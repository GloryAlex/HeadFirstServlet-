package Chapter1;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;

@WebServlet(name = "ch1Servlet", value = "/ch1")
public class Ch1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var out = resp.getWriter();
        var today = new Date();
        out.printf("""
                <html><body>
                <h1 align=center>HF's first Chapter1 Servlet</h1>
                <p>Welcome!It's %s.</p>
                </body></html>
                """, today);
    }
}
