package co.edu.uniquindio.poo.projectmusica.model;
import java.util.LinkedList;

public abstract class Curso implements IEvaluable, IValidable, IReporteable, ICurso {

    private String nombre;
    private int cupo;
    private TipoClase tipoClase;
    private Horario horario;
    private Nivel nivel;
    private LinkedList<Estudiante> ListEstudianteCurso;

    public Curso(String nombre, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel) {
        this.nombre = nombre;
        this.cupo = cupo;
        this.tipoClase = tipoClase;
        this.horario = horario;
        this.nivel = nivel;
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

    public TipoClase getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(TipoClase tipoClase) {
        this.tipoClase = tipoClase;
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

    // Métodos abstractos o vacíos de IEvaluable
    @Override
    public void registrarProgreso() {}

    @Override
    public void consultarProgreso() {}

    @Override
    public void gestionarHorarioDisponible() {}

    @Override
    public void crearClaseGrupal() {}

    @Override
    public void registrarAsistencia() {}

    @Override
    public void valorarProgreso() {}
}
