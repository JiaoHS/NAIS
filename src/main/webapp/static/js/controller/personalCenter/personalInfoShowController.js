myApp.controller('personalInfoShowController', function ($scope, $http, $compile) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];

    if (!window.localStorage) {
        alert("浏览器支持localstorage");
    } else {
        storage = window.localStorage;
    }
    $scope.sexValue = "";
    $scope.paperType = "";
    $scope.emcSexValue = "";
    $scope.btnName = "更改课程";
    $("#beforeChange").removeClass("hide");
    $("#afterChange").addClass("hide");
    $(document).attr("title", "控制面板");

    //更改课程
    var CourseListTotal = new Array();
    $(document).attr("title", "更改课程");

    $scope.Show = function () {
        $http({
            method: "post",
            url: $scope.baseurl + "/user/show?id=" + parseInt(storage.getItem("userId")),
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                var url = resdata.data.data;
                //个人信息是否完善
                $scope.ChName = url.nameCn;
                var names = url.nameEn.split(' ');
                if (names.length > 1) {
                    $scope.EnName1 = names[0];
                    $scope.ChName2 = names[1];
                } else {
                    $scope.EnName1 = url.nameEn;
                    $scope.ChName2 = url.nameEn;
                }
                $scope.birthday = url.birthDate.substr(0, 10);
                $scope.selectValue = url.cardtype;
                $scope.cardId = url.idCard;
                $scope.nowSchool = url.fromSchoolCn;
                $scope.StartYear = url.major;
                var address = url.homeaddress.split(',');
                if (address.length > 1) {
                    $scope.country = address[0];
                    $scope.province = address[1];
                    $scope.city = address[2];
                } else {
                    $scope.country = "";
                    $scope.province = "";
                    $scope.city = "";
                }
                var phones = url.telCn.split(',');
                if (phones.length > 1) {
                    $scope.phone1 = phones[0];
                    $scope.phone2 = phones[1];
                } else {
                    $scope.phone1 = "";
                    $scope.phone2 = "";
                }
                $scope.email = url.email;
                $scope.emeName = url.emcUser;
                $scope.emePhone = url.emcTel;
                $scope.emeChengwei = url.emcrole;
                $scope.weixin = url.wechat;
                $scope.imageSrc = url.photo;
                if ($scope.EnName1 != "" && $scope.ChName2 != "" && $scope.ChName != "" && url.gender != "" && url.birthDate != "" && url.cardtype.toString() != "" && url.idCard != "" && url.fromSchoolCn != "" && url.major != "" && url.emcgender.toString() != "" && $scope.country != "" && $scope.province != "" && $scope.city != "" && $scope.phone1 != "" && $scope.phone2 != "" && url.email != "" && url.emcUser != "" && url.emcTel != "" && url.emcrole.toString() != "" && url.wechat != "" && url.photo != "") {
                    $("#process").addClass("step2")
                } else {
                    $("#process").removeClass("step2")
                }
            } else {
                // alert(resdata.data.info);
            }
        });
    }
    $scope.Show();
    //根据couponId查找couponCode
    $scope.GetCodeById = function (couponId) {
        $http({
            method: "post",
            url: $scope.baseurl + "/coupon/getCodeById?id=" + couponId,
            dataType: "JSON",
            data: "",
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (response) {
            var resdata = angular.fromJson(response)
            if (resdata.data.code == 0) {//成功
                $scope.CouponCode = resdata.data.data;
            } else {
            }
        })
    }

    $scope.Update = function () {
        //storage.clear();
        window.location.href = $scope.baseurl + "/user/update#/personHome";
    }
    $scope.SkipIndex = function () {
        window.location.href = $scope.baseurl;
    }
    $scope.getNowFormatDate = function () {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var hour = date.getHours();
        var minu = date.getMinutes();
        var sec = date.getSeconds();
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (hour >= 1 && hour <= 9) {
            hour = "0" + hour;
        }
        if (minu >= 1 && minu <= 9) {
            minu = "0" + minu;
        }
        if (sec >= 1 && sec <= 9) {
            sec = "0" + sec;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + hour + seperator2 + minu
            + seperator2 + sec;
        return currentdate;
    }

    //查看我的课程
    $scope.MyCourseList = function () {
        $scope.isHtml = false;
        $scope.CourseListTotal = [];
        var ids = [];
        $http({
            method: "post",
            url: $scope.baseurl + "/order/list/my",
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                var html = "";
                var html2 = '';
                $scope.MyOrderList = resdata.data.data;
                if ($scope.MyOrderList != null && $scope.MyOrderList.length > 0) {

                    var orderId = "";
                    //循环我的课程列表
                    $scope.orderIdList = new Array();
                    var num = 0;
                    angular.forEach($scope.MyOrderList, function (value, key) {

                        //循环订单列表  取出订单id
                        if (value.orderStatus != -1 && value.orderSource == 100) {
                            num++;

                            // if (value.remark != null && value.remark != "") {
                            //     ids = value.remark.split("i");
                            // }
                            if (value.remark == null || value.remark == "") {
                                $scope.orderIdList.push(value);
                            }
                        }
                    });
                    if ($scope.orderIdList != null && $scope.orderIdList.length > 0) {
                        //有课成
                        $("#noCourseList").hide();
                        $("#courseList").show();
                        $(".lessonDetail").show();
                        $(".btnBuy").hide();
                        $("#changeCourse").show();
                        var step4 = true;
                        angular.forEach($scope.orderIdList, function (valueOrder, key3) {
                            $http({
                                method: "post",
                                url: $scope.baseurl + "/order/courseList?orderId=" + valueOrder.id,
                                dataType: "json",
                                data: JSON.stringify($scope.FilterPanel),
                                headers: {"Content-Type": "application/json;charset=utf-8"}
                            }).then(function (data) {
                                var resdata = angular.fromJson(data);
                                if (resdata.data.code == 0) {//成功
                                    $scope.CourseList = resdata.data.data;
                                    var indexTemp = 0;

                                    angular.forEach($scope.CourseList, function (value1, key1) {
                                        if (value1 != null) {
                                            value1.professorId = valueOrder.id;
                                            value1.status = valueOrder.orderStatus;
                                            // if (ids != null && ids.length > 0) {
                                            //     for (var i = 0; i < ids.length; i++) {
                                            //         if (ids[i] == value1.id) {
                                            //             value1.status = 3;
                                            //         }
                                            //     }
                                            // }
                                            if (step4) {
                                                if (valueOrder.orderStatus != 3 && valueOrder.orderSource == 100) {
                                                    step4 = false;
                                                }
                                            }


                                            $scope.CourseListTotal.push(value1);
                                            storage.setItem("schoolId", value1.campusId);
                                            if ($scope.CourseListTotal != null && $scope.CourseListTotal.length > 0) {
                                                $("#process").addClass("step3");
                                            } else {
                                                $("#process").removeClass("step3");
                                            }


                                            if (step4) {
                                                $("#process").addClass("step4");
                                            } else {
                                                $("#process").removeClass("step4");
                                            }
                                        }
                                    });
                                } else {
                                    //alert(resdata.data.info);
                                }
                            });
                        });


                    } else {
                        //无课程
                        $("#noCourseList").show();
                        $("#courseList").hide();
                        $(".lessonDetail").hide();
                        $(".btnBuy").show();
                        $("#changeCourse").hide();
                    }
                } else {
                    //无课程
                    $("#noCourseList").show();
                    $("#courseList").hide();
                    $(".lessonDetail").hide();
                    $(".btnBuy").show();
                    $("#changeCourse").hide();
                }
            } else {
                $scope.noneCouse = true;
                $("#noCourseList").show();
                $("#courseList").hide();
                $(".lessonDetail").hide();
                $(".btnBuy").show();
                $("#changeCourse").hide();
            }
        });
    }
    $scope.MyCourseList();
    $scope.FormatDateTime = function (time) {
        if (time == undefined || time == "undefined") {
            return false;
        }
        var temp = time.substr(0, 10);
        return temp.split('-')[0] + '.' + temp.split('-')[1] + '.' + temp.split('-')[2];
    }
    $scope.DelOrder = function (orderId, orderStatus) {
        if (orderStatus == 3 || orderStatus == 4) {
            return false;
        }
        if (orderId != null) {
            $http({
                method: "post",
                url: $scope.baseurl + "/order/abandon?ids=" + orderId,
                dataType: "json",
                data: JSON.stringify($scope.FilterPanel),
                headers: {"Content-Type": "application/json;charset=utf-8"}
            }).then(function (data) {
                var resdata = angular.fromJson(data);
                if (resdata.data.code == 0) {//成功

                    $scope.MyCourseList();
                    if ($scope.CourseListTotal == null || $scope.CourseListTotal.length <= 0) {
                        //无课程
                        $("#noCourseList").show();
                        $("#courseList").hide();
                        $(".lessonDetail").hide();
                        $(".btnBuy").show();
                        $("#changeCourse").hide();
                        storage.removeItem("schoolSelectedId");
                        $("#process").removeClass("step3");
                    }
                    // angular.forEach($scope.CourseListTotal, function (value1, key1) {
                    //     if (value1 != null) {
                    //         if (value1.id == orderId) {
                    //             $scope.CourseListTotal.pop(value1);
                    //         }
                    //     }
                    //
                    // });
                } else {
                    alert(resdata.data.info);
                }
            });

        }
    }


    $scope.MergeList = function () {
        var html = '';
        var html1 = '';
        var indexTime = 0;
        if (CourseListTotal != null && CourseListTotal.length > 0) {

            angular.forEach($scope.CourseListAll, function (CourseInfo, key3) {
                var flag3 = false;
                var flag = false;  //select
                var flag2 = "";  //checked
                var flag3 = false;  //是否付款
                var html2 = '';
                var html3 = '';
                html2 += ' <i class="arr abs"></i><ul class="baseInfo f22 clearfix"><li class="fl a">时间段</li><li class="fl b">' + CourseInfo.timeSpan + '</li><li class="fl c">&nbsp;</li><li id="courseNameId" class="fl d"></li></ul><ol class="typeInfo f22 clearfix hide"><li class="fl a">Time</li><li class="fl b">Course Name</li><li class="fl c">Instructor</li><li class="fl d">Operating</li></ol>';
                html2 += '<div class="lessonListInfo f16 c65">';
                indexTime++;
                angular.forEach(CourseInfo.list, function (info, key5) {
                    for (var key in CourseListTotal) {
                        //循环
                        if (info.id == CourseListTotal[key].id) {
                            //选中
                            flag = true;
                            flag2 = info.id;
                            if (CourseListTotal[key].status == 3 || CourseListTotal[key].status == 4) {
                                flag3 = true;
                            }
                            break;
                        }
                    }
                });
                angular.forEach(CourseInfo.list, function (info, key5) {
                    var name = 'time' + indexTime;
                    html2 += '<ul class="perList clearfix"><li class="fl a">' + CourseInfo.timeSpan + '</li><li class="fl b"><p>' + (info.courseCode == '' ? '&nbsp;' : info.courseCode) + '</p><p>' + (info.courseName == '' ? '&nbsp;' : info.courseName) + '</p></li><li class="fl c">' + (info.professorNameCn == '' ? '&nbsp;' : info.professorNameCn) + '</li><li class="fl d"><a href="">课程详情</a></li>';
                    if (flag) {//有选中的
                        if (flag2 == info.id) {//已选中的课程
                            html3 = '<li class="fl e"><input coursecouch="' + (info.courseAttach==""?"null":info.courseAttach) + '"  coursenamea="' + info.courseName + '" school="' + info.campusId + '" timespan="' + info.startTime.substr(11, 2) + '" id="' + info.id + '"  name=' + name + ' type="radio" checked></li></ul>';
                        } else {
                            if (flag3) {
                                html3 = '<li class="fl e"><input coursecouch="' + (info.courseAttach==""?"null":info.courseAttach) + '"  coursenamea="' + info.courseName + '" school="' + info.campusId + '" timespan="' + info.startTime.substr(11, 2) + '" id="' + info.id + '" name=' + name + ' type="radio" disabled></li></ul>';
                            } else {
                                html3 = '<li class="fl e"><input coursecouch="' + (info.courseAttach==""?"null":info.courseAttach) + '"  coursenamea="' + info.courseName + '" school="' + info.campusId + '" timespan="' + info.startTime.substr(11, 2) + '" id="' + info.id + '" name=' + name + ' type="radio"></li></ul>';
                            }
                        }
                    } else {
                        html3 = '<li class="fl e"><input coursecouch="' + (info.courseAttach==""?"null":info.courseAttach) + '"  coursenamea="' + info.courseName + '" school="' + info.campusId + '" timespan="' + info.startTime.substr(11, 2) + '" id="' + info.id + '" name=' + name + ' type="radio"></li></ul>';
                    }
                    html2 += html3;
                });


                html2 += '</div>';
                if (flag) {
                    html1 = '<div class="lessonDetail rel select">';
                    flag = false;
                } else {
                    html1 = '<div class="lessonDetail rel">';
                }
                html += html1 + html2 + '</div>';
            });

        } else {
            angular.forEach($scope.CourseListAll, function (CourseInfo, key3) {
                var flag3 = false;
                var flag = false;  //select
                var flag2 = "";  //checked
                var flag3 = false;  //是否付款
                var html2 = '';
                var html3 = '';
                html2 += ' <i class="arr abs"></i><ul class="baseInfo f22 clearfix"><li class="fl a">时间段</li><li class="fl b">' + CourseInfo.timeSpan + '</li><li class="fl c">&nbsp;</li><li id="courseNameId" class="fl d"></li></ul><ol class="typeInfo f22 clearfix hide"><li class="fl a">Time</li><li class="fl b">Course Name</li><li class="fl c">Instructor</li><li class="fl d">Operating</li></ol>';
                html2 += '<div class="lessonListInfo f16 c65">';
                indexTime++;
                angular.forEach(CourseInfo.list, function (info, key5) {
                    var name = 'time' + indexTime;
                    html2 += '<ul class="perList clearfix"><li class="fl a">' + CourseInfo.timeSpan + '</li><li class="fl b"><p>' + (info.courseCode == '' ? '&nbsp;' : info.courseCode) + '</p><p>' + (info.courseName == '' ? '&nbsp;' : info.courseName) + '</p></li><li class="fl c">' + (info.professorNameCn == '' ? '&nbsp;' : info.professorNameCn) + '</li><li class="fl d"><a href="">课程详情</a></li>';
                    html3 = '<li class="fl e"><input coursecouch="' + (info.courseAttach==""?"null":info.courseAttach) + '"  coursenamea="' + info.courseName + '" school="' + info.campusId + '" timespan="' + info.startTime.substr(11, 2) + '" id="' + info.id + '" name=' + name + ' type="radio"></li></ul>';
                    html2 += html3;
                });


                html2 += '</div>';
                if (flag) {
                    html1 = '<div class="lessonDetail rel select">';
                } else {
                    html1 = '<div class="lessonDetail rel">';
                }
                html += html1 + html2 + '</div>';
            });
        }
        //html += html1 + html2;
        var tmp = $compile(html)($scope);
        $("#lessonList").html(tmp);

        $(":radio").on("click", function () {
            var courseName = $(this)[0].attributes["coursenamea"].value;
            //$('#courseNameId').html(courseName);
            // $(this).parent().parent().parent().parent().children("#courseNameId").html(courseName);
            $(this).parent().parent().parent().parent().children('ul').children('#courseNameId').html(courseName);
            $(this).parent().parent().parent().parent().addClass('select');
        })
        $("#lessonList li input").each(function (index, value) {
            if ($(this)[0].checked) {
                var courseName = $(this)[0].attributes["coursenamea"].value;
                $(this).parent().parent().parent().parent().children('ul').children('#courseNameId').html(courseName);
            }
        });
    }


    $scope.CommonFun = function (cumpusId) {


        var CourseListAll = $.ajax(
            {
                url: $scope.baseurl + "/campusCourse/show?campusId=" + cumpusId,
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        $scope.CourseListAll = angular.fromJson(resdata.data);
                    }
                }
            });
        var MyCourseList = $.ajax(
            {
                url: $scope.baseurl + "/order/list/my",
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        $scope.MyOrderList = resdata.data;

                        if ($scope.MyOrderList != null) {
                            var orderId = "";
                            //循环我的课程列表
                            var orderIdList = [];
                            var ids = [];
                            angular.forEach($scope.MyOrderList, function (value, key) {
                                //循环订单列表  取出订单id
                                if (value.orderStatus != -1) {
                                    orderId = value.id;

                                    // if (value.remark != null && value.remark != "") {
                                    //     ids = value.remark.split("i");
                                    // }
                                    if (value.remark == null || value.remark == "") {
                                        orderIdList.push(value);
                                    }
                                }
                            });

                            if (orderIdList != null && orderIdList.length > 0) {
                                angular.forEach(orderIdList, function (valueOrder, key3) {
                                    $.ajax(
                                        {
                                            url: $scope.baseurl + "/order/courseList?orderId=" + valueOrder.id,
                                            dataType: "json",
                                            type: "post",
                                            async: false,
                                            success: function (data) {
                                                var resdata = angular.fromJson(data);
                                                if (resdata.code == 0) {//成功
                                                    $scope.CourseList = resdata.data;
                                                    var indexTemp = 0;

                                                    angular.forEach($scope.CourseList, function (value1, key1) {
                                                        if (value1 != null) {
                                                            value1.professorId = valueOrder.id;
                                                            value1.status = valueOrder.orderStatus;
                                                            valueOrder.paymentSeq = valueOrder.courseName;
                                                            // if (ids != null && ids.length > 0) {
                                                            //     for (var i = 0; i < ids.length; i++) {
                                                            //         if (ids[i] == value1.id) {
                                                            //             value1.status = 3;
                                                            //         }
                                                            //     }
                                                            // }
                                                            if (valueOrder.remark == null || valueOrder.remark == "") {
                                                                CourseListTotal[valueOrder.id] = value1;
                                                                storage.setItem("schoolSelectedId", value1.campusId);
                                                            }
                                                        }
                                                    });
                                                } else {
                                                }
                                            }
                                        });
                                });
                            }
                        }
                    }
                }
            });


        $.when(CourseListAll, MyCourseList).done(function () {
            //所做操作
            $scope.MergeList();
        });
    }
    $scope.ChangeLesson = function () {
        if ($scope.btnName == "返回") {
            $scope.btnName = "更改课程";
            $("#beforeChange").removeClass("hide");
            $("#afterChange").addClass("hide");
        } else {
            $scope.btnName = "返回";
            $("#beforeChange").addClass("hide");
            $("#afterChange").removeClass("hide");
        }
        // $("#beforeChange").addClass("hide");
        // $("#afterChange").removeClass("hide");
        $("#lessonList li input").each(function (index, value) {
            if ($(this)[0].checked) {
                var courseName = $(this)[0].attributes["coursenamea"].value;
                $(this).parent().parent().parent().parent().children('ul').children('#courseNameId').html(courseName);
            }
        });
        $scope.CommonFun(storage.getItem('schoolId'));
    }


    //提交申请表
    $scope.submitApply = function () {
        $scope.schoolId = storage.getItem("schoolId");
        var idList = [];
        //已选择的课程
        $("#lessonList li input").each(function (index, value) {
            if ($(this)[0].checked) {
                //$scope.idList.push($(this)[0]["id"]);
                idList[$(this)[0].attributes["timespan"].value] = $(this)[0]["id"];

                var courseName = $(this)[0].attributes["coursenamea"].value;
                $(this).parent().parent().parent().parent().children('ul').children('#courseNameId').html(courseName);
            }
        });

        //在已有的订单里 先过滤已经付款的课程
        var idList2 = [];
        var idListTemp = [];
        if (CourseListTotal != null && CourseListTotal.length > 0) {
            for (var key2 in idList) {//新的订单课程id集合

                for (var key in CourseListTotal) {//key是订单
                    if (key2 == CourseListTotal[key].startTime.substr(11, 2)) {//同一个时间段比较
                        if (CourseListTotal[key].status == 3 || CourseListTotal[key].status == 4) {//状态=3表示已付款
                            idListTemp.push(key2);
                            continue;
                        } else {
                            idList2[idList[key2]] = key;
                        }
                        idListTemp.push(key2);
                    }
                }
            }
            for (var key3 in idList) {
                if (idListTemp.indexOf(key3) > -1) {
                    continue;
                } else {
                    idList2[idList[key3]] = 0;
                }
            }
        } else {
            if (idList != null) {
                for (var key in idList) {
                    idList2[idList[key]] = 0;
                }
            } else {
                idList2 = [];
            }
        }

        if (idList2 != null) {
            angular.forEach(idList2, function (value, index) {
                $.ajax(
                    {
                        url: $scope.baseurl + "/chooseCourse/submit?id=" + index + "&campusId=" + $scope.schoolId + "&orderId=" + value,
                        dataType: "json",
                        type: "post",
                        async: false,
                        success: function (data) {
                            var resdata = angular.fromJson(data);
                            if (resdata.code == 0) {//成功
                                $scope.CourseList = resdata.data;
                                //跳转到支付页面
                                window.location.href = $scope.baseurl + "/user/home#/payment";
                                //+ "/#/pay";
                            }
                        }
                    });
            })
        } else {
            //没有新增订单跳转到支付页面
            window.location.href = $scope.baseurl + "/user/home#/payment";
        }

        //
    }

    //给每一个按钮一个点击事件

    $(":radio").on("click", function () {
        var courseName = $(this)[0].attributes["coursenamea"].value;
        //$('#courseNameId').html(courseName);
        // $(this).parent().parent().parent().parent().children("#courseNameId").html(courseName);
        $(this).parent().parent().parent().parent().children('ul').children('#courseNameId').html(courseName);
        $(this).parent().parent().parent().parent().addClass('select');
    })
    $("#lessonList li input").each(function (index, value) {
        if ($(this)[0].checked) {
            var courseName = $(this)[0].attributes["coursenamea"].value;
            $(this).parent().parent().parent().parent().children('ul').children('#courseNameId').html(courseName);
        }
    });

    $scope.DownLoadSy = function () {
        //未选择任何课程，请选择后下载
        var idList = [];
        //已选择的课程
        $("#lessonList li input").each(function (index, value) {
            if ($(this)[0].checked) {
                //$scope.idList.push($(this)[0]["id"]);
                var courseAttach = $(this)[0].attributes["coursecouch"].value;
                idList.push(courseAttach)
                //idList[$(this)[0].attributes["courseAttach"].value] = $(this)[0]["id"];
            }
        });
        if (idList != null && idList.length > 0) {
            for (var i = 0; i < idList.length; i++) {
                var url = idList[i];
                if ((url == null || url == NaN || url == ""||url=="null")) {
                  continue;
                } else {
                    downloadFile($scope.baseurl + "/" + url);
                }
            }
        } else {
            alert('未选择任何课程，请选择后下载')
            return false;
        }


    }
});
window.downloadFile = function (sUrl) {

    //iOS devices do not support downloading. We have to inform user about this.
    if (/(iP)/g.test(navigator.userAgent)) {
        alert('Your device does not support files downloading. Please try again in desktop browser.');
        return false;
    }

    //If in Chrome or Safari - download via virtual link click
    if (window.downloadFile.isChrome || window.downloadFile.isSafari) {
        //Creating new link node.
        var link = document.createElement('a');
        link.href = sUrl;

        if (link.download !== undefined) {
            //Set HTML5 download attribute. This will prevent file from opening if supported.
            var fileName = sUrl.substring(sUrl.lastIndexOf('/') + 1, sUrl.length);
            link.download = fileName;
        }

        //Dispatching click event.
        if (document.createEvent) {
            var e = document.createEvent('MouseEvents');
            e.initEvent('click', true, true);
            link.dispatchEvent(e);
            return true;
        }
    }

    // Force file download (whether supported by server).
    if (sUrl.indexOf('?') === -1) {
        sUrl += '?download';
    }

    window.open(sUrl, '_self');
    return true;
}

window.downloadFile.isChrome = navigator.userAgent.toLowerCase().indexOf('chrome') > -1;
window.downloadFile.isSafari = navigator.userAgent.toLowerCase().indexOf('safari') > -1;
