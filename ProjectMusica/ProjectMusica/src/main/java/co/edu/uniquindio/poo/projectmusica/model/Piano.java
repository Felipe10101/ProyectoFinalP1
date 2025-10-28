package co.edu.uniquindio.poo.projectmusica.model;

public class Piano extends Curso{

    private String tipoPiano, marca;
    private boolean requierePedales;

    public Piano(String nombre, int cupo, String tipoPiano, String marca, boolean requierePedales) {
        super( nombre, cupo, tipoclase, horario, nivel);
        super(nombre, cupo);
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
}
