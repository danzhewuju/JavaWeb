<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="usst.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
Students students;
%>
<%
request.setCharacterEncoding("UTF-8");
students=(Students)application.getAttribute("students");
String sno,sname;
sno=request.getParameter("sno");
sname=request.getParameter("sname");
int ID=Integer.valueOf(request.getSession().getAttribute("ID").toString()) ;
students.getStudents().get(ID).setSname(sname);
students.getStudents().get(ID).setSno(sno);
pageContext.forward("Show.jsp");
%>

</body>
</html>