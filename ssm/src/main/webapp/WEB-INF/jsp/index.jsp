<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>单页版首页SSM</title>
<jsp:include page="base.jsp"/>
<!-- 先引第三方 再引自己的 -->
<link rel="stylesheet" href="assert/js/layer/theme/default/layer.css">
<link rel="stylesheet" href="assert\css\index.css">
<link rel="stylesheet" href="assert/uploadfile/uploadifive.css">
</head>
<body>
<div class="contaner">
<div class="top">
<h1>管理系统</h1>
</div>
<div class="left">
<a href="user">用户管理</a><br>
</div>
<div class="main" id="maindiv"></div>
</div>

</body>
<script type="text/javascript" src="assert\js\jQuery\jquery-3.4.1.js"></script>
<script type="text/javascript" src="assert/js/layer/layer.js"></script>
<script type="text/javascript" src="assert/uploadfile/jquery.uploadifive.js"></script>
<script type="text/javascript" src="assert/js/index.js"></script>
</html>