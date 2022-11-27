package org.example.javaer;

/**
 * @author: liuxuan
 * @date: 2022-06-27 09:15
 **/
public class ThreadDemo {
    public static void main(String[] args) {
        //创建并开启4个线程，模拟四个售票窗口
        SaleThread saleThread = new SaleThread();
        //创建并开启4个线程，模拟四个售票窗口
        new Thread(saleThread, "窗口1").start();
        new Thread(saleThread, "窗口2").start();
        new Thread(saleThread, "窗口3").start();
        new Thread(saleThread, "窗口4").start();
    }
}

class SaleThread implements Runnable{
    //大前提：票得是static的，除非创建线程共用一个SaleThread对象
    //不共用Runnable对象的话，且票不是static的，则每个线程各自卖
    private Integer tickets = 20;  //多线程共享的变量
    //定义任意一个对象，用作同步代码块的锁
    //如果不是static变量，达不到同步效果
    //如果是static变量，多线程对象共享该变量。正确同步。
    //如果上面创建线程用的是同一个SaleThread对象，则不管是不是static的，都是正确同步的。
    private Object lock = new Object();

    @Override
    public void run(){
        while(true){
            //synchronized (lock){
                if(tickets>0){
                    int i = tickets;
                    try{
                        Thread.sleep(1);  //模拟售票耗时过程
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    //如果lock是static，则hashcode一样。tickets的hashcode一直在变
                    System.out.println(lock.hashCode() + "  " + tickets.hashCode());
                    System.out.println(Thread.currentThread().getName()
                            +"正在发售第"+tickets--+"张票");
                }
            //}
        }
    }
}
