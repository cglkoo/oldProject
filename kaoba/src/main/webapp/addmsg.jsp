<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.kaokaoba.msg.*,com.kaokaoba.keywords.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加通告 </title>
 
 </head>
 
 <body>
<%
request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
String mName=request.getParameter("mName");
IMsgService ins = new MsgServiceImpl();
String sql=" insert into t_msg (mName,mDate,mStatus) values (?,?,?)";
String date="";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
date=sdf.format(new java.util.Date());
int status=1;   //默认审核通过；
boolean f= false; //默认没有敏感词汇；
 
List<KeyWords> klist=(List<KeyWords>)application.getAttribute("listKeyWords");
for(KeyWords kw : klist){
	if(mName.indexOf(kw.getkName())>=0){
		f=true;
		break;
	}
}
if(f){
	status=0;  //表示有敏感词汇，不能在首页显示；
}
if(null!=mName){
	if(mName.trim().length()>0){
		int n=ins.addOrUpdateOrDelete(sql, mName,date,status);
		
	}
}

response.sendRedirect("index.jsp"); 
%>


 

</body>
</html>