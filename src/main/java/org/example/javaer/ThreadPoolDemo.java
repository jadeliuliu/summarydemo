package org.example.javaer;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: liuxuan
 * @date: 2022-07-02 10:55
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 4, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(6),
                new ThreadFactory() {
                    AtomicInteger id = new AtomicInteger(0);
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "thread-poolName-" + id.incrementAndGet());
                    }
                });
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        //可以直接用lambda表达式：
        threadPool.submit(() -> System.out.println(Thread.currentThread().getName()));
        threadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        threadPool.shutdown();
    }
}
