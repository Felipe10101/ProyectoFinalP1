package co.edu.uniquindio.poo.projectmusica.viewcontroller;
import co.edu.uniquindio.poo.projectmusica.controller.ProfesorController;
import co.edu.uniquindio.poo.projectmusica.model.Curso;
import co.edu.uniquindio.poo.projectmusica.model.Piano;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class ProfesorViewController {
    @FXML
    private TextArea txtReporteProgreso;

    @FXML
    private TextField txtComentario;

    @FXML
    private TextField txtNota;

    @FXML
    private DatePicker dpFecha;

    private final ProfesorController profesorController = new ProfesorController();

    @FXML
    private void onCrearComentario() {
        try {
            String comentario = txtComentario.getText();
            double nota = Double.parseDouble(txtNota.getText());
            LocalDate fecha = dpFecha.getValue();

            // Esto debería venir desde selección del usuario en tu proyecto real
            Curso curso = new Piano("Piano Básico", "Inicial", "Individual",
                    "Acústico", "Yamaha", true);

            String reporte = profesorController.crearComentario(comentario, nota, fecha, curso);

            txtReporteProgreso.setText(reporte);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al crear comentario");
            alert.setHeaderText("Datos incorrectos");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}

