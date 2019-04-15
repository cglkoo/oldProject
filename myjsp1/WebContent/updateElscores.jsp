<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.store.elscore.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改员工业绩</title>
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
				var c = $("#mnum").val();
				c = trimSpace(c);
			    if(c==''){
					$("span").text("数量不能为空");
					$("#mnum").focus();
					$("#mnum").css("border","1px solid red");
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
	String elscoreId=request.getParameter("elscoreId");       //表示从列表的页面链接过来的(根据Id)
	String elscoreId2=request.getParameter("elscoreId2");       //表示从自己的页面提交过来的(修改后的)
	IElScoresService ins = new ElScoresServiceImpl(); 
	
	String sql=" select mNum from tb_elscores WHERE elscoreId = ? ";
	int num=0;
	int id=0;
	if(null!=elscoreId && elscoreId.length()!=0){
		id=Integer.parseInt(elscoreId);
	}
	if(elscoreId2==null){    //表示从列表的页面链接过来。
		List<ElScores> list = ins.getElScoresByProperty(sql,id);
		if(list!=null && list.size()>0){
			ElScores n = list.get(0);
			num=n.getmNum();      //得到的是原来的手机数量
		}
	}else{  		//表示从自己的页面提交过来的。
		sql="UPDATE tb_elscores SET mNum = ? WHERE elscoreId=?;";
		String mNum=request.getParameter("mNum");  //获取修改后的手机数量
		int num3=ins.addOrUpdateOrDelete(sql,Integer.parseInt(mNum),elscoreId2);	
		if(num3>0){
			%>
			<script type="text/javascript">
	     		alert("修改成功！");
	     		window.location="elscores.jsp";
			</script>
			<% 
		}else{
			out.println("修改失败");
		}
	}
	%>
</span>
<form action="updateElscores.jsp" name="ElscoresForm" method="post">
	<div style="width: 580px;">
	手机数量：&nbsp;<input id="mnum" name="mNum" value="<%=num %>"/>&nbsp;&nbsp;
	<input type="hidden" name="elscoreId2" value="<%=id %>"/>
	<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button>&nbsp;&nbsp;&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;</button></div>
</form>
<p>&nbsp;</p>
</div>

</body>
</html>