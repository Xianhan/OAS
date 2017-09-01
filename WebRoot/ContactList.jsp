<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" com.neuq.entities.Worker" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>通讯录</title>
	

	<script type="text/javascript" src="js/ContactList.js">
	</script>
	<script type="text/javascript">
	window.onload=function(){
	var sub=document.getElementById('sub');
	var sc=document.getElementById('sc');
	sub.onclick=function(){
	//alert(sc.value);
	sendRequest(sc.value);
	}
	
	}
	
	</script>
	
	
	<link href="css/Table23.css" rel="stylesheet"/>
	
  </head>
  
  <body>
  <div id="box">
  <div id="input">
    通讯录:<input class="input" type="text"  name="sc" id="sc" placeholder="请输入姓名">
       &nbsp &nbsp
       <input class="input" type="submit" value="查询" id="sub"><br>
       <div id="select"  >
	 
	 </div>
	 </div>
     <br>
     <br>
     
     <div id="pos">
       
     <div id="scroll">
     <table class="tab">
     <tr>
	  <td class="first">ID</td>
	  <td class="first"> RealName</td>
	  <td class="first"> Email</td>
	  <td class="first"> Phone</td>
	  </tr>
	  
	 <c:forEach items="${sessionScope.ContactList}" var="ct">
	 <tr>
	  <td class="td"> ${ct.id }</td>
	  <td class="td"> ${ct.realname }</td>
	  <td class="td"> <a href="mailto:"+"${ct.email}">${ct.email}</a></td>
	  <td class="td"> ${ct.phone}</td>
	  </tr>
	 </c:forEach>
	
	 </table>
	  </div>
     <br><br>
	 
	 </div>
	 </div>
  </body>
</html>
