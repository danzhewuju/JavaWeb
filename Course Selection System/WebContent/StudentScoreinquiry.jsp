<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <jsp:include page="Stu_StudentMenuTitle.jsp" flush="true"></jsp:include>
      <%@include file="CSS.jsp" %>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
<div class="col-sm-offset-4"><h3>YOU CAN INQUIRE YOUR SCORE</h3></div>

<div class="col-sm-offset-3 col-sm-6">

<table class="table table-striped">

<tr><td>CID</td><td>NAME</td><td>TEACHER</td><td>GRADE</td><td>GPA</td></tr>
<c:forEach var="i" begin="0" end="${sessionScope.studentschedule.count-1 }" step="1">
<tr>
<td>${sessionScope.studentschedule.studentschedule[i].courses.cno }</td>
<td>${sessionScope.studentschedule.studentschedule[i].courses.cname }</td>
<td>${sessionScope.studentschedule.studentschedule[i].teacher.tname }</td>
<td>${sessionScope.studentschedule.studentschedule[i].grade }</td>
<td>${sessionScope.studentschedule.studentschedule[i].GPA}</td>
</tr>
<c:set var="totalGPA">
${totalGPA+sessionScope.studentschedule.studentschedule[i].GPA}
</c:set>

</c:forEach>

<tr><td>TOTAL GPA:</td><td></td><td></td><td></td><td><fmt:formatNumber value="${totalGPA/sessionScope.studentschedule.count}" pattern="#,###.##" /></td></tr>
</table>

</div>
</body>
</html>