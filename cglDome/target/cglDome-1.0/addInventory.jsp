<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.kaokaoba.inventory.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加通告 </title>
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
					$("span").text("手机型号不能为空");
					$("input").focus();
					$("input").css("border","1px solid red");
					return false;
				}else if(c==''){
					$("span").text("通告内容不能为空");
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
String mName=request.getParameter("mName");
String nContent=request.getParameter("nContent");
IInventoryService ins = new InventoryServiceImpl();
String sql=" insert into t_notice (mName,nContent,nDate) values (?,?,?)";
String date="";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
date=sdf.format(new java.util.Date());
if(null!=mName&&null!=nContent){
	if(mName.trim().length()>0&&nContent.trim().length()>0){
		int n=ins.addOrUpdateOrDelete(sql, mName,nContent,date);
		if(n>0){
			out.println("添加通告成功！");
		}else{
			out.println("添加通告失败！");
		}
	}
}else{
	out.println("添加通告页面：");
}
%>


</span>
<form action="addInventory.jsp" name="NoticeForm" method="post">
<div style="width: 580px;">
通告标题：&nbsp;&nbsp;<input name="mName"   size="50" /> &nbsp;&nbsp;
<br/><br/>
通告内容：&nbsp;&nbsp; <textarea  rows="5" name="nContent" cols="50"></textarea> &nbsp;&nbsp;
<br/><br/>
<button>&nbsp;&nbsp;&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;</button></div>
</form>
 <p>&nbsp;</p>

 
</div>

</body>
</html>