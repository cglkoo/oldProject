<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style type="text/css">
span{
color:red;
font-size:20px;
font-family:微软雅黑;
}
p,input{
font-size:20px;
font-family:微软雅黑;
}
.redClass{
border:1px solid red;
}
.bgdiv{
	height:100%;
	padding: 100px;
	line-height: 35px;
}
h1{
	color:#009B72;
}
</style>
<script type="text/javascript" src="myjs/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	/*去除字符串前后的空格*/
	function trimSpace(str) {
		return str.replace(/(^\s+)|(\s+$)/g, "");
	}
	$(document).ready(function(){
		$("#btn").click(function(){
			window.location="reg.html";
		});
		
		//验证表单
		$("#sbm").click(function(){
			var u=$("input[name='username']").val();
	    		u = trimSpace(u);
	    	var p=$("input[name='pwd']").val();
	    		p = trimSpace(p);
 			if(u==''){
 				$("span").text('用户名不能为空！');
 				$("input[name='username']").focus();
 				$("input[name='username']").addClass("redClass");
 				return false;
 			}else if(p==''){
 				$("input[name='username']").removeClass("redClass");
 				$("span").text('密码不能为空！');
 				$("input[name='pwd']").focus();
 				$("input[name='pwd']").addClass("redClass");
 				return false;
 			}else{
 				$("input[name='pwd']").removeClass("redClass");
 				document.forms[0].submit();  //提交表单；
 			}
 		});
	});
</script>
</head>
<body>
<div align="center" class="bgdiv">
	<h1>欢迎登录OPPO商店</h1>
	<span>${msg }</span>
	<form action="main.jsp" method="post" name="lgForm">
		<p>用户名：<input name="username"/></p>
		<p>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input name="pwd" type="password"/></p>
		<p>&nbsp;<input  id="sbm" type="button" value="登录"/>&nbsp;&nbsp;&nbsp;&nbsp;<input id="btn" type="button" value="注册"/></p>
	</form>
</div>
</body>
</html>