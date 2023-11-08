/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihms;

import gestion_notes.Enseignant;
import gestion_notes.Etudiant;
import gestion_notes.GestionNotes;
import gestion_notes.Matiere;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 * @author François de Saint Palais
 */
public class IhmEnseignantController implements Initializable {

    private Enseignant enseignant; // Enseignant connecté

    @FXML private TextField txtNote;
    @FXML private ComboBox<String> comboMatiere;
    @FXML private ComboBox<String> comboEtudiant;

    void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
        // Remplir la liste comboMatieres avec les matières enseignées
        //** REMARQUE : ceci ne peut pas être fait dans la méthode initialize(url,rb) car
        //** cette méthode est appelée dès la création d'une instance du contrôleur par 
        //** le FXMLLoader
        Matiere[] matieresEnseignant = enseignant.getMatieresEnseignees();
        ArrayList<String> nomsMatieres = new ArrayList();
        for (Matiere m : matieresEnseignant) {
            nomsMatieres.add(m.getIntitule());
        }
        comboMatiere.getItems().setAll(nomsMatieres);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void btnModifierNoteAction(ActionEvent event) {
        if (comboMatiere.getValue() == null || comboEtudiant.getValue() == null) {
            Popup.afficherInfo("Sélectioner une matière et un étudiant !");
        } else {
            // Modifier la note de l'étudiant sélectionné dans la matière sélectionnée en la remplaçant par
            // la note saisie dans la zone txtNote
            // 1. Récupérer la matière sélectionnée et l'étudiant sélectionné
            int i = comboMatiere.getItems().indexOf(comboMatiere.getValue());
            Matiere m = enseignant.getMatieresEnseignees()[i];
            int j = comboEtudiant.getItems().indexOf(comboEtudiant.getValue());
            Etudiant e = m.getEtudiantsInscrits()[j];
            // 2. Modifier la note si elle est correctement saisie
            if (txtNote.getText().isEmpty()) {
                Popup.afficherInfo("Note non saisie !");
            } else {
                try {
                    Float note = Float.parseFloat(txtNote.getText());
                    if (note >= 0 && note <= 20) {
                        e.modifierNote(m.getIntitule(), note);
                    } else {
                        Popup.afficherInfo("Note mal saisie !");
                    }
                } catch (NumberFormatException ex) {
                    Popup.afficherInfo("Note mal saisie !");
                }
            }
        }
    }

    @FXML
    private void btnQuitter(ActionEvent event) {
        // Enregistrer les données et lever le verrou sur les données 
        // avant de quitter l'application
        try {
            GestionNotes.enregistrerDonnees();
            GestionNotes.deVerrouillerDonnees();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Erreur lors du déverrouillage des données !");
        }
    }

    @FXML
    private void comboMatiereAction(ActionEvent event) {
        // Rechercher les étudiants inscrits à la matière sélectionnée et les afficher dans
        // la liste comboEtudiants
        comboEtudiant.getItems().clear();
        // 1. Récupérer la matière sélectionnée
        int i = comboMatiere.getItems().indexOf(comboMatiere.getValue());
        Matiere m = enseignant.getMatieresEnseignees()[i];
        // 2. Afficher les noms et prénoms des étudiants inscrits dans cette matière
        for (Etudiant e : m.getEtudiantsInscrits()) {
            comboEtudiant.getItems().add(e.getNom() + " " + e.getPrenom());
        }
        // 3. Effacer la note affichée précdemment
        txtNote.setText("");
    }

    @FXML
    private void comboEtudiantAction(ActionEvent event) {
        // Rechercher la note de l'étudiant sélectionné pour la matière sélectionnée
        // et l'afficher dans la zone txtNote
        if (comboEtudiant.getValue() != null) { // Si un étudiant est sélectionné
            // 1. Récupérer la matière sélectionnée et l'étudiant sélectionné
            int i = comboMatiere.getItems().indexOf(comboMatiere.getValue());
            Matiere m = enseignant.getMatieresEnseignees()[i];
            int j = comboEtudiant.getItems().indexOf(comboEtudiant.getValue());
            Etudiant e = m.getEtudiantsInscrits()[j];
            // 2. Afficher sa note ou "" si absence de note (indiquée par -1)
            if (e.note(m.getIntitule()) == -1) {
                txtNote.setText("");
            } else {
                txtNote.setText("" + e.note(m.getIntitule()));
            }
        }
    }

}
