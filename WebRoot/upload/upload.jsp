<%@ page language="java" import="java.util.*" 
pageEncoding="gbk"%>
<html>
<head>
<script type="text/javascript">
window.onload=function()
{
  var btn=document.getElementById("btn");
  var panl=document.getElementById("panl");
 
  btn.onclick=function()
  {
    
    var fs=document.getElementsByClassName("file");
    panl.innerHTML+="<input class='file' type='file' name='f"+(fs.length+1)+"'><br/>";
  }
}
</script>
<link href="../css/Form.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="box">
<div id="pos" align="center">
<form action="../Upload" method="post" enctype="multipart/form-data">
<table class="tab">
<div id="panl"> 
<input class="file" type="file" name="f1"><br/>
</div>
<span style="width: 100px;height: 100px;background-color: red" id="btn">&nbsp;+&nbsp;</span><br/>
</table>
<input id="sub" type="submit" value="È·¶¨">
</form>
</div>
</div>
</body>
</html>