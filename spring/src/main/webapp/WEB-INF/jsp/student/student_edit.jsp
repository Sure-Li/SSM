<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>学生修改</h1>
	
	<form action="doedit" method="post">
	<input type="hidden" name="rowId" value="${studentGoEdit.rowId}">
		学生姓名<input name="stuName" value="${studentGoEdit.stuName}" /><br> 学生年龄<input name="stuAge" value="${studentGoEdit.stuAge}"/><br>
		学生性别<select name="stuSex">
			<option value="1" ${studentGoEdit.stuSex==1? "selected='selected'":''}>男</option>
			<option value="0" ${studentGoEdit.stuSex==0? "selected='selected'":''}>女</option>
		</select><br> 
		 <%-- 学生生日<input type="date" name="stuBirthday" value="${studentGoEdit.stuBirthady}"><br> --%>
		<input type="submit">
	</form>
</body>
</html>