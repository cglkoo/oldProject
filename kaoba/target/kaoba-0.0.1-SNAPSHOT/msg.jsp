<%@ page language="java" import="com.kaokaoba.msg.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言管理</title>
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
		   
			 	 //跳转到添加留言的页面；
			  
			 	 $("#myForm").attr("action","addmsg.jsp");
				
				document.forms[0].submit();  //提交表单
			});
		
	});
</script> 

</head>
<body>
 


<div align="center">
<p>&nbsp;</p>
<form action="msg.jsp" id="myForm" name="roleForm" method="post">
<div style="width: 580px;">留言标题：&nbsp;&nbsp;<input name="mName"   size="20" /> &nbsp;&nbsp;<button id="b1">
&nbsp;&nbsp;关&nbsp;&nbsp;键&nbsp;&nbsp;字&nbsp;&nbsp;查&nbsp;&nbsp;询&nbsp;&nbsp;</button>
 
</div>
</form>
 <p>&nbsp;</p>
<table>
<tr><th>序号</th><th>留言标题</th>  <th>状态</th> <th>操作</th></tr>

<%
request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
List<Msg> list = new ArrayList<>();
IMsgService ins = new MsgServiceImpl();
String sql="";
String mName=request.getParameter("mName")==null?"":request.getParameter("mName");
int pageCount=0;   //查询到的所有记录；
sql="select count(1) from t_msg  ";

pageCount=Integer.parseInt(ins.getObjectByProperty(sql).toString());

sql="select count(1) from t_msg  where mName like ? ";

pageCount=Integer.parseInt(ins.getObjectByProperty(sql,"%"+mName+"%").toString());
 
int pageSize=5;   //每面的记录数量；
int pageTotal=(pageCount%pageSize==0?pageCount/pageSize:((pageCount/pageSize)+1));  //根据pageCount与pageSize得到共有多少页？
int pageIndex=(request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex")));  //当前第几页；默认是第1页；



if(pageIndex<=0){
	pageIndex=1;
}else if(pageIndex>=pageTotal){
	pageIndex=pageTotal;
}
 

sql="select mId,mName,mStatus from t_msg  where mName like ?  ORDER BY mId desc LIMIT ?,?  ";
list = ins.getMsgsByProperty(sql,"%"+mName+"%",(pageIndex-1)*pageSize,pageSize);
 

if(pageCount>0){
	for(int i = 0; i<list.size();i++){
		Msg u = list.get(i);
		
%>
<tr><td><%=(i+1) %></td><td><%=u.getmName() %></td> <td><%=u.getmStatus()==1?"审核通过":"<font color='red'>待审核</font>"%></td>
<td>&nbsp;&nbsp; 
<a href="deleteMsg.jsp?mId=<%=u.getmId() %>">&nbsp;删&nbsp;除&nbsp;</a>
<a href="updateMsg.jsp?mId=<%=u.getmId() %>">&nbsp;审核&nbsp;通过&nbsp;</a>
</td></tr>
 
<%
}
}
%>
</table>
<p>&nbsp;</p>
<div>当前页面:第<%=pageIndex %>页，每页<%=pageSize %>条记录，共计<%=pageCount %>条记录  ，共计<%=pageTotal %>页
 <a href="msg.jsp?pageIndex=1&mName=<%=mName %>">&nbsp;&nbsp;首页</a> &nbsp;
 <a href="msg.jsp?pageIndex=<%=(pageIndex-1) %>&mName=<%=mName %>">上一页</a> 
 &nbsp;<a href="msg.jsp?pageIndex=<%=(pageIndex+1) %>&mName=<%=mName %>">下一页</a> &nbsp;
 <a href="msg.jsp?pageIndex=<%=pageTotal %>&mName=<%=mName %>">最后一页</a></div>
</div>

</body>
</html>