<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="myjs/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- fileinput -->
<link href="bootstrap-fileinput/css/fileinput.min.css" rel="stylesheet">
<script type="text/javascript" src="bootstrap-fileinput/js/fileinput.min.js"></script>
<script type="text/javascript" src="bootstrap-fileinput/js/locales/zh.js"></script>
<script type="text/javascript" src="bootstrap-fileinput/themes/explorer/theme.min.js"></script>
<!-- fileinput -->
</head>
<body>

	<div class="container" style="margin-top:50px;">
		<div class="row">
			<div class="col-md-6" style="height:300px;">
				<input id="userImg" name="userImg" type="file" class="file-loading"/>
			</div>
		</div>
	</div>

<script type="text/javascript">
$(function(){
	 $("#userImg").fileinput({
       language: 'zh',//设置语言
       uploadUrl: "fileupload",//上传的地址
		 uploadExtraData: function() {//扩展参数
           return {"bankId":"111111","userId":"admin"};
       },
       allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
       showUpload: true, //是否显示上传按钮
       showCaption: false,//是否显示标题
       browseClass: "btn btn-primary", //按钮样式
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
	   alert("上传成功");
	   console.log(data);
	   console.log(data.response);
	   alert(data.response.data);
	   window.open("http://localhost:8080/kaoba/" + data.response.data);
   });
});
</script>
</body>
</html>