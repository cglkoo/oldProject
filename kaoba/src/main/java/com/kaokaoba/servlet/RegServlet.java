package com.kaokaoba.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaokaoba.log.ILogService;
import com.kaokaoba.log.LogServiceImpl;
import com.kaokaoba.user.IUserService;
import com.kaokaoba.user.UserServiceImpl;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
		response.setContentType("text/html; charset=UTF-8");
		String user=request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String sql ="insert into tbl_user (userName,userPwd) values (?,?)";
		IUserService ius = new UserServiceImpl();
		int num= ius.addOrUpdateOrDelete(sql, user.trim(),pwd.trim());
		PrintWriter out = response.getWriter();
		if(num>0){
			
			out.println("<h1>恭喜你注册成功！</h1>");
			 
		}else{
			 
			out.println("<h1>注册失败！</h1>");
			 
		}
		 
		out.println("<br/><a href='login.jsp'>欢迎登录</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
