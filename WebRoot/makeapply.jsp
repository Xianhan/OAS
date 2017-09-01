<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" type="text/css" href="css/Form.css" />
    <style type="text/css" ></style>
  </head>
  <body>
 	<div id="box">
 		<div id="pos">
 		<form action="checkApply" method="post">
 		<table class="tab" >
 			<tr>
 				<td class="td" id="head" colspan="6">员工事务申请表</td>
 			</tr>
 			<tr>
 				
 				<td class="first">申请人</td>
 				<td class="td">
 					<input class="inp" type="text" name="sender" value="${sessionScope.id}" readonly="readonly" />
 				</td>
 				<td class="first">接收人</td>
 				<td class="td">
 					<select name="manager">
				<c:forEach items="${sessionScope.managerList}" var="manager">
						<option value="${manager.id}">${manager.realname}</option>
						
				</c:forEach>
				</select>
 				</td>
 				<td class="first">申请时间</td>
 				<td class="td">
 					<input class="inp" type="text" name="applyTime" value="系统当前时间" readonly="readonly" />
 				</td> 
 			</tr>
 			<tr>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 			</tr>
 			<tr>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 				<td align="center">名称</td>
 				<td class="td"><input class="inp" type="text" name="title" value="" /></td>
 				<td ></td>
 				<td ></td>
 			</tr>
 			<tr>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 			</tr>
 			<tr>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 				<td >&nbsp;&nbsp;&nbsp;&nbsp;内容</td>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 			</tr>
 		</table>
 		<textarea class="td" name="content" rows="4" cols="100"></textarea><br/>
 		<div id="subbox">
 			<input id="sub" type="submit" name="sub" value="提交"/>
 		</div>
 		</form>	
 		</div>
 	</div>
 </body>
</html>
