package com.kaokaoba.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	 
    /**
     * Default constructor. 
     */
    public LoginFilter() {
    	//System.out.println("filter destroy...");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		//System.out.println("filter destroy...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long start = System.currentTimeMillis();  //起始的时间；
		HttpServletRequest  req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session =req.getSession();  //得到session;
		req.setCharacterEncoding("UTF-8");      //解决中文乱码的问题；
		String uri = req.getRequestURI();   //得到请求的URI
		if(uri.endsWith("login.jsp") || uri.endsWith("login")|| uri.endsWith("reg.html")
				||	uri.endsWith("allmsg.jsp")	||	uri.endsWith("msg")	
				||	uri.endsWith("jquery-3.2.1.min.js") 
				|| uri.endsWith("reg")|| session.getAttribute("user")!=null){
			//哪些页面不需要过滤直接可以访问？ 登录页面，注册页面，还有js 
			chain.doFilter(request, response);   
			//可以过去；
			
		}else{
			System.out.println(uri);
			session.setAttribute("msg", "你还没有登录，别想混过去。。。");
			res.sendRedirect("login.jsp");  
			//其它不符合条件 的全部重定向到登录页面。
		}
		
		long end = System.currentTimeMillis();   //结束的时间；
		
		System.out.println("刚才的功能，执行的时间："+(end - start) +"豪秒！");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		 
		
	}

}
