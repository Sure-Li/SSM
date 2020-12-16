<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assert\uploadfile\uploadifive.css">
</head>
<body>
<form>
学生名称：<input name="stuName"><br>
学生头像：<input type="file"name="stuFile" id="stuFile"><br>
<input type="hidden" name="stuAvatar" id="stuAvatarId">
<img alt="" src="E:\SSM\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\spring\upfiles/1608110213827.png" id="upImg"/>
<input type="submit">
<input type="reset">
</form>
</body>
<script type="text/javascript" src="assert\js\jQuery\jquery-3.4.1.js"></script>
<script type="text/javascript" src="assert\uploadfile\jquery.uploadifive.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//绑定ajax文件上传功能
	$('#stuFile').uploadifive({
        'auto': true,
        'fileObjName'     : 'multipartFile', 
        'uploadScript'     : 'upload3',//上传的url
        'onUploadComplete' : function(file, data) {//上传成功后的回调
        	console.log(data);
        	$('#stuAvatar').val(data);
        	$('#upImg').attr('src',data);
        	}
    });
});
</script>
</html>