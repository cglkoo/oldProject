<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退出系统</title>
</head>
<body>
<%
if(session.getAttribute("user")!=null){
	session.removeAttribute("user");  //注销当前用户的session;
	request.setAttribute("msg", "你已经安全退出系统，欢迎下次再来！");
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>
</body>
</html>