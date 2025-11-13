package co.edu.uniquindio.poo.projectmusica.model;
import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {
            // Crear un profesor
            Profesor profesor = new Profesor("Thomas", "P001", "3101234567", 28);

            // Crear un curso de guitarra
            Guitarra cursoGuitarra = new Guitarra("Guitarra Clásica", 10, TipoClase.GRUPAL, Horario.TARDE,  Nivel.MEDIO, "MEDIO", "EADGBE", 6);

            // Crear un comentario (reporte de progreso)
            profesor.crearComentario("Excelente avance en los acordes y técnica de mano derecha.", 4.7, LocalDate.now(),
                    cursoGuitarra
            );
        }
    }


