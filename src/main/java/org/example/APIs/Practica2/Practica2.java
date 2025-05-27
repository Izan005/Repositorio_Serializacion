package org.example.APIs.Practica2;

import com.google.gson.Gson;
import org.example.APIs.Chistes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Practica2 {
    public static void main(String[] args) {
        try {
            String apiUrl = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum&vs_currencies=usd,eur";

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
            Criptomonedas criptomonedas = gson.fromJson(json.toString(), Criptomonedas.class);

            System.out.println("Bitcoin:");
            System.out.println("USD: " + criptomonedas.bitcoin.usd + "$");
            System.out.println("EUR: " + criptomonedas.bitcoin.eur + "€");
            System.out.println("Ethereum:");
            System.out.println("USD: " + criptomonedas.ethereum.usd + "$");
            System.out.println("EUR: " + criptomonedas.ethereum.eur + "€");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
