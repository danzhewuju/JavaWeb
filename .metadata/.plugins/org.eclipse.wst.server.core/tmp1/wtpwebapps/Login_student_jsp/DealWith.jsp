<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="usst.Student"
    import="usst.Students"
    import="java.util.*"
     %>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息表</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
%>
<%! boolean first=true; 
    Students students;
%>
<jsp:useBean id="student" class="usst.Student" ></jsp:useBean>
<jsp:setProperty property="sname" name="student" />
<jsp:setProperty property="sno" name="student"/>


<c:if test="<%=first %>">
<%
students=new Students();
students.addstudent(student);
application.setAttribute("students", students);
%>
</c:if>
<c:if test="<%=!first %>">
<%
students=(Students)application.getAttribute("students");
students.addstudent(student);
application.setAttribute("students", students);
%>
</c:if>
<%first=false; %>
<jsp:forward page="Show.jsp"></jsp:forward>
</body>
</html>