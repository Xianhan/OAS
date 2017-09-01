<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
<title>消息发送</title>
<link rel="stylesheet" type="text/css" href="css/SmallForm.css" />
<style type="text/css"></style>
<script type="text/javascript" src="js/workerExsit.js"></script>
</head>
<body>
	<div id="box">
		<div id="pos">
			<form action="SendMessages" method="post">
				<br /> <br /> <br />
				<table class="tab" >
					<tr>
						<td class="td">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您要发送至</td>
						<td class="td"><input type="text" name="receiver" id="name" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
					<td class="td"></td>
					<td class="td"><p id="nameMsg">请输入正确用户</p></td>
					</tr>
					<tr>
						<td class="td">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;消息内容</td>
						<td class="td"><input type="text" value="" id="content" name="content"
							height="400" width="750" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
				</table>
				<div id="subbox" >
				<input id="sub" type="submit" value="提交" display="inline">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
