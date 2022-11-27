package org.example.javaer;

/**
 * @author: liuxuan
 * @date: 2022-11-23 23:28
 **/
public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
        int local = 1;

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));
            local = (int) (Math.random() * 100D);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println("threadLocal:" +threadLocal.get());
            System.out.println("local:" +local);
        }

    }

    public static void main(String[] args) {

        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
