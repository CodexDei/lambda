package org.codexdei.java8.lambda.examples;

import org.codexdei.java8.lambda.arithmetic.Arithmetic;
import org.codexdei.java8.lambda.arithmetic.Calculator;

public class InterfaceFuntionalExample {

    public static void main(String[] args) {

        Arithmetic addition = Double::sum;
        Arithmetic subtraction = (a,b) -> a - b;
        Arithmetic multiplication = (a,b) -> a * b;
        Arithmetic division = (a,b) -> a / b;

        Calculator cal = new Calculator();

        System.out.println("addition: " + cal.computer(15,7,addition));
        System.out.println("subtraction: " + cal.computer(15,7,subtraction));
        System.out.println("multiplication: " + cal.computer(15,7,multiplication));
        System.out.println("Division: " + cal.computer(15,7,division));
        System.out.println("Exponentiation: " + cal.computer(15,7,(a,b) -> Math.pow(15,7)));
        //Usando el metodo que implementa BiFuntion
        System.out.println("Addition with Bifuntion: " + cal.computerFuntion(15,7,Double::sum));
    }
}
