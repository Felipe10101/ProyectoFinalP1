package co.edu.uniquindio.poo.projectmusica.model;
import java.util.LinkedList;

public abstract class Curso {

    private String nombre;
    private int cupo;
    private TipoClase Tipoclase;
    private Horario Horario;
    private Nivel Nivel;
    private LinkedList<Estudiante> ListEstudianteCurso;

    public Curso(String nombre, int cupo, TipoClase tipoclase, Horario horario, Nivel nivel) {
        this.nombre = nombre;
        this.cupo = cupo;
        Tipoclase = tipoclase;
        Horario = horario;
        Nivel = nivel;
        this.ListEstudianteCurso = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public TipoClase getTipoclase() {
        return Tipoclase;
    }

    public void setTipoclase(TipoClase tipoclase) {
        Tipoclase = tipoclase;
    }

    public Horario getHorario() {
        return Horario;
    }

    public void setHorario(Horario horario) {
        Horario = horario;
    }

    public Nivel getNivel() {
        return Nivel;
    }

    public void setNivel(Nivel nivel) {
        Nivel = nivel;
    }
}
