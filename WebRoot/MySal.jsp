<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<style type="text/css">

.h{
width:50px;
}
.h1{
width:80px;
}


</style>


<html>
  <head>
   
    <title>My JSP 'AllSal.jsp' starting page</title>

	<link rel="stylesheet" type="text/css" href="css/Form.css" />
    </head>
  
  <body>
<div id="box">
 <div id="pos">
<table class="tab">
<tr>
	<td class="first"> 工号</td>
	 <td class="first"> 姓名</td>
	 <td class="first"> 日期</td>
	 <td class="first"> 薪水</td>
	 <td class="first">奖金</td>
	 <td class="first">税额 </td>
	 <td class="first"> 克扣工资</td>
	  <td class="first">实发工资</td>	
 
</tr>

  <c:forEach  items="${sessionScope.empList}"  var="sal">
<tr>
	
	 <td class="td"> <input  type="text"  name="id"      class="h" readonly="readonly" value="${sal.worker.id}"></td>
	 <td class="td"><input type="text"    name="realname"  class="h"  readonly="readonly" value="${sal.worker.realname}"> </td>
	 <td class="td"><input type="text"    name="saldate" class="h1"  readonly="readonly"  value="${sal.salDate}"> </td>
	 <td class="td"><input type="text"    name="salary"  class="h" readonly="readonly"  value="${sal.salary}"> </td>
	 <td class="td"><input type="text"    name="bonus"  class="h" readonly="readonly" value="${sal.bonus}"> </td>
	 <td class="td"><input type="text"     name="tax"   class="h"  readonly="readonly" value="${sal.tax}"> </td>
	 <td class="td"><input type="text"     name="attendantsal" class="h1" readonly="readonly"    value="${sal.attendantsal}"> </td>
	 <td class="td"><input type="text"    name="realsal" class="h1"   readonly="readonly"    value="${sal.realsal}"> </td>	
	 
</tr>

 </c:forEach>
</table>
 </div>
 </div>
  </body>
</html>