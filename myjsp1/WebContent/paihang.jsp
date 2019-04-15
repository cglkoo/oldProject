<%@ page language="java" import="com.store.elscore.*,java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排行榜</title>
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
</style>
</head>
<body>
<div align="center">
<h2>排行榜</h2>
<table>
<tr><th>名次</th><th>姓名</th><th>业绩</th></tr>
	<%
	request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
	IElScoresService ius = new ElScoresServiceImpl();
	String sql="";
	List<ElScores> list= new ArrayList<>();
	
	sql="select count(1) from tb_elscores";  //查询到的所有记录
	int pageCount=0;     
	pageCount=Integer.parseInt(ius.getObjectByProperty(sql).toString());
	
	int pageSize=3;   //每面的记录数量；
	int pageTotal=(pageCount%pageSize==0?pageCount/pageSize:((pageCount/pageSize)+1));    //根据pageCount与pageSize得到共有多少页？
	int pageIndex=(request.getParameter("pageIndex")==null?1:Integer.parseInt(request.getParameter("pageIndex")));  //当前第几页；默认是第1页；
	
	if(pageIndex<=0){
		pageIndex=1;
	}else if(pageIndex>=pageTotal){
		pageIndex=pageTotal;
	}
	sql = "select userName,mPrices,mNum from tb_elscores ORDER BY mPrices*mNum desc LIMIT ?,?";
	list = ius.getElScoresByProperty(sql,(pageIndex-1)*pageSize,pageSize);
	if(list!=null && pageCount>0){
		for(int i = 0; i<list.size();i++){
			ElScores u = list.get(i);
		%>
		<tr><td>第<%=(i+1) %>名</td><td><%=u.getUserName() %></td><td><%=u.getmPrices()*u.getmNum()%></td></tr>
		<%
        }
	}
	%>
</table>
<p>&nbsp;</p>
<div>当前页面:第<%=pageIndex %>页，每页<%=pageSize %>条记录，共计<%=pageCount %>条记录  ，共计<%=pageTotal %>页
	 <a href="paihang.jsp?pageIndex=1">首&nbsp;页</a>&nbsp;
	 <a href="paihang.jsp?pageIndex=<%=(pageIndex-1) %>">上一页</a>&nbsp;
	 <a href="paihang.jsp?pageIndex=<%=(pageIndex+1) %>">下一页</a>&nbsp;
	 <a href="paihang.jsp?pageIndex=<%=pageTotal %> ">最后一页</a>
 </div>
</div>

</body>
</html>