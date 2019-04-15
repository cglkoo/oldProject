<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片上传</title>
<link rel="stylesheet" href="bootstrapCss/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap-fileinput/css/fileinput.min.css">
<script type="text/javascript" src="myjs/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="bootstrap-fileinput/js/fileinput.min.js"></script>
<script type="text/javascript" src="bootstrap-fileinput/js/locales/zh.js"></script>

</head>

<body>
<div class="container" style="margin-top: 50px;">
	  <div class="col-md-4"></div>
	  <div class="col-md-4" >
	  	
		  	<form action="" method="post" class="from-horizontal" role="form">
			  	<div class="col-md-12">
			  			<div class="col-md-2"></div>
			  			<div class="col-md-8"><h3>欢迎注册</h3></div>
			  			<div class="col-md-2"></div>
			  	</div>
			  	<div class="form-group">
			  		<label class="control-label">用户名：</label>
			  		<input class="form-control" placeholder="请输入用户名" name="username"/>
			  	</div>
			  	<div class="form-group">
			  		<label class="control-label">密&nbsp;码：</label>
			    	<input class="form-control" placeholder="请输入用户密码" name="userpwd"/>
			    </div>
			    <div class="form-group">
			    	<label class="control-label">头&nbsp;像：</label>
			    	<input class="" name="userIcon" type="file"/>
			    </div>
		  		<input  type="button" class="btn btn-lg btn-info btn-block" value="提&nbsp;交"/>
		  	</form>
		</div>
 	 <div class="col-md-4"></div>
 	 </div>
</body>
</body>
</html>