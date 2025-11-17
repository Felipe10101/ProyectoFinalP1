package co.edu.uniquindio.poo.projectmusica.model;

import java.util.LinkedList;

public class Estudiante implements IInscribible{
    private String nombre, id, telefono;
    private int edad;
    private  Curso curso;
    private Academia academia;
    private LinkedList<Curso> cursosInscritos = new LinkedList<>();



    public Estudiante(String nombre, String id, String telefono, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.edad = edad;
        this.curso = curso;
        this.academia = academia;
        this.cursosInscritos = new LinkedList<>();
    }

    @Override
    public void cancelacionCurso(Curso curso) {
        if (academia == null) {
            System.out.println("✘ Error: el estudiante no está asociado a ninguna academia.");
            return;
        }
        if (!cursosInscritos.contains(curso)) {
            System.out.println("✘ No estás inscrito en este curso.");
            return;
        }
        boolean ok = curso.eliminarEstudianteCurso(this.getId());

        if (ok) {
            cursosInscritos.remove(curso);
            System.out.println("✔ Curso cancelado correctamente: " + curso.getNombreCurso());
        } else {
            System.out.println("✘ No se pudo cancelar el curso.");
        }
    }
    @Override
    public Curso inscripcionCurso(Curso curso) {
        if (academia == null) {
            System.out.println("Error: el estudiante no pertenece a ninguna academia.");
            return null;
        }
        if (cursosInscritos.contains(curso)) {
            System.out.println("✘ Ya estás inscrito en este curso.");
            return null;
        }
        boolean ok = academia.matricularEstudiante(this.getId(), curso.getNombreCurso());
        if (ok) {
            cursosInscritos.add(curso);
            System.out.println("✔ Estudiante inscrito correctamente a " + curso.getNombreCurso());
            return curso;
        } else {
            System.out.println("✘ No se pudo inscribir al curso.");
            return null;
        }
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LinkedList<Curso> getCursosInscritos() {
        return cursosInscritos;
    }
}
