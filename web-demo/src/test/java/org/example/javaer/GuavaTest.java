package org.example.javaer;

import com.google.common.base.Strings;

/**
 * @author: liuxuan
 * @date: 2022-05-12 21:52
 **/
public class GuavaTest {
    public static void main(String[] args) {
        String s = null;
        System.out.println(Strings.nullToEmpty(s));
    }
}
