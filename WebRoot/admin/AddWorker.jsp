<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>

<link rel="stylesheet" type="text/css" href="../css/Form.css" />
<title>添加员工</title>

</head>

<body>
	<div id="box">
		<div id="pos">

			<table class="tab" style="width:80%">
				<form action="../AddWorker" method="post">
				<tr>
					<td class="first">真实姓名</td>
					<td class="td"><input type="text" name="realname" required="required"></td>
				</tr>
				<tr>
					<td class="first">密码</td>
					<td class="td"><input type="password" name="password" required="required"></td>
				</tr>
				<tr>
					<td class="first">邮箱</td>
					<td class="td"><input type="email" name="email" required="required"></td>
				</tr>
				<tr>
					<td class="first">手机号码</td>
					<td class="td"><input type="text" name="phone" required="required"></td>
				</tr>
				<tr>
					<td class="first">性别</td>
					<td class="td"><input type="radio" name="sex" value="男"
						checked="checked">男 <input type="radio" name="sex"
						value="女">女</td>
				</tr>
				<tr>
					<td class="first">雇佣日期</td>
					<td class="td"><input type="date" name="hiredate" required="required"></td>
				</tr>
				<tr>
					<td class="first">职务</td>
					<td class="td"><select name="job">
							<c:forEach items="${sessionScope.jobList}" var="job">

								<option selected="selected" value="${job.id}">${job.job}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="first" >家庭住址</td>
					<td class="td"><input type="text" name="address" required="required"></td>
				</tr>
				<tr>
					<td class="first">员工状态</td>
					<td class="td"><input type="radio" name="status" value="0">离职
						<input type="radio" name="status" value="1" checked="checked">在职</td>
				</tr>

				<tr>
					<td class="first">经理</td>
					<td class="td"><select name="manager">
							<c:forEach items="${sessionScope.managerList}" var="manager">
								<option value="${manager.id}">${manager.realname}</option>
							</c:forEach>
					</select></td>
				</tr>
			
					<tr align="center"><td colspan="2"><input id="sub" type="submit" value="确认添加"></td></tr>
				
				</form>
			</table>


		</div>
	</div>
</body>
</html>
