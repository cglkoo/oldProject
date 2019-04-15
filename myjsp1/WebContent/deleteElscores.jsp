<%@ page language="java" import="com.store.elscore.*,java.util.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除员工业绩</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
	String elscoreId=request.getParameter("elscoreId");
	IElScoresService ius = new ElScoresServiceImpl();
	String sql="delete from tb_elscores where elscoreId=? ";
	if(null!=elscoreId){
			int n=ius.addOrUpdateOrDelete(sql,Integer.parseInt(elscoreId));
			response.sendRedirect("elscores.jsp");	 
	}
	%>
</body>
</html>