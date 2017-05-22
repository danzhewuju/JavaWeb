<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ include file="ManagerMenuTitle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DelTeacher</title>
<script type="text/javascript">
function getKey(){
	var key=document.getElementById("E").value;
	window.location.href="DelTeacher?E="+key;
}
</script>
</head>
<body>
<div class="col-sm-offset-4">
<div class="col-lg-6">
    <div class="input-group">
      <input id="E" type="text" class="form-control" placeholder="Search for Teacher By ID or Name">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button" onclick="getKey()">Go!</button>
      </span>
    </div>
  </div>
 <h3>Please be careful</h3>
</div>

 <div class="col-sm-offset-4">
 
 <c:if test="${sessionScope.message=='Teacher' }">
 <h1> Sorry The Teacher don't Exist</h1>
 ${sessionScope.message='' }
 
 </c:if>
 
 </div>

</body>
</html>