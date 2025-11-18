package co.edu.uniquindio.poo.projectmusica;

import co.edu.uniquindio.poo.projectmusica.model.Academia;
import co.edu.uniquindio.poo.projectmusica.model.Estudiante;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static Academia academia;
    public static Estudiante estudianteActual;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {

        // Inicializar academia una sola vez
        academia = new Academia("UQ Música", "001");

        // Simular estudiante logeado (si quieres)
        estudianteActual = new Estudiante("Juan", "01", "123", 20);

        // Cargar vista principal
        scene = new Scene(loadFXML("Academia"));
        stage.setScene(scene);
        stage.setTitle("Academia UQ Música");
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