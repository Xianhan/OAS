<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>在线员工</title>
</head>
<body>
	<table>
		<tr><td>员工工号</td><td>员工姓名</td></tr>
		<%-- <c:forEach items="${sessionScope.wList}" var="worker">
		<tr><td>${worker.id}</td><td>${worker.realname}</td></tr></c:forEach> --%>
	</table>
	在线人数：${sessionScope.wList}
</body>
</html>