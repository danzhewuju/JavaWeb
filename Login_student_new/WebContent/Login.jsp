<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎进入登入学生管理系统</title>
</head>
<body>
<center>
<form action="check.jsp" method="post">
<p>用户名:<input type="text" name="username" >
<p>密码：<input type="password" name="code">
<p><input type="submit" value="登录"> &nbsp<input type="reset" value="取消">
</form>
</center>
</body>
</html>