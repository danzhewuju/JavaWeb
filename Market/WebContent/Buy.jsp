<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="usst.Goods"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.btn{
    width:200px;
    height:50px;
    background:red;
    color:yellow;
   fone-size=30;
}
.image{
width:128px;
height:128px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎进行选购</title>
</head>
<body>
<%! ArrayList<Goods> goods=null; 

%>
<%
	goods=(ArrayList<Goods>)application.getAttribute("goods");

%>
<center>

<table>
<% 
for(int i=0,count=0;i<goods.size()/4+1;i++)
{
	out.println("<tr>");
	for(int j=0;j<4&&count<goods.size();j++)
	{
		out.println("<td><img src="+"\""+goods.get(count).getImage()+"\""+"class=image alt=图片不存在   >"+
		"<p>"+goods.get(count).getName()+"<p>单价:"+goods.get(count).getPrice()+"元 <a href=PutCarMarket?indox="+count+"><p><input type=\"button\" style=\"background:red;color:yellow\"value=加入购物车 ></a>"+
		"</td>");
		count++;
	}
	out.println("</tr>");
}

%>
</table>
<p><a href="Pay.jsp"><input type="button" class="btn"  value="去购物车结算"></a>
<p><a href="Login.jsp"><input type="button" class="btn" value="退出"></a>
</center> 
</body>
</html>