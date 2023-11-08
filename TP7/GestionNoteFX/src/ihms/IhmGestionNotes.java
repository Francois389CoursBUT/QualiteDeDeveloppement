package ihms;

import gestion_notes.GestionNotes;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class IhmGestionNotes extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ihmGestionNotes.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        IhmGestionNotesController controleur = loader.getController();
        controleur.setFenetreAppli(stage);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        // Action si fermeture fenêtre
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent evt) {
                // Enregistrer les données et lever le verrou sur les données 
                // avant de quitter l'application
                try {
                    GestionNotes.enregistrerDonnees();
                    GestionNotes.deVerrouillerDonnees();
                    System.out.println("Application arrêtée !");
                } catch (IOException e) {
                    System.out.println("Erreur lors du déverrouillage ou d'enregistrement des données !");
                }
            }

        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
