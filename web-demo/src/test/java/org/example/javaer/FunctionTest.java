package org.example.javaer;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author: liuxuan
 * @date: 2023-01-07 16:09
 **/
public class FunctionTest {
    Function<String, String> function = (str) -> {
        return "hello," + str;
    };

    String funDemo(String str2, Function<String, String> function) {
        return function.apply(str2);
    }

    @Test
    public void testFunDemo() {
        System.out.println(funDemo("小明", function));
        System.out.println(funDemo("小美", str -> "hello"+str));
    }
}
