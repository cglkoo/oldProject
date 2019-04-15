<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日志管理</title>
<style type="text/css">
table{
	border: 1px blue solid;
	border-collapse: collapse;
}
td{
	border: 1px blue solid;
	width: 200px;
	text-align: center;
}
</style>

<script type="text/javascript" src="myjs/jquery-3.2.1.min.js" ></script>

<script type="text/javascript">
	$(document).ready(function(){
			$("#b1").click(function(){
				document.forms[0].submit();  //提交表单
			});
	});
</script> 

</head>
<body>
<div align="center">
<p>&nbsp;</p>
	<form action="rzhi" name="rzhiForm" method="post">
	<div style="width: 580px;"><input name="rWords" size="20" /> &nbsp;&nbsp;
	<button id="b1">&nbsp;关&nbsp;&nbsp;键&nbsp;&nbsp;字&nbsp;&nbsp;查&nbsp;&nbsp;询&nbsp;&nbsp;</button>
	</div>
	</form>
<p>&nbsp;</p>
<table>
<tr><th>序号</th><th>日志内容 </th><th>时间</th><th>操作</th></tr>
<c:forEach items="${list }" var="r" varStatus="v">
<tr>
	<td><c:out value="${(v.index+1) }" /></td>
	<td><c:out value="${r.rContent }" /></td>
	<td><c:out value="${r.rDate }" /></td>
	<td><a href="deleteRzhis.jsp?rId=<c:out value='${r.rId }'/>">删&nbsp;除</a></td>
</tr>
</c:forEach>
</table>
<p>&nbsp;</p>
<div>当前页面是第${pageIndex }页，每页${pageSize } 条记录，共计<c:out value="${pageCount }"/> 条记录  ，共计${pageTotal }页 &nbsp;
	 <a href="rzhi.jsp?pageIndex=1&rContent=<c:out value='${rContent }'/>">首 &nbsp;页</a>&nbsp;
	 <a href="rzhi.jsp?pageIndex=<c:out value='${(pageIndex-1) }'/>&rContent=<c:out value='${rContent }'/>">上一页</a>&nbsp; 
	 <a href="rzhi.jsp?pageIndex=<c:out value='${(pageIndex+1) }'/>&rContent=<c:out value='${rContent }'/>">下一页</a>&nbsp;
	 <a href="rzhi.jsp?pageIndex=<c:out value='${pageTotal }'/>&rContent=<c:out value='${rContent }'/>">最后一页</a>
 </div>
</div>


</body>
</html>