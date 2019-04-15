<%@ page language="java" import="com.hzit.employees.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户</title>
</head>
<body>
<div align="center">
<p>&nbsp;</p>
<span style="color:red">
	<%
	request.setCharacterEncoding("utf-8");
	String userId=request.getParameter("userId");	//从列表的页面链接过来
	String userId2=request.getParameter("userId2");		//从自己的页面提交过来
	IEmployees ip= new EmployeesImpl();
	String name="";
	String pwd="";
	String sex="";
	String mobile="";
	String borth="";
	String entry="";
	String sql="select userName,userPwd,sex,mobile,borth,entry from t_employees where userId=?";
	int id=0;
	if(null!=userId&&userId.length()!=0){
		id=Integer.parseInt(userId);
	}
	if(userId2==null){	//表示从列表的页面链接过来。
		List<Employees> list =ip.getUserByProperty(sql, id);
		if(list!=null&&list.size()>0){
			Employees e =list.get(0);	//的到的是原来的内容
			name=e.getUserName();
			pwd =e.getUserPwd();
			sex =e.getSex();
			mobile=e.getMobile();
			borth=e.getBorth();
			entry =e.getEntry();
		}
	}else {	//表示从自己的页面提交过来的。
		sql="update t_employees set userName=?,userPwd=?,sex=?,mobile=?,borth=?,entry=? where userId=?";
		String userName=request.getParameter("userName");
		out.println(userName);
		String userPwd =request.getParameter("userPwd");
		String s =request.getParameter("sex");
		String  m=request.getParameter("mobile");
		String b =request.getParameter("borth");
		String e =request.getParameter("entry");
		int num =ip.addOrUpdateOrDelete(sql, userName,userPwd,s,m,b,e,userId2);
		if(num>0){
			%>
			<script type="text/javascript">
		 		alert("修改成功！");
		 		window.location="user.jsp";
			</script>
			<% 
		}else{
			out.println("修改失败");
		}
	}
	%>
</span>
<form action="updateUser.jsp" name="UserForm" method="post" style="line-height: 30px; ">
	<%--name指的是原来的值,value指的是修改后的值 --%>
	<p>用&nbsp;户&nbsp;名:&nbsp;&nbsp;<input name="userName" value="<%=name%>"></p>
	<p>密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input name="userPwd" value="<%=pwd %>"></p>
	<p>性&nbsp;&nbsp;&nbsp;&nbsp;别:&nbsp;&nbsp;<input name="sex" value="<%=sex %>"></p>
	<p>手&nbsp;机&nbsp;号:&nbsp;&nbsp;<input name="mobile" value="<%=mobile %>"></p>
	<p>出生年月:&nbsp;&nbsp;<input name="borth" value="<%=borth %>"></p>
	<p>入职时间:&nbsp;&nbsp;<input name="entry" value="<%= entry%>"></p>
	<p><input type="hidden" name="userId2" value="<%=id %>"/></p>
	<p><button>&nbsp;&nbsp;&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;</button></p>
</form>
</div>
</body>
</html>