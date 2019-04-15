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
</head>
<body>

	<!-- 导航条 -->
	<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
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
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3">
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
		                         <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
		                           <span >系统管理</span>
		                          </a>
		                    </h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in">
	                        <div class="panel-body">
	                        <ul>
	                              <li><a href="">角色管理</a></li>
	                              <li>会员管理</li>
	                            </ul>
	                        </div>
	                    </div>
					</div>
				</div>
				
				<div class="panel-group">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
		                         <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
		                           <span >敏感词汇</span>
		                          </a>
		                    </h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse in">
	                        <div class="panel-body">
	                        <ul>
	                              <li><a href="">词汇列表</a></li>
	                              <li>添加词汇</li>
	                            </ul>
	                        </div>
	                    </div>
					</div>
				</div>
				
				<div class="panel-group">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
		                         <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
		                           <span >文件上传</span>
		                          </a>
		                    </h4>
						</div>
						<div id="collapse3" class="panel-collapse collapse in">
	                        <div class="panel-body">
	                        <ul>
	                              <li><a href="fileUpload2.jsp" target="rightFRM">点击上传</a></li>
	                            </ul>
	                        </div>
	                    </div>
					</div>
				</div>
			</div>
			
			<div class="col-md-9">
				<iframe src="success.jsp" id="rightFrame" name="rightFRM" scrolling="no"  style="width:100%; height: 1500px; border: 0;">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>留意内容</th>
							<th>留意时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>今天的天气不好啊！！！</td>
							<td>2017-05-12 12:00</td>
							<td><a href="">册除</a></td>
						</tr>
						<tr>
							<td>今天的天气不好啊！！！</td>
							<td>2017-05-12 12:00</td>
							<td><a href="">册除</a></td>
						</tr>
						<tr>
							<td>今天的天气不好啊！！！</td>
							<td>2017-05-12 12:00</td>
							<td><a href="">册除</a></td>
						</tr>
						<tr>
							<td>今天的天气不好啊！！！</td>
							<td>2017-05-12 12:00</td>
							<td><a href="">册除</a></td>
						</tr>
					</tbody>
					
				</table>
				<div style="text-align:right">
					<nav aria-label="Page navigation">
					  <ul class="pagination">
					    <li>
					      <a href="#" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    <li><a href="#">1</a></li>
					    <li><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">4</a></li>
					    <li><a href="#">5</a></li>
					    <li>
					      <a href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					  </ul>
					</nav>
				</div>
			</div>
		</div>
		
	</div>
	<!-- 内容 -->
	
</body>
</html>