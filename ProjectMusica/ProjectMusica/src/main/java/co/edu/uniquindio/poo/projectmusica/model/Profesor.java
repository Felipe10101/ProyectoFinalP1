package co.edu.uniquindio.poo.projectmusica.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Profesor implements IEvaluable, IHorarioGestionable {

    private String nombre, id, telefono;
    private int edad;
    private Horario horario;
    private Academia academia;

    public Profesor(String nombre, String id, String telefono, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getId(){ return id; }
    public void setId(String id) { this.id = id; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public Academia getAcademia() { return academia; }
    public void setAcademia(Academia academia) { this.academia = academia; }


    @Override
    public void gestionHorarios(Curso curso, Horario horario) {
        System.out.println("Permiso denegado: los profesores no pueden cambiar horarios directamente.");
    }

    @Override
    public boolean validarHorario(Curso curso, Horario horario) {
        return false;
    }

    @Override
    public boolean registrarProgreso(Curso curso, String descripcion, double nota) {

        if (curso == null) return false;
        if (nota < 0 || nota > 5) {
            System.out.println("Error: la nota debe estar entre 0 y 5.");
            return false;
        }

        ReporteProgreso reporte = new ReporteProgreso(descripcion, nota, LocalDate.now());
        curso.getListReportes().add(reporte);

        System.out.println("✔ Progreso registrado en curso: " + curso.getNombreCurso());
        return true;
    }

    @Override
    public LinkedList<ReporteProgreso> consultarProgreso(Curso curso) {
        if (curso == null) return new LinkedList<>();
        return curso.getListReportes();
    }

    @Override
    public String crearComentario(String comentario, double nota, LocalDate fecha, Curso curso) {

        ReporteProgreso reporte = new ReporteProgreso(comentario, nota, fecha);

        System.out.println("\n==== REPORTE DE PROGRESO ====");
        System.out.println("Profesor: " + nombre);
        System.out.println("Curso: " + curso.getNombreCurso());
        System.out.println("Nivel: " + curso.getNivel());
        System.out.println("Tipo de clase: " + curso.getTipoClase());
        System.out.println("------------------------------");
        System.out.println("Comentario: " + comentario);
        System.out.println("Nota: " + nota);
        System.out.println("Fecha: " + fecha);

        System.out.println("\n--- Detalles del curso ---");

        if (curso instanceof Piano piano) {
            System.out.println("Tipo de piano: " + piano.getTipoPiano());
            System.out.println("Marca: " + piano.getMarca());
            System.out.println("¿Requiere pedales?: " + (piano.isRequierePedales() ? "Sí" : "No"));
        }
        else if (curso instanceof Guitarra guitarra) {
            System.out.println("Tipo de cuerda: " + guitarra.getTipoCuerda());
            System.out.println("Afinación: " + guitarra.getAfinacion());
            System.out.println("Número de cuerdas: " + guitarra.getCuerdas());
        }
        else if (curso instanceof Violin violin) {
            System.out.println("Tamaño: " + violin.getTamanio());
            System.out.println("Arco: " + violin.getArco());
            System.out.println("Técnica: " + violin.getTecnica());
        }
        else if (curso instanceof Canto canto) {
            System.out.println("Tipo de voz: " + canto.getTipoVoz());
            System.out.println("Género musical: " + canto.getGeneroMusical());
        }

        System.out.println("==============================\n");

        return comentario;
    }

    @Override
    public boolean registrarAsistencia(Curso curso, Estudiante estudiante, boolean presente, Profesor profesor) {

        if (curso == null || estudiante == null) {
            System.out.println("Error: curso o estudiante es null.");
            return false;
        }
        if (curso.getProfesor() == null || !curso.getProfesor().equals(this)) {
            System.out.println("Error: este profesor no está asignado al curso.");
            return false;
        }
        if (!curso.verificarEstudianteCurso(estudiante.getId())) {
            System.out.println("Error: el estudiante no pertenece al curso.");
            return false;
        }
        Asistencia asistencia = new Asistencia(LocalDate.now(), presente);
        curso.getListAsistencias().add(asistencia);

        System.out.println("Asistencia registrada para: " + estudiante.getNombre());
        return true;
    }

    @Override
    public boolean valorarProgreso(Curso curso, Estudiante estudiante, double nota, String mensaje) {

        if (curso == null || estudiante == null) return false;

        if (nota < 0 || nota > 5) {
            System.out.println("Error: nota fuera de rango.");
            return false;
        }

        ReporteProgreso finalReport = new ReporteProgreso(mensaje, nota, LocalDate.now());
        curso.getListReportes().add(finalReport);

        System.out.println("Valoración final registrada para " + estudiante.getNombre());
        return true;
    }

    public LinkedList<Horario> gestionarHorarioDisponible() {
        LinkedList<Horario> disponibles = new LinkedList<>();

        if (academia == null) return disponibles;

        for (Curso c : academia.getListCursos()) {
            if (c.getProfesor() == null || !c.getProfesor().getId().equals(this.id)) {
                disponibles.add(c.getHorario());
            }
        }

        return disponibles;
    }

    public boolean definirHorario(Curso curso, Horario nuevoHorario) {
        if (curso == null || nuevoHorario == null) return false;
        for (Curso c : academia.getListCursos()) {
            if (c != curso && c.getProfesor() != null && c.getProfesor().equals(this)) {
                if (c.getHorario().equals(nuevoHorario)) {
                    return false;
                }
            }
        }
        if (curso.getAula() != null) {
            Aula aula = curso.getAula();
            for (Curso c : academia.getListCursos()) {
                if (c != curso && aula.equals(c.getAula()) && c.getHorario().equals(nuevoHorario)) {
                    return false;
                }
            }
        }

        curso.setHorario(nuevoHorario);
        return true;
    }


}
