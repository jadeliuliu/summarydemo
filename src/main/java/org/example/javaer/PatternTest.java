package org.example.javaer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: liuxuan
 * @date: 2022-05-28 14:58
 **/
public class PatternTest {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("\\d+","22.23"));//返回true
        System.out.println(Pattern.matches("\\d+","2223aa"));//返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到
        Pattern.matches("\\d+","22bb23");//返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到

        String str = "11";
        String paternStr = "\\d+";
        Pattern pattern = Pattern.compile(paternStr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            System.out.println(matcher.group(0));
        }
    }
}
