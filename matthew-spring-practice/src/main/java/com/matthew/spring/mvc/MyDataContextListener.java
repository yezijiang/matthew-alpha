package com.matthew.spring.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 在web.xml中配置<listener>
 *一但启动就可以在servlet和jsp中获取初始化参数，getServletContext().getAttribute("myData");
 *
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-09-14 19:04
 */
public class MyDataContextListener implements ServletContextListener{
    private ServletContext context = null;
    public MyDataContextListener(){}

    public void contextInitialized(ServletContextEvent sce) {
        this.context = sce.getServletContext();
        context.setAttribute("myData","this is myData");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        this.context = null;
    }
}
