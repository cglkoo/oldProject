<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.store.notice.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除公告 </title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
	String nId=request.getParameter("nId");
	INoticeService ins = new NoticeServiceImpl();
	String sql=" delete from tb_notice where nId=? ";
	if(null!=nId){
			int n=ins.addOrUpdateOrDelete(sql,Integer.parseInt(nId));
			response.sendRedirect("notice.jsp");
	}
	%>
</body>
</html>