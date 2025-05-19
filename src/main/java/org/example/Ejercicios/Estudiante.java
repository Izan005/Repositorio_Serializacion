package org.example.Ejercicios;

import java.io.Serializable;

public class Estudiante implements Serializable {
    private String nombre;
    private int edad;
    private transient String curso;

    public Estudiante(String nombre, int edad, String curso){
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    @Override
    public String toString(){
        return nombre + " tiene " + edad + " años y va al curso " + curso + ".";
    }
}
