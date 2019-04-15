<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="myjs/jquery-3.2.1.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-6" style="margin-top:80px;"></div>
		</div>
		<div class="row">
			<div class="col-md-5"></div>
			<div class="col-md-5">
				<form action="" class="form-horizontal" role="form">
					<div class="form-group">
						<div class="col-md-8">
							<h3>用户登录</h3>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-8">
							<input type="text" name="userName" class="form-control" placeholder="请输入登录用户名" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-8">
							<input type="password" name="password" class="form-control" placeholder="请输入登录密码"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-8">
							<input type="button" value="登录" class="btn btn-lg btn-info btn-block"/>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-2"></div>
	</div>

</body>
</html>