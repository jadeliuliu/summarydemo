package org.example.javaer;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: liuxuan
 * @date: 2022-07-09 22:34
 **/
public class ListTest {
    @Test
    public void test1() {
        //List<String> list1 = new ArrayList<String>("1", "2"); 不行
        List<String> list2 = Lists.newArrayList("1", "2");
        list2.add("3");  //咩问题
        System.out.println(list2);
        List<String> list3 = Arrays.asList("1", "2");
        list3.set(1, "3"); //设置除了0、1会报错
        System.out.println(list3);
        list3.add("3");  //报错：java.lang.UnsupportedOperationException
        System.out.println(list3);
        List<String> list4 = Collections.singletonList("1");
        list4.add("2"); //报错：java.lang.UnsupportedOperationException

        String a[] = new String[] { "A", "B", "C", "D" };
        List<String> list5 = Arrays.asList(a);
    }

    @Test
    public void test2() {
        List<Long> list = Lists.newArrayList(1L, 2L, 3L);
        System.out.println(list.subList(1, list.size()));
        List<Long> list1 = Lists.newArrayListWithExpectedSize(3);
    }

    @Test
    public void test3() {
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
            }
        };
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            list.add(4);
        }
    }

    @Test
    public void test4() throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 30; i++){
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        };
        Thread.sleep(60 * 1000);
    }

    @Test
    public void test5() {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    }

    @Test
    @SuppressWarnings({"rawtypes"})
    public void test6() {
        List list = new ArrayList();
        list.add("123");
        list.add(1L);
        list.add(0.11d);
        for (Object o : list) {
            double a = (double) o;
        }
    }

    @Test
    public void test7() {
        Map<Long, Long> map = new HashMap<>();
        map.put(1L, 1L);
        List<Long> list = Lists.newArrayList();
        System.out.println(map.get(2L)); //null
        list.add(null); //没问题
        //list.addAll(null); //会报空指针
        //list.addAll(1L);  //addAll只能传Collection

        list.add(1L);
        list.add(3L);
        list.add(1, 2L);
        System.out.println(list);  //[null, 2, 1, 3]
    }
}
