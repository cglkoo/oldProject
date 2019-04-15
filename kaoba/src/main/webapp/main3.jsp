<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>考考吧后台管理系统</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="myjs/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
.sidebar {
    position: fixed;
    top: 51px;
    bottom: 0;
    left: 0;
    z-index: 1000;
    display: block;
    padding: 20px;
    overflow-x: hidden;
    overflow-y: auto;
    background-color: #f5f5f5;
    border-right: 1px solid #eee;
}
.nav-sidebar {
    margin-right: -21px;
    margin-bottom: 20px;
    margin-left: -20px;
}
.nav-sidebar > li > a {
  padding-right: 20px;
  padding-left: 40px;
}
.main{
  padding-right: 20px;
  padding-left: 10px;
  font-weight: bold;
  margin-top:10px;
  margin-bottom:10px;
}
.nav-sidebar > .active > a,
.nav-sidebar > .active > a:hover,
.nav-sidebar > .active > a:focus {
  color: #fff;
  background-color: #428bca;
}
</style>
<script type="text/javascript">
function sideClick(obj){
	$(".sidebar *").each(function(){
		if($(this).hasClass("active")){
			$(this).removeClass("active");
		}
	});
	$(obj).parent().addClass("active");
}
</script>
</head>
<body>

	<!-- 导航条 -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="" class="navbar-brand">考考吧</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">留言管理 <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="">留言列表</a></li>
							<li><a href="">新增留言</a></li>
						</ul>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="">超级管理员 2017-05-12</a></li>
					<li><a href="">退出</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- 导航条 -->
	
	<!-- 内容 -->
	<div class="container-fluid" style="margin-top:50px;">
		<div class="row">
			<div class="col-md-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
		            <li class="main">系统管理 </li>
		            <li><a href="#" onclick="sideClick(this)" target="rightFRM">角色管理</a></li>
		            <li><a href="user.jsp" onclick="sideClick(this)" target="rightFRM">会员管理</a></li>
	          	</ul>
	          	<ul class="nav nav-sidebar">
		            <li class="main">敏感词汇</li>
		            <li><a href="" onclick="sideClick(this)" target="rightFRM">敏感词汇列表</a></li>
		            <li><a href="" onclick="sideClick(this)" target="rightFRM">添加敏感词汇</a></li>
	          	</ul>
		        <ul class="nav nav-sidebar">
		            <li class="main">通知管理</li>
		            <li><a href="" onclick="sideClick(this)" target="rightFRM">通知列表</a></li>
		            <li><a href="" onclick="sideClick(this)" target="rightFRM">添加通知</a></li>
		        </ul>
		        <ul class="nav nav-sidebar">
		            <li class="main">留言管理</li>
		            <li><a href="" onclick="sideClick(this)" target="rightFRM">留言列表</a></li>
		        </ul>
		        <ul class="nav nav-sidebar">
		            <li class="main">图片上传</li>
		            <li><a href="fileUpload2.jsp" onclick="sideClick(this)" target="rightFRM">点击上传</a></li>
		        </ul>
			</div>
			
			<div class="col-md-9">
				<iframe src="success.jsp" id="rightFrame" name="rightFRM" scrolling="no"  style="margin-left:200px;width:100%; height: 1500px; border: 0;"></iframe>
			</div>
		</div>
		
	</div>
	<!-- 内容 -->
	
</body>
</html>