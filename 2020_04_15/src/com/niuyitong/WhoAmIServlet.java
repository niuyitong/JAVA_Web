package com.niuyitong;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/who-am-i")
public class WhoAmIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if (user == null) {
            writer.println("我不知道你是谁");
        } else {
            writer.println("你是 " + user.username + " " + user.title);
        }
    }
}
