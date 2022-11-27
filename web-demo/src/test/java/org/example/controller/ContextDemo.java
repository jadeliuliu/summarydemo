package org.example.controller;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: liuxuan
 * @date: 2022-08-15 09:05
 **/
@WebServlet("/con1")
public class ContextDemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getSession().getServletContext();
        //常用方法
        //获取当前服务器的版本信息
        String ServletInfo = servletContext.getServerInfo();
        System.out.println("服务器当前的版本信息：" + ServletInfo);
        //获取项目的真实路径
        String realPath = servletContext.getRealPath("/");     //表示获取根路径
        System.out.println("获取项目的真实路径：" + realPath);

        // 设置域对象
        servletContext.setAttribute("name", "张三");
        // 获取域对象
        String name = (String) servletContext.getAttribute("name");
        System.out.println(name);
        // 移除域对象
        servletContext.removeAttribute("name");
        // 获取域对象
        String name1 = (String) servletContext.getAttribute("name");
        System.out.println(name1);  //null
    }
}