<%@ page language="java"   contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页-考考吧</title>
<script type="text/javascript" src="myjs/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#paper tr:even").css("background-color","#CCC");
		$("#paper tr:odd").css("background-color","#EEE");
		
		$("#paper2 tr:even").css("background-color","#bbb");
		$("#paper2 tr:odd").css("background-color","#fff");
		
		
		$("#paper3 tr:even").css("background-color","#CCC");
		$("#paper3 tr:odd").css("background-color","#EEE");
		
		 
	});
	
 
</script>
<style type="text/css">
 table{
 	border-collapse: collapse;
 }
 
 #notice th{
 	color: red;
 	
 }
 
  #notice td{
 	color: blue;
 	
 }
  #paper2 th{
 	color: red;
 }
 #paper2 td{
 	color: blue;
 }
</style>
</head>
<body>
 
 <div align="center">
 
 <table>
 
 
 <tr>
  
  <!-- 右边的； -->
 <td>
 
 <table id="paper2">
 
 	<tr><th>留言板</th></tr>
 
<c:forEach items="${list }" var="m" varStatus="v">

<tr><td>
(<c:out value="${(v.index+1) }" />) 
<c:out value="${m.mName }" /> 
<c:if test="${m.mStatus==1 }">
	【审核通过】
</c:if>
<c:if test="${m.mStatus==0 }">
	【未审核通过】
</c:if>
[<c:out value="${m.mDate }" />]
   </td></tr>
</c:forEach>
	
	
 
 
 
 </table>
 </td>
 </tr>
  
 </table>
 
 </div>
</body>
</html>