<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>公告发布</title>
<link rel="stylesheet" type="text/css" href="../css/SmallForm.css">
<script type="text/javascript" src="admin/js/InputTextArea.js"></script>
</head>

<body>
	<div id="box">
	<div id="pos">
		<form action="../AddAnnouncement" method="post">
			<p class="first">公告标题  </p>
			<p class="td"><input type="text" name="anntitle"></p>
			<p class="first">公告内容</p>
			<p class="td">
				<textarea id="bigtext" name="anncontent" cols="40" rows="4" ></textarea>
			</p>
			<p align="center">
				<input id="sub" type="submit" value="提交" id="annsubmit" /> 
				<input id="sub" type="reset" value="重置" />
			</p>
		</form>
		</div>
	</div>
</body>
</html>
