<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工信息修改</title>
<link rel="stylesheet" type="text/css" href="../css/Form.css">
<style type="text/css"></style>
</head>
<body>
	<div id="box">
		<div id="pos">
			<form action="../AlterWorker" method="post">
				<table text-align="center" class="tab">
					<tr>
						<td class="first">员工工号</td>
						<td class="td"><input readonly="readonly" name="id"
							value="${alterWorker.id}"></td>
						<td class="first">员工姓名</td>
						<td class="td"><input name="realname"
							value="${alterWorker.realname}"></td>
					</tr>
					<tr>
						<td class="first">员工性别</td>
						<td class="td"><input name="sex" value="${alterWorker.sex}"></td>
						<td class="first">员工职位</td>
						<td class="td">
						<select name="job">
								<c:forEach items="${sessionScope.jobList}" var="job">
									<c:choose>
										<c:when test="${job.job==sessionScope.worker.job.job}">
											<option selected="selected" value="${job.id}">${job.job}</option>
										</c:when>
										<c:otherwise>
											<option value="${job.id}">${job.job}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td class="first">员工状态</td>
						<td class="td"><input name="status"
							value="${alterWorker.status}"></td>
						<td class="first">经理工号</td>
						<td class="td"><input name="manager"
							value="${alterWorker.manager.id}"></td>
					</tr>
				</table>
				<div id="subbox"><input id="sub" type="submit" value="确定修改"></div>
			</form>
		</div>
	</div>
</body>
</html>