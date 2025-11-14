package co.edu.uniquindio.poo.projectmusica.model;

import java.util.ArrayList;

public class AdministradorAcademico implements IUsuario, IHorarioGestionable, IReporteable {

    private String usuario, id, password;
    private ArrayList<Estudiante> listEstudiantesCurso;

    public AdministradorAcademico(String usuario, String id, String password) {
        this.usuario = usuario;
        this.id = id;
        this.password = password;
    }

    public void setListEstudiantesCurso(ArrayList<Estudiante> lista) {
        this.listEstudiantesCurso = lista;
    }

    public boolean agregarEstudiante(Estudiante estudiante) {
        if (!verificarEstudiante(estudiante.getId())
                && listEstudiantesCurso.size() < listEstudiantesCurso.size()) {
            listEstudiantesCurso.add(estudiante);
            return true;
        }
        return false;
    }

    public boolean eliminarEstudiante(String id) {
        for (Estudiante estudiante : listEstudiantesCurso) {
            if (estudiante.getId().equals(id)) {
                listEstudiantesCurso.remove(estudiante);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarEstudiante(String Id, Estudiante actualizado) {
        for (Estudiante estudiante : listEstudiantesCurso) {
            if (estudiante.getId().equals(Id)) {
                estudiante.setNombre(actualizado.getNombre());
                estudiante.setTelefono(actualizado.getTelefono());
                estudiante.setEdad(actualizado.getEdad());
                return true;
            }
        }
        return false;
    }

    public boolean verificarEstudiante(String Id) {
        for (Estudiante estudiante : listEstudiantesCurso) {
            if (estudiante.getId().equals(Id)) {
                return true;
            }
        }
        return false;
    }

    // Getters y setters
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}


