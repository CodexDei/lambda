package org.codexdei.java8.lambda.examples;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {

        Function<String, String> returnName = (name) -> "Hola!! " + name;

        String greeting = returnName.apply("Jorge");

        System.out.println(greeting);

        Function<String,String> upperCase = String::toUpperCase;

        String upper = upperCase.apply("samy");

        BiFunction<String,String,Integer> compare = String::compareTo;//lo anterior es igual a: (a,b) -> a.compareTo(b);
        //Retorna un integer, sin son iguales es cero
        System.out.println(compare.apply(greeting,upper));

        BiFunction<String,String,String> concat = String::concat;//lo anterior es igual a: (a,b) -> a.compareTo(b);
        System.out.println(concat.apply(greeting,upper));



    }
}
