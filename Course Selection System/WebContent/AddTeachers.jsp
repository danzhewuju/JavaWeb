<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@include file="ManagerMenuTitle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Student</title>
</head>
<body>
<div class="col-sm-offset-5">
<h1>Welcome you</h1>
</div>
<div class="col-sm-offset-4">
<h1><small> Please Complete these info for Teacher</small></h1>
</div>

<form class="form-horizontal" action="AddTeacher" method="post">
<div class="form-group">
<label for="ID" class="col-sm-4 control-label" >Username</label>
<div class="col-sm-4">
<input type="text" id="name"  class="form-control" name="name"  placeholder="Please input UserName" >
</div>
</div>

<div class="form-group">
<label for="Scode" class="col-sm-4 control-label">Password</label>
<div class="col-sm-4">
<input type="password" class="form-control" name="code" id="code" placeholder="Please input Teacher's password">
</div>
</div>

<div class="form-group">
<label for="Stel" class="col-sm-4 control-label" >Tel</label>
<div class="col-sm-4">
<input type="text" id="Stel"  class="form-control" name="tel"  placeholder="Please input Teacher's Tel " >
</div>
</div>



<div class="form-group">
<label for="sex" class="col-sm-4 control-label" >Gender</label>


<div class=" col-sm-offset-1 col-sm-4">
<div class="col-sm-2 " >
<label class=" control-label">male<input type="radio" name="sex" value="male" checked> </label>
</div>

<div class="col-sm-2 ">
 <label class="control-label">female<input type="radio" name="sex" value="female"></label>
</div>
 
</div>
</div>

<div class="form-group">
<div class="col-sm-offset-5 col-sm-1"><button type="reset" class="btn btn-info">Reset</button></div>
<div class=" col-sm-1"><input type="submit" class="btn btn-primary" value="Sure"></div>
</div>
</form>
<div class="form-group"> 
<div class="col-sm-offset-5 " >
<a href="AddTeachers.jsp"> <button class="btn btn-info btn-lg" >Input Next Teacher</button>   </a>

</div>
</div>
</body>
</html>