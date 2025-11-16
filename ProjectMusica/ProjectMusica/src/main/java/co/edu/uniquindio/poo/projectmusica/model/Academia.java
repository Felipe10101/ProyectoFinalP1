package co.edu.uniquindio.poo.projectmusica.model;
import java.util.LinkedList;
import co.edu.uniquindio.poo.projectmusica.model.*;

public class Academia {
    private String nombre, id;
    private LinkedList<Curso> ListCursos;
    private LinkedList<Estudiante> ListEstudiantes;
    private LinkedList<Profesor> ListProfesores;
    private LinkedList<AdministradorAcademico> ListAdministradores;
    private LinkedList<Matricula> ListMatriculas;

    public Academia(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.ListCursos = new LinkedList<>();
        this.ListEstudiantes= new LinkedList<>();
        this.ListProfesores= new LinkedList<>();
        this.ListAdministradores = new LinkedList<>();
        this.ListMatriculas = new LinkedList<>();
    }

    public String getNombreCurso() {
        return nombre;
    }

    public void setNombreCurso(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinkedList<Estudiante> getListEstudiantes() {
        return ListEstudiantes;
    }

    public LinkedList<Profesor> getListProfesores() {
        return ListProfesores;
    }

    public LinkedList<Curso> getListCursos() {
        return ListCursos;
    }

    public LinkedList<Matricula> getListMatriculas() {
        return ListMatriculas;
    }


    // CRUD ESTUDIANTE

    public boolean agregarEstudiante(Estudiante Estudiante) {
        boolean centinela = false;
        if (!verificarEstudiante(Estudiante.getId())) {
            ListEstudiantes.add(Estudiante);
            centinela = true;
        }
        return centinela;
    }
    public boolean eliminarEstudiante (String id) {
        boolean centinela = false;
        for (Estudiante Estudiante : ListEstudiantes) {
            if (Estudiante.getId().equals(id)) {
                ListEstudiantes.remove(Estudiante);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean actualizarEstudiante(String Id, Estudiante actualizado) {
        boolean centinela = false;
        for (Estudiante Estudiante : ListEstudiantes) {
            if (Estudiante.getId().equals(Id)) {
                Estudiante.setNombre(actualizado.getNombre());
                Estudiante.setTelefono(actualizado.getTelefono());
                Estudiante.setEdad(actualizado.getEdad());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarEstudiante(String Id) {
        boolean centinela = false;
        for (Estudiante Estudiante : ListEstudiantes) {
            if (Estudiante.getId().equals(Id)) {
                centinela = true;
            }
        }
        return centinela;
    }

    // CRUD PROFESORES

    public boolean agregarProfesor(Profesor Profesor) {
        boolean centinela = false;
        if (!verificarProfesor(Profesor.getId())) {
            ListProfesores.add(Profesor);
            centinela = true;
        }
        return centinela;
    }
    public boolean eliminarProfesor (String cedula) {
        boolean centinela = false;
        for (Profesor Profesor : ListProfesores) {
            if (Profesor.getId().equals(cedula)) {
                ListProfesores.remove(Profesor);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean actualizarProfesor(String Id, Profesor actualizado) {
        boolean centinela = false;
        for (Profesor Profesor : ListProfesores) {
            if (Profesor.getId().equals(Id)) {
                Profesor.setNombre(actualizado.getNombre());
                Profesor.setTelefono(actualizado.getTelefono());
                Profesor.setEdad(actualizado.getEdad());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarProfesor(String Id) {
        boolean centinela = false;
        for (Profesor Profesor : ListProfesores) {
            if (Profesor.getId().equals(Id)) {
                centinela = true;
            }
        }
        return centinela;
    }

    // CRUD CURSO

    public Curso crearCursoPiano(String nombre, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel,
                                 String tipoPiano, String marcaPiano, boolean requierePedales) {

        Curso curso = new Piano(nombre, cupo, tipoClase, horario, nivel,
                tipoPiano, marcaPiano, requierePedales);

        ListCursos.add(curso);
        return curso;
    }
    public Curso crearCursoGuitarra(String nombre, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel,
                                    String afinacion, String tipoCuerda, int cuerdas) {

        Curso curso = new Guitarra(nombre, cupo, tipoClase, horario, nivel,
                afinacion, tipoCuerda, cuerdas);

        ListCursos.add(curso);
        return curso;
    }
    public Curso crearCursoCanto(String nombre, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel,
                                 String tipoVoz, String generoMusical) {

        Curso curso = new Canto(nombre, cupo, tipoClase, horario, nivel,
                tipoVoz, generoMusical);

        ListCursos.add(curso);
        return curso;
    }
    public Curso crearCursoViolin(String nombre, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel,
                                  String tamanio, String arco, String tecnica) {

        Curso curso = new Violin(nombre, cupo, tipoClase, horario, nivel,
                tamanio, arco, tecnica);

        ListCursos.add(curso);
        return curso;
    }

    public boolean eliminarCurso (String nombre) {
        boolean centinela = false;
        for (Curso Curso : ListCursos) {
            if (Curso.getnombreCurso().equals(nombre)) {
                ListCursos.remove(Curso);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean actualizarCurso(String nombre,Curso actualizado) {
        boolean centinela = false;
        for (Curso Curso : ListCursos) {
            if (Curso.getnombreCurso().equals(nombre)) {
                Curso.setHorario(actualizado.getHorario());
                Curso.setNivel(actualizado.getNivel());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarCurso(String Nombre) {
        boolean centinela = false;
        for (Curso Curso : ListCursos) {
            if (Curso.getnombreCurso().equals(Nombre)) {
                centinela = true;
            }
        }
        return centinela;
    }

// CRUD ADMINISTRADOR ACADEMICO

    public boolean agregarAdministradorAcademico(AdministradorAcademico AdministradorAcademico) {
        boolean centinela = false;
        if (!verificarAdministradorAcademico(AdministradorAcademico.getId())) {
            ListAdministradores.add(AdministradorAcademico);
            centinela = true;
        }
        return centinela;
    }
    public boolean eliminarAdministradorAcademico (String Id) {
        boolean centinela = false;
        for (AdministradorAcademico AdministradorAcademico : ListAdministradores) {
            if (AdministradorAcademico.getId().equals(Id)) {
                ListAdministradores.remove(AdministradorAcademico);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean actualizarAdministradorAcademico(String Id, AdministradorAcademico actualizado) {
        boolean centinela = false;
        for (AdministradorAcademico AdministradorAcademico : ListAdministradores) {
            if (AdministradorAcademico.getId().equals(Id)) {
                AdministradorAcademico.setUsuario(actualizado.getUsuario());
                AdministradorAcademico.setPassword(actualizado.getPassword());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarAdministradorAcademico(String Id) {
        boolean centinela = false;
        for (AdministradorAcademico AdministradorAcademico : ListAdministradores) {
            if (AdministradorAcademico.getId().equals(Id)) {
                centinela = true;
            }
        }
        return centinela;
    }

    //CRUD MATRICULA

    public boolean agregarMatricula(Matricula matricula){
        boolean centinela = false;
        if (!verificarMatricula(matricula.getId())){
            ListMatriculas.add(matricula);
            centinela = true;
        }
        return centinela;


    }
    public boolean eliminarMatricula(String Id){
        boolean centinela = false;
        for (Matricula matricula : ListMatriculas){
            if (matricula.getId().equals(Id)){
            ListMatriculas.remove(matricula);
            centinela = true;
            break;
            }
        }
        return centinela;
    }
    public boolean actualizarMatricula(String Id, Matricula actualizado){
        boolean centinela = false;
        for (Matricula Matricula : ListMatriculas){
            if ( Matricula.getId().equals(Id)){
                Matricula.setFecha(actualizado.getFecha());
                    centinela = true;
                    break ;
            }
        }
        return centinela;
    }
    public boolean verificarMatricula(String Id) {
        boolean centinela = false;
        for (Matricula Matricula : ListMatriculas) {
            if (Matricula.getId().equals(Id)) {
                centinela = true;
            }
        }
        return centinela;
    }

    // ASIGNAR CURSO

    public boolean asignarAulaACurso(String nombreCurso, Aula aula) {
        Curso curso = null;
        for (Curso c : ListCursos) {
            if (c.getnombreCurso().equals(nombreCurso)) {
                curso = c;
                break;
            }
        }
        if (curso == null) {
            System.out.println("Error: el curso no existe.");
            return false;
        }
        if (curso.getCupo() > aula.capacidad()) {
            System.out.println("Error: el aula no tiene capacidad suficiente.");
            return false;
        }
        for (Curso c : ListCursos) {
            if (c.getAula() != null && c.getAula().equals(aula)) {
                if (c.getHorario().equals(curso.getHorario())) {
                    System.out.println("Error: el aula ya está ocupada en ese horario.");
                    return false;
                }
            }
        }
        Profesor profesor = curso.getProfesor();
        for (Curso c : ListCursos) {
            if (c != curso && c.getProfesor().equals(profesor)) {
                if (c.getHorario().equals(curso.getHorario())){
                    System.out.println("Error: el profesor ya dicta otro curso en ese horario.");
                    return false;
                }
            }
        }
        curso.setAula(aula);
        System.out.println("Aula asignada correctamente.");
        return true;
    }

 public boolean cambiarHorarioCurso(String nombreCurso, Horario nuevoHorario) {
     Curso curso = null;
     for (Curso c : ListCursos) {
         if (c.getnombreCurso().equals(nombreCurso)) {
             curso = c;
             break;
         }
     }
     if (curso == null) {
         System.out.println("Error: el curso no existe.");
         return false;
     }
     Profesor profesor = curso.getProfesor();
     for (Curso c : ListCursos) {
         if (c != curso && c.getProfesor() != null && c.getProfesor().equals(profesor)) {
             if (c.getHorario().equals(nuevoHorario)) {
                 System.out.println("Error: el profesor ya tiene un curso en ese horario (" + nuevoHorario + ").");
                 return false;
             }
         }
     }
     if (curso.getAula() != null) {
         Aula aula = curso.getAula();
         for (Curso c : ListCursos) {
             if (c != curso && c.getAula() != null && c.getAula().equals(aula)) {
                 if (c.getHorario().equals(nuevoHorario)) {
                     System.out.println("Error: el aula ya está ocupada en ese horario (" + nuevoHorario + ").");
                     return false;
                 }
             }
         }
     }
     curso.setHorario(nuevoHorario);
     System.out.println("✔ Horario actualizado correctamente para el curso: " + nombreCurso + " -> " + nuevoHorario);
     return true;
 }

    public Estudiante obtenerEstudiante(String id) {
        for (Estudiante e : ListEstudiantes) {
            if (e.getId().equals(id)) return e;
        }
        return null;
    }

    public Profesor obtenerProfesor(String id) {
        for (Profesor p : ListProfesores) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public Curso obtenerCurso(String nombre) {
        for (Curso c : ListCursos) {
            if (c.getnombreCurso().equals(nombre)) return c;
        }
        return null;
    }

    public AdministradorAcademico obtenerAdmin(String id) {
        for (AdministradorAcademico a : ListAdministradores) {
            if (a.getId().equals(id)) return a;
        }
        return null;
    }

    public Matricula obtenerMatricula(String id) {
        for (Matricula m : ListMatriculas) {
            if (m.getId().equals(id)) return m;
        }
        return null;
    }

    public boolean matricularEstudiante(String idEstudiante, String nombreCurso){
        Estudiante est = obtenerEstudiante(idEstudiante);
        if (est == null) {
            System.out.println("Error: el estudiante no existe.");
            return false;
        }
        Curso curso = obtenerCurso(nombreCurso);
        if (curso == null) {
            System.out.println("Error: el curso no existe.");
            return false;
        }
        if (curso.verificarEstudianteCurso(est.getId())) {
            System.out.println("Error: el estudiante ya está inscrito en este curso.");
            return false;
        }
        if (curso.getTipoClase() == TipoClase.GRUPAL) {
            if (curso.getListEstudiantesCurso().size() >= curso.getCupo()) {
                System.out.println("Error: no hay cupos disponibles en este curso.");
                return false;
            }
        } else {
            if (curso.getListEstudiantesCurso().size() >= 1) {
                System.out.println("Error: este curso individual ya tiene asignado un estudiante.");
                return false;
            }
        }
        for (Curso c : ListCursos) {
            if (c.getListEstudiantesCurso().contains(est)) {
                if (c.getHorario().equals(curso.getHorario())) {
                    System.out.println("Error: el estudiante tiene otro curso en el mismo horario (" + curso.getHorario() + ").");
                    return false;
                }
            }
        }
        boolean agregado = curso.agregarEstudianteCurso(est, curso.getTipoClase());

        if (!agregado) {
            System.out.println("Error: no se pudo agregar el estudiante (reglas internas del curso).");
            return false;
        }
        System.out.println("Estudiante matriculado correctamente en " + curso.getnombreCurso());
        return true;
    }

    public boolean asignarProfesorACurso(String idProfesor, String nombreCurso) {

        Profesor profesor = obtenerProfesor(idProfesor);
        if (profesor == null) {
            System.out.println("Error: el profesor no existe.");
            return false;
        }

        Curso curso = obtenerCurso(nombreCurso);
        if (curso == null) {
            System.out.println("Error: el curso no existe.");
            return false;
        }

        if (curso.getProfesor() != null) {
            System.out.println(" Error: el curso ya tiene un profesor asignado.");
            return false;
        }

        for (Curso c : ListCursos) {
            if (c != curso && c.getProfesor() != null && c.getProfesor().getId().equals(idProfesor)) {
                if (c.getHorario().equals(curso.getHorario())) {
                    System.out.println("Error: el profesor ya dicta otro curso en el mismo horario.");
                    return false;
                }
            }
        }
        curso.setProfesor(profesor);
        System.out.println("✔ Profesor asignado correctamente al curso: " + nombreCurso);
        return true;
    }

}

