package org.example.javaer;

import com.google.common.collect.Lists;
import lombok.ToString;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author: liuxuan
 * @date: 2023-01-07 15:02
 **/
public class StreamTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(10).setName("11");
        System.out.println(person);
    }

    @ToString
    static class Person {
        private String name;
        private Integer age;

        public Person setName(String name) {
            this.name = name;
            return this;
        }
        public Person setAge(Integer age) {
            this.age = age;
            return this;
        }
    }

    @Test
    public void test1() {
        List<Long> list = Lists.newArrayList(1L, 2L, 3L);
        list.set(1, 4L);  //[1, 4, 3]
        System.out.println(list);
//        list.stream().max(((o1, o2) -> (int) (o1-o2))).ifPresent();


        List<Long> link = Lists.newLinkedList();
        link.add(1L);
        link.add(2L);
        link.add(3L);
        System.out.println(link.get(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<Person> emptyOpt = Optional.empty();
        System.out.println(emptyOpt);
//        emptyOpt.get(); //NoSuchElementException

        Optional<String> opt = Optional.of("11");
        System.out.println(opt.isPresent()); // 输出：true

        Optional<String> optOrNull = Optional.ofNullable(null);
        System.out.println(optOrNull.isPresent()); // 输出：false
    }
}
