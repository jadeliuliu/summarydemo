package org.example.javaer;

/**
 * @author: liuxuan
 * @date: 2022-11-22 23:44
 **/
public class SynchroObject extends Thread {
    private static volatile int n = 0;
    private Object lock = new Object();
    public void run() {
        for (int i = 0; i < 10; i++) {
            add();
            try {
                sleep(5);
                //测试多线程的private变量，发现多个线程对象的private变量是不同的
                System.out.println("lock hashcode:" + lock.hashCode());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //如果同步方法是static的，则多线程正确同步
    //如果同步方法不是static的，则不是正确同步
    private static synchronized void add() {
        n++;
        System.out.println(n);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threads[] = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new SynchroObject();
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join(); //等待该线程终止
        }
        System.out.println(" n= " + n);
    }
}