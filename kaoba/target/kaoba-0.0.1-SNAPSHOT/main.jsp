<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.kaokaoba.user.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>登录结果</title>
<style type="text/css">
*{
	font-size: 14px;
}
h1{
	text-align: center;
}
table{
	width:100%;
	border:1px blue solid;
	border-collapse: collapse;
}
td{
	border:1px blue solid;
	vertical-align: bottom;
}
#leftTD{
	width: 200px;
	background-color: #ccc;
} 

dl{
	font-weight: bold;
	line-height: 50px;
	
}
#current{
	float:right;
	vertical-align: bottom;
}
</style>


<script type="text/javascript" src="myjs/jquery-3.2.1.min.js" ></script>
 
 
 
</head>
<body>

<%
 
if(session.getAttribute("user")!=null){
	 
	%>
<div align="center">
<table>
<tr><td colspan="2" style="font-size: 36px; background-color: #ccc;" >
<img  src="imgs/logo.jpg"/>考考吧在线考试管理系统
<div id="current">当前用户：${user } <br/>当前日期：<span></span><br/>
<a href="logout.jsp">退出系统</a> <font color="blue"> </font>
</div></td></tr>

<script type="text/javascript">
 	$(document).ready(function(){
 		 var now = new Date();
 		 var y=now.getFullYear();
 		 var m=now.getMonth();
 		 var d=now.getDate();
 		 var today=y+"年"+(m+1)+"月"+d+"日";
 		 $("#current span").text(today);
 	});
 </script>

<tr>
<td id="leftTD">
<!-- 左边的导航菜单 -->
<dl>
	<dt>系统管理</dt>
	<dd><a href="role.jsp" target="rightFRM">角色管理</a></dd>
	<dd><a href="user.jsp" target="rightFRM">会员管理</a></dd>
</dl>

<dl>
	<dt>敏感词汇</dt>
	<dd><a href="keywords.jsp" target="rightFRM">敏感词汇列表</a></dd>
	<dd><a href="addKeyWords.jsp" target="rightFRM">添加敏感词汇</a></dd>
</dl>


<dl>
	<dt>通告管理</dt>
	<dd><a href="notice.jsp" target="rightFRM">通告列表</a></dd>
	<dd><a href="addNotice.jsp" target="rightFRM">添加通告</a></dd> 
</dl>

<dl>
	<dt>留言管理</dt>
	<dd><a href="msg.jsp" target="rightFRM">留言列表</a></dd>
	 
</dl> 
 
</td>


<!-- 右边的页面内容 -->
<td id="rightTD" style="vertical-align: top;">
<iframe src="success.jsp" id="rightFrame" name="rightFRM" scrolling="no"  style="width:966px; height: 522px; border: 0;">

</iframe>
</td></tr>

</table>

<div align="center"> &copy;2017-2077版权所有   考考吧在线考试管理系统   管理员QQ：1302981271 欢迎商务洽谈</div>	
</div>	
	<%  
}else{
	//如果登录失败，则系统跳转到登录页面，重新登录。并要求提示用户：用户名或密码错误！
	request.setAttribute("msg", "你还没有登录，无法继续访问！");
	request.getRequestDispatcher("login.jsp").forward(request,response);
}
%>

</body>
</html>