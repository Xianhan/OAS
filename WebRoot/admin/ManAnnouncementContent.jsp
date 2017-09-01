<%@page import="com.neuq.entities.Messages"%>
<%@page import="com.neuq.entities.Worker"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="css/SmallForm.css" />
<title>公告详情</title>
</head>
<body>
	<div id=box>
		<div id="pos">
			<form action="UpdateAnnouncement?annID=${sessionScope.annContent.id}"
				method="post">
				<p class="first">公告标题:${sessionScope.annContent.title}</p>
				<p class="first">公告内容</p>
				<p class="td">
					<textarea id="bigtext" name="anncontent"
						 cols="40" rows="4">${sessionScope.annContent.content}</textarea>
				</p>
				<p class="first">发布时间:${sessionScope.annContent.punTime}</p>
				<p align="center">
					<input id="sub" type="submit" value="提交" id="annsubmit" /> <input
						id="sub" type="reset" value="重置" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>