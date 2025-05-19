package org.example.Pruebas;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializacionPersona {
    public static void main(String[] args) {
        Persona p = new Persona("Izan", 20);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/persona.ser"));

            out.writeObject(p);

            out.close();
        } catch (IOException e){
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }
        System.out.println("Objeto serializado en persona.ser");
    }
}
