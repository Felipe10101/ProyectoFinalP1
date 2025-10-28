package co.edu.uniquindio.poo.projectmusica.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MatriculaViewController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}