package org.example.javaer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: liuxuan
 * @date: 2022-09-11 22:25
 **/
public class TestRemoveDup {

    /**
     *     TreeSet的本质是一个"有序的，并且没有重复元素"的集合，它是通过TreeMap实现的。
     *     TreeSet注意事项：
     *     如果向TreeSet集合中添加元素的时候，元素本身没有具备自然顺序的特性，并且元素所属的类也没有
     *     实现Comparable接口，那么必须在创建TreeSet对象的时候传入一个比较器；
     */
    //根据名字进行比较，相等时TreeSet会将该元素视为重复元素，不允许添加；
    private List<Person> removeDupByName(List<Person> people) {
        Set<Person> personSet = new TreeSet<>(Comparator.comparing(Person::getName));
        personSet.addAll(people);
        return new ArrayList<>(personSet);
    }

    private List<Person> removeDupByName2(List<Person> people) {
        List<Person> unique = people.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))), ArrayList::new)
        );
        return unique;
    }

    //filter的使用方式为： filter(item -> item的逻辑判断 ) ，其中filter会保留判断条件为true的记录
    private List<Person> removeDupByName3(List<Person> people) {
        //用一个name的list去重，没用TreeSet
        List<String> names = new ArrayList<>();//用来临时存储person的id

        List<Person> personList = people.stream().filter(// 过滤去重
                v -> {
                    boolean flag = !names.contains(v.getName());
                    names.add(v.getName());
                    return flag;
                }
        ).collect(Collectors.toList());
        return personList;
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("Liu",30);
        people.add(p1);
        Person p2 = new Person("Mi",36);
        people.add(p2);
        Person p3 = new Person("Liu",31);
        people.add(p3);
        TestRemoveDup testRemoveDup = new TestRemoveDup();

        List<Person> people1 = testRemoveDup.removeDupByName(people);
        List<Person> people2 = testRemoveDup.removeDupByName2(people);
        List<Person> people3 = testRemoveDup.removeDupByName3(people);
        System.out.println(people1);
        System.out.println(people2);
        System.out.println(people3);
    }

    @Getter
    @Setter
    @ToString
    @RequiredArgsConstructor
    static class Person {
        private final String name;
        private final Integer age;
    }
}


