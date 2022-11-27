package org.example.javaer;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: liuxuan
 * @date: 2022-11-19 19:23
 **/
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<>();
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        threadPool.execute(() -> {
            String a = "银行流水A";
            try {
                String exchange = exgr.exchange(a);
                System.out.println("B 录入的是:" + exchange + " A录入的是：" + a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(() -> {
            String b = "银行流水B";
            try {
                String exchange = exgr.exchange(b);
                System.out.println("A 录入的是:" + exchange + " B录入的是：" + b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
