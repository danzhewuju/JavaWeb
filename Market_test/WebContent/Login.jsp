<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.image{
width:128px;
height:128px;
}
.btn{
    width:60px;
    height:30px;
    background:red;
    color:yellow;
   fone-size=30;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
</head>
<body>
<%@ include file="Head.jsp" %>
<center>
<form action="Buy.jsp"method="post">
<p>用户:<input type="text" name="username">
<p>密码:<input type="password" name="password">
<p><input type="submit" value="确认" class="btn">
		<element>&nbsp&nbsp&nbsp&nbsp</element>
	<input type="reset" value="取消" class="btn">
</form>
<p><a href="manager.jsp">进入管理员界面</a>
</center>

</body>
</html>