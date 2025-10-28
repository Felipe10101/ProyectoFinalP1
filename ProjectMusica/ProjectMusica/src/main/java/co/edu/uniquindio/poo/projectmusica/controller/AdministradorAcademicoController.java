AcademiaController.javaAcademiaController.javapackage co.edu.uniquindio.poo.projectmusica.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class  AdministradorAcademicoController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}