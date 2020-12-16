<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- duoyiaojianchaxun  -->
<form id="searchForm">
<input placeholder="班级编号">
<input placeholder="班级信息">
<input type="button" value="查询">
<input type="reset" >
</form>
<a href="clazz/goadd" style="float: right;" id="clazzAddId">新增</a>
<table>
		<tr>
			<th>班级编号</th>
			<th>班级名称</th>
			<th>学生数量</th>
			<th>班级信息</th> 
			<th>操作</th>
		</tr>
		<tbody id="tbody_clazz"></tbody>
</table>
<script type="text/javascript" src="assert\js\clazz\clazz_index.js"></script>