package co.edu.uniquindio.poo.projectmusica.Test;

import co.edu.uniquindio.poo.projectmusica.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class ProfesorTest {

    private Profesor profesor;
    private Academia academia;
    private Curso curso;
    private Estudiante estudiante;

    @BeforeEach
    public void setup() {
        profesor = new Profesor("Mario", "P1", "123", 40);
        academia = new Academia("UQ", "1");
        estudiante = new Estudiante("Ana", "E1", "555", 20);

        curso = new Piano(
                "CursoPiano",
                Horario.MANIANA,
                Nivel.BASICO,
                TipoClase.GRUPAL,
                10,
                "acústico",
                "Yamaha",
                true
        );

        curso.setProfesor(profesor);
        curso.setAula(new Aula("A1", 20, 1.0));

        academia.getListCursos().add(curso);
        estudiante.setAcademia(academia);
    }


    @Test
    public void testValidarHorarioSinConflicto() {
        boolean ok = profesor.validarHorario(curso, Horario.TARDE);
        assertTrue(ok);
    }

    @Test
    public void testValidarHorarioConConflicto() {
        Curso otro = new Piano(
                "Piano2",
                Horario.TARDE,
                Nivel.BASICO,
                TipoClase.GRUPAL,
                10,
                "acústico",
                "Casio",
                false
        );

        otro.setProfesor(profesor);
        academia.getListCursos().add(otro);

        assertFalse(profesor.validarHorario(curso, Horario.TARDE));
    }


    @Test
    public void testRegistrarProgresoCorrecto() {
        assertTrue(profesor.registrarProgreso(curso, "Mejoró técnica", 4.5));
        assertEquals(1, curso.getListReportes().size());
    }

    @Test
    public void testRegistrarProgresoNotaInvalida() {
        assertFalse(profesor.registrarProgreso(curso, "Error", 8.0));
        assertEquals(0, curso.getListReportes().size());
    }

    @Test
    public void testCrearComentarioGuardaReporte() {
        profesor.crearComentario("Avanza bien", 4.0, LocalDate.now(), curso);

        assertEquals(1, curso.getListReportes().size());
        assertEquals("Avanza bien", curso.getListReportes().get(0).comentario());
    }

    @Test
    public void testRegistrarAsistenciaCorrecta() {
        curso.agregarEstudianteCurso(estudiante, TipoClase.GRUPAL);

        assertTrue(profesor.registrarAsistencia(curso, estudiante, true, profesor));
        assertEquals(1, curso.getListAsistencias().size());
    }

    @Test
    public void testRegistrarAsistenciaEstudianteNoPertenece() {
        assertFalse(profesor.registrarAsistencia(curso, estudiante, true, profesor));
    }

    @Test
    public void testRegistrarAsistenciaProfesorNoAsignado() {
        Profesor otro = new Profesor("Luis", "PX", "000", 50);
        assertFalse(otro.registrarAsistencia(curso, estudiante, true, otro));
    }


    @Test
    public void testValorarProgresoCorrecto() {
        curso.agregarEstudianteCurso(estudiante, TipoClase.GRUPAL);

        assertTrue(profesor.valorarProgreso(curso, estudiante, 5.0, "Excelente"));
        assertEquals(1, curso.getListReportes().size());
    }

    @Test
    public void testValorarProgresoNotaInvalida() {
        curso.agregarEstudianteCurso(estudiante, TipoClase.GRUPAL);

        assertFalse(profesor.valorarProgreso(curso, estudiante, -1, "Error"));
        assertEquals(0, curso.getListReportes().size());
    }



    @Test
    public void testGestionarHorarioDisponible() {
        profesor.setAcademia(academia);

        LinkedList<Horario> disponibles = profesor.gestionarHorarioDisponible();

        assertTrue(disponibles.contains(Horario.MANIANA));
    }


    @Test
    public void testDefinirHorarioCorrecto() {
        profesor.setAcademia(academia);

        assertTrue(profesor.definirHorario(curso, Horario.TARDE));
        assertEquals(Horario.TARDE, curso.getHorario());
    }

    @Test
    public void testDefinirHorarioConConflictoProfesor() {
        profesor.setAcademia(academia);

        Curso otro = new Piano("Otro", Horario.TARDE, Nivel.BASICO, TipoClase.GRUPAL, 10,
                "acústico", "Yamaha", true);
        otro.setProfesor(profesor);
        academia.getListCursos().add(otro);

        assertFalse(profesor.definirHorario(curso, Horario.TARDE));
    }

    @Test
    public void testDefinirHorarioConConflictoAula() {
        profesor.setAcademia(academia);

        Curso otro = new Piano("OtroCurso", Horario.TARDE, Nivel.BASICO, TipoClase.GRUPAL, 10,
                "acústico", "Yamaha", true);

        otro.setAula(curso.getAula());
        academia.getListCursos().add(otro);

        assertFalse(profesor.definirHorario(curso, Horario.TARDE));
    }
}

