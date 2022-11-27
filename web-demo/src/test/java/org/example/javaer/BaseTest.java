package org.example.javaer;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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

        DO doo = new DO();
        doo.setA(1);
        System.out.println(doo.getA());
        doo.setB(true);
        System.out.println(doo.isB());

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2, 31) - 1);
        System.out.println(Integer.MIN_VALUE);
    }

    @ToString
    @Getter
    @Setter
    static
    class DO {
        int a;
        boolean b;
    }
}
