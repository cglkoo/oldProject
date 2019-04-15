package com.kaokaoba.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class CountListener
 *
 */
@WebListener
public class CountListener implements ServletContextListener {
	ServletContext application = null;
    /**
     * Default constructor. 
     */
    public CountListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
          System.out.println("ServletContextListener:销毁了。");
          application = null;
          //写入数据库；
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
          //初始化：容器启动就调用了初始化方法；从数据库中读取数据；
    	application = arg0.getServletContext();
    	application.setAttribute("count", 30);
    	System.out.println("ServletContextListener:创建了。");
    	
    }
	
}
