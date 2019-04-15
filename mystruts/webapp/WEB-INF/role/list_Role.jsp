<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
</head>
<body>
<div align="center">
<font color="red" size="100">${msg}</font>
<table>
<tr><th>序号</th><th>角色名称</th> <th>操作</th></tr>
<s:iterator value="list" id="r" status="v">
	<tr>
		<td><s:property value="#v.index+1"/></td>
		<td>${r.rName }</td>
		<td>
			<a href="get_Role.action?roleId=${r.rId }">修改</a>&nbsp;
			<a href="delete_Role.action?roleId=${r.rId }">删除</a>
		</td>
	</tr>
</s:iterator>
</table>
<form action="add_Role.action" method="post">
<p><input type="submit" value="新增"/></p>
</form>
</div>
</body>
</html>