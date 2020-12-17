//建议写成文件 可以使用浏览器缓存
$(document).ready(function() {
	/*给页面左侧绑定点击事件*/
	$('.left').off('click', 'a').on('click', 'a', function() {
		var href = $(this).attr('href');
		console.log(href);
		/*ajax get data*/
		var layer_index = null;
		$.ajax({
			url: href,
			type: 'get',
			datetype: 'html',/*异步请求期望返回的数据格式 如果不写 ajax会自适应*/
			beforeSend: function() {/*请求完成之前*/
				layer_index = layer.load(1, {
					shade: [0.1, '#fff'] //0.1透明度的白色背景
				});
			},
			success: function(data) {
				console.log(data);
				$('#maindiv').html(data);
			},
			complete: function() {/*请求完成之后*/
				layer.close(layer_index);
			}
		});
		return false;
	});
});