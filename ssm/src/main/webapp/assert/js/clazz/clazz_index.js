/**
 * 
 */
$(document).ready(function(){
	initTableDate();
	function initTableDate(){
	$.ajax({
		type:'get',
		url:'clazz/list',
		success:function(result){
			$('#tbody_clazz').html(result); 
		}
	});
	}
	$(document).off('click','#clazzEditId').on('click','#clazzEditId',function(){
		var href = $(this).attr('href');
		console.log(href);
		$.ajax({
			type:'put',
			url:href,
			success:function(result){
				layer.open({
                    type:1,
                    title:"班级修改",
                    area:['500px','500px'],
                    content:result
                }); 
		}
		})
		return false;
	});
	$(document).off('click','#clazzDeleteId').on('click','#clazzDeleteId',function(){
		 var href = $(this).attr('href');
		 layer.alert('',{
                icon:2,
                area:['200px','200px'],
                title:'删除确认',
                content:'您确定要删除这条记录吗？',
                closeBtn:1},
                function(index){
					console.log(href);
                    $.ajax({
						type:'delete',
						url:href,
						success:function(result){
							 layer.close(layer.index);
							$('#tbody_clazz').html(result); 
							console.log(result);
					}
					});
                    layer.close(index);
                }); 
		return false;
	});
	$('#clazzAddId').off('click').on("click",function(){
		console.log("clazzAddId");
		var href = $(this).attr('href');
		console.log(href);
		$.ajax({
			type:'post',
			url:href,
			success:function(result){
				layer.open({
                    type:1,
                    title:"班级新增",
                    area:['500px','500px'],
                    content:result
                }); 
		}
		})
		return false;
	});
	$(document).off('click','#clazzAddSubmitId').on('click','#clazzAddSubmitId',function(){
		console.log("clazzAddSubmitId");
		$.ajax({
			type:'post',
			url:'clazz',
			data:$('#clazzAddForm').serialize(),
			success:function(htmlData){
				 layer.close(layer.index);
				$('#tbody_clazz').html(htmlData); 
			}
		});
		return false;
	});
});