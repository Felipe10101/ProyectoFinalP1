package co.edu.uniquindio.poo.projectmusica.model;

public class Guitarra extends Curso{
    private String tipoCuerda, afinacion;
    private int cuerdas;

    public Guitarra(String nombreCurso, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel,String afinacion, String tipoCuerda, int cuerdas) {
        super(nombreCurso, cupo, horario, nivel);
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

}


