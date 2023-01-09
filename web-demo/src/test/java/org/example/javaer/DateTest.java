package org.example.javaer;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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

    @Test
    public void test1() {
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);
        LocalDate now = LocalDate.now();
        System.out.println(now.getDayOfYear());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getMonth());
        System.out.println(now.withDayOfYear(61));

        System.out.println(LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());  //0
    }
}
