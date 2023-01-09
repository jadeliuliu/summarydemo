package org.example.javaer;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @author: liuxuan
 * @date: 2022-06-26 10:45
 **/
public class DecimalDemo {
    public static void main(String[] args)
    {
        BigDecimal a = new BigDecimal("4.5635");

        a = a.setScale(3, BigDecimal.ROUND_HALF_UP);    //保留3位小数，且四舍五入
        System.out.println(a);

        Double d = a.doubleValue();  //转为double类型

        BigDecimal a1 = new BigDecimal("4.5");
        BigDecimal b = new BigDecimal("1.5");
        a1 = a1.add(b);
        System.out.println(a1);
    }

    @Test
    public void test1() {
        String s = Double.toString(1.1);
        double d1 = 1.1;
        String s1 = Double.toString(d1);

        BigDecimal a=BigDecimal.valueOf(1.0);
        BigDecimal b=BigDecimal.valueOf(1.000);
        System.out.println(a.equals(b));  //true

        BigDecimal c = new BigDecimal("10.00");
        BigDecimal d = new BigDecimal("10");
        BigDecimal e = new BigDecimal(10.00);
        System.out.println(c.equals(d));  //false
        System.out.println(c.equals(e));  //false

        //toPlainString再equals
        System.out.println(c.toPlainString().equals(d.toPlainString())); //false
        System.out.println(c.toPlainString().equals(e.toPlainString())); //false

        //longValue方式
        System.out.println(c.longValue() == d.longValue()); //true
        System.out.println(c.longValue() == e.longValue()); //true

        //compareTo
        System.out.println(c.compareTo(d) == 0); //true
        System.out.println(c.compareTo(e) == 0); //true

        BigDecimal f = new BigDecimal("10.100001");
        BigDecimal g = new BigDecimal(10.100001);
        System.out.println(f.compareTo(g) == 0); //false
        // 这是因为本身Double传参的构造就不准，看上面
    }

    @Test
    public void test2() {
        //1.使用BigDecimal
        BigDecimal bdL = new BigDecimal("1.22");
        BigDecimal bdR = new BigDecimal("1.22");
        if (bdL.compareTo(bdR) < 0)
            System.out.println("num1 < num2");
        else if (bdL.compareTo(bdR) == 0)
            System.out.println("num1 == num2");
        else
            System.out.println("num1 > num2");

        Double dL = 1.33;
        Double dR = 1.33;
        if (dL.compareTo(dR) < 0)
            System.out.println("num1 < num2");
        else if (dL.compareTo(dR) == 0)
            System.out.println("num1 == num2");
        else
            System.out.println("num1 > num2");

        Double num1 = 1.222;
        Double num2 = 1.222;
        if (num1 - num2 > 0.000001)
            System.out.println("num1 > num2");
        else if (num1 - num2 < -0.0000001)
            System.out.println("num1 < num2");
        else
            System.out.println("num1 == num2");

        // 使用使用sun提供的Double.doubleToLongBits()方法
        long lL = Double.doubleToRawLongBits(num1);
        long lR = Double.doubleToRawLongBits(num2);
        System.out.println(lL + ":" + lR);
        if (lL < lR)
            System.out.println("num1 < num2");
        else if (lL == lR)
            System.out.println("num1 == num2");
        else
            System.out.println("num1 > num2");



    }
}
