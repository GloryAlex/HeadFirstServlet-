package Chapter6;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        var context = sce.getServletContext();
        String dogBreed = context.getInitParameter("dogBreed");
        Dog littleDog = new Dog(dogBreed);
        context.setAttribute("dog", littleDog);
        System.out.println("Binding dog complete!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Do nothing
    }
}
