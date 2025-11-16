package co.edu.uniquindio.poo.projectmusica.model;

public class AdministradorAcademico implements IHorarioGestionable, IReporteable {

    private String id;
    private Academia academia;

    public AdministradorAcademico( String id, Academia academia) {
        this.id = id;
        this.academia = academia;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }


    public boolean agregarEstudiante(Estudiante e) {
        return academia.agregarEstudiante(e);
    }

    public boolean eliminarEstudiante(String idEstudiante) {
        return academia.eliminarEstudiante(idEstudiante);
    }

    public boolean actualizarEstudiante(String id, Estudiante actualizado) {
        return academia.actualizarEstudiante(id, actualizado);
    }

    public boolean agregarProfesor(Profesor p) {
        return academia.agregarProfesor(p);
    }

    public boolean eliminarProfesor(String idProfesor) {
        return academia.eliminarProfesor(idProfesor);
    }

    public boolean actualizarProfesor(String id, Profesor actualizado) {
        return academia.actualizarProfesor(id, actualizado);
    }

    public Curso crearCursoPiano(String nombre, int cupo, TipoClase tipoClase,
                                 Horario horario, Nivel nivel,
                                 String tipoPiano, String marcaPiano, boolean requierePedales) {

        return academia.crearCursoPiano(nombre, cupo, tipoClase, horario, nivel,
                tipoPiano, marcaPiano, requierePedales);
    }

    public Curso crearCursoGuitarra(String nombre, int cupo, TipoClase tipoClase,
                                    Horario horario, Nivel nivel,
                                    String afinacion, String tipoCuerda, int cuerdas) {

        return academia.crearCursoGuitarra(nombre, cupo, tipoClase, horario, nivel,
                afinacion, tipoCuerda, cuerdas);
    }

    public Curso crearCursoCanto(String nombre, int cupo, TipoClase tipoClase,
                                 Horario horario, Nivel nivel,
                                 String tipoVoz, String generoMusical) {

        return academia.crearCursoCanto(nombre, cupo, tipoClase, horario, nivel,
                tipoVoz, generoMusical);
    }

    public Curso crearCursoViolin(String nombre, int cupo, TipoClase tipoClase,
                                  Horario horario, Nivel nivel,
                                  String tamanio, String arco, String tecnica) {

        return academia.crearCursoViolin(nombre, cupo, tipoClase, horario, nivel,
                tamanio, arco, tecnica);
    }

    public boolean eliminarCurso(String nombreCurso) {
        return academia.eliminarCurso(nombreCurso);
    }

    public boolean actualizarCurso(String nombreCurso, Curso actualizado) {
        return academia.actualizarCurso(nombreCurso, actualizado);
    }

    public boolean agregarMatricula(Matricula m) {
        return academia.agregarMatricula(m);
    }

    public boolean eliminarMatricula(String id) {
        return academia.eliminarMatricula(id);
    }

    public boolean actualizarMatricula(String id, Matricula actualizado) {
        return academia.actualizarMatricula(id, actualizado);
    }

    public boolean matricularEstudiante(String idEstudiante, String nombreCurso) {
        return academia.matricularEstudiante(idEstudiante, nombreCurso);
    }

    public boolean asignarProfesor(String idProfesor, String nombreCurso) {
        // Solo si creas academia.asignarProfesorACurso()
        return academia.asignarProfesorACurso(idProfesor, nombreCurso);
    }

    public boolean asignarAula(String nombreCurso, Aula aula) {
        return academia.asignarAulaACurso(nombreCurso, aula);
    }

    @Override
    public void gestionHorarios(Curso curso, Horario nuevoHorario) {
        boolean ok = academia.cambiarHorarioCurso(curso.getnombreCurso(), nuevoHorario);
        if (!ok) {
            System.out.println("No se pudo cambiar el horario para el curso: " + curso.getnombreCurso());
        }
    }

    @Override
    public boolean validarHorario(Curso curso, Horario horario) {
        return false;
    }

    @Override
    public void generarReporte(Curso curso) {
        System.out.println("==== REPORTE DEL CURSO ====");
        System.out.println("Curso: " + curso.getnombreCurso());
        System.out.println("Horario: " + curso.getHorario());
        System.out.println("Nivel: " + curso.getNivel());
        System.out.println("Tipo: " + curso.getTipoClase());
        System.out.println("Cupo: " + curso.getCupo());
        System.out.println("Inscritos: " + curso.getListEstudiantesCurso().size());
        System.out.println("Profesor: " + (curso.getProfesor() != null ? curso.getProfesor().getNombre() : "No asignado"));
        System.out.println("============================");
    }
}
