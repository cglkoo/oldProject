<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加与修改爱好页面</title>
<link href="${rc.getContextPath() }/static/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${rc.getContextPath() }/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath() }/static/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row" style="margin-top:100px;">
		<div class="col-md-2"></div>
		<div class="col-md-6">
			 <form action="add.action" class="form form-horizontal" method="post" onsubmit="return onSubmit()">
				<input  type="hidden" name="pageSize" value="${pageSize }"/>
				 <input  type="hidden" name="hId" value="${hobby.hId }"/>
				<div class="form-group">
					<div class="col-sm-2"><label class="control-label"></label></div>
					<div class="col-sm-8" id="info" style="color:red;">${info }</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2" align="right"><label class="control-label">爱好名称:</label></div>
					<div class="col-sm-5">
						<input type="text" value="${hobby.hName }" class="form-control" id="hName" name="hName" onblur='checkName()' >
					</div>
					<div class="col-sm-3" align="left">
						<input id="sbm" type="submit" class="btn btn-info" value="提交保存" />
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
var flag = false;  // 标记能不能提交表单 
function checkName(){
	var v = $("#hName").val();
	if(v!=""||v.length>0){
		$.ajax({
			type:"POST",
			url:"${rc.getContextPath() }/hobby/checkName.action",
			data:{"hobbyName":v},
			dataType:"json",
			success:function(response){
				if(response.data==1){
					$("#info").text("该爱好名已经被占用,请输入别的爱好名");
					flag = false;
				}else{
					$("#info").text("该爱好名可以使用");
					flag = true;
				}
			}
		});
	}
}
function onSubmit(){
	var v = $("#hName").val();
	if(v ==""||v.length==0){
		$("#info").text("爱好名称不能为空");
		flag = false; 
	}
	return flag;
}

</script>	
</body>
</html>