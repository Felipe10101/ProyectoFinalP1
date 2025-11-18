package co.edu.uniquindio.poo.projectmusica.Test;

import co.edu.uniquindio.poo.projectmusica.model.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EstudianteTest {

    private Academia crearAcademiaDemo() {
        return new Academia("UQ", "1");
    }

    private Estudiante crearEstudianteDemo() {
        return new Estudiante("Ana", "10", "123", 18);
    }

    private Curso crearCursoDemo() {
        return new Piano(
                "Piano1",
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
    public void testInscripcionSinAcademia() {
        Estudiante e = crearEstudianteDemo();
        Curso c = crearCursoDemo();

        assertNull(e.inscripcionCurso(c));
    }

    @Test
    public void testInscripcionCorrecta() {
        Academia a = crearAcademiaDemo();
        Estudiante e = crearEstudianteDemo();
        e.setAcademia(a);

        Curso c = crearCursoDemo();
        a.getListCursos().add(c);

        Curso resultado = e.inscripcionCurso(c);

        assertNotNull(resultado);
        assertEquals(1, e.getCursosInscritos().size());
    }

    @Test
    public void testInscripcionRepetida() {
        Academia a = crearAcademiaDemo();
        Estudiante e = crearEstudianteDemo();
        e.setAcademia(a);

        Curso c = crearCursoDemo();
        a.getListCursos().add(c);

        e.inscripcionCurso(c);
        assertNull(e.inscripcionCurso(c));
    }

    @Test
    public void testCancelarCurso() {
        Academia a = crearAcademiaDemo();
        Estudiante e = crearEstudianteDemo();
        e.setAcademia(a);

        Curso c = crearCursoDemo();
        a.getListCursos().add(c);

        e.inscripcionCurso(c);
        e.cancelacionCurso(c);

        assertEquals(0, e.getCursosInscritos().size());
    }

    @Test
    public void testValidarPrerequisitos() {
        Curso p1 = new Piano("P1", Horario.MANIANA, Nivel.PRINCIPIANTE, TipoClase.GRUPAL, 10,
                "a","b",true);
        Curso b = new Piano("BASICO", Horario.TARDE, Nivel.BASICO, TipoClase.GRUPAL, 10,
                "a","b",true);

        Estudiante e = crearEstudianteDemo();
        e.getCursosInscritos().add(p1);

        assertTrue(e.validarPrerequisitos(b));
    }
}
