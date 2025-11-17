
package co.edu.uniquindio.poo.projectmusica.controller;
import co.edu.uniquindio.poo.projectmusica.App;
import co.edu.uniquindio.poo.projectmusica.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class AcademiaController {

    public void abrirVistaEstudiante() {
        App.setRoot("Estudiante");
    }

    public void abrirVistaProfesor() {
        App.setRoot("Profesor");
    }

    public void abrirVistaAdmin() {
        App.setRoot("AdministradorAcademico");
    }
}