<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.kaokaoba.role.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加通告 </title>
 

</head>
<body>

<div align="center">
<p>&nbsp;</p>
<span style="color: red">
 
<%
request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
String rId=request.getParameter("rId");
 
IRoleService ius = new RoleServiceImpl();
String sql=" delete from t_roles where rId=? ";
 
if(null!=rId){
	 
		int n=ius.addOrUpdateOrDelete(sql,Integer.parseInt(rId));
		response.sendRedirect("role.jsp");
		 
}
%>


</span>
 
 

 
</div>

</body>
</html>