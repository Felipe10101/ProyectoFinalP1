package co.edu.uniquindio.poo.projectmusica.model;

public class Canto extends Curso{

    private String tipoVoz, GeneroMusical;

    public Canto(String nombre, int cupo, Horario horario, Nivel nivel, String tipoVoz, String generoMusical) {
        super (nombre, cupo, horario, nivel);
        this.tipoVoz = tipoVoz;
        GeneroMusical = generoMusical;
    }

    public String getTipoVoz() {
        return tipoVoz;
    }

    public void setTipoVoz(String tipoVoz) {
        this.tipoVoz = tipoVoz;
    }

    public String getGeneroMusical() {
        return GeneroMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        GeneroMusical = generoMusical;
    }
}
