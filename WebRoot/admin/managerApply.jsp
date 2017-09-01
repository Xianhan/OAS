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
    <link rel="stylesheet" type="text/css" href="css/Table.css" />
    <style type="text/css"></style>
  </head>
  <body>
  <div id="box">
   <div id="pos">
  	<table class="tab">
  			<tr>
  				<td class="first">名称</td>
  				<td class="first">发送人</td>
  				<td class="first">发送时间</td>
  				<td class="first">员工详情</td>
  				<td class="first">审核状态</td>
  			</tr>
  		<c:forEach items="${sessionScope.maffair}" var="marr">
    		<tr>
    			<td class="td">${marr.title}</td>
    			<td class="td">${marr.sender.realname}</td>
    			<td class="td">${marr.sendTime}</td>
    			<td class="td"><a href="ApplyDetail?affid=${marr.id}">详情</a></td>
    			<td class="td">
    			<c:if test="${marr.approvalProgress==0}">待审核</c:if>
    			<c:if test="${marr.approvalProgress==1}">通过</c:if>
    			<c:if test="${marr.approvalProgress==2}">不通过</c:if>
    			</td>
    		</tr>
    	</c:forEach>
     </table>
  	</div>
   </div> 	
  </body>
</html>
