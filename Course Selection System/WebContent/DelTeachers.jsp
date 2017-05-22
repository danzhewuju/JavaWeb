<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ include file="DelStudentsTitle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>delete teacher</title>
</head>
<body>

<div class="col-sm-offset-5"><h3>Teacher's info</h3>
</div>
<div class="col-sm-offset-4 col-sm-4">

<form  action="DelTeacher" method="post">
<table class="table table-striped">
 
 
 <tr>
 <td>ID</td> <td>${sessionScope.delteacher.tno}</td>
 </tr>
 <tr>
 <td>Name</td> <td>${sessionScope.delteacher.tname}</td>
 </tr>
 <tr>
 <td>Sex</td> <td>${sessionScope.delteacher.tsex}</td>
 </tr>
 <tr>
 <td>Tel</td> <td>${sessionScope.delteacher.ttel}</td>
 </tr>
 
</table>
<div class="col-sm-offset-5"><input type="submit" class="btn btn-warning btn-lg" value="Del"></div>
</form>

</div>


</body>
</html>