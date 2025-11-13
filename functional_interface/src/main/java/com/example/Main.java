package com.example;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Greeting add = (a,b)-> a+b;
        Greeting multiply = (a,b)-> a*b;

        System.out.println("Addition: " + add.process(5, 3));
        System.out.println("Multiplication: " + multiply.process(5, 3));


        //Check Something ( takes input and returns boolean)
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(10));

        // Does Something ( takes input and returns output)  map it
        Function<String, Integer> length = s -> s.length();
        System.out.println(length.apply("Java")); // 4

        //performs action no return
        Consumer<String> printer = s -> System.out.println("Hello, " + s);
        printer.accept("World");

        //Return Something ,   input nothing
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());

    }
}