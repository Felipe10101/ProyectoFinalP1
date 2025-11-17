package co.edu.uniquindio.poo.projectmusica.viewcontroller;

import co.edu.uniquindio.poo.projectmusica.controller.AcademiaController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import co.edu.uniquindio.poo.projectmusica.App;

public class AcademiaViewController {

    @FXML
    private void ingresarEstudiante() {
        App.setRoot("Estudiante");
    }

    @FXML
    private void ingresarProfesor() {
        App.setRoot("Profesor");
    }

    @FXML
    private void ingresarAdmin() {
        App.setRoot("AdministradorAcademico");
    }
}