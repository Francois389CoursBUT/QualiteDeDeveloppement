/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihms;

import gestion_notes.Enseignant;
import gestion_notes.Etudiant;
import gestion_notes.GestionNotes;
import gestion_notes.IdentificationException;
import gestion_notes.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class IhmGestionNotesController implements Initializable {

    private Stage fenetreAppli;

    public void setFenetreAppli(Stage fenetreAppli) {
        this.fenetreAppli = fenetreAppli; // Fenêtre (vue) IhmGestionNotes
    }

    @FXML private TextField txtIdentifiant;
    @FXML private TextField txtMotDePasse;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialisation des données 
        try {
            // 1. Attendre si nécessaire que les données ne soient plus verrouillées
            if (GestionNotes.verrouDonneesFerme()) {
                System.out.println("Application en cours d'utilisation. Attendez...");
                while (GestionNotes.verrouDonneesFerme());
            }
            // 2. Le verrouillage étant levé, verrouiller et charger les données
            GestionNotes.verrouillerDonnees();
            GestionNotes.initialiserDonnees();
            System.out.println("Application démarrée !");
        } catch (Exception e) {
            System.out.println("Erreur de lancement " + e);
        }
    }

    @FXML
    private void btnSeConnecterAction(ActionEvent event) throws Exception {
        String identifiant = txtIdentifiant.getText();
        String motDePasse = txtMotDePasse.getText();
        if (identifiant.equals("") || motDePasse.equals("")) {
            Popup.afficherInfo("Identifiant ou mot de passe non saisi(s) ! ");
        } else {
            try {
                Utilisateur utilisateur = GestionNotes.connecter(identifiant, motDePasse);
                // Connexion réussie : remplacer la vue de l'IhmGestionNotes par la vue de l'IhmEnseignant
                // ou l'IhmEtudiant selon le type d'utilisateur
                FXMLLoader loader;
                if (utilisateur instanceof Enseignant) {
                    loader = new FXMLLoader(getClass().getResource("ihmEnseignant.fxml"));
                    Parent vueIhmEnseignant = loader.load();
                    IhmEnseignantController controleur = loader.getController();
                    controleur.setEnseignant((Enseignant) utilisateur);
                    fenetreAppli.setScene(new Scene(vueIhmEnseignant));
                } else if (utilisateur instanceof Etudiant) {
                    loader = new FXMLLoader(getClass().getResource("ihmEtudiant.fxml"));
                    Parent vueIhmEtudiant = loader.load();
                    IhmEtudiantController controleur = loader.getController();
                    controleur.setEtudiant((Etudiant) utilisateur);
                    fenetreAppli.setScene(new Scene(vueIhmEtudiant));
                } else {
                    // Normalement, cela ne se produira jamais
                    System.out.println("Type d'utilisateur non identifié ! Application arrêtée.");
                    System.exit(0);
                }
            } catch (IdentificationException e) {
                Popup.afficherInfo("Identifiant ou mot de passe incorrect(s) !");
            }
        }
    }

    @FXML
    private void btnQuitterAction(ActionEvent event) {
        // Lever le verrou sur les données avant de quitter l'application
        try {
            GestionNotes.deVerrouillerDonnees();
            fenetreAppli.hide();
            System.out.println("Application arrêtée !");
        } catch (IOException e) {
            System.out.println("Erreur lors du déverrouillage des données !");
        }
    }
}
