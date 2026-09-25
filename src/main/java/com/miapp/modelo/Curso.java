package com.miapp.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int codigo;
    private int creditos;
    private List<Estudiante> estudiantes;

    public Curso(int codigo, int creditos) {
        this.codigo = codigo;
        this.creditos = creditos;
        this.estudiantes = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (!this.estudiantes.contains(estudiante)) {
            this.estudiantes.add(estudiante);
        }
    }
}