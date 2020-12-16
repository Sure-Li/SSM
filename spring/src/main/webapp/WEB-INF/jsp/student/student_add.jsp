<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生新增</title>
<base href="http://localhost:8080/spring/">
<base>
</head>
<body>
	<h1>学生新增</h1>
	<form action="student/doadd" method="post">
		学生编号：<input name="stuCode" id="stuCodeId"><br>
		学生姓名<input name="stuName" /><br>
		学生年龄<input name="stuAge" /><br>
		学生性别<select name="stuSex">
			<option value="1">男</option>
			<option value="0">女</option>
		</select><br> 
	<!-- 	@DateTimeFormat(pattern = "yyyy-MM-dd")//将表单中得到的字符串格式的数据转换为date数据
	private Date stuBirthday;  -->
		 学生生日<input type="date" name="stuBirthday"><br>
		<input type="submit">
	</form>
</body>
<script type="text/javascript" src="assert\js\jQuery\jquery-3.4.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#stuCodeId').on('blur',function(){
		var val = $(this).val();
		if(val!=null && val!=""){
			$.ajax({
				url:'student/checkcode',
				data:{'stuCode':val},
				success:function(result){
					console.log(result);
				}
			});
		}
	})
});
</script>
</html>