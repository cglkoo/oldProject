<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script type="text/javascript" src="wejs/jquery-3.2.1.min.js"></script>
<style type="text/css">
.header{
	height:50px;
}
.shouye{
	font-size:20px;
}
</style>
</head>
<body>
<div class="header">
	<div class="shouye"><a href="index.jsp">首&nbsp;&nbsp;页</a></div>
	<div style="padding-right: 20px;"><a href="login.html">登录</a></div>
</div>
<div align="center">
<div>${msg}</div>   
</div>
</body>
</html>