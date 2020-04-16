package com.niuyitong;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/set-cookie")
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 手动设置状态头的方式设置
        /*
        resp.setHeader("Set-Cookie", "mingzi=peixinchen");
        */

        // 通过 Cookie 对象设置 Cookie 信息
        Cookie cookie = new Cookie("mingzi", "peixinchen");
        cookie.setMaxAge(10 * 60);  // 600秒后过期
        resp.addCookie(cookie);
    }
}
