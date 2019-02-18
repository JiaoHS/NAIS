myApp.controller('orderCenterController', function ($scope, $http, $interval) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];
    $scope.courseId = [];
    $scope.cuponsBox = false;
    if (!window.localStorage) {
        alert("浏览器支持localstorage");
    } else {
        storage = window.localStorage;
    }
    //删除缓存
    storage.setItem("Selected", "coursesOrderReview");
    var dict = {
        "course1": [],
        "course2": [],
        "course3": [],
        "course4": []
    };
    $scope.schoolId = storage.getItem("schoolId");

    dict = JSON.parse(storage.getItem("courseDic"));
    storage.setItem("ShouldMoney", "0");
    for (var course in dict) {
        if (dict[course].length > 0) {
            for (c = 0; c < dict[course].length; c++) {
                $scope.courseId.push(dict[course][c]);
            }
        }
    }
    $scope.SkipIndex = function () {
        window.location.href = $scope.baseurl;
    }
    $scope.ToPay = function (orderId) {
        $http({
            method: "post",
            url: $scope.baseurl + "/order/toPayList?orderId=" + orderId,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.OrderInfo = resdata.data.data;
                $scope.ShouldMoney = $scope.OrderInfo.totalAmount / 1000;
                $scope.DiscountMoney = 0.00;
                $scope.TimeDiff($scope.OrderInfo.createTime);
                storage.setItem("CouponCreateTime", $scope.OrderInfo.createTime);
                storage.setItem("paymentSeq", $scope.OrderInfo.paymentSeq);
                storage.setItem("ShouldMoney", $scope.ShouldMoney);
            } else {
                alert(resdata.data.info);
            }
        });
    }
    $scope.LoadOrder = function (courseId, schoolId) {
        storage.setItem("Selected", "coursesOrderReview");
        $http({
            method: "get",
            url: $scope.baseurl + "/chooseCourse/submit?" + courseId + "&campusId=" + schoolId,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            $(".ps-m-left div").each(function (index, value) {
                if (storage.getItem("Selected") == $scope.ChangeTab(value.innerHTML)) {//当前选中
                    value.className = "Selected";
                    $(this).parent().siblings().children().each(function (index, value) {
                        value.className = 'unSelected';
                    });
                }
            });
            if (resdata.data.code == 0) {//成功
                //跳转到我的订单  并清除缓存
                storage.removeItem("schoolId");
                storage.removeItem("courseId");
                storage.removeItem("courseDic");
                storage.removeItem("chk");
                storage.removeItem("orderId");//清除已存在的订单缓存
                storage.removeItem("tabId");//清除已存在的订单缓存
                //缓存 订单 id
                $scope.OrderInfo = resdata.data.data;
                storage.setItem("orderId", $scope.OrderInfo.id);
                $scope.ShouldMoney = $scope.OrderInfo.totalAmount / 1000;
                $scope.DiscountMoney = 0.00;
                storage.setItem("paymentSeq", $scope.OrderInfo.paymentSeq);
                storage.setItem("CouponCreateTime", $scope.OrderInfo.createTime);
                storage.setItem("ShouldMoney", $scope.ShouldMoney);
                //$scope.ToPay($scope.OrderInfo.id);
                //开启计时
                $scope.TimeDiff($scope.OrderInfo.createTime)
            } else {
                alert(resdata.data.info);
            }

        });
    }
    //判断$scope.schoolId  第一次加载进来
    if ($scope.schoolId == -1) {
        var temp = "id=-1";
        $scope.LoadOrder(temp, -1);
    } else if ($scope.schoolId != null) {
        var idList = 'id=';
        if ($scope.courseId == null) {//未支付 不 跳转到我的订单
            storage.setItem("Selected", "coursesOrderReview");
            storage.removeItem("schoolId");
            $(".ps-m-left div").each(function (index, value) {
                if (storage.getItem("Selected") == value.innerHTML) {//当前选中
                    value.className = "Selected";
                    $(this).parent().siblings().children().each(function (index, value) {
                        value.className = 'unSelected';
                    });
                }
            });
            //调接口查订单  取缓存数据orderId
            var orderId = storage.getItem("orderId");
            $scope.ToPay(orderId);

            //window.location.href = $scope.baseurl + "/user/home#/coursesOrderReview";
        } else {
            for (i = 0; i < $scope.courseId.length; i++) {
                if (i == $scope.courseId.length - 1) {
                    idList += $scope.courseId[i];
                } else {
                    idList += $scope.courseId[i] + '&id='
                }
            }
            $scope.LoadOrder(idList, $scope.schoolId);
        }
    }

    $scope.OrderId = storage.getItem("orderId");
    if ($scope.OrderId != null && $scope.schoolId == null) {
        $scope.ToPay($scope.OrderId);
    }
    $scope.CouponlistShow = false;
    $scope.MyCouponList = function () {
        $scope.cuponsBox = true;
        $http({
            method: "get",
            url: $scope.baseurl + "/coupon/show/myCouponList?page=1&rows=8",
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            if ($scope.CouponlistShow == false) {
                $scope.CouponlistShow = true;
            } else {
                $scope.CouponlistShow = false;
                return false;
            }
            var resdata = angular.fromJson(data);
            $scope.MyCouponList = resdata.data.rows;
            if ($scope.MyCouponList == null || $scope.MyCouponList.length <= 0) {
                alert("暂无优惠券")
                return false;
            }
            //修改 m-right的样式
            var temp = Math.ceil($scope.MyCouponList.length / 5);
            var pxTemp = $('.m-right')[0].offsetHeight + temp * 100;
            $('.m-right').css('height', pxTemp);
        });
    }

    $scope.GetCouponMoney = function (money, id) {
        //将id缓存
        storage.setItem("couponId", id);
        $scope.DiscountMoney = money.toFixed(2);
        $scope.ShouldMoney = ($scope.OrderInfo.totalAmount / 1000 - money).toFixed(2) < 0 ? 0.00 : ($scope.OrderInfo.totalAmount / 1000 - money).toFixed(2);
        storage.setItem("ShouldMoney", $scope.ShouldMoney);
    }

    $scope.TimeDiff = function (createTime) {
        //已s为单位

        createTime = new Date(createTime.replace(/-/g, "/"));//replace方法将-转为/
        var time = $interval(function () {
            timeFn(createTime);
            $scope.text = (23 - $scope.hours) + ":" + (59 - $scope.minutes) + ":" + (60 - $scope.seconds);
            if ($scope.n == 0) {
                $interval.cancel(time);
                $scope.isDisable = false;
                //$scope.text = "可以点击";
            }

        }, 1000);
    }

    function timeFn(d1) {
        //di作为一个变量传进来
        //如果时间格式是正确的，那下面这一步转化时间格式就可以不用了
        var dateBegin = new Date(d1);//将-转化为/，使用new Date
        var dateEnd = new Date();//获取当前时间
        var dateDiff = dateEnd.getTime() - dateBegin.getTime();//时间差的毫秒数
        var dayDiff = Math.floor(dateDiff / (24 * 3600 * 1000));//计算出相差天数
        var leave1 = dateDiff % (24 * 3600 * 1000)    //计算天数后剩余的毫秒数
        $scope.hours = Math.floor(leave1 / (3600 * 1000))//计算出小时数
        //计算相差分钟数
        var leave2 = leave1 % (3600 * 1000)    //计算小时数后剩余的毫秒数
        $scope.minutes = Math.floor(leave2 / (60 * 1000))//计算相差分钟数
        //计算相差秒数
        var leave3 = leave2 % (60 * 1000)      //计算分钟数后剩余的毫秒数
        $scope.seconds = Math.round(leave3 / 1000)
    }

});