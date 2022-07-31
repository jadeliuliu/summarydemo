package org.example.controller;

/**
 * @author: liuxuan
 * @date: 2022-07-24 23:24
 * 请求转发
 **/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发跳转
 * 可以让请求从服务端跳转到客户端（或跳转到指定Servlet）服务器行为
 * 特点：1。服务端行为 2。地址栏不会发生改变
 * 3。从始至终只有一个请求 4。request数据可以共享
 * 只能跳一次
 **/
@WebServlet("/demo3")
public class ServletDemo3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收客户端请求的参数
        String uname = req.getParameter("uname");
        System.out.println("ser04 uname:"+uname);
        req.setAttribute("name", "admin");
        req.setAttribute("age", 18);
        // 请求转发跳转到ser03
        req.getRequestDispatcher("demo2").forward(req, resp);
    }
}