<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${rc.getContextPath() }/static/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${rc.getContextPath() }/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath() }/static/js/bootstrap.min.js"></script>
<title>图书增与改</title>
</head>
<body>
	<div class="container">
		<div style="margin-top:80px;"></div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
			
			<form action="${rc.getContextPath() }/book/add" class="form form-horizontal" method="post"  onsubmit="return onSubmit()">
					<div class="form-group">
						<div class="col-sm-3"><label class="control-label"></label></div>
						<div class="col-sm-7" id="info" style="color:red;">${info }</div>
					</div>
					<input type="hidden" id="bId" name="bId" value="${book.bId }">
					<div class="form-group">
						<div class="col-sm-3"><label class="control-label">图书名称：</label></div>
						<div class="col-sm-7"><input type="text" class="form-control" id="bName" value="${book.bName }" name="bName"></div>
					</div>
					<div class="form-group">
						<div class="col-sm-3"><label class="control-label">图书作者：</label></div>
						<div class="col-sm-7"><input type="text" class="form-control" id="bAuthor" value="${book.bAuthor }" name="bAuthor"></div>
					</div>
					<div class="form-group">
						<div class="col-sm-3"><label class="control-label">出版社：</label></div>
						<div class="col-sm-7"><input type="text" class="form-control" id="bPublisher" value="${book.bPublisher }" name="bPublisher"></div>
					</div>
					<div class="form-group" style="margin-top:100px;">
						<div class="col-sm-offset-3 col-sm-10">
							<div>
								<button type="submit" class="btn btn-lg btn-primary">提交保存</button>&nbsp;
							</div>
						</div>
			  		</div>
				</form>
			</div>
			
		</div>
	</div>
	
<script type="text/javascript">
 
function onSubmit(){
	var v = $("#bName").val();
	var z = $("#bAuthor").val();
	var y = $("#bPublisher").val();
	if(v == "" || v.length==0){
		$("#info").html("图书名称不能为空.");
		return false;
	}
	if(z == "" || z.length==0){
		$("#info").html("图书作者不能为空.");
		return false;
	}
	if(y == "" || y.length==0){
		$("#info").html("图书出版社不能为空.");
		return false;
	}
	return true;
}


</script>
</body>
</html>