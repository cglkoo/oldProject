<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页标签页面</title>
</head>
<body>
<div class="row">
	<input type="hidden" name="pageIndex" id="pageNo">
	<div class="col-sm-6">
		<div style="margin-top:30px;">
			共${page.totalCount }条记录，共${page.totalPage }页，当前第${page.pageNo }页，
			每页显示
			<select name="pageSize" onchange="pageSizeChange()">
				<option <c:if test="${page.pageSize eq 2 }">selected</c:if>>2</option>
				<option <c:if test="${page.pageSize eq 5 }">selected</c:if>>5</option>
				<option <c:if test="${page.pageSize eq 10 }">selected</c:if>>10</option>
				<option <c:if test="${page.pageSize eq 20 }">selected</c:if>>20</option>
				<option <c:if test="${page.pageSize eq 30 }">selected</c:if>>30</option>
			</select>
			条
		</div>
	</div>
	<div class="col-sm-6">
		<nav aria-label="Page navigation">
		  <ul class="pagination">
		  <!-- 计算上一页的页码 -->
		  	<c:set var="prePage" value="${page.pageNo - 1 }" scope="page"/>
		  	<c:if test="${prePage eq 0 }">
		  		<c:set var="prePage" value="1"/>
		  	</c:if>
		    <li>
		      <a href="#" onclick="goToPage(${prePage})" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		   
		    <!-- 计算循环的起始位置和结束位置 -->
		    <fmt:parseNumber var="rowNo" value="${page.pageNo / 5  }" integerOnly="true"/>
		    <c:if test="${page.pageNo % 5 == 0 }">
		    	<c:set var="rowNo" value="${ rowNo - 1}" scope="page"/>
		    </c:if>
		    <c:set var="startNo" value="${rowNo * 5 + 1 }"/>
		    <c:set var="endNo" value="${startNo + 4 }"/>
		    <c:if test="${endNo > page.totalPage }">
		    	<c:set var="endNo" value="${page.totalPage }"/>
		    </c:if>
		    <c:forEach begin="${startNo }" end="${endNo }" varStatus="s">
		    	<li <c:if test="${page.pageNo eq s.index }">class="active"</c:if> >
		    	<a href="#" onclick="goToPage(${s.index})">${s.index }</a></li>
		    </c:forEach>
		    <c:set var="nextPage" value="${page.pageNo + 1 }" scope="page"/>
		    <c:if test="${nextPage > page.totalPage }">
		    	<c:set var="nextPage" value="${page.totalPage }" scope="page"/>
		    </c:if>
		    <li>
		      <c:if test="${nextPage eq 0 }"><c:set var="nextPage" value="1" /></c:if>
		      <a href="#" onclick="goToPage(${nextPage})" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
	</div>
</div>
<script type="text/javascript">
function goToPage(pageNo){
	$("#pageNo").val(pageNo);
	$("#myForm").submit();
}
function pageSizeChange(){
	$("#pageNo").val(1);
	$("#myForm").submit();
}
</script>
</body>