package Chapter3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Controller Class
@WebServlet(value = {"/SelectBeer.do"})
public class BeerSelect extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        var out = resp.getWriter();
        var color = req.getParameter("color");

        out.println("<h1>Beer Expert's Suggestion</h1>");
        for (var beer : new BeerExpert().getBrands(color)) {
            out.printf("<p>Why not try %s?</p>\n", beer);
        }
    }
}
