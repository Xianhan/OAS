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
	//alert(encodeURI(message));
	//1.调用创建对象的方法
	createXmlHttpRequest();
	//4.监视ajax的工作状态
	xmlhttp.onreadystatechange=stateFun;
	//2.打开异步请求
	
	xmlhttp.open("post","SelectContactListAction?realname="+encodeURI(message));
	//3.发送
	xmlhttp.send(null);
	
}
function stateFun(){
	
	if(xmlhttp.readyState==4){
		
		if(xmlhttp.status==200){
			//alert(xmlhttp.status);
			var str=xmlhttp.responseText;
			var select=document.getElementById('select');
			
			select.innerHTML=str+"<br><br>";
		}
	}
}
