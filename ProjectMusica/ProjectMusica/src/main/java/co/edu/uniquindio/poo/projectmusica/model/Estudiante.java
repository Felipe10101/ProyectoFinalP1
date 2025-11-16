package co.edu.uniquindio.poo.projectmusica.model;

public class Estudiante implements IInscribible{
    private String nombre, id, telefono;
    private int edad;
    private  Curso curso;


    public Estudiante(String nombre, String id, String telefono, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.edad = edad;
        this.curso = curso;
    }

    @Override
    public Curso inscripcionCurso(Curso curso) {

        Academia academia = curso.getProfesor() != null ?
                curso.getProfesor().getAcademia() : null;

        if (academia == null) {
            System.out.println("Error: no se pudo determinar la academia del curso.");
            return null;
        }

        boolean ok = academia.matricularEstudiante(this.getId(), curso.getNombreCurso());

        if (ok) {
            System.out.println("✔ Estudiante inscrito correctamente a " + curso.getNombreCurso());
            return curso;
        } else {
            System.out.println("✘ No se pudo inscribir al curso.");
            return null;
        }
    }

    @Override
    public void cancelacionCurso(Curso curso) {

        Academia academia = curso.getProfesor() != null ?
                curso.getProfesor().getAcademia() : null;

        if (academia == null) {
            System.out.println("Error: no se pudo determinar la academia del curso.");
            return;
        }

        boolean ok = curso.eliminarEstudianteCurso(this.getId());

        if (ok) {
            System.out.println("✔ Curso cancelado correctamente: " + curso.getNombreCurso());
        } else {
            System.out.println("✘ No estás inscrito en este curso.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static String getId() {
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
}
