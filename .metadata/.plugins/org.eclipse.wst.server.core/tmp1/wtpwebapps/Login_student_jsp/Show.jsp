<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="usst.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

.btn{
    width:100px;
    height:50px;
    background:red;
    color:yellow;
    fone-size=30;

}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息处</title>
</head>
<body>
<%!Students students; %>
<%
request.setCharacterEncoding("UTF-8");
students=(Students)application.getAttribute("students");
%>
<center>
<table border=1>
<caption>学生信息表</caption>
<c:forEach var="i" begin="0" end="${students.sum-1}" step="1" >
<tr>
<td>序号</td><td>姓名</td><td>学号</td><td>操作</td><td>操作</td>
</tr>
<tr>  
<td>${i+1}</td>
<td>${students.students[i].sname } </td>
<td>${students.students[i].sno }</td>
<td><a href="Edit.jsp?index=${i}">编辑</a></td>
<td><a href="Del.jsp?index=${i}">删除</a></td>
</tr>
</c:forEach>
</table>
<p><a href="Login.jsp"><input type="button" value="登记学生" class="btn"></a>
</center>
</body>
</html>