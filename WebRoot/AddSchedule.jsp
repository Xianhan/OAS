<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddSchedule.jsp' starting page</title>
    
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
    <div id="addspos">
    <form action="AddScheduleAction" method="post">
    <h4 align="center">添加日程</h4>
    <div id="adds" align="center">
    <table align="center">
    <tr> <td class="first">主题</td><td class="td"><input class="td"  type="text" name="title"></td> </tr>
    <tr> <td class="first">日期</td><td class="td"><input class="td"  type="text" name="date" placeholder="2000-01-01 14:30:30"></td> </tr>
    <tr> <td class="first">内容</td><td class="td"><textarea rows="3" cols="14"></textarea> </td> </tr>
    
    <tr align="center"><td colspan="2"> <input type="submit" value="提交"></td> </tr>
    </table>
    </div>
    </form>
    </div>
    </div> 
  </body>
</html>
