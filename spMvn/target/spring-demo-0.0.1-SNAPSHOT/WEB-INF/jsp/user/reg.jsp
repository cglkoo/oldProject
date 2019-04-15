<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type"  content="text/html; charset=UTF-8">

<title>用户注册和图片上传</title>

<link href="${rc.getContextPath() }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${rc.getContextPath() }/static/bootstrap-fileinput/css/fileinput.min.css" rel="stylesheet">
<script type="text/javascript" src="${rc.getContextPath() }/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath() }/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath() }/static/bootstrap-fileinput/js/fileinput.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath() }/static/bootstrap-fileinput/js/locales/zh.js"></script>
<script type="text/javascript" src="${rc.getContextPath() }/static/bootstrap-fileinput/themes/explorer/theme.min.js"></script>

<style type="text/css">
.redClass{
 	border: 1px red solid;
}
</style>

</head>
<body>
<div class="container">
		<div class="row" style="margin-top:40px;">
			<div class="col-md-3"></div>
			<div class="col-md-6">
			    <form class="form form-horizontal" method="post" action="add">
			   		 <div class="form-group">
						<div class="col-sm-2"><label class="control-label"></label></div>
						<div class="col-sm-8" style="text-align: center;"><h3>欢迎注册</h3></div>
					</div>	  	
				  	<div class="form-group">
						<div class="col-sm-2"><label class="control-label"></label></div>
						<div class="col-sm-8" style="text-align: center;color:red;font-size:18px;" id="info">${info }</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2"><label class="control-label">用户名</label></div>
						<div class="col-sm-8">
						<input class="form-control" name="userName" id="userName" onblur="checkName(this.value)"></div>
						
					</div>
					<div class="form-group">
						<div class="col-sm-2"><label class="control-label">用户密码</label></div>
						<div class="col-sm-8"><input type="password" class="form-control" name="userPwd"></div>
					</div>
				    <div class="form-group">
				   		<div class="col-sm-2"><label class="control-label">头像</label></div>
				   		<div class="col-sm-9">
							<div class="container">
								<div class="row">
									<div style="width:400px;height:300px;">
									    <input type="hidden" name="userIcon" id="userIcon">
										<input id="userImg" name="userImg" type="file" class="file-loading" />
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group" style="margin-top: 130px;">
						<div class="col-sm-offset-2 col-sm-3">
							<input type="button" id="sbm" class="btn btn-lg btn-info btn-block" value="提交注册">
						</div>
						<div class="col-sm-3"><input type="button" id="btn" class="btn btn-lg btn-success btn-block" value="登&nbsp;录"/></div>
					</div>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
</div>
<script type="text/javascript">
function trimSpace(str) {
	return str.replace(/(^\s+)|(\s+$)/g, "");
}
$(document).ready(function(){
	 $("#userImg").fileinput({
       language: 'zh',//设置语言
       uploadUrl: "${rc.getContextPath() }/user/upload",//上传的地址
       allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
       showUpload: true, //是否显示上传按钮
       showCaption: false,//是否显示标题
       browseClass: "btn btn-primary", //按钮样式
       dropZoneEnabled: true,//是否显示拖拽区域
       minImageWidth: 50, //图片的最小宽度
       minImageHeight: 50,//图片的最小高度
       maxImageWidth: 1000,//图片的最大宽度
       maxImageHeight: 500,//图片的最大高度
       maxFileSize: 1024, //单位为kb，如果为0表示不限制文件大小
       minFileCount: 1,  //表示上传的最小文件个数
       maxFileCount: 3,  //表示允许同时上传的最大文件个数
       enctype: 'multipart/form-data',//表单类型
       validateInitialCount: true,
       initialPreviewAsData: true,
       previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
       msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！"

     }).on("fileuploaded", function(event, data){
	   alert("上传成功");
	   console.log(data);
	   console.log(data.response);
	   alert(data.response.data);
	   $("#userIcon").val(data.response.data);
	  // window.open("http://localhost:8080/${rc.getContextPath()}/" + data.response.data);
     });
	 var flag=false;//默认表单不提交
	 $("#userName").blur(function(){  //用户名进行唯一 性验证
		 var v=$("#userName").val();
		 v=trimSpace(v);
		 if(v.length>0 && v!=""){
			 $.ajax({
				type:"POST",
				url:"${rc.getContextPath() }/user/checkName",   
				data:{"userName":v},
				dataType:"json",
				success:function(response){
					if(response.data==1){
						$("#info").text("该用户名已经被使用,请输入别的用户名");
						flag = false;
					}else{
						$("#info").text("该用户名可以使用");
						flag = true;
					}
				}
			}); 
		 }
	 });
	 
	 $("#sbm").click(function(){
		var v=$("#userName").val();
		v=trimSpace(v);
		var p=$("input[name='userPwd']").val();
	    p=trimSpace(p);
	    var m=$("#userIcon").val();
	    m=trimSpace(m);
	    if(v == "" || v.length==0){
			$("#info").text("用户名不能为空！");
			$("#userName").focus();
			$("#userName").addClass("redClass");
			return false;
		}else if(p.length==0 || p==""){
			$("#userName").removeClass("redClass");
			$("#info").text('密码不能为空');
			$("input[name='userPwd']").focus();
			$("input[name='userPwd']").addClass("redClass");
			return false;
		}else if(m==''|| m.length==0){
			$("input[name='userPwd']").removeClass("redClass");
			$("#info").text('图像不能为空，请先上传图像');
			return false;
		}else if(flag==true){
			document.forms[0].submit();
		}
	 });
	
	 $("#btn").click(function(){
		window.location.href="${rc.getContextPath()}/user/login";
	 });
	 
});
function checkName(v){
	
}
</script>
</body>
</html>