<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/Table.css" />
    <style type="text/css"></style>
  </head>
  <body>
  	<div id="box">
  	<div id="pos">
    	<table class="tab" >
    		<tr>
    			<td class="first">名称</td>
    			<td class="first">接收人</td>
    			<td class="first">发送时间</td>
    			<td class="first">审核结果</td>
    		</tr>
    		<c:forEach items="${sessionScope.arrayAff}" var="arr">
    		<tr>
    			<td class="td">${arr.title}</td>
    			<td class="td">${arr.receiver.realname}</td>
    			<td class="td">${arr.sendTime}</td>
    			<td class="td">
    			<c:if test="${arr.approvalProgress==0}">待审核</c:if>
    			<c:if test="${arr.approvalProgress==1}">通过</c:if>
    			<c:if test="${arr.approvalProgress==2}">不通过</c:if>
    			</td>
    		</tr>
    		</c:forEach>
    	</table>
    	</div>
    </div>
  </body>
</html>
