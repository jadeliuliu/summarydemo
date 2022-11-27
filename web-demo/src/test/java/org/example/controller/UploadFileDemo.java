package org.example.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author: liuxuan
 * @date: 2022-08-16 09:10
 **/
@MultipartConfig
@WebServlet("/upload")
public class UploadFileDemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("文件上传......");

        // 为保证数据正确性，首先设置编码
        req.setCharacterEncoding("UTF-8");

        // 获取普通表单项参数
        String uname = req.getParameter("uname"); // 表单元素中 uname 的值
        System.out.println("uname：" + uname);

        // 获取 Part 对象，上传的文件
        Part part = req.getPart("myfile"); // 表单中 file 文件域的 name 属性值

        // 通过 part 对象得到上传的文件名
        String fileName = part.getSubmittedFileName();
        System.out.println("上传的文件名：" + fileName);

        // 得到文件要存放的路径--项目路径
        String filePath = getServletContext().getRealPath("/");
        System.out.println(filePath); // 文件存放的路径
        // /Users/liuxuan/MyProject/JavaProject/java/web/target/web/

        // 保存文件到指定路径
        part.write(filePath + "/" + fileName);
    }
}
