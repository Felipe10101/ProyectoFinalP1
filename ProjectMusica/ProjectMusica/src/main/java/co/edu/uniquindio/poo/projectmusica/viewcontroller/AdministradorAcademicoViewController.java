package co.edu.uniquindio.poo.projectmusica.viewcontroller;

import co.edu.uniquindio.poo.projectmusica.App;
import javafx.fxml.FXML;
import co.edu.uniquindio.poo.projectmusica.controller.AdministradorAcademicoController;
import javafx.scene.control.Button;

public class AdministradorAcademicoViewController {

    private final AdministradorAcademicoController controller;

    @FXML
    private Button btnAulas;
    @FXML
    private Button btnProfesores;
    @FXML
    private Button btnEstudiantes;
    @FXML
    private Button btnCursos;
    @FXML
    private Button btnSalir;

    public AdministradorAcademicoViewController() {
        controller = new AdministradorAcademicoController();
    }

    @FXML
    public void initialize() {

    }

    @FXML
    private void abrirVistaAulas() {
        App.setRoot("crudAula");
    }

    @FXML
    private void abrirVistaProfesores() {
        App.setRoot("crudProfesor");
    }

    @FXML
    private void abrirVistaEstudiantes() {
        App.setRoot("crudEstudiante");
    }

    @FXML
    private void abrirVistaCursos() {
        App.setRoot("crudCurso");
    }

    @FXML
    private void salir() {
        App.setRoot("Academia");
    }
}