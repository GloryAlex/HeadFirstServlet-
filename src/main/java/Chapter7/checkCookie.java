package Chapter7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkCookie.do")
public class checkCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        for (var cookie : cookies) {
            if (cookie.getName().equals("username")) {
                out.println("Hello, " + cookie.getValue());
                return;
            }
        }
        out.println("Sorry, I don't get your name!");
    }
}
