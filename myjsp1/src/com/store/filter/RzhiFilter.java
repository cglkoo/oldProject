package com.store.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;

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

import com.store.rzhi.IRzhiService;
import com.store.rzhi.RzhiServiceImpl;


@WebFilter("/RzhiFilter")
public class RzhiFilter implements Filter {
    
    public RzhiFilter() {
        
    }
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session = req.getSession();
		String ip = req.getRemoteAddr();  //获取用户上网IP地址
		String userName ="游客";
		if(session.getAttribute("user")!=null){
			userName = 	session.getAttribute("user").toString();  //获得用户名
		}else{
			userName=ip; 
		}
		String url = req.getRequestURL().toString();   //url返回的是StringBuffer,故要转字符串
		String qst = req.getQueryString(); 
		String detail=url+"?"+qst==null?"":qst;
		
		chain.doFilter(request, response);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = sdf.format(new java.util.Date());   //格式化当前的时间

		//插入日志：
		IRzhiService ils = new RzhiServiceImpl();
		String sql="INSERT INTO t_rzhi (rContent,rDate) VALUES (?,?) ";
		ils.addOrUpdateOrDelete(sql,"访客["+userName+"]访问地址:"+detail,nowTime) ;
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
