<%@ page language="java" import="com.hzit.roles.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除角色</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String roleId =request.getParameter("roleId");
IRoles ir = new RolesImpl();
String sql ="delete from t_roles where roleId=?";
if(null!=roleId){
	int n =ir.addOrUpdateOrDelete(sql, Integer.parseInt(roleId));
	response.sendRedirect("role.jsp");
}
%>
</body>
</html>