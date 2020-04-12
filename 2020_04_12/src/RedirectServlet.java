import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        innerMethod(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        innerMethod(req, resp);
    }

    private void innerMethod(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //resp.setStatus(302);//无论请求是什么，二次请求都是get
        //resp.setStatus(303);//同上
        resp.setStatus(307);//保留原来方法
        resp.setHeader("Location", "redirect-success");

        //resp.sendRedirect("redirect-success");  // 其实就是 302
    }
}
