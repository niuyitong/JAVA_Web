package com.niu;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/request-demo")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<table border='1'>");
        writer.println("<thead>");
        writer.println("<tr>");
        writer.println("<th>");
        writer.println("方法名");
        writer.println("</th>");
        writer.println("<th>");
        writer.println("结果");
        writer.println("</th>");
        writer.println("<th>");
        writer.println("解释");
        writer.println("</th>");
        writer.println("</tr>");
        writer.println("</thead>");
        writer.println("<tbody>");

        {
            String name = "req.getMethod()";
            String value = req.getMethod();
            String explain = "获取 HTTP 请求中的方法";

            printTableLine(writer, value, explain, name);
        }

        {
            String name = "req.getRequestURI()";
            String value = req.getRequestURI();
            String explain = "获取 HTTP 请求的中 URL 部分";

            printTableLine(writer, value, explain, name);
        }

        {
            String name = "req.getContextPath()";
            String value = req.getContextPath();
            String explain = "获取 URL 部分中属于 Context Path 的部分";

            printTableLine(writer, value, explain, name);
        }

        {
            String name = "req.getProtocol()";
            String value = req.getProtocol();
            String explain = "请求中的 HTTP 版本部分";

            printTableLine(writer, value, explain, name);
        }

        {
            String name = "req.getParameter(\"name\")";
            String value = req.getParameter("name");
            String explain = "URL 的 QueryString 部分的 Key 为 name 的值";

            printTableLine(writer, value, explain, name);
        }

        {
            String name = "req.getParameter(\"age\")";
            String value = req.getParameter("age");
            String explain = "URL 的 QueryString 部分的 Key 为 age 的值";

            printTableLine(writer, value, explain, name);
        }

        {
            String name = "req.getHeader(\"User-Agent\")";
            String value = req.getHeader("User-Agent");
            String explain = "获取 请求头中 Key 为 User-Agent 的值";

            printTableLine(writer, value, explain, name);
        }

        {
            // 理论上还可以获取请求体
            // GET 方法不允许有请求体
            ServletInputStream inputStream = req.getInputStream();
            InputStream is = inputStream;
        }

        writer.println("</tbody>");
        writer.println("</table>");
    }

    private void printTableLine(PrintWriter writer, String value, String explain, String name) {
        writer.println("<tr>");
        writer.println("<td>");
        writer.println(name);
        writer.println("</td>");
        writer.println("<td>");
        writer.println(value);
        writer.println("</td>");
        writer.println("<td>");
        writer.println(explain);
        writer.println("</td>");
        writer.println("</tr>");
    }
}
