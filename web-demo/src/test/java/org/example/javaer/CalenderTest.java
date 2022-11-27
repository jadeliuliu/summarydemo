package org.example.javaer;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author: liuxuan
 * @date: 2022-05-31 21:52
 **/
public class CalenderTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set (2013, 5, 4, 13, 44, 51);//年月日时分秒 (月份0代表1月)
        cal.set (Calendar.YEAR, 2014); //年
        cal.set (Calendar.MONTH, 7); //月 (月份0代表1月)
        cal.set (Calendar.DATE, 11); //日
        cal.set (Calendar.HOUR_OF_DAY, 15); //时
        cal.set (Calendar.MINUTE, 33); //分
        cal.set (Calendar.SECOND, 32); //秒

        //同时还有get、add方法，使用类似

        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        calendar.setTime(date);
        calendar.add(GregorianCalendar.MINUTE, 10);
        Date after = calendar.getTime();
        System.out.println(after);
    }
}
