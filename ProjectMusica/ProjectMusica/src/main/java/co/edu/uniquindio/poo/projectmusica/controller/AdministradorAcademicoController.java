package co.edu.uniquindio.poo.projectmusica.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import co.edu.uniquindio.poo.projectmusica.model.*;
import java.util.List;

public class AdministradorAcademicoController {

        private final Academia academia;

        // inyecta la instancia de Academia (puedes crear una sola y pasarla a todos los controllers)
        public AdministradorAcademicoController(Academia academia) {
            this.academia = academia;
        }

        // --- ESTUDIANTES ---
        public boolean agregarEstudiante(Estudiante e) {
            return academia.agregarEstudiante(e);
        }

        public boolean eliminarEstudiante(String idEstudiante) {
            return academia.eliminarEstudiante(idEstudiante);
        }

        public boolean actualizarEstudiante(String id, Estudiante actualizado) {
            return academia.actualizarEstudiante(id, actualizado);
        }

        public List<Estudiante> listarEstudiantes() {
            return academia.getListEstudiantes();
        }

        // --- PROFESORES ---
        public boolean agregarProfesor(Profesor p) {
            return academia.agregarProfesor(p);
        }

        public boolean eliminarProfesor(String idProfesor) {
            return academia.eliminarProfesor(idProfesor);
        }

        public boolean actualizarProfesor(String id, Profesor actualizado) {
            return academia.actualizarProfesor(id, actualizado);
        }

        public List<Profesor> listarProfesores() {
            return academia.getListProfesores();
        }

        // --- CURSOS (creación delegada a Academia para cada instrumento) ---
        public Curso crearCursoPiano(String nombre, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel,
                                     String tipoPiano, String marcaPiano, boolean requierePedales) {
            return academia.crearCursoPiano(nombre, cupo, tipoClase, horario, nivel, tipoPiano, marcaPiano, requierePedales);
        }

        public Curso crearCursoGuitarra(String nombre, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel,
                                        String afinacion, String tipoCuerda, int cuerdas) {
            return academia.crearCursoGuitarra(nombre, cupo, tipoClase, horario, nivel, afinacion, tipoCuerda, cuerdas);
        }

        public Curso crearCursoCanto(String nombre, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel,
                                     String tipoVoz, String generoMusical) {
            return academia.crearCursoCanto(nombre, cupo, tipoClase, horario, nivel, tipoVoz, generoMusical);
        }

        public Curso crearCursoViolin(String nombre, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel,
                                      String tamanio, String arco, String tecnica) {
            return academia.crearCursoViolin(nombre, cupo, tipoClase, horario, nivel, tamanio, arco, tecnica);
        }

        public boolean eliminarCurso(String nombreCurso) {
            return academia.eliminarCurso(nombreCurso);
        }

        public boolean actualizarCurso(String nombreCurso, Curso actualizado) {
            return academia.actualizarCurso(nombreCurso, actualizado);
        }

        public List<Curso> listarCursos() {
            return academia.getListCursos();
        }

        // --- MATRICULAS ---
        public boolean agregarMatricula(Matricula m) {
            return academia.agregarMatricula(m);
        }

        public boolean eliminarMatricula(String id) {
            return academia.eliminarMatricula(id);
        }

        public boolean actualizarMatricula(String id, Matricula actualizado) {
            return academia.actualizarMatricula(id, actualizado);
        }

        public List<Matricula> listarMatriculas() {
            return academia.getListMatriculas();
        }

        // --- OPERACIONES COMUNES ---
        public boolean matricularEstudiante(String idEstudiante, String nombreCurso) {
            return academia.matricularEstudiante(idEstudiante, nombreCurso);
        }

        public boolean asignarProfesorACurso(String idProfesor, String nombreCurso) {
            return academia.asignarProfesorACurso(idProfesor, nombreCurso);
        }

        public boolean asignarAulaACurso(String nombreCurso, Aula aula) {
            return academia.asignarAulaACurso(nombreCurso, aula);
        }

        public boolean cambiarHorarioCurso(String nombreCurso, Horario nuevoHorario) {
            return academia.cambiarHorarioCurso(nombreCurso, nuevoHorario);
        }

        // getters utilitarios
        public Estudiante obtenerEstudiante(String id) { return academia.obtenerEstudiante(id); }
        public Profesor obtenerProfesor(String id) { return academia.obtenerProfesor(id); }
        public Curso obtenerCurso(String nombre) { return academia.obtenerCurso(nombre); }
        public Matricula obtenerMatricula(String id) { return academia.obtenerMatricula(id); }
    }
}