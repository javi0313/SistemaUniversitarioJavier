/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miapp.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
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
