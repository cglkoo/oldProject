<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link href="${rc.getContextPath() }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${rc.getContextPath() }/static/bootstrap-fileinput/css/fileinput.min.css" rel="stylesheet">

<script type="text/javascript" src="${rc.getContextPath() }/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath() }/static/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${rc.getContextPath() }/static/bootstrap-fileinput/js/fileinput.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath() }/static/bootstrap-fileinput/js/locales/zh.js"></script>
<script type="text/javascript" src="${rc.getContextPath() }/static/bootstrap-fileinput/themes/explorer/theme.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
		$("#btn").click(function(){
			window.location.href="${rc.getContextPath() }/user/reg";
		});
		/*验证表单*/
		$("#sbm").click(function(){
			var u=$("input[name='username']").val();
			var p=$("input[name='pwd']").val();
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
<div class="container" style="margin-top: 50px;">
	  <div class="col-md-4"></div>
	  <div class="col-md-4" >
	  	<div class="col-md-1"></div>
	  	<div class="col-md-10">
		  	<form action="" method="post" class="from-horizontal" role="form" id="uForm">
			  	<div class="col-md-12">
			  			<div class="col-md-2"></div>
			  			<div class="col-md-8"><h3>欢迎登录</h3></div>
			  			<div class="col-md-2"></div>
			  	</div>
			  	
			  	<div class="form-group">
			  		    <div class="col-md-2"></div>
			  			<div class="col-md-8"><span>${msg }</span></div>
			  			<div class="col-md-2"></div>
			  	</div>
			  	<div class="form-group">
			  		<input name="username" class="form-control" placeholder="请输入用户名"/>
			  	</div>
			  	<div class="form-group">
			    	<input name="pwd" type="password" class="form-control" placeholder="请输入用户密码"/>
			    </div>
		  		<input type="button" id="sbm" class="btn btn-lg btn-info btn-block" value="登&nbsp;录"/>
		  		<input type="button" id="btn" class="btn btn-lg btn-info btn-block" value="注&nbsp;册"/>
		  	</form>
		</div>
	  	<div class="col-md-1"></div>
  		</div>
 	 <div class="col-md-4"></div>
	</div>
</body>
</html>