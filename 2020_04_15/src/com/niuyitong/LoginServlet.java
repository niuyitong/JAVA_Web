package com.niuyitong;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        User user = User.login(username, password);
        if (user != null) {
            // 表示认证成功（登陆成功）
            // 1. 把 User 对象放入 Session 服务器中
            session.setAttribute("user", user);
            writer.println("登陆成功，欢迎 " + user.username + " " + user.title);
        } else {
            writer.println("没有这个用户");
        }
    }
}
