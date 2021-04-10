package Chapter5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.annotation.Resource;

@WebServlet(value = "/email", initParams = {@WebInitParam(name = "adminEmail", value = "blooper@icloud.com")})
public class GetEmail extends HttpServlet {

    //    @Resource(name = "adminEmail")
    private String email;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        var e = getServletConfig().getInitParameterNames();
//        while(e.hasMoreElements()) System.out.printf("%s\n",e.nextElement());

        email = getServletConfig().getInitParameter("adminEmail");
        resp.getWriter().printf("""
                <html><body><p>%s</p></body></html>""", email);
    }
}
