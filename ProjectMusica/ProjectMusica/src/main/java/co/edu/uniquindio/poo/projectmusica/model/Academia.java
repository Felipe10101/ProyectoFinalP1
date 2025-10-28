package co.edu.uniquindio.poo.projectmusica.model;
import java.util.LinkedList;

public class Academia {
    private String nombre, id;
    private LinkedList<Curso> ListCurso;
    private LinkedList<Estudiante> ListEstudiante;
    private LinkedList<Profesor> ListProfesor;
    private LinkedList<AdministradorAcademico> ListAministradorAcademico;
    private LinkedList<Matricula> ListMatricula;

    public Academia(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.ListCurso = new LinkedList<>();
        this.ListEstudiante = new LinkedList<>();
        this.ListProfesor = new LinkedList<>();
        this.ListAministradorAcademico = new LinkedList<>();
        this.ListMatricula = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


