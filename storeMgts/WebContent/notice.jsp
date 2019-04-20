<%@ page language="java" import="com.store.notice.*,java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通告管理</title>
<style type="text/css">
table {
	border: 1px blue solid;
	border-collapse: collapse;
}

td {
	border: 1px blue solid;
	width: 200px;
	text-align: center;
}
</style>
<script type="text/javascript" src="myjs/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
			$("#b1").click(function(){
				document.forms[0].submit();  //提交表单
			});
			$("#b2").click(function(){
			 	 //跳转到添加通告的页面；
			 	 $("#myForm").attr("action","addNotice.jsp");
				document.forms[0].submit();  //提交表单
			});
	});
</script>

</head>
<body>
	<div align="center">
		<form action="notice.jsp" id="myForm" name="roleForm" method="post">
			<div style="width: 580px;">
				通告标题：&nbsp;&nbsp;<input name="nName" size="20" />&nbsp;&nbsp;
				<button id="b1">&nbsp;&nbsp;关&nbsp;&nbsp;键&nbsp;&nbsp;字&nbsp;&nbsp;查&nbsp;&nbsp;询&nbsp;&nbsp;</button>
				<button id="b2">&nbsp;&nbsp;添&nbsp;&nbsp;加&nbsp;&nbsp;通&nbsp;&nbsp;告&nbsp;&nbsp;</button>
			</div>
		</form>
		<br>

		<table>
			<tr>
				<th>序号</th>
				<th>通告标题</th>
				<th>操作</th>
			</tr>
			<%
request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
List<Notice> list = new ArrayList<>();
INoticeService ins = new NoticeServiceImpl();
String sql="";
String nName=request.getParameter("nName")==null?"":request.getParameter("nName");
int pageCount=0;   //查询到的所有记录；
sql="select count(1) from t_notice  ";

pageCount=Integer.parseInt(ins.getObjectByProperty(sql).toString());

sql="select count(1) from t_notice  where nName like ? ";
pageCount=Integer.parseInt(ins.getObjectByProperty(sql,"%"+nName+"%").toString());
 
int pageSize=5;   //每面的记录数量；
int pageTotal=(pageCount%pageSize==0?pageCount/pageSize:((pageCount/pageSize)+1));  //根据pageCount与pageSize得到共有多少页？
int pageIndex=(request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex")));  //当前第几页；默认是第1页；

if(pageIndex<=0){
	pageIndex=1;
}else if(pageIndex>=pageTotal){
	pageIndex=pageTotal;
}

sql="select nId,nName,nDate from t_notice  where nName like ?  ORDER BY nId LIMIT ?,?  ";
list = ins.getNoticesByProperty(sql,"%"+nName+"%",(pageIndex-1)*pageSize,pageSize);
 
if(pageCount>0){
	for(int i = 0; i<list.size();i++){
		Notice u = list.get(i);
	%>
			<tr>
				<td><%=(i+1) %></td>
				<td><%=u.getnName() %></td>
				<td><a href="updateNotice.jsp?nId=<%=u.getnId() %>">修&nbsp;改</a>&nbsp;&nbsp;
					<a href="deleteNotice.jsp?nId=<%=u.getnId() %>">删&nbsp;除</a></td>
			</tr>
			<%
	}
}
%>
		</table>
		<p>&nbsp;</p>
		<div>
			当前页面:第<%=pageIndex %>页，每页<%=pageSize %>条记录，共计<%=pageCount %>条记录 ，共计<%=pageTotal %>页
			<a href="notice.jsp?pageIndex=1&nName=<%=nName %>">首&nbsp;页</a>&nbsp;
			<a href="notice.jsp?pageIndex=<%=(pageIndex-1) %>&nName=<%=nName %>">上一页</a>&nbsp;
			<a href="notice.jsp?pageIndex=<%=(pageIndex+1) %>&nName=<%=nName %>">下一页</a>&nbsp;
			<a href="notice.jsp?pageIndex=<%=pageTotal %>&nName=<%=nName %>">最后一页</a>
		</div>
	</div>

</body>
</html>