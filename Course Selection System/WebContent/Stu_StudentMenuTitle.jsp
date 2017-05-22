<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome you</title>
</head>
<body>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.min.js"></script>


 <ul class="nav nav-tabs nav-justified">

<li role="presentation" > <a href="Stu_CurriculaVariable"> Curricula-Variable</a></li>


<li role="presentation" ><a href="StudentScoreinquiry">Score Inquiry</a> </li>
<li role="presentation" ><a href="StudentEvaluation">Teacher Evaluation</a> </li>
<li role="presentation" ><a href="StudentGetHelp">Getting Help</a> </li>
<li role="presentation"><a href="">${sessionScope.student.sname}(${sessionScope.student.sno }) Student</a></li>
<li role="presentation" ><a href="Login.html">Exit <span class="glyphicon glyphicon-remove" ></span></a>

</li>

  
</ul>
</body>
</html>