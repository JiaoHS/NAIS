$(function(){
	$(".tab").on("click","li",function(){
		var i = $(this).index();
		$(this).addClass('select').siblings().removeClass('select');
		$(".topBanner li").eq(i).show().siblings().hide();
		$(".infoItem").eq(i).show().siblings().hide();
	})
})