package org.example.javaer;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author: liuxuan
 * @date: 2023-01-07 17:38
 **/
public class ConsumerTest {
    Consumer<String> consumer = (str) -> {
        System.out.println(str);
    };
    public void conDemo(String str, Consumer<String> consumer) {
        consumer.accept(str);
    }
    @Test
    public void testConDemo() {
        conDemo("hello", consumer);//打印结果：hello
        conDemo("hello", s -> System.out.println(s));
    }
}
