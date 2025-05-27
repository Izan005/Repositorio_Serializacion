package org.example.APIs;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Pruebas {
    public static void main(String[] args) {

        try {
            //Conectamos con la API realizando una solicitud HTTP
            String apiUrl = "https://v2.jokeapi.dev/joke/Programming?type=single&lang=es";

            URL url = new URL(apiUrl);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            //Recibimos una respuesta en JSON
            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                json.append(line);
            }

            in.close();

            //Usamos Gson para convertir el JSON en objetos Java.
            Gson gson = new Gson();
            Chistes chiste = gson.fromJson(json.toString(), Chistes.class);

            System.out.println("Chiste: \n" + chiste.joke);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
