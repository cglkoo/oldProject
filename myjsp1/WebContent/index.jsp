<%@ page language="java" import="com.hzit.employees.*,com.store.notice.*,java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
 <link rel='stylesheet' type='text/css' href='./myCss/index.css'>
<script type="text/javascript" src="myjs/jquery-3.2.1.min.js" ></script>
<script type="text/javascript">
function lunbo(imgs) {
	document.getElementById("aimg").src = "imgs/" + imgs + ".jpg";  //img/1.jpg
	document.getElementById("aimg").name = 0;   //一个重要的标志：鼠标移上来的时候；
	changeBGcolor(imgs);
}
function start() {
	var b = document.getElementById("aimg").name;
	if (b == 1) {     					//鼠标移开的时候，自由轮播；
		document.getElementById("aimg").src = "imgs/1.jpg";
		document.getElementById("aimg").name = 2;
		
	} else if (b == 2) {
		document.getElementById("aimg").src = "imgs/2.jpg";
		document.getElementById("aimg").name = 1;
	} 
	changeBGcolor(b);
}

function changeBGcolor(n){
	if(n==1){
		document.getElementById('d1').style.backgroundColor = 'white';
		document.getElementById('d2').style.backgroundColor = '#666';
	}else if(n==2){
		document.getElementById('d2').style.backgroundColor = 'white';
		document.getElementById('d1').style.backgroundColor = '#666';
	}
}
function time() {
	var run = setInterval("start()", 3000);   //一秒调用一次，轮播一次图片；
}
function r(imgs) {
	document.getElementById("aimg").name = imgs;
	document.getElementById(imgs).style.backgroundColor = 'white';
}
//购物结算部分
$(function($){
    //商品变色
    $("#myTableProduct").find("tr").mouseover(function(){
        $(this).css("backgroundColor","#fff");
    }).mouseout(function(){
        if($("#myTableProduct").find("tr").index($(this))%2==1) {//判断是否奇数行
            $(this).css("backgroundColor","#F7FCFF");
        }
    });
    //计算总价
    function totalPrice(){
        var percents= 0,prePrices= 0,prices=0;//积分，原价，现价
        $("#myTableProduct").find("tr").each(function(i,ele){
            var num=$(ele).find(".shopping_product_list_5").find("input").val();//数量
            percents+=parseInt($(ele).find(".shopping_product_list_2").text())*num;
            //解决下js中浮点数的bug问题，因此建议浮点数的运算不要放在前台，这里是指粗略的解决了一下
            var price=parseInt($(ele).find(".shopping_product_list_4").find("label").text().replace(".",""))*num;
            prices+=price;
            var prePrice=parseInt($(ele).find(".shopping_product_list_3").find("label").text().replace(".",""))*num;
            prePrices+=prePrice;
        });
        $("#product_integral").text(percents);
        $("#product_total").text(prices/100);
        $("#product_save").text((prePrices-prices)/100);
        return prices/100;
    }
    totalPrice();
    //删除商品
    $("#myTableProduct").find(".shopping_product_list_6").children("a").click(function(){
        if(confirm("您确定要删除商品么？")){
            $(this).parent().parent().remove();
            totalPrice();
        }
    });
    //修改数量
    $("#myTableProduct").find(".shopping_product_list_5").children("input").change(function(){
        var value=$(this).val();
        if((value == "")||!(/^[0-9]*[1-9][0-9]*$/.test(value))){
            alert("数量不能为空，且只能为正整数");
            $(this).val(1);
        }
        var t =totalPrice();
        alert("修改成功！，您的商品总金额是"+t+"元")
    });
    //清空购物车
    $("#removeAllProduct").click(function(){
        //注意清除的先后顺序
        $("#myTableProduct").next().remove();
        $("#myTableProduct").remove();
        $(".shopping_list_border").append("<div class='empty_product'><div>您还没有挑选商品，<a href='index.html'>去挑选看看>></a></div></div>");

    });
})
</script>
<style type="text/css">
.top{
    width:100%;
    height:55px;
    background-color: #009B72;
    text-indent:2em;
    color:white;
    font-size: 30px;
    font-weight: bold;
    line-height: 50px;
}
.span1{
	margin-left:60px;
	font-size:18px;
}
.span2{
    font-size:18px;
	float: right;
	margin-top: 2px;
}
a{
	text-decoration: none;
	color:white;
}
h3{
	color: #009B72;
}
</style>
</head>
<body onload="time()">
    <%
	request.setCharacterEncoding("UTF-8");
	String user =request.getParameter("username");
	String pwd =request.getParameter("pwd");
	String sex =request.getParameter("sex");
	String mobile =request.getParameter("mobile");
	String borthday =request.getParameter("borthday");
	String entry = request.getParameter("entry");
	IEmployees iep = new EmployeesImpl();
	String sql ="insert into t_employees (userName,userPwd,sex,mobile,borth,entry) values(?,?,?,?,?,?)";
	if(user!=null && pwd!=null && sex!=null && mobile!=null && borthday!=null && entry!=null){
		int num =iep.addOrUpdateOrDelete(sql, user.trim(),pwd.trim(),sex.trim(),mobile.trim(),borthday.trim(),entry.trim());
		if(num>0){
			%>
			<script type="text/javascript">
			     alert("注册成功！");
			</script>
			<%
		}
	}
	
%>
<div class="top"><span class="logo">OPPO&nbsp;&nbsp;商&nbsp;店</span><span class="span1"><a href="index.jsp">首&nbsp;&nbsp;页</a></span>
				<span class="span2"><a href="login.jsp">登&nbsp;录</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="reg.html">注&nbsp;册</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></div>
<div align="center">
    <form name="aform">
		<table style="text-align: center">
			<tr><td><img id="aimg" src="imgs/1.jpg" name="1" /></td></tr>
			<tr><td><input id="d1" value="" onMouseMove="lunbo(1)" onmouseout="r(1)"><input id="d2" value="" onMouseMove="lunbo(1)" onmouseout="r(1)"></td></tr>
		</table>
	</form>
</div>
<div>
	<div style="float: left;text-align: center;width:300px;">
	<h3>公&nbsp;告&nbsp;列&nbsp;表</h3>
	<%
	List<Notice> listNotice = new ArrayList<>();
	INoticeService ins = new NoticeServiceImpl();
	String sql2 ="select nId,nName,nDate from tb_notice order by nId desc";
	listNotice = ins.getNoticesByProperty(sql);
	if(listNotice.size()>0){
		for(int i =0;i<listNotice.size();i++){
			Notice p = listNotice.get(i);
			String name=p.getnName();
			if(name.length()>5){
				name=name.substring(0,5);
			} 
		%>
		<div><a href="detail.jsp?nId=<%=p.getnId() %>">(<%=(i+1) %>)<%=name %> [<%=p.getnDate()%>]</a></div>
		<%
	}
	}
	%>
	</div>
	<div style="float: right;text-align: center;width:200px;">
	<h3>排&nbsp;行&nbsp;榜</h3>
	</div>

</div>
</body>
</html>
