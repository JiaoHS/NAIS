myApp.controller('couponHomeController', function ($scope, $http) {
    var storage;
    $scope.Init = function () {
        $scope.baseurl = getApiUrl();
        $scope.FilterPanel = [];
        $scope.cuponShadeShow = false;
        if (!window.localStorage) {
            alert("浏览器支持localstorage");
        } else {
            storage = window.localStorage;
            //storage.clear();
            return false;
        }
    }
    $scope.SkipIndex = function () {
        window.location.href = $scope.baseurl;
    }
    $scope.Quit = function () {
        storage.clear();
        window.location.href = $scope.baseurl + "/user/login";
    }
    $scope.Init();
    //我的优惠券
    $scope.MyCouponList = function () {
        $http({
            method: "get",
            url: $scope.baseurl + "/coupon/show/myCouponList?page=1&rows=8",
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            $scope.MyCouponList = resdata.data.rows;
            // if (resdata.data.code == 0) {//成功
            //     $scope.MyCouponList = resdata.data.rows;
            // } else {
            //     alert(resdata.data.info);
            // }

        });
    }
    $scope.MyCouponList();
    //显示 活动优惠券
    $scope.GetActiveList = function () {
        $http({
            method: "get",
            url: $scope.baseurl + "/coupon/show/activityCouponList?page=1&rows=6",
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            $scope.GetActiveList = resdata.data.rows;
            // if (resdata.data.code == 0) {//成功
            //     $scope.GetActiveList = resdata.data.rows;
            // } else {
            //     alert(resdata.data.info);
            // }

        });
    }
    $scope.GetActiveList();
    //领取活动优惠券
    $scope.GetCoupon = function (couponId, moneyNum) {
        var w = document.documentElement.clientWidth || document.body.clientWidth;
        var h = document.documentElement.clientHeight || document.body.clientHeight;
        $(".cuponShade").css({"width": w, "height": h, "display": "block"});

        // $scope.cuponShadeShow = true;
        var html = '<span class="csb-cSymbol">￥' + moneyNum + '</span><div class="csb-cGet">优惠券</div>';
        $('#couponsDetail').html(html);
        $http({
            method: "get",
            url: $scope.baseurl + "/coupon/pullActivityCouponCode?id=" + couponId,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {

            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                //alert(resdata.data.info);
                //追加到我的优惠券
                var couponHtl = '<div class="mcb-couponsDetail"><span class="mcb-cSymbol">￥' + moneyNum + '</span><div class="mcb-cGet">优惠券</div></div>';
                $('#mycoupon').append(couponHtl);
            } else {
                // alert(resdata.data.info);
                var wordHtml = '<span>抱歉</span><span>优惠券已拥有</span>';
                $('#csbpWord').html(wordHtml);
            }

        });
    }
    //领取推广优惠券
    $scope.GetGeneralizeCoupon = function () {
        var code = $scope.couponCodeModel;
        $http({
            method: "get",
            url: $scope.baseurl + "/coupon/pullSpreadCouponCode?couponCode=" + code,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                alert(resdata.data.info);
            } else {
                alert(resdata.data.info);
            }

        });
    }

    //日期转换
    $scope.FormatTime = function (time) {
        var timeList = [];
        var newTime = '';
        if (time != null && time != '') {
            time = time.substr(0, 10);
            timeList = time.split('-');
            for (i = 0; i < timeList.length; i++) {
                if (i == timeList.length - 1) {
                    newTime += timeList[i];
                } else {
                    newTime += timeList[i] + '.';
                }
            }
        }
        return newTime;
    }
    $scope.FormatTimeEnd = function (time) {
        var timeList = [];
        var newTime = '';
        if (time != null && time != '') {
            time = time.substr(5, 5);
            timeList = time.split('-');
            for (i = 0; i < timeList.length; i++) {
                if (i == timeList.length - 1) {
                    newTime += timeList[i];
                } else {
                    newTime += timeList[i] + '.';
                }
            }
        }
        return newTime;
    }
});