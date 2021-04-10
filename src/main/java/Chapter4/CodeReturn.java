package Chapter4;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/getJar")
public class CodeReturn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/jar");

        ServletContext ctx = getServletContext();
        InputStream input = ctx.getResourceAsStream("/resources/spring-ui.jar");

        OutputStream output = resp.getOutputStream();
        byte[] bytes = new byte[1024];
        int readLength = 0;
        while ((readLength = input.read(bytes)) != -1) {
            output.write(bytes, 0, readLength);
        }
        output.flush();
        output.close();
    }
}
