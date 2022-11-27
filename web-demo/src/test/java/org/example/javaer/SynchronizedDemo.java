package org.example.javaer;

import java.util.concurrent.TimeUnit;

/**
 * @author: liuxuan
 * @date: 2022-09-17 14:11
 **/
//资源类
class Phone{
    //1.静态方法（加锁）
    public static synchronized void sendEmail() {
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(System.currentTimeMillis() + "," + Thread.currentThread() + "-------sendEmail");
    }
    //2.普通方法（加锁）
    public synchronized void sendSMS() {
        System.out.println(System.currentTimeMillis() + "," + Thread.currentThread() + "-------sendSMS");
    }
    //3. 普通方法不加锁
    public void hello() {
        System.out.println(System.currentTimeMillis() + "," + Thread.currentThread() + "-------hello");
    }
}

//主方法
public class SynchronizedDemo{
    //一切程序的入口，主线程
    public static void main(String[] args){
        Phone phone = new Phone();//资源类1
        Phone phone2 = new Phone();//资源类2

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //phone.sendSMS(); //1、2
                //phone.hello();
                phone.sendEmail();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //phone.sendSMS(); //1、2
                //phone.hello();
                phone2.sendEmail();
            }
        });


        t1.start();
        try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        t2.start();
        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

    }
}


