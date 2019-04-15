<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户添加与修改</title>
<link href="${rc.getContextPath() }/static/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${rc.getContextPath() }/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath() }/static/js/bootstrap.min.js"></script>
</head>
<body>
<form action="input" method="post" name="inputForm">
<div align="center"> 
	<h3>添加与修改</h3>
	<div class="row"><p id="msg" style="color:red;">${msg }</p></div>
		<input type="hidden" id="u" name="userId" value="${userId}"/>
	<div class="row">
		<div class="col-sm-5" align="right">用户:</div>
		<div class="col-md-2">
			<input name="userName" id="username" class="form-control" value="${userName }" onblur="checkUserName(this.value)"/>
		</div>
	</div>
	<p></p>
	<div class="row">
		<div class="col-sm-5" align="right">密码:</div>
		<div  class="col-md-2">
		<input id="pwd" name="userPwd" class="form-control" value="${userPwd }" />
		</div>
	</div>
	<p></p>	
	<div class="row">
		<div class="col-sm-5" align="right">角色:</div>
		<div class="col-md-2">
		<select multiple="multiple" class="form-control" id="role"   name="userRole">
			<c:forEach items="${rList }" var="role">
				<option value="${role.rId }"
				<c:forEach items="${userRoleList }" var="r">
				<c:if test="${r.rId eq role.rId}">selected</c:if>
				</c:forEach>
				>${role.rName }</option>
			</c:forEach>
		</select>
		</div>
	</div>
	<p></p>	
	<div class="row">
		<div class="col-sm-5" align="right">爱好:</div>
		<div class="col-md-2">
			<c:forEach items="${hList }" var="hobby">
				<input type="checkbox" name="userHobby" value="${hobby.hId }" 
				<c:forEach items="${userHobbyList }" var="h">
				 <c:if test="${h.hId eq hobby.hId}">checked</c:if>
				</c:forEach>
				/>${hobby.hName }
			</c:forEach>
		</div>
	</div>
	<p></p>
	<p><input type="submit" id="sbm" value="提交并保存" class="btn btn-success"/>
</div>
</form>
<script type="text/javascript">
var flag = false; 
// 标记能不能提交表单
function checkUserName(v){
	var u= $("#u").val();
	if(u==""){     //表示是添加页面，否则是修改页面；
		if(v == "" || v.length==0){
			$("#msg").html("用户名不能为空！");
			flag = false;
		}else{
			    $.ajax({
				type:"POST",
				url:"${rc.getContextPath() }/user/checkUserName",   //用户名进行唯一 性验证
				data:{"userName":v},
				dataType:"json",
				success:function(resp){
					var obj=resp.json;
					var obj2 = $.parseJSON(obj); //把Json格式的字符串转为对象；
					if("1" ==obj2.data){
						$("#msg").html("该用户名已被占用,请输入别的用户名.");
						flag = false;
					}else{
						$("#msg").html("该用户名可以使用。");
						flag = true;
					}
				}
			});
		} 
	}else{
		flag = true;   //修改页面不需要验证！
	}
}

$(document).ready(function(){
	
	$("#sbm").click(function(){
		var u= $("#u").val();
		if(u!="" && u.length > 0){ //表示是是修改页面；
			flag = true;
		}
			var v = $("#username").val();
			if(v == "" || v.length==0){
				$("#msg").html("用户名不能为空！");
				flag = false;
				return false;  //不让提交表单；如果不写，仍然会自动提交表单，因为用的是type="submit";
			}else{
				var p=$("#pwd").val();
				if(flag==false){
					$("#msg").html("该用户名已被占用,请输入别的用户名.");
					return false;
				}else if(p==""){  //相当于是p.length==0
					//alert(p.length);
					$("#msg").html("密码不能为空.");
					return false;
				}else{
					return true;
				}
			}
		 
	});
	
});
</script>
</body>
</html>