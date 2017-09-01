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
			<form>
			<br/>
				<p class="first">公告标题:${sessionScope.annContent.title}</p>
				<p class="first">公告内容</p>
				<p class="td" id="bigtext" name="anncontent" cols="40" rows="4">${sessionScope.annContent.content}</p>
				<p class="first">发布时间:${sessionScope.annContent.punTime}</p>

			</form>
		</div>
	</div>
</body>
</html>