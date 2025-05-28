package org.example.JSON_Actividades.Practica1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonVideojuegos {
    public static void main(String[] args) {

        //Guardar videojuegos en una lista
        //Videojuegos de play
        List<Videojuego> listaVideojuegos = new ArrayList<>(Arrays.asList(new Videojuego("Metal Gear Solid V: The Phantom Pain", "PS3", 60, true, Arrays.asList("Acción", "Espionaje Táctico"))));
        listaVideojuegos.add(new Videojuego("Devil May Cry 3", "PS2", 30, false, Arrays.asList("Acción")));
        listaVideojuegos.add(new Videojuego("Sekiro: Shadows die twice", "PS4", 60, true, Arrays.asList("JRPG", "Aventura")));

        //Videojuegos de nintendo
        listaVideojuegos.add(new Videojuego("The Legend of Zelda: Ocarina of Time", "N64", 40, false, Arrays.asList("Acción", "Aventura")));
        listaVideojuegos.add(new Videojuego("Super Mario Galaxy 2", "Wii", 40, true, Arrays.asList("Plataformas", "Exploración")));
        listaVideojuegos.add(new Videojuego("Pokémon Perla", "DS", 30, false, Arrays.asList("RPG", "Aventura")));

        //Videojuegos de xbox
        listaVideojuegos.add(new Videojuego("Halo Infinite", "XBOX Series X", 70, true, Arrays.asList("FPS", "Acción")));
        listaVideojuegos.add(new Videojuego("Fable II", "XBOX 360", 30, false, Arrays.asList("RPG", "Aventura")));
        listaVideojuegos.add(new Videojuego("Quantum Breake", "XBOX 360", 70, true, Arrays.asList("RPG", "Táctico")));


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

}
