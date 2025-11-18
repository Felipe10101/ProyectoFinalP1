package co.edu.uniquindio.poo.projectmusica.Test;

import co.edu.uniquindio.poo.projectmusica.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdministradorAcademicoTest {

    private Academia crearAcademiaDemo() {
        return new Academia("UQ", "1");
    }

    private Estudiante crearEstudianteDemo() {
        return new Estudiante("Ana", "10", "123", 18);
    }

    private Profesor crearProfesorDemo() {
        return new Profesor("Luis", "20", "999", 35);
    }

    private Curso crearCursoDemo() {
        return new Piano(
                "CursoPiano",
                Horario.MANIANA,
                Nivel.BASICO,
                TipoClase.GRUPAL,
                10,
                "acústico",
                "Yamaha",
                true
        );
    }

    @Test
    public void testAgregarEstudiante() {
        Academia a = crearAcademiaDemo();
        AdministradorAcademico admin = new AdministradorAcademico("admin", a);

        Estudiante e = crearEstudianteDemo();

        assertTrue(admin.agregarEstudiante(e));
        assertEquals(1, a.getListEstudiantes().size());
    }

    @Test
    public void testAgregarProfesor() {
        Academia a = crearAcademiaDemo();
        AdministradorAcademico admin = new AdministradorAcademico("admin", a);

        Profesor p = crearProfesorDemo();

        assertTrue(admin.agregarProfesor(p));
        assertEquals(1, a.getListProfesores().size());
    }

    @Test
    public void testCrearCursoPiano() {
        Academia a = crearAcademiaDemo();
        AdministradorAcademico admin = new AdministradorAcademico("admin", a);

        Curso c = admin.crearCursoPiano(
                "Piano1",
                Horario.MANIANA,
                Nivel.BASICO,
                TipoClase.GRUPAL,
                10,
                "acústico",
                "Yamaha",
                true
        );

        assertNotNull(c);
        assertTrue(a.verificarCurso("Piano1"));
    }

    @Test
    public void testActualizarCurso() {
        Academia a = crearAcademiaDemo();
        AdministradorAcademico admin = new AdministradorAcademico("admin", a);

        Curso original = crearCursoDemo();
        a.getListCursos().add(original);

        Curso actualizado = new Piano(
                "CursoPiano",
                Horario.NOCHE,
                Nivel.MEDIO,
                TipoClase.GRUPAL,
                10,
                "digital",
                "Casio",
                false
        );

        assertTrue(admin.actualizarCurso("CursoPiano", actualizado));

        assertEquals(Horario.NOCHE, original.getHorario());
        assertEquals(Nivel.MEDIO, original.getNivel());
    }


    //  TEST ELIMINAR CURSO

    @Test
    public void testEliminarCurso() {
        Academia a = crearAcademiaDemo();
        AdministradorAcademico admin = new AdministradorAcademico("admin", a);

        Curso c = crearCursoDemo();
        a.getListCursos().add(c);

        assertTrue(admin.eliminarCurso("CursoPiano"));
        assertFalse(a.verificarCurso("CursoPiano"));
    }

    @Test
    public void testCambiarHorarioCurso() {
        Academia a = crearAcademiaDemo();
        AdministradorAcademico admin = new AdministradorAcademico("admin", a);

        Curso c = crearCursoDemo();
        a.getListCursos().add(c);

        assertTrue(a.cambiarHorarioCurso("CursoPiano", Horario.NOCHE));
        assertEquals(Horario.NOCHE, c.getHorario());
    }
}
