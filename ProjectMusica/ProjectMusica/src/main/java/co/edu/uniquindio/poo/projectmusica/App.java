package co.edu.uniquindio.poo.projectmusica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("Academia"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String name) {
        scene.setRoot(loadFXML(name));
    }

    private static Parent loadFXML(String name) {
        try {
            return FXMLLoader.load(App.class.getResource("/co/edu/uniquindio/poo/projectmusica/" + name + ".fxml"));
        } catch (Exception e) {
            System.out.println("ERROR CARGANDO FXML: " + name);
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}