<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assert\css\index.css">
</head>
<body>
<div class="contaner">
<div class="top">
<h1>管理系统</h1>
</div>
<div class="left">
<a href="clazz">班级管理</a><br>
<a href="student/index">学生管理</a>
</div>
<div class="main"></div>
</div>

</body>
<script type="text/javascript" src="assert\js\jQuery\jquery-3.4.1.js"></script>
<script type="text/javascript" src="assert\js\layer\layer.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	console.log("index");
	$('.left ').off('click','a').on('click','a',function(){
		var href = $( this).attr('href');
		console.log(href);
		$.ajax({
			url:href,
			type:'get',
			success:function(htmlDate){
				$('.main').html(htmlDate);
			}  
		})
		return false;
	});


});
</script>
</html>