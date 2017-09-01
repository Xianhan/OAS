//判断公告输入框字数js	
function checkContent(con) {
	if (con.length < 1 || con.length > 100) {
		alert("内容应在50字内");
	}
}
window.onload = function() {
	document.getElementById('content').onblur = function() {
		var con = document.getElementById('content').value; //内容
		checkContent(con);
	}
}