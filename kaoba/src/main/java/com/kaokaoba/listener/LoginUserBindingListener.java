package com.kaokaoba.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class LoginUserBindingListener
 *
 */
@WebListener
public class LoginUserBindingListener implements HttpSessionBindingListener {
	private static int count = 0;
    /**
     * Default constructor. 
     */
    public LoginUserBindingListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent arg0)  { 
         //绑定； 只要有session.setAttribute();就调用此方法；
    	count++;
    	System.out.println("有一个用户session增加："+count);
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
         //解绑；只要session.removeAttribute(), invalidate(); 或者session时间过期；就解开绑定。
    	count--;
    	System.out.println("有一个用户session注销："+count);
    }
	
}
