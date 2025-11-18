package co.edu.uniquindio.poo.projectmusica.controller;

import co.edu.uniquindio.poo.projectmusica.App;
import co.edu.uniquindio.poo.projectmusica.model.Estudiante;
import co.edu.uniquindio.poo.projectmusica.model.Academia;

import java.util.LinkedList;

public class CrudEstudianteController {

    private final Academia academia;

    public CrudEstudianteController() {
        this.academia = App.academia;
    }

    public LinkedList<Estudiante> obtenerEstudiantes() {
        return academia.getListEstudiantes();
    }

    public boolean crearEstudiante(String id, String nombre, String telefono, int edad) {
        Estudiante e = new Estudiante(nombre, id, telefono, edad);
        return academia.agregarEstudiante(e);
    }

    public boolean actualizarEstudiante(String id, String nombre, String telefono, int edad) {
        Estudiante nuevo = new Estudiante(nombre, id, telefono, edad);
        return academia.actualizarEstudiante(id, nuevo);
    }

    public boolean eliminarEstudiante(String id) {
        return academia.eliminarEstudiante(id);
    }
}