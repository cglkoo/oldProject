<%@ page language="java" import="com.kaokaoba.inventory.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创库管理</title>
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
	function isDel() {
	    return confirm("是否删除?");
	}
	$(document).ready(function(){
			$("#b1").click(function(){
				 
				
				document.forms[0].submit();  //提交表单
				
			});
			
			$("#b2").click(function(){
		   
			 	 //跳转到添加通告的页面；
			  
			 	 $("#myForm").attr("action","addInventory.jsp");
				
				document.forms[0].submit();  //提交表单
			});
		
	});
</script> 

</head>
<body>
 

<div align="center">
<p>&nbsp;</p>
<form action="inventory.jsp" id="myForm" name="roleForm" method="post">
<div style="width: 580px;">库存查询：&nbsp;&nbsp;<input name="mName"   size="20" /> &nbsp;&nbsp;
<button id="b1">&nbsp;&nbsp;关&nbsp;&nbsp;键&nbsp;&nbsp;字&nbsp;&nbsp;查&nbsp;&nbsp;询&nbsp;&nbsp;</button>
</div>
</form>
 <p>&nbsp;</p>
<table>
<tr><th>序号</th><th>手机型号</th><th>价格</th><th>数量</th> <th>操作</th></tr>

<%
request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
List<Inventory> list = new ArrayList<>();
IInventoryService ins = new InventoryServiceImpl();
String sql="";
String mName=request.getParameter("mName")==null?"":request.getParameter("mName");
int pageCount=0;   //查询到的所有记录；
sql="select count(1) from tb_inventory  ";

pageCount=Integer.parseInt(ins.getObjectByProperty(sql).toString());

sql="select count(1) from tb_inventory  where mName like ? ";

pageCount=Integer.parseInt(ins.getObjectByProperty(sql,"%"+mName+"%").toString());
 
int pageSize=10;   //每面的记录数量；
int pageTotal=(pageCount%pageSize==0?pageCount/pageSize:((pageCount/pageSize)+1));  //根据pageCount与pageSize得到共有多少页？
int pageIndex=(request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex")));  //当前第几页；默认是第1页；



if(pageIndex<=0){
	pageIndex=1;
}else if(pageIndex>=pageTotal){
	pageIndex=pageTotal;
}
 

sql="select mId,mName,mPrice,mSum from tb_inventory  where mName like ?  ORDER BY mId LIMIT ?,?  ";
list = ins.getInventorysByProperty(sql,"%"+mName+"%",(pageIndex-1)*pageSize,pageSize);
 

if(pageCount>0){
	for(int i = 0; i<list.size();i++){
		Inventory u = list.get(i);
		
%>
<tr><td><%=(i+1) %></td><td><%=u.getmName() %></td> <td><%=u.getmPrice() %></td><td><%=u.getmSum() %></td>
<td>&nbsp;&nbsp;<a href="updateInventory.jsp?mId=<%=u.getmId() %>">修&nbsp;&nbsp;改</a>&nbsp;&nbsp;

<a href="deleteInventory.jsp?mId=<%=u.getmId() %>" onclick="return isDel()">删&nbsp;&nbsp;除</a></td></tr>
 
<%
}
}
%>
</table>
<p>&nbsp;</p>
<div>当前页面:第<%=pageIndex %>页，每页<%=pageSize %>条记录，共计<%=pageCount %>条记录  ，共计<%=pageTotal %>页
 <a href="inventory.jsp?pageIndex=1&mName=<%=mName %>">&nbsp;&nbsp;首页</a> &nbsp;
 <a href="inventory.jsp?pageIndex=<%=(pageIndex-1) %>&mName=<%=mName %>">上一页</a> 
 &nbsp;<a href="inventory.jsp?pageIndex=<%=(pageIndex+1) %>&mName=<%=mName %>">下一页</a> &nbsp;
 <a href="inventory.jsp?pageIndex=<%=pageTotal %>&mName=<%=mName %>">最后一页</a></div>
</div>

</body>
</html>