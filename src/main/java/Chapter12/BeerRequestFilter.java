package Chapter12;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(urlPatterns = {"*.do"}, dispatcherTypes = DispatcherType.REQUEST)
public class BeerRequestFilter implements Filter { //每个过滤器都必须实现Filter接口
    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig; //必须实现init()方法。通常只用保存filterConfig即可
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request; //注意此处需要强转
        String name = httpReq.getRemoteUser();
        if (name != null) {
            System.out.println("User " + name + " is updating!");
            filterConfig.getServletContext().log("User " + name + " is updating!");
        } else {
            System.out.println("no name user is updating");
        }
        chain.doFilter(request, response); //调用过滤器链的下一个对象
    }

    @Override
    public void destroy() {
        //完成清理工作
    }
}
