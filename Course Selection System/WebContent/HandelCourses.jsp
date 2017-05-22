<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="ManagerMenuTitle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Handel Courses</title>

<style type="text/css">
.top{
margin-bottom:10px;
}
</style>

<script type="text/javascript">
function DelCourse(key)
{
	window.location.href="DelCourse?Cno="+key;
	
	}
function EditCourse(key)
{
	var Rname,Cname,Ctime;
	Cname=document.getElementById("Cname"+key).value;
	Rname=document.getElementById("Rname"+key).value;
	Ctime=document.getElementById("Ctime"+key).value;
	window.location.href="EditCourse?Cname="+Cname+"&Rname="+Rname+"&Ctime="+Ctime+"&Cno="+key;
	}

</script>
</head>
<body>

<table class="table table-striped">
<tr>
<td>
<div class="col-sm-12">
<div class="col-sm-offset-4">
<h1> Add Course</h1>
</div>

<div class="col-sm-offset-3">
<h1><small>you should input some infomation</small></h1>
</div>

<form class="form-horizontal" action="AddCourses" method="post">
<div class="form-group">
<label class="col-sm-3 control-label">Name</label>
<div class="col-sm-8">
<input type="text" name="Cname" class="form-control" placeholder="Please Input Course's Name">
</div>
</div>
<div class="form-group">
<label class="col-sm-3 control-label">Time</label>
<div class="col-sm-8">
<select class="form-control" name="Ctime">
<option>MON-9:00~12:00</option>
<option>MON-13:00~16:00</option>
<option>MON-18:00~21:00</option>

<option>TUE-9:00~12:00</option>
<option>TUE-13:00~16:00</option>
<option>TUE-18:00~21:00</option>

<option>WED-9:00~12:00</option>
<option>WED-13:00~16:00</option>
<option>WED-18:00~21:00</option>

<option>THU-9:00~12:00</option>
<option>THU-13:00~16:00</option>
<option>THU-18:00~21:00</option>

<option>FRI-9:00~12:00</option>
<option>FRI-13:00~16:00</option>
<option>FRI-18:00~21:00</option>
</select>

</div>
</div>
<div class="form-group">
<label class="col-sm-3 control-label">ClassRoom</label>
<div class="col-sm-8">
<select class="form-control" name="Rno">
<c:forEach var="i" begin="0" end="${sessionScope.classroomlist.count-1}" step="1">
<option>${sessionScope.classroomlist.roomlist[i].rname} </option>
</c:forEach>
</select>
</div>
</div>

<div class="form-group">
<label class="col-sm-3 control-label">Teacher</label>
<div class="col-sm-8">
<select class="form-control" name="Tno">
<c:forEach var="i" begin="0" end="${sessionScope.classroomlist.count-1}" step="1">
<option>${sessionScope.teacherlist.teacherlist[i].tname} </option>
</c:forEach>
</select>
</div>
</div>


<div class="form-group">
<div class="col-sm-offset-4 col-sm-2">
<input type="reset" value="Reset" class="btn btn-warning">
</div>


<div class=" col-sm-offset-1 col-sm-2">
<input type="submit" value="Sure" class="btn btn-success">
</div>
</div>
</form>
</div>
</td>
<td>
<div class="col-sm-12" >
<div class="col-sm-offset-1"><h1> you can handle these infomation</h1></div>

<table class="table table-striped">
<tr><td>ID</td><td> <label class=" col-sm-offset-4">Name</label> </td><td> <label class=" col-sm-offset-4">Time</label></td><td>ClassRoom</td><td>Max</td><td>Delete</td><td>Edit</td></tr>
<c:forEach var="i" begin="0" end="${sessionScope.courseslist.count-1 }" step="1">
<tr>
<td>${sessionScope.courseslist.courselist[i].cno} </td>
<td><input type="text" id="Cname${sessionScope.courseslist.courselist[i].cno}" class="form-control" name="Cname" value="${sessionScope.courseslist.courselist[i].cname }"></td>
<td>
<input type="text"  id="Ctime${sessionScope.courseslist.courselist[i].cno}" class="form-control" name="Ctime" value="${sessionScope.courseslist.courselist[i].ctime }">
</td>
<td>


<select id="Rname${sessionScope.courseslist.courselist[i].cno}" class="form-control">
<c:forEach var="j" begin="0" end="${sessionScope.classroomlist.count-1 }">
<c:if test="${sessionScope.courseslist.courselist[i].rno==sessionScope.classroomlist.roomlist[j].rno }">
<option selected="selected"> ${sessionScope.classroomlist.roomlist[j].rname }</option>
</c:if>
<c:if test="${sessionScope.courseslist.courselist[i].rno!=sessionScope.classroomlist.roomlist[j].rno }">
<option  > ${sessionScope.classroomlist.roomlist[j].rname }</option>
</c:if>
</c:forEach>
</select>


</td>
<td>${sessionScope.courseslist.courselist[i].cmax}</td>
<td><button class="btn btn-danger" onclick="DelCourse('${sessionScope.courseslist.courselist[i].cno}')">Del</button></td>
<td><button class="btn btn-info" onclick="EditCourse('${sessionScope.courseslist.courselist[i].cno}')">Edit</button></td>
</tr>

</c:forEach>

</table>
</div>
</td>
</tr>
</table>
</body>
</html>