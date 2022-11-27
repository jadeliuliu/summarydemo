package org.example.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: liuxuan
 * @date: 2022-07-25 23:24
 * cookie到期时间
 **/
@WebServlet("/coo3")
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 默认值-1，表示只在浏览器内存中
        // 创建Cookie对象
        Cookie cookie = new Cookie("hello","pwd");
        // 设置Cookie 3天后失效
        cookie.setMaxAge(3 * 24 * 60 * 60);
        // 发送Cookie对象 设置之后必需进行响应
        resp.addCookie(cookie);
        // 删除之前的cookie
        Cookie oldCookie = new Cookie("name", "kkk"); //删除看key，一样就删。
        oldCookie.setMaxAge(0);
        resp.addCookie(oldCookie);
    }
}
