package co.edu.uniquindio.poo.projectmusica.model;
import java.util.LinkedList;
import co.edu.uniquindio.poo.projectmusica.model.*;

public class Academia {
    private String nombre, id;
    private LinkedList<Curso> ListCursos;
    private LinkedList<Estudiante> ListEstudiantes;
    private LinkedList<Profesor> ListProfesores;
    private LinkedList<AdministradorAcademico> ListAministradorAcademicos;
    private LinkedList<Matricula> ListMatriculas;

    public Academia(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.ListCursos = new LinkedList<>();
        this.ListEstudiantes= new LinkedList<>();
        this.ListProfesores= new LinkedList<>();
        this.ListAministradorAcademicos = new LinkedList<>();
        this.ListMatriculas = new LinkedList<>();
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

    public boolean agregarCliente(Estudiante Estudiante) {
        boolean centinela = false;
        if (!verificarEstudiante(Estudiante.getId())) {
            ListEstudiantes.add(Estudiante);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarEstudiante (String cedula) {
        boolean centinela = false;
        for (Estudiante Estudiante : ListEstudiantes) {
            if (Estudiante.getId().equals(cedula)) {
                ListEstudiantes.remove(Estudiante);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarEstudiante(String Id, Estudiante actualizado) {
        boolean centinela = false;
        for (Estudiante Estudiante : ListEstudiantes) {
            if (Estudiante.getId().equals(Id)) {
                Estudiante.setNombre(actualizado.getNombre());
                Estudiante.setTelefono(actualizado.getTelefono());
                Estudiante.setEdad(actualizado.getEdad());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean verificarEstudiante(String Id) {
        boolean centinela = false;
        for (Estudiante Estudiante : ListEstudiantes) {
            if (Estudiante.getId().equals(Id)) {
                centinela = true;
            }
        }
        return centinela;
    }
}


