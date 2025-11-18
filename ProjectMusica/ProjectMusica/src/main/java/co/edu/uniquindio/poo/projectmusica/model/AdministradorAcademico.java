package co.edu.uniquindio.poo.projectmusica.model;

public class AdministradorAcademico implements IHorarioGestionable, IReporteable {

    private String user,id;
    private Academia academia;

    public AdministradorAcademico( String user, Academia academia) {
        this.user = user;
        this.academia = academia;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Curso crearCursoPiano(String nombreCurso,Horario horario, Nivel nivel, TipoClase tipoClase, int cupo, String tipoPiano, String marca, boolean requierePedales) {

        return academia.crearCursoPiano(nombreCurso,horario,nivel,tipoClase,cupo,tipoPiano,marca,requierePedales);
    }

    public Curso crearCursoGuitarra(String nombreCurso,Horario horario, Nivel nivel, TipoClase tipoClase, int cupo,String afinacion, String tipoCuerda, int cuerdas) {

        return academia.crearCursoGuitarra(nombreCurso,horario,nivel, tipoClase, cupo,afinacion, tipoCuerda,cuerdas);
    }

    public Curso crearCursoCanto(String nombreCurso,Horario horario, Nivel nivel, TipoClase tipoClase, int cupo,
                                 String tipoVoz, String generoMusical) {

        return academia.crearCursoCanto(nombreCurso, horario, nivel, tipoClase,cupo,
     tipoVoz, generoMusical);
    }

    public Curso crearCursoViolin(String nombreCurso,Horario horario, Nivel nivel, TipoClase tipoClase, int cupo, String tamanio, String arco, String tecnica) {

        return academia.crearCursoViolin(nombreCurso,horario,nivel,tipoClase,cupo,tamanio,arco,tecnica);
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
        boolean ok = academia.cambiarHorarioCurso(curso.getNombreCurso(), nuevoHorario);
        if (!ok) {
            System.out.println("No se pudo cambiar el horario para el curso: " + curso.getNombreCurso());
        }
    }

    @Override
    public boolean validarHorario(Curso curso, Horario horario) {
        return false;
    }


    @Override
    public void generarReporte(Curso curso) {
        if (curso == null) {
            System.out.println("Error: curso nulo.");
            return;
        }

        curso.generarReporte();
    }


    public boolean crearAula(String nombre, int capacidad, Double estado) {
        return academia.crearAula(nombre, capacidad,estado);
    }

    public boolean eliminarAula(String nombre) {
        return academia.eliminarAula(nombre);
    }

    public boolean actualizarAula(String nombre, int capacidad, Double estado) {
        return academia.actualizarAula(nombre, capacidad, estado);
    }

    public Aula obtenerAula(String nombre) {
        return academia.obtenerAula(nombre);
    }

    public boolean validarPrerequisitos(Estudiante est, Curso curso) {
        if (est == null || curso == null) return false;
        if (curso.getNivel() == Nivel.PRINCIPIANTE) return true;
        if (curso.getNivel() == Nivel.BASICO) {
            return est.getCursosInscritos().stream()
                    .anyMatch(c -> c.getNivel() == Nivel.PRINCIPIANTE);
        }
        if (curso.getNivel() == Nivel.MEDIO) {
            return est.getCursosInscritos().stream()
                    .anyMatch(c -> c.getNivel() == Nivel.BASICO);
        }
        if (curso.getNivel() == Nivel.ALTO) {
            return est.getCursosInscritos().stream()
                    .anyMatch(c -> c.getNivel() == Nivel.MEDIO);
        }
        return false;
    }

    public boolean resolverConflictoHorario(Curso c1, Curso c2) {
        if (c1 == null || c2 == null) return false;
        if (c1.getAula() == null || c2.getAula() == null) return false;
        if (!c1.getHorario().equals(c2.getHorario())) return false;
        if (!c1.getAula().equals(c2.getAula())) return false;
        Curso mover = (c1.getCupo() <= c2.getCupo()) ? c1 : c2;
        Horario horarioActual = mover.getHorario();
        Aula aulaActual = mover.getAula();
        for (Horario candidate : Horario.values()) {
            if (candidate.equals(horarioActual)) continue;
            boolean aulaLibre = true;
            boolean profLibre = true;
            for (Curso other : academia.getListCursos()) {
                if (other == mover) continue;
                if (other.getAula() != null && other.getAula().equals(aulaActual)
                        && other.getHorario().equals(candidate)) {
                    aulaLibre = false;
                    break;
                }
            }
            if (!aulaLibre) continue;
            if (mover.getProfesor() != null) {
                for (Curso other : academia.getListCursos()) {
                    if (other == mover) continue;
                    if (other.getProfesor() != null && other.getProfesor().equals(mover.getProfesor())
                            && other.getHorario().equals(candidate)) {
                        profLibre = false;
                        break;
                    }
                }
            }
            if (!profLibre) continue;
            boolean ok = academia.cambiarHorarioCurso(mover.getNombreCurso(), candidate);
            if (ok) return true;

        }
        for (Aula otraAula : academia.getListAulas()) {
            if (otraAula.equals(aulaActual)) continue;
            if (otraAula.capacidad() < mover.getCupo()) continue;

            boolean ocupada = false;
            for (Curso other : academia.getListCursos()) {
                if (other == mover) continue;
                if (other.getAula() != null && other.getAula().equals(otraAula)
                        && other.getHorario().equals(horarioActual)) {
                    ocupada = true;
                    break;
                }
            }
            if (ocupada) continue;

            boolean okAsign = academia.asignarAulaACurso(mover.getNombreCurso(), otraAula);
            if (okAsign) return true;
        }
        return false;
    }






}
