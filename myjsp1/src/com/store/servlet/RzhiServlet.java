package com.store.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.rzhi.IRzhiService;
import com.store.rzhi.Rzhi;
import com.store.rzhi.RzhiServiceImpl;

@WebServlet("/RzhiServlet")
public class RzhiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RzhiServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
		response.setContentType("text/html; charset=UTF-8");
		IRzhiService irs=new RzhiServiceImpl();
		List<Rzhi> list = new ArrayList<>();
		String sql="";
		String rContent=request.getParameter("rContent")==null?"":request.getParameter("rContent");
		int pageCount=0;   //查询到的所有记录；
		 
		sql="select count(1) from t_rzhi where rContent like ? ";
		Object obj=irs.getObjectByProperty(sql,"%"+rContent+"%");
		if(obj!=null){
			pageCount=Integer.parseInt(obj.toString());
		}
		 
		int pageSize=10;   //每面的记录数量；
		int pageTotal=(pageCount%pageSize==0?pageCount/pageSize:((pageCount/pageSize)+1));  //根据pageCount与pageSize得到共有多少页？
		int pageIndex=(request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex")));  //当前第几页；默认是第1页；

		if(pageIndex<=0){
			pageIndex=1;
		}else if(pageIndex>=pageTotal){
			pageIndex=pageTotal;
		}

		sql="select rId,rContent,rDate from t_rzhi  where rContent like ? ORDER BY rId desc LIMIT ?,?  ";
		list = irs.getRzhisByProperty(sql,"%"+rContent+"%",(pageIndex-1)*pageSize,pageSize);
		request.setAttribute("list", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageIndex", pageIndex);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageTotal", pageTotal);
		request.getRequestDispatcher("rzhi.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
