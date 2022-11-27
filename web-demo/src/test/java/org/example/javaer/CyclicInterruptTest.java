package org.example.javaer;

import java.util.concurrent.CyclicBarrier;

/**
 * @author: liuxuan
 * @date: 2022-11-19 18:37
 **/
public class CyclicInterruptTest {
    public static void main(String[] args) {
        CyclicBarrier c = new CyclicBarrier(3);
        Thread thread = new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println(e);
            }
            System.out.println(2);
        });
        thread.start();
        thread.interrupt();
        try {
            c.await();
        } catch (Exception e) {
            System.out.println(c.isBroken());
//            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println(1);
    }

}
