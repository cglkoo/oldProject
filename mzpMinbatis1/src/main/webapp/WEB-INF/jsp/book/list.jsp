<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="${rc.getContextPath() }/static/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${rc.getContextPath() }/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath() }/static/js/bootstrap.min.js"></script>
<title>图书列表</title>
<style type="text/css">
th{text-align: center;}
</style>
</head>
<body>
<form id="myForm" action="list" method="post">
<div class="container" style="margin-top: 50px;">
	<ol class="breadcrumb">
		<li>首页</li>
		<li>图书管理</li>
		<li class="active">图书列表</li>
	</ol>
	<div class="row" style="color:red;">${info }</div>
	<div class="row">
		<div class="col-sm-3">
			<input name="keyword" class="form-control" value="${keyword }" placeholder="按图书名称搜索">
			 <input type="hidden" id="fg" value="" name="flag" />
		</div>
		<button id="sch" class="btn btn-success">搜索</button>
		<button  id="del" class="btn btn-success">批量删除</button>
		<a href="update/0" class="btn btn-success">添加图书</a>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-striped table-hover" style="text-align: center;">
				<thead>
					<tr>
						<th>全选 <input type="checkbox" id="all" name="all" /></th>
						<th>序号</th>
						<th>图书名</th>
						<th>作者</th>
						<th>出版社</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${bookList }" var="book" varStatus="s">
					<tr>
						<td><input type="checkbox" value="${book.bId }" name="bids" id="bids" /></td>
						<td>${s.index + 1 }</td>
						<td>${book.bName }</td>
						<td>${book.bAuthor }</td>
						<td>${book.bPublisher }</td>
						<td><a href="update/${book.bId }" class="btn btn-info">修改</a>
							<button onclick="deletebook(${book.bId})" class="btn btn-danger">删除</button></td>
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
		$("input[name='bids']").prop("checked",f);    
	});
	$("#sch").click(function(){
		$("#fg").val("sch"); //表示搜索功能
		$("#PageNo").val("1")
		document.forms[0].action="${rc.getContextPath() }/book/list";
		document.forms[0].method="post";
		document.forms[0].submit();
	});
	$("#del").click(function(){
		if($('input[name="bids"]:checked').is(':checked')==true){
			var	u_ids=new Array();
			$('input[name="bids"]:checked').each(function(){  
		    	u_ids.push($(this).val());
		    });
			$.ajax({
				type:"post",
				//async: false,   //同步锁
				url:"${rc.getContextPath() }/book/deleteAll",
				traditional: true,  //阻止深度序列化
				data:{"ids":u_ids},
				dataType:"json",
				success:function(response){
					if(response.data == 1){
						alert("删除成功!");
						$('input[name="bids"]:checked').parent().remove();
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
function deletebook(bookId){
	if($('input[name="bids"]:checked').is(':checked')==true){
		$.ajax({
			type:"post",
			//async: false,  //同步锁
			url:"${rc.getContextPath() }/book/delete",
			data:{"bookId":bookId},
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