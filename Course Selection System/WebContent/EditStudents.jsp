<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="EditStudentsTitle.jsp" %>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome you</title>
</head>
<body>
<div class="col-sm-offset-5"> 
<h3>Student's information</h3>
</div>
<form action="EditStudent" method="post" class="form-horizontal">
<div class="form-group">
<label class="col-sm-4 control-label">Name</label>
<div class="col-sm-4">
<input type="text" class="form-control" name="Sname" value=${sessionScope.editstudent.sname } >
</div>
</div>

<div class="form-group">
<label class="col-sm-4 control-label">Code</label>
<div class="col-sm-4">
<input type="text" class="form-control" name="Scode" value=${sessionScope.editstudent.scode } >
</div>
</div>


<div class="form-group">
<label class="col-sm-4 control-label">Tel</label>
<div class="col-sm-4">
<input type="text" class="form-control" name="Stel" value=${sessionScope.editstudent.stel } >
</div>
</div>
<div class="form-group">
<label class="col-sm-4 control-label">Profession</label>
<div class="col-sm-4">
<select class="form-control" name="Sclass" >
<option>计算机学院</option>
<option>管理学院</option>
<option>环境学院</option>
<option>能动学院</option>
<option>版院</option>
</select>
</div>
</div>

<div class="form-group">
<label class="col-sm-4 control-label">Sex</label>
<div class="col-sm-6">

<c:if test="${sessionScope.editstudent.sex =='male' }">
<label class=" control-label  col-sm-3">male<input type="radio" name="Sex" value="male" checked> </label>
<label class=" control-label col-sm-3">female<input type="radio" name="Sex" value="female" > </label>
</c:if>
<c:if test="${sessionScope.editstudent.sex =='female' }">
<label class=" control-label col-sm-3">male<input type="radio" name="Sex" value="male" > </label>
<label class=" control-label col-sm-3">female<input type="radio" name="Sex" value="female" checked> </label>
</c:if>
</div>
</div>
<div class="form-group">
<div class="col-sm-offset-5  col-sm-2"><input type="submit" class="btn btn-info form-control " value="Edit"></div>
</div>
</form>


</body>
</html>