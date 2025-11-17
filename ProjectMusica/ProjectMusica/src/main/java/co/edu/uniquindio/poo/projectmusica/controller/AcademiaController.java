
package co.edu.uniquindio.poo.projectmusica.controller;
import co.edu.uniquindio.poo.projectmusica.App;
import co.edu.uniquindio.poo.projectmusica.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class AcademiaController {

    private final Academia academia;

    public AcademiaController(Academia academia) {
        this.academia = academia;
    }

    public Academia getAcademia() {
        return academia;
    }

}