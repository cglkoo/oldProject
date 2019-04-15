<%@ page language="java" import="com.kaokaoba.user.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员管理</title>
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
			$("button").click(function(){
				 
				
				document.forms[0].submit();  //提交表单
				
			});
		
	});
</script> 

</head>
<body>
 


<div align="center">
<p>&nbsp;</p>
<form action="user.jsp" name="roleForm" method="post">
<div style="width: 580px;">用户名：&nbsp;&nbsp;<input name="userName"   size="20" /> &nbsp;&nbsp;<button>
&nbsp;&nbsp;关&nbsp;&nbsp;键&nbsp;&nbsp;字&nbsp;&nbsp;查&nbsp;&nbsp;询&nbsp;&nbsp;</button>

</div>
</form>
 <p>&nbsp;</p>
<table>
<tr><th>序号</th><th>用户名称</th> <th>操作</th></tr>

<%
request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
IUserService ius = new UserServiceImpl();
List<TBlUser> list = new ArrayList<>();
String sql="";
String userName=request.getParameter("userName")==null?"":request.getParameter("userName");
int pageCount=0;   //查询到的所有记录；
sql="select count(1) from tbl_user  ";

pageCount=Integer.parseInt(ius.getObjectByProperty(sql).toString());

sql="select count(1) from tbl_user  where userName like ? ";

pageCount=Integer.parseInt(ius.getObjectByProperty(sql,"%"+userName+"%").toString());
 
int pageSize=10;   //每面的记录数量；
int pageTotal=(pageCount%pageSize==0?pageCount/pageSize:((pageCount/pageSize)+1));  //根据pageCount与pageSize得到共有多少页？
int pageIndex=(request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex")));  //当前第几页；默认是第1页；



if(pageIndex<=0){
	pageIndex=1;
}else if(pageIndex>=pageTotal){
	pageIndex=pageTotal;
}
 

sql="select uId,userName,userPwd  from tbl_user  where userName like ?  ORDER BY uId desc LIMIT ?,?  ";
list = ius.getUsersByProperty(sql,"%"+userName+"%",(pageIndex-1)*pageSize,pageSize);
 

if(pageCount>0){
	for(int i = 0; i<list.size();i++){
		TBlUser u = list.get(i);
		
%>
<tr><td><%=(i+1) %></td><td><%=u.getUserName() %></td> <td>&nbsp;&nbsp;<a href="updateUser.jsp">&nbsp;修&nbsp;改&nbsp;</a>&nbsp;&nbsp;
<a href="deleteUser.jsp?uId=<%=u.getuId() %>">&nbsp;删&nbsp;除&nbsp;</a></td></tr>
 
<%
}
}
%>
</table>
<p>&nbsp;</p>
<div>当前页面:第<%=pageIndex %>页，每页<%=pageSize %>条记录，共计<%=pageCount %>条记录  ，共计<%=pageTotal %>页
 <a href="user.jsp?pageIndex=1&userName=<%=userName %>">&nbsp;&nbsp;首页</a> &nbsp;
 <a href="user.jsp?pageIndex=<%=(pageIndex-1) %>&userName=<%=userName %>">上一页</a> 
 &nbsp;<a href="user.jsp?pageIndex=<%=(pageIndex+1) %>&userName=<%=userName %>">下一页</a> &nbsp;
 <a href="user.jsp?pageIndex=<%=pageTotal %>&userName=<%=userName %>">最后一页</a></div>
</div>

</body>
</html>