package org.example.javaer;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author: liuxuan
 * @date: 2022-11-18 22:50
 **/
public class CyclicTest {
    public static void main(String[] args) {
        CyclicBarrier c = new CyclicBarrier(2, new A());
        new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(2);
        }).start();
        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(1);
    }

    static class A implements Runnable {

        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
