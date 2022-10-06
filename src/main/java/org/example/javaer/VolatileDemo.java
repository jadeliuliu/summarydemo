package org.example.javaer;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: liuxuan
 * @date: 2022-09-12 20:14
 **/
public class VolatileDemo {

    private volatile AtomicInteger count = new AtomicInteger(0);

    @Test
    public void testVolatile() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for(int i = 0; i < 50; i++) {
                    count.incrementAndGet();
                    System.out.println(Thread.currentThread() + " count:" + count);
                    Thread.sleep(100);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for(int i = 0; i < 50; i++) {
                    count.incrementAndGet();
                    System.out.println(Thread.currentThread() + " count:" + count);
                    Thread.sleep(100);
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("count:" + count);
    }


    //private boolean tag = false;  //不会运行tag is true,exit
    //private static boolean tag = false;  //不会运行tag is true,exit
    private volatile  boolean tag = false; //会运行tag is true,exit

    @Test
    public void visibleTest() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //当tag标志变为true时结束循环并打印退出信息
                while(!tag){
                }
                System.out.println("tag is true,exit......");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                tag = true;
            }
        });

        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(2000);
    }
}
