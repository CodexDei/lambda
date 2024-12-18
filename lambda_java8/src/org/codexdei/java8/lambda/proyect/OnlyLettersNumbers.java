package org.codexdei.java8.lambda.proyect;

import java.util.function.Function;

public class OnlyLettersNumbers {

    public static void main(String[] args) {

        //Expresión Lambda que elimine espacios, comas y puntos de una frase y
        //además la devuelva la frase convertida en mayúscula.

        Function<String, String> onlyNumbersLetters = text -> text.replaceAll("[^a-zA-Z0-9]","").toUpperCase();
        String text = onlyNumbersLetters.apply("  </d*+i´?,o)&s * +");
        System.out.println("Only numbers and letters uppercase:" + text);
    }

}
