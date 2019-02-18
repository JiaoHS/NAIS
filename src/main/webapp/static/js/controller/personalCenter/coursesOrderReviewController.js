myApp.controller('coursesOrderReviewController', function ($scope, $http, $location) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];
    $scope.noneCouse = false;
    if (!window.localStorage) {
        alert("浏览器支持localstorage");
    } else {
        storage = window.localStorage;
    }
    //storage.clear();测试
    $(document).attr("title", "学费缴纳");

    storage.setItem("persionnavigationId", "3");
    if (storage.getItem("reloadd") != null) {
        if ($location.absUrl().indexOf("personHome") > -1) {
            $scope.isShow = true;
            $scope.TitleName1 = "首页";
            $scope.TitleName2 = "学生中心";
            storage.removeItem("reloadd");
            storage.setItem("persionnavigationId", "0");
            window.location.href = $scope.baseurl + "/user/home#/personHome";
            window.location.reload();
        }
        if ($location.absUrl().indexOf("payment") > -1) {
            $scope.isShow = false;
            $scope.TitleName1 = "学生中心";
            $scope.TitleName2 = "学生缴费";
            storage.removeItem("reloadd");
            storage.setItem("persionnavigationId", "3");
            window.location.href = $scope.baseurl + "/user/home#/payment";
            window.location.reload();
        }
    }

    $(".tabList li").each(function (index, value) {
        if (storage.getItem("persionnavigationId") != null) {
            if (storage.getItem("persionnavigationId") == index && index < 4) {
                $(this)[0].className = "rel cur";
            } else {
                $(this)[0].className = "rel";
            }
        }
    });

    $scope.isHeBing = true;
    $scope.OrderList = [];
    $scope.SkipIndex = function () {
        window.location.href = $scope.baseurl;
    }
    storage.removeItem("schoolId");
    storage.removeItem("schoolName");
    $scope.GetDetail = function (orderSource, orderId) {
        if (orderSource == 100) {//课程费用
            var w = document.documentElement.clientWidth || document.body.clientWidth;
            var h = document.documentElement.clientHeight || document.body.clientHeight;
            $(".courseShade").css({"width": w, "height": h, "display": "block"});
            //弹框内容设置
            $http({
                method: "post",
                url: $scope.baseurl + "/order/courseList?orderId=" + orderId,
                dataType: "json",
                data: JSON.stringify($scope.FilterPanel),
                headers: {"Content-Type": "application/json;charset=utf-8"}
            }).then(function (data) {
                var resdata = angular.fromJson(data);
                if (resdata.data.code == 0) {//成功
                    $scope.CourseList = resdata.data.data;
                } else {
                    alert(resdata.data.info);
                }
            });
        } else {
            return false;
        }
        $(".csb-close").click(function () {
            $(".courseShade").css("display", "none");
        })
    }


    $scope.OrderList = [];
    $scope.OrderId = storage.getItem("orderId");
    $scope.ChangeOrderStatus = function (OrderId) {
        var url = "/chooseCourse/ChangeOrderStatus?orderId=" + OrderId;
        $.ajax(
            {
                url: $scope.baseurl + url,
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功

                    }
                }
            });
    }
    //我的订单列表
    $scope.MyOrderList = [];//过滤订单列表
    $scope.GetMyOrderList = function () {
        $scope.loading = true;
        $.ajax(
            {
                url: $scope.baseurl + "/order/list/my",
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        //$scope.MyOrderList = resdata.data;
                        angular.forEach(resdata.data, function (value1, key1) {
                            if (value1.orderStatus != -1) {
                                $scope.MyOrderList.push(value1);
                            }
                        });
                    }
                }
            });
        $scope.TotalMoney = 0;
        $scope.OrderListtemp = [];
        if ($scope.MyOrderList != null && $scope.MyOrderList.length > 0) {
            var orderId = "";
            //循环我的课程列表
            $scope.orderIdList = new Array();
            var num = 0;
            angular.forEach($scope.MyOrderList, function (value, key) {
                //循环订单列表  取出订单id
                if (value.orderStatus != -1) {
                    orderId = value.id;
                    if (value.orderStatus == 1 && (value.remark == "" || value.remark == null)) {
                        $scope.TotalMoney += (value.totalAmount - value.discountAmount);
                    }

                    if (value.orderSource == 100) {
                        $.ajax(
                            {
                                url: $scope.baseurl + "/order/courseList?orderId=" + orderId,
                                dataType: "json",
                                type: "post",
                                async: false,
                                success: function (data) {
                                    var resdata = angular.fromJson(data);
                                    if (resdata.code == 0) {//成功
                                        $scope.CourseList = resdata.data;
                                        angular.forEach($scope.CourseList, function (value1, key1) {
                                            if (value1 != null) {
                                                value.receipt = value1.courseName;
                                                value.orderVersion = value1.id;
                                                if (value.orderStatus != 3 && value.orderStatus != 4) {
                                                    $scope.OrderListtemp.push(value);
                                                }

                                                if (value.remark == null || value.remark == "") {
                                                    $scope.OrderList.push(value);
                                                }
                                            }

                                        });

                                    } else {
                                        //alert(resdata.data.info);
                                    }
                                }
                            });
                    } else if (value.orderSource == 200) {
                        if (value.orderStatus != 3 && value.orderStatus != 4) {
                            $scope.OrderListtemp.push(value);
                        }
                        value.receipt = "住宿费";
                        $scope.OrderList.push(value);
                    }

                }
            });
            if ($scope.OrderListtemp == null || $scope.OrderListtemp.length <= 1) {
                $scope.isHeBing = false;
            }
        } else {
            $scope.isHeBing = false;
        }
    }
    $scope.GetMyOrderList();


    $scope.SubmitOrder = function (OrderId, CouponId) {
        var url = "/couponOrder/submit?orderId=" + OrderId + "&stockId=" + CouponId;
        if (CouponId == null || CouponId == "") {
            url = "/couponOrder/submit?orderId=" + OrderId + "&stockId=";
        }
        $.ajax(
            {
                url: $scope.baseurl + url,
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功

                    }
                }
            });
    }
    $scope.LoadOrder = function (orderids, courseId, schoolId, orderId) {
        $.ajax(
            {
                url: $scope.baseurl + "/chooseCourse/submit?orderIds=" + orderids + "&id=" + courseId + "&campusId=" + schoolId + "&orderId=" + orderId,
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        //缓存 订单 id
                        $scope.OrderInfo = resdata.data;
                        storage.setItem("orderIdd", $scope.OrderInfo.id);
                        storage.setItem("orderId", $scope.OrderInfo.id);
                        $scope.TotalMoney = $scope.OrderInfo.totalAmount;
                        storage.setItem("TotalMoney", $scope.TotalMoney);
                        $scope.DiscountMoney = 0.00;
                        storage.setItem("paymentSeq", $scope.OrderInfo.paymentSeq);
                        //storage.setItem("CouponCreateTime", $scope.OrderInfo.createTime);
                        storage.setItem("ShouldMoney", $scope.ShouldMoney);

                    } else {
                        return false;
                    }
                }
            });

    }


    //ui-sref="orderCenter"
    $scope.ToPayOrder = function (orderId, orderStatus) {
        //去支付 传订单id
        if (orderStatus == 3 || orderStatus == 4) {
            return false;
        }
        storage.setItem("orderId", orderId);
        storage.setItem("reloadd", orderId);
        if (orderId == 1) {//合并支付  未支付的合并到一个订单
            //循环所有的orderId   $scope.orderListPay
            storage.removeItem("orderId");
            $scope.TotalMoney = 0;
            var idList = '';
            var orderids = '';
            angular.forEach($scope.OrderList, function (value1, key1) {
                if (value1 != null) {
                    if (value1.orderStatus == 1) {
                        //$scope.TotalMoney += (value1.totalAmount - value1.discountAmount);
                        if (idList.indexOf(value1.orderVersion) == -1) {
                            idList += value1.orderVersion + 'i'
                        }
                        if (orderids.indexOf(value1.id) == -1) {
                            orderids += value1.id + 'i'
                        }
                        $scope.schoolId = value1.campusId;
                    }
                }
            });
            if (storage.getItem("orderIdd") != null) {
                $scope.orderId = storage.getItem("orderIdd");
            } else {
                $scope.orderId = 0;
            }
            $scope.LoadOrder(orderids.substr(0, orderids.length - 1), idList.substr(0, idList.length - 1), $scope.schoolId, $scope.orderId);
        } else {
            storage.removeItem("orderIdd");
            storage.setItem("orderId", orderId);
            $scope.SubmitOrder(orderId, "");
            angular.forEach($scope.OrderList, function (value1, key1) {
                if (value1.id == orderId) {
                    $scope.TotalMoney = value1.totalAmount - value1.discountAmount;
                    $scope.paymentSeq = value1.paymentSeq;
                    storage.setItem("paymentSeq", $scope.paymentSeq);
                }
            });
        }
        storage.setItem("TotalMoney", $scope.TotalMoney);
        //缓存orderId;
        window.location.href = $scope.baseurl + "/user/home#/payWay";
    }

});
