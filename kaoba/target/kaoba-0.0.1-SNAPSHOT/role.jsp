<%@ page language="java" import="com.kaokaoba.role.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<style type="text/css">
table{
	border: 1px blue solid;
	border-collapse: collapse;
}

td{
	border: 1px blue solid;
	width: 200px;
}
</style>

<script type="text/javascript" src="myjs/jquery-3.2.1.min.js" ></script>

<script type="text/javascript">
	$(document).ready(function(){
			$("#b1").click(function(){
				 
				
				document.forms[0].submit();  //提交表单
				
			});
			
			$("#b2").click(function(){
				 
				document.forms[0].action="addRole.jsp"; 
				document.forms[0].submit();  //提交表单
				
			});
		
	});
</script> 

</head>
<body>
 


<div align="center">
<p>&nbsp;</p>
<form action="role.jsp" name="roleForm" method="post">
<div style="width: 580px;">角色名称：&nbsp;&nbsp;<input name="roleName"   size="20" /> 
&nbsp;&nbsp;<button id="b1">
&nbsp;&nbsp;关&nbsp;&nbsp;键&nbsp;&nbsp;字&nbsp;&nbsp;查&nbsp;&nbsp;询&nbsp;&nbsp;</button>
&nbsp;&nbsp;<button id="b2">
&nbsp;&nbsp;添&nbsp;&nbsp;加&nbsp;&nbsp;角&nbsp;&nbsp;色&nbsp;&nbsp;</button></div>
</form>
 <p>&nbsp;</p>
<table>
<tr><th>序号</th><th>角色名称</th> <th>操作</th></tr>

<%
request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
IRoleService irs = new RoleServiceImpl();
List<Role> list = new ArrayList<>();
String sql="";
String roleName=request.getParameter("roleName")==null?"":request.getParameter("roleName");
int pageCount=0;   //查询到的所有记录；
sql="select count(1) from t_roles  ";

pageCount=Integer.parseInt(irs.getObjectByProperty(sql).toString());

sql="select count(1) from t_roles  where rName like ? ";

pageCount=Integer.parseInt(irs.getObjectByProperty(sql,"%"+roleName+"%").toString());
 
int pageSize=10;   //每面的记录数量；
int pageTotal=(pageCount%pageSize==0?pageCount/pageSize:((pageCount/pageSize)+1));  //根据pageCount与pageSize得到共有多少页？
int pageIndex=(request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex")));  //当前第几页；默认是第1页；



if(pageIndex<=0){
	pageIndex=1;
}else if(pageIndex>=pageTotal){
	pageIndex=pageTotal;
}
 

sql="select rId,rName from t_roles  where rName like ?  ORDER BY rId LIMIT ?,?  ";
list = irs.getRoleByProperty(sql,"%"+roleName+"%",(pageIndex-1)*pageSize,pageSize);
 

if(pageCount>0){
	for(int i = 0; i<list.size();i++){
		Role r = list.get(i);
		
%>
<tr><td><%=(i+1) %></td><td><%=r.getrName() %></td> <td>
&nbsp;&nbsp;<a href="">&nbsp;修&nbsp;改&nbsp;</a>&nbsp;&nbsp;
<a href="deleteRole.jsp?rId=<%=r.getrId() %>">&nbsp;删&nbsp;除&nbsp;</a></td></tr>
 
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