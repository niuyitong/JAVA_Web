package com.niuyitong;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print-cookie")
public class PrintCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " = " + cookie.getValue());
            writer.println(cookie.getName() + " = " + cookie.getValue());
        }

        // 手动从请求头中获取
        /*
        String cookie = req.getHeader("Cookie");
        if (cookie == null) {
            System.out.println("没有设置 Cookie");
            writer.println("没有设置 Cookie");
        } else {
            System.out.println(cookie);
            writer.println(cookie);
        }
        */
    }
}
