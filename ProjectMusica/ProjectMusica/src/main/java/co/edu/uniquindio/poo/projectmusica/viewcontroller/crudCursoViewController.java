package co.edu.uniquindio.poo.projectmusica.viewcontroller;

import co.edu.uniquindio.poo.projectmusica.controller.CrudCursoController;
import co.edu.uniquindio.poo.projectmusica.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class crudCursoViewController {


    @FXML private TableView<Curso> tablaCursos;
    @FXML private TableColumn<Curso, String> colNombre;
    @FXML private TableColumn<Curso, Integer> colCupo;
    @FXML private TableColumn<Curso, String> colTipo;
    @FXML private TableColumn<Curso, Nivel> colNivel;
    @FXML private TableColumn<Curso, Horario> colHorario;


    @FXML private TextField txtNombreCurso;
    @FXML private ComboBox<String> cbInstrumento;
    @FXML private ComboBox<Horario> cbHorario;
    @FXML private ComboBox<Nivel> cbNivel;
    @FXML private ComboBox<TipoClase> cbTipoClase;
    @FXML private TextField txtCupo;


    @FXML private Button btnCrear;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;
    @FXML private Button btnRefrescar;

    private CrudCursoController crudController;

    private ObservableList<Curso> obsCursos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        crudController = new CrudCursoController();


        colNombre.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("nombreCurso"));
        colCupo.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("cupo"));
        colTipo.setCellValueFactory(cell -> {
            Curso c = cell.getValue();
            String tipo = c.getClass().getSimpleName();
            return javafx.beans.property.SimpleStringProperty.stringExpression(new javafx.beans.binding.StringBinding() {
                { bind(); }
                @Override
                protected String computeValue() { return tipo; }
            });
        });
        colNivel.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("nivel"));
        colHorario.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("horario"));

        tablaCursos.setItems(obsCursos);


        cbInstrumento.setItems(FXCollections.observableArrayList("Piano", "Guitarra", "Canto", "Violin"));
        cbHorario.setItems(FXCollections.observableArrayList(Arrays.asList(Horario.values())));
        cbNivel.setItems(FXCollections.observableArrayList(Arrays.asList(Nivel.values())));
        cbTipoClase.setItems(FXCollections.observableArrayList(Arrays.asList(TipoClase.values())));


        tablaCursos.getSelectionModel().selectedItemProperty().addListener((obs, oldS, newS) -> {
            if (newS != null) {
                cargarCursoEnFormulario(newS);
            }
        });

        refreshCursos();
    }

    private void cargarCursoEnFormulario(Curso curso) {
        txtNombreCurso.setText(curso.getNombreCurso());
        txtCupo.setText(String.valueOf(curso.getCupo()));

        if (curso.getHorario() != null) cbHorario.setValue(curso.getHorario());
        if (curso.getNivel() != null) cbNivel.setValue(curso.getNivel());
        if (curso.getTipoClase() != null) cbTipoClase.setValue(curso.getTipoClase());


        String tipo = curso.getClass().getSimpleName();
        cbInstrumento.setValue(tipo);
    }

    @FXML
    private void onCrear() {
        String nombre = txtNombreCurso.getText().trim();
        String instrumento = cbInstrumento.getValue();
        Horario horario = cbHorario.getValue();
        Nivel nivel = cbNivel.getValue();
        TipoClase tipoClase = cbTipoClase.getValue();
        int cupo = parseIntOrZero(txtCupo.getText().trim());

        if (nombre.isEmpty() || instrumento == null || horario == null || nivel == null || tipoClase == null) {
            showAlert(Alert.AlertType.WARNING, "Debe completar todos los campos obligatorios.");
            return;
        }

        try {
            CrudCursoController controller = crudController;
            controller.crearCurso(nombre, horario, nivel, tipoClase, cupo, instrumento);
            showAlert(Alert.AlertType.INFORMATION, "Curso creado correctamente.");
            refreshCursos();
            clearForm();
        } catch (Exception ex) {
            showAlert(Alert.AlertType.ERROR, "Error al crear curso: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    private void onActualizar() {
        String nombre = txtNombreCurso.getText().trim();
        Horario horario = cbHorario.getValue();
        Nivel nivel = cbNivel.getValue();

        if (nombre.isEmpty() || horario == null || nivel == null) {
            showAlert(Alert.AlertType.WARNING, "Seleccione un curso y defina horario y nivel para actualizar.");
            return;
        }

        boolean ok = crudController.actualizarCurso(nombre, horario, nivel);
        if (ok) {
            showAlert(Alert.AlertType.INFORMATION, "Curso actualizado correctamente.");
            refreshCursos();
        } else {
            showAlert(Alert.AlertType.ERROR, "No se pudo actualizar (curso no existe).");
        }
    }

    @FXML
    private void onEliminar() {
        Curso seleccionado = tablaCursos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            showAlert(Alert.AlertType.WARNING, "Seleccione un curso para eliminar.");
            return;
        }
        boolean ok = crudController.eliminarCurso(seleccionado.getNombreCurso());
        if (ok) {
            showAlert(Alert.AlertType.INFORMATION, "Curso eliminado.");
            refreshCursos();
            clearForm();
        } else {
            showAlert(Alert.AlertType.ERROR, "No se pudo eliminar.");
        }
    }

    @FXML
    private void onRefrescar() {
        refreshCursos();
    }

    private void refreshCursos() {
        obsCursos.setAll(crudController.obtenerCursos().stream().collect(Collectors.toList()));
        tablaCursos.refresh();
    }

    private void clearForm() {
        txtNombreCurso.clear();
        txtCupo.clear();
        cbInstrumento.getSelectionModel().clearSelection();
        cbHorario.getSelectionModel().clearSelection();
        cbNivel.getSelectionModel().clearSelection();
        cbTipoClase.getSelectionModel().clearSelection();
        tablaCursos.getSelectionModel().clearSelection();
    }

    private int parseIntOrZero(String s) {
        try { return Integer.parseInt(s); } catch (Exception ex) { return 0; }
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert a = new Alert(type, message);
        a.setHeaderText(null);
        a.showAndWait();
    }
}