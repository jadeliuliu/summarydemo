package org.example.javaer;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * @author: liuxuan
 * @date: 2022-05-12 19:45
 **/
public class DateTest {
    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date oldTime = dateFormat.parse("2019-04-07 19:50:11");
        System.out.println("oldTime："+oldTime);
        System.out.println("Object: " + dateFormat);

        // String formatting
        String str = dateFormat.format(new Date());
        System.out.println("str:"+str);

        Date newTime = new Date();
        int result = oldTime.compareTo(newTime);
        System.out.println(result);

        DateFormat dateformat = DateFormat.getDateInstance();
        Date old = dateformat.parse("2022-04-07 19:50:11");
        Date now = new Date();
        if(now.after(old)){
            System.out.println("now比old新");
        }
        dateFormat = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CHINA);
        System.out.println(dateFormat.format(new Date()));
    }
}
