<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.kaokaoba.stock.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除通知</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
String mId=request.getParameter("mId");
 
IStockService ins = new StockServiceImpl();
String sql="delete from tb_stock where mId=? ";
 
if(null!=mId){
		int n=ins.addOrUpdateOrDelete(sql,Integer.parseInt(mId));
		response.sendRedirect("stock.jsp");	 
}
%>

</body>
</html>