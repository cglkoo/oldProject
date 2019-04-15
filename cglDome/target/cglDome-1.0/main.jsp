<%@ page language="java" import="com.hzit.employees.*,java.util.*,java.text.SimpleDateFormat" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统主页面</title>
<style type="text/css">
*{
	font-size: 14px;
}
.logo img{
    vertical-align: middle;
    margin-left:100px;
}
.logo span{
    color:#009B72;
    font-size: 30px;
    vertical-align: middle;
    font-weight: bolder;
}
h1{
	text-align: center;
}
table{
	width:100%;
	border:1px #ddd solid;
	border-collapse: collapse;
}
td{
	border:1px #ddd solid;
	vertical-align: top;
}
#leftTD{
	width: 200px;
	background-color: #eee;
} 
h4{
   border:1px solid #ddd;
   width:150px;
   height:30px;
   color:#777;
   font-weight:bold;
   font-size: 16px;
}

li{
   line-height: 30px;
   color:#aaa;
}
#current{
	float:right;
	vertical-align: bottom;
	display: inline-block;
}
a{
	text-decoration: none;
}
.header{
	background-color: #009B72;
	height:50px;
	width:100%;
}
</style>
<script type="text/javascript" src="myjs/jquery-3.2.1.min.js" ></script>
<script type="text/javascript">
jQuery(function(){
	$("#h1,#h2,#h3,#h4,#h5").css("background-color","#f5f5f5").css("margin-top","0").css("padding-left","30px").css("line-height","30px");
	$("#p1,#p2,#p3,#p4,#p5").css("display","none");
	
	$("#h1").click(function(){
		$("#h1").css("text-decoration","underline");
		if($("#p1").css("display")=="none"){
			$("#p1").show(1000);
		}else{
			$("#p1").hide();
			$("#h1").css("text-decoration","none")
		}
		$("#p2").css("display","none")
		$("#p3").css("display","none")
		$("#p4").css("display","none")
		$("#p5").css("display","none")
		
	});
	$("#h2").click(function(){
		$("#h2").css("text-decoration","underline");
		if($("#p2").css("display")=="none"){
			$("#p2").show(1000);
		}else{
			$("#p2").hide();
			$("#h2").css("text-decoration","none")
		}
		$("#p1").css("display","none")
		$("#p3").css("display","none")
		$("#p4").css("display","none")
		$("#p5").css("display","none")
		
	});
	$("#h3").click(function(){
		$("#h3").css("text-decoration","underline");
		if($("#p3").css("display")=="none"){
			$("#p3").show(1000);
		}else{
			$("#p3").hide();
			$("#h3").css("text-decoration","none")
		}
		$("#p1").css("display","none")
		$("#p2").css("display","none")
		$("#p4").css("display","none")
		$("#p5").css("display","none")
		
	});
	$("#h4").click(function(){
		$("#h4").css("text-decoration","underline");
		if($("#p4").css("display")=="none"){
			$("#p4").show(1000);
		}else{
			$("#p4").hide();
			$("#h4").css("text-decoration","none")
		}
		$("#p1").css("display","none")
		$("#p2").css("display","none")
		$("#p3").css("display","none")
		$("#p5").css("display","none")
		
	});
	$("#h5").click(function(){
		$("#h5").css("text-decoration","underline");
		if($("#p5").css("display")=="none"){
			$("#p5").show(100);
		}else{
			$("#p5").hide();
			$("#h5").css("text-decoration","none")
		}
		$("#p1").css("display","none")
		$("#p2").css("display","none")
		$("#p3").css("display","none")
		$("#p4").css("display","none")
	});
});
</script>
</head>
<body>
<div class="header">
	<%
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	String now=sdf.format(new java.util.Date());   //格式化当前的时间；
	request.setCharacterEncoding("UTF-8");  //解决中文乱码的问题；
	String user=request.getParameter("username");
	String pwd = request.getParameter("pwd");
	String sql ="select userName,userPwd from t_employees where userName=? and userPwd=? ";
	IEmployees ius = new EmployeesImpl();
	Employees tu = null;
	List<Employees> list = ius.getUserByProperty(sql,user,pwd);
	if(list.size()>0){
		tu=list.get(0);
	}
	if(tu!=null){
		session.setAttribute("user", user);
	%>
	
</div>
<div id="current">当前用户：${user }<br/>日期：<span></span><br/>时间：<font color="blue"><% out.write(now); %></font></div>
<div class="logo">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="logout.jsp">退出系统</a><img alt="" src="jpg/logo.png"><span>专卖店管理系统</span></div>
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
<table>
<tr><td id="leftTD">
	<!-- 左边的导航菜单 -->
	<div style="height:35px;margin-top:20px;"><h4 id="h1">系统管理</h4></div>
	<div id="p1" >
	<ul>
	   <li><a href="role.jsp" target="rightFRM">角色管理</a></li>
	   <li><a href="user.jsp" target="rightFRM">会员管理</a></li>
	</ul>
	</div>
	<div style="height:35px;margin-top:30px;"><h4 id="h2">库存管理</h4></div>
	<div id="p2" >
	<ul>
	   <li><a href="inventory.jsp" target="rightFRM">门店库存</a></li>
	   <li><a href="sell.jsp" target="rightFRM">出售管理</a></li>
	   <li><a href="stock.jsp" target="rightFRM">进货管理</a></li>
	</ul>
	</div>
	<div style="height:35px;margin-top:30px;"><h4 id="h3">业绩管理</h4></div>
	<div id="p3" >
	<ul>
	   <li><a href="elscores.jsp" target="rightFRM">员工业绩</a></li>
	   <li><a href="paihang.jsp" target="rightFRM">排行榜</a></li>
	</ul>
	</div>
	<div style="height:35px;margin-top:30px;"><h4 id="h4">门店公告管理</h4></div>
	<div id="p4" >
	<ul>
	   <li><a href="notice.jsp" target="rightFRM">公告列表</a></li>
	   <li><a href="addNotice.jsp" target="rightFRM">添加公告</a></li>
	</ul>
	</div>
	<div style="height:35px;margin-top:30px;"><h4 id="h5">日志管理</h4></div>
	<div id="p5" >
	<ul>
	   <li><a href="rzhi.jsp" target="rightFRM">日志列表</a></li>
	</ul>
	</div>
	</td>
	
	<td id="rightTD"><!-- 右边的页面内容 -->
	<iframe src="success.jsp" id="rightFrame" name="rightFRM" scrolling="no"  style="width:1200px; height: 580px; border: 0;"></iframe>
	</td></tr>
</table>
<div align="center"> &copy;2017-4-17 XXX公司版权所有   oppo专卖店管理系统   </div>	
	<%  
	}else{
		//如果登录失败，则系统跳转到登录页面，重新登录。并要求提示用户：用户名或密码错误！
		request.setAttribute("msg", "用户名或密码错误！请重新登录！");
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}
	%>
</body>
</html>