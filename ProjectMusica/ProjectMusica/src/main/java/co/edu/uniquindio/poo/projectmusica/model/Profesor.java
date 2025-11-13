package co.edu.uniquindio.poo.projectmusica.model;
import java.time.LocalDate;

public class Profesor implements IUsuario, IEvaluable, IHorarioGestionable {
    private String nombre, id, telefono;
    private int edad;

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

    @Override
    public void registrarProgreso() {

    }

    @Override
    public void consultarProgreso() {

    }

    @Override
    public void crearComentario(String comentario, double nota, LocalDate fecha, Curso curso) {
    }

    @Override
    public void gestionarHorarioDisponible() {

    }

    @Override
    public void crearClaseGrupal() {

    }

    @Override
    public void registrarAsistencia(Curso curso, Estudiante estudiante, boolean presente, Profesor profesor) {
        Asistencia asistencia = new Asistencia(LocalDate.now(), presente);
        curso.agregarAsistencia(asistencia);

        System.out.println("Asistencia registrada:");
        System.out.println("Profesor: " + nombre);
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Curso: " + curso.getNombre());
        System.out.println("Presente: " + (presente ? "Sí" : "No"));
    }

    @Override
    public void valorarProgreso() {

    }

// @OVERRIDE

}