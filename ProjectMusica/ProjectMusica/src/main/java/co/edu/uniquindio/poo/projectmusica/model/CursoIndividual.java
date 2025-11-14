package co.edu.uniquindio.poo.projectmusica.model;

public class CursoIndividual {
    private Curso curso; // Aquí puede ser Guitarra, Piano, etc.
    private Estudiante estudiante;
    private Profesor profesor;
    private Horario horario;

    public CursoIndividual(Curso curso, Estudiante estudiante, Profesor profesor, Horario horario) {
        this.curso = curso;
        this.estudiante = estudiante;
        this.profesor = profesor;
        this.horario = horario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}
