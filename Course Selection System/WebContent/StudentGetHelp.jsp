<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="Stu_StudentMenuTitle.jsp" flush="true"></jsp:include>
      <%@include file="CSS.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get Help</title>
</head>
<body>
<div class="col-sm-offset-3"><h2>YOU CAN SEND MESSAGE TO TEACHER</h2></div>
<form action="StudentGetHelp"  class="form-horizontal" method="post">
<div class="form-group">
<label class="col-sm-4 control-label ">Teacher</label>
<div class="col-sm-4">
<select name="CTname" class="form-control">
<c:forEach var="i" begin="0" end="${sessionScope.studentschedule.count-1 }" step="1">
<option>${sessionScope.studentschedule.studentschedule[i].courses.cname}:${sessionScope.studentschedule.studentschedule[i].teacher.tname}</option>
</c:forEach>
</select>
</div>
</div>
<div class="form-group">
<label class="col-sm-4 control-label">message</label>
<div class="col-sm-4"><textarea rows="8" cols="1" class="form-control" name="message" placeholder="you can inqure your bewilderment"></textarea></div>


</div>

<div class="col-sm-offset-5">
<div class="col-sm-2">
<input type="reset" class="btn btn-warning" value="Reset">

</div>
<div class="  col-sm-2">
<input type="submit" class="btn btn-success" value="Send">

</div>


</div>

</form>
</body>
</html>