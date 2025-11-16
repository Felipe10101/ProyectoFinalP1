package co.edu.uniquindio.poo.projectmusica.model;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Curso implements IValidable, ICurso {

    private String nombreCurso;
    private Horario horario;
    private Nivel nivel;
    private Aula aula;
    private Profesor profesor;
    private TipoClase tipoClase;
    private int cupo;
    private ArrayList<Estudiante> ListEstudiantesCurso;
    private LinkedList<Asistencia> listAsistencias;
    private LinkedList<ReporteProgreso> listReportes;

    public Curso(String nombreCurso, int cupo, Horario horario, Nivel nivel) {
        this.nombreCurso = nombreCurso;
        this.horario = horario;
        this.nivel = nivel;
        this.tipoClase = tipoClase;
        this.listAsistencias = new LinkedList<>();
        this.listReportes = new LinkedList<>();
        this.ListEstudiantesCurso = new ArrayList<>(cupo);

    }

    public String getnombreCurso() {
        return nombreCurso;
    }

    public void setnombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
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

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public TipoClase getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(TipoClase tipoClase) {
        this.tipoClase = tipoClase;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public ArrayList<Estudiante> getListEstudiantesCurso() {
        return ListEstudiantesCurso;
    }

    public void setListEstudiantesCurso(ArrayList<Estudiante> listEstudiantesCurso) {
        ListEstudiantesCurso = listEstudiantesCurso;
    }

    public boolean agregarEstudianteCurso(Estudiante estudiante, TipoClase tipoClase) {
        if (verificarEstudianteCurso(estudiante.getId())) {
            return false;
        }
        if (tipoClase == TipoClase.GRUPAL) {
            if (ListEstudiantesCurso.size() >= cupo) {
                return false;
            }
        }
        if (tipoClase == TipoClase.INDIVIDUAL) {
            if (ListEstudiantesCurso.size() >= 1) {
                return false;
            }
        }
        ListEstudiantesCurso.add(estudiante);
        return true;
    }


    public boolean eliminarEstudianteCurso(String id) {
        for (Estudiante estudiante : ListEstudiantesCurso) {
            if (estudiante.getId().equals(id)) {
                ListEstudiantesCurso.remove(estudiante);
                return true;
            }
        }
        return false;
    }
//
    public boolean actualizarEstudianteCurso(String Id, Estudiante actualizado) {
        for (Estudiante estudiante : ListEstudiantesCurso) {
            if (estudiante.getId().equals(Id)) {
                estudiante.setNombre(actualizado.getNombre());
                estudiante.setTelefono(actualizado.getTelefono());
                estudiante.setEdad(actualizado.getEdad());
                return true;
            }
        }
        return false;
    }

    //

    public boolean verificarEstudianteCurso(String Id) {
        for (Estudiante estudiante : ListEstudiantesCurso) {
            if (estudiante.getId().equals(Id)) {
                return true;
            }
        }
        return false;
    }
}
