package com.kaokaoba.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaokaoba.role.IRoleService;
import com.kaokaoba.role.RoleServiceImpl;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //处理业务逻辑；
		request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
		String rName=request.getParameter("rName");
		IRoleService irs = new RoleServiceImpl();
		String sql=" insert into t_roles (rName) values (?)";
		//PrintWriter out = response.getWriter(); 
		String msg="";
		if(null!=rName){
			if(rName.trim().length()>0){
				int n=irs.addOrUpdateOrDelete(sql, rName);
				if(n>0){
					msg = "添加角色成功！";
				}else{
					msg = "添加角色失败！";
				}
			}
		} 
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("addRole.jsp").forward(request, response);
		
	}

}
