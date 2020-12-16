<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${!empty clazzList}">
	<c:forEach items="${clazzList}" var="clazz">
		<c:if test="${clazz.activeFlag==1}">
			<tr>
				<td>${clazz.clazzId}</td>
				<td>${clazz.clazzName}</td>
				<td>${clazz.clazzStudentCount}</td>
				<td>${clazz.clazzInfo}</td>
				<td><a href="clazz/${clazz.rowId}" id="clazzEditId">修改</a><a
					href="clazz/${clazz.rowId}" id="clazzDeleteId">删除</a></td>
			</tr>
		</c:if>
	</c:forEach>
</c:if>