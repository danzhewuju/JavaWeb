<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <jsp:include page="TeacherMenuTitle.jsp" flush="true"></jsp:include>
    <%@include file="CSS.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ScoreReistration</title>
<script type="text/javascript">
function Send(Sno,Cno,i){
	var grade=document.getElementById(i).value;
	window.location.href="TeacherUpdateScore?Sno="+Sno+"&Cno="+Cno+"&Grade="+grade;
}


</script>
</head>
<body>
<div class="col-sm-offset-4">
<h2>YOU CAN INPUT GRADE</h2>
</div>

<div class="col-sm-offset-2 col-sm-8">
<table class="table table-striped">
<tr><td>StudentID</td><td>StudentName</td><td>CourseID</td><td>CourseName</td><td>Grade</td><td>Handle</td></tr>
<c:forEach var="i" begin="0" end="${sessionScope.teacherupdate.count }" step="1">
<c:if test="${sessionScope.teacherupdate.count!=i }">
<tr>
<td>${sessionScope.teacherupdate.studentcourses[i].student.sno }</td>
<td>${sessionScope.teacherupdate.studentcourses[i].student.sname }</td>
<td>${sessionScope.teacherupdate.studentcourses[i].courses.cno}</td>
<td>${sessionScope.teacherupdate.studentcourses[i].courses.cname}</td>
<td>
<input type="text" id="${i}" class="form-control" placeholder="Grade" >
</td>
<td><button class="btn btn-success" onclick="Send('${sessionScope.teacherupdate.studentcourses[i].student.sno }',
'${sessionScope.teacherupdate.studentcourses[i].courses.cno}',
'${i}')">Sure</button></td>




</tr>



</c:if>


</c:forEach>

</table>

</div>



</body>
</html>