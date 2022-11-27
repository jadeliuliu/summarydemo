package org.example.javaer;

/**
 * @author: liuxuan
 * @date: 2022-07-30 11:17
 **/
// 通过无限递归演示堆栈溢出错误
class StackOverflow {
    public static void test(int i) {
        if (i == 0) {
            return;
        } else {
            test(i++);
        }
    }
}

public class ErrorTest {
    public static void main(String[] args) {
        // 执行StackOverflow方法
        StackOverflow.test(5);
    }

}