package org.codexdei.java8.lambda.proyect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class CantWordsListExample {

    public static void main(String[] args) {

        // Lista de superheroes
        List<String> wordsList = Arrays.asList("Batman", "Superman", "Batman", "Spiderman", "Batman", "Iron Man",
                "Wonder Woman", "Batman", "Flash", "Batman", "Thor", "Superman",
                "Hulk", "Batman", "Captain America", "Wonder Woman", "Flash",
                "Green Lantern", "Batman","Iron Man");

        // Mapa para almacenar las frecuencias de las palabras
        Map<String,Integer> wordRepeat = new HashMap<>();
        // BiConsumer para actualizar el conteo de palabras en cualquier mapa
        BiConsumer<List<String>,Map<String,Integer>> counterWord = (list,map) ->
                list.forEach( word -> map.put(word,map.getOrDefault(word,0) + 1) );
        // Contar las palabras usando el BiConsumer
        counterWord.accept(wordsList,wordRepeat);
        // Encontrar la palabra con la frecuencia máxima usando streams
        wordRepeat.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry ->
                        System.out.println(
                                "The word than repeats the most is: " + entry.getKey() + " with " + entry.getValue() + " repetitions"));

    }
}
