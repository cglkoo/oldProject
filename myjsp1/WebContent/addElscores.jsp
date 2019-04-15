<%@ page language="java" import="com.store.elscore.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加员工业绩</title>
<style type="text/css">
.redClass{
	border:1px solid red;
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
 		    var uid = $("input[name='userId']").val();
 		    uid = trimSpace(uid);
 			var u = $("input[name='userName']").val();
 			u = trimSpace(u);
 			var tp = $("input[name='mTypes']").val();
 			tp = trimSpace(tp);
 			var mp = $("input[name='mPrices']").val();
 			mp = trimSpace(mp);
 			var nu = $("input[name='mNum']").val();
 			nu = trimSpace(nu);
 			 if(uid==''){
  				$("span").text('用编号不能为空！');
  				$("input[name='userId']").focus();
  				$("input[name='userId']").addClass("redClass");
  				return false;
 			 }else if(u==''){
 				$("input[name='userId']").removeClass("redClass");
 				$("span").text('用户名不能为空！');
 				$("input[name='userName']").focus();
 				$("input[name='userName']").addClass("redClass");
 				return false;
 			}else if(tp==''){
 				$("input[name='userName']").removeClass("redClass");
 				$("span").text('手机型号不能为空！');
 				$("input[name='mTypes']").focus();
 				$("input[name='mTypes']").addClass("redClass");
 				return false;
 			}else if(mp==''){
 				$("input[name='mTypes']").removeClass("redClass");
 				$("span").text('手机售价不能为空！');
 				$("input[name='mPrices']").focus();
 				$("input[name='mPrices']").addClass("redClass");
 				return false;
 			}else if(nu==''){
 				$("input[name='mPrices']").removeClass("redClass");
 				$("span").text('销售数量不能为空！');
 				$("input[name='mNum']").focus();
 				$("input[name='mNum']").addClass("redClass");
 				return false;
 	     	}else{
 				$("input[name='mNum']").removeClass("redClass");
 				document.forms[0].submit();  //提交表单；
 	     	}
 		});
 	});
 </script>
</head>
<body>
<div align="center">
<p>&nbsp;</p>
<span style="color:red">&nbsp;&nbsp;
	<%
	request.setCharacterEncoding("UTF-8");
	String userId =request.getParameter("userId");
	String userName =request.getParameter("userName");
	String mTypes =request.getParameter("mTypes");
	String mPrices =request.getParameter("mPrices");
	String mNum =request.getParameter("mNum");
	IElScoresService iep = new ElScoresServiceImpl();
	String sql ="insert into tb_elscores (userId,userName,mTypes,mPrices,mNum) values (?,?,?,?,?) ";
	if(null!=userId && null!=userName && null!=mTypes && null!=mPrices && null!=mNum){
		if(userId.trim().length()>0 && userName.trim().length()>0 && mTypes.trim().length()>0 && mPrices.trim().length()>0 && mNum.trim().length()>0){
			int n=iep.addOrUpdateOrDelete(sql,Integer.parseInt(userId),userName,mTypes,Integer.parseInt(mPrices),Integer.parseInt(mNum));
			if(n>0){
				%>
				<script type="text/javascript">
	     			alert("添加成功！");
	     			window.location="elscores.jsp";
				</script>
				<% 
			}else{
				out.println("添加失败！");
			}
		}
	}else{
		out.println("添加业绩页面");
	}
	%>
</span><br/>
<form action="addElscores.jsp" name="addElForm" method="post" style="line-height: 30px; ">
	<p>用户编号:&nbsp;&nbsp;<input name="userId" ></p>
	<p>用&nbsp;户&nbsp;名:&nbsp;&nbsp;<input name="userName" ></p>
	<p>手机型号:&nbsp;&nbsp;<input name="mTypes" ></p>
	<p>手机单价:&nbsp;&nbsp;<input name="mPrices"></p>
	<p>数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量:&nbsp;&nbsp;&nbsp;<input name="mNum"></p>
	<p>&nbsp;&nbsp;<button>提&nbsp;&nbsp;交&nbsp;&nbsp;并&nbsp;&nbsp;保&nbsp;&nbsp;存</button></p>
</form>
</body>
</html>