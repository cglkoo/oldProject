<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri ="/struts-tags" prefix ="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎注册Struts2</title>
<script type="text/javascript" src="<%=basePath %>/myjs/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
function gotoReg(){
	//window.location="index.action?userName=1";
	document.forms[0].action="register.action";
	document.forms[0].method="POST";
	document.forms[0].submit();
}
</script>
</head>
<body>
<form action="updateUserResult.action" method="post" name="regForm">
<div align="center"> 

	<p id="msg" style="color:red;"></p>
	
	<input type="hidden" id="u" name="userId" value="${userId}"/>
	
	<p>用户：<input id="username" name="userName" value="${userName }" onblur="checkUserName(this.value)"/></p>
	
	<p>密码：<input id="pwd" name="userPwd" value="${userPwd }" /></p>
	
	<p>角色：<s:select list="roleMap"  name="rid" Key="key" Value="value" size="10" multiple="true" headerKey="0" headerValue="--请选择--"/></p>
	
	<!-- 引用Struts2标签给下拉框赋值； --> 
	<p><input type="submit" id="sbm" value="注册或保存"/>  <input type="button" onclick="gotoReg()" value="登录"/></p>
</div>
</form>
<script type="text/javascript">

var flag = false; 
// 标记能不能提交表单
function checkUserName(v){
	var u= $("#u").val();
	if(u==""){     //表示是注册页面；否则是修改页面；
		if(v == "" || v.length==0){
			$("#msg").html("用户名不能为空！");
			flag = false;
		}else{
			    $.ajax({
				type:"POST",
				url:"checkUserName.action",   //用户名进行唯一 性验证
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