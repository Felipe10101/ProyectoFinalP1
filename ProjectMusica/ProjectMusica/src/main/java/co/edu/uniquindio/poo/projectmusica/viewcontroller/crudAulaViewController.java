package co.edu.uniquindio.poo.projectmusica.viewcontroller;

import co.edu.uniquindio.poo.projectmusica.App;
import co.edu.uniquindio.poo.projectmusica.controller.CrudAulaController;
import co.edu.uniquindio.poo.projectmusica.model.Aula;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class crudAulaViewController {

    @FXML private TableView<Aula> tablaAulas;
    @FXML private TableColumn<Aula, String> colNombre;
    @FXML private TableColumn<Aula, Integer> colCapacidad;
    @FXML private TableColumn<Aula, Double> colEstado;

    @FXML private TextField txtNombre;
    @FXML private TextField txtCapacidad;
    @FXML private TextField txtEstado;

    @FXML private Button btnCrear;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;
    @FXML private Button btnVolver;

    private CrudAulaController controller;
    private ObservableList<Aula> obsAulas = FXCollections.observableArrayList();

    public crudAulaViewController() {
        controller = new CrudAulaController();
    }

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().nombre()));
        colCapacidad.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().capacidad()).asObject());
        colEstado.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().estado()).asObject());

        tablaAulas.setItems(obsAulas);
        refrescarTabla();

        tablaAulas.setOnMouseClicked(event -> {
            Aula a = tablaAulas.getSelectionModel().getSelectedItem();
            if(a != null){
                txtNombre.setText(a.nombre());
                txtCapacidad.setText(String.valueOf(a.capacidad()));
                txtEstado.setText(String.valueOf(a.estado()));
            }
        });
    }

    private void refrescarTabla() {
        obsAulas.setAll(controller.obtenerAulas());
    }

    @FXML
    private void crearAula() {
        try {
            String nombre = txtNombre.getText().trim();
            int capacidad = Integer.parseInt(txtCapacidad.getText().trim());
            Double estado = Double.parseDouble(txtEstado.getText().trim());

            if(controller.crearAula(nombre, capacidad, estado)) {
                alerta("Aula creada correctamente", Alert.AlertType.INFORMATION);
                refrescarTabla();
                limpiarCampos();
            } else {
                alerta("El aula ya existe", Alert.AlertType.WARNING);
            }

        } catch(Exception e) {
            alerta("Datos inválidos", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void actualizarAula() {
        try {
            String nombre = txtNombre.getText().trim();
            int capacidad = Integer.parseInt(txtCapacidad.getText().trim());
            Double estado = Double.parseDouble(txtEstado.getText().trim());

            if(controller.actualizarAula(nombre, capacidad, estado)) {
                alerta("Aula actualizada", Alert.AlertType.INFORMATION);
                refrescarTabla();
                limpiarCampos();
            } else {
                alerta("No se pudo actualizar el aula", Alert.AlertType.ERROR);
            }

        } catch(Exception e) {
            alerta("Datos inválidos", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void eliminarAula() {
        Aula seleccionada = tablaAulas.getSelectionModel().getSelectedItem();
        if(seleccionada == null){
            alerta("Seleccione un aula para eliminar", Alert.AlertType.WARNING);
            return;
        }

        if(controller.eliminarAula(seleccionada.nombre())) {
            alerta("Aula eliminada correctamente", Alert.AlertType.INFORMATION);
            refrescarTabla();
            limpiarCampos();
        } else {
            alerta("No se pudo eliminar (está asignada a un curso)", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void volver() {
        App.setRoot("AdministradorAcademico");
    }

    private void limpiarCampos(){
        txtNombre.clear();
        txtCapacidad.clear();
        txtEstado.clear();
    }

    private void alerta(String msg, Alert.AlertType type){
        new Alert(type, msg).showAndWait();
    }
}