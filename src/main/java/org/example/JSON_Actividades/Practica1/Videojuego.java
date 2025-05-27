package org.example.JSON_Actividades.Practica1;

import java.util.ArrayList;
import java.util.List;

public class Videojuego {
    private String nombre;
    private String plataforma;
    private double precio;
    private boolean disponible;
    private List<String> listaGeneros;

    public Videojuego() {
    }

    public Videojuego(String nombre, String plataforma, double precio, boolean disponible, List<String> listaGeneros) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.precio = precio;
        this.disponible = disponible;
        this.listaGeneros = new ArrayList<>(listaGeneros);
    }

    public String getNombre() {
        return nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public List<String> getListaGeneros() {
        return listaGeneros;
    }
}
