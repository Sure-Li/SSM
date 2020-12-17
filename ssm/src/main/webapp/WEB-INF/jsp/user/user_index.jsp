<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- duoyiaojianchaxun  -->
<form id="searchForm">
<input name="userName"  placeholder="用户名称">
<input name="userCode" placeholder="用户账号">
<input type="button" value="查询">
<input type="reset" >
</form>
<a href="javaScript:;" style="float: right;" id="btn-add">新增</a>
<table>
		<tr>
			<th>用户名称</th>
			<th>登录账号</th>
			<th>登录次数</th>
			<th>左后登录信息</th> 
			<th>账户状态</th> 
			<th>操作</th>
		</tr>
		<tbody id="tbody_clazz"></tbody>
</table>
<script type="text/javascript" src="assert/js/user.js"></script>
