package org.example.Ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) {
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Jefe("Paco", 12000, "Dep1"));
        listaEmpleados.add(new Jefe("Pepe", 13000, "Dep2"));

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/empleados.ser"));

            out.writeObject(listaEmpleados);

            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/empleados.ser"));

            List<Empleado> listaSer = (List<Empleado>) in.readObject();

            in.close();

            for (Empleado e : listaSer){
                System.out.println(e);
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}