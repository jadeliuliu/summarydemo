package org.example.javaer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: liuxuan
 * @date: 2022-07-02 17:49
 **/
public class AtomicIntegerTest {
    public static void main(String[] args){
        //1、默认初始值
        AtomicInteger atomicInteger = new AtomicInteger(100);
        //2、默认初始值和给定值，都是100，所以会更改成功
        boolean isSuccess = atomicInteger.compareAndSet(100,110);   //current value 100
        //3、返回true
        System.out.println(isSuccess);      //true
        System.out.println(atomicInteger);  //110
        //4、默认初始值是110,给定值是100，所以会更改失败
        isSuccess = atomicInteger.compareAndSet(100,120);       //current value 110
        //5、返回false
        System.out.println(isSuccess);      //false
        System.out.println(atomicInteger);  //110
    }
}
