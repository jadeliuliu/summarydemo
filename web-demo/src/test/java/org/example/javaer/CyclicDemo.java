package org.example.javaer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: liuxuan
 * @date: 2022-11-18 23:02
 **/
public class CyclicDemo {

    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }

    static class BankWaterService implements Runnable {
        private final CyclicBarrier c = new CyclicBarrier(4, this);  //这里屏障解除后执行本线程。
        private final ExecutorService executor = Executors.newFixedThreadPool(4);
        private final ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

        private void count() {
            for (int i = 0; i < 4; i++) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        sheetBankWaterCount.put(Thread.currentThread().getName(), 3);
                        try {
                            c.await();
                            System.out.println(sdf.format(new Date()) + " " + Thread.currentThread().getName());
                        } catch (Exception e) {
                        }
                    }
                });
            }
        }

        @Override
        public void run() {
            int result = 0;
            for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
                result += sheet.getValue();
            }
            System.out.println(sdf.format(new Date()) + " " + "result:" + result);
            executor.shutdownNow();
        }
    }
}
