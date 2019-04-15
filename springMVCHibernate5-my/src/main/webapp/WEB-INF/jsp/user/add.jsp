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

<title>用户注册</title>
</head>
<body>
	<div class="container">
		<div style="margin-top:80px;"></div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form action="addUser.action" class="form form-horizontal" method="post"   onsubmit="return onSubmit()" >
					<input type="hidden" id="userIcon" name="userIcon" value="${user.userIcon }">
					<input type="hidden" id="uId" name="uId" value="${user.uId }">
					<div class="form-group">
						<div class="col-sm-2"><label class="control-label"></label></div>
						<div class="col-sm-8">
							<span id="info" style="color:red;"></span>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-2"><label class="control-label">用户名</label></div>
						<div class="col-sm-8"><input type="text" class="form-control" id="username" value="${user.userName }" name="userName"></div>
					</div>
					<div class="form-group">
						<div class="col-sm-2"><label class="control-label">密码</label></div>
						<div class="col-sm-8"><input type="text" class="form-control" id="pwd"  value="${user.userPwd }" name="userPwd"></div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-2"><label class="control-label">角色</label></div>
						<div class="col-sm-8"><select multiple="multiple" class="form-control" id="role"   name="userRole">
						<c:forEach items="${rList }" var="role">
							<option value="${role.rId }"
							
							<c:forEach items="${userRoleList }" var="r">
							<c:if test="${r.rId eq role.rId}">selected</c:if>
							</c:forEach>
							
							>${role.rName }</option>
						</c:forEach>
						</select></div>
					</div> 
					
					
					<div class="form-group">
						<div class="col-sm-2"><label class="control-label">爱好</label></div>
						<div class="col-sm-8"> 
						<c:forEach items="${hList }" var="hobby">
							<input type="checkbox" name="userHobby" value="${hobby.hId }" 
							
							<c:forEach items="${userHobbyList }" var="h">
							 <c:if test="${h.hId eq hobby.hId}">checked</c:if>
							</c:forEach>
							
							
							/>${hobby.hName }
						</c:forEach>
						 </div>
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
	/* v = $("#userIcon").val();
	if(v == "" || v == null){
		$("#info").html("请先上传图片.");
		return false;
	} */
	return true;
}


</script>
</body>
</html>