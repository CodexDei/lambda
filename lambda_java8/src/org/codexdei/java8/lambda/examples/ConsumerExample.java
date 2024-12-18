package org.codexdei.java8.lambda.examples;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class ConsumerExample {

    public static void main(String[] args) {

        //Ejemplo 1, registrar eventos de un usuario
        Logger logger = Logger.getLogger(Main.class.getName());

        Consumer<String> logEvent = message -> logger.info("Log of the event: " + message);

        logEvent.accept("User logged in");
        logEvent.accept("User logged out");

        //Ejemplo 2
        Consumer<String> convertirUpperCase = text -> System.out.println("Uppercase text: "  + text.toUpperCase());
        Consumer<String> length = text -> System.out.println("lenght: " + text.length());
        Consumer<String> substring = text -> System.out.println("Was extracted  : " + text.substring(7,15));
        Consumer<String> replace = text -> System.out.println("Replace: " + text.replace('a','i').replace('e','o'));

        Consumer<String> combinar = convertirUpperCase.andThen(length).andThen(substring).
                         andThen(replace);

        String text = JOptionPane.showInputDialog("Enter the text to transform");

        combinar.accept(text);
    }
}
