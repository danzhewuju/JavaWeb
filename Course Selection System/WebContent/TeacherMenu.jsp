<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="TeacherMenuTitle.jsp" flush="true"></jsp:include>
    <%@include file="CSS.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome you Teacher</title>
</head>
<body>
<div class="jumbotron">
  <h1>Welcome, you ${sessionScope.teacher.tname}!</h1>
  <p>You can do something</p>
  <ul>
  <li> <h3>Score Registration</h3></li>
   <li><h3>Check Mark</h3></li>
    <li><h3>Answer Student</h3></li>

  </ul>
  <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
</div>
</body>
</html>