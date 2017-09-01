<%@page import="com.neuq.entities.Messages"%>
<%@page import="com.neuq.entities.Worker"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>消息管理</title>
<link rel="stylesheet" type="text/css" href="css/Table.css" />
<style type="text/css"></style>
</head>
<body>
<div id="box">
 	<div id="pos">
		<table class="tab" border="1" cellpadding="3" cellspacing="0" >
		<caption id="cap">您的消息列表</caption>
			<tr>
				<td class="first">消息编号</td>
				<td class="first">发送者</td>
				<td class="first">接受者</td>
				<td class="first">消息内容</td>
				<td class="first">时间</td>
				<td class="first">状态</td>
				<td class="first">操作</td>
			</tr>
		<c:forEach items="${sessionScope.MessagesList }" var="msg">
		<tr>
			<td class="td">${msg.id }</td>
			<td class="td">${msg.sender.realname}</td>
			<td class="td">${msg.receiver.realname}</td>
			<td class="td">${msg.content }</td>
			<td class="td">${msg.sendTime }</td>
			<td class="td"><a href="IsReadMessages?msgID=${msg.id}&isRead=${msg.isRead}&recevier=${msg.receiver.realname}"> 
			<c:choose>
					<c:when test="${msg.isRead==0}">未读</c:when>
					<c:otherwise>已读</c:otherwise>
			</c:choose>
			</a></td>
			<td class="td"><a href="DeleteMessages?messagesId=${msg.id }">删除</a></td>
		</tr>
		</c:forEach>
		</table>
	</div>
</div>
</body>
</html>