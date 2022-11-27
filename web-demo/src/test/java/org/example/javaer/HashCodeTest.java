package org.example.javaer;

/**
 * @author: liuxuan
 * @date: 2022-11-24 00:45
 **/
/**
 *hashCode相同，不一定是同一个对象
 *同一个对象的，hashCode值一定相同
 *
 *-------------------------------------------------------------------------------
 *普通对象的HashCode值源码解释：
 * equals相同则hashCode一定一样
 *If two objects are equal according to the equals(Object) method, then calling
 *the hashCode method on each of the two objects must produce the same integer result.
 *-------------------------------------------------------------------------------
 *equals不一样，hashCode不一定不一样
 * It is not required that if two objects are unequal according to the
 *java.lang.Object.equals(java.lang.Object) method, then calling the hashCode
 *method on each of the two objects must produce distinct integer results.
 *-------------------------------------------------------------------------------
 *However, the programmer should be aware that producing distinct integer results
 *for unequal objects may improve the performance of hash tables.
 *-------------------------------------------------------------------------------
 *
 */
public class HashCodeTest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashCodeTest() {
        super();
    }

    public HashCodeTest(String name) {
        super();
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println("--------------------普通对象-----------------------");
        HashCodeTest test3=new HashCodeTest();
        HashCodeTest test4=new HashCodeTest();
        System.out.println(test3.equals(test4));//false(因为没重写还是==)
        System.out.println(test3.hashCode() == test4.hashCode());//false

        HashCodeTest test1=new HashCodeTest("我");
        HashCodeTest test2=new HashCodeTest("我");
        System.out.println(test1.equals(test2));//false(因为没重写还是==)
        System.out.println(test1.hashCode() == test2.hashCode());//false

        System.out.println("--------------------String-----------------------");
        String s1="abc";
        String s2="abc";
        System.out.println(s1.equals(s2));//true(因为重写变值比较)
        System.out.println(s1.hashCode() == s2.hashCode());//true
        System.out.println(s1==s2); //true(是一个对象)

        String s5=new String("abc");
        String s6=new String("abc");
        System.out.println(s5.equals(s6));//true(因为重写变值比较)
        System.out.println(s5.hashCode() == s6.hashCode());//true
        System.out.println(s5==s6); //false(不是一个对象)


        String s3=new String();
        String s4=new String();
        System.out.println(s3.hashCode());//0
        System.out.println(s4.hashCode());//0

        /**
         * 数值型原始类型对应的包装类(Byte,Short,Integer,Float,Double)，hashCode算法都是基于
         * 对应的原始数据类型，所以只要包装类的数值相同，那么hashCode必然相同
         *
         * Double类关于hashCode源码说明：
         * Double类的hashCode是根据对应的double值计算获得的。
         *
         * Returns a hash code for a {@code double} value; compatible with
         * {@code Double.hashCode()}.
         *
         * @param value the value to hash
         * @return a hash code value for a {@code double} value.
         * @since 1.8
         */
        /*Double类关于hashCode源码：
         * public static int hashCode(double value) {
            long bits = doubleToLongBits(value);
            return (int)(bits ^ (bits >>> 32));
        }*/
        System.out.println("--------------------原始类型对应的包装类-----------------------");
        Double d1=5.0;
        Double d2=5.0;
        System.out.println(d1.equals(d2));//true(因为重写变值比较)
        System.out.println(d1.hashCode() == d2.hashCode());//true
        System.out.println(d1==d2);//false (？？？为啥是false，和String不一样)

        Double d3=new Double(5.0);
        Double d4=new Double(5.0);
        System.out.println(d3.equals(d4));//true(因为重写变值比较)
        System.out.println(d3.hashCode() == d4.hashCode());//true
        System.out.println(d3==d4);//false
    }
}
