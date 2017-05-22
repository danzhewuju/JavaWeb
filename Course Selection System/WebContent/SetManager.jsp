<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome you Manager</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
var xmlHttp;
function createXMLHttpRequest(){
	if(window.ActiveXObject){
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	else if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}
	
}
function validate(){
	createXMLHttpRequest();
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	var url="CheckManager?username="+username+"&password="+password;
	xmlHttp.onreadystatechange=handleStateChange;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
}
function handleStateChange(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var message=xmlHttp.responseXML.getElementsByTagName("message")[0].firstChild.data;
			var messageArea=document.getElementById("results");
			var log ="你的账号："+message;
			messageArea.innerHTML="<h5>"+log+"</h5>";
		}
	}
}


</script>




</head>
<body>
<div class="col-sm-offset-4">
<h1> Welcome join us </h1>
<strong> Your Work Will Make our System Better</strong> 
<p>
</div>

<form class="form-horizontal" action="Login.html" method="get">
<div class="form-group">
<label for="username" class="col-sm-4 control-label">UserName</label>
<div class="col-sm-3">
<input type="text" class="form-control" name="username" id="username" 
  placeholder="Please Input Your Name">
</div>

</div>

<div class="form-group">
<label for="password" class="col-sm-4 control-label">PassWord</label>
<div class="col-sm-3">
<input type="password" class="form-control" name="password" id="password" 
   placeholder="Please Input Your " onchange="validate()">
</div>

</div>

<div class="form-group">
<div class="col-sm-offset-5">
<input type="submit" class="btn btn-default" value="Sure" >
</div>
</div>

</form>

<div class="col-sm-offset-4" id="results">

</div>

</body>
</html>