package co.edu.uniquindio.poo.projectmusica.viewcontroller;

import co.edu.uniquindio.poo.projectmusica.App;
import co.edu.uniquindio.poo.projectmusica.controller.EstudianteController;
import co.edu.uniquindio.poo.projectmusica.model.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EstudianteViewController {

    @FXML private ComboBox<Curso> cbCursos;
    @FXML private ComboBox<Curso> cbMisCursos;
    @FXML private TextArea txtSalida;

    private EstudianteController controller;
    private Estudiante estudiante;

    @FXML
    public void initialize() {
        controller = new EstudianteController();


        estudiante = App.estudianteActual;
        if(estudiante == null){
            estudiante = new Estudiante("Estudiante Demo","111","0000",20);
            estudiante.setAcademia(App.academia);
        }

        cargarCursos();
    }

    private void cargarCursos() {
        cbCursos.getItems().setAll(controller.obtenerCursosDisponibles());
        cbMisCursos.getItems().setAll(controller.obtenerCursosEstudiante(estudiante));
    }

    @FXML
    private void onInscribirse() {
        Curso c = cbCursos.getValue();
        if (c == null) {
            txtSalida.setText("Seleccione un curso.");
            return;
        }

        boolean ok = controller.inscribir(estudiante, c);
        txtSalida.setText(ok ? "Inscrito correctamente." : "No se pudo inscribir.");

        cargarCursos();
    }

    @FXML
    private void onCancelarCurso() {
        Curso c = cbMisCursos.getValue();
        if (c == null) {
            txtSalida.setText("Seleccione un curso a cancelar.");
            return;
        }

        controller.cancelar(estudiante, c);
        txtSalida.setText("Curso cancelado.");
        cargarCursos();
    }

    @FXML
    private void onConsultarHorario() {
        txtSalida.setText(controller.consultarHorario(estudiante));
    }
}