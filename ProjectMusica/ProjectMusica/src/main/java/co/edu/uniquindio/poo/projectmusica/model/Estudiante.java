package co.edu.uniquindio.poo.projectmusica.model;

import java.util.LinkedList;

public class Estudiante implements IInscribible {

    private String nombre, id, telefono;
    private int edad;
    private Academia academia;
    private LinkedList<Curso> cursosInscritos;

    public Estudiante(String nombre, String id, String telefono, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.edad = edad;
        this.cursosInscritos = new LinkedList<>();
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    public Academia getAcademia() {
        return academia;
    }

    @Override
    public Curso inscripcionCurso(Curso curso) {

        if (academia == null) {
            System.out.println("✘ Error: el estudiante no pertenece a ninguna academia.");
            return null;
        }

        if (cursosInscritos.contains(curso)) {
            System.out.println("✘ Ya estás inscrito en este curso.");
            return null;
        }

        if (!validarPrerequisitos(curso)) {
            return null;
        }
        boolean ok = academia.matricularEstudiante(this.getId(), curso.getNombreCurso());

        if (ok) {
            cursosInscritos.add(curso);
            System.out.println("✔ Estudiante inscrito correctamente a " + curso.getNombreCurso());
            return curso;
        } else {
            System.out.println("✘ No se pudo inscribir al curso.");
            return null;
        }
    }



    @Override
    public void cancelacionCurso(Curso curso) {

        if (academia == null) {
            System.out.println("✘ Error: el estudiante no está asociado a ninguna academia.");
            return;
        }

        if (!cursosInscritos.contains(curso)) {
            System.out.println("✘ No estás inscrito en este curso.");
            return;
        }

        boolean ok = curso.eliminarEstudianteCurso(this.getId());

        if (ok) {
            cursosInscritos.remove(curso);
            System.out.println("✔ Curso cancelado correctamente: " + curso.getNombreCurso());
        } else {
            System.out.println("✘ No se pudo cancelar el curso.");
        }
    }

    public boolean validarPrerequisitos(Curso curso) {

        Nivel nivelCurso = curso.getNivel();

        switch (nivelCurso) {

            case PRINCIPIANTE:
                return true; // No requiere nada

            case BASICO:
                return validarNivelPrevio(Nivel.PRINCIPIANTE, "básico");

            case MEDIO:
                return validarNivelPrevio(Nivel.BASICO, "medio");

            case ALTO:
                return validarNivelPrevio(Nivel.MEDIO, "avanzado");
        }

        return true;
    }

    private boolean validarNivelPrevio(Nivel nivelRequerido, String nombreNivel) {

        boolean tieneNivelPrevio = cursosInscritos.stream()
                .anyMatch(c -> c.getNivel() == nivelRequerido);

        if (!tieneNivelPrevio) {
            System.out.println("✘ No cumple los prerrequisitos para un curso " + nombreNivel
                    + ". Requiere nivel " + nivelRequerido);
            return false;
        }

        return true;
    }

    public void consultarHorario() {

        if (cursosInscritos.isEmpty()) {
            System.out.println("No tiene cursos inscritos.");
            return;
        }

        System.out.println("=== HORARIO DEL ESTUDIANTE ===");
        for (Curso c : cursosInscritos) {
            System.out.println(c.getNombreCurso() + " - " + c.getHorario());
        }
    }

    public void descargarReporte(Curso curso) {

        System.out.println("=== REPORTE DE PROGRESO ===");
        for (ReporteProgreso r : curso.getListReportes()) {
            System.out.println(r.fecha() + " | Nota: " + r.nota() + " | " + r.comentario());
        }
    }

    public void solicitarClaseIndividual(Profesor profesor) {
        System.out.println("Solicitud de clase individual enviada al profesor: " + profesor.getNombre());
    }

    public void listarCursosDisponibles() {

        if (academia == null) {
            System.out.println("✘ El estudiante no está asociado a una academia.");
            return;
        }

        System.out.println("=== CURSOS DISPONIBLES EN LA ACADEMIA ===");

        for (Curso c : academia.getListCursos()) {
            System.out.println("- " + c.getNombreCurso() +
                    " | Nivel: " + c.getNivel() +
                    " | Tipo: " + c.getTipoClase() +
                    " | Cupo: " + c.getCupo());
        }
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public LinkedList<Curso> getCursosInscritos() { return cursosInscritos; }
}
