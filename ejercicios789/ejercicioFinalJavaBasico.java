package com.example;

import java.io.*;
import java.util.*;
import java.io.InputStream;
import java.io.PrintStream;

public class ejercicioFinalJavaBasico {

    public static class MiPrograma {

        public static void main(String[] args) {

            // Creando el HashMap
            HashMap<Integer, String> map = new HashMap<Integer, String>();
            map.put(1, "Avila");
            map.put(2, "Madrid");
            map.put(3, "Barcelona");

            // Almacenando el HashMap en un Array para mostrarlo por pantalla
            System.out.println("Mostrando Array");
            String[] ciudades = map.values().toArray(new String[0]);

            for (String ciudad : ciudades)
                System.out.print(ciudad + " ");

            // Indicando el fichero donde guardaremos el HashMap
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nIntroduce el fichero de destino: ");
            String fileOut = scanner.nextLine();

            File file = new File(fileOut);
            BufferedWriter bf = null;

            try {
                bf = new BufferedWriter(new FileWriter(file));
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    bf.write(entry.getKey() + ":" + entry.getValue());
                    bf.newLine();
                }
                bf.flush();
                System.out.println("Fichero almacenado correctamente");

                // Leemos el fichero si el usuario lo desea
                Scanner leer = new Scanner(System.in);
                System.out.println("¿Quieres leer el contenido del fichero anterior? (Si o No)");
                String respuesta = leer.nextLine();

                if (respuesta.equalsIgnoreCase("Si")) {
                    try {
                        InputStream ins = new FileInputStream(fileOut);
                        byte[] byteArray = ins.readAllBytes();
                        System.out.println(new String(byteArray));
                        ins.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // Realizado una copia de seguridad del fichero si el usuario lo desea
                    Scanner copiaseg = new Scanner(System.in);
                    System.out.println("¿Quieres hacer una copia de seguridad del fichero? (Si o No)");
                    String respuesta2 = copiaseg.nextLine();

                    if (respuesta2.equalsIgnoreCase("Si")) {

                        // Indicamos el fichero nuevo donde se copiara el fichero original
                        Scanner destino = new Scanner(System.in);
                        System.out.println("Introduce el destino de la copia de seguridad: ");
                        String copia = destino.nextLine();

                        try {
                            InputStream in = new FileInputStream(fileOut);
                            byte[] datos = in.readAllBytes();
                            in.close();

                            PrintStream out = new PrintStream(copia);
                            out.write(datos);
                            out.close();

                            System.out.println("Copia realizada con exito");
                        } catch (Exception e) {
                            System.out.println("Excepcion: " + e.getMessage());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bf.close();
                    System.out.println("Fin del programa");
                } catch (Exception e) {
                }
            }
        }
    }
}


