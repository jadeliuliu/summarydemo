package org.example.javaer;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * @author: liuxuan
 * @date: 2023-01-07 16:21
 **/
public class PredicateTest {
    Predicate<Integer> predicate = (i) -> {
        return i > 10;
    };
    boolean preDemo(Integer i, Predicate<Integer> predicate) {
        return predicate.test(i);
    }
    @Test
    public void testPreDemo() {
        System.out.println(preDemo(12, predicate));//打印结果：true
        System.out.println(preDemo(12, i -> i > 13));//打印结果：false
    }
}
