<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.store.sell.*,java.util.*" contentType="text/html; charset=UTF-8"
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
	text-align: center;
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
	request.setCharacterEncoding("UTF-8");    //解决中文乱码的问题；
	String mId=request.getParameter("mId");   //表示从列表的页面链接过来。
	String mId2=request.getParameter("mId2");   //表示从自己的页面提交过来的。
	ISellService ins = new SellServiceImpl(); 
	String sql="select mTypes,mPrices,mNumbers,mValues mDate from tb_sell where mId = ? ";
	String date="";
	String name="";
	int number=0;
	int mPrices=0;
	int mValues=0;
	int id=0;
	if(null!=mId && mId.length()!=0){
		id=Integer.parseInt(mId);
	}
	if(mId2==null){    //表示从列表的页面链接过来。
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	date=sdf.format(new java.util.Date());   //获取修改后的通告日期；
	List<Sell> list = ins.getSellsByProperty(sql,id);
	if(list!=null && list.size()>0){
		Sell n = list.get(0);
		name=n.getmTypes();     //得到的是原来的手机型号；
		number=n.getmNumbers(); //得到的是原来的数量；
	}
	}else{  //表示从自己的页面提交过来的。
	sql=" update tb_sell set mTypes=? , mPrices=?, mNumbers=? , mValues=?, mDate=? where mId=? ";
	String mTypes=request.getParameter("mTypes");   //获取修改后的通告标题；
	String mNumbers=request.getParameter("mNumbers"); //获取修改后的通告内容；
	if("oppoFind9".equals(mTypes)){
		mPrices=3999;
		mValues=mPrices*Integer.parseInt(mNumbers);
	}else if("oppoR9sPlus".equals(mTypes)){
		mPrices=3499;
		mValues=mPrices*Integer.parseInt(mNumbers);
	}else if("oppoR9s".equals(mTypes)){
		mPrices=2499;
		mValues=mPrices*Integer.parseInt(mNumbers);
	}else if("oppoR9Plus".equals(mTypes)){
		mPrices=2799;
		mValues=mPrices*Integer.parseInt(mNumbers);
	}else if("oppoR9".equals(mTypes)){
		mPrices=2199;
		mValues=mPrices*Integer.parseInt(mNumbers);
	}
	int num=ins.addOrUpdateOrDelete(sql, mTypes,mPrices,mNumbers,mValues,date,mId2);	
	
	if(num>0){
		out.println("修改成功");
	}else{
		out.println("修改失败");
	}
	}
	%>

</span>
<form action="updateSell.jsp" name="SellForm" method="post">
<div style="width: 580px;">
手机型号：&nbsp;&nbsp;<input name="mTypes" id="type"  value="<%=name %>"  size="20" /> &nbsp;&nbsp;
<br/><br/>
手机型号：&nbsp;&nbsp; <input id="num"  name="mNumbers" size="2" value="<%=number %>"> &nbsp;&nbsp;
<br/><br/><input type="hidden" name="mId2" value="<%=id %>"/>
<button>
&nbsp;&nbsp;&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;</button></div>
</form>
 <p>&nbsp;</p>


 
</div>

</body>
</html>