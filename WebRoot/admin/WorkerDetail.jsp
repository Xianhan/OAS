<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工详情</title>
<link rel="stylesheet" href="css/Table.css" type="text/css" />
</head>
<body>
	<div id="box">
		<div id="pos">
			<table class="tab">
				<tr>
					<td class="first">工号</td>
					<td class="td">${sessionScope.WorkerDetail.id}</td>
				</tr>
				<tr>
					<td class="first">姓名</td>
					<td class="td">${sessionScope.WorkerDetail.realname}</td>
				</tr>
				<tr>
					<td class="first">E-mail</td>
					<td class="td">${sessionScope.WorkerDetail.email}</td>
				</tr>
				<tr>
					<td class="first">手机</td>
					<td class="td">${sessionScope.WorkerDetail.phone}</td>
				</tr>
				<tr>
					<td class="first">性别</td>
					<td class="td">${sessionScope.WorkerDetail.sex}</td>
				</tr>
				<tr>
					<td class="first">雇佣日期</td>
					<td class="td">${sessionScope.WorkerDetail.hiredate}</td>
				</tr>
				<tr>
					<td class="first">工作</td>
					<td class="td">${sessionScope.WorkerDetail.job.job}</td>
				</tr>
				<tr>
					<td class="first">家庭住址</td>
					<td class="td">${sessionScope.WorkerDetail.address}</td>
				</tr>
				<tr>
					<td class="first">员工状态</td>
					<td class="td">${sessionScope.WorkerDetail.status}</td>
				</tr>
				<tr>
					<td class="first">经理工号</td>
					<td class="td">${sessionScope.WorkerDetail.manager.id}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>