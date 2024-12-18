package org.codexdei.java8.lambda.examples;

import org.codexdei.java8.lambda.models.User;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class BiConsumerExample {

    public static void main(String[] args) {

        Map<String, Integer> products = new HashMap<>();

        int cantProduct = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de productos a ingresar"));


            for (int i = 0; i < cantProduct; i++){

                products.put(JOptionPane.showInputDialog("Ingrese el producto"),
                             Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad")));
            }
        BiConsumer<String,Integer> showInventory = (product, number) -> {

            System.out.println("Product:" + product + " " + "Cant:" + number );

        };
        products.forEach(showInventory);

        //Supplier devuelve un dato, en este caso crea un objeto
        Supplier<User> creUser = User::new;
        //se obtiene el usuario y se almacena  en una varible
        User user = creUser.get();

        BiConsumer<User,String> createUser = User::setName;
        createUser.accept(user,"pepe");
        System.out.println("UserName: " + user.getName());

    }
}
