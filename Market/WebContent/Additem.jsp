<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.image{
width:128px;
height:128px;
}
.btn{
    width:60px;
    height:30px;
    background:red;
    color:yellow;
   fone-size=30;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body>
<center>
<form action="AddItem" enctype="multipart/form-data" method="post">
<p>名称:<input type="text" name="name">
<p>价格:<input type="text" name="price">
<p>上传图片：<input type="file" name="image">
<p><input type="submit" value="确认" class="btn">&nbsp<input type="reset" value="取消" class="btn">
</form>
</center>
</body>
</html>