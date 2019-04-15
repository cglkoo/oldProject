<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.store.notice.*,java.util.*" contentType="text/html; charset=UTF-8"
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
	String nId=request.getParameter("nId");    //表示从列表的页面链接过来。
	String nId2=request.getParameter("nId2");   //表示从自己的页面提交过来的。
	INoticeService ins = new NoticeServiceImpl(); 
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String date=sdf.format(new java.util.Date());   //获取修改后的通告日期；
	
	String name="";
	String content="";
	String sql=" select nName,nContent,nDate from tb_notice where nId = ? ";
	int id=0;
	if(null!=nId && nId.length()!=0){
		id=Integer.parseInt(nId);
	}
	if(nId2==null){    //表示从列表的页面链接过来。
	
		List<Notice> list = ins.getNoticesByProperty(sql,id);
		if(list!=null && list.size()>0){
			Notice n = list.get(0);
			name=n.getnName();     //得到的是原来的通告标题；
			content=n.getnContent(); //得到的是原来的通告内容；
		}
	}else{  		//表示从自己的页面提交过来的。
		sql=" update tb_notice set nName=? , nContent=? , nDate=? where nId=? ";
		String nName=request.getParameter("nName");     //获取修改后的通告标题；
		String nContent=request.getParameter("nContent");  //获取修改后的通告内容；
		int num=ins.addOrUpdateOrDelete(sql, nName,nContent,date,nId2);	
		if(num>0){
			%>
			<script type="text/javascript">
	     		alert("修改公告成功！");
	     		window.location="notice.jsp";
			</script>
			<% 
		}else{
			out.println("修改公告失败！");
		}
	}
	%>
</span>
<form action="updateNotice.jsp" name="NoticeForm" method="post">
	<div style="width: 580px;">
	公告标题：&nbsp;&nbsp;<input name="nName"  value="<%=name %>"  size="50" /> &nbsp;&nbsp;
	<br/><br/>
	公告内容：&nbsp;&nbsp; <textarea  rows="5" name="nContent" cols="50" style="vertical-align: middle;"><%=content %></textarea> &nbsp;&nbsp;
	<br/><br/><input type="hidden" name="nId2" value="<%=id %>"/>
	<button>&nbsp;&nbsp;&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;</button></div>
</form>
<p>&nbsp;</p>

 
</div>

</body>
</html>