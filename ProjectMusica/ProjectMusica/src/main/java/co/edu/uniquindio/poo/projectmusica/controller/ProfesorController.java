package co.edu.uniquindio.poo.projectmusica.controller;
import javafx.fxml.FXML;
import co.edu.uniquindio.poo.projectmusica.model.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert;
import java.time.LocalDate;

public class ProfesorController {

        @FXML
        private TextArea txtReporteProgreso;

        @FXML
        private TextField txtComentario;

        @FXML
        private TextField txtNota;

        @FXML
        private DatePicker dpFecha;

        private String nombre = "Profesor";

        public String crearComentario(String comentario, double nota, LocalDate fecha, Curso curso) {
            ReporteProgreso reporte = new ReporteProgreso(comentario, nota, fecha);

            StringBuilder sb = new StringBuilder();
            sb.append("Reporte de Progreso\n");
            sb.append("------------------------------\n");
            sb.append("Profesor: ").append(nombre).append("\n");
            sb.append("Curso: ").append(curso.getnombreCurso()).append("\n");
            sb.append("Nivel: ").append(curso.getNivel()).append("\n");
            sb.append("Tipo de clase: ").append(curso.getTipoClase()).append("\n");
            sb.append("Comentario: ").append(comentario).append("\n");
            sb.append("Nota: ").append(nota).append("\n");
            sb.append("Fecha: ").append(fecha).append("\n");

            if (curso instanceof Piano piano) {
                sb.append(" Tipo de piano: ").append(piano.getTipoPiano()).append("\n");
                sb.append("Marca: ").append(piano.getMarca()).append("\n");
                sb.append("¿Requiere pedales?: ").append(piano.isRequierePedales() ? "Sí" : "No").append("\n");
            } else if (curso instanceof Guitarra guitarra) {
                sb.append(" Tipo de cuerda: ").append(guitarra.getTipoCuerda()).append("\n");
                sb.append("Afinación: ").append(guitarra.getAfinacion()).append("\n");
                sb.append("Número de cuerdas: ").append(guitarra.getCuerdas()).append("\n");
            } else if (curso instanceof Violin violin) {
                sb.append(" Tamaño: ").append(violin.getTamanio()).append("\n");
                sb.append("Arco: ").append(violin.getArco()).append("\n");
                sb.append("Técnica: ").append(violin.getTecnica()).append("\n");
            } else if (curso instanceof Canto canto) {
                sb.append("Tipo de voz: ").append(canto.getTipoVoz()).append("\n");
                sb.append("Género musical: ").append(canto.getGeneroMusical()).append("\n");
            }

            sb.append("------------------------------\n");

            txtReporteProgreso.setText(sb.toString());
            return comentario;
        }

        @FXML
        private void onCrearComentario() {
            try {
                String comentario = txtComentario.getText();
                double nota = Double.parseDouble(txtNota.getText());
                LocalDate fecha = dpFecha.getValue();


                Curso curso = new Piano("Piano Básico", "Inicial", "Individual", "Acústico", "Yamaha", true);

                crearComentario(comentario, nota, fecha, curso);

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error al crear comentario");
                alert.setHeaderText("Revisa los datos ingresados");
                alert.setContentText("Asegúrate de llenar todos los campos correctamente.\n\n" + e.getMessage());
                alert.showAndWait();
            }
        }
    }

}

