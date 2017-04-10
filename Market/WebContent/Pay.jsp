<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" 
    import="usst.Goods"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function pay(){
	var temp=confirm("是否完成支付？");
	if(temp){
		alert("你已经完成了支付！");
		window.location.href="Finished";
		
	}
	else
		{
		alert("你已经取消了支付！");
		}
}
</script>
<style type="text/css">
.image{
width:128px;
height:128px;
}
.btn{
    width:100px;
    height:30px;
    background:red;
    color:yellow;
   fone-size=30;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>付款页面</title>
</head>
<body>
<center>

<%! 
ArrayList<Integer> Car=null;
ArrayList<Goods>goods=null;
float sum=0;

%>
<p>你已经加入了以下商品
<%
Car=(ArrayList<Integer>)request.getSession().getAttribute("Car");

if(Car!=null&&Car.size()!=0)
{out.println("<table>");
	goods=(ArrayList<Goods>)application.getAttribute("goods");
	for(int i=0;i<Car.size();i++)
	{
		sum+=goods.get(Car.get(i)).getPrice();
	}
	for(int i=0;i<Car.size();i++)
	{
		out.println("<tr>");
		int toal=Car.size();
		if(toal>4) toal=4; 
		for(int j=0;j<toal;j++,i++)
		{
			out.println("<td><img src="+ "\""+goods.get(Car.get(i)).getImage()+"\""+"class=image alt=图片不存在>"
			+"<p>单价:"+goods.get(Car.get(i)).getPrice()+"元 "
			+"</td>");
			
		}
		out.println("</tr>");
	}
	out.println("</table>");
	out.println("<p>总共消费："+sum+"元  \n <input type=button value=确认支付  onclick=pay()  class=btn");
	sum=0;
}
else
{
	out.println("<script>"+
	"alert(\"购物车为空\");window.location.href=\"Buy.jsp\""
	+"</script>");
}
%>

</center>
</body>
</html>