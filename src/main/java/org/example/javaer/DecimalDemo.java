package org.example.javaer;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
}
