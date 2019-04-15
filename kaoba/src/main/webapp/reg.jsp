<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="myjs/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- fileinput -->
<link href="bootstrap-fileinput/css/fileinput.min.css" rel="stylesheet">
<script type="text/javascript" src="bootstrap-fileinput/js/fileinput.min.js"></script>
<script type="text/javascript" src="bootstrap-fileinput/js/locales/zh.js"></script>
<script type="text/javascript" src="bootstrap-fileinput/themes/explorer/theme.min.js"></script>
<!-- fileinput -->
<title>用户注册</title>
</head>
<body>
	<div class="container">
		<div style="margin-top:80px;"></div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form action="reg2" class="form form-horizontal" method="post" onsubmit="return onSubmit()" >
					<input type="hidden" id="userIcon" name="userIcon">
					<div class="form-group">
						<div class="col-sm-2"><label class="control-label"></label></div>
						<div class="col-sm-8">
							<span id="info" style="color:red;">${info }</span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2"><label class="control-label">用户名</label></div>
						<div class="col-sm-8"><input type="text" class="form-control" id="username" name="username"></div>
					</div>
					<div class="form-group">
						<div class="col-sm-2"><label class="control-label">密码</label></div>
						<div class="col-sm-8"><input type="password" class="form-control" id="pwd" name="pwd"></div>
					</div>
					<div class="form-group">
						<div class="col-sm-2"><label class="control-label">头像</label></div>
						<div class="col-sm-8" style="height:300px;"><input type="file" class="form-control" id="selectImg" name="selectImg"></div>
					</div>
					<div class="form-group" style="margin-top:100px;">
						<div class="col-sm-offset-2 col-sm-10">
							<div>
								<button type="submit" class="btn btn-lg btn-primary">提交注册</button>&nbsp;
							</div>
						</div>
			  		</div>
				</form>
			</div>
			
		</div>
	</div>
	
<script type="text/javascript">
$(function(){
	 $("#selectImg").fileinput({
      language: 'zh',//设置语言
      uploadUrl: "fileupload",//上传的地址
		 uploadExtraData: function() {//扩展参数
          return {"bankId":"111111","userId":"admin"};
      },
      allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
      showUpload: true, //是否显示上传按钮
      showCaption: false,//是否显示标题
      browseClass: "btn btn-success", //按钮样式
      dropZoneEnabled: true,//是否显示拖拽区域
      minImageWidth: 50, //图片的最小宽度
      minImageHeight: 50,//图片的最小高度
      maxImageWidth: 1000,//图片的最大宽度
      maxImageHeight: 500,//图片的最大高度
      maxFileSize: 1024,//单位为kb，如果为0表示不限制文件大小
      minFileCount: 1,
      maxFileCount: 3, //表示允许同时上传的最大文件个数
      enctype: 'multipart/form-data',//表单类型
      validateInitialCount: true,
      previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
      msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！"
  }).on("fileuploaded", function(event, data){
	   $("#userIcon").val(data.response.data);
  });
});

function onSubmit(){
	var v = $("#username").val();
	if(v == "" || v == null){
		$("#info").html("用户名不能为空.");
		return false;
	}
	v = $("#pwd").val();
	if(v == "" || v == null){
		$("#info").html("密码不能为空.");
		return false;
	}
	v = $("#userIcon").val();
	if(v == "" || v == null){
		$("#info").html("请先上传图片.");
		return false;
	}
	return true;
}



</script>
</body>
</html>