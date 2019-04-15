package com.kaokaoba.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaokaoba.msg.*;
/**
 * Servlet implementation class MsgServlet
 */
@WebServlet("/MsgServlet")
public class MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MsgServlet中的doGet()方法");
		doPost(request,response);   //调用doPost()；
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //查询所有留言信息，并展示出来。
		System.out.println("MsgServlet中的doPost()方法:查询所有的留言信息");
		IMsgService ims = new MsgServiceImpl();
		List<Msg> list = ims.getMsgsByProperty("select mId,mName,mDate,mStatus from t_msg");
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("allmsg.jsp").forward(request, response);
		//转发页面到allmsg.jsp;
		
	}

}
