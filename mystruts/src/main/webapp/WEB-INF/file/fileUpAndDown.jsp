<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传与下载</title>
</head>
<body>
<div align="center">
<form enctype="multipart/form-data" action="uploadfile.action" method="post">
<input type="file" name="upload"/><br/>
<input type="submit" value="提交">
</form>
<table style="text-align: center;width:100%;" cellspacing="0" border="1">
	<tr>
		<td>图片名称</td>
		<td>文件预览</td>
		<td>操作</td>
	</tr>
	<tr>
		<td>${newFile}</td>
		<td><img src="upload/${newFile}" width="100px" height="100px" /></td>
		<td><a href="downloadfile.action?downloadFileName=${newFile}">下载资源</a></td>
	</tr>
</table>
</div>
</body>
</html>