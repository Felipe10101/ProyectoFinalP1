package co.edu.uniquindio.poo.projectmusica.controller;
import co.edu.uniquindio.poo.projectmusica.model.Academia;
import co.edu.uniquindio.poo.projectmusica.model.Profesor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CrudProfesorController {

    private final Academia academia;

    public CrudProfesorController(Academia academia) {
        this.academia = academia;
    }

    public boolean crearProfesor(String nombre, String id, String telefono, int edad) {
        Profesor nuevo = new Profesor(nombre, id, telefono, edad);
        nuevo.setAcademia(academia);
        return academia.agregarProfesor(nuevo);
    }

    public boolean actualizarProfesor(String idOriginal, String nombre, String telefono, int edad) {
        Profesor actualizado = new Profesor(nombre, idOriginal, telefono, edad);
        return academia.actualizarProfesor(idOriginal, actualizado);
    }

    public boolean eliminarProfesor(String id) {
        return academia.eliminarProfesor(id);
    }

    public ObservableList<Profesor> obtenerProfesores() {
        return FXCollections.observableArrayList(academia.getListProfesores());
    }
}
