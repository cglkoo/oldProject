<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>

<script type="text/javascript" src="myjs/jquery-3.2.1.min.js" ></script>
 
 <script type="text/javascript">
 	$(document).ready(function(){
 		
 		$("#btn").click(function(){
 			
 			window.location="reg.html";
 		});
 		
 		/*验证表单*/
 		$("#sbm").click(function(){
 			var u=$("input[name='username']").val();
 			var p=$("input[name='pwd']").val();
 			if(u==''){
 				$("span").text('用户名不能为空！');
 				$("input[name='username']").focus();
 				$("input[name='username']").addClass("redClass");
 			}else if(p==''){
 				$("input[name='username']").removeClass("redClass");
 				$("span").text('密码不能为空！');
 				$("input[name='pwd']").focus();
 				$("input[name='pwd']").addClass("redClass");
 			}else{
 				$("input[name='pwd']").removeClass("redClass");
 				document.forms[0].submit();  //提交表单；
 			}
 			
 		});
 		
 	});
 </script>
 
<style type="text/css">
 .redClass{
 	border: 1px red solid;
 }
 span{
 	color:red;
 	font-size: 20px;
 }
 </style>
 
</head>
<body>

<div align="center"><span>${msg}</span>
<form action="login" method="post" name="lgForm">
<p>用户：<input name="username"/></p>
<p>密码：<input name="pwd" type="password"/></p>
<p> <input  id="sbm"  type="button" value="登录"/>  <input id="btn" type="button" value="注册"/></p>
</form>
</div>
</body>
</html>