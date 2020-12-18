$(document).ready(function(){
	//页面加载完成之后直接加载文件的数据
	initUserData();
	//绑定查询数据
	$('#btn_search').off('click').on('click',function(){
		initUserData();
	});
	$('#btn-add').off('click').on('click',function(){
		$.ajax({
			url:'user/form',
			success:function(htmlData){
				layer.open({
                    type:1,
                    title:"用户新增",
                    area:['500px','500px'],
                    content:htmlData,
					success:function(layero,index){
						bindFileUpload();
						bindSubmit();
					}
                }); 
			}
		});
	});
	function bindFileUpload(){
		//绑定异步上传文件 在外面直接绑定无法绑定
		$('#userFile').uploadifive({
	        'auto': true,
			'buttonText':'用户头像',
	        'fileObjName'     : 'userFile', 
	        'uploadScript'     : 'user/upload',//上传的url
	        'onUploadComplete' : function(file, data) {//上传成功后的回调
	        	console.log(data);
	        	$('#userAvatar').val(data);
	        	}
	    });
	}
	function bindSubmit(){
		$('#btn_userSubmit').off('click').on('click',function(){
			$.ajax({
				type:'post',
				url:'user',
				data:$('#form_user').serialize(),
				success:function(data){
					console.log(data);
					if(date){
						layer.close(index);
					}
				}
			})
		});
		return false;
	}
	function initUserData(){
		$.ajax({
			url:'user/list',
			type:'get',
			data:$('#searchForm').serialize(),//将多条件查询表单
			success:function(data){
				$('#tbody_user').html(data);
			}
		});
	}
	
});