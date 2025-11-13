package co.edu.uniquindio.poo.projectmusica.model;
import co.edu.uniquindio.poo.projectmusica.model.*;

public class AdministradorAcademico implements IUsuario, IHorarioGestionable, IReporteable  {
    private String usuario, id, password;

    public AdministradorAcademico(String usuario, String id, String password) {
        this.usuario = usuario;
        this.id = id;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    }
}
