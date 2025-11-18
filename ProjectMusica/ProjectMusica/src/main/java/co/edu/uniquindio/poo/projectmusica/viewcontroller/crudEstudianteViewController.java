package co.edu.uniquindio.poo.projectmusica.viewcontroller;

import co.edu.uniquindio.poo.projectmusica.controller.CrudEstudianteController;
import co.edu.uniquindio.poo.projectmusica.model.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class crudEstudianteViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtEdad;
    @FXML private TableView<Estudiante> tablaEstudiantes;
    @FXML private TableColumn<Estudiante, String> colId;
    @FXML private TableColumn<Estudiante, String> colNombre;
    @FXML private TableColumn<Estudiante, String> colTelefono;
    @FXML private TableColumn<Estudiante, Integer> colEdad;

    private final CrudEstudianteController controller = new CrudEstudianteController();
    private final ObservableList<Estudiante> lista = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getId()));
        colNombre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        colTelefono.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTelefono()));
        colEdad.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getEdad()).asObject());

        actualizarTabla();
    }

    private void actualizarTabla() {
        lista.setAll(controller.obtenerEstudiantes());
        tablaEstudiantes.setItems(lista);
    }

    @FXML
    private void crearEstudiante() {
        controller.crearEstudiante(
                txtId.getText(),
                txtNombre.getText(),
                txtTelefono.getText(),
                Integer.parseInt(txtEdad.getText())
        );
        actualizarTabla();
    }

    @FXML
    private void actualizarEstudiante() {
        controller.actualizarEstudiante(
                txtId.getText(),
                txtNombre.getText(),
                txtTelefono.getText(),
                Integer.parseInt(txtEdad.getText())
        );
        actualizarTabla();
    }

    @FXML
    private void eliminarEstudiante() {
        controller.eliminarEstudiante(txtId.getText());
        actualizarTabla();
    }

    @FXML
    private void seleccionarEstudiante() {
        Estudiante e = tablaEstudiantes.getSelectionModel().getSelectedItem();
        if (e != null) {
            txtId.setText(e.getId());
            txtNombre.setText(e.getNombre());
            txtTelefono.setText(e.getTelefono());
            txtEdad.setText(String.valueOf(e.getEdad()));
        }
    }
}