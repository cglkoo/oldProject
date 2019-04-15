<%@ page language="java" import="com.hzit.roles.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>

<style type="text/css">
table{
	border: 1px #23E99E solid;
	border-collapse: collapse;
}
td{
	border: 1px #A7D7A3 solid;
	width: 200px;
	text-align: center;
}
a{
	text-decoration: none;
}
</style>

<script type="text/javascript" src="myjs/jquery-3.2.1.min.js" ></script>

<script type="text/javascript">
	$(document).ready(function(){
			$("button").click(function(){
				document.forms[0].submit();  //提交表单
			});
			
			$("#b2").click(function(){
				   
			 	 //跳转到添加通告的页面；
			  
				document.forms[0].action="addRoles.jsp";
				document.forms[0].submit();  //提交表单
			});
		
	});
	function isDel() {
	    return confirm("是否删除?");
	}
</script> 

</head>
<body>
 


<div align="center">
<p>&nbsp;</p>
<form action="role.jsp" name="roleForm">
<div style="width: 580px;">角色名称：&nbsp;&nbsp;<input name="roleName"   size="20" /> &nbsp;&nbsp;<button>
&nbsp;&nbsp;关&nbsp;&nbsp;键&nbsp;&nbsp;字&nbsp;&nbsp;查&nbsp;&nbsp;询&nbsp;&nbsp;</button>

<button id="b2">
&nbsp;&nbsp;添&nbsp;&nbsp;加&nbsp;&nbsp;角&nbsp;&nbsp;色&nbsp;&nbsp;</button>
</div>
</form>
 <p>&nbsp;</p>
<table>
<tr><th>序号</th><th>角色名称</th> <th>操作</th></tr>

	<%
	request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
	IRoles irs = new RolesImpl();
	List<Roles> list = new ArrayList<>();
	String sql="";
	String roleName=request.getParameter("roleName")==null?"":request.getParameter("roleName");
	int pageCount=0;   //查询到的所有记录；
	sql="select count(1) from t_roles  ";
	
	pageCount=Integer.parseInt(irs.getObjectByProperty(sql).toString());
	
	sql="select count(1) from t_roles  where roleName like ? ";
	
	pageCount=Integer.parseInt(irs.getObjectByProperty(sql,"%"+roleName+"%").toString());
	 
	int pageSize=10;   //每面的记录数量；
	int pageTotal=(pageCount%pageSize==0?pageCount/pageSize:((pageCount/pageSize)+1));  //根据pageCount与pageSize得到共有多少页？
	int pageIndex=(request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex")));  //当前第几页；默认是第1页；
	
	
	
	if(pageIndex<=0){
		pageIndex=1;
	}else if(pageIndex>=pageTotal){
		pageIndex=pageTotal;
	}
	sql="select roleId,roleName from t_roles  where roleName like ?  ORDER BY roleId LIMIT ?,?  ";
	list = irs.getRolesByProperty(sql,"%"+roleName+"%",(pageIndex-1)*pageSize,pageSize);
	 
	
	if(pageCount>0){
		for(int i = 0; i<list.size();i++){
			Roles r = list.get(i);
			
	%>
	<tr><td><%=(i+1) %></td><td><%=r.getRoleName() %></td> 
		<td><a href="updateRole.jsp?roleId=<%=r.getRoleId()%>">修&nbsp;&nbsp;改</a>&nbsp;&nbsp;
			<a href="deleteRole.jsp?roleId=<%=r.getRoleId()%>" onclick="return isDel()">删&nbsp;&nbsp;除</a></td></tr>
	 
	<%
	}
	}
	%>
</table>
<p>&nbsp;</p>
<div>当前页面是第<%=pageIndex %>页，每页<%=pageSize %>条记录，共计<%=pageCount %>条记录  ，共计<%=pageTotal %>页
 <a href="role.jsp?pageIndex=1&roleName=<%=roleName %>">首页</a> &nbsp;
 <a href="role.jsp?pageIndex=<%=(pageIndex-1) %>&roleName=<%=roleName %>">上一页</a> 
 &nbsp;<a href="role.jsp?pageIndex=<%=(pageIndex+1) %>&roleName=<%=roleName %>">下一页</a> &nbsp;
 <a href="role.jsp?pageIndex=<%=pageTotal %>&roleName=<%=roleName %>">最后一页</a></div>
</div>

</body>
</html>