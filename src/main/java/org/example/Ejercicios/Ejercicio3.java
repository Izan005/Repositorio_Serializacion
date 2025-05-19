package org.example.Ejercicios;

import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/noexistente.ser"));
            Estudiante e = (Estudiante) in.readObject();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR. Archivo no encontrado. Se creará uno con valores por defecto:");
            crearArchivo();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR al encontrar una clase. Se creará un archivo con valores por defecto");
            crearArchivo();
        }
    }

    public static void crearArchivo(){
        Estudiante e = new Estudiante("Nombre_por_defecto", 0, "Curso_por_defecto");

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/noexistente.ser"));

            out.writeObject(e);

            out.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/noexistente.ser"));
            Estudiante eSer = (Estudiante) in.readObject();
            System.out.println(eSer);
            in.close();
        }catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
