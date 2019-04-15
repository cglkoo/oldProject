<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.kaokaoba.stock.*,java.util.*" contentType="text/html; charset=UTF-8"
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
button:HOVER{
	cursor:pointer;
	background-color: orange;
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
				$("#sp").text("手机型号不能为空");
				$("#type").focus();
				$("#type").css("border","1px solid red");
				return false;
			}else if((n!='oppoFind9')&&(n!='oppoR9sPlus')&&(n!='oppoR9s')&&(n!='oppoR9Plus')&&(n!='oppoR9')){
				$("#sp").text("你输入的手机型号不存在！");
				return false;
			}else if(c==''){
				$("#sp").text("手机数量不能为空");
				$("#num").focus();
				$("#num").css("border","1px solid red");
				return false;
			}else if(isNaN(c)){
				$("#sp").text("手机数量请输入数字！");
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
<div align="center" style="color: orange; font-size: 20px;font-weight: bold;">手机进货修改</div>
<div align="center" style="margin-top: -45px">
<p>&nbsp;</p>
<span style="color: red" id="sp">

	<%
	request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
	String mId=request.getParameter("mId"); //表示从列表的页面链接过来。
	String mId2=request.getParameter("mId2");   //表示从自己的页面提交过来的。
	IStockService ins = new StockServiceImpl(); 
	String sql="select mType,mPrice,mNumber,mValue mDate from tb_stock where mId = ? ";
	String date="";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	date=sdf.format(new java.util.Date());   //获取修改后的通告日期；
	String name="";
	int number=0;
	int mPrice=0;
	int mValue=0;
	int id=0;
	if(null!=mId && mId.length()!=0){
		id=Integer.parseInt(mId);
	}
	if(mId2==null){    //表示从列表的页面链接过来。
	List<Stock> list = ins.getStocksByProperty(sql,id);
	if(list!=null && list.size()>0){
		Stock n = list.get(0);
		name=n.getmType();     //得到的是原来的手机型号；
		number=n.getmNumber(); //得到的是原来的数量；
	}
	}else{  //表示从自己的页面提交过来的。
	sql=" update tb_stock set mType=? , mPrice=?, mNumber=? , mValue=?, mDate=? where mId=? ";
	String mType=request.getParameter("mType");   //获取修改后的通告标题；
	String mNumber=request.getParameter("mNumber"); //获取修改后的通告内容；
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
	int num=ins.addOrUpdateOrDelete(sql, mType,mPrice,mNumber,mValue,date,mId2);	
	
	if(num>0){
		%>
		<script type="text/javascript">
	 		alert("修改成功！");
	 		window.location="stock.jsp";
		</script>
		<% 
	}else{
		out.println("修改失败");
	}
	}
	%>

</span>
	<form action="updateStock.jsp" name="StockForm" method="post">
		<div style="background-image: url('1.jpg');background-repeat:no-repeat;height: 500px;margin-top: -56px;border: 0">
		<div style="height: 60px"></div>
		<br>
		<div style="width: 580px">
		手机型号：&nbsp;&nbsp;<input name="mType" id="type"  value="<%=name %>"  size="20" /> &nbsp;&nbsp;
		<br><br><span style="background-color:white; ">（手机型号只能是oppoFind9、oppoR9sPlus、oppoR9s、oppoR9Plus、oppoR9）</span>
		<span style="background-color:white; ">（相对于的单价为1999、1599、1399、1699、1099）</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>
		手机数量：&nbsp;&nbsp; <input id="num"  name="mNumber" size="2" value="<%=number %>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<br/><br/><input type="hidden" name="mId2" value="<%=id %>"/>
		&nbsp;&nbsp;<button>
		&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;</button></div>
		</div>
	</form>
 <p>&nbsp;</p>
</div>
</body>
</html>