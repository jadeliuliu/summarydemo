package org.example.javaer;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @author: liuxuan
 * @date: 2022-06-26 22:10
 **/
public class ThreadTest {
    // 线程安全的累加
    @Test
    public void test1() {
        /**
         * 创建线程
         */
        class CreateThread implements Runnable {

            private int num = 1;
            private final Object lock = new Object(); //使用一个Java对象作为一个锁

            @Override
            public void run() {
                while(true) {
                    synchronized (lock) {
                        if (num <= 100) {
                            System.out.println("线程：" + Thread.currentThread().getName() + "  num: " + num );
                            num++;
                            //lock.notifyAll(); //不加也一样
                            //Thread.yield();  //不行
                        }
                    }
                }
            }
        }
        // 必须共用一个Runnable
        CreateThread myThread1 = new CreateThread();
        Thread thread1 = new Thread(myThread1, "thread1");
        Thread thread2 = new Thread(myThread1, "thread2");
        thread1.start();
        thread2.start();
    }

    @Test
    public void test2() throws InterruptedException {
        // 线程类还必须放前面
        class CreateThread1 implements Runnable {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程执行");
                Thread.yield(); //线程让步
                System.out.println("继续执行");
            }
        }
        Thread thread1 = new Thread(new CreateThread1(), "thread1");
        thread1.start();
        thread1.join();
        System.out.println("main线程");
        Thread.sleep(1000 * 10);
    }

    @Test
    public void test3() throws InterruptedException {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3), new ThreadPoolExecutor.AbortPolicy());

        class ThreadPoolTask implements Runnable, Serializable {
            private static final long serialVersionUID = 0;
            // 保存任务所需要的数据
            private Object threadPoolTaskData;

            ThreadPoolTask(Object tasks) {
                this.threadPoolTaskData = tasks;
            }

            public void run() {
                System.out.println(Thread.currentThread().getName() + "start .." + getTask());
                try {
                    // //便于观察，等待一段时间
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                threadPoolTaskData = null;
            }

            public Object getTask() {
                return this.threadPoolTaskData;
            }
        }

        for (int i = 1; i <= 8; i++) {
            try {
                // 产生一个任务，并将其加入到线程池
                String task = "task@ " + i;
                System.out.println("put " + task);
                threadPool.submit(new ThreadPoolTask(task));
                // 便于观察，等待一段时间
                Thread.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(10000);
        // 也可以直接用lambda表达式往线程池里加线程
        threadPool.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "start .." + "lambda");
        });
    }

    @Test
    public void test4() throws InterruptedException {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Task performed on: " + new Date() + "n" +
                        "Thread's name: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("later: " + new Date() + "n" +
                        "Thread's name: " + Thread.currentThread().getName());
            }
        };
        Timer timer = new Timer("Timer");

        long delay = 100L;
        // 第一个参数是TimeTask对象，第二个参数是延迟（只有第二个参数时执行一次），第三个参数是周期执行的周期
        timer.schedule(task, delay, 4000);
        Thread.sleep(10000);
    }

    @Test
    public void test5() throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        //ScheduledExecutorService executorService1 = Executors.newScheduledThreadPool(3);
        executorService.scheduleAtFixedRate(()->{
            try {
                Thread.sleep(2000);
            }catch (Exception ex){

            }
            System.out.println(Thread.currentThread().getName()+" run : "+ System.currentTimeMillis());
        }, 0, 1000, TimeUnit.MILLISECONDS);
        Thread.sleep(10000);
    }

    @Test
    public void test6() throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread t = new Thread(r, "myThread");
            t.setDaemon(true); //设置为守护线程
            return t;
        });

        ScheduledExecutorService executorService3 = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "myThread");
            }
        });
        ScheduledExecutorService executorService4 = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("myThread").daemon(true).build());
        ScheduledExecutorService executorService1 = new ScheduledThreadPoolExecutor(1);
        executorService2.scheduleWithFixedDelay(()->{
            try {
                Thread.sleep(2000);
            }catch (Exception ex){

            }
            System.out.println(Thread.currentThread().getName()+" go : "+ System.currentTimeMillis());
        }, 0, 1000, TimeUnit.MILLISECONDS);
        Thread.sleep(10000);
    }


}
