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
    
    <title>My JSP 'UpdateSchedule.jsp' starting page</title>
    
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
    <b>编辑下列信息</b>
     <table class="tab">
     <tr>
	  <td class="first">Title</td>
	  <td class="first"> PubTime</td>
	  <td class="first">Content</td>
	  
	 </tr>
	  
	 <c:forEach items="${sessionScope.USSchedule}" var="uss">
	 <form action="SaveUpdateScheduleAction?scheid=${uss.scheId }" method="post">
	 <tr>
	  <td class="td"> <input class="upsinput" type="text" value="${uss.title}" name="title"></td>
	  <td class="td"> <input class="upsinput" type="text" value="${uss.pubTime}" name="pubtime"></td>
	  <td class="td"> <input class="upsinput" type="text" value="${uss.content}" name="content"></td>
	  
	  
	 </tr>
	 </c:forEach>
	 <tr ><td class="td" colspan="3"> <input type="submit" value="确认修改"> </td></tr>
	 </table>
    </form>
    </div>
    </div>
  </body>
</html>
