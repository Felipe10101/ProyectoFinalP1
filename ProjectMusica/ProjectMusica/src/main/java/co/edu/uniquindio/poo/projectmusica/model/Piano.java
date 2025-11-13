package co.edu.uniquindio.poo.projectmusica.model;

import java.time.LocalDate;

public class Piano extends Curso{

    private String tipoPiano, marca;
    private boolean requierePedales;

    public Piano(String nombre, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel, String tipoPiano, String marca, boolean requierePedales) {
        super(nombre, cupo, tipoClase, horario, nivel);
        this.tipoPiano = tipoPiano;
        this.marca = marca;
        this.requierePedales = requierePedales;
    }

    public String getTipoPiano() {
        return tipoPiano;
    }

    public void setTipoPiano(String tipoPiano) {
        this.tipoPiano = tipoPiano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isRequierePedales() {
        return requierePedales;
    }

    public void setRequierePedales(boolean requierePedales) {
        this.requierePedales = requierePedales;
    }

    @Override
    public void crearComentario(String comentario, double nota, LocalDate fecha, Curso curso) {

    }
}
