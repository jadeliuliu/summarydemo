package org.example.javaer;

import org.junit.Test;

/**
 * @author: liuxuan
 * @date: 2022-07-23 17:44
 **/
public class BaseTest {
    @Test
    public void test1() {
        System.out.println((double) 1 / 1000); //输出0.001
        System.out.println((double) (1 / 1000)); //输出0.0
        Integer integer = 1;
        System.out.println((double) integer / 1000); //输出0.001

        //向上取整
        double d = Math.ceil(2.3);
        Integer i = (int) d;
        System.out.println(i); //输出3
    }
}
