<%@ page language="java" import="com.kaokaoba.stock.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机进货管理</title>
<style type="text/css">
button:HOVER{
	cursor:pointer;
	background-color: orange;
}
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
a:HOVER {
	text-decoration:underline;
	color: orange;
}
</style>

<script type="text/javascript" src="myjs/jquery-3.2.1.min.js" ></script>

<script type="text/javascript">
	$(document).ready(function(){
			$("#b1").click(function(){
				document.forms[0].submit();  //提交表单
			});
			
			$("#b2").click(function(){
			 	 //跳转到添加通告的页面；
			 	 $("#myForm").attr("action","addStock.jsp");
				
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
<form action="stock.jsp" id="myForm" name="roleForm" method="post">
<div style="width: 600px;">手机进货型号：&nbsp;<input name="mType"   size="20" /> &nbsp;&nbsp;<button id="b1">
&nbsp;&nbsp;关&nbsp;&nbsp;键&nbsp;&nbsp;字&nbsp;&nbsp;查&nbsp;&nbsp;询&nbsp;&nbsp;</button>

<button id="b2">
&nbsp;&nbsp;添&nbsp;&nbsp;加&nbsp;&nbsp;进&nbsp;&nbsp;货&nbsp;&nbsp;</button>
</div>
</form>
<br>&nbsp;
<div style="height: 240px">
<table>
<tr><th>序号</th><th>手机型号</th><th>单价</th><th>数量</th><th>总价</th><th>日期</th> <th>操作</th></tr>

<%
request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
List<Stock> list = new ArrayList<>();
IStockService ins = new StockServiceImpl();
String sql="";
String mType=request.getParameter("mType")==null?"":request.getParameter("mType");
int pageCount=0;   //查询到的所有记录；
sql="select count(1) from tb_Stock  ";

pageCount=Integer.parseInt(ins.getObjectByProperty(sql).toString());

sql="select count(1) from tb_stock  where mType like ? ";

pageCount=Integer.parseInt(ins.getObjectByProperty(sql,"%"+mType+"%").toString());
 
int pageSize=10;   //每面的记录数量；
int pageTotal=(pageCount%pageSize==0?pageCount/pageSize:((pageCount/pageSize)+1));  //根据pageCount与pageSize得到共有多少页？
int pageIndex=(request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex")));  //当前第几页；默认是第1页；



if(pageIndex<=0){
	pageIndex=1;
}else if(pageIndex>=pageTotal){
	pageIndex=pageTotal;
}
 

sql="select mId,mType,mPrice,mNumber,mValue,mDate from tb_stock  where mType like ?  ORDER BY mId desc LIMIT ?,?  ";
list = ins.getStocksByProperty(sql,"%"+mType+"%",(pageIndex-1)*pageSize,pageSize);
 

if(pageCount>0){
	for(int i = 0; i<list.size();i++){
		Stock u = list.get(i);
		
%>
<tr><td align="center"><%=(i+1) %></td><td align="center"><%=u.getmType() %></td>
<td align="center"><%=u.getmPrice() %></td>
<td align="center"><%=u.getmNumber() %></td>
<td align="center"><%=u.getmValue() %></td>
<td align="center"><%=u.getmDate() %></td>
<td align="center"><a href="updateStock.jsp?mId=<%=u.getmId() %>">修&nbsp;改</a>&nbsp;
&nbsp;<a href="deleteStock.jsp?mId=<%=u.getmId() %>" onclick="return isDel()">删&nbsp;除</a></td></tr>
 
<%
}
}
%>
</table>
</div>
<p>&nbsp;</p>
<div>当前页面:第<%=pageIndex %>页，每页<%=pageSize %>条记录，共计<%=pageCount %>条记录  ，共计<%=pageTotal %>页
 &nbsp;&nbsp;<a href="stock.jsp?pageIndex=1&mType=<%=mType %>">首页</a> &nbsp;
 <a href="stock.jsp?pageIndex=<%=(pageIndex-1) %>&mType=<%=mType %>">上一页</a> 
 &nbsp;<a href="stock.jsp?pageIndex=<%=(pageIndex+1) %>&mType=<%=mType %>">下一页</a> &nbsp;
 <a href="stock.jsp?pageIndex=<%=pageTotal %>&mType=<%=mType %>">最后一页</a></div>
</div>

</body>
</html>