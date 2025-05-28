package org.example.JSON_Actividades.Practica1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JsonVideojuegos {
    static List<Videojuego> listaVideojuegos = new ArrayList<>();
    static List<String> listaGeneros = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        //Guardar videojuegos en una lista
        crearJuego();


        //Pasar los videojuegos a JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(listaVideojuegos);

        //Escribir un JSON con los videojuegos
        try (FileWriter writer = new FileWriter("src/main/resources/videojuegos.json")){
            gson.toJson(listaVideojuegos, writer);
        }catch (Exception e){
            e.printStackTrace();
        }

        //Leer el JSON e imprimirlo por pantalla, transformando el tipo de la lista (LinkedTreeSet) a List
        Type tipoListaVideojuegos = new TypeToken<List<Videojuego>>() {}.getType();
        List<Videojuego> listaVideojuegos2 = gson.fromJson(json, tipoListaVideojuegos);

        System.out.println(listaVideojuegos2);

        for (Videojuego v : listaVideojuegos2){
            System.out.println(v);
        }

        //Añadir nuevo videojuego a la nueva lista
        listaVideojuegos2.add(new Videojuego("Demon Souls", "PS3", 25, false, Arrays.asList("JRPG", "Acción")));

        //Videojuegos por menos de 30€
        System.out.println("Videojuegos por menos de 30€: \n ");
        for (Videojuego v : listaVideojuegos2){
            if (v.getPrecio() < 30){
                System.out.println(v.getNombre());
            }

        }
        //Reescribimos la lista modificada en el JSON
        try (FileWriter writer = new FileWriter("src/main/resources/videojuegos.json")){
            gson.toJson(listaVideojuegos2, writer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void crearJuego(){
        boolean salirVideojuego = false;
        boolean salirGenero = false;
        String nombre;
        String plataforma;
        double precio;
        String disponible;


        while (!salirVideojuego){
            System.out.println("Crear Videojuego");
            System.out.println("Nombre:");
            nombre = in.nextLine();
            System.out.println("Plataforma:");
            plataforma = in.nextLine();
            System.out.println("Precio:");
            precio = in.nextDouble();
            System.out.println("¿Está disponible? (true/false)");
            disponible = in.next();

            System.out.println("Géneros:");
            while(!salirGenero){
                System.out.println("Introduce un género:");
                listaGeneros.add(in.next());
                System.out.println("¿Añadir más géneros?(S/Cualquier cosa)");
                if (!in.next().equalsIgnoreCase("S")){
                    salirGenero = true;
                }
            }

            listaVideojuegos.add(new Videojuego(nombre, plataforma, precio, Boolean.parseBoolean(disponible), listaGeneros));
            System.out.println("¿Añadir otro videojuego?(S/Cualquier cosa)");

            if (!in.next().equalsIgnoreCase("S")){
                salirVideojuego = true;
            } else {
                salirGenero = false;
                listaGeneros.clear();
                in.nextLine();
            }

        }
    }
}


