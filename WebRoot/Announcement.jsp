<%@page import="com.neuq.entities.Messages"%>
<%@page import="com.neuq.entities.Worker"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>公告信息</title>
<link rel="stylesheet" href="css/Table.css" type="text/css" />
</head>
<div id="box">
	<div id="pos">
		<table id="AnnouncementTable" class="tab" border="1" cellpadding="3"
			cellspacing="0">
			<caption>公告列表</caption>
			<tr>
				<td class="first">公告编号</td>
				<td class="first">公告标题</td>
				<td class="first">发布时间</td>
				<td class="first">公告内容</td>
				<td class="first">发布人</td>
				<td class="first">操作</td>
			</tr>
			<c:forEach items="${sessionScope.AnnouncementList }" var="ann">
				<tr>
					<td class="td">${ann.id }</td>
					<td class="td">${ann.title}</td>
					<td class="td">${ann.punTime}</td>
					<td class="td">${ann.content }</td>
					<td class="td">${ann.promulgator.realname }</td>
					<td class="td"><a href="AnnouncementContent?annID=${ann.id}">详情</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</div>
<body>
</body>
</html>