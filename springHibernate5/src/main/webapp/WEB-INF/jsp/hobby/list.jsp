<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${rc.getContextPath() }/static/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${rc.getContextPath() }/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${rc.getContextPath() }/static/js/bootstrap.min.js"></script>
<title>爱好列表</title>
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
					<input type="text" name="hobbyName" class="form-control"
						value="${hobbyName }" placeholder="按用户名称搜索"> <input
						type="hidden" id="fg" value="" name="flag" />
				</div>
				<button id="sch" class="btn btn-success">搜索</button>
				<button id="del" class="btn btn-success">批量删除</button>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th width="20%">全选 <input type="checkbox" id="all"
									name="all" /></th>
								<th width="30%">序号</th>
								<th width="30%">爱好名称</th>
								<th width="20%">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${hobbyList }" var="hobby" varStatus="s">
								<tr id="${hobby.hId}">
									<td><input type="checkbox" value="${hobby.hId }"
										name="uids" /></td>
									<td>${s.index + 1 }</td>
									<td>${hobby.hName }</td>

									<td><a href="reviseUser?hobbyId=${hobby.hId }"
										hobby="button" class="btn btn-info">修改</a> <a href="#"
										onclick="deleteHobby(${hobby.hId})" hobby="button"
										class="btn btn-danger">删除</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>


		</div>
	</form>
	<script type="text/javascript">

$(document).ready(function(){
	//全选
	$("#all").click(function(){
		var f=$("#all").is(':checked');
		$("input[name='uids']").prop("checked",f);    
  
	});
	$("#del").click(function(){
		$("#fg").val("del"); //表示搜索功能；
		 
	});
	$("#sch").click(function(){
		$("#fg").val("sch"); //表示搜索功能；
		 
	});
});


function deleteHobby(hId){
	if(confirm("您确定要删除该兴趣爱好吗?") == true){
		$.ajax({
			type:"POST",
			url:"deleteHobby.action",
			data:{"hobbyId":hId},
			dataType:"json",
			success:function(response){
				 
					alert(response.message);
					window.location.href="list.action";
				 
			}
		});
	}
}

function showImage(path){
 
	var obj = new Object();
	obj.name=path;
	var sFeatures = "dialogHeight=900px;dialogWidth=900px;resizeable=no;help=no;status=no;location=no;toolbar=no;menubar=no;titlebar=no;";
	var returnValue = window.showModalDialog ("img.html",obj,sFeatures);  
	//"dialogWidth=800px;dialogHeight=800px;status=no;help=no;scroll=no;resizable=no;location=no;toolbar=no"
	var path2= "http://localhost:8080/kaoba/"+path;
	if(returnValue=="1"){
		//alert(path);
		//document.getElementById(path).style="border: 10px gray solid";
		$("img").each(function(){
			if(this.src==path2) {
				//$(this).addClass("selected");
				$(this).toggleClass("selected");
			}  
		});
	}  

}
</script>

</body>
</html>