package com.example;

public interface Greeting {
    int process(int a , int b);
    default void sayGoodbye(String name) {
        System.out.println("Goodbye, " + name + "!");
    }

}
