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
 * @date: 2022-07-25 23:19
 * cookie创建和发送
 **/
@WebServlet("/coo1")
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建cookie name唯一
        Cookie cookie = new Cookie("name", "pwd");
        // 发送（响应）cookie
        resp.addCookie(cookie);
    }
}
