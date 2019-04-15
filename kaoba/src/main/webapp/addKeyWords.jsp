<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.kaokaoba.role.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加词汇 </title>
<style type="text/css">
table{
	border: 1px blue solid;
	border-collapse: collapse;
}

td{
	border: 1px blue solid;
	width: 200px;
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
				 
				if(n==''){
					$("span").text("词汇名称不能为空");
					$("input").focus();
					$("input").css("border","1px solid red");
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
String kName=request.getParameter("kName");
IRoleService irs = new RoleServiceImpl();
String sql=" insert into t_keywords (kName) values (?)";
 
if(null!=kName){
	if(kName.trim().length()>0){
		int n=irs.addOrUpdateOrDelete(sql, kName);
		if(n>0){
			out.println("添加词汇成功！");
		}else{
			out.println("添加词汇失败！");
		}
	}
}else{
	out.println("添加词汇页面：");
}
%>


</span>
<form action="addKeyWords.jsp" name="KeyForm" method="post">
<div style="width: 580px;">
词汇名称：&nbsp;&nbsp;<input name="kName"   size="50" /> &nbsp;&nbsp;
<br/><br/>
 
<button>
&nbsp;&nbsp;&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;</button></div>
</form>
 <p>&nbsp;</p>

 
</div>

</body>
</html>