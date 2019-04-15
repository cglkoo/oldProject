<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.kaokaoba.stock.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加手机进货 </title>
<style type="text/css">
button:HOVER{
	cursor:pointer;
	background-color: orange;
}
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
			 
			var n = $("#type").val();
			n = trimSpace(n);
			var c = $("#num").val();
			c = trimSpace(c);
			if(n==''){
				$("span").text("手机型号不能为空");
				$("#type").focus();
				$("#type").css("border","1px solid red");
				return false;
			}else if((n!='oppoFind9')&&(n!='oppoR9sPlus')&&(n!='oppoR9s')&&(n!='oppoR9Plus')&&(n!='oppoR9')){
				$("span").text("你输入的手机型号不存在！");
				return false;
			}else if(c==''){
				$("span").text("手机数量不能为空");
				$("#num").focus();
				$("#num").css("border","1px solid red");
				return false;
			}else if(isNaN(c)){
				$("span").text("手机数量请输入数字！");
				$("#num").focus();
				$("#num").css("border","1px solid red");
				return false;
			}else{
				document.forms[0].submit();  //提交表单
			}
		});
	});
</script> 

</head>
<body>
<div style="background-image: url('3.jpg');width: 1600px;height: 700px;margin-top: -20px;margin-left: -30px">
<div align="center" style="margin-left: -600px">
<p>&nbsp;</p>
<span style="color: red">
 
<%
request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
String mType=request.getParameter("mType");
String mNumber=request.getParameter("mNumber");
IStockService ins = new StockServiceImpl();
String sql="insert into tb_stock (mType,mPrice,mNumber,mValue,mDate) values (?,?,?,?,?)";
String date="";
int mPrice=0;
int mValue=0;
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
date=sdf.format(new java.util.Date());
if("oppoFind9".equals(mType)){
	mPrice=1999;
	mValue=mPrice*Integer.parseInt(mNumber);
}else if("oppoR9sPlus".equals(mType)){
	mPrice=1599;
	mValue=mPrice*Integer.parseInt(mNumber);
}else if("oppoR9s".equals(mType)){
	mPrice=1399;
	mValue=mPrice*Integer.parseInt(mNumber);
}else if("oppoR9Plus".equals(mType)){
	mPrice=1699;
	mValue=mPrice*Integer.parseInt(mNumber);
}else if("oppoR9".equals(mType)){
	mPrice=1099;
	mValue=mPrice*Integer.parseInt(mNumber);
}
if(null!=mType&&null!=mNumber){
	if(mType.trim().length()>0&&mNumber.trim().length()>0){
		int n=ins.addOrUpdateOrDelete(sql, mType,mPrice,mNumber,mValue,date);
		if(n>0){
			%>
			<script type="text/javascript">
     			alert("添加成功！");
     			window.location="stock.jsp";
			</script>
			<% 
		}else{
			out.println("添加进货失败！");
		}
	}
}else{
	out.println("添加手机进货页面：");
}
%>


</span>
<br><br>
<form action="addStock.jsp" name="StockForm" method="post">
<div style="width: 580px;">
手机型号：&nbsp;&nbsp;<input name="mType" id="type" size="20" /><br><br>（手机型号只能是oppoFind9、oppoR9sPlus、oppoR9s、oppoR9Plus、oppoR9） &nbsp;&nbsp;
（相对于的单价为1999、1599、1399、1699、1099）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/><br>
手机数量：&nbsp;&nbsp;<input id="num" name="mNumber" size="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button>
&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;</button></div>
</form>
 <p>&nbsp;</p>

 
</div>
</div>
</body>
</html>