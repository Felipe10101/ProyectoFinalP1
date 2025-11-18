package co.edu.uniquindio.poo.projectmusica.Test;

import co.edu.uniquindio.poo.projectmusica.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class CursoTest {

    private Estudiante crearEst(String id) {
        return new Estudiante("Est" + id, id, "123", 20);
    }

    private Curso crearCursoDemo() {
        return new Piano(
                "CursoPiano",
                Horario.MANIANA,
                Nivel.BASICO,
                TipoClase.GRUPAL,
                3,
                "acústico",
                "Yamaha",
                true
        );
    }

    @Test
    public void testValidarConflictoHorario() {
        Curso c1 = crearCursoDemo();
        Curso c2 = new Piano(
                "Otro",
                Horario.MANIANA,
                Nivel.PRINCIPIANTE,
                TipoClase.GRUPAL,
                2,
                "digital",
                "Casio",
                false
        );

        assertTrue(c1.validarConflictoHorario(c2));

        c2.setHorario(Horario.NOCHE);
        assertFalse(c1.validarConflictoHorario(c2));
    }


    @Test
    public void testListarAsistencia() {
        Curso c = crearCursoDemo();

        assertFalse(c.listarAsistencia());


        c.getListAsistencias().add(
                new Asistencia(LocalDate.of(2025, 1, 10), true)
        );

        assertTrue(c.listarAsistencia());
    }

    @Test
    public void testAgregarEstudianteCurso() {
        Curso c = crearCursoDemo();

        Estudiante e1 = crearEst("1");
        Estudiante e2 = crearEst("2");
        Estudiante e3 = crearEst("3");

        assertTrue(c.agregarEstudianteCurso(e1, TipoClase.GRUPAL));
        assertTrue(c.agregarEstudianteCurso(e2, TipoClase.GRUPAL));
        assertTrue(c.agregarEstudianteCurso(e3, TipoClase.GRUPAL));

        Estudiante extra = crearEst("4");
        assertFalse(c.agregarEstudianteCurso(extra, TipoClase.GRUPAL));
    }

    @Test
    public void testEliminarEstudianteCurso() {
        Curso c = crearCursoDemo();
        Estudiante e = crearEst("1");

        c.agregarEstudianteCurso(e, TipoClase.GRUPAL);

        assertTrue(c.eliminarEstudianteCurso("1"));
        assertFalse(c.verificarEstudianteCurso("1"));
        assertFalse(c.eliminarEstudianteCurso("10"));
    }


    @Test
    public void testActualizarEstudianteCurso() {
        Curso c = crearCursoDemo();
        Estudiante e = crearEst("1");
        c.agregarEstudianteCurso(e, TipoClase.GRUPAL);

        Estudiante nuevo = new Estudiante("Nuevo", "1", "555", 30);

        assertTrue(c.actualizarEstudianteCurso("1", nuevo));

        assertEquals("Nuevo", c.getListEstudiantesCurso().get(0).getNombre());
        assertEquals("555", c.getListEstudiantesCurso().get(0).getTelefono());
        assertEquals(30, c.getListEstudiantesCurso().get(0).getEdad());

        assertFalse(c.actualizarEstudianteCurso("999", nuevo));
    }

    @Test
    public void testVerificarEstudianteCurso() {
        Curso c = crearCursoDemo();
        Estudiante e = crearEst("1");

        c.agregarEstudianteCurso(e, TipoClase.GRUPAL);

        assertTrue(c.verificarEstudianteCurso("1"));
        assertFalse(c.verificarEstudianteCurso("5"));
    }


    @Test
    public void testValidarInscripcion() {
        Curso c = crearCursoDemo();

        Estudiante e1 = crearEst("1");
        Estudiante e2 = crearEst("2");
        Estudiante e3 = crearEst("3");

        assertTrue(c.validarInscripcion(e1, c));
        c.agregarEstudianteCurso(e1, TipoClase.GRUPAL);

        assertFalse(c.validarInscripcion(e1, c));

        c.agregarEstudianteCurso(e2, TipoClase.GRUPAL);
        c.agregarEstudianteCurso(e3, TipoClase.GRUPAL);

        Estudiante extra = crearEst("4");
        assertFalse(c.validarInscripcion(extra, c));
    }


    @Test
    public void testAsignarProfesor() {
        Curso c = crearCursoDemo();

        Profesor p = new Profesor("Luis", "20", "999", 30);

        c.asignarProfesor(p);

        assertEquals("Luis", c.getProfesor().getNombre());
    }


    @Test
    public void testAsignarAula() {
        Curso c = crearCursoDemo();

        Aula aula = new Aula("A1", 20, 1.0);

        c.asignarAula(aula);

        assertEquals("A1", c.getAula().nombre());
    }
}

