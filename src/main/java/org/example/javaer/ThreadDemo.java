package org.example.javaer;

/**
 * @author: liuxuan
 * @date: 2022-06-27 09:15
 **/
public class ThreadDemo {
    public static void main(String[] args) {
        SaleThread saleThread = new SaleThread();
        //创建并开启4个线程，模拟四个售票窗口
        new Thread(saleThread, "窗口1").start();
        new Thread(saleThread, "窗口2").start();
        new Thread(saleThread, "窗口3").start();
        new Thread(saleThread, "窗口4").start();
    }
}

class SaleThread implements Runnable{
    private int tickets = 100;
    Object lock = new Object();  //定义任意一个对象，用作同步代码块的锁
    public void run(){
        while(true){
            synchronized (lock){
                if(tickets>0){
                    try{
                        Thread.sleep(100);  //模拟售票耗时过程
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                            +"正在发售第"+tickets--+"张票");
                }
            }
        }
    }
}
