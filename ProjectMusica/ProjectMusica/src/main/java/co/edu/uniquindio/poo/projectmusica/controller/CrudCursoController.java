package co.edu.uniquindio.poo.projectmusica.controller;

import co.edu.uniquindio.poo.projectmusica.App;
import co.edu.uniquindio.poo.projectmusica.model.*;

import java.util.LinkedList;

public class CrudCursoController {

    private final Academia academia;

    public CrudCursoController() {
        this.academia = App.academia;
    }

    public LinkedList<Curso> obtenerCursos() {
        return academia.getListCursos();
    }


    public Curso crearCurso(String nombreCurso, Horario horario, Nivel nivel,
                            TipoClase tipoClase, int cupo, String tipoInstrumento) {

        return switch (tipoInstrumento) {
            case "Piano" -> academia.crearCursoPiano(nombreCurso, horario, nivel, tipoClase, cupo,
                    "Acústico", "Yamaha", true);
            case "Guitarra" -> academia.crearCursoGuitarra(nombreCurso, horario, nivel, tipoClase, cupo,
                    "Estándar", "Nylon", 6);
            case "Canto" -> academia.crearCursoCanto(nombreCurso, horario, nivel, tipoClase, cupo,
                    "Tenor", "Lírico");
            case "Violin" -> academia.crearCursoViolin(nombreCurso, horario, nivel, tipoClase, cupo,
                    "4/4", "Obe", "Detache");
            default -> throw new IllegalArgumentException("Tipo curso inválido: " + tipoInstrumento);
        };
    }


    public boolean actualizarCurso(String nombreCurso, Horario nuevoHorario, Nivel nuevoNivel) {
        Curso curso = academia.obtenerCurso(nombreCurso);
        if (curso == null) {
            System.out.println("Error: curso no existe: " + nombreCurso);
            return false;
        }
        curso.setHorario(nuevoHorario);
        curso.setNivel(nuevoNivel);

        return true;
    }

    public boolean eliminarCurso(String nombreCurso) {
        return academia.eliminarCurso(nombreCurso);
    }

    public Curso obtenerCursoPorNombre(String nombreCurso) {
        return academia.obtenerCurso(nombreCurso);
    }
}