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
<title>角色列表</title>
</head>
<body>

	<form id="myForm" action="list.action" method="post">
		<div class="container" style="margin-top: 50px;">
			<ol class="breadcrumb">
				<li>首页</li>
				<li>角色管理</li>
				<li class="active">角色列表</li>
			</ol>
			<div class="row">
				<div class="col-sm-3">
					<input type="text" name="roleName" class="form-control"
						value="${roleName }" placeholder="按用户名称搜索"> <input
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
								<th width="30%">角色名称</th>
								<th width="20%">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${roleList }" var="role" varStatus="s">
								<tr id="${role.rName}">
									<td><input type="checkbox" value="${role.rName }"
										name="rids" /></td>
									<td>${s.index + 1 }</td>
									<td>${role.rName }</td>

									<td><a href="reviseUser?roleId=${role.rName }"
										role="button" class="btn btn-info">修改</a> <a
										href="deleteRolebyRid.action?rName=${role.rName }"
										role="button" class="btn btn-danger">删除</a></td>
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


function deleteRole(rId){
	if(confirm("您确定要删除该角色吗?") == true){
		$.ajax({
			type:"POST",
			url:"role/deleteRolebyRid",
			data:{"roleId":rId},
			dataType:"json",
			success:function(response){
				if(response.data == 1){
					alert("删除成功");
					window.location.href="role/list.action";
				}else{
					alert("删除失败");
				}
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