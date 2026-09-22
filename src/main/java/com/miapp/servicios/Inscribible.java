package com.miapp.servicios;

import com.miapp.modelo.Curso;

/**
 * Interfaz que define la capacidad de un elemento para inscribirse en un curso.
 */
public interface Inscribible {

    boolean inscribir(Curso curso);
    
}
