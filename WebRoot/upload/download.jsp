<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="../css/Table.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="box">
<div id="pos">
	<table class="tab">
	<c:forEach items="${sessionScope.files}" var="file"></c:forEach>
		<tr><a href="DownLoad?download=${file.name}">${file.name}</a></tr>
	</table>
	</div>
	</div>
</body>
</html>