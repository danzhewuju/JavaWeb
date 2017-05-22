<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="Stu_StudentMenuTitle.jsp" flush="true"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WelCome you</title>
</head>
<body>
<div class="jumbotron">
  <h1>Welcome, you ${sessionScope.student.sname}!</h1>
  <p>You can do something</p>
  <ul>
  <li> <h3>Curricula-Variable</h3></li>
   <li><h3>Score Inquiry</h3></li>
    <li><h3>Teacher Evaluation</h3></li>
     <li> <h3>Getting Help</h3></li>
  </ul>
  <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
</div>
</body>
</html>