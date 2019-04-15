<%@ page language="java" import="java.util.*,com.kaokaoba.notice.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
<!-- 这个注释在源代码中可以看到 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通告详情页面</title>
<style type="text/css">
p{
	width: 900px;
	line-height: 50px;
	text-indent: 2em;
}
</style>
</head>
<%--这 也是注释。所以你看不到。 --%>
<body>
 <%
 INoticeService ins = new NoticeServiceImpl(); 
 request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
 String nId=request.getParameter("nId"); //表示从首页链接过来。
 String ndate="";
 String name="";
 String content="";
 String sql=" select nName,nContent,nDate from t_notice where nId = ? ";
 int id=0;
 if(null!=nId && nId.length()!=0){
 	id=Integer.parseInt(nId);
 


 List<Notice> list = ins.getNoticesByProperty(sql,id);
 if(list!=null && list.size()>0){
 	Notice n = list.get(0);
 	name=n.getnName();     //得到的是原来的通告标题；
 	content=n.getnContent(); //得到的是原来的通告内容；
 	ndate=n.getnDate();
 }
 }
 %>
 
 <div align="center">
 	<h1><%=name %></h1><br/>
 	<hr/>
 		【发布日期：<%=ndate %>】
 	<br/>
 	
 	<p><%=content %></p>
 </div>
</body>
</html>