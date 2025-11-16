package co.edu.uniquindio.poo.projectmusica.model;

public interface IHorarioGestionable {
    void gestionHorarios(Curso curso, Horario nuevoHorario);
    boolean validarHorario(Curso curso, Horario horario);
}
