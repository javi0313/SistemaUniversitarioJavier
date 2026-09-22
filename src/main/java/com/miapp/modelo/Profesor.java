/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miapp.modelo;

/**
 *
 * @author Estudiante
 */     

   
public class Profesor extends Persona {
     private static final double salarioBase = 5000000; 
    public Profesor(String nombre, int id, String apellido) {
        super(nombre, id, apellido);
    }
    

    public void ImpartirClase(){
        
    }
    
    @Override
    public double calcularPago() {
        return 0;
    }
    
    
}
