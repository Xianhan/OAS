<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="css/Form.css" />
    <style type="text/css" ></style>
  </head>
  
  <body>
  <div id="box">
  	<div id="pos">
     <form action="managerCheckAffairs?affid=${sessionScope.affdetail.id}" method="post">
     	<table class="tab">
     	
 			<tr>
 				<td id="head" colspan="6" align="center">员工事务申请表</td>
 			</tr>
 				<tr>
 					<td class="first">名称</td>
 					<td class="td"><input type="text" class="inp" name="title" value="${sessionScope.affdetail.title}" readonly="readonly"/></td>
 					<td class="first">申请人</td>
 					<td class="td"><input type="text" class="inp" name="sender" value="${sessionScope.affdetail.sender.realname}" readonly="readonly" /></td>
 					<td class="first">接收人</td>
 					<td class="td"><input type="text" class="inp" name="receiver" value="${sessionScope.affdetail.receiver.realname}" readonly="readonly" /></td>
 				</tr>
 				<tr>
 					<td class="first">申请时间</td>
 					<td class="td"><input type="text" class="inp" name="applyTime" value="${sessionScope.affdetail.sendTime}" readonly="readonly" /></td>
 				
 					<td class="first">审核状态</td>
 					<c:if test="${sessionScope.affdetail.approvalProgress==0}">
 					<td class="td">
 						<input type="radio" name="status" value="1"/>通过
 						<input type="radio" name="status" value="2"/>不通过
 					</td></c:if>
 					<c:if test="${sessionScope.affdetail.approvalProgress==1}">
 					<td class="td">
 						<input type="radio" name="status"  checked="checked" value="1"/>通过
 						<input type="radio" name="status" disabled="disabled" value="2"/>不通过
 					</td></c:if>
 					<c:if test="${sessionScope.affdetail.approvalProgress==2}">
 					<td class="td">
 						<input type="radio" name="status" disabled="disabled" value="1"/>通过
 						<input type="radio" name="status"   checked="checked" value="2"/>不通过
 					</td></c:if>
 				</tr>
 			<tr>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 				<td>&nbsp;</td>
 				<td >&nbsp;</td>
 				<td >&nbsp;</td>
 			</tr>
 			</table>
 			<textarea rows="4" cols="100" class="td" name="applyContent" readonly="readonly"  >${sessionScope.affdetail.content}</textarea>
 			<div id="subbox"><input id="sub" type="submit"  name="sub" value="提交审核" /></div>
 		</form>
 	 </div>
 	</div>
  </body>
</html>
