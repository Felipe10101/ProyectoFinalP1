package co.edu.uniquindio.poo.projectmusica.controller;

import co.edu.uniquindio.poo.projectmusica.App;
import co.edu.uniquindio.poo.projectmusica.model.*;

import java.util.LinkedList;

public class EstudianteController {

    private Academia academia;

    public EstudianteController() {
        academia = App.academia;
    }

    public LinkedList<Curso> obtenerCursosDisponibles() {
        return academia.getListCursos();
    }

    public LinkedList<Curso> obtenerCursosEstudiante(Estudiante est) {
        return est.getCursosInscritos();
    }

    public boolean inscribir(Estudiante estudiante, Curso curso) {
        estudiante.setAcademia(academia);
        return estudiante.inscripcionCurso(curso) != null;
    }

    public boolean cancelar(Estudiante estudiante, Curso curso) {
        estudiante.cancelacionCurso(curso);
        return true;
    }

    public String consultarHorario(Estudiante est) {
        StringBuilder sb = new StringBuilder();

        if (est.getCursosInscritos().isEmpty()) {
            return "El estudiante no tiene cursos inscritos.";
        }

        sb.append("=== HORARIO ===\n\n");
        for (Curso c : est.getCursosInscritos()) {
            sb.append(c.getNombreCurso())
                    .append("  |  ")
                    .append(c.getHorario())
                    .append("\n");
        }
        return sb.toString();
    }
}