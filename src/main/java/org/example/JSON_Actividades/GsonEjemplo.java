package org.example.JSON_Actividades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLOutput;
import java.util.Arrays;

public class GsonEjemplo {
    public static void main(String[] args) {

        //Gson gson = new Gson();
        //imprime en formato elegante
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //convertir objeto a JSON
        PersonaJSON persona = new PersonaJSON("Luis", 25, Arrays.asList("Java", "Python"));
        String json = gson.toJson(persona);
        System.out.println("JSON: " + json);

        //imprimir ese JSON en un archivo .json
        try (FileWriter writer = new FileWriter("src/main/resources/personas.json")) {
            gson.toJson(persona, writer);
            System.out.println("JSON guardado en personas.json");
        } catch (Exception e){
            e.printStackTrace();
        }

        //convertir JSON a objeto
        PersonaJSON persona2 = gson.fromJson(json, PersonaJSON.class);
        System.out.println(persona2);

        //leer el JSON desde un archivo

        try (FileReader reader = new FileReader("src/main/resources/personas.json")) {
            PersonaJSON persona3 = gson.fromJson(reader, PersonaJSON.class);
            System.out.println("Nombre: " + persona3.getNombre());
            System.out.println("Edad: " + persona3.getEdad());
            System.out.println("Lenguajes: " + persona3.getLenguajes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
