<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>考勤详情</title>
<link href="css/SignOnDetail.css" rel="stylesheet"/>
</head>

<body>
<div id="box">
<div id="pos">
<div id="form">
<form action="SignOnDetail" method="post">
	<input type="month" name="date" placeholder="查询某年某月签到情况"> <input type="submit" value="查询">
</form>
</div>
<table class="tab">
	
	<tr><th class="first">签到时间</th><th class="first">签退时间</th><th class="first">是否迟到</th><th class="first">是否早退</th></tr>
	<c:forEach items="${sessionScope.gatecards}" var="gatecard">
	<tr><td class="td">${gatecard.arriveTime}</td><td class="td">${gatecard.leaveTime}</td><td class="td"><c:choose ><c:when test="${gatecard.isLate==1}">是</c:when><c:otherwise>否</c:otherwise></c:choose></td><td class="td"><c:choose ><c:when test="${gatecard.isLeaveEarly==1}">是</c:when><c:otherwise>否</c:otherwise></c:choose></td></tr>
	</c:forEach>
	<br>
</table>
</div>
</div>
</body>
</html>