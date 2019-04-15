package com.kaokaoba.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class VisitListener
 *
 */
@WebListener
public class VisitListener implements HttpSessionListener {
	private static int count=0;
    /**
     * Default constructor. 
     */
    public VisitListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
          //只要有人打开系统的任何一个页面，就会创建一个session;
    	count++;
    	System.out.println("又有一个人访问了我们和网站："+count);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	 //只要session过期就会销毁session;
    	count--;
    	System.out.println("又有一个人离开了我们和网站："+count);
    }
	
}
