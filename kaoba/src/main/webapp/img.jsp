<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>图片上传</title>
<link href=css/bootstrap.min.css rel="stylesheet">
<script type="text/javascript" src=myjs/jquery-3.2.1.min.js></script>
<script type="text/javascript" src=js/bootstrap.min.js></script>
<!-- fileinput -->
<link href=bootstrap-fileinput/css/fileinput.min.css rel="stylesheet">
<script type="text/javascript" src="bootstrap-fileinput/js/fileinput.min.js"></script>
<script type="text/javascript" src="bootstrap-fileinput/js/locales/zh.js"></script>
<script type="text/javascript" src="bootstrap-fileinput/themes/explorer/theme.min.js"></script>


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
</script>
</head> 
<body>
<div class="container"> 
    <div class="row">
        <div class="col-md-6" style="height:500px;width:500px;">
        <input type="file" class="file-loading" id="userImg" name="userName"/>
        </div>
    
    </div>


</div>
</body>
</html>