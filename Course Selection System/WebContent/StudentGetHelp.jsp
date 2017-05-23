<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="Stu_StudentMenuTitle.jsp" flush="true"></jsp:include>
      <%@include file="CSS.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get Help</title>
<script type="text/javascript">
function Sure(){
	window.location.href="StudentCheckedMessage";
}
</script>
</head>
<body>
<div class="col-sm-offset-3"><h2>YOU CAN SEND MESSAGE TO TEACHER</h2></div>
<table class="table table-striped">
<tr>
<td>
<c:if test="${sessionScope.messagelist.count==0}">
<div class="col-sm-offset-2 col-sm-7">
<form action="StudentGetHelp"  class="form-horizontal" method="post">
<div class="form-group">
<label class="col-sm-4 control-label ">Teacher</label>
<div class="col-sm-8">
<select name="CTname" class="form-control">
<c:forEach var="i" begin="0" end="${sessionScope.studentschedule.count-1 }" step="1">
<option>${sessionScope.studentschedule.studentschedule[i].courses.cname}:${sessionScope.studentschedule.studentschedule[i].teacher.tname}</option>
</c:forEach>
</select>
</div>
</div>
<div class="form-group">
<label class="col-sm-4 control-label">message</label>
<div class="col-sm-8"><textarea rows="8" cols="1" class="form-control" name="message" placeholder="you can inqure your bewilderment"></textarea></div>


</div>

<div class="col-sm-offset-5">
<div class="col-sm-6">
<input type="reset" class="btn btn-warning" value="Reset">

</div>
<div class="  col-sm-6">
<input type="submit" class="btn btn-success" value="Send">

</div>


</div>

</form>
</div>
</c:if>
<c:if test="${sessionScope.messagelist.count!=0}">
<div class=" col-sm-12">
<form action="StudentGetHelp"  class="form-horizontal" method="post">
<div class="form-group">
<label class="col-sm-4 control-label ">Teacher</label>
<div class="col-sm-8">
<select name="CTname" class="form-control">
<c:forEach var="i" begin="0" end="${sessionScope.studentschedule.count-1 }" step="1">
<option>${sessionScope.studentschedule.studentschedule[i].courses.cname}:${sessionScope.studentschedule.studentschedule[i].teacher.tname}</option>
</c:forEach>
</select>
</div>
</div>
<div class="form-group">
<label class="col-sm-4 control-label">message</label>
<div class="col-sm-8"><textarea rows="8" cols="1" class="form-control" name="message" placeholder="you can inqure your bewilderment"></textarea></div>


</div>

<div class="col-sm-offset-5">
<div class="col-sm-6">
<input type="reset" class="btn btn-warning" value="Reset">

</div>
<div class="  col-sm-6">
<input type="submit" class="btn btn-success" value="Send">

</div>


</div>

</form>
</div>

</c:if>

</td>
<td>
<div class="col-sm-10">


<c:if test="${sessionScope.messagelist.count!=0}">
<table class="table table-striped">
<tr><td>TeacherID</td><td>TeacherName</td><td>Question</td><td>Answer</td></tr>
<c:forEach var="i" begin="0" end="${sessionScope.messagelist.count }" step="1">
<c:if test="${i!=sessionScope.messagelist.count }">
<tr>

<td>${sessionScope.messagelist.messagelist[i].teacher.tno }</td>
<td>${sessionScope.messagelist.messagelist[i].teacher.tname }</td>
<td>${sessionScope.messagelist.messagelist[i].msn}</td>
<td>${sessionScope.messagelist.messagelist[i].backmsn}</td>
</tr>


</c:if>


</c:forEach>
</table>
<div class="col-sm-offset-4"><button class="btn btn-success btn-lg" onclick="Sure()">Sure</button></div>
</c:if>





</div>



</td>
</tr>
</table>

</body>
</html>