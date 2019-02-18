myApp.controller('hotelHomeController', function ($scope, $http, $q, $compile) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];

    if (!window.localStorage) {
        alert("浏览器支持localstorage");
    } else {
        storage = window.localStorage;
    }

    $(document).attr("title", "住宿申请");

    storage.setItem("persionnavigationId", "2");

    $(".tabList li").each(function (index, value) {
        if (storage.getItem("persionnavigationId") != null) {
            if (storage.getItem("persionnavigationId") == index && index < 4) {
                $(this)[0].className = "rel cur";
            } else {
                $(this)[0].className = "rel";
            }
        }
    });

    $scope.SelectCampus = function (campusid) {
        $scope.campusid = campusid;
        $http({
            method: "post",
            url: $scope.baseurl + "/campus/show/list/select?id=" + $scope.campusid,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.campusInfoList = resdata.data.data[0];
                var star = $scope.campusInfoList.hotalstar;
                var html = '';
                switch (star) {
                    case '1':
                        html += '<li class="fl cur"></li><li class="fl"></li><li class="fl"></li><li class="fl"></li><li class="fl"></li>'
                        break;
                    case '2':
                        html += '<li class="fl cur"></li><li class="fl cur"></li><li class="fl"></li><li class="fl"></li><li class="fl"></li>'
                        break;
                    case '3':
                        html += '<li class="fl cur"></li><li class="fl cur"></li><li class="fl cur"></li><li class="fl"></li><li class="fl"></li>'
                        break;
                    case '4':
                        html += '<li class="fl cur"></li><li class="fl cur"></li><li class="fl cur"></li><li class="fl cur"></li><li class="fl"></li>'
                        break;
                    case '5':
                        html += '<li class="fl cur"></li><li class="fl cur"></li><li class="fl cur"></li><li class="fl cur"></li><li class="fl cur"></li>'
                        break;
                }
                $('#star1').html(html);
                $('#star2').html(html);
                $scope.imageUrl = getApiUrl() + $scope.campusInfoList.campusBannerPhoto;
            } else {
                alert(resdata.data.info);
            }
        });
    }

    $scope.SelectRoomType = function () {
        if ($('#roomtypelist').hasClass('hide')) {
            $('#roomtypelist').removeClass('hide')
            $('#roomType').addClass('open');
        } else {
            $('#roomtypelist').addClass('hide');
            $('#roomType').removeClass('open');
        }

    }
    // $('#roomtypelist').
    $(".hotleList li").each(function (index, value) {
        $scope.HotelMoney = 0;
        $(this).click(function () {
            if ($(this)[0].innerHTML == '房型A') {
                $scope.HotelMoney = 1000000;
            } else if ($(this)[0].innerHTML == '房型B') {
                $scope.HotelMoney = 2000000;
            } else if ($(this)[0].innerHTML == '房型C') {
                $scope.HotelMoney = 3000000;
            } else {
                $scope.HotelMoney = 0;
            }
            $('#roomType').html($(this)[0].innerHTML);
            $('#roomtypelist').addClass('hide');
            $('#hotelmoney').html('¥ ' + $scope.HotelMoney/1000 + ' 元')
            storage.setItem('hotelmoney', $scope.HotelMoney);
            storage.setItem('hoteltype', $(this)[0].innerHTML);
        });
    });
    $scope.CheckDate = function (value) {
        //日期的正则表达式
        var reg = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
        var regExp = new RegExp(reg);
        if (!regExp.test(value)) {
            return false;
        } else {
            return true;
        }
    }
    $scope.SubmitHotelApply = function () {
        //校验
        $scope.loading = true;
        $scope.agree = $("#agree").prop("checked");
        if (!$scope.agree) {
            alert("请选择同意！");
            return false;
        }
        if ($scope.StartYear >= $scope.EndYear) {
            alert('时间填写有误！')
            return false;
        }
        if ($scope.StartYear == "" || $scope.StartYear == undefined) {
            alert("入住时间格式错误，形如:yyyy-mm-dd，请重新输入！");
            return false;
        } else {
            if ($scope.CheckDate($scope.StartYear)) {
                //$("#StartYear").addClass("hide");
            } else {
                alert("入住时间格式错误，形如:yyyy-mm-dd，请重新输入！");
                return false;
            }
        }
        if ($scope.EndYear == "" || $scope.EndYear == undefined) {
            alert("离开时间格式错误，形如:yyyy-mm-dd，请重新输入！");
            return false;
        } else {
            if ($scope.CheckDate($scope.EndYear)) {
                //$("#StartYear").addClass("hide");
            } else {
                alert("离开时间格式错误，形如:yyyy-mm-dd，请重新输入！");
                return false;
            }
        }
        if ($('#roomType').html() == '选择房型') {
            alert('请选择房型！')
            return false;
        }
        if ($scope.roomnumber == undefined || $scope.roomnumber == '') {
            $scope.roomnumber = 'no';
        }

        //先查询是否已经申请
        var isOrder = true;
        var isOrder2 = true;
        $scope.MyCourseList = function () {
            $.ajax(
                {
                    url: $scope.baseurl + "/order/list/my",
                    dataType: "json",
                    type: "post",
                    async: false,
                    success: function (data) {
                        var resdata = angular.fromJson(data);
                        if (resdata.code == 0) {//成功
                            $scope.MyOrderList = resdata.data;
                            if ($scope.MyOrderList != null && $scope.MyOrderList.length > 0) {
                                angular.forEach($scope.MyOrderList, function (value, key) {
                                    //循环订单列表  取出订单id
                                    if (value.orderStatus == 3 && value.orderSource == 200) {
                                        //已经申请  已付款或者已审核
                                        isOrder2 = false;
                                        return false;
                                    }
                                    if (value.orderStatus == 4 && value.orderSource == 200) {
                                        //已经申请  已付款或者已审核
                                        isOrder = false;
                                        return false;
                                    }
                                });
                            }
                        }
                    }
                });
        }
        $scope.MyCourseList();
        if (!isOrder) {
            alert("住宿订单正在审核...");
            return false;
        }
        if (!isOrder2) {
            alert("您已申请住宿！");
            return false;
        }
        //生成住宿订单
        $scope.schoolId = storage.getItem('schoolId');
        var remark = $scope.StartYear + 'J' + $scope.EndYear + 'J' + storage.getItem('hoteltype') + 'J' + storage.getItem('hotelmoney') + 'J' + $scope.roomnumber;
        $http({
            method: "post",
            url: $scope.baseurl + "/quarter/submit?campusId=" + $scope.schoolId + "&remark=" + remark + "&money=" + storage.getItem('hotelmoney'),
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功 跳转到 订单支付
                storage.setItem("orderId", resdata.data.data.id);
                $scope.loading = false;
                window.location.href = $scope.baseurl + "/user/home#/payment";
            } else {
                alert(resdata.data.info);
            }
        });
    }

    $scope.SubmitPay = function () {
        $http({
            method: "post",
            url: $scope.baseurl + "/quarter/submit",
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功 跳转到 订单支付
                storage.setItem("orderId", resdata.data.data.id);
                window.location.href = $scope.baseurl + "/user/home#/orderCenter";
            } else {
                alert(resdata.data.info);
            }
        });
    }

    $.ajax(
        {
            url: $scope.baseurl + "/campus/show/list",
            dataType: "json",
            type: "post",
            async: false,
            success: function (data) {
                var resdata = angular.fromJson(data);
                if (resdata.code == 0) {//成功
                    $scope.campusList = resdata.data;
                    angular.forEach($scope.campusList, function (value, key) {
                        if (value.campusName.toLowerCase().indexOf("北京") > -1) {
                            $scope.beijingInfo = value;
                        }
                        if (value.campusName.toLowerCase().indexOf("南京") > -1) {
                            $scope.shanghaiInfo = value;
                        }
                    });
                } else {
                    alert(resdata.data.info);
                }
            }
        });
    if (storage.getItem('schoolId') == null || storage.getItem('schoolId') == "") {
        $scope.cumpusId = $scope.beijingInfo.id;
        storage.setItem("schoolId", $scope.cumpusId);
        $scope.SelectCampus($scope.cumpusId);
        storage.setItem("campusnavigationId", 0);
    } else {
        $scope.SelectCampus(storage.getItem('schoolId'));
        if (storage.getItem('schoolId') == $scope.beijingInfo.id) {
            storage.setItem("campusnavigationId", 0);
        } else {
            storage.setItem("campusnavigationId", 1);
        }

    }


    $(".schoolAddr li").each(function (index, value) {
        if (storage.getItem("campusnavigationId") != null) {
            if (storage.getItem("campusnavigationId") == index && index < 2) {
                $(this)[0].className = "fl rel tc f20 select";
                // "m" + (index + 1) + "-borderBottom" + (index + 1);
            } else {
                $(this)[0].className = "fl rel tc f20";
            }
        }
        $(this).click(function () {
            storage.setItem("campusnavigationId", index);
            $(".schoolAddr li").each(function (indexTemp, value) {
                if (storage.getItem("campusnavigationId") == indexTemp && indexTemp < 2) {
                    $(this)[0].className = "fl rel tc f20 select";
                } else {
                    $(this)[0].className = "fl rel tc f20";
                }
            });

            if (index == 0) {
                //北京
                $scope.SelectCampus($scope.beijingInfo.id);
            } else if (index == 1) {
                //南京
                $scope.SelectCampus($scope.shanghaiInfo.id);
            }
        });
    });
});