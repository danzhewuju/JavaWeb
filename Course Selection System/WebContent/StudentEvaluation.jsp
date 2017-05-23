<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <jsp:include page="Stu_StudentMenuTitle.jsp" flush="true"></jsp:include>
      <%@include file="CSS.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Evaluation</title>
<script type="text/javascript">
function Send(Cno,i,Tno){
	var eva=document.getElementById(i).value;
	var tem=document.getElementsByName('radio'+i);
	var score;
	for(var j=0;j<tem.length;j++)
		{
		if(tem[j].checked)
			{
			
			score=tem[j].value;
			}
		
		}

	window.location.href="StudentSendEvaluation?Cno="+Cno+"&Eva="+eva+"&Score="+score+"&Tno="+Tno+"&Indox="+i;
}
</script>
</head>
<body>

<%
int first=(int)session.getAttribute("first");
first++;
session.setAttribute("first", first); %>
<div cLass="col-sm-offset-3"><h2>YOU CAN EVALUATE YOUR TEACHER</h2></div>
<div class="col-sm-offset-2 col-sm-8">
<table class="table table-striped">

<tr><td>Teacher Name</td><td>Course</td><td>Evaluation</td><td>Score</td><td>Handle</td></tr>
<c:forEach var="i" begin="0" end="${sessionScope.studentschedule.count-1 }" step="1">
<c:if test="${sessionScope.key[i]==1}">
<tr>
<td>${sessionScope.studentschedule.studentschedule[i].teacher.tname }</td>
<td>${sessionScope.studentschedule.studentschedule[i].courses.cname }</td>
<td>
 <input ID="${i}" type="text" class="form-control" >
</td>
<td>
<div class="col-sm-10">
<label class="col-sm-3 control-label">5<input type="radio" name="radio${i}" value="5" ></label>
<label class="col-sm-3 control-label">4<input type="radio" name="radio${i}" value="4"></label>
<label class="col-sm-3 control-label">3<input type="radio" name="radio${i}" value="3"></label>
<label class="col-sm-3 control-label">2<input type="radio" name="radio${i}" value="2"></label>
<label class="col-sm-3 control-label">1<input type="radio" name="radio${i}" value="1"></label>
</div>


</td>
<td><button id="btn${i}" class="btn btn-success" onclick="Send('${sessionScope.studentschedule.studentschedule[i].courses.cno}',
'${i}','${sessionScope.studentschedule.studentschedule[i].teacher.tno }')">SURE</button></td>


</tr>
</c:if>


</c:forEach>
</table>

</div>








</body>
</html>