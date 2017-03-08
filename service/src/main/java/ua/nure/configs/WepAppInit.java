package ua.nure.configs;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WepAppInit implements WebApplicationInitializer {


    private static final String SERVLET_NAME = "Dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebAppConfig.class);
        ctx.setServletContext(servletContext);
        DispatcherServlet servlet = new DispatcherServlet();
        servlet.setApplicationContext(ctx);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet(SERVLET_NAME, servlet);
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
    }
}
