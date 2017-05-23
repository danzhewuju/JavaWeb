<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="TeacherMenuTitle.jsp" flush="true"></jsp:include>
      <%@include file="CSS.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Check Comment</title>
</head>
<body>
<div class="col-sm-offset-3">
<h2>YOU CAN CHECK STUDENT'S COMMENT</h2>
</div>
<div class="col-sm-offset-2 col-sm-8">
<table class="table table-striped">
<tr><td>StudentID</td><td>Student'sName</td><td>Course'sID</td><td>Course'sName</td><td>Comment</td><td>Score</td></tr>
<c:forEach var="i" begin="0" end="${sessionScope.evaluationList.count }" step="1">
<c:if test="${i!= sessionScope.evaluationList.count}">
<tr>
<td>${sessionScope.evaluationList.evaluationlist[i].student.sno }</td>
<td>${sessionScope.evaluationList.evaluationlist[i].student.sname }</td>
<td>${sessionScope.evaluationList.evaluationlist[i].courses.cno }</td>
<td>${sessionScope.evaluationList.evaluationlist[i].courses.cname }</td>
<td>${sessionScope.evaluationList.evaluationlist[i].eva }</td>
<td>${sessionScope.evaluationList.evaluationlist[i].score}</td>
</tr>



</c:if>
</c:forEach>

</table>


</div>

</body>
</html>