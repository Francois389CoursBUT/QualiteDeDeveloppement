package ihms;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Affiche une popup avec un message
 * @author François de Saint Palais
 */
public class Popup {

    public static void afficherInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.NO);
        alert.showAndWait();
    }
    
    public static void afficherErreur(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }
    
    public static void afficherConfirmation(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.OK);
        alert.showAndWait();
    }
    
    
}
