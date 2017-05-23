<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="TeacherMenuTitle.jsp" flush="true"></jsp:include>
      <%@include file="CSS.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Answer Student</title>
<script type="text/javascript">
function Send(Sno,ID)
{
	var Backmsn=document.getElementById(ID).value;
	document.location.href="TeacherAnswerBackMsn?Sno="+Sno+"&Backmsn="+Backmsn+"&ID="+ID;
	}
</script>
</head>
<body>
<div class="col-sm-offset-3 ">
<h2>YOU CAN ANSWER YOUR STUDENT'S QUESTION</h2>
</div>
<div class="col-sm-offset-2 col-sm-8">

<table class="table table-striped">
<tr><td>Student'sID</td><td>Student'sName</td><td>Question</td><td>Answer</td><td>Handle</td></tr>
<c:forEach var="i" begin="0" end="${sessionScope.messagelist.count }" step="1">
<c:if test="${i!=sessionScope.messagelist.count }">
<tr>
<td>${sessionScope.messagelist.messagelist[i].student.sno }</td>
<td>${sessionScope.messagelist.messagelist[i].student.sname }</td>
<td>${sessionScope.messagelist.messagelist[i].msn }</td>
<td><input id="${sessionScope.messagelist.messagelist[i].ID}" class="form-control" ></td>
<td><button class="btn btn-success" onclick="Send('${sessionScope.messagelist.messagelist[i].student.sno }',
		'${sessionScope.messagelist.messagelist[i].ID}')">Sure</button></td>
</tr>



</c:if>

</c:forEach>

</table>
</div>

</body>
</html>