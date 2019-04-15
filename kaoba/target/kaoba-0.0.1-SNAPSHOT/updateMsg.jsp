<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.kaokaoba.msg.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加通告 </title>
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
				var c = $("textarea").val();
				c = trimSpace(c);
				if(n==''){
					$("span").text("通告标题不能为空");
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
String mId=request.getParameter("mId");
 
IMsgService ims = new MsgServiceImpl();
String sql=" update  t_msg set mStatus=1  where mId=? ";
 
if(null!=mId){
	 
		int n=ims.addOrUpdateOrDelete(sql,Integer.parseInt(mId));
		response.sendRedirect("msg.jsp");
		 
}
%>


</span>
 
 

 
</div>

</body>
</html>