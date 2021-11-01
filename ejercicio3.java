package com.example;

public class ejercicio3 {

    public static void main(String[] args) {

        /*

        Ejercicio Sesión 3

        En este ejercicio tenéis que crear un bucle que permita concatenar textos e imprima
        el resultado final por consola.

        Tened en cuenta que los textos pueden venir de un array de tipo String.
        Por ejemplo: String[] nombres = {"", "", "", ""}

         */

        String[] texto = new String[]{"Texto numero 1", "Texto numero 2", "Texto numero 3"};

        for(int i = 0; i < texto.length; i++) {
            System.out.println(texto[i]);
        }

    }

}
