package co.edu.uniquindio.poo.projectmusica.model;

import java.time.LocalDate;

public class ReporteProgreso {

    private String comentario;
    private double nota;
    private LocalDate fecha;

    public ReporteProgreso(String comentario, double nota, LocalDate fecha) {
        this.comentario = comentario;
        this.nota = nota;
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
