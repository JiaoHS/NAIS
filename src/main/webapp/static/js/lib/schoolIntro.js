$(function(){
	$(".tab").on("click","li",function(){
		var i = $(this).index();
		$(this).addClass('select').siblings().removeClass('select');
		$(".infoItem").eq(i).show().siblings().hide();
	})

	$(".detailTab").on("click","li",function(){
		var i = $(this).index();
		$(this).addClass('select').siblings().removeClass('select');
		$(".detailCon .detailItem").eq(i).addClass('cur').siblings().removeClass('cur');
	})
})