package org.example.interfac;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        method(s -> Integer.parseInt(s));
    }

    private static void method(Function<String, Integer> function) {
        int num = function.apply("10");
        System.out.println(num + 20);
    }
}
