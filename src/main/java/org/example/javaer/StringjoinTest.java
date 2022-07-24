package org.example.javaer;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author: liuxuan
 * @date: 2022-05-26 19:32
 **/
public class StringjoinTest {
    public static void main(String[] args) {
        List<Long> list = Lists.newArrayList(1L, 2L, 2L);
        // 元素中类型变换
        List<String> ls = list.stream().distinct().map(String::valueOf).collect(Collectors.toList());
        // 里面的ls不能为空，必须是String元素类型
        String s = String.join(",", ls);
        System.out.println(s);

        Set<Long> set = Sets.newHashSet(1L, 2L);
        Set<Long> set1 = Sets.newHashSet(list);
        Set<Long> set2 = new HashSet<>(list);
        Set<String> ss = set.stream().map(i->String.valueOf(i)).collect(Collectors.toSet());
        s = String.join(",", ss);
        System.out.println(s);

//        List<Long> list1 = null;
//        Set<Long> set1 = Sets.newHashSet(list1);
//        System.out.println("set:"+set1);

        //Set<Long> set2 = null;
        String s2 = String.join(",", set2.stream().map(String::valueOf).collect(Collectors.toSet()));
        System.out.println(s2);

        List<Long> list2 = new ArrayList<>(set1);
        List<Long> list3 = Lists.newArrayList(set1);
    }
}
