package Chapter12;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.LogRecord;
import java.util.zip.GZIPOutputStream;

@WebFilter(urlPatterns = "*.do")
public class CompressionFilter implements Filter {
    private ServletContext context;
    private FilterConfig config;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String validEncoding = request.getHeader("Accept-Encoding");
        if (validEncoding != null && validEncoding.contains("gzip")) {
            CompressionResponseWrapper wrapResp = new CompressionResponseWrapper(response);
            wrapResp.setHeader("Content-Encoding", "gzip");
            chain.doFilter(request, wrapResp);
            GZIPOutputStream gos = wrapResp.getGZipOutputStream();
            gos.finish(); //刷新缓冲区
            System.out.println("encoding " + config.getFilterName());
        } else {
            System.out.println("Can't encoding!" + config.getFilterName());
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void destroy() {
        this.config = null;
        this.context = null;
    }
}
