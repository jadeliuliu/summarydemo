package org.example.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: liuxuan
 * @date: 2022-07-31 22:57
 **/
@WebServlet("/sess01")
public class SessionDemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // session对象的获取,
        HttpSession session = req.getSession();
        // 获取session的唯一标识--会话标识符
        String id = session.getId();
        System.out.println("唯一标识符号："+id);
        System.out.println("创建时间："+session.getCreationTime());
        System.out.println("最后一次访问时间："+session.getLastAccessedTime());
        System.out.println("是否是新的session对象"+session.isNew());

        session.setAttribute("uname", "lili");
        session.setAttribute("pwd", "123");
        session.removeAttribute("pwd");
        req.setAttribute("name", "lili");
        // 请求转发跳转到jsp页面，请求转发，一次请求，request可以拿到，session也可以拿到
        //req.getRequestDispatcher("sess01.jsp").forward(req, resp);
        // 重定向跳转到jsp页面,两次请求，request失效，但是session可以拿到
        resp.sendRedirect("sess01.jsp");
    }
}
