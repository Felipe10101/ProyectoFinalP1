package co.edu.uniquindio.poo.projectmusica.viewcontroller;

import co.edu.uniquindio.poo.projectmusica.controller.ProfesorController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import co.edu.uniquindio.poo.projectmusica.App;
import co.edu.uniquindio.poo.projectmusica.controller.CrudProfesorController;
import co.edu.uniquindio.poo.projectmusica.model.Academia;
import co.edu.uniquindio.poo.projectmusica.model.Profesor;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.*;

public class crudProfesorViewController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtId;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtEdad;

    @FXML private TableView<Profesor> tablaProfesores;
    @FXML private TableColumn<Profesor, String> colNombre;
    @FXML private TableColumn<Profesor, String> colId;
    @FXML private TableColumn<Profesor, String> colTelefono;
    @FXML private TableColumn<Profesor, Integer> colEdad;

    private CrudProfesorController crudProfesorController;

    @FXML
    public void initialize() {
        Academia academia = AcademiaSingleton.getInstance().getAcademia();
        crudProfesorController = new CrudProfesorController(academia);

        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        colId.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));
        colTelefono.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTelefono()));
        colEdad.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getEdad()).asObject());

        cargarTabla();
    }

    private void cargarTabla() {
        tablaProfesores.setItems(crudProfesorController.obtenerProfesores());
    }

    @FXML
    private void crearProfesor() {
        crudProfesorController.crearProfesor(
                txtNombre.getText(),
                txtId.getText(),
                txtTelefono.getText(),
                Integer.parseInt(txtEdad.getText())
        );
        cargarTabla();
        limpiar();
    }

    @FXML
    private void actualizarProfesor() {
        crudProfesorController.actualizarProfesor(
                txtId.getText(),
                txtNombre.getText(),
                txtTelefono.getText(),
                Integer.parseInt(txtEdad.getText())
        );
        cargarTabla();
    }

    @FXML
    private void eliminarProfesor() {
        crudProfesorController.eliminarProfesor(txtId.getText());
        cargarTabla();
        limpiar();
    }

    private void limpiar() {
        txtNombre.clear();
        txtId.clear();
        txtTelefono.clear();
        txtEdad.clear();
    }
}

