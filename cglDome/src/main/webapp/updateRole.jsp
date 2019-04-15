<%@ page language="java" import="com.hzit.roles.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改角色列表</title>
<script type="text/javascript" src="myjs/jquery-3.2.1.min.js" ></script>
<script type="text/javascript">

	/*去除字符串前后的空格*/
	function trimSpace(str) {
		return str.replace(/(^\s+)|(\s+$)/g, "");
	}
	$(document).ready(function(){
			$("button").click(function(){
				var n = $("input").val();
				n = trimSpace(n);
				if(n==''){
					$("span").text("角色名称不能为空");
					$("input").focus();
					$("input").css("border","1px solid red");
					return false;
				}else{
					document.forms[0].submit();  //提交表单
				}
			});
	});
</script> 
</head>
<body>
<div align="center">
<p>&nbsp;&nbsp;</p>
<span style="color:red">
	<%
	request.setCharacterEncoding("utf-8");	//解决中文乱码的问题；
	String roleId =request.getParameter("roleId");	//表示从列表的页面链接过来。
	String roleId2 =request.getParameter("roleId2");	//表示从自己的页面提交过来的。
	IRoles ir = new RolesImpl();
	String name="";
	String sql="select roleName from t_roles where roleId=?";
	int id=0;
	if(null!=roleId && roleId.length()!=0){
		id=Integer.parseInt(roleId);
	}
	if(roleId2==null){	//表示从列表的页面链接过来
		List<Roles> list =ir.getRolesByProperty(sql, id);
	if(list!=null&&list.size()>0){
		Roles r = list.get(0);
		name=r.getRoleName();	//得到的是原来的通告标题
	}
	}else{	//表示从自己的页面提交过来的。
	sql="update t_roles set roleName=? where roleId=?";
	String roleName=request.getParameter("RoleName");	//获取修改后的通告标题；
	int num=ir.addOrUpdateOrDelete(sql, roleName,roleId2);
	if(num>0){
		%>
		<script type="text/javascript">
	 		alert("修改成功！");
	 		window.location="role.jsp";
		</script>
		<% 
	}else{
		out.println("修改失败");
	}
	}
	%>
</span>
	<form action="updateRole.jsp" name="RoleForm" method="post">
		<input name="RoleName" value="<%=name%>">
		<input type="hidden" name="roleId2" value="<%=id %>">
	<button>提交</button>
	</form>
</div>
</body>
</html>