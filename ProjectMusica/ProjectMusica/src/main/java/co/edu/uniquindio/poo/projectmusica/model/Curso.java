package co.edu.uniquindio.poo.projectmusica.model;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Curso implements IValidable, ICurso {

    protected String nombreCurso;
    protected Horario horario;
    protected Nivel nivel;
    protected Aula aula;
    protected Profesor profesor;
    protected TipoClase tipoClase;
    protected int cupo;
    protected ArrayList<Estudiante> ListEstudiantesCurso;
    protected LinkedList<Asistencia> listAsistencias;
    protected LinkedList<ReporteProgreso> listReportes;

    public Curso(String nombreCurso,Horario horario, Nivel nivel, TipoClase tipoClase, int cupo) {
        this.nombreCurso = nombreCurso;
        this.horario = horario;
        this.nivel = nivel;
        this.tipoClase = tipoClase;
        this.listAsistencias = new LinkedList<>();
        this.listReportes = new LinkedList<>();
        this.ListEstudiantesCurso = new ArrayList<>(cupo);

    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
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

    public void validarCupo() {
        if (tipoClase == TipoClase.GRUPAL) {
            System.out.println("Cupo disponible: " + (cupo - ListEstudiantesCurso.size()));
        } else {
            System.out.println("Curso individual — cupo máximo: 1");
        }
    }

    public boolean validarConflictoHorario(Curso otro) {
        if (this.horario == null || otro.horario == null) return false;
        return this.horario.equals(otro.horario);
    }

    public boolean listarAsistencia() {
        if (listAsistencias.isEmpty()) {
            System.out.println("No hay registros de asistencia.");
            return false;
        }
        System.out.println("Asistencias del curso: " + nombreCurso);
        for (Asistencia a : listAsistencias) {
            System.out.println(a.fecha() + " - " + (a.presente() ? "Presente" : "Ausente"));
        }
        return true;
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



    public boolean verificarEstudianteCurso(String Id) {
        for (Estudiante estudiante : ListEstudiantesCurso) {
            if (estudiante.getId().equals(Id)) {
                return true;
            }
        }
        return false;
    }


    public void generarReporte() {
        System.out.println("REPORTE DEL CURSO ");
        System.out.println("Curso: " + getNombreCurso());
        System.out.println("Horario: " + getHorario());
        System.out.println("Nivel: " + getNivel());
        System.out.println("Tipo: " + getTipoClase());
        System.out.println("Cupo: " + getCupo());
        System.out.println("Inscritos: " + getListEstudiantesCurso().size());
        System.out.println("Profesor: " + (getProfesor() != null ? getProfesor().getNombre() : "No asignado"));

        if (listReportes == null || listReportes.isEmpty()) {
            System.out.println("No hay reportes de progreso.");
        } else {
            System.out.println("Reportes de Progreso:");
            int i = 1;
            for (ReporteProgreso r : listReportes) {
                System.out.println("  [" + i++ + "]");
                System.out.println("    Comentario: " + r.comentario());
                System.out.println("    Nota      : " + r.nota());
                System.out.println("    Fecha     : " + r.fecha());
            }
        }
        if (listAsistencias == null || listAsistencias.isEmpty()) {
            System.out.println("No hay registros de asistencia.");
        } else {
            int presentes = 0;
            System.out.println("Asistencias:");
            int idx = 1;
            for (Asistencia a : listAsistencias) {
                System.out.println("  [" + (idx++) + "] " + a.fecha() + " - " + (a.presente() ? "Presente" : "Ausente"));
                if (a.presente()) presentes++;
            }
            System.out.println("Asistencias totales: " + presentes + "/" + listAsistencias.size());
        }
        System.out.println(" FIN DEL REPORTE");
    }

    @Override
    public boolean validarInscripcion(Estudiante estudiante, Curso curso) {

        if (curso.verificarEstudianteCurso(estudiante.getId())) {
            System.out.println("El estudiante ya está inscrito en este curso.");
            return false;
        }


        if (curso.getTipoClase() == TipoClase.GRUPAL &&
                curso.getListEstudiantesCurso().size() >= curso.getCupo()) {
            System.out.println("No hay cupos disponibles en el curso.");
            return false;
        }

        if (curso.getTipoClase() == TipoClase.INDIVIDUAL &&
                curso.getListEstudiantesCurso().size() >= 1) {
            System.out.println("El curso individual ya tiene estudiante asignado.");
            return false;
        }

        return true;
    }

    @Override
    public void asignarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public void asignarAula(Aula aula) {
        this.aula = aula;
    }


}
