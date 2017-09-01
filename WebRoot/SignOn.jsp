<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>签到</title>
	<link href="css/SignOn.css" rel="stylesheet"/>
</head>
<body>
<div id="box">
<div id="pos">
<div id="so">
<table class="tab">
<tr>
	<td id="right"><form action="Sign" method="post"><input class="input" type="submit" name="signon"  value="签到"></form></td>
	<td id="left"><form action="Sign" method="post"><input class="input" type="submit" name="signout" value="签退"></form></td>
</tr>

</table>
<br>
 <b id="b">本月已签到<span>${sessionScope.signedDays}</span>天</b>
</div>
</div>
</div>
</body>
</html>