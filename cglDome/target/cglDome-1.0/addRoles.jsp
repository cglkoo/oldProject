<%@ page language="java" import="com.hzit.roles.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加角色 </title>
<style type="text/css">
body{
font-size:20px;
font-family:微软雅黑；
}
table{
	border: 1px #23E99E solid;
	border-collapse: collapse;
}
td{
	border: 1px #A7D7A3 solid;
	width: 200px;
	text-align: center;
}
a{
	text-decoration: none;
}
</style>

<script type="text/javascript" src="myjs/jquery-3.2.1.min.js" ></script>

<script type="text/javascript">

	/*去除字符串前后的空格*/
	function trimSpace(str) {
		return str.replace(/(^\s+)|(\s+$)/g, "");
	}
	$(document).ready(function(){
			$("button").click(function(){
				var n = $("input").val();
				n = trimSpace(n);
				if(n==''){
					$("span").text("角色名称不能为空");
					$("input").focus();
					$("input").css("border","1px solid red");
					return false;
				}else{
					document.forms[0].submit();  //提交表单
					
				}
				 
			});
		
	});
</script> 

</head>
<body>

<div align="center">
<p>&nbsp;</p>
<span style="color: red">
 
<%
request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
String roleName=request.getParameter("roleName");
IRoles irs = new RolesImpl();
String sql=" insert into t_roles (roleName) values (?)";
 
if(null!=roleName){
	if(roleName.trim().length()>0){
		int n=irs.addOrUpdateOrDelete(sql, roleName);
		if(n>0){
			%>
			<script type="text/javascript">
     			alert("添加成功！");
     			window.location="role.jsp";
			</script>
			<% 
		}else{
			out.println("添加角色失败！");
		}
	}
}else{
	out.println("添加角色页面：");
}
%>

</span>
<form action="addRoles.jsp" name="RoleForm" method="post">
	<div style="width: 580px;">
	角色名称：&nbsp;&nbsp;<input name="roleName" size="50" /> &nbsp;&nbsp;
	<br/><br/>
	<button>&nbsp;&nbsp;&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;</button></div>
</form>
<p>&nbsp;</p>
</div>

</html>