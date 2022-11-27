package org.example.javaer;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author: liuxuan
 * @date: 2022-07-04 22:33
 **/
public class FileTest {
    @Test
    public void test1() throws IOException {
        // 1. 新建文件夹
        String filePath = "/Users/liuxuan/MyProject/JavaProject/SingleFile/hello.java";
        File file = new File(filePath);
        File file1 = new File(filePath);
        boolean isSame = file.equals(file1);  //true 重写了，变值比较
        boolean isSame1 = file == file1;  //false 地址比较
        System.out.println(isSame);  //true
        if(!file.getParentFile().exists()) {
            File dirFile = file.getParentFile();
            dirFile.mkdirs();  //建立父文件夹
        }
        // 2.字节数组直接写文件，下面有加一步输出流的方式
        String filePath1 = "/Users/liuxuan/MyProject/JavaProject/SingleFile/hi.java";
        File file2 = new File(filePath1);
        if(file2.exists()) {
            boolean res = file2.delete();
            System.out.println("delete:" + res);
        }
        byte[] data = "hi".getBytes();
        byte[] data1 = "System.out.println(\"hi\")".getBytes();  //String变字节数组
        try {
            FileUtils.writeByteArrayToFile(file2, data);
            FileUtils.writeByteArrayToFile(file2, data1);  //覆写的方式
        } catch(Exception e) {
            System.out.println(e);
        }
        // 3.读取文件：用输入流 文件->输入流->字节数组
        FileInputStream in = new FileInputStream(file2);  //也有传入路径字符串的构造函数
        // 输入流变字节数组
        byte[] data2 = IOUtils.toByteArray(in);
        //String content = data2.toString();  //字节数组变String，用这个不对
        String content = new String(data2);  //得用它
        System.out.println("输入流内容：" + content);
        String content4 = Arrays.toString(data2);
        System.out.println("输入流内容：" + content4); //这样输出的是数字
        // 3.读取文件：用输入流 输入流->字节数组，另一中方法
        FileInputStream in1 = new FileInputStream(file2);
        byte[] data3 = new byte[20];
        String content3 = CharStreams.toString(new InputStreamReader(in1, Charsets.UTF_8)); //这里也消耗输入流
        System.out.println("前面获取输入流内容：" + content3);
        int num = in1.read(data3);  //输入流消耗20个字节
        System.out.println("几个字节：" + num);
        String content1 = IOUtils.toString(in1, String.valueOf(StandardCharsets.UTF_8));
        System.out.println("输入流内容：" + content1);   //这里只剩几个可以展示
        String content2 = IOUtils.toString(in1, String.valueOf(StandardCharsets.UTF_8));
        System.out.println("输入流内容2：" + content2);  //这里已经没有了
        // 4.写文件：用输出流 字节数组->输出流->文件
        String filePath2 = "/Users/liuxuan/MyProject/JavaProject/SingleFile/hi2.java";  //要写的文件，可以没建立
        File file3 = new File(filePath2);
        FileOutputStream out = new FileOutputStream(filePath2);
        byte[] data4 = "System.out.println(\"hi2\")".getBytes();
        out.write(data4);  //如果文件存在内容，则是覆盖的方式
        if(file3.exists()) System.out.println("写入成功");
        //关闭流
        IOUtils.closeQuietly(in);
        IOUtils.closeQuietly(out);
        // 5.copy文件：文件-输入流-字节数组-输出流-文件，用IOUtils.copy()一步到位
        String filePath3 = "/Users/liuxuan/MyProject/JavaProject/SingleFile/hi3.java";  //要写的文件，可以没建立
        File file4 = new File(filePath3);
        FileInputStream in3 = new FileInputStream(file3);
        FileOutputStream out2 = new FileOutputStream(file4);
        IOUtils.copy(in3, out2);
    }

    // 获取文件大小
    @Test
    public void test2() throws IOException {
        // 1.方法一：使用java io
        String filePath = "/Users/liuxuan/MyProject/JavaProject/SingleFile/hello.java";
        File file = new File(filePath);
        long size = file.length();
        System.out.println("文件大小：" + size + "B");
        // 2.方法二：使用java nio
        Path filePath1 = Paths.get("/Users/liuxuan/MyProject/JavaProject/SingleFile/hello.java");  //绝对路径
        FileChannel fileChannel = FileChannel.open(filePath1);
        long size1 = fileChannel.size();
        System.out.println("文件大小：" + size1 + "B");
        Path filePath2 = Paths.get("src/test/resources/hi.md");  //项目下路径
        FileChannel fileChannel2 = FileChannel.open(filePath2);
        long size2 = fileChannel2.size();
        System.out.println("文件大小：" + size2 + "B");
        // 3.方法三：使用  apache commons io (只能读文件夹的大小)
        String dir = "/Users/liuxuan/MyProject/JavaProject/SingleFile";
        File file1 = new File(dir);
        long size3 = FileUtils.sizeOfDirectory(file1);
        System.out.println("文件夹大小：" + size3 + "B");
        // 用户可读视角？
        String display = FileUtils.byteCountToDisplaySize(size);
        System.out.println(display);  //117 bytes
    }

    @Test
    public void test3() throws IOException {
        // 1.File转为MultipartFile：file-InputStream-MultipartFile
        String filePath = "/Users/liuxuan/MyProject/JavaProject/SingleFile/hello.java";
        File file = new File(filePath);
        URI uri = file.toURI();
        System.out.println(uri); //file:/Users/liuxuan/MyProject/JavaProject/SingleFile/hello.java
        System.out.println(file.getName());  //hello.java
        System.out.println(FilenameUtils.getExtension(file.getName()));  //后缀java
        FileInputStream in = new FileInputStream(file);
        MultipartFile mf = new MockMultipartFile(file.getName(), file.getName(), "text/plain", in);
        System.out.println(mf.getName()); //hello.java
        System.out.println(mf.getOriginalFilename());  //hello.java
        // 2.MultipartFile转为File
        try {
            String uuid = UUID.randomUUID().toString();
            //得到文件后缀
            String originalName = mf.getOriginalFilename();
            String ext = "." + FilenameUtils.getExtension(originalName);
            String fileName = uuid + ext;
            File targetFile = new File("/Users/liuxuan/MyProject/JavaProject/SingleFile/", fileName);
            //第一个参数：文件夹  第二个参数：文件名
            // 方法一：MultipartFile - 字节数组 - File本地
            FileUtils.writeByteArrayToFile(targetFile, mf.getBytes());
            // 方法二：MultipartFile - 字节数组 - 输出流 - File本地
            byte[] data = mf.getBytes();
            FileOutputStream out = new FileOutputStream(targetFile);
            out.write(data);
            IOUtils.closeQuietly(out);
            // 方法三：直接用MultipartFile内部方法
            mf.transferTo(targetFile);
        } catch (IOException e) {
            System.out.println("失败");
        }
    }

    @Test
    public void test4() throws IOException {
        String filePath = "/Users/liuxuan/MyProject/JavaProject/SingleFile/hello.java";
        File file = new File(filePath);
        OutputStream out = new FileOutputStream(file, true);
        IOUtils.write("hello", out);
        IOUtils.write("\n", out);
        IOUtils.write("hi", out);
    }

}
