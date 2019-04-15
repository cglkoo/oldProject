<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户修改页面</title>
</head>
<body>
<form action="updateUserResult" method="post">
<div align="center"> 
<input type="hidden" name="userId" value="${user.userId }"/>
<p>用户：<input name="userName" value="${user.userName }" /></p>
<p>密码：<input name="userPwd" value="${user.userPwd }"/></p>
<p><input type="submit" value="保存"/></p>
</div>
</form>
</body>
</html>