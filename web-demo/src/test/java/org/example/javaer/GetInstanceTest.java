package org.example.javaer;

/**
 * @author: liuxuan
 * @date: 2022-12-04 20:29
 **/
public class GetInstanceTest {
    public static void main(String args[])
    {
        Person p = Person.getInstance("Limbo");
        p.eat();
    }
}

abstract class Person {
    private String title;
    public Person(String title) {
        this.title = title;
    }
    abstract public void eat();
    public static  PersonImpl getInstance(String title) {
        return new PersonImpl(title);
    }
    //必须static：
    static class PersonImpl extends Person
    {
        public PersonImpl(String title) {
            super(title);
        }
        @Override
        public void eat()
        {
            System.out.println("Eat!!!");
        }
    }
}
