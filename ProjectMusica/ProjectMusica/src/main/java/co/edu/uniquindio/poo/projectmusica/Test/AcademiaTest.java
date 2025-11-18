package co.edu.uniquindio.poo.projectmusica.Test;

import co.edu.uniquindio.poo.projectmusica.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AcademiaTest {

    private Academia academia;

    @BeforeEach
    public void setup() {
        academia = new Academia("UQ", "1");
    }


    @Test
    public void testAgregarEstudiante() {
        Estudiante e = new Estudiante("Ana", "10", "111", 18);
        assertTrue(academia.agregarEstudiante(e));
        assertTrue(academia.verificarEstudiante("10"));
    }

    @Test
    public void testAgregarEstudianteDuplicado() {
        Estudiante e = new Estudiante("Ana", "10", "111", 18);
        academia.agregarEstudiante(e);

        assertFalse(academia.agregarEstudiante(e));
    }

    @Test
    public void testEliminarEstudiante() {
        Estudiante e = new Estudiante("Ana", "10", "111", 18);
        academia.agregarEstudiante(e);

        assertTrue(academia.eliminarEstudiante("10"));
        assertFalse(academia.verificarEstudiante("10"));
    }

    @Test
    public void testActualizarEstudiante() {
        academia.agregarEstudiante(new Estudiante("Ana", "10", "111", 18));

        Estudiante actualizado = new Estudiante("Ana María", "10", "999", 20);

        assertTrue(academia.actualizarEstudiante("10", actualizado));
        assertEquals("Ana María", academia.obtenerEstudiante("10").getNombre());
        assertEquals("999", academia.obtenerEstudiante("10").getTelefono());
    }


    @Test
    public void testAgregarProfesor() {
        Profesor p = new Profesor("Luis", "20", "333", 30);

        assertTrue(academia.agregarProfesor(p));
        assertTrue(academia.verificarProfesor("20"));
    }

    @Test
    public void testEliminarProfesor() {
        Profesor p = new Profesor("Luis", "20", "333", 30);
        academia.agregarProfesor(p);

        assertTrue(academia.eliminarProfesor("20"));
    }

    @Test
    public void testActualizarProfesor() {
        academia.agregarProfesor(new Profesor("Luis", "20", "333", 30));

        Profesor actualizado = new Profesor("Luis Miguel", "20", "888", 40);

        assertTrue(academia.actualizarProfesor("20", actualizado));
        assertEquals("Luis Miguel", academia.obtenerProfesor("20").getNombre());
    }


    @Test
    public void testCrearCursoPiano() {
        Curso c = academia.crearCursoPiano(
                "Piano1",
                Horario.MANIANA,
                Nivel.BASICO,
                TipoClase.GRUPAL,
                10,
                "Acústico",
                "Yamaha",
                true
        );

        assertNotNull(c);
        assertTrue(academia.verificarCurso("Piano1"));
    }

    @Test
    public void testEliminarCurso() {
        academia.crearCursoPiano("Piano1", Horario.TARDE, Nivel.BASICO, TipoClase.GRUPAL, 10,
                "Acústico", "Yamaha", true);

        assertTrue(academia.eliminarCurso("Piano1"));
        assertFalse(academia.verificarCurso("Piano1"));
    }

    @Test
    public void testActualizarCurso() {
        academia.crearCursoPiano("Piano1", Horario.TARDE, Nivel.BASICO, TipoClase.GRUPAL, 10,
                "Acústico", "Yamaha", true);

        Curso actualizado = new Piano("Piano1", Horario.NOCHE, Nivel.MEDIO, TipoClase.GRUPAL, 10,
                "Acústico", "Yamaha", true);

        assertTrue(academia.actualizarCurso("Piano1", actualizado));

        Curso c = academia.obtenerCurso("Piano1");

        assertEquals(Horario.NOCHE, c.getHorario());
        assertEquals(Nivel.MEDIO, c.getNivel());
    }


    @Test
    public void testCrearAula() {
        assertTrue(academia.crearAula("A1", 20, 1.0));
        assertNotNull(academia.obtenerAula("A1"));
    }

    @Test
    public void testCrearAulaDuplicada() {
        academia.crearAula("A1", 20, 1.0);
        assertFalse(academia.crearAula("A1", 15, 1.0));
    }

    @Test
    public void testEliminarAulaSinUso() {
        academia.crearAula("A1", 20, 1.0);
        assertTrue(academia.eliminarAula("A1"));
    }

    @Test
    public void testEliminarAulaAsignadaDebeFallar() {
        academia.crearAula("A1", 20, 1.0);

        Curso c = academia.crearCursoPiano(
                "Piano1",
                Horario.TARDE,
                Nivel.BASICO,
                TipoClase.GRUPAL,
                10,
                "acústico",
                "Yamaha",
                true
        );

        c.setAula(new Aula("A1", 20, 1.0));

        assertFalse(academia.eliminarAula("A1"));
    }

    @Test
    public void testActualizarAula() {
        academia.crearAula("A1", 20, 1.0);

        assertTrue(academia.actualizarAula("A1", 50, 0.9));
        assertEquals(50, academia.obtenerAula("A1").capacidad());
    }


    @Test
    public void testAgregarMatricula() {
        Matricula m = new Matricula("M1", LocalDate.now());
        assertTrue(academia.agregarMatricula(m));
        assertTrue(academia.verificarMatricula("M1"));
    }

    @Test
    public void testEliminarMatricula() {
        Matricula m = new Matricula("M1", LocalDate.now());
        academia.agregarMatricula(m);

        assertTrue(academia.eliminarMatricula("M1"));
    }

    @Test
    public void testActualizarMatricula() {
        academia.agregarMatricula(new Matricula("M1", LocalDate.now()));

        Matricula nueva = new Matricula("M1", LocalDate.of(2025, 1, 1));

        assertTrue(academia.actualizarMatricula("M1", nueva));
        assertEquals(LocalDate.of(2025, 1, 1), academia.obtenerMatricula("M1").getFecha());
    }


    @Test
    public void testAsignarProfesorACurso() {
        Profesor p = new Profesor("Luis", "20", "111", 33);
        academia.agregarProfesor(p);

        Curso c = academia.crearCursoPiano("Piano1", Horario.MANIANA, Nivel.BASICO,
                TipoClase.GRUPAL, 10, "a", "b", true);

        assertTrue(academia.asignarProfesorACurso("20", "Piano1"));
        assertEquals(p, c.getProfesor());
    }

    @Test
    public void testAsignarProfesorHorarioConflicto() {
        Profesor p = new Profesor("Luis", "20", "111", 33);
        academia.agregarProfesor(p);

        Curso c1 = academia.crearCursoPiano("Curso1", Horario.MANIANA, Nivel.BASICO,
                TipoClase.GRUPAL, 10, "a", "b", true);
        Curso c2 = academia.crearCursoPiano("Curso2", Horario.MANIANA, Nivel.BASICO,
                TipoClase.GRUPAL, 10, "a", "b", true);

        c1.setProfesor(p);

        assertFalse(academia.asignarProfesorACurso("20", "Curso2"));
    }


    @Test
    public void testCambiarHorarioCursoCorrecto() {
        Curso c = academia.crearCursoPiano("Piano1", Horario.MANIANA, Nivel.BASICO,
                TipoClase.GRUPAL, 10, "a", "b", true);

        assertTrue(academia.cambiarHorarioCurso("Piano1", Horario.TARDE));
        assertEquals(Horario.TARDE, c.getHorario());
    }

    @Test
    public void testCambiarHorarioProfesorOcupado() {
        Profesor p = new Profesor("Luis", "20", "111", 33);
        academia.agregarProfesor(p);

        Curso c1 = academia.crearCursoPiano("Curso1", Horario.TARDE, Nivel.BASICO, TipoClase.GRUPAL,
                10, "a", "b", true);
        Curso c2 = academia.crearCursoPiano("Curso2", Horario.MANIANA, Nivel.BASICO, TipoClase.GRUPAL,
                10, "a", "b", true);

        c1.setProfesor(p);
        c2.setProfesor(p);

        assertFalse(academia.cambiarHorarioCurso("Curso1", Horario.MANIANA));
    }


    @Test
    public void testMatricularEstudianteCorrecto() {
        Estudiante e = new Estudiante("Ana", "10", "111", 18);
        academia.agregarEstudiante(e);

        Curso c = academia.crearCursoPiano("Piano1", Horario.MANIANA, Nivel.BASICO,
                TipoClase.GRUPAL, 10, "a", "b", true);

        assertTrue(academia.matricularEstudiante("10", "Piano1"));
        assertTrue(c.verificarEstudianteCurso("10"));
    }

    @Test
    public void testMatricularCupoLleno() {
        academia.agregarEstudiante(new Estudiante("Ana", "10", "111", 18));
        academia.agregarEstudiante(new Estudiante("Luis", "20", "111", 22));

        Curso c = academia.crearCursoPiano("Piano1", Horario.MANIANA, Nivel.BASICO,
                TipoClase.GRUPAL, 1, "a", "b", true);

        academia.matricularEstudiante("10", "Piano1");

        assertFalse(academia.matricularEstudiante("20", "Piano1"));
    }

    @Test
    public void testMatricularHorarioConflicto() {
        Estudiante e = new Estudiante("Ana", "10", "111", 18);
        academia.agregarEstudiante(e);

        Curso c1 = academia.crearCursoPiano("Curso1", Horario.MANIANA, Nivel.BASICO,
                TipoClase.GRUPAL, 10, "a", "b", true);

        Curso c2 = academia.crearCursoPiano("Curso2", Horario.MANIANA, Nivel.BASICO,
                TipoClase.GRUPAL, 10, "a", "b", true);

        academia.matricularEstudiante("10", "Curso1");

        assertFalse(academia.matricularEstudiante("10", "Curso2"));
    }
}




