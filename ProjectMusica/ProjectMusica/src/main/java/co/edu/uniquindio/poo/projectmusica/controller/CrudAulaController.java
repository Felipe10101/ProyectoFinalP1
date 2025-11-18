package co.edu.uniquindio.poo.projectmusica.controller;

import co.edu.uniquindio.poo.projectmusica.App;
import co.edu.uniquindio.poo.projectmusica.model.Aula;

import java.util.LinkedList;

public class CrudAulaController {

    public LinkedList<Aula> obtenerAulas() {
        return App.academia.getListAulas();
    }

    public boolean crearAula(String nombre, int capacidad, Double estado) {
        return App.academia.crearAula(nombre, capacidad, estado);
    }

    public boolean actualizarAula(String nombre, int capacidad, Double estado) {
        return App.academia.actualizarAula(nombre, capacidad, estado);
    }

    public boolean eliminarAula(String nombre) {
        return App.academia.eliminarAula(nombre);
    }
}
