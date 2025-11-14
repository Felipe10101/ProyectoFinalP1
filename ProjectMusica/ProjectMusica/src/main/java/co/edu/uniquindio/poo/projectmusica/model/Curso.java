package co.edu.uniquindio.poo.projectmusica.model;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Curso implements IValidable, IReporteable, ICurso {

    private String nombre;
    private Horario horario;
    private Nivel nivel;
    private Aula aula;
    private CursoGrupal CursoGrupal;
    private CursoIndividual CursoIndividual;
    private Profesor profesor;
    private LinkedList<Asistencia> listAsistencias;
    private LinkedList<ReporteProgreso> listReportes;

    public Curso(String nombre, int cupo, Horario horario, Nivel nivel) {
        this.nombre = nombre;
        this.horario = horario;
        this.nivel = nivel;
        this.listAsistencias = new LinkedList<>();
        this.listReportes = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public LinkedList<Asistencia> getListAsistencias() {
        return listAsistencias;
    }

    public void setListAsistencias(LinkedList<Asistencia> listAsistencias) {
        this.listAsistencias = listAsistencias;
    }

    public LinkedList<ReporteProgreso> getListReportes() {
        return listReportes;
    }

    public void setListReportes(LinkedList<ReporteProgreso> listReportes) {
        this.listReportes = listReportes;
    }

}
