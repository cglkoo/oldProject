<%@ page language="java" import="com.kaokaoba.paper.*,com.kaokaoba.msg.*,com.kaokaoba.notice.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
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
 
  <tr><td colspan="4" align="right">  <a href="login.jsp">登录</a> <a href="reg.html">注册</a> </td></tr>
  
 <tr><td colspan="4"><img src="imgs/banner.jpg" /> <br/></td></tr>
 
 <tr>
 <!-- 左边的网站公告； -->
 <td>
 <table id="notice">
 
 	<tr><th>网站公告</th></tr>
 	
<%
List<Notice> listNotice = new ArrayList<>();
INoticeService ins = new NoticeServiceImpl();
String sql =" SELECT nId,SUBSTRING(nName,1,5) nName,nDate FROM t_notice ORDER BY nId DESC";
listNotice = ins.getNoticesByProperty(sql);
pageContext.setAttribute("listNotice", listNotice);  
Date date = new java.util.Date();
pageContext.setAttribute("date", date);
%>

<c:forEach var="notice" items="${listNotice }" varStatus="v">

<c:if test="${v.index%2==0 }">
	<tr><td bgcolor="#ccc"><a href="detail.jsp?nId=<c:out value='${notice.nId }' /> "> <c:out value="${(v.index+1) }" /> <c:out value="${notice.nName }" /> [<c:out value="${notice.nDate }" /> ] </a></td></tr>

</c:if>
<c:if test="${v.index%2!=0 }">
	<tr><td><a href="detail.jsp?nId=<c:out value='${notice.nId }' /> "> <c:out value="${(v.index+1) }" /> <c:out value="${notice.nName }" /> [<c:out value="${notice.nDate }" /> ] </a></td></tr>

</c:if>


</c:forEach> 

 
 
  <tr><td> <fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm:ss"/>  </td></tr>	
 
 </table>
 </td>
  

 <td>
 <table id="paper">
 
 	<tr><th>热门试卷</th></tr>
 	
<%
IPaperService ius = new PaperServiceImpl();
List<Paper> list = new ArrayList<>();
sql ="select pId,pName,pType,pCount from t_paper order by pCount desc";
list = ius.getPapersByProperty(sql);
if(list.size()>0){
	for(int i =0;i<list.size();i++){
	Paper p = list.get(i);
	%>
	<tr><td>(<%=(i+1) %>) <%=p.getpName() %> [<%=p.getpCount() %>]</td></tr>
	<%
}
}
%>
 	
 </table>
 </td>
 
 
  <!-- 中间的； -->
 <td>
  <table id="paper3">
 
 	<tr><th>所有试卷</th></tr>
 	
<%
List<Paper> list3 = new ArrayList<>();
String sql3 ="select pId,pName,pType,pCount from t_paper order by pType desc";
list3 = ius.getPapersByProperty(sql3);
if(list3.size()>0){
	for(int i =0;i<list3.size();i++){
	Paper p = list3.get(i);
	%>
	<tr><td>(<%=(i+1) %>) <%=p.getpName() %> [<%=p.getpCount() %>]</td></tr>
	<%
}
}
%>
 	
 </table>
 
 
 </td>
  <!-- 右边的； -->
 <td>
 
 <table id="paper2">
 
 	<tr><th>留言板</th></tr>
 	
<%
IMsgService ims = new MsgServiceImpl();
List<Msg> list2 = new ArrayList<>();
String sql2 ="select mId,mName,mDate from t_msg where mStatus=1 order by mId desc";
list2 = ims.getMsgsByProperty(sql2);
if(list2.size()>0){
	for(int i =0;i<list2.size();i++){
	Msg m = list2.get(i);
	
	String name=m.getmName();
	if(name.length()>5){
		name=name.substring(0,5);
	} 
	%>
	<tr><td>(<%=(i+1) %>) <%=name %> [<%=m.getmDate() %>] <span></span>
	
	<input  type="hidden"  value="<%=m.getmName() %>"/>
	
	</td></tr>
	<%
}
}
%>
 <tr>
 <td>
 
 <form action="addmsg.jsp" name="msgForm" method="post">
 
 <textarea rows="5" cols="30" name="mName"></textarea>
 <p> <input type="submit" value="我要留言 "/>  </p>
 </form>
 
 </td>
 </tr>	
 </table>
 </td>
 </tr>
 <tr><td colspan="4" align="center"><br/><br/><br/><br/> 	</td></tr>
 <tr><td colspan="4" align="center"  bgcolor="#CCC">版本所有，复制不究。</td></tr>
 </table>
 
 </div>
</body>
</html>