package Chapter12;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.FilterConfig;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

public class CompressionResponseWrapper extends HttpServletResponseWrapper {
    private GZIPServletOutputStream servletGzipOS = null;
    private PrintWriter printWriter = null;
    private Object streamUsed = null;

    public CompressionResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public void setContentLength(int len) {
    }

    public GZIPOutputStream getGZipOutputStream() throws IOException {
        return this.servletGzipOS.internalGzipOS;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (streamUsed != null && streamUsed != printWriter) throw new IllegalStateException();
        if (servletGzipOS == null) {
            servletGzipOS = new GZIPServletOutputStream(getResponse().getOutputStream());
            streamUsed = servletGzipOS;
        }
        return servletGzipOS;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (streamUsed != null && streamUsed != servletGzipOS) throw new IllegalStateException();

        if (printWriter == null) {
            printWriter = new PrintWriter(
                    new OutputStreamWriter(
                            new GZIPServletOutputStream(getResponse().getOutputStream())
                            , getResponse().getCharacterEncoding()
                    )
            );
            streamUsed = printWriter;
        }
        return printWriter;
    }
}
