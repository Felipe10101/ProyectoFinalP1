package co.edu.uniquindio.poo.projectmusica.model;

import java.time.LocalDate;
import java.util.LinkedList;

public interface IEvaluable {
    boolean registrarProgreso(Curso curso, String descripcion, double nota);
    LinkedList<ReporteProgreso> consultarProgreso(Curso curso);
    String crearComentario(String comentario, double nota, LocalDate fecha, Curso curso);
    boolean registrarAsistencia(Curso curso, Estudiante estudiante, boolean presente, Profesor profesor);
    boolean valorarProgreso(Curso curso, Estudiante estudiante, double notaFinal, String mensaje);
}

