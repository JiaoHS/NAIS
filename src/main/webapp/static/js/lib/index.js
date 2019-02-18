$(function(){
	var timerObj = {
		s_speed : 500, //特效时间
        t_speed : 3000, //轮播时间
        index : -1, //得到序号
        off : 1,
        timerObj : null
	}

	$(".handleCon").on('click', 'li', function(event) {
		if(!timerObj.off) return false;

        timerObj.index = $(this).index();
        $(this).addClass('select').siblings().removeClass('select');
        $(".bannerCon li").eq(timerObj.index).stop().fadeIn(timerObj.s_speed).siblings().stop().fadeOut(timerObj.s_speed);
        timerObj.off = 0;

        setTimeout(function() {
            timerObj.off = 1;
        }, timerObj.s_speed - 100); //启动定时器 一定时间后timerObj.off=1，点击有效
    });
    function autoplay() {
    	timerObj.index++; //先++  后判断  再 执行
        timerObj.index = timerObj.index % $(".bannerCon li").length; //length  返回长度  就是图片的张数
        $(".bannerCon li").eq(timerObj.index).stop().fadeIn(timerObj.s_speed).siblings().stop().fadeOut(timerObj.s_speed);
        $(".handleCon li").eq(timerObj.index).addClass('select').siblings().removeClass('select');
    }
    setTimeout(function(){autoplay();},0);
    timerObj.timer = setInterval(autoplay, timerObj.t_speed); //开始定时器

    
    $(".prev").click(function(event) {
        if(!timerObj.off) return false; //判断值是否为1 是的时候点击有效
        timerObj.index--;
        if (timerObj.index < 0) {
            timerObj.index = $(".handleCon li").length - 1; //倒着来
        }
        $(".bannerCon li").eq(timerObj.index).stop().fadeIn(timerObj.s_speed).siblings().stop().fadeOut(timerObj.s_speed);
        $(".handleCon li").eq(timerObj.index).addClass('select').siblings().removeClass('select');
        timerObj.off = 0; //再置为0 点击无效

        setTimeout(function() {
            timerObj.off = 1;
        }, timerObj.s_speed); //启动定时器 一定时间后timerObj.off=1，点击有效
    });

    $(".next").click(function(event) {
    	if(!timerObj.off) return false;

        autoplay();
        timerObj.off = 0;

        setTimeout(function() {
            timerObj.off = 1;
        }, timerObj.s_speed);
    });

    $(".banner").hover(function() {
        clearInterval(timerObj.timer); //清除定时器
        timerObj.timer = null; //清空变量
    }, function() {
        clearInterval(timerObj.timer); //开启定时器之前，首先先清除
        timerObj.timer = setInterval(autoplay, timerObj.t_speed); //开启定时器
    });

});
