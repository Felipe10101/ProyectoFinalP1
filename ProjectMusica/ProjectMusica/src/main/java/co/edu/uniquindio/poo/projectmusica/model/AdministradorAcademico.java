package co.edu.uniquindio.poo.projectmusica.model;

import java.util.ArrayList;

public class AdministradorAcademico implements IUsuario, IHorarioGestionable, IReporteable {

    private String usuario, id, password;
    private Academia academia;

    public AdministradorAcademico(String usuario, String id, String password,Academia academia) {
        this.usuario = usuario;
        this.id = id;
        this.password = password;
        this.academia = academia;
    }

    // Getters y setters
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }




    @Override
    public void gestionHorarios(Curso curso, Horario horario) {

    }

    @Override
    public void generarReporte(Curso curso) {

    }
}


