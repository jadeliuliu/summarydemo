package org.example.javaer;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

/**
 * @author: liuxuan
 * @date: 2022-12-23 18:31
 **/
public class PairTest {
    @Test
    public void test1() {
        Pair<Integer, String> pair = Pair.of(1, "1");
        System.out.println(pair.getLeft());
        System.out.println(pair.getKey());
        System.out.println(pair.getRight());
        System.out.println(pair.getValue());
        pair.setValue("2"); //java.lang.UnsupportedOperationException

    }
}
