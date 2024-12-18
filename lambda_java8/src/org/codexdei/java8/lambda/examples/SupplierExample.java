package org.codexdei.java8.lambda.examples;

import org.codexdei.java8.lambda.models.User;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        //Es utilizada para representar una función que no toma ningún argumento pero retorna un resultado
        //Supplier devuelve un dato, en este caso crea un objeto
        Supplier<User> creUser = User::new;
        //se obtiene el usuario y se almacena  en una varible
        User user = creUser.get();

        BiConsumer<User,String> createUser = User::setName;
        createUser.accept(user,"pepe");
        System.out.println("UserName: " + user.getName());

        //Ejemplo 2: generar aletorios
        //En este caso aleatorios del 1 a 100,ya que es excluyente, no generara nunca el 101
        Supplier<Integer> creRandoms = () -> new Random().nextInt(1,101);
        System.out.println(creRandoms.get());
    }
}
