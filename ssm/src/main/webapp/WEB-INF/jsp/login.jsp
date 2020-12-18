<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录首页</title>
<jsp:include page="base.jsp" />
</head>
<body>
	<h1 id="login_info"></h1>
	<form id="form_login" style="text-align: center;">
		 登陆账号：<input name="userCode"><br>
		 登陆密码：<input type="password"name="userPassword"><br>
		<input type="button" value="登录" id="btn_login">
		<input type="reset">
	</form>
</body>
<script type="text/javascript" src="assert\js\jQuery\jquery-3.4.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#btn_login').off('click').on('click',function(){
		$.ajax({
			url:'dologin',
			data:$('#form_login').serialize(),
			success:function(data){
				if(data==1){
					location.href="index";
				}else if(data==3){
					$('#login_info').text("账户被锁定，请联系管理员");
				}else if(data==2){
					$('#login_info').text("密码错误");
				}
			}
		});
	});
});
</script>
</html>