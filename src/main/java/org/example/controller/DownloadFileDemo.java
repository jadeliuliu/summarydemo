package org.example.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: liuxuan
 * @date: 2022-03-31 21:59
 **/
@WebServlet("/download")
public class DownloadFileDemo extends HttpServlet {
    @Override //重写钥匙的
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("文件下载===");
        // 设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        // 乱码问题，设置编码格式
        resp.setContentType("text/html;charset=UTF-8");
        // 获取参数（得到要下载的文件名）
        String fileName = req.getParameter("fileName");
        // 参数的非空判断  trim()去除字符串前后空格，中间的不管
        if(fileName == null || "".equals(fileName.trim())){
            resp.getWriter().write("请输入要下载的文件名！");
            resp.getWriter().close();
            return;
        }
        // 得到图片存放的路径,文件放在配置好的download目录下的。
        String path = req.getServletContext().getRealPath("/download/");
        // 通过路径得到file对象
        File file = new File(path + fileName);
        System.out.println("文件："+ file);
        //地址是：/Users/liuxuan/MyProject/JavaProject/java/web/target/web/download/Taco.jsp，不是main目录下的，只能把download文件夹复制过去

        // 判断文件对象是否存在，并且是个标准文件
        if(file.exists() && file.isFile()){
            // 1.设置响应类型，设置为浏览器无法使用某种方式或激活某个程序来处理的MIME类型
            resp.setContentType("application/x-msdownload");
            // 2.设置响应头
            resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            // 3.得到file文件的输入流
            InputStream in = new FileInputStream(file);
            // 4.得到字节输出流，字符输出流文件是不行的
            ServletOutputStream out = resp.getOutputStream();
            // 5.定义byte数组
            byte[] bytes = new byte[1024];
            // 6.定义长度
            int len = 0;
            // 7.循环输出
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
            // 8.关闭资源
            out.close();
            in.close();
        } else {
            resp.getWriter().write("文件不存在，请重试！");
            resp.getWriter().close();
        }
    }
}