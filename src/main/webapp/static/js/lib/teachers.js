$(function(){
	$(".tab").on("click","li",function(){
		var i = $(this).index();
		$(this).addClass('select').siblings().removeClass('select');
	})
})