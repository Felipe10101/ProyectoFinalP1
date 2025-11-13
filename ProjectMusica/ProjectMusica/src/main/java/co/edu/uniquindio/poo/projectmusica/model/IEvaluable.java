package co.edu.uniquindio.poo.projectmusica.model;

public interface IEvaluable {
    void registrarProgreso();
    void consultarProgreso();
    void crearComentario(String comentario, double nota, java.time.LocalDate fecha, Curso curso);
    void gestionarHorarioDisponible();
    void crearClaseGrupal();
    void registrarAsistencia(Curso curso, Estudiante estudiante, boolean presente, Profesor profesor);
    void valorarProgreso();
}
