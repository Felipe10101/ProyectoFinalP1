package co.edu.uniquindio.poo.projectmusica.viewcontroller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProfesorViewController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}