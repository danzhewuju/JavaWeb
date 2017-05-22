<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="Stu_StudentMenuTitle.jsp" flush="true"></jsp:include>
    <%@include file="CSS.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Students</title>
<script type="text/javascript">
function Choose(Sno,Cno,Tno)
{
	window.location.href="ChooseCourses?Sno="+Sno+"&Cno="+Cno+"&Tno="+Tno;
	}
</script>

</head>
<body>
<table class=" table table-striped">
<tr> 
<td>
<div class=" col-sm-offset-1 col-sm-8">
<h3 >You can Choose Course</h3>
</div>
</td>
<td>
<div class=" col-sm-offset-3 col-sm-8">
<h3 >You can Check your Course Schedule</h3>
</div>
</td>
</tr>

<tr> 
<td>

<table class="table table-striped">
<tr><td>Sno</td><td>Name</td><td>Teacher</td><td>ClassRoom</td><td>Time</td><td>Total</td><td>Choose</td></tr>
<c:forEach var="i" begin="0" end="${sessionScope.opcourseslist.count-1 }" step="1">

<tr><td>${sessionScope.opcourseslist.opcourseslist[i].courses.cno} </td>
<td>${sessionScope.opcourseslist.opcourseslist[i].courses.cname }</td>
<td>${sessionScope.opcourseslist.opcourseslist[i].teacher.tname }</td>
<td>${sessionScope.opcourseslist.opcourseslist[i].classroom.rname }</td>
<td>${sessionScope.opcourseslist.opcourseslist[i].courses.ctime}</td>
<td>${sessionScope.opcourseslist.opcourseslist[i].courses.cmax}</td>
<td><button class="btn btn-info" 
onclick="Choose('${sessionScope.student.sno}',
'${sessionScope.opcourseslist.opcourseslist[i].courses.cno}',
'${sessionScope.opcourseslist.opcourseslist[i].teacher.tno}')">Choose</button></td></tr>
</c:forEach>

</table>

</td>
<td>

  <table class="table">
     <tr><td>MON</td><td>TUE</td><td>WED</td><td>THU</td><td>FRI</td></tr>
      <c:forEach var="i" begin="0" end="2" step="1">
      <tr>
      <c:choose>
     <c:when test="${i==0}"><c:set var="day" value="9:00~12:00"></c:set></c:when>
          <c:when test="${i==1}"><c:set var="day" value="13:00~16:00"></c:set></c:when>
               <c:when test="${i==2}"><c:set var="day" value="18:00~21:00"></c:set></c:when>
     </c:choose>
     
      <c:forEach var="j" begin="0" end="4" step="1">
     <c:choose>
     <c:when test="${j==0}"><c:set var="week" value="MON"></c:set></c:when>
      <c:when test="${j==1}"><c:set var="week" value="TUE"></c:set></c:when>
      <c:when test="${j==2}"><c:set var="week" value="WED"></c:set></c:when>
      <c:when test="${j==3}"><c:set var="week" value="THU"></c:set></c:when>
      <c:when test="${j==4}"><c:set var="week" value="FRI"></c:set></c:when>
     </c:choose>
    <c:set var="time" value="${week}-${day}"></c:set>
        <td>  
        <c:forEach var="x" begin="0" end="${sessionScope.studentschedule.count-1 }" step="1">
        <c:if test="${sessionScope.studentschedule.studentschedule[x].courses.ctime==time}">
        <table class="table table-striped">
        <tr>
        <td>${sessionScope.studentschedule.studentschedule[x].courses.cname} </td>
       
        </tr>
        <tr>
        <td> ${sessionScope.studentschedule.studentschedule[x].courses.ctime} </td>
        </tr>
        <tr><td>
         ${sessionScope.studentschedule.studentschedule[x].teacher.tname}
        </td></tr>
         <tr><td>
         ${sessionScope.studentschedule.studentschedule[x].classroom.rname}
        </td></tr>
        </table>
        
        
        </c:if>
        
        </c:forEach>
        </td>
      </c:forEach>
      </tr>
      </c:forEach>
  </table>


</td>
</tr>
</table>


</body>
</html>