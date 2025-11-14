package co.edu.uniquindio.poo.projectmusica.model;

import java.util.ArrayList;

public class CursoGrupal {
    private int cupo;
    private ArrayList<Estudiante> ListEstudiantesCurso;

    public CursoGrupal(int cupo, ArrayList<Estudiante> listEstudiantesCurso) {
        this.cupo = cupo;
        this.ListEstudiantesCurso = new ArrayList<>(cupo);
    }

    public ArrayList<Estudiante> getListEstudiantesCurso() {
        return ListEstudiantesCurso;
    }

    public void setListEstudiantesCursos(ArrayList<Estudiante> listEstudiantesCursos) {
        ListEstudiantesCurso = listEstudiantesCursos;
    }



}
