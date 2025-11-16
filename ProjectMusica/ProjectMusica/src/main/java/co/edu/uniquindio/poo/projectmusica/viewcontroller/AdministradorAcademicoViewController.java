package co.edu.uniquindio.poo.projectmusica.viewcontroller;

import co.edu.uniquindio.poo.projectmusica.controller.AdministradorAcademicoController;
import co.edu.uniquindio.poo.projectmusica.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdministradorAcademicoViewController{

    // UI - Estudiantes
    @FXML private TableView<Estudiante> tablaEstudiantes;
    @FXML private TableColumn<Estudiante, String> colEstId;
    @FXML private TableColumn<Estudiante, String> colEstNombre;
    @FXML private TextField txtEstId;
    @FXML private TextField txtEstNombre;
    @FXML private TextField txtEstTelefono;
    @FXML private TextField txtEstEdad;

    // UI - Profesores
    @FXML private TableView<Profesor> tablaProfesores;
    @FXML private TableColumn<Profesor, String> colProfId;
    @FXML private TableColumn<Profesor, String> colProfNombre;
    @FXML private TextField txtProfId;
    @FXML private TextField txtProfNombre;
    @FXML private TextField txtProfTelefono;
    @FXML private TextField txtProfEdad;

    // UI - Cursos (sólo lista simple)
    @FXML private TableView<Curso> tablaCursos;
    @FXML private TableColumn<Curso, String> colCursoNombre;
    @FXML private TableColumn<Curso, Integer> colCursoCupo;

    // controlador de negocio
    private AdministradorAcademicoController controller;

    // listas observables para TableView
    private ObservableList<Estudiante> obsEstudiantes = FXCollections.observableArrayList();
    private ObservableList<Profesor> obsProfesores = FXCollections.observableArrayList();
    private ObservableList<Curso> obsCursos = FXCollections.observableArrayList();

    // Debes inyectar la instancia de Academia desde tu App o crear una aquí para pruebas.
    public void setController(AdministradorAcademicoController controller) {
        this.controller = controller;
        refreshAll();
    }

    @FXML
    public void initialize() {
        // columnas de estudiantes
        colEstId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEstNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        // columnas profesores
        colProfId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colProfNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        // columnas cursos (usa getters del modelo: getNombreCurso, getCupo)
        colCursoNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCurso"));
        colCursoCupo.setCellValueFactory(new PropertyValueFactory<>("cupo"));

        tablaEstudiantes.setItems(obsEstudiantes);
        tablaProfesores.setItems(obsProfesores);
        tablaCursos.setItems(obsCursos);
    }

    // ---------- ESTUDIANTES ----------
    @FXML
    private void onAgregarEstudiante() {
        String id = txtEstId.getText().trim();
        String nombre = txtEstNombre.getText().trim();
        String telefono = txtEstTelefono.getText().trim();
        int edad = parseIntOrZero(txtEstEdad.getText().trim());

        if(id.isEmpty() || nombre.isEmpty()){
            showAlert(Alert.AlertType.WARNING, "Debe completar id y nombre");
            return;
        }
        Estudiante e = new Estudiante(nombre, id, edad, telefono); // ajusta constructor según tu clase
        boolean ok = controller.agregarEstudiante(e);
        if (ok) {
            showAlert(Alert.AlertType.INFORMATION, "Estudiante agregado");
            refreshEstudiantes();
            clearEstudianteForm();
        } else {
            showAlert(Alert.AlertType.ERROR, "No se pudo agregar (ya existe).");
        }
    }

    @FXML
    private void onEliminarEstudiante() {
        Estudiante seleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            showAlert(Alert.AlertType.WARNING, "Selecciona un estudiante");
            return;
        }
        boolean ok = controller.eliminarEstudiante(seleccionado.getId());
        if (ok) {
            showAlert(Alert.AlertType.INFORMATION, "Estudiante eliminado");
            refreshEstudiantes();
        } else {
            showAlert(Alert.AlertType.ERROR, "No se pudo eliminar");
        }
    }

    @FXML
    private void onActualizarEstudiante() {
        String id = txtEstId.getText().trim();
        String nombre = txtEstNombre.getText().trim();
        String telefono = txtEstTelefono.getText().trim();
        int edad = parseIntOrZero(txtEstEdad.getText().trim());

        if(id.isEmpty()){
            showAlert(Alert.AlertType.WARNING, "Ingrese el id del estudiante a actualizar");
            return;
        }
        Estudiante actualizado = new Estudiante(nombre, id, edad, telefono);
        boolean ok = controller.actualizarEstudiante(id, actualizado);
        if (ok) {
            showAlert(Alert.AlertType.INFORMATION, "Estudiante actualizado");
            refreshEstudiantes();
            clearEstudianteForm();
        } else {
            showAlert(Alert.AlertType.ERROR, "No se pudo actualizar");
        }
    }

    // ---------- PROFESORES ----------
    @FXML
    private void onAgregarProfesor() {
        String id = txtProfId.getText().trim();
        String nombre = txtProfNombre.getText().trim();
        String telefono = txtProfTelefono.getText().trim();
        int edad = parseIntOrZero(txtProfEdad.getText().trim());

        if(id.isEmpty() || nombre.isEmpty()){
            showAlert(Alert.AlertType.WARNING, "Debe completar id y nombre");
            return;
        }
        Profesor p = new Profesor(nombre, id, edad, telefono); // ajusta constructor según tu clase
        boolean ok = controller.agregarProfesor(p);
        if (ok) {
            showAlert(Alert.AlertType.INFORMATION, "Profesor agregado");
            refreshProfesores();
            clearProfesorForm();
        } else {
            showAlert(Alert.AlertType.ERROR, "No se pudo agregar (ya existe).");
        }
    }

    @FXML
    private void onEliminarProfesor() {
        Profesor seleccionado = tablaProfesores.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            showAlert(Alert.AlertType.WARNING, "Selecciona un profesor");
            return;
        }
        boolean ok = controller.eliminarProfesor(seleccionado.getId());
        if (ok) {
            showAlert(Alert.AlertType.INFORMATION, "Profesor eliminado");
            refreshProfesores();
        } else {
            showAlert(Alert.AlertType.ERROR, "No se pudo eliminar");
        }
    }

    @FXML
    private void onActualizarProfesor() {
        String id = txtProfId.getText().trim();
        String nombre = txtProfNombre.getText().trim();
        String telefono = txtProfTelefono.getText().trim();
        int edad = parseIntOrZero(txtProfEdad.getText().trim());

        if(id.isEmpty()){
            showAlert(Alert.AlertType.WARNING, "Ingrese el id del profesor a actualizar");
            return;
        }
        Profesor actualizado = new Profesor(nombre, id, edad, telefono);
        boolean ok = controller.actualizarProfesor(id, actualizado);
        if (ok) {
            showAlert(Alert.AlertType.INFORMATION, "Profesor actualizado");
            refreshProfesores();
            clearProfesorForm();
        } else {
            showAlert(Alert.AlertType.ERROR, "No se pudo actualizar");
        }
    }

    // ---------- CURSOS ----------
    @FXML
    private void onRefrescarCursos() {
        refreshCursos();
    }

    // ---------- UTIL / HELPERS ----------
    private void refreshAll() {
        refreshEstudiantes();
        refreshProfesores();
        refreshCursos();
    }

    private void refreshEstudiantes() {
        obsEstudiantes.setAll(controller.listarEstudiantes());
        tablaEstudiantes.refresh();
    }

    private void refreshProfesores() {
        obsProfesores.setAll(controller.listarProfesores());
        tablaProfesores.refresh();
    }

    private void refreshCursos() {
        obsCursos.setAll(controller.listarCursos());
        tablaCursos.refresh();
    }

    private void clearEstudianteForm() {
        txtEstId.clear();
        txtEstNombre.clear();
        txtEstTelefono.clear();
        txtEstEdad.clear();
    }

    private void clearProfesorForm() {
        txtProfId.clear();
        txtProfNombre.clear();
        txtProfTelefono.clear();
        txtProfEdad.clear();
    }

    private int parseIntOrZero(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception ex) {
            return 0;
        }
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert a = new Alert(type, message);
        a.setHeaderText(null);
        a.showAndWait();
    }
}
