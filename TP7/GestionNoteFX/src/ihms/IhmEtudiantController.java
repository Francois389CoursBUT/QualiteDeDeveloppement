/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihms;

import gestion_notes.Etudiant;
import gestion_notes.GestionNotes;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class IhmEtudiantController implements Initializable {

    private Etudiant etudiant; // Etudiant connecté

    @FXML private TextArea txtNotes;
    @FXML private Text txtEtudiant;

    void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
        // Préciser dans labelNotes les nom et prénoms de l'étudiant
        // et Remplir la zone txtNotesEtudiant avec ses notes
        txtEtudiant.setText("Notes de " + etudiant.getNom() + " " + etudiant.getPrenom());
        txtNotes.setText(etudiant.notesToString());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Popup.afficherConfirmation("Bienvenue");
    }

    @FXML
    private void btnQuitterAction(ActionEvent event) {
        // Lever le verrou sur les données avant de quitter l'application
        try {
            GestionNotes.deVerrouillerDonnees();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Erreur lors du déverrouillage des données !");
        }
    }

}
