package org.example.javaer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: liuxuan
 * @date: 2022-11-12 20:58
 **/
public class MapTest {

    @Test
    public void test1() {
        Map<String, String> map = new HashMap<>();
        map.put("11", "11");
        System.out.println(map.put("11", "22"));  //输出11
        System.out.println(map.put("22", "22"));  //输出null
        System.out.println(map.putIfAbsent("11", "33"));  //输出22
        System.out.println(map.putIfAbsent("33", "44"));  //输出33
    }

    @Test
    public void test2() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "1");
        map.put(3, "3");
        Map.Entry<Integer, String> entry = map.ceilingEntry(2);
        System.out.println(entry.getValue()); //3
    }
}
