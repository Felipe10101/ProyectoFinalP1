package co.edu.uniquindio.poo.projectmusica.model;
import co.edu.uniquindio.poo.projectmusica.model.*;
import java.time.LocalDate;

public class Profesor implements IUsuario, IEvaluable, IHorarioGestionable {
    private String nombre, id, telefono;
    private int edad;

    public Profesor(String nombre, String id, String telefono, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public void registrarProgreso() {

    }

    @Override
    public void consultarProgreso() {

    }

    @Override
    public void crearComentario(String comentario, double nota, LocalDate fecha, Curso curso) {
        ReporteProgreso reporte = new ReporteProgreso(comentario, nota, fecha);

        System.out.println(" Reporte de Progreso");
        System.out.println("------------------------------");
        System.out.println("Profesor: " + nombre);
        System.out.println("Curso: " + curso.getNombre());
        System.out.println("Nivel: " + curso.getNivel());
        System.out.println("Tipo de clase: " + curso.getTipoClase());
        System.out.println("Comentario: " + comentario);
        System.out.println("Nota: " + nota);
        System.out.println("Fecha: " + fecha);

        if (curso instanceof Piano piano) {
            System.out.println("🎹 Tipo de piano: " + piano.getTipoPiano());
            System.out.println("Marca: " + piano.getMarca());
            System.out.println("¿Requiere pedales?: " + (piano.isRequierePedales() ? "Sí" : "No"));
        }
        else if (curso instanceof Guitarra guitarra) {
            System.out.println(" Tipo de Cuerda: " + guitarra.getTipoCuerda());
            System.out.println("Afinación: " + guitarra.getAfinacion());
            System.out.println("Número de cuerdas: " + guitarra.getCuerdas());
        }
        else if (curso instanceof Violin violin) {
            System.out.println(" Tamaño: " + violin.getTamanio());
            System.out.println("Arco: " + violin.getArco());
            System.out.println("Técnica: " + violin.getTecnica());
        }
        else if (curso instanceof Canto canto) {
            System.out.println("Tipo de voz: " + canto.getTipoVoz());
            System.out.println("Género musical: " + canto.getGeneroMusical());
        }

        System.out.println("------------------------------");
    }
    @Override
    public void gestionarHorarioDisponible() {

    }

    @Override
    public void crearClaseGrupal() {

    }

    @Override
    public void registrarAsistencia() {

    }

    @Override
    public void valorarProgreso() {

    }


}
