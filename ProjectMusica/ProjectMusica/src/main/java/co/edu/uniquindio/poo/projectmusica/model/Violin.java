package co.edu.uniquindio.poo.projectmusica.model;

public class Violin extends Curso{

    private String tamanio, arco, tecnica;

    public Violin(String nombreCurso, int cupo, TipoClase tipoClase, Horario horario, Nivel nivel, String tamanio, String arco, String tecnica) {
        super(nombreCurso, cupo, horario, nivel);
        this.tamanio = tamanio;
        this.arco = arco;
        this.tecnica = tecnica;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getArco() {
        return arco;
    }

    public void setArco(String arco) {
        this.arco = arco;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }
}
