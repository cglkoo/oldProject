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
			$("#btn").click(function(){
				 
				var n = $("#i1").val();
				n = trimSpace(n);
				var c = $("#i2").val();
				c = trimSpace(c);
				var v = $("#i3").val();
				v = trimSpace(v);
				if(n==''){
					$("span").text("手机型号不能为空");
					$("#i1").focus();
					$("#i1").css("border","1px solid red");
					return false;
				}else if(c==''){
					$("span").text("手机价格不能为空");
					$("#i2").focus();
					$("#i2").css("border","1px solid red");
					return false;
				}else if(v==''){
					$("span").text("手机数量不能为空");
					$("#i3").focus();
					$("#i3").css("border","1px solid red");
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
	String mId=request.getParameter("mId"); //表示从列表的页面链接过来。
	String mId2=request.getParameter("mId2");   //表示从自己的页面提交过来的。
	IInventoryService ins = new InventoryServiceImpl(); 
	
	
	String name="";
	int price=0;
	int sum=0;
	String sql=" select mName,mPrice,mSum from tb_inventory where mId = ? ";
	int id=0;
	if(null!=mId && mId.length()!=0){
		id=Integer.parseInt(mId);
	}
	if(mId2==null){    //表示从列表的页面链接过来。
	
	
	List<Inventory> list = ins.getInventorysByProperty(sql,id);
	if(list!=null && list.size()>0){
		Inventory n = list.get(0);
		name=n.getmName();     //得到的是原来的手机型号；
		price=n.getmPrice();     //得到的是原来的手机价格；
		sum=n.getmSum();     //得到的是原来的手机数量；
	}
	}else{  //表示从自己的页面提交过来的。
		sql=" update tb_inventory set mName=? , mPrice=? , mSum=? where mId=? ";
		
		String mName=request.getParameter("mName");   //获取修改后的手机型号；
		String mPrice=request.getParameter("mPrice"); //获取修改后的手机价格；
		String mSum=request.getParameter("mSum"); //获取修改后的手机数量；
		
		int num=ins.addOrUpdateOrDelete(sql, mName,mPrice,mSum,mId2);	
		
		if(num>0){
			%>
			<script type="text/javascript">
	     		alert("修改成功！");
	     		window.location="inventory.jsp";
			</script>
			<% 
		}else{
			out.println("修改失败");
		}
	}
	%>


</span>
<form action="updateInventory.jsp" name="NoticeForm" method="post">
<div style="width: 580px;">
手机型号：&nbsp;&nbsp;<input id="i1" name="mName"  value="<%=name %>"  size="50" /> &nbsp;&nbsp;
<br/><br/>
手机价格：&nbsp;&nbsp;<input id="i2" name="mPrice"  value="<%=price %>"  size="50" /> &nbsp;&nbsp;
<br/><br/>
手机数量：&nbsp;&nbsp;<input id="i3" name="mSum"  value="<%=sum%>"  size="50" /> &nbsp;&nbsp;
<br/><br/>
<input type="hidden" name="mId2" value="<%=id %>"/>
<button id="btn">
&nbsp;&nbsp;&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;</button></div>
</form>
 <p>&nbsp;</p>

 
</div>

</body>
</html>