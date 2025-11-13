package co.edu.uniquindio.poo.projectmusica.model;

import java.time.LocalDate;

public class Guitarra extends Curso{
    private String tipoCuerda, afinacion;
    private int cuerdas;

    public Guitarra(String nombre, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel,String afinacion, String tipoCuerda, int cuerdas) {
        super(nombre, cupo, tipoClase, horario, nivel);
        this.tipoCuerda = tipoCuerda;
        this.afinacion = afinacion;
        this.cuerdas = cuerdas;
    }

    public String getTipoCuerda() {
        return tipoCuerda;
    }

    public void setTipoCuerda(String tipoCuerda) {
        this.tipoCuerda = tipoCuerda;
    }

    public String getAfinacion() {
        return afinacion;
    }

    public void setAfinacion(String afinacion) {
        this.afinacion = afinacion;
    }

    public int getCuerdas() {
        return cuerdas;
    }

    public void setCuerdas(int cuerdas) {
        this.cuerdas = cuerdas;
    }

    @Override
    public void crearComentario(String comentario, double nota, LocalDate fecha, Curso curso) {

    }
}

