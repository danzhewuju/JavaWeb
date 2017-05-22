<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file="ManagerMenuTitle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<div class="col-sm-offset-3">
<h1>Welcom you,<strong><small> Please Complete these info</small> </strong></h1>
</div>

<form class="form-horizontal" action="AddStudent" method="post">
<div class="form-group">
<label for="ID" class="col-sm-4 control-label" >Username</label>
<div class="col-sm-4">
<input type="text" id="Sname"  class="form-control" name="Sname"  placeholder="Please input UserName" >
</div>
</div>

<div class="form-group">
<label for="Scode" class="col-sm-4 control-label">Password</label>
<div class="col-sm-4">
<input type="password" class="form-control" name="Scode" id="Scode" placeholder="Please input your password">
</div>
</div>

<div class="form-group">
<label for="Stel" class="col-sm-4 control-label" >Tel</label>
<div class="col-sm-4">
<input type="text" id="Stel"  class="form-control" name="Stel"  placeholder="Please input Tel " >
</div>
</div>

<div class="form-group">
<label for="" class="col-sm-4 control-label" >Profession</label>
<div class="col-sm-4">
<select class="form-control" name="Sclass">
<option>计算机学院</option>
<option>管理学院</option>
<option>环境学院</option>
<option>能动学院</option>
<option>版院</option>
</select>
</div>
</div>

<div class="form-group">
<label for="Sex" class="col-sm-4 control-label" >Gender</label>


<div class=" col-sm-offset-1 col-sm-4">
<div class="col-sm-2 " >
<label class=" control-label">男<input type="radio" name="Sex" value="male" checked> </label>
</div>

<div class="col-sm-2 ">
 <label class="control-label">女<input type="radio" name="Sex" value="female"></label>
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
<a href="AddStudents.jsp"> <button class="btn btn-info btn-lg" >Input Next Student</button>   </a>

</div>
</div>

</body>
</html>