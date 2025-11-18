package co.edu.uniquindio.poo.projectmusica.controller;
import javafx.fxml.FXML;
import co.edu.uniquindio.poo.projectmusica.model.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert;
import java.time.LocalDate;
import java.util.LinkedList;

public class ProfesorController {

    private Profesor profesorActivo;

    public ProfesorController(Profesor profesor) {
        this.profesorActivo = profesor;
    }

    public ReporteProgreso crearReporteProgreso(
            Curso curso,
            String comentario,
            double nota,
            LocalDate fecha
    ) {
        if (curso == null)
            throw new IllegalArgumentException("Debe seleccionar un curso.");

        if (comentario == null || comentario.isBlank())
            throw new IllegalArgumentException("El comentario no puede estar vacío.");

        if (nota < 0 || nota > 5)
            throw new IllegalArgumentException("La nota debe estar entre 0 y 5.");

        if (fecha == null)
            throw new IllegalArgumentException("La fecha no puede ser nula.");

        ReporteProgreso reporte = new ReporteProgreso(comentario, nota, fecha);
        curso.getListReportes().add(reporte);

        return reporte;
    }
}