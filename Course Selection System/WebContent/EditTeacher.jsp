<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@include file="EditTeachersTitle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Teacher</title>
</head>
<body>

<div class="col-sm-offset-5"> 
<h3>Teacher's information</h3>
</div>
<form action="EditTeacher" method="post" class="form-horizontal">
<div class="form-group">
<label class="col-sm-4 control-label">Name</label>
<div class="col-sm-4">
<input type="text" class="form-control" name="name" value=${sessionScope.editteacher.tname } >
</div>
</div>

<div class="form-group">
<label class="col-sm-4 control-label">Code</label>
<div class="col-sm-4">
<input type="password" class="form-control" name="code" value=${sessionScope.editteacher.tcode } >
</div>
</div>


<div class="form-group">
<label class="col-sm-4 control-label">Tel</label>
<div class="col-sm-4">
<input type="text" class="form-control" name="tel" value=${sessionScope.editteacher.ttel } >
</div>
</div>


<div class="form-group">
<label class="col-sm-4 control-label">Sex</label>
<div class="col-sm-6">

<c:if test="${sessionScope.editteacher.tsex =='male' }">
<label class=" control-label  col-sm-3">male<input type="radio" name="sex" value="male" checked> </label>
<label class=" control-label col-sm-3">female<input type="radio" name="sex" value="female" > </label>
</c:if>
<c:if test="${sessionScope.editteacher.tsex =='female' }">
<label class=" control-label col-sm-3">male<input type="radio" name="sex" value="male" > </label>
<label class=" control-label col-sm-3">female<input type="radio" name="sex" value="female" checked> </label>
</c:if>
</div>
</div>
<div class="form-group">
<div class="col-sm-offset-5  col-sm-2"><input type="submit" class="btn btn-info form-control " value="Edit"></div>
</div>
</form>


</body>



</body>
</html>