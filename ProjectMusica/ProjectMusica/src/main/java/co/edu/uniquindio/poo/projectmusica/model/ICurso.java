package co.edu.uniquindio.poo.projectmusica.model;

public interface ICurso {
    boolean agregarEstudianteCurso(Estudiante estudiante, TipoClase tipoClase);
    boolean eliminarEstudianteCurso(String id);
    boolean actualizarEstudianteCurso(String id, Estudiante actualizado);
    boolean verificarEstudianteCurso(String id);
    void asignarProfesor(Profesor profesor);
    void asignarAula(Aula aula);
}
