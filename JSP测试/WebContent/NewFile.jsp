<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
this is jsp page!
<%! int count=0;
int f(){
	return 1;
}

%>
<%
String name=(String)request.getAttribute("name");
if(name==null)
{
	
}

%>
<from action=NewFile.jsp method="post">
<p>姓名：<input type="text" name="name" >
<p><input type=submit value="提交">
</from>
</body>
</html>