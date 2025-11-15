package co.edu.uniquindio.poo.projectmusica.controller;
import co.edu.uniquindio.poo.projectmusica.App;
import co.edu.uniquindio.poo.projectmusica.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class AcademiaController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void abrirVistaEstudiante() {
        App.setRoot("vistaEstudiante");
    }

    public void abrirVistaProfesor() {
        App.setRoot("vistaProfesor");
    }

    public void abrirVistaAdmin() {
        App.setRoot("vistaAdministrador");
    }
}