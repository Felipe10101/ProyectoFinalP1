package co.edu.uniquindio.poo.projectmusica;

import co.edu.uniquindio.poo.projectmusica.model.Curso;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }



    public boolean agregarCurso(Curso Curso) {
        boolean centinela = false;
        if (!verificarCurso(Curso.getId())) {
            ListCursoes.add(Curso);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarCurso (String cedula) {
        boolean centinela = false;
        for (Curso Curso : ListCursos) {
            if (Curso.getId().equals(cedula)) {
                ListCursos.remove(Curso);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarCurso(String Id, Curso actualizado) {
        boolean centinela = false;
        for (Curso Curso : ListCursos) {
            if (Curso.getId().equals(Id)) {
                Curso.setNombre(actualizado.getNombre());
                Curso.setTelefono(actualizado.getTelefono());
                Curso.setEdad(actualizado.getEdad());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean verificarCurso(String Id) {
        boolean centinela = false;
        for (Curso Curso : ListCursos) {
            if (Curso.getId().equals(Id)) {
                centinela = true;
            }
        }
        return centinela;
    }
}