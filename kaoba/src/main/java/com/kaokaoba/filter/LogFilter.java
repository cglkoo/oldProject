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
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/LogFilter")
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
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
		HttpServletRequest req =(HttpServletRequest)request;
		HttpServletResponse res =(HttpServletResponse)response;
		HttpSession session = req.getSession();
		String url = req.getRequestURL().toString();
		
		
		String uri = req.getRequestURI();
	 
		
		if(uri.endsWith("login.jsp") || uri.endsWith(".js") || uri.endsWith("login") ||
				uri.endsWith(".jpg") ||	uri.endsWith("test.jsp") ||	uri.endsWith("index.jsp") ||	uri.endsWith("reg.html") || uri.endsWith("reg") || session.getAttribute("user")!=null){
 
		 
			/*String userName = session.getAttribute("user").toString();
			//写入日志：
			String user=session.getAttribute("user").toString();
			ILogService igs = new LogServiceImpl();
			igs.addOrUpdateOrDelete("insert into t_log (gName) values (?)",user+":正在访问："+url );
			*/
			chain.doFilter(request, response);
		}else{
			req.setAttribute("msg", "你还没有登录，无法访问任何页面！");
			req.getRequestDispatcher("login.jsp").forward(req, res);;  //如果没有登录就去登录页面。
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
