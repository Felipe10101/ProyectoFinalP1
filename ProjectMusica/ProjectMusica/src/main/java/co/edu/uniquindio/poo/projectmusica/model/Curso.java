package co.edu.uniquindio.poo.projectmusica.model;

public abstract class Curso {

    private String nombre;
    private int cupo;

    public Curso(String nombre, int cupo) {
        this.nombre = nombre;
        this.cupo = cupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
}
