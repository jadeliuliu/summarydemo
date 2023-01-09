package org.example.javaer;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

/**
 * @author: liuxuan
 * @date: 2022-12-04 19:08
 **/
public class RandomTest {
    @Test
    public void test1() {
        int num = (int)(Math.random()*100);
        System.out.println(num);
        System.out.println((int)0.01); //0

        Random random = new Random();
        random.setSeed(10000L);
        for(int i = 0 ; i < 10 ; i ++) {
            System.out.println(random.nextInt(1000));
        }
        System.out.println("------------------");
        random = new Random();
        random.setSeed(10000L);
        for(int i = 0 ; i < 10 ; i ++) {
            System.out.println(random.nextInt(1000));
        }
    }

    public static void main(String[] args) {
        Random r = new Random();//以系统自身时间为种子数
        int i = r.nextInt();
        System.out.println("i"+i);
        Scanner sc  =new Scanner(System.in);
        int j = sc.nextInt();
        Random r2 = new Random(j);//自定义种子数
        Random r3 = new Random(j);//这里是为了验证上方的注意事项：Random类是伪随机，相同种子数相同次数产生的随机数相同
        int num  = r2.nextInt(1000);
        int num2 = r3.nextInt(1000);
        System.out.println("num"+num);
        System.out.println("num2"+num2);
    }

    @Test
    public void test3() {
        SecureRandom random = new SecureRandom();
        String returnValue = "";
        int randomInt = 0;
        int range = 9;
        for(int i=0; i<5; i++ ){
            randomInt = random.nextInt(range+1);
            returnValue = returnValue + randomInt;
        }
        System.out.println(returnValue);
    }

    @Test
    public void testSecureRandom() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(10000L);
        for(int i = 0 ; i < 10 ; i ++) {
            System.out.println(secureRandom.nextInt(1000));
        }
        System.out.println("-------------------");
        secureRandom = new SecureRandom();
        secureRandom.setSeed(10000L);
        for(int i = 0; i < 10 ; i ++) {
            System.out.println(secureRandom.nextInt(1000));
        }
    }


}
