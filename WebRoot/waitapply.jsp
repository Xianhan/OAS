<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  </head>
  
  <body>
    <form action="" method="post">
 		<table>
 			<tr>
 				<td colspan="6">员工事务申请表</td>
 			</tr>
 			<tr>
 				<td>名称：</td>
 				<td><input type="text" name="name" value="" readonly="readonly" /></td>
 				<td>申请人：</td>
 				<td><input type="text" name="sender" value="" readonly="readonly" /></td>
 				<td>接收人：</td>
 				<td><input type="text" name="receiver" value="" readonly="readonly" /></td>
 			</tr>
 			<tr>
 				<td>申请时间：</td>
 				<td><input type="text" name="applyTime" value="" readonly="readonly" /></td>
 				<td>审核结果：</td>
 				<td>
 					<input type="radio" name="status" value="1" />通过
 					<input type="radio" name="status" value="2" />不通过
 				</td>
 			</tr>
 		</table>
 			<textarea name="applyContent" readonly="readonly">
 			</textarea>
 			<input type="submit" name="sub" value="提交"/>
 		</form>	
  </body>
</html>
