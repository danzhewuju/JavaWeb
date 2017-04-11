<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="usst.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑学生信息</title>
</head>
<body>
<center>
<%
int ID=Integer.valueOf(request.getParameter("index"));
request.getSession().setAttribute("ID", ID);
%>
<form action="BackEdit.jsp" method="post">
<p>学号：<input type="text" name="sno" value="${applicationScope.students.students[param.index].sno}">
<p>姓名：<input type="text" name="sname" value="${applicationScope.students.students[param.index].sname}" >
<p><input type="submit" value="确认"  ><input type="reset" value="取消">
</form>
</center>
</body>
</html>