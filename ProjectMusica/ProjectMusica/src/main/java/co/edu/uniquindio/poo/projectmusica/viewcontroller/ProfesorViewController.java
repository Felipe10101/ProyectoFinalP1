package co.edu.uniquindio.poo.projectmusica.viewcontroller;
import co.edu.uniquindio.poo.projectmusica.controller.ProfesorController;
import co.edu.uniquindio.poo.projectmusica.model.*;
import co.edu.uniquindio.poo.projectmusica.model.Profesor;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;



public class ProfesorViewController {

    @FXML
    private ComboBox<Curso> cbCursos;

    @FXML
    private TextField txtComentario;

    @FXML
    private TextField txtNota;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private TextArea txtReporteProgreso;

    private ProfesorController profesorController;

    public void initialize() {

        Profesor profesor = new Profesor("Juan Pérez", "123", "3110000000", 40);

        profesorController = new ProfesorController(profesor);

        cbCursos.getItems().addAll(

                new Piano(
                        "Piano Básico",
                        Horario.TARDE,
                        Nivel.BASICO,
                        TipoClase.INDIVIDUAL,
                        10,
                        "Acústico",
                        "Yamaha",
                        true
                ),

                new Guitarra(
                        "Guitarra Eléctrica",
                        Horario.NOCHE,
                        Nivel.MEDIO,
                        TipoClase.GRUPAL,
                        8,
                        "Estándar",
                        "Acero",
                        6
                ),

                new Violin(
                        "Violín Intermedio",
                        Horario.MANIANA,
                        Nivel.MEDIO,
                        TipoClase.INDIVIDUAL,
                        6,
                        "4/4",
                        "Pernambuco",
                        "Arco clásico"
                ),

                new Canto(
                        "Canto Lírico",
                        Horario.MEDIATARDE,
                        Nivel.PRINCIPIANTE,
                        TipoClase.GRUPAL,
                        12,
                        "Soprano",
                        "Ópera"
                )
        );
    }


    @FXML
    private void onCrearComentario() {
        try {
            Curso curso = cbCursos.getValue();
            String comentario = txtComentario.getText();
            double nota = Double.parseDouble(txtNota.getText());
            LocalDate fecha = dpFecha.getValue();

            ReporteProgreso reporte = profesorController.crearReporteProgreso(
                    curso, comentario, nota, fecha
            );

            txtReporteProgreso.setText(
                    "=== REPORTE GUARDADO ===\n" +
                            "Curso: " + curso.getNombreCurso() + "\n" +
                            "Nivel: " + curso.getNivel() + "\n" +
                            "Comentario: " + comentario + "\n" +
                            "Nota: " + nota + "\n" +
                            "Fecha: " + fecha + "\n" +
                            "---------------------------\n" +
                            "Reportes totales: " + curso.getListReportes().size()
            );

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}