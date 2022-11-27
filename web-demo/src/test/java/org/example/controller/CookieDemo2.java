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
 * @date: 2022-07-25 23:21
 * 获取浏览器的所有cookie
 **/
@WebServlet("/coo2")
public class CookieDemo2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取cookie数组
        Cookie[] cookies = req.getCookies();
        // 非空判断
        if(cookies != null && cookies.length >0){
            // 遍历cookie数组
            for(Cookie cookie : cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println("名称："+name+"--值："+value);
            }
        }
    }
}