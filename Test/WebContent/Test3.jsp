<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="usst.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%! Students students;%>
<c:forEach var="x" begin="1" end="9" step="1">
<c:forEach var="y" begin="1" end="${x }" step="1">
${y}*${x}=${x*y}
</c:forEach>
<br>
</c:forEach>
<c:set var="poems" 
value="白日依山尽，黄河入海流，去穷千里目，更上一层楼"
></c:set>
<center>
<h4>登黄鹤楼 王之涣</h4>
<c:forTokens var="line" items="${poems }" delims="，">
${line }
</c:forTokens>
</center>
<!--<jsp:useBean id="students" class="usst.Students" scope="session"></jsp:useBean>-->
<%
students=new Students(); 
students.setSum(1000);
%>
<p>${students.sum}

</body>
</html>