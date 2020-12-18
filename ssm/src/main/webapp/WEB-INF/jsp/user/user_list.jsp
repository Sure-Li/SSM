<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${!empty userList}">
	<c:forEach items="${userList}" var="user">
		<c:if test="${user.activeFlag==1}">
			<tr>
				<td>${user.userName}</td>
				<td>${user.userCode}</td>
				<td>${user.loginCount}</td>
				<td>${user.lastLoginIp}&nbsp;<fmt:formatDate value="${user.lastLoginDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${user.isLock==1?"锁定":"正常"}</td>
				<td><a href="clazz/${clazz.rowId}" id="clazzEditId">修改</a><a
					href="clazz/${clazz.rowId}" id="clazzDeleteId">删除</a></td>
			</tr>
		</c:if>
	</c:forEach>
</c:if>
<c:if test="${empty userList}">
<h1 style="color: red;">暂无数据</h1>
</c:if>