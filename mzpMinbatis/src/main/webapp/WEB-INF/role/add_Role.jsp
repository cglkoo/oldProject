<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加与修改角色页面</title>
</head>
<body>
<div align="center">
<font size="100">${msg}</font>
 
<form action="update_Role.action" method="post">
 	<input  type="hidden" name="roleId" value="${roleId }"/>
 	<p>角色名称：<input name="roleName" value="${roleName }"/>
 	<p> <input type="submit" value="保存"/></p>
</form>
</div>
</body>
</html>