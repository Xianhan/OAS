<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工管理</title>
<link href="../css/Form.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="box">
		<div id="pos">
			<table class="tab">
				<tr>
					<td class="first">工号</td>
					<td class="first">姓名</td>
					<td class="first">性别</td>
					<td class="first">职务</td>
					<td class="first">员工详情</td>
					<td class="first">编辑</td>
					<td class="first">删除</td>
				</tr>
				<c:forEach items="${sessionScope.pWorker}" var="worker">
					<tr>
						<td class="td">${worker.id}</td>
						<td class="td">${worker.realname}</td>
						<td class="td">${worker.sex}</td>
						<td class="td">${worker.job.job}</td>
						<td class="td"><a href="../WorkerDetail?id=${worker.id}">查看详情</a></td>
						<td class="td"><a href="../WorkerDetail?alter=${worker.id}">修改</a></td>
						<%-- <td class="td"><a href="../WorkerDetail?delete=${worker.id}">删除</a></td> --%>

					</tr>
				</c:forEach>
			</table>
			<div align="center">
				<span>共${sessionScope.page.totalPage}页</span> 
				<a href="../ShowAllWorker?reqNum=${sessionScope.page.previous }">上一页</a>
				<c:choose>
				<c:when test="${sessionScope.page.totalPage<5}">
					<c:forEach begin="1" end="${sessionScope.page.totalPage}" step="1" var="pnum">
					<a href="../ShowAllWorker?reqNum=${pnum}">${pnum }</a>
				</c:forEach>
				</c:when>
				<c:when test="${sessionScope.page.reqPage==1||sessionScope.page.reqPage==2}">
					<c:forEach begin="1" end="5" step="1" var="pnum">
					<a href="../ShowAllWorker?reqNum=${pnum}">${pnum }</a>
				</c:forEach>
				</c:when>
				<c:when test="${sessionScope.page.reqPage==sessionScope.page.totalPage||sessionScope.page.reqPage==(sessionScope.page.totalPage-1)}">
					<c:forEach begin="${sessionScope.page.totalPage-4}" end="${sessionScope.page.totalPage}" step="1" var="pnum">
					<a href="../ShowAllWorker?reqNum=${pnum}">${pnum }</a>
				</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach begin="${sessionScope.page.reqPage-2}" end="${sessionScope.page.reqPage+2}" step="1" var="pnum">
					<a href="../ShowAllWorker?reqNum=${pnum}">${pnum }</a>
				</c:forEach>
				</c:otherwise>
				</c:choose>
				<%-- <c:forEach begin="1" end="${sessionScope.page.totalPage}" step="1" var="pnum">
					<a href="../ShowAllWorker?reqNum=${pnum}">${pnum }</a>
				</c:forEach> --%>
				<a href="../ShowAllWorker?reqNum=${sessionScope.page.next }">下一页</a>
			</div>
		</div>
	</div>
</body>
</html>