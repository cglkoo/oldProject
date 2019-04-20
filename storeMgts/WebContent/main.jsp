<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>系统主界面</title>
<script type="text/javascript" src="wejs/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".ld").toggle(function(){
			$(this).next().show(100);
		},function(){
			$(this).next().hide(100);
		});
		
	});
</script>
<style type="text/css">
* {
	font-size: 13px;
	text-decoration: none;
}

table {
	width: 100%;
	border: 1px #23E99E solid;
	border-collapse: collapse;
}

td {
	border: 1px #23E99E solid;
	vertical-align: top;
}

#leftTD {
	width: 200px;
	background-color: #D7E5CC;
	line-height: 20px;
}

.ld {
	font-size: 16px;
	font-weight: bold;
	color: gray;
	text-indent: 1em;
	line-height: 40px;
}

.ldm {
	text-indent: 2em;
	line-height: 30px;
	display: none;
}

#current {
	float: right;
}
</style>


</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	String now=sdf.format(new java.util.Date());   //格式化当前的时间；
	String user=request.getParameter("fname");
	String pwd = request.getParameter("pwd");
	%>
	<div align="center">
		<table>
			<tr>
				<td colspan="2"
					style="background-color: #E8EFE8; height: 80px; font-size: 36px;">门店商品管理系统
					<div id="current">
						当前用户：${user } <br />日期：<span></span><br />时间：<font color="blue">
							<% out.write(now); %>
						</font><br /> <a href="index.jsp">退出系统</a>
					</div>
				</td>
			</tr>
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
				<!-- 左边的页面内容 -->
				<td id="leftTD">
					<div>
						<br>
						<div class="ld">系统管理</div>
						<div class="ldm">
							<div>
								<a href="role.jsp" target="rightFRM">角色管理</a>
							</div>
							<div>
								<a href="user.jsp" target="rightFRM">会员管理</a>
							</div>
						</div>
						<div class="ld">手机商品管理</div>
						<div class="ldm">
							<div>
								<a href="inventory.jsp" target="rightFRM">创库管理</a>
							</div>
							<div>
								<a href="stock.jsp" target="rightFRM">进货管理</a>
							</div>
							<div>
								<a href="sell.jsp" target="rightFRM">已售商品管理</a>
							</div>
						</div>
						<div class="ld">业绩管理</div>
						<div class="ldm">
							<div>
								<a href="elscores.jsp" target="rightFRM">员工业绩</a>
							</div>
							<div>
								<a href="index.jsp">销售排行榜</a>
							</div>
						</div>
						<div class="ld">门店公告管理</div>
						<div class="ldm">
							<div>
								<a href="notice.jsp" target="rightFRM">公告列表</a>
							</div>
							<div>
								<a href="addNotice.jsp" target="rightFRM">公告列表</a>
							</div>
						</div>
						<div class="ld">日志管理</div>
						<div class="ldm">
							<div>
								<a href="rzhi.jsp" target="rightFRM">日志列表</a>
							</div>
						</div>
					</div>
				</td>

				<!-- 右边的页面内容 -->
				<td id="rightTD"><iframe src="success.jsp" id="rightFrame"
						name="rightFRM" scrolling="no"
						style="width: 966px; height: 522px; border: 0;"></iframe></td>
			</tr>
		</table>
		<div align="center">&copy;2017-2077版权所有 手机门店管理系统
			管理员QQ：2477526295 欢迎商务洽谈</div>
	</div>
	<%
	if(session.getAttribute("user")!=null){
		session.removeAttribute("user");  //注销当前用户的session;
		request.setAttribute("msg", "你已经安全退出系统，欢迎下次再来！");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	%>
</body>
</html>