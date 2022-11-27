package org.example.guava;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: liuxuan
 * @date: 2022-05-28 19:43
 **/
public class SplitterTest {

    private static final Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();

    @Test
    public void test(){
        String s = "1,2, 3";
        List<String> list = splitter.splitToList(s);
        System.out.println(list);
        List<Long> list1 = list.stream().map(Long::valueOf).collect(Collectors.toList());
        System.out.println(list1);
    }
}
