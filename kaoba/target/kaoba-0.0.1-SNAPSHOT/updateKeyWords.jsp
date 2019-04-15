<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.kaokaoba.keywords.*,java.util.*" contentType="text/html; charset=UTF-8"
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
String kId=request.getParameter("kId"); //表示从列表的页面链接过来。
IKeywordsService ins = new KeyWordsImpl(); 
 
String id=request.getParameter("id"); //隐藏域id。
String name="";
 
String sql=" select kName  from t_keywords where kId = ? ";
int keyId=0;
if(null!=kId && kId.length()!=0){
	keyId=Integer.parseInt(kId);
}
if(id==null){    //表示从列表的页面链接过来。

Object obj = ins.getObjectByProperty(sql, keyId);
name = obj.toString();   //查询到的敏感词汇；
}else{  //表示从自己的页面提交过来的。
sql=" update t_keywords set kName=?   where kId=? ";

String kName2=request.getParameter("kName");   //表单获取到的新的词汇；
 
 
int num=ins.addOrUpdateOrDelete(sql, kName2, id);	

if(num>0){
	out.println("修改成功");
}else{
	out.println("修改失败");
}
}
%>


</span>
<form action="updateKeyWords.jsp" name="NoticeForm" method="post">
<div style="width: 580px;">
敏感词汇：&nbsp;&nbsp;<input name="kName"  value="<%=name %>"  size="50" /> &nbsp;&nbsp;
<br/><br/>
<br/><br/><input type="hidden" name="id" value="<%=kId %>"/>
<button>
&nbsp;&nbsp;&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;</button></div>
</form>
 <p>&nbsp;</p>

 
</div>

</body>
</html>