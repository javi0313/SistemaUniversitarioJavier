package com.miapp.modelo;

public class Profesor extends Persona {
    private final double salarioBase;

    public Profesor(String nombre, int id, String apellido, double salarioBase) {
        super(nombre, id, apellido);
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void impartirClase() {
    }

    @Override
    public double calcularPago() {
        return salarioBase;
    }
}