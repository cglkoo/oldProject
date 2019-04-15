package com.kaokaoba.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaokaoba.listener.LoginUserBindingListener;
import com.kaokaoba.user.IUserService;
import com.kaokaoba.user.TBlUser;
import com.kaokaoba.user.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		//System.out.println("实例化方法...");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// 初始化方法；

		//System.out.println("初始化方法...");

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// 销毁的方法；
		System.out.println("销毁的方法...");
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // 得到session;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(new java.util.Date()); // 格式化当前的时间；

		String user = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String sql = "select uId,userName,userPwd from   tbl_user where userName=? and userPwd=? ";
		IUserService ius = new UserServiceImpl();
		TBlUser tu = null;
		List<TBlUser> list = ius.getUsersByProperty(sql, user, pwd);
		if (list.size() > 0) {
			tu = list.get(0);
		}
		if (tu != null) {
			session.setAttribute("user", user); // 登录的标志！
			//System.out.println(request.getRemoteAddr());
			LoginUserBindingListener listener = new LoginUserBindingListener();   //实例化； 对于每一个会话过程均启动一个监听器
			session.setAttribute("listener", listener); // 将监听器植入HttpSession，这将激发监听器调用
		    request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			// 如果登录失败，则系统跳转到登录页面，重新登录。并要求提示用户：用户名或密码错误！
			request.setAttribute("msg", "用户名或密码错误！请重新登录！");

			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * JspFactory fac=JspFactory.getDefaultFactory(); PageContext
		 * pageContext=fac.getPageContext(this, request,response, null, false,
		 * JspWriter.DEFAULT_BUFFER, true);
		 */
		doGet(request, response);
	}

}
