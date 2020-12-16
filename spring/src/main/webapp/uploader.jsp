<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="upload1" method="post" enctype="multipart/form-data">
学生名称：<input name="stuName"><br>
学生头像：<input type="file"name="stuFile"><br>
<input type="submit">
<input type="reset">
</form>

</body>
</html>