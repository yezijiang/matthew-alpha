package com.matthew.springboot.chapterTwo.javaconfig;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Registration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-06-26 16:07
 */
public class WebInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        ctx.setServletContext(servletContext);
        Registration.Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));
        ((ServletRegistration.Dynamic) servlet).addMapping("/");
        ((ServletRegistration.Dynamic) servlet).setLoadOnStartup(1);
        System.out.println("启动");

    }
}
