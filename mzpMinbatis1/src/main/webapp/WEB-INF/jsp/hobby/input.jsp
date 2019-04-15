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

<title>兴趣爱好增与改</title>
</head>
<body>
	<div class="container">
		<div style="margin-top:80px;"></div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form action="${rc.getContextPath() }/hobby/add" class="form form-horizontal" method="post" onsubmit="return onSubmit()" >
					<div class="form-group">
						<div class="col-sm-2"><label class="control-label"></label></div>
						<div class="col-sm-8">
							<span id="info" style="color:red;">${info }</span>
						</div>
					</div>
					<input type="hidden" id="hId" name="hId" value="${hobby.hId }">
					<div class="form-group">
						<div class="col-sm-2"><label class="control-label">爱好名称</label></div>
						<div class="col-sm-8"><input type="text" class="form-control" id="hName" value="${hobby.hName }" name="hName"></div>
					</div>
					 
					<div class="form-group" style="margin-top:100px;">
						<div class="col-sm-offset-2 col-sm-10">
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
 
//验证提交到controller层；
function onSubmit(){
	var v = $("#hName").val();
	if(v == "" || v == null){
		$("#info").html("爱好名称不能为空.");
		return false;
	}
	 
	return true;
}


</script>
</body>
</html>