<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

                   <!-- 显示并可以修改某个人工资的 界面-->


<style type="text/css">
.h{
width:50px;
}


</style>


<html>
  <head>
 
    <title>My JSP 'AllSal.jsp' starting page</title>

	<link rel="stylesheet" type="text/css" href="../css/Form.css" />
    </head>
  
  <body>
  员工工资信息表
  <hr/>
<table class="tab">
  <tr>
	  <!-- <td> &nbsp;薪水号&nbsp;&nbsp;&nbsp;</td> -->
	 <td class="first"> 工号</td>
	 <td class="first"> 姓名</td>
	 <td class="first"> 日期</td>
	 <td class="first"> 薪水</td>
	 <td class="first">奖金</td>
	 <td class="first">税额 </td>
	 <td class="first"> 克扣工资</td>
	  <td class="first">实发工资</td>	
	  <td class="first">&nbsp</td>
	 
 </tr><br/>
 
 <tr>
	 <form  action="UpdateSave">
	<td class="td"> <input class="inp" type="text"  name="id"      class="h" readonly="readonly" value="${sessionScope.MySalList.worker.id}"></td>
	 <td class="td"><input class="inp" type="text"    name="realname"  class="h"     readonly="readonly" value="${sessionScope.MySalList.worker.realname}"> </td>
	 <td class="td"><input class="inp" type="text"    name="saldate" class="h" value="${sessionScope.MySalList.salDate}"> </td>
	 <td class="td"><input class="inp" type="text"    name="salary"  class="h" value="${sessionScope.MySalList.salary}"> </td>
	 <td class="td"><input  class="inp" type="text"    name="bonus"  class="h"  value="${sessionScope.MySalList.bonus}"> </td>
	<td class="td"><input class="inp" type="text"     name="tax"   class="h"   value="${sessionScope.MySalList.tax}"> </td>
	<td class="td"><input class="inp" type="text"     name="attendantsal" class="h" value="${sessionScope.MySalList.attendantsal}"> </td>
	 <td class="td"><input class="inp" type="text"    name="realsal" class="h" value="${sessionScope.MySalList.realsal}"> </td>	
	 	 <td class="td"> <input hidden class="inp" type="text"  name="salid"  class="h" readonly="readonly" value="${sessionScope.MySalList.salId}"></td>
	 
	  <td class="td"><input is="sub" type="submit" name="submit" class="h"    value="保存">  </td>
	  </form> 
 </tr>

</table>
 
  </body>
</html>

