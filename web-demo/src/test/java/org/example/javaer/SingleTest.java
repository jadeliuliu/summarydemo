package org.example.javaer;

/**
 * @author: liuxuan
 * @date: 2022-12-04 20:39
 **/
public class SingleTest {
    public static void main(String args[]) {
        Singleton s = Singleton.getInstance();
        System.out.println(s);
    }
}

class Singleton {
    private String title;
    private String content;
    //在自己内部定义自己的一个实例
    private static Singleton SINGLETON = null;
    //private 只能在自己内部供自己去访问
    private Singleton(String title, String content) {
        this.title = title;
        this.content = content;
    }
    //此静态方法供外部直接访问
    public static Singleton getInstance() {
        if (SINGLETON == null)
            SINGLETON = new Singleton("Kobe", "MVP");
        return SINGLETON;
    }

    public String toString() {
        return this.title + " - " + this.content;
    }
}

