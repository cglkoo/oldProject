<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=basePath %>myjs/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function gotoReg(){
	//window.location="register.action?userName=a";
	document.forms[0].action="register.action";
	document.forms[0].method="POST";
	document.forms[0].submit();
}
</script>
</head>
<body>
<form action="login.action" method="post" >

<div align="center">

<p style="color:red;" id="msg">${info }</p>

<p>用户：<input name="userName" id="username"/></p>

<p>密码：<input name="userPwd" id="userpwd"/></p>

<p><input type="submit" id="sbm" value="登录"/><input type="button" onclick="gotoReg()" value="注册"/></p>

</div>
</form>
<script type="text/javascript">
$(document)ready(function(){
	$("#sbm").click(function(){
		var u = $("#username").val();
		if(u==""|| u==null){
			$("#username").focus();
			$("#msg").html("用户名不能为空.");
			return false;
		}
		var p = $("#userpwd").val();
		if(p=="" || p == null){
			$("#username").focus();
			$("#msg").html("密码不能为空");
			return false;
		}
		return true;
	});
});
</script>
</body>
</html>