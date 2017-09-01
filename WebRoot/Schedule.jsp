<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My Schedule</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
   <link href="css/Table23.css" rel="stylesheet"/>
  </head>
  
  <body>
     <div id="box">
     <div id="pos">
    <table class="tab">
     <tr>
	  <td class="first">Title</td>
	  <td class="first"> PubTime</td>
	  <td class="first">Content</td>
	  <td class="first">详情</td>
	  <td class="first">修改</td>
	  <td class="first">删除</td>
	 </tr>
	  
	 <c:forEach items="${sessionScope.Schedule}" var="sl">
	 <tr>
	  <td class="td"> ${sl.title }</td>
	  <td class="td"> ${sl.pubTime }</td>
	  <td class="td"> ${sl.content}</td>
	  
	  <td class="td"><a class="link" href="ScheduleDetailAction?ussch=${ sl.scheId}">详情</a></td>
	  <td class="td"><a class="link" href="UpdateSelectScheduleAction?ussch=${ sl.scheId}">修改</a></td>
	  <td class="td"><a class="link" href="DelScheduleAction?delsch=${ sl.scheId}">删除</a></td>
	 </tr>
	 </c:forEach>
	
	 </table>
	 </div>
	 </div>
  </body>
</html>
