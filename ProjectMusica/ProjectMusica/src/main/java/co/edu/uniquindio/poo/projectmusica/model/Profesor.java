package co.edu.uniquindio.poo.projectmusica.model;
import java.time.LocalDate;
import java.util.LinkedList;

public class Profesor implements IEvaluable, IHorarioGestionable {
    private String nombre, id, telefono;
    private int edad;
    private Horario Horario;
    private Academia academia;

    public Profesor(String nombre, String id, String telefono, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.edad = edad;
        this.academia = academia;

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getId(){
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
    public Academia getAcademia() {
        return academia;
    }
    public void setAcademia(Academia academia) {
        this.academia = academia;
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

        if (curso == null) return false;
        if (nota < 0 || nota > 5) {
            System.out.println("Error: la nota debe estar entre 0 y 5.");
            return false;
        }

        ReporteProgreso reporte = new ReporteProgreso(descripcion, nota, LocalDate.now());
        curso.getListReportes().add(reporte);

        System.out.println("✔ Progreso registrado en curso: " + curso.getNombreCurso());
        return true;
    }

    @Override
    public LinkedList<ReporteProgreso> consultarProgreso(Curso curso) {
        if (curso == null) return new LinkedList<>();
        return curso.getListReportes();
    }


    @Override
    public boolean crearComentario(String comentario, double nota, LocalDate fecha, Curso curso, Estudiante estudiante) {
        return false;
    }

    @Override
    public boolean registrarAsistencia(Curso curso, Estudiante estudiante, boolean presente, Profesor profesor) {

        if (curso == null || estudiante == null) {
            System.out.println("Error: curso o estudiante es null.");
            return false;
        }
        if (curso.getProfesor() == null || !curso.getProfesor().equals(this)) {
            System.out.println("Error: este profesor no está asignado al curso.");
            return false;
        }
        if (!curso.verificarEstudianteCurso(estudiante.getId())) {
            System.out.println("Error: el estudiante no pertenece al curso.");
            return false;
        }
        Asistencia asistencia = new Asistencia(LocalDate.now(), presente);
        curso.getListAsistencias().add(asistencia);

        System.out.println("Asistencia registrada para: " + estudiante.getNombre());
        return true;
    }


    @Override
    public boolean valorarProgreso(Curso curso, Estudiante estudiante, double nota, String mensaje) {

        if (curso == null || estudiante == null) return false;

        if (nota < 0 || nota > 5) {
            System.out.println("Error: nota fuera de rango.");
            return false;
        }

        ReporteProgreso finalReport = new ReporteProgreso(mensaje, nota, LocalDate.now());
        curso.getListReportes().add(finalReport);

        System.out.println("Valoración final registrada para " + estudiante.getNombre());
        return true;
    }

}
