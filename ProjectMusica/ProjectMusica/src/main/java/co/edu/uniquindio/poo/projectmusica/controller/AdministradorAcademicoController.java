package co.edu.uniquindio.poo.projectmusica.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import co.edu.uniquindio.poo.projectmusica.model.*;
import java.util.List;


public class AdministradorAcademicoController {

    private final Academia academia;

    public AdministradorAcademicoController(Academia academia) {
        this.academia = academia;
    }


    public Academia getAcademia() {
        return academia;
    }
}
