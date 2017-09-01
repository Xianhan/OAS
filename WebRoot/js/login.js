var xmlhttp;
//得到异步对象
function createXmlHttpRequest(){
	if(window.ActiveXObject){
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}else{
		xmlhttp=new XMLHttpRequest();
	}
}
function sendRequest(message){
	
	//1.调用创建对象的方法
	createXmlHttpRequest();
	//4.监视ajax的工作状态
	xmlhttp.onreadystatechange=stateFun;
	//2.打开异步请求
	xmlhttp.open("post","Login?txt_yzm="+message);
	//3.发送
	xmlhttp.send(null);
}
function stateFun(){
	if(xmlhttp.readyState==4){
		if(xmlhttp.status==200){
			
			var res=document.getElementById('res');
			var str=xmlhttp.responseText;
			
			if(str.trim()!="true"){
				res.innerHTML="<img src=\"images/no.png\">";
				res.style.color="red";
			}else{
				res.innerHTML="<img src=\"images/yes.png\">";
				res.style.color="green";
			}
		}
	}
}
function checkAll(){                     //表单中不可有空项
	var alltxt=document.getElementsByTagName('input');
	for(var i=0;i<alltxt.length;i++){
		if(alltxt[i].value==null||alltxt[i].value.length<=0){
			alert("用户名、密码、验证码均不可为空");
			return false;
		}
	}
}

window.onload=function(){
	var btnlogin=document.getElementById('btnLogin');
	var username=document.getElementById('username');
	var password=document.getElementById('password');
	
	var yzm=document.getElementById('yzm'); 
	img_yzm=document.getElementById('img_yzm'); 
	txt_yzm=document.getElementById('txt_yzm');
	
	yzm.onclick=function(){
		img_yzm.src="login/image.jsp?un="+Math.random();
	}
	
	txt_yzm.onkeyup=function(){
		if(this.value.length==4){
			
			sendRequest(this.value);
		}
	}
	
}