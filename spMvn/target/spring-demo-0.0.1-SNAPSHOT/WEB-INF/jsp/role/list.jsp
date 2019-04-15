<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="${rc.getContextPath() }/static/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${rc.getContextPath() }/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath() }/static/js/bootstrap.min.js"></script>
<title>角色列表</title>
<style type="text/css">
th{text-align: center;}
</style>

</head>
<body>
<form id="myForm" action="list" method="post">
<div class="container" style="margin-top: 50px;">
	<ol class="breadcrumb">
		<li>首页</li>
		<li>角色管理</li>
		<li class="active">角色列表</li>
	</ol>
	<div class="row">
		<div class="col-sm-3">
			<input name="keyword" class="form-control" value="${keyword }" placeholder="按角色名称搜索">
			 <input type="hidden" id="fg" value="" name="flag" />
		</div>
		<button id="sch" class="btn btn-success">搜索</button>
		<button  id="del" class="btn btn-success">批量删除</button>
		<a href="input" class="btn btn-success">添加角色</a>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-striped table-hover" style="text-align: center;">
				<thead>
					<tr>
						<th width="10%">全选 <input type="checkbox" id="all" name="all" /></th>
						<th width="10%">序号</th>
						<th width="30%">角色名</th>
						<th width="20%">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${roleList }" var="role" varStatus="s">
					<tr>
						<td><input type="checkbox" value="${role.rId }" name="rids" id="rids" /></td>
						<td>${s.index + 1 }</td>
						<td>${role.rName }</td>
						<td><a href="input?roleId=${role.rId }&pageSize=${pageSize}" class="btn btn-info">修改</a>
							<button class="btn btn-danger" onclick="deleterole(${role.rId})">删除</button></td>
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
		$("input[name='rids']").prop("checked",f);    
	});
	$("#sch").click(function(){
		$("#fg").val("sch"); //表示搜索功能
		document.forms[0].action="list";
		document.forms[0].method="post";
		document.forms[0].submit();
	});
	$("#del").click(function(){
		if($('input[name="rids"]:checked').is(':checked')==true){
			var	u_ids=new Array();
			$('input[name="rids"]:checked').each(function(){  
		    	u_ids.push($(this).val());
		    });
			$.ajax({
				type:"post",
				async: false,  //同步
				url:"${rc.getContextPath() }/role/deleteAll",
				traditional: true,  //阻止深度序列化
				data:{"ids":u_ids},
				dataType:"json",
				success:function(response){
					if(response.data == 1){
						alert("删除成功!");
						$('input[name="keyword"]').val(response.keyword);
						$('input[name="rids"]:checked').parent().remove();
						//window.location.href="${rc.getContextPath()}/role/list";  //更新页面
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
function deleterole(roleId){
	if($('input[name="rids"]:checked').is(':checked')==true){
		$.ajax({
			type:"post",
			async: false,  //同步
			url:"${rc.getContextPath() }/role/delete",
			//traditional: true,  //阻止深度序列化
			data:{"roleId":roleId},
			dataType:"json",
			success:function(response){
				if(response.data == 1){
					alert("删除成功!");
					$('input[name="keyword"]').val(response.keyword);
					$(this).parent().parent().remove();
					//window.location.href="${rc.getContextPath()}/role/list";
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