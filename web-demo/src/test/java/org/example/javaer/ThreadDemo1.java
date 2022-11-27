package org.example.javaer;

/**
 * @author: liuxuan
 * @date: 2022-06-27 09:15
 **/
public class ThreadDemo1 {
    public static void main(String[] args) {
        SaleThread saleThread = new SaleThread();
        //创建并开启4个线程，模拟四个售票窗口
        new Thread(new SaleThread1(), "窗口1").start();
        new Thread(new SaleThread1(), "窗口2").start();
        new Thread(new SaleThread1(), "窗口3").start();
        new Thread(new SaleThread1(), "窗口4").start();
    }
}

class SaleThread1 implements Runnable{
    private static int tickets = 40;  //多线程共享的变量
    private static Object lock = new Object();  //定义任意一个对象，用作同步代码块的锁

    @Override
    public void run(){
        for (int o = 1; o<=10; o++) {
//            synchronized (lock){
//                if(tickets>0){
                    int i = tickets;
                    try{
                        Thread.sleep(1);  //模拟售票耗时过程
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(lock.hashCode() + "  " + i);
                    int cur = tickets--;
                    System.out.println(Thread.currentThread().getName()
                            +"正在发售第"+ cur +"张票" + tickets);
//                }
//            }
        }
    }
}
