<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功页面</title>
</head>
<body>
<div align="center">
<p>当前用户：${user }</p>
<span style="color: red;">${msg }</span> 
<table>
<tr><th>序号</th><th>用户名</th><th>操作</th></tr>
 
<c:forEach items="${list }" var="user" varStatus="s">
	<tr id="${user.uId}">
		<td>${s.index + 1 }</td>
		<td>${user.userName }</td>
		<td>${user.userIcon }</td>
		<td>
			<a href="updateUser.action?userId=${user.uId }">修改</a>
			<a href="deleteUser.action?userId=${user.uId}">删除</a>
		</td>
	</tr>
</c:forEach>
						
</table>
</div>
</body>
</html>