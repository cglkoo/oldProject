<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="${rc.getContextPath() }/static/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${rc.getContextPath() }/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath() }/static/js/bootstrap.min.js"></script>
<title>爱好列表</title>
<style type="text/css">
th{text-align: center;}
</style>
</head>
<body>
<form id="myForm" action="list.action" method="post">
<div class="container" style="margin-top: 50px;">
	<ol class="breadcrumb">
		<li>首页</li>
		<li>爱好管理</li>
		<li class="active">爱好列表</li>
	</ol>
	<div class="row">
		<div class="col-sm-3">
			<input name="keyword" class="form-control" value="${keyword }" placeholder="按爱好名称搜索">
			 <input type="hidden" id="fg" value="" name="flag" />
		</div>
		<button id="sch" class="btn btn-success">搜索</button>
		<button  id="del" class="btn btn-success">批量删除</button>
		<a href="input.action" class="btn btn-success">添加爱好</a>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-striped table-hover" style="text-align: center;">
				<thead>
					<tr>
						<th width="10%">全选 <input type="checkbox" id="all" name="all" /></th>
						<th width="10%">序号</th>
						<th width="30%">爱好名</th>
						<th width="20%">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${hobbyList }" var="hobby" varStatus="s">
					<tr>
						<td><input type="checkbox" value="${hobby.hId }" name="hids" id="hids" /></td>
						<td>${s.index + 1 }</td>
						<td>${hobby.hName }</td>
						<td><a href="input.action?hobbyId=${hobby.hId }" class="btn btn-info">修改</a>
							<button class="btn btn-danger" onclick="deletehobby(${hobby.hId})">删除</button></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 静态包含分页页面； -->
	<%@ include file="../page/page.jsp"%>
</div>
</form>
<script type="text/javascript">

$(document).ready(function(){
	//全选
	$("#all").click(function(){
		var f=$("#all").is(':checked');
		$("input[name='hids']").prop("checked",f);    
	});
	$("#sch").click(function(){
		$("#pageNo").val("1"); //表示搜索功能；
		$("#fg").val("sch"); //表示搜索功能
		document.forms[0].action="${rc.getContextPath() }/hobby/list.action";
		document.forms[0].method="post";
		document.forms[0].submit();
	});
	$("#del").click(function(){
		if($('input[name="hids"]:checked').is(':checked')==true){
			var	u_ids=new Array();
			$('input[name="hids"]:checked').each(function(){  
		    	u_ids.push($(this).val());
		    });
			$.ajax({
				type:"post",
				async: false,  //同步
				url:"${rc.getContextPath() }/hobby/deleteAll.action",
				traditional: true,  //阻止深度序列化
				data:{"ids":u_ids},
				dataType:"json",
				success:function(response){
					if(response.data == 1){
						alert("删除成功!");
						$('input[name="hids"]:checked').parent().remove();
					}else{
						alert("删除失败!");
					}
				}
			});	
		}else{
			alert("请至少选择一个你要删除的选项！");
		}
	});
});
function deletehobby(hobbyId){
	if($('input[name="hids"]:checked').is(':checked')==true){
		$.ajax({
			type:"post",
			async: false,  //同步
			url:"${rc.getContextPath() }/hobby/delete.action",
			//traditional: true,  //阻止深度序列化
			data:{"hobbyId":hobbyId},
			dataType:"json",
			success:function(response){
				if(response.data == 1){
					alert("删除成功!");
					$(this).parent().parent().remove();
				}else{
					alert("删除失败!");
				}
			}
		});	
	}else{
		alert("请选中你要删除的选项!");
	}
}
</script>
</body>
</html>