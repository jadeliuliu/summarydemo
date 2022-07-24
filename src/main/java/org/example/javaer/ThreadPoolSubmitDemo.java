package org.example.javaer;

import lombok.Data;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author: liuxuan
 * @date: 2022-07-14 09:08
 **/
public class ThreadPoolSubmitDemo {
    public static class Main {
        public static void main(String[] args) throws InterruptedException, ExecutionException {
            ExecutorService executor = Executors.newFixedThreadPool(2); //不推荐
            //创建一个Callable，3秒后返回String类型
            Callable myCallable = new Callable() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(3000);
                    System.out.println("calld方法执行了");
                    return "call方法返回值";
                }
            };
            System.out.println("提交任务之前 "+getStringDate());
            Future future = executor.submit(myCallable);
            System.out.println("提交任务之后，获取结果之前 "+getStringDate());
            System.out.println("获取返回值: "+future.get());
            System.out.println("获取到结果之后 "+getStringDate());
        }
        public static String getStringDate() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            String dateString = formatter.format(currentTime);
            return dateString;
        }
    }

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2); //不推荐这样创建
        Result res = new Result();
        Future<Result> future = executor.submit(new MyThread(res), res);
        System.out.println("返回的结果  name: " + future.get().getName()); //新名字
        System.out.println("原来的Data  name: " + res.getName()); //原来的也变成了新名字
    }

    static class MyThread implements Runnable {
        private Result result;
        public MyThread(Result result) {
            this.result = result;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("线程  执行:");
                result.setName("新名字");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Data
    public static class Result {
        String name;
    }




}
