<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="usst.Goods"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function sure(){
	var temp=confirm("确定删除？");
	var ID=document.getElementById("yuhao").value;
	if(temp)
		{
		window.location.href="delete?delete="+ID;
		}
}
</script>
<style type="text/css">
.btn{
    width:200px;
    height:50px;
    background:red;
    color:yellow;
   fone-size=30;
}
.btn1{
width:50px;
height:30px;
background:red;
color:yellow;
}
.image{
width:128px;
height:128px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎你管理员</title>
</head>
<body>

<center>
<table>
<%!ArrayList<Goods> goods=null;
boolean first=true;
ArrayList<Goods> firstset(){
	goods=new ArrayList<Goods>();
	Goods g1=new Goods();
	g1.setName("小米手机5");
	g1.setPrice((float)1799.00);
	g1.setImage("image/小米5(1799).png");
	goods.add(g1);
	Goods g2=new Goods();
	g2.setName("小米note4");
	g2.setPrice(999);
	g2.setImage("image/小米note4(999).png");
	goods.add(g2);
	Goods g3=new Goods();
	g3.setName("红米4x");
	g3.setPrice(200);
	g3.setImage("image/hongmi4x.png");
	goods.add(g3);
	Goods g4=new Goods();
	g4.setName("小米手机5s");
	g4.setPrice(1999);
	g4.setImage("image/小米手机5s(1999).png");
	goods.add(g4);
	Goods g5=new Goods();
	g5.setName("荣耀6plus");
	g5.setPrice(1399);
	g5.setImage("image/荣耀6pluse.jpg");
	goods.add(g5);
return goods;
}

%>
<% 
if(first)
{
	first=false;
	application.setAttribute("goods", firstset());
}
goods=(ArrayList<Goods>)application.getAttribute("goods");

for(int i=0,count=0;i<goods.size()/4+1;i++)
{
	out.println("<tr>");

	for(int j=0;j<4&&count<goods.size();j++)
	{
		out.println("<td><img  src="+"\""+goods.get(count).getImage()+"\""+"class=image alt=图片不存在   >"+
		"<p>"+goods.get(count).getName()+"<p>单价:"+goods.get(count).getPrice()+"元 <p> <input type=button class=btn1   value=删除   onclick=sure()>"+
		"<input type=hidden id=yuhao  value="+count+" >"+
"</td>");
	count++;
	}
	out.println("</tr>");
	
}


%>
</table>
<p><a href="Additem.jsp"><input type="button" class="btn" value="添加商品"></a>
<p><a href="Login.jsp"><input type="button" class="btn" value="返回"></a>
</center>
</body>
</html>