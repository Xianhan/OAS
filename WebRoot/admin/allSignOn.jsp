<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>考勤统计</title>
<link rel="stylesheet" type="text/css" href="css/Table.css" />
<style type="text/css"></style>
</head>
<body>
<div id="box">
 <div id="pos">
	<table class="tab">
	<tr>
		<td class="first">员工姓名</td>
		<td class="first">迟到天数</td>
		<td class="first">早退天数</td>
		<td class="first">签到天数</td>
		<td class="first">日期</td>
	</tr>
	<c:forEach items="${sessionScope.allList}" var="list">
	<tr>
		<td class="td">${list.worker.realname}</td>
		<td class="td">${list.lateDays}</td>
		<td class="td">${list.leaveearlyDays}</td>
		<td class="td">${list.arriveDays}</td>
		<td class="td">${list.month}</td>
	</tr>
	</c:forEach>
	</table>
 </div>
</div>	
</body>
</html>