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
			dataType:'html',
			data:$('#searchForm').serialize(),//将多条件查询表单
			success:function(data){
				$('#tbody_user').html(data);
			}
		});
	}
	var editIndex = null;
	function bindEditSubmit(){
		$('#btn_userSubmitEdit').off('click').on('click',function(){
			$.ajax({
				type:'post',
				url:'user/doedit',
				data:$('#form_user_edit').serialize(),
				success:function(data){
					console.log(data);
					if(data){
						layer.close(editIndex);
						$('#loginUserName').text(data);
						initUserData();
					}
				}
			})
		});
		return false;
	}
	$(document).off('click','#userEditId').on('click','#userEditId',function(){
		console.log("userEditId");
		var href = $(this).attr('href');
		console.log(href);
		$.ajax({
			url:href,
			type:'GET',
			success:function(result){
			editIndex=layer.open({
                    type:1,
                    title:"用户修改",
                    area:['500px','500px'],
                    content:result,
					success:function(data){
						bindFileUpload();
						console.log("bindEditSubmit();");
						bindEditSubmit();
					}
                }); 
			}
		});
		return false;
	});
	$(document).off('click','#userDeleteId').on('click','#userDeleteId',function(){
		console.log("userDeleteId");
		var href = $(this).attr('href');
		console.log(href);
		layer.alert('',{
                icon:2,
                area:['200px','200px'],
                title:'退出删除',
                content:'您确定要删除吗？',
                closeBtn:1},
                function(index){
					$.ajax({
						url:href,
						method:'get',
						success:function(data){
							if(data==1){
								location.href="index";
							}
						}
					});
                    layer.close(index);
                }); 
		return false;
	});
});