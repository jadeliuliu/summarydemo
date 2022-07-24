package org.example.javaer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author: liuxuan
 * @date: 2022-04-30 12:04
 **/
public class ForEachTest {
    @Test
    public void testArray(){
        ArrayList<Integer> numbers = new ArrayList<>();

        // 往数组中添加元素
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        System.out.println("ArrayList: " + numbers);

        // 将 lambda 表达式传递给 forEach
        //numbers = null;
        numbers.forEach((e) -> {
            System.out.print(e + " ");
        });
    }
}
