<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${rc.getContextPath() }/static/js/jquery-3.2.1.min.js"></script>
</head>
<body>
	${hello }
	<script type="text/javascript">
function sayHello(){
	$.ajax({
		type:'POST',
		url:'${rc.getContextPath()}/hello/haha',
		contentType:"application/json",
		data:{"uId":123,"userName":"ddddd", "userPwd":"5656", "userIcon":"wewewe"},
		success:function(resp){
			console.log(resp);
		}
	});
}
</script>
</body>
</html>