package Chapter12;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPServletOutputStream extends ServletOutputStream {
    GZIPOutputStream internalGzipOS;

    public GZIPServletOutputStream(ServletOutputStream outputStream) throws IOException {
        this.internalGzipOS = new GZIPOutputStream(outputStream);
    }

    @Override
    public void write(int b) throws IOException {
        internalGzipOS.write(b);
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }
}
