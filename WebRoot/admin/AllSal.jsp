<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

 <!-- 该页面用于显示所有人的工资 -->
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'AllSal.jsp' starting page</title>
		<link rel="stylesheet" type="text/css" href="css/Table.css">
		<style type="text/css"></style>
</head>
 <body>
  <div id="box">
  	<div id="pos">
  			<c:forEach  items="${sessionScope.empList}"  var="sal">
  				<form  action="LinkAlter?salid=${sal.salId}" method="post">
  					<table class="tab">
  					<caption>工资信息列表</caption><br>
							<tr> 
	 							<td class="first">工号</td>
	 							<td class="first">姓名</td>
	 							<td class="first">日期</td>
	 							<td class="first">薪水</td>
							</tr>
							<tr>
	 							<td class="td"><input type="text"  name="id"       class="h"  readonly="readonly" value="${sal.worker.id}"></td>
	 							<td class="td"><input type="text"  name="realname" class="h"  readonly="readonly" value="${sal.worker.realname}"> </td>
	 							<td class="td"><input type="text"  name="saldate"  class="h1" readonly="readonly" value="${sal.salDate}"> </td>
	 							<td class="td"><input type="text"  name="salary"   class="h"  readonly="readonly" value="${sal.salary}"> </td>
							</tr>
							<tr>
	 							<td class="first">奖金</td>
	 							<td class="first">税额</td>
	 							<td class="first">克扣工资</td>
	 							<td class="first">实发工资</td>	
							</tr>
							<tr>
								<td class="td"><input type="text"    name="bonus"  class="h" readonly="readonly" value="${sal.bonus}"> </td>
	 							<td class="td"><input type="text"    name="tax"   class="h"  readonly="readonly" value="${sal.tax}"> </td>
	 							<td class="td"><input type="text"    name="attendantsal" class="h1" readonly="readonly"    value="${sal.attendantsal}"> </td>
	 							<td class="td"><input type="text"    name="realsal" class="h1"   readonly="readonly"    value="${sal.realsal}"> </td>	
	 					</tr>
	 						</table>
	 						<div align="center" id="subbox"><input  id="sub" type="submit" name="submit" class="h"    value="修改"></div>
	  			</form> 
 				</c:forEach>
 		</div>
 	</div>
</body>
</html>
