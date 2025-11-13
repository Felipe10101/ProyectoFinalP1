package co.edu.uniquindio.poo.projectmusica.model;
import java.util.LinkedList;

public abstract class Curso implements IValidable, IReporteable, ICurso {

    private String nombre;
    private int cupo;
    private TipoClase tipoClase;
    private Horario horario;
    private Nivel nivel;
    private LinkedList<Estudiante> ListEstudiantesCursos;
    private LinkedList<Asistencia> listAsistencias;

    public Curso(String nombre, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel) {
        this.nombre = nombre;
        this.cupo = cupo;
        this.tipoClase = tipoClase;
        this.horario = horario;
        this.nivel = nivel;
        this.ListEstudiantesCursos = new LinkedList<>();
        this.listAsistencias = new LinkedList<>();
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

    public LinkedList<Estudiante> getListEstudiantesCursos() {
        return ListEstudiantesCursos;
    }

    public void setListEstudiantesCursos(LinkedList<Estudiante> listEstudiantesCursos) {
        ListEstudiantesCursos = listEstudiantesCursos;
    }

    public LinkedList<Asistencia> getListaAsistencias() {
        return listAsistencias;
    }

    public void setListaAsistencias(LinkedList<Asistencia> listAsistencias) {
        this.listAsistencias = listAsistencias;
    }

    // CRUD ESTUIDIANTE CURSO

    public boolean agregarEstudiante(Estudiante estudiante) {
        boolean centinela = false;
        if (!verificarEstudiante(estudiante.getId())) {
            ListEstudiantesCursos.add(estudiante);
            centinela = true;
        }
        return centinela;
    }

    public boolean eliminarEstudiante(String id) {
        boolean centinela = false;
        for (Estudiante estudiante : ListEstudiantesCursos) {
            if (estudiante.getId().equals(id)) {
                ListEstudiantesCursos.remove(estudiante);
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean actualizarEstudiante(String Id, Estudiante actualizado) {
        boolean centinela = false;
        for (Estudiante estudiante : ListEstudiantesCursos) {
            if (estudiante.getId().equals(Id)) {
                estudiante.setNombre(actualizado.getNombre());
                estudiante.setTelefono(actualizado.getTelefono());
                estudiante.setEdad(actualizado.getEdad());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    public boolean verificarEstudiante(String Id) {
        boolean centinela = false;
        for (Estudiante estudiante : ListEstudiantesCursos) {
            if (estudiante.getId().equals(Id)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public void agregarAsistencia(Asistencia asistencia) {
        listAsistencias.add(asistencia);
    }
}
