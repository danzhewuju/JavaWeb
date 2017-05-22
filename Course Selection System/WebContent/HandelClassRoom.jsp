<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file="ManagerMenuTitle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Handle ClassRoom</title>
<script type="text/javascript">
var xmlHttp;
function validate(){
	xmlHttp=new XMLHttpRequest();
	var name=document.getElementById("name").value;
	var url="AddClassRoom?Rname="+name;
	xmlHttp.onreadystatechange=handelStateChange;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
	
}
function handelStateChange(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var message=xmlHttp.responseXML.getElementsByTagName("message")[0].firstChild.data;
			var loc=document.getElementById("results");
			loc.innerHTML="<mark>"+message+"</mark>";
		}
	}
	}
	
	
function  deleteclassroom(key){
		var Rno=document.getElementById(key).value;
		window.location.href="DeleteClassRoom?Rno="+Rno;
}
function editclassroom(btnid,inputid)
{
	var Rno=document.getElementById(btnid).value;
	var newname=document.getElementById(inputid).value;
	window.location.href="EditClassRoom?Rno="+Rno+"&newname="+newname;
	}
</script>
</head>
<div class="col-sm-offset-3">
<h1> Welcome You <small>you can add,del,edit ClassRoom </small></h1>
</div>
<body>
<div class="col-sm-offset-4">
<h3> you can add Class Room</h3>
</div>

<div class="form-group">
<form class="form-horizontal " action="AddClassRoom" method="post">
<label for="name" class="col-sm-4 control-label">ClassRoomName</label>
<div class="col-sm-4">
<input  type="text" name="Rname" id="name" class="form-control"  placeholder="Please input ClassRoom's Name" >
</div>
<input class="btn btn-success " type="submit" value="Create" >

</form>
</div>




<div class="col-sm-offset-4"><h1> You can handle info</h1></div>
<div class="col-sm-offset-2 col-sm-8">
<c:set var="Del" value="Del"></c:set>
<c:set var="Edit" value="Edit"></c:set><!--  设置变量-->
<c:set var="Input" value="Input"></c:set>
<table class="table table-striped">
<tr><td>ID</td><td><div class="col-sm-offset-2">Name</div></td><td>Del</td><td>Edit</td></tr>

<c:forEach var="i" begin="0" end="${sessionScope.classroomlist.count-1 }" step="1">
<tr>
<td>
${sessionScope.classroomlist.roomlist[i].rno }
</td>
<td>
<div class=" col-sm-offset-1 col-sm-4">
  <input type="text" id="${Input}${i}" name="${Input}${i}"  class="form-control" value=" ${sessionScope.classroomlist.roomlist[i].rname }" >
</div>
 
</td>
<td>
<button class="btn btn-danger " id="${Del}${i}" value="${sessionScope.classroomlist.roomlist[i].rno}" onclick="deleteclassroom('${Del}${i}')">delete</button>
</td>
<td>
<button class="btn btn-info " id="${Edit}${i}" value="${sessionScope.classroomlist.roomlist[i].rno}" onclick="editclassroom('${Edit}${i}','${Input}${i}')">Sure</button>
</td>
</tr>

</c:forEach>
</table>
</div>
</body>
</html>