package com.miapp.modelo;

import com.miapp.servicios.Inscribible;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo: representa la entidad Estudiante.
 */
public class Estudiante extends Persona implements Inscribible {  

    private static int totalEstudiantes = 0;
    private static final int MAX_MATERIAS = 7; 
    public static final int PROMEDIO_MINIMO = 0;
    public static final int PROMEDIO_MAXIMO = 5;
    public static final String CARRERA_PREDETERMINADA = "Sin especificar";

    // ── Atributos de instancia ────────────────────────────────────────────────

    public Estudiante(int id, String carrera, String nombre, String apellido, double promedio) {
        super(nombre, id, apellido);
        this.carrera = carrera;
        this.promedio = promedio;
        this.curso = new ArrayList<>();
    }

    
    
   
    private String carrera;
    private double promedio;
    private List<Curso> curso;
    // ── Constructor ───────────────────────────────────────────────────────────

    

    

    // ── Métodos estáticos (de clase) ──────────────────────────────────────────

    public static int getTotalEstudiantes() {
        return totalEstudiantes;
    }

    public static void reiniciarContador() {
        totalEstudiantes = 0;
    }

    public static int getProximoId() {  
        return totalEstudiantes + 1;
    
    }

    

    // ── Getters ──────────────────────────────────────────────────────────────

    public int getId() { 
        return id; 
    }

   

    

    public String getCarrera() { 
        return carrera; 
    }

    public double getPromedio() { 
        return promedio; 
    }

    // ── Setters ──────────────────────────────────────────────────────────────

    public void setId(int id) { 
        this.id = id; 
    }


    public void setCarrera(String carrera) { 
        this.carrera = carrera; 
    }

    /**
     Valida el promedio antes de asignarlo usando constantes finales
     * @param p promedio a validar (debe estar entre PROMEDIO_MINIMO y PROMEDIO_MAXIMO)
     */
    public void setPromedio(double p) {
        // nuevo: Uso de constantes finales para validación
        if (p >= PROMEDIO_MINIMO && p <= PROMEDIO_MAXIMO) {
            this.promedio = p;
        }
    }

    /**
     Método final: no puede ser sobrescrito por subclases
     */
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
        return true;
    }

    
}