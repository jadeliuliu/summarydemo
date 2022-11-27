package org.example.javaer;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author: liuxuan
 * @date: 2022-07-08 21:58
 **/
public class ClassTest {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException, IOException {
        Class cl = getClass();
        System.out.println(cl); //class org.example.javaer.ClassTest
        String name = cl.getName(); // org.example.javaer.ClassTest
        System.out.println(name);
        Object classTest = cl.newInstance(); //创建实例
        ClassLoader classLoader = cl.getClassLoader(); //获取类加载器
        System.out.println(classLoader);
        String packName = cl.getPackage().getName();
        System.out.println(packName); //org.example.javaer
        //getResourceAsStream从项目下文件中获取输入流
        InputStream in = cl.getResourceAsStream("/hi.md"); //加"/"，/表示src/test/resources下（ClassPath根目录）
        System.out.println(IOUtils.toString(in, String.valueOf(StandardCharsets.UTF_8)));
        //读取为字节数组
        byte[] bytes = IOUtils.toByteArray(in);
        System.out.println(bytes);
        InputStream in1 = cl.getResourceAsStream("src/test/resources/hi.md"); //不行，NPE
        System.out.println(IOUtils.toString(in1, String.valueOf(StandardCharsets.UTF_8)));
    }

    @Test
    public void test2() throws IOException {
        // 1.获取ClassPath根路径（类加载根路径），到src/test/resources，两种方法
        String path1 = getClass().getResource("/").toString(); //file:/Users/liuxuan/MyProject/JavaProject/java/web/target/test-classes/
        System.out.println("ClassPath根路径：" + path1);
        System.out.println("项目路径：" + getClass().getClassLoader().getResource("")); //和上面一样

        // 2.获取绝对路径
        String path2 = getClass().getResource("").toString(); //file:/Users/liuxuan/MyProject/JavaProject/java/web/target/classes/org/example/javaer/
        System.out.println("绝对路径：" + path2);

        // 3.获取项目路径 两种方法
        File dir = new File(""); //参数为空
        String path3 = dir.getCanonicalPath(); ///Users/liuxuan/MyProject/JavaProject/java/web
        System.out.println("项目路径：" + path3);
        String path4 = System.getProperty("user.dir"); ///Users/liuxuan/MyProject/JavaProject/java/web
        System.out.println("项目路径：" + path4);
        String allPath = System.getProperty("java.class.path"); //所有jar包的路径
        System.out.println("java类路径：" + allPath);

        // 再看看
        String path5 = getClass().getResource("/").getPath(); //这样获得的前面没有file
        System.out.println("ClassPath根路径：" + path5);
        URL url = getClass().getClassLoader().getResource(""); //file:/Users/liuxuan/MyProject/JavaProject/java/web/target/test-classes/
        System.out.println(url);
    }

    @Test
    public void test3() {
        // 1.直接
        Student stu1 = new Student();
        stu1.setNumber(12345);
        Student stu2 = stu1;
        stu2.setNumber(54321);
        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());  //改2，1跟着也改了
        //原因出在(stu2 = stu1) 这一句。
        //该语句的作用是将stu1的引用赋值给stu2。其实，stu1和stu2在堆内存中指向的是同一个对象

        // 2.新建一个，再set
        Student stu3 = new Student();
        stu3.setNumber(stu1.getNumber());
        stu3.setNumber(111);
        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生3:" + stu3.getNumber());  //改2，1不会跟着也改了
    }

    @Test
    public void test4() {
        // 1.浅拷贝
        Student stu1 = new Student();
        stu1.setNumber(1);
        stu1.setName("ll");
        stu1.setTeacher(new Teacher(23));
        Student stu2 = (Student)stu1.clone();
        stu2.setNumber(2);
        stu2.setName("oo");
        //stu2.setTeacher(new Teacher(24)); //新建不对
        stu2.getTeacher().setAge(24);
        System.out.println("学生1:" + stu1 + " hashCode:" + stu1.hashCode());
        //ClassTest.Student(number=1, name=ll, teacher=ClassTest.Teacher(age=24)) hashCode:1407343478
        System.out.println("学生2:" + stu2 + " hashCode:" + stu2.hashCode());
        //ClassTest.Student(number=2, name=oo, teacher=ClassTest.Teacher(age=24)) hashCode:1940447180
        System.out.println("teacher的hashCode：" + stu1.getTeacher().hashCode() + " " + stu2.getTeacher().hashCode());
        //teacher的hashCode：83 83
    }

    @ToString
    static class Student implements Cloneable {
        private int number;
        private String name;
        private Teacher teacher;
        public int getNumber() {
            return number;
        }
        public void setNumber(int number) {
            this.number = number;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }
        public Teacher getTeacher() {return teacher;}
//        //浅拷贝
//        @Override
//        public Object clone() {
//            try{
//                return super.clone();
//            }catch(CloneNotSupportedException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
        //深拷贝
        @Override
        public Object clone() {
            try{
                Student stu = (Student)super.clone();
                stu.setTeacher((Teacher)this.teacher.clone());
                return stu;

            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Data
    class Teacher implements Cloneable{
        private Integer age;
        Teacher(Integer age) {
            this.age = age;
        }
        @Override
        public Object clone() {
            try{
                return super.clone();
            }catch(CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


}
