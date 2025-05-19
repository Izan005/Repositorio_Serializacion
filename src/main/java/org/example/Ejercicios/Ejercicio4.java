package org.example.Ejercicios;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ejercicio4 {
    public static void main(String[] args) {
        Map<String, Estudiante> mapa = new HashMap<>();
        mapa.put("Est2", new Estudiante("Pepito", 12, "1ºESO"));
        mapa.put("Est1", new Estudiante("Paco", 15, "3ºESO"));
        mapa.put("Est3", new Estudiante("Juan", 17, "1ºBach"));

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/mapa.ser"));

            out.writeObject(mapa);

            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/mapa.ser"));

            Map<String, Estudiante> desMapa = (Map<String, Estudiante>) in.readObject();

            Map<String,Estudiante> ordenado = new TreeMap<>(desMapa);

            for (Map.Entry<String, Estudiante> map : ordenado.entrySet()){
                System.out.println("Clave: " + map.getKey() + " Valor: " + map.getValue());
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
