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

import com.kaokaoba.log.ILogService;
import com.kaokaoba.log.LogServiceImpl;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		//req.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
		HttpSession session = req.getSession();
		String ip = req.getRemoteAddr();
		String userName = "游客";
		if(session.getAttribute("user")!=null){
			userName = 	session.getAttribute("user").toString();
		}else{
			userName=ip;
		}
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String qst = req.getQueryString();
		String detail=url+"?"+qst==null?"":qst;
		
		if(uri.endsWith("login.jsp") || uri.endsWith(".js") || uri.endsWith("login") ||
				uri.endsWith(".jpg") ||	uri.endsWith("test.jsp") ||	uri.endsWith("index.jsp") ||	uri.endsWith("reg.html") || uri.endsWith("reg") || session.getAttribute("user")!=null){
			chain.doFilter(request, response);
			

			//插入日志：
			//ILogService ils = new LogServiceImpl();
			
			//ils.addOrUpdateOrDelete("insert into t_log (gName) values (?)",new java.util.Date().toString()+":"+ userName+"访问地址："+detail) ;
		}else{
			req.setAttribute("msg", "先登录再玩好吧？");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
