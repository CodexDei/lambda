package org.codexdei.java8.lambda.examples;

import org.codexdei.java8.lambda.models.User;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

    public static void main(String[] args) {

        //Para saber si es impar, odd es 'impar' es ingles
        Predicate<Integer> isEven = num -> num % 2 == 0;
        //negamos el Predicate anterior que evalua si un numero es par, por tanto 'isOdd' ahora evaluaria impares
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println("Is odd?: " + isOdd.test(8));

        //Predicate 'AND'
        Predicate<Integer> isPositive = num -> num > 0;
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
        System.out.println("Is positive and even?: " + isEvenAndPositive.test(10));

        //Predicate 'OR'
        Predicate<Integer> isNegative = num -> num < 0;
        Predicate<Integer> isOddOrNegative = isOdd.or(isNegative);
        System.out.println("Is negative or odd?: " + isOddOrNegative.test(-2));

        //Los textos son iguales?
        Predicate<String> isTextEquals = text -> text.equals("Hello God!");
        System.out.println("Is equals the phrases?:" + isTextEquals.test("Hello God!"));

        //Filtrar una lista por una condicion
        List<String> personsList = Arrays.asList("Ana", "Pedro", "Abelardo", "Fabio");

        Predicate<String> startName = name -> name.startsWith("A");

        List<String> filterNames = personsList.stream()
                                              .filter(startName)
                                              .collect(Collectors.toList());

        filterNames.forEach(System.out::println);

        //Otro ejemplo filtrar lista pero con numeros
        List<Integer> listNum = Arrays.asList(1,2,3,4,5,6,7,8);

        Predicate<Integer> isEvenFilter = num -> num % 2 == 0;

        List<Integer> evenList = listNum.stream().filter(isEvenFilter).collect(Collectors.toUnmodifiableList());

        System.out.println("Numbers evens: " + evenList);

        //Tambien podemos usar BiPredicate
        BiPredicate<String,String> equalsNames = String::equals;

        boolean isEqualsNames = equalsNames.test("Jeysson", "Jeysson");

        System.out.println("Does names are equals?: " + isEqualsNames);

        //otro ejemplo BiPredicate
        //Saber cual numero es mayor
        BiPredicate<Integer,Integer> numGreter = (num1,num2) -> num1 > num2;
        boolean greaterNumber = numGreter.test(15,7);
        System.out.println("Is the number 1 greater than the number 2?: " + greaterNumber);

        User user1 = new User();
        user1.setName("Gerardo");
        User user2 = new User();
        user2.setName("Gerardo");

        BiPredicate<User,User> equalsUsers = (name1, name2) -> name1.getName().equals(name2.getName());
        //boolean isEqualsUser = equalsUsers.test(user1,user2);
        System.out.println("The userNames are equals?:" + equalsUsers.test(user1,user2));

    }


}
