package org.example.javaer;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

/**
 * @author: liuxuan
 * @date: 2022-06-19 21:32
 **/
public class DateUtilsTest {
    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void test1() {
        // 获取指定格式时间字符串
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN));
        System.out.println(date);
        // 获取当前月份
        Integer month = LocalDateTime.now().getMonth().getValue();
        System.out.println(month);
    }

    @Test
    public void test2() {
        // 时间戳
        long timeStamp = System.currentTimeMillis();
        System.out.println("时间戳：" + timeStamp);
        // 时间戳到LocalDateTime
        LocalDateTime time = new Timestamp(timeStamp).toLocalDateTime();
        System.out.println("LocatDateTime：" + time);
    }

    @Test
    public void timeStampTest() {
        // 当前时间时间戳
        long nowStamp = System.currentTimeMillis();
        System.out.println("毫秒时间戳：" + nowStamp);
        long nowhaomiao = System.currentTimeMillis() * 1000;
        System.out.println("微妙时间戳" + nowhaomiao);
        long nowhaomiao1 = System.nanoTime() / 1000;
        System.out.println("微妙时间戳1" + nowhaomiao1); //不行

        // 昨天这个时间时间戳
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        System.out.println("昨天此时：" + calendar.getTime().getTime());

        // 昨天某时间的时间戳
        Calendar calendar1 = Calendar.getInstance();
        calendar.set(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH) - 1, 23, 59, 59);
        System.out.println(calendar.getTime().getTime());

        // 时间戳转换为Date
        Date now = new Date(nowStamp);
        //如果是时间戳字符串，用下面
        //Date now1 = new Date(Long.parseLong(nowStamp));
        System.out.println("now: " + now);
        // 再转换为字符串
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        System.out.println("now: " + sdf.format(now));

        // 日期格式字符串转换为时间戳
        String s = "2022-06-25 12:12:12";
        try {
            System.out.println("时间戳：" + String.valueOf(sdf.parse(s).getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 当前时间的后几秒
        Date data = new Date(System.currentTimeMillis() + 10 * 1000);
        System.out.println(data);
    }

    @Test
    public void testDateUtils() throws ParseException {
        // 获取指定日期的开始时间
        DateFormat df = DateFormat.getDateInstance();
        Date date = df.parse("2022-06-24 14:01:01");
        Date begin = org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.DATE);
        System.out.println("初始时间：" + begin);
    }

    @Test
    public void testLocalDate() {
        //获取当前年月日
        LocalDate localDate = LocalDate.now();
        //构造指定的年月日
        LocalDate localDate1 = LocalDate.of(2019, 9, 10);
        int year = localDate.getYear();
        System.out.println(year);
        int year1 = localDate.get(ChronoField.YEAR);
        System.out.println(year1);
        Month month = localDate.getMonth();
        System.out.println(month);
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(month1);
        int day = localDate.getDayOfMonth();
        System.out.println(day);
        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);
        System.out.println(day1);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(dayOfWeek);
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);
        System.out.println(dayOfWeek1);

        LocalDateTime localDateTime1 = LocalDateTime.of(2019, 6,26, 10, 14, 46, 56);

        Instant instant = Instant.now();
        System.out.println(instant);

        LocalDate localDate2 = LocalDate.now();
        LocalDate localDate3 = localDate.with(firstDayOfYear());
        System.out.println(localDate3);
    }
    @Test
    public void CalenderTest() {
        //1.创建Calendar对象
        Calendar calendar =Calendar.getInstance();
        System.out.println(calendar.getTime());//Calender变Date
        System.out.println(calendar.getTimeInMillis());//Calender变时间戳
        Calendar calendar1 = new GregorianCalendar();
        System.out.println(calendar1.getTime()); //输出一样

        //2.获取时间信息
        //获取年
        int year = calendar.get(Calendar.YEAR);
        //月
        int month = calendar.get(Calendar.MONTH);
        //日
        int day = calendar.get(Calendar.DAY_OF_MONTH);//DATE
        //小时
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        //分钟
        int minute = calendar.get(Calendar.MINUTE);
        //秒
        int second = calendar.get(Calendar.SECOND);
        System.out.println(year+"年"+month+"月"+day+"日"+"  "+hour+"时"+minute+"分"+second+"秒");

        //修改时间
        Calendar calendar2 =Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH,5);
        System.out.println(calendar2.getTime().toLocaleString());

        //add方法修改时间
        calendar2.add(Calendar.HOUR,-1);
        System.out.println(calendar2.getTime().toLocaleString());

        //获取当月多少天
        int max = calendar2.getActualMaximum(Calendar.DAY_OF_MONTH); //30
        int min = calendar2.getActualMinimum(Calendar.DAY_OF_MONTH); //1
    }

}
