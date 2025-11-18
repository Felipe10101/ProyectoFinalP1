package co.edu.uniquindio.poo.projectmusica.model;

public class Piano extends Curso{

    private String tipoPiano, marca;
    private boolean requierePedales;

    public Piano(String nombreCurso,Horario horario, Nivel nivel, TipoClase tipoClase, int cupo, String tipoPiano, String marca, boolean requierePedales) {
        super(nombreCurso, horario, nivel, tipoClase, cupo);
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

