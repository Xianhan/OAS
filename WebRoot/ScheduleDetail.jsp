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
    
    <title>My JSP 'ScheduleDetail.jsp' starting page</title>
    
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
	  <td class="first">PubTime</td>
	  <td class="first">Content</td>
	  
	 </tr>
	  
	 <c:forEach items="${sessionScope.USSchedule}" var="uss">
	 
	 <tr>
	  <td class="td"> ${uss.title}  </td>
	  <td class="td"> ${uss.pubTime}</td>
	  <td class="td"> ${uss.content}</td>
	 </tr>
	 </c:forEach>
	 
	 </table>
     </div>
     </div>
  </body>
</html>
