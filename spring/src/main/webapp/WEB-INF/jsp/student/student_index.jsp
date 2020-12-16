<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生管理</title>
<base href="http://localhost:8080/spring/"><base>
</head>
<body>
	<a href="student/goadd" style="float: right;">新增</a>
	<table>
		<tr>
			<th>学生姓名</th>
			<th>学生年龄</th>
			<th>学生生日</th>
			<th>操作</th>
		</tr>
	
	<c:if test="${!empty studenList}">
	<c:forEach items="${studenList}" var="student">
	<c:if test="${student.stuName!=null}">
	<tr>
			<td>${student.stuName}</td>
			<td>${student.stuAge}</td>
			<td>${student.stuBirthday}</td>
			<td><a href="student/goedit/${student.rowId}">修改</a><a href="student/delect/${student.rowId}">删除</a></td>
	</tr>
	</c:if>
	</c:forEach>
	</c:if>
	</table>
</body>
</html>