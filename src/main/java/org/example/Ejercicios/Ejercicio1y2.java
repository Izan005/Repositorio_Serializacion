package org.example.Ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio1y2 {
    public static void main(String[] args) {
        List<Estudiante> listaEstudiantes = new ArrayList<>();

        listaEstudiantes.add(new Estudiante("Pepe", 12, "1ºESO"));
        listaEstudiantes.add(new Estudiante("Paco", 15, "3ºESO"));

        try {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/estudiantes.ser"));

            out.writeObject(listaEstudiantes);

            out.close();

            System.out.println("Lista serializada con éxito.");

        }catch (IOException e){
            e.printStackTrace();
        }

        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/estudiantes.ser"));

            List<Estudiante> serListaEstudiantes = (List<Estudiante>) in.readObject();

            in.close();

            for (Estudiante e : serListaEstudiantes){
                System.out.println(e);
            }

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
