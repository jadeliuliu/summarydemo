package org.example.javaer;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: liuxuan
 * @date: 2022-11-18 09:06
 **/
public class InterruptDemo {

    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");

    public static void main(String[] args) {
//        InterruptThread t = new InterruptThread();
        Interrupt2Thread t = new Interrupt2Thread();
//        Interrupt3Thread t = new Interrupt3Thread();

        t.start();
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }

    static class InterruptThread extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 抛出InterruptedException后中断标志被清除
                    // 在catch中直接return结束线程
                    System.out.println(sdf.format(new Date()) + Thread.currentThread() + " catch " + isInterrupted() + " " + interrupted()); //false false
                    System.out.println(sdf.format(new Date()) + Thread.currentThread() + " " + isInterrupted()+ " " + interrupted()); //false false
                    return;
                }
                System.out.println(sdf.format(new Date()) + Thread.currentThread() + " " + isInterrupted()+ " " + interrupted()); //不输出
            }
        }
    }

    static class Interrupt2Thread extends Thread {

        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 抛出InterruptedException后中断标志被清除
                    // 可以再次调用interrupt恢复中断
                    // catch中再次调用interrupt恢复中断状态，while中下次判断isInterrupted()中结束线程
                    System.out.println(sdf.format(new Date()) + Thread.currentThread() + " catch " + isInterrupted()+ " " + interrupted()); //false false
                    //interrupt();
                    //如果不在catch里再中断，会一直执行
                }
                System.out.println(sdf.format(new Date()) + Thread.currentThread() + " " + isInterrupted()+ " ");
//                System.out.println(sdf.format(new Date()) + Thread.currentThread() + " " + isInterrupted()+ " " + interrupted());
                //如果用了上面的那个，中断标识为会输出true后被重置为false，继续循环，不会停
            }
        }
    }

    static class Interrupt3Thread extends Thread {

        @SneakyThrows
        @Override
        public void run() {
            while (!isInterrupted()) {
                Thread.sleep(1000);
                // 抛出InterruptedException后中断标志被清除
                // 可以再次调用interrupt恢复中断
                // catch中再次调用interrupt恢复中断状态，while中下次判断isInterrupted()中结束线程
                System.out.println(sdf.format(new Date()) + Thread.currentThread() + " catch " + isInterrupted()+ " " + interrupted()); //false false
                interrupt();
                //System.out.println(sdf.format(new Date()) + Thread.currentThread() + " " + isInterrupted()+ " ");
                System.out.println(sdf.format(new Date()) + Thread.currentThread() + " " + isInterrupted()+ " " + interrupted());
                //如果用了上面的那个，中断标识为会输出true后被重置为false，继续循环，直到在主线程内中断，抛出InterruptedException
            }
        }
    }
}
