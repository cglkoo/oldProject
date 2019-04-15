package com.kaokaoba.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaokaoba.user.IUserService;
import com.kaokaoba.user.UserServiceImpl;

/**
 * Servlet implementation class Reg2Servlet
 */
@WebServlet("/Reg2Servlet")
public class Reg2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
		response.setContentType("text/html; charset=UTF-8");
		String userName = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String userIcon = request.getParameter("userIcon");
		String sql ="insert into tbl_user (userName,userPwd,userIcon) values (?,?,?)";
		IUserService ius = new UserServiceImpl();
		int num= ius.addOrUpdateOrDelete(sql, userName.trim(),pwd.trim(),userIcon.trim());
		if(num > 0){
			request.setAttribute("info", "注册成功,去登录吧");
		}else{
			request.setAttribute("info", "注册失败");
		}
		request.getRequestDispatcher("/reg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
