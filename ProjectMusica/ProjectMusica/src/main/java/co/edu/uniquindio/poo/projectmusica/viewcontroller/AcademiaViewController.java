package co.edu.uniquindio.poo.projectmusica.viewcontroller;

import co.edu.uniquindio.poo.projectmusica.controller.AcademiaController;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class AcademiaViewController {

    private final AcademiaController controller = new AcademiaController();

    @FXML
    private void ingresarEstudiante() {
        controller.abrirVistaEstudiante();
    }

    @FXML
    private void ingresarProfesor() {
        controller.abrirVistaProfesor();
    }

    @FXML
    private void ingresarAdmin() {
        controller.abrirVistaAdmin();
    }
}