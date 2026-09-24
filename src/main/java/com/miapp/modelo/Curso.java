
package com.miapp.modelo;

import java.util.ArrayList;
import java.util.List;


public class Curso {
    private int codigo;
    private int creditos;
    
    private List<Estudiante> estudiantes;

    public Curso(int codigo, int creditos, List<Estudiante> estudiantes) {
        this.codigo = codigo;
        this.creditos = creditos;
        this.estudiantes = new ArrayList<>();
    }
}
