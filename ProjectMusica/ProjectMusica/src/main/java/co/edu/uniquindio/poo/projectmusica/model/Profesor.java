package co.edu.uniquindio.poo.projectmusica.model;
import java.time.LocalDate;
import java.util.LinkedList;

public class Profesor implements IEvaluable, IHorarioGestionable {
    private String nombre, id, telefono;
    private int edad;
    private Horario Horario;

    public Profesor(String nombre, String id, String telefono, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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



    @Override
    public void gestionHorarios(Curso curso, Horario horario) {
        System.out.println("Permiso denegado: los profesores no pueden cambiar horarios directamente.");
    }

    @Override
    public boolean validarHorario(Curso curso, Horario horario) {
        return false;
    }

    @Override
    public boolean registrarProgreso(Curso curso, String descripcion, double nota) {
        return false;
    }

    @Override
    public LinkedList<ReporteProgreso> consultarProgreso(Curso curso) {
        return null;
    }

    @Override
    public boolean crearComentario(String comentario, double nota, LocalDate fecha, Curso curso, Estudiante estudiante) {
        return false;
    }

    @Override
    public boolean registrarAsistencia(Curso curso, Estudiante estudiante, boolean presente, Profesor profesor) {
        return false;
    }

    @Override
    public boolean valorarProgreso(Curso curso, Estudiante estudiante, double notaFinal, String mensaje) {
        return false;
    }
}
