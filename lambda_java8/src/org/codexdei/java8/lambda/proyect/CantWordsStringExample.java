package org.codexdei.java8.lambda.proyect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class CantWordsStringExample {

    public static void main(String[] args) {

        // Lista de superheroes
        String text = "Había un hombre de los fariseos que se llamaba Nicodemo, un principal entre los judíos. " +
                "2 Este vino a Jesús de noche, y le dijo: Rabí, sabemos que has venido de Dios como maestro; porque" +
                " nadie puede hacer estas señales que tú haces, si no está Dios con él. 3 Respondió Jesús y le dijo:" +
                " De cierto, de cierto te digo, que el que no naciere de nuevo, no puede ver el reino de Dios. 4 " +
                "Nicodemo le dijo: ¿Cómo puede un hombre nacer siendo viejo? ¿Puede acaso entrar por segunda vez en" +
                " el vientre de su madre, y nacer? 5 Respondió Jesús: De cierto, de cierto te digo, que el que no " +
                "naciere de agua y del Espíritu, no puede entrar en el reino de Dios. 6 Lo que es nacido de la carne," +
                " carne es; y lo que es nacido del Espíritu,[a] espíritu es. 7 No te maravilles de que te dije: Os es" +
                " necesario nacer de nuevo.";

        // Mapa para almacenar las frecuencias de las palabras
        Map<String,Integer> wordRepeat = new HashMap<>();
        // BiConsumer para actualizar el conteo de palabras en cualquier mapa
        Function<String, String> onlyLettersSpaces = textLambda ->
                                                           textLambda.replaceAll("[^a-zA-Z//s] ]","");
        Function<String,String[]> arrayFunction = string -> string.split(" ");
        Function<String,String[]> arrayFunctiononlyLettersSpaces = onlyLettersSpaces.andThen(arrayFunction);

        String[] array = arrayFunctiononlyLettersSpaces.apply(text);

        List<String> wordsList = Arrays.asList(array);

        BiConsumer<List<String>,Map<String,Integer>> counterWord = (list,map) ->
                list.forEach( word -> map.put(word,map.getOrDefault(word,0) + 1) );
        // Contar las palabras usando el BiConsumer
        counterWord.accept(wordsList,wordRepeat);
        // Encontrar la palabra con la frecuencia máxima usando streams
        wordRepeat.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry ->
                        System.out.println(
                                "The word than repeats the most is: '" + entry.getKey() + "' with " + entry.getValue() + " repetitions"));

    }
}
