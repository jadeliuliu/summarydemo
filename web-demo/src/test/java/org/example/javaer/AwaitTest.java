package org.example.javaer;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * @author: liuxuan
 * @date: 2022-11-18 22:33
 **/
public class AwaitTest {
    public static void main(String[] args) {
        Object lock = 1;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread thread1 = new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("thread1 get lock");
                    countDownLatch.await();
                }
            }
        };
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("thread2 get lock");
            }
        });
        thread1.start();
        thread2.start();
    }
}
