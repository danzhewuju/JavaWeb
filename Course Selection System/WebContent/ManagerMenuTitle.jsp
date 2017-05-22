<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcom you Manager</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.min.js"></script>
  
  <ul class="nav nav-tabs nav-justified">

<li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      Students <span class="caret"></span>
    </a>
    <ul class="dropdown-menu">
    <li><a href="AddStudents.jsp">AddStudents</a></li>
    <li><a href="DelStudentsTitle.jsp">DelStudents</a></li>
        <li><a href="EditStudentsTitle.jsp">EditStudents</a></li>
   </ul>
  </li>

<li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      Teachers <span class="caret"></span>
    </a>
    <ul class="dropdown-menu">
    <li><a href="AddTeachers.jsp">AddTeachers</a></li>
    <li><a href="DelTeachersTitle.jsp">DelTeachers</a></li>
        <li><a href="EditTeachersTitle.jsp">EditTeachers</a></li>
   </ul>
  </li>
<li role="presentation" class="dropdown"><a href="StartCourses">Courses</a> </li>
<li role="presentation" class="dropdown"><a href="StartClassRoom">ClassRoom</a> </li>
<li role="presentation" ><a href="Login.html">Exit <span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
 
</li>

  
</ul>



</body>
</html>