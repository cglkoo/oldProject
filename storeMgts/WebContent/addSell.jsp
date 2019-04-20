<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="com.store.sell.*,java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加已售手机商品</title>
<style type="text/css">
table {
	border: 1px blue solid;
	border-collapse: collapse;
}

td {
	border: 1px blue solid;
	width: 200px;
	text-align: center;
}
</style>
<script type="text/javascript" src="myjs/jquery-3.2.1.min.js"></script>
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
		<span style="color: red"> <%
	request.setCharacterEncoding("UTF-8");//解决中文乱码的问题；
	String mTypes=request.getParameter("mTypes");
	String mNumbers=request.getParameter("mNumbers");
	ISellService ins = new SellServiceImpl();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String date=sdf.format(new java.util.Date());
	String sql="insert into tb_sell (mTypes,mPrices,mNumbers,mValues,mDate) values (?,?,?,?,?)";
	int mPrices=0;
	int mValues=0;
	if("oppoFind9".equals(mTypes)){
		mPrices=1999;
		mValues=mPrices*Integer.parseInt(mNumbers);
	}else if("oppoR9sPlus".equals(mTypes)){
		mPrices=1599;
		mValues=mPrices*Integer.parseInt(mNumbers);
	}else if("oppoR9s".equals(mTypes)){
		mPrices=1399;
		mValues=mPrices*Integer.parseInt(mNumbers);
	}else if("oppoR9Plus".equals(mTypes)){
		mPrices=1699;
		mValues=mPrices*Integer.parseInt(mNumbers);
	}else if("oppoR9".equals(mTypes)){
		mPrices=1099;
		mValues=mPrices*Integer.parseInt(mNumbers);
	}
	if(null!=mTypes && null!=mNumbers){
		if(mTypes.trim().length()>0 && mNumbers.trim().length()>0){
			int n=ins.addOrUpdateOrDelete(sql, mTypes,mPrices,mNumbers,mValues,date);
			if(n>0){
				out.println("添加成功！");
			}else{
				out.println("添加失败！");
			}
		}
	}else{
		out.println("添加手机出售页面：");
	}
	%>
		</span>
		<form action="addSell.jsp" name="SellForm" method="post">
			<div style="width: 580px;">
				手机型号：&nbsp;&nbsp;<input name="mTypes" size="20" /><br>（手机型号只能是oppoFind9、oppoR9sPlus、oppoR9s、oppoR9Plus、oppoR9）
				&nbsp;&nbsp; <br /> <br /> 手机数量：&nbsp;&nbsp;<input name="mNumbers"
					size="4">&nbsp;&nbsp; <br /> <br />
				<button>&nbsp;&nbsp;&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;</button>
			</div>
		</form>
		<p>&nbsp;</p>
	</div>
</body>
</html>