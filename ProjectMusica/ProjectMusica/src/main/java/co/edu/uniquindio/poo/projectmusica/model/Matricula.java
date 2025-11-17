package co.edu.uniquindio.poo.projectmusica.model;

import java.time.LocalDate;

public class Matricula {
    private String Id;
    private LocalDate fecha;

    public Matricula(String id, LocalDate fecha) {
        Id = id;
        this.fecha = fecha;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
