<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="usst.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!int ID;
Students students;
%>
<%
ID=Integer.valueOf(request.getParameter("index"));
students=(Students)application.getAttribute("students");
students.delstudent(ID);
application.setAttribute("students", students);
%>
<jsp:forward page="Show.jsp"></jsp:forward>
</body>
</html>