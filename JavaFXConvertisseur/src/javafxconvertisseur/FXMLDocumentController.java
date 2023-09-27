/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxconvertisseur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

/**
 *
 * @author francois.desaintpala
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private RadioButton convertToEuro;
    @FXML private RadioButton convertToDollars;
    
    @FXML private Text indicationDeConvertion;
    

    @FXML private TextField sortieConverti;
    @FXML private TextField entrerAConvertir;
    
    @FXML private ToggleGroup selectionDevise;
    
    private static final float EURO_TO_DOLLARS = 1.1703f;
    
    private static final Alert ENTREE_VIDE = new Alert(Alert.AlertType.ERROR, "Veuillez saisir un entier", ButtonType.OK);
    private static final Alert CONVERTION_NON_SELECTIONNER = 
            new Alert(Alert.AlertType.ERROR, "Veuillez selectionner la devise de départ", ButtonType.OK);

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //indicationDeConvertion.setText("");
    }
    
    @FXML
    public void convertir() {
        if (entrerAConvertir.getText().matches("^[a-zA-Z]+$")) {
            ENTREE_VIDE.showAndWait();
        } else if (!convertToDollars.isSelected() && !convertToEuro.isSelected()) {
            CONVERTION_NON_SELECTIONNER.showAndWait();
        } else {
            float aConvertir = Float.parseFloat(entrerAConvertir.getText());
            if (convertToEuro.isSelected()) {
                sortieConverti.setText(aConvertir * EURO_TO_DOLLARS + "");
            } else if (convertToDollars.isSelected())  {
                sortieConverti.setText(aConvertir / EURO_TO_DOLLARS + "");
            }
        }
    }
    
}
