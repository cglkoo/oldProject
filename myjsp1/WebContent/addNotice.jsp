<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.store.notice.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加公告 </title>
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
	/*去除字符串前后的空格*/
	function trimSpace(str) {
		return str.replace(/(^\s+)|(\s+$)/g, "");
	}
	
	$(document).ready(function(){
			$("button").click(function(){
				 
				var n = $("input").val();
				n = trimSpace(n);
				var c = $("textarea").val();
				c = trimSpace(c);
				if(n==''){
					$("span").text("公告标题不能为空");
					$("input").focus();
					$("input").css("border","1px solid red");
					return false;
				}else if(c==''){
					$("span").text("公告内容不能为空");
					$("textarea").focus();
					$("textarea").css("border","1px solid red");
					return false;
				}else{
					document.forms[0].submit();  //提交表单
				}
			});
		
	});
</script> 

</head>
<body>

<div align="center">
<p>&nbsp;</p>
<span style="color: red">
	<%
	request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
	String nName=request.getParameter("nName");
	String nContent=request.getParameter("nContent");
	INoticeService ins = new NoticeServiceImpl();
	String sql=" insert into tb_notice (nName,nContent,nDate) values (?,?,?)";
	String date="";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	date=sdf.format(new java.util.Date());
	if(null!=nName&&null!=nContent){
		if(nName.trim().length()>0&&nContent.trim().length()>0){
			int n=ins.addOrUpdateOrDelete(sql, nName,nContent,date);
			if(n>0){
				%>
				<script type="text/javascript">
	     			alert("添加成功！");
	     			window.location="notice.jsp";
				</script>
				<% 
				
			}else{
				out.println("添加公告失败！");
			}
		}
	}else{
		out.println("添加公告页面：");
	}
	%>
</span>
<form action="addNotice.jsp" name="NoticeForm" method="post">
	<div style="width: 580px;">
	公告标题：&nbsp;&nbsp;<input name="nName" size="50" /> &nbsp;&nbsp;
	<br/><br/>
	公告内容：&nbsp;&nbsp; <textarea  rows="5" name="nContent" cols="50" style="vertical-align: middle;"></textarea> &nbsp;&nbsp;
	<br/><br/>
	<button>&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;</button></div>
</form>
<p>&nbsp;</p>
</div>
</body>
</html>