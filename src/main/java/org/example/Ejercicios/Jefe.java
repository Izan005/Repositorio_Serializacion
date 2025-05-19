package org.example.Ejercicios;

public class Jefe extends Empleado{

    private String departamento;
    public Jefe(String nombre, int salario, String departamento) {
        super(nombre, salario);
        this.departamento = departamento;
    }
}
