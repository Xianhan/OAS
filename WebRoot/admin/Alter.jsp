<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Alert.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="css/Form.css">
    <style type="text/css"></style>
  </head>
  
  <body>
  <div id="box">
  	<div id="pos">
  	<form action="Alter"  >
  	<table class="tab">
   	 	<tr>
   	 		<td class="first">工号</td><td class="td"><input  type="text"  name="id"></td>
   	 		<td class="first">日期</td><td class="td"><input  type="text"  name="saldate"></td>
   	 		<td class="first">底薪</td><td class="td"><input  type="text"  name="salary"></td>
   	 		<td class="first">奖金</td><td class="td"><input  type="text"  name="bonus"></td>
   	 	</tr>
  		<tr>
  			<td class="first">税额</td><td class="td"><input  	type="text"  name="tax"></td>
  			<td class="first">克扣</td><td class="td"><input  	type="text"  name="attendantsal"></td>
  			<td class="first">实发工资</td><td class="td"><input    type="text"  name="realsal"></td>
  			<td >&nbsp;</td><td>&nbsp;</td>
  		</tr>  
  	</table>
   <div id="subbox"><input id="sub"  type="submit"  value="提交"></div>
   </form>
   </div>
  </div>
 </body>
</html>
