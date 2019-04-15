<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>默认登录成功的页面</title>
<script type="text/javascript" src="myjs/jquery-3.2.1.min.js" ></script>
<script type="text/javascript">


function lunbo(imgs) {
	document.getElementById("aimg").src = "imgs/" + imgs + ".jpg";  //img/1.jpg
	document.getElementById("aimg").name = 0;   //一个重要的标志：鼠标移上来的时候；
	changeBGcolor(imgs);
}

function start() {

	var b = document.getElementById("aimg").name;

	if (b == 3) {     					//鼠标移开的时候，自由轮播；
		document.getElementById("aimg").src = "imgs/3.jpg";
		document.getElementById("aimg").name = 4;
	} else if (b == 4) {
		document.getElementById("aimg").src = "imgs/4.jpg";
		document.getElementById("aimg").name = 5;
	}  else if (b == 5) {
		document.getElementById("aimg").src = "imgs/5.jpg";
		document.getElementById("aimg").name = 3;
	} 
	changeBGcolor(b);
}

function changeBGcolor(n){
	if(n==3){
		document.getElementById('d3').style.backgroundColor = 'white';
		document.getElementById('d2').style.backgroundColor = 'white';
		document.getElementById('d1').style.backgroundColor = '#666';
	}else if(n==4){
		document.getElementById('d3').style.backgroundColor = 'white';
		document.getElementById('d1').style.backgroundColor = 'white';
		document.getElementById('d2').style.backgroundColor = '#666';
	}else if(n==5){
		document.getElementById('d1').style.backgroundColor = 'white';
		document.getElementById('d2').style.backgroundColor = 'white';
		document.getElementById('d3').style.backgroundColor = '#666';
	}
	
}
function time() {

	var run = setInterval("start()", 2000);   //一秒调用一次，轮播一次图片；

}
function r(imgs) {

	document.getElementById("aimg").name = imgs;
	
	document.getElementById(imgs).style.backgroundColor = 'white';

}
</script>
<style type="text/css">
#aimg{
    width:100%;
    height:500px;
}
#d1{
    width:12px;
    height:12px;
    border-radius:50%;
    border:2px solid #2AAD6F;
    background-color: white; 
}
#d1:hover{
    cursor: pointer;
}
#d2{
    width:12px;
    height:12px;
    border-radius:50%;
    border:2px solid #2AAD6F;
    background-color: white; 
    margin-left:20px;
}
#d2:hover{
    cursor: pointer;
}
#d3{
    width:12px;
    height:12px;
    border-radius:50%;
    border:2px solid #2AAD6F;
    background-color: white; 
    margin-left:20px;
}
#d3:hover{
    cursor: pointer;
}
</style>
</head>
<body onload="time()">


<div>
    <form name="aform">
		<table align="center">
			<tr>
				<td><img id="aimg" src="imgs/3.jpg" name="3" /></td>
			</tr>
		</table>
		<table align="center">
			<tr>
			    <td><div id="d1"  value="3" onMouseMove="lunbo(1)" onmouseout="r(1)"></div></td>
			    <td><div id="d2"  value="4" onMouseMove="lunbo(2)" onmouseout="r(2)"></div></td>
			    <td><div id="d3"  value="5" onMouseMove="lunbo(3)" onmouseout="r(3)"></div></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>