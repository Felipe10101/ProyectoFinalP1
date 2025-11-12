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

    // CRUD ESTUDIANTE

    public boolean agregarEstudiante(Estudiante Estudiante) {
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

    // CRUD PROFESORES

    public boolean agregarProfesor(Profesor Profesor) {
        boolean centinela = false;
        if (!verificarProfesor(Profesor.getId())) {
            ListProfesores.add(Profesor);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarProfesor (String cedula) {
        boolean centinela = false;
        for (Profesor Profesor : ListProfesores) {
            if (Profesor.getId().equals(cedula)) {
                ListProfesores.remove(Profesor);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarProfesor(String Id, Profesor actualizado) {
        boolean centinela = false;
        for (Profesor Profesor : ListProfesores) {
            if (Profesor.getId().equals(Id)) {
                Profesor.setNombre(actualizado.getNombre());
                Profesor.setTelefono(actualizado.getTelefono());
                Profesor.setEdad(actualizado.getEdad());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean verificarProfesor(String Id) {
        boolean centinela = false;
        for (Profesor Profesor : ListProfesores) {
            if (Profesor.getId().equals(Id)) {
                centinela = true;
            }
        }
        return centinela;
    }

    // CRUD CURSO

    public boolean agregarCurso(Curso Curso) {
        boolean centinela = false;
        if (!verificarCurso(Curso.getNombre())) {
            ListCursos.add(Curso);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarCurso (String nombre) {
        boolean centinela = false;
        for (Curso Curso : ListCursos) {
            if (Curso.getNombre().equals(nombre)) {
                ListCursos.remove(Curso);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarCurso(String nombre, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel, Curso actualizado) {
        boolean centinela = false;
        for (Curso Curso : ListCursos) {
            if (Curso.getNombre().equals(nombre)) {
                Curso.setCupo(actualizado.getCupo());
                Curso.setTipoClase(actualizado.getTipoClase());
                Curso.setHorario(actualizado.getHorario());
                Curso.setNivel(actualizado.getNivel());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean verificarCurso(String Nombre) {
        boolean centinela = false;
        for (Curso Curso : ListCursos) {
            if (Curso.getNombre().equals(Nombre)) {
                centinela = true;
            }
        }
        return centinela;
    }
}


