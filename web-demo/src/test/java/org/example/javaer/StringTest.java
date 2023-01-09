package org.example.javaer;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import lombok.experimental.StandardException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author: liuxuan
 * @date: 2022-06-26 18:41
 **/
public class StringTest {
    @Test
    public void test1() {
        String s = "1";
        Integer i =Integer.valueOf(s);
        System.out.println(i);
        Integer i1 = Integer.parseInt(s);
        System.out.println(i1);

        Long l = Long.valueOf(s);
        Long l1 = Long.parseLong(s);
    }

    @Test
    public void test2() {
        String s = "hello";
        System.out.println(s.substring(2)); //llo
        System.out.println(s.substring(2, 4)); //ll 左闭右开

        String str = "hello, world, ni,  hao";
        String[]  strs=str.split(",");
        for(int i=0,len=strs.length;i<len;i++){
            System.out.println(strs[i]);
        }
    }

    @Test
    public void test3() {
        // 1.直接用+，内部会替换成StringBuilder的append方法
        // 不建议在 for 循环中使用 “+” 进行字符串拼接，会创建多个StringBuilder 对象
        String s1 = "hel";
        String s2 = null;
        System.out.println(s1 + s2); //helnull  如果是null，当作字符串null来处理

        // 2.StringBuilder的append方法 （非线程安全）
        StringBuilder s3 = new StringBuilder("hel");
        System.out.println(s3.append("lo"));

        // 3.StringBuffer的append方法 （线程安全）
        StringBuffer s4 = new StringBuffer("hel");
        System.out.println(s4.append("lo"));

        // 4.String类的concat方法
        System.out.println(s1.concat("lo"));
        //System.out.println(s1.concat(null)); //NPE

        // 5.String类的静态join方法 JDK 1.8 提供，可以分隔符，也可以多个字符串
        System.out.println(String.join("", "hel", "lo")); //第一个参数为字符串连接符，后面可以是很多个字符串连接

        // 6.org.apache.commons.lang3.StringUtil的join方法
        // 不用担心 NullPointerException,内部使用的仍然是 StringBuilder
        System.out.println(StringUtils.join("hel", "lo"));
    }

    @Test
    public void test4() {
        String s1 = null;
        if(s1 == "a") System.out.println("对");
        Integer s2 = 3;
        if(s2 == null) System.out.println("对"); //对的
    }

    @Test
    public void test5() {
        System.out.println(StringUtils.equalsIgnoreCase("abc", "aBC"));
        Double d = null;
        System.out.println(d);
    }

    @Test
    public void test6() {
        String str = "111";
        System.out.println(str.getClass()+"@"+str.hashCode());
    }

    @Test
    public void test7() {
        StringBuilder sb = new StringBuilder();
        sb.append('a').append('b').append('c');
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb); //ab

        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb); //ab
    }

    @Test
    public void test8() {
        String s = "1";
        Integer i = Integer.valueOf(s);
        System.out.println(i);

        Long l = new Long(1L);
        String s1 = String.valueOf(l);
        System.out.println(s1);
        String s2 = l.toString();
        System.out.println(s2);

        l = null;
        String s3 = String.valueOf(l);
        System.out.println(s3);  //null
        String s4 = l.toString(); //NullPointerException
        System.out.println(s4);

    }
}
