package com.miapp.modelo;

import com.miapp.servicios.Inscribible;
import com.miapp.utilidades.EstadoMatricula;
import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona implements Inscribible {  

    private static int totalEstudiantes = 0;
    private static final int MAX_MATERIAS = 7; 
    public static final int PROMEDIO_MINIMO = 0;
    public static final int PROMEDIO_MAXIMO = 5;
    public static final String CARRERA_PREDETERMINADA = "Sin especificar";

    public Estudiante(int id, String nombre, String apellido, String carrera, double promedio) {
    super(nombre, id, apellido);
    this.carrera = carrera;
    this.promedio = promedio;
    this.curso = new ArrayList<>();
    this.estadoMatricula = EstadoMatricula.ACTIVO;
    totalEstudiantes++;
}

    private String carrera;
    private double promedio;
    private List<Curso> curso;
    private EstadoMatricula estadoMatricula;

    public static int getTotalEstudiantes() {
        return totalEstudiantes;
    }

    public static void reiniciarContador() {
        totalEstudiantes = 0;
    }

    public static int getProximoId() {  
        return totalEstudiantes + 1;
    }

    public int getId() {  
        return id; 
    }

    public String getCarrera() {  
        return carrera; 
    }

    public double getPromedio() {  
        return promedio; 
    }

    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }

    public EstadoMatricula getEstadoMatricula() {
        return estadoMatricula;
    }

    public void setEstadoMatricula(EstadoMatricula estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }

    public void setId(int id) {  
        this.id = id; 
    }

    public void setCarrera(String carrera) {  
        this.carrera = carrera; 
    }

    public void setPromedio(double p) {
        if (p >= PROMEDIO_MINIMO && p <= PROMEDIO_MAXIMO) {
            this.promedio = p;
        }
    }

    @Override
    public final String toString() {
        return "ID: " + super.getId()
             + " | Nombre: " + super.getNombre()
             + " | Apellido: " + super.getApellido()
             + " | Carrera: " + carrera
             + " | Promedio: " + String.format("%.2f", promedio);
    }

    @Override
    public double calcularPago() {
        return 0;
    }

    @Override
    public boolean inscribir(Curso curso) {
        if (this.curso.size() < MAX_MATERIAS && !this.curso.contains(curso)) {
            this.curso.add(curso);
            curso.agregarEstudiante(this);
            return true;
        }
        return false;
    }
}