package org.example.javaer;

/**
 * @author: liuxuan
 * @date: 2022-11-23 23:55
 **/
public class ThreadLocalExample2 {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    int local = 1;

    public static void main(String[] args) {
        ThreadLocalExample2 demo = new ThreadLocalExample2();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(() -> {
                demo.threadLocal.set((int) (Math.random() * 100D));
                demo.local = (int) (Math.random() * 100D);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("threadLocal:" +demo.threadLocal.get());
                System.out.println("local:" +demo.local);
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}


