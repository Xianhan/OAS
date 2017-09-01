<%@page import="com.neuq.entities.Messages"%>
<%@page import="com.neuq.entities.Worker"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>公告管理</title>
  <link href="css/Table.css" rel="stylesheet"/>

</head>
<body>
<div id="box">
<div id="pos">
<table class="tab" id="AnnouncementTable" border="1" cellpadding="3" cellspacing="0" >
<caption>公告列表&nbsp;&nbsp;&nbsp; <a href="admin/AddAnnouncement.jsp">发布新公告</a></caption>

	<tr>
		<td class="first">公告编号</td>
		<td class="first">公告标题</td>
		<td class="first">发布日期</td>
		<td class="first">公告内容</td>
		<td class="first">发布人</td>
		<td class="first" colspan="2">操作</td>

	</tr>
	<c:forEach items="${sessionScope.AnnouncementList }" var="ann">
		<tr>
			<td class="td">${ann.id }</td>
			<td class="td">${ann.title}</td>
			<td class="td">${ann.punTime}</td>
			<td class="td">${ann.content }</td>
			<td class="td">${ann.promulgator.realname }</td>
			<td class="td"><a class="link" href="AnnouncementContent?annID=${ann.id }">详情</a></td>
			<td class="td"><a class="link" href="DeleteAnnouncement?annID1=${ann.id }">删除</a></td>
		</tr>
	</c:forEach>

</table>
</div>
</div>
</body>
</html>