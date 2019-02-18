myApp.controller('personHomeController', function ($scope, $http, $location, AuthenticationService) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];
    if (!window.localStorage) {
        alert("浏览器支持localstorage");
    } else {
        storage = window.localStorage;
        //storage.clear();
        //return false;

    }
    $(document).attr("title", "个人中心");
    //
    // storage.setItem("persionnavigationId", "0");
    //
    // $(".tabList li").each(function (index, value) {
    //     if (storage.getItem("persionnavigationId") != null) {
    //         if (storage.getItem("persionnavigationId") == index && index < 4) {
    //             $(this)[0].className = "rel cur";
    //         } else {
    //             $(this)[0].className = "rel";
    //         }
    //     }
    // });
    if ($location.absUrl().indexOf("personHome") > -1) {
        storage.setItem("persionnavigationId", "0");
    }
    if ($location.absUrl().indexOf("apply") > -1) {
        storage.setItem("persionnavigationId", "1");
    }
    if ($location.absUrl().indexOf("hotelHome") > -1) {
        storage.setItem("persionnavigationId", "2");
    }
    if ($location.absUrl().indexOf("payment") > -1) {
        storage.setItem("persionnavigationId", "3");
    }
    // if ($location.absUrl().indexOf("personHome") > -1 || $location.absUrl().indexOf("apply") > -1 || $location.absUrl().indexOf("payment") > -1 || $location.absUrl().indexOf("hotelHome") > -1) {
    //     $scope.isShow = true;
    //     $scope.TitleName1 = "首页";
    //     $scope.TitleName2 = "学生中心";
    // }
    if ($location.absUrl().indexOf("payWay") > -1) {
        $scope.isShow = false;
        $scope.TitleName1 = "学生中心";
        $scope.TitleName2 = "学生缴费";
    } else {
        $scope.isShow = true;
        $scope.TitleName1 = "首页";
        $scope.TitleName2 = "学生中心";
    }

    $scope.SkipIndex = function () {

        // if ($location.absUrl().indexOf("personHome") > -1) {
        //     window.location.href = $scope.baseurl;
        //     window.location.reload();
        // }
        if ($location.absUrl().indexOf("payWay") > -1) {
            storage.setItem("persionnavigationId", "0");
            window.location.href = $scope.baseurl + "/user/home#/personHome";

            window.location.reload();
        } else {
            window.location.href = $scope.baseurl;
        }
    }

    $scope.GetPersonInfo = function () {
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
                $scope.username = url.nameCn;
                $scope.imageSrc = url.photo == "" ? "/static/images/userCenter/默认1.png" : url.photo;

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
                $scope.addressVal = $scope.country + "-" + $scope.province + "-" + $scope.city;
                $scope.schoolVal = url.fromSchoolCn;
            } else {
            }
        });
    }
    $scope.GetPersonInfo();
    $scope.CloseForm = function () {
        $('#RetrievePwd').hide();
        $(".maskBg").css("display", "none");
    }
    $scope.ChangePwd = function () {
        $(".maskBg").css("display", "block");
        $('#RetrievePwd').show();
        $scope.userpwd = "";
        $scope.userpwd2 = "";
    }
    //修改密码
    $scope.ModifyPwd = function () {
        //校验
        $scope.check1();//邮箱
        $scope.check4();//密码
        $scope.checkPwdSame();//验证密码是否一致
        $scope.checkCode();
        if ($scope.isPwd2 == false || $scope.isPwd == false || $scope.isEmail == false || $scope.isCode == false) {
            return false;
        }
        //发送后台
        var password = $scope.userpwd;
        $http({
            method: "post",
            url: $scope.baseurl + "/user/passwordResetSubmit?password=" + password,
            dataType: "JSON",
            data: "",
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (response) {
            var resdata = angular.fromJson(response)
            if (resdata.data.code == 0) {//成功
                $('#RetrievePwd').hide();
                $(".maskBg").css("display", "none");
                window.location.href = $scope.baseurl + "/user/home#/personHome";//暂时跳转个人中心
            } else {
                alert(resdata.data.info);
            }
        })
    }

    //
    //验证邮箱
    $scope.check1 = function () {
        var temp = $scope.useracount;
        var mylog = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/
        if (!mylog.test(temp)) {
            $("#email").addClass('fr errorTip');
            $("#emailMsg").show();

            $("#emailRegster").addClass('fr errorTip');
            $("#emailMsgRegster").show();

            $("#emailRetrieve").addClass('fr errorTip');
            $("#emailMsgRetrieve").show();
            $scope.isEmail = false;
        } else {
            $("#email").removeClass('errorTip');
            $("#emailMsg").hide();

            $("#emailRegster").removeClass('errorTip');
            $("#emailMsgRegster").hide();

            $("#emailRetrieve").removeClass('errorTip');
            $("#emailMsgRetrieve").hide();
            $scope.isEmail = true;
        }
    }
    $scope.checkCode = function () {
        var str = storage.getItem("code");
        if ($scope.userTxtidcode == "" || $scope.userTxtidcode == undefined) {
            //没填写
            $("#emailRetrieveCode").addClass('fr errorTip');
            $("#emailMsgRetrieveCode").show();
            $scope.isCode = false;
        } else {
            if ($scope.userTxtidcode == str) {
                $("#emailRetrieveCode").removeClass('errorTip');
                $("#emailMsgRetrieveCode").hide();
                $scope.isCode = true;
            } else {
                $("#emailRetrieveCode").addClass('fr errorTip');
                $("#emailMsgRetrieveCode").show();
                $scope.isCode = false;
            }
        }
    }

    //邮箱验证
    var clock = '';
    var nums = 120;
    var btn = $("#emailRetrieveBtn");

    function sendCode(thisBtn) {
        btn = thisBtn;
        btn.prop("disabled", true); //将按钮置为不可点击
        btn.val("重新发送(" + nums + ")");
        clock = setInterval(doLoop, 1000); //一秒执行一次
    }

    function doLoop() {
        nums--;
        if (nums > 0) {
            btn.val("重新发送(" + nums + ")");
        } else {
            clearInterval(clock); //清除js定时器
            btn.prop("disabled", false);
            btn.val('免费邮箱验证');
            nums = 120; //重置时间
        }
    }

    $scope.EmailCheck = function () {
        $scope.check1();
        if ($scope.isEmail) {

            sendCode(btn);

            // countdown = 60;
            // DaoJiShi();
            //发送邮件，置灰按钮  可点击就发送一次
            var code = storage.getItem("code");
            var email = $scope.useracount;
            $http({
                method: "post",
                url: $scope.baseurl + "/user/emailVerify?" + "email=" + email,
                dataType: "json",
                data: JSON.stringify($scope.FilterPanel),
                headers: {"Content-Type": "application/json;charset=utf-8"}
            }).then(function (data) {
                var resdata = angular.fromJson(data);
                if (resdata.data.code == 0) {//成功
                    code = resdata.data.data;//验证码  加入缓存
                    storage.setItem("code", code);
                } else {
                    alert(resdata.data.info);
                }
            });
        } else {
            return false;
        }
    }
    //验证密码是否字母数字组成
    $scope.check4 = function () {
        var temp = $scope.userpwd;
        var myreg = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,10}$/
        if (!myreg.test(temp)) {
            $("#password").addClass('fr errorTip');
            $("#emailMsgPwd").show();

            $("#passwordRegater").addClass('fr errorTip');
            $("#MsgPwdReg").show();

            $("#passwordRetrieve").addClass('fr errorTip');
            $("#emailMsgPwdRetrieve").show();
            $scope.isPwd = false;
        } else {
            $("#password").removeClass('errorTip');
            $("#emailMsgPwd").hide();

            $("#passwordRegater").removeClass('errorTip');
            $("#MsgPwdReg").hide();

            $("#passwordRetrieve").removeClass('errorTip');
            $("#emailMsgPwdRetrieve").hide();
            $scope.isPwd = true;
        }
    }
    //两次密码是否一致校验
    $scope.checkPwdSame = function () {
        if ($scope.userpwd == $scope.userpwdReg2) {
            $("#passwordRegater2").removeClass('errorTip');
            $("#MsgPwdReg2").hide();
            $scope.isPwd2 = true;
        } else {
            $("#passwordRegater2").addClass('fr errorTip');
            $("#MsgPwdReg2").show();
            $scope.isPwd2 = false;
        }

        if ($scope.userpwd == $scope.userpwd2) {
            $("#password2Retrieve").removeClass('errorTip');
            $("#emailMsg2PwdRetrieve").hide();
            $scope.isPwd2 = true;
        } else {
            $("#password2Retrieve").addClass('fr errorTip');
            $("#emailMsg2PwdRetrieve").show();
            $scope.isPwd2 = false;
        }
    }
    // if ($location.absUrl().indexOf("courseArrangeId") > 1 && $location.absUrl().indexOf("campusId") > 1 && $location.absUrl().indexOf("studentId") > 1) {
    //     //不包含导航 后台调用
    //     window.location.href = $location.absUrl();
    //     return false;
    // } else {
    //     storage.setItem("middleIsShowStorage", true);
    //     storage.setItem("LoginIsShow", true);
    // }
    var promiseGetUser = AuthenticationService.GetCurrentUser();
    promiseGetUser.then(function (data) {
        if (data && data.Id && (data.type == 2 || data.type == 1)) {
            //window.location.href = $location.absUrl();
            //$scope.UserId = data.Id;
            //当前登陆且
        } else {
            window.location.href = $scope.baseurl;
        }
    }, function (err) {
        alert(err.status);
    });


    // if (storage.getItem("middleIsShowStorage") == "true") {
    //     $scope.middleIsShow = true;
    // } else {
    //     $scope.middleIsShow = false;
    // }
    // var personType = storage.getItem("personType");
    // if (personType == 2) {
    //     $scope.TempTitle = "学生个人中心";
    //     $scope.TempIndex = "首页";
    //     $scope.footIsShow = true;
    //     $scope.middleIsShow = true;
    // }
    // if (personType == 1) {
    //     $scope.TempIndex = "HOME";
    //     $scope.TempTitle = "Teachers' Office Center";
    //     $scope.footIsShow = false;
    //     $scope.middleIsShow = false;
    // }
    //
    // if (storage.getItem("LoginIsShow") == "true") {
    //     $scope.LoginIsShow = true;
    // } else {
    //     $scope.LoginIsShow = false;
    // }


    $scope.Quit = function () {
        storage.clear();
        window.location.href = $scope.baseurl;
    }
    $scope.ChangeTab = function (tabName) {
        var tabNameEn = '';
        switch (tabName) {
            case '个人信息':
                tabNameEn = 'personHome';
                break;
            case '课程选择':
                tabNameEn = 'protocol';
                break;
            case '我的订单':
                tabNameEn = 'coursesOrderReview';
                break;
            case '住宿选择':
                tabNameEn = 'hotelHome';
                break;
            case '优惠大厅':
                tabNameEn = 'couponHome';
                break;
            case '教育中心':
                tabNameEn = 'SelectCampus';
                break;
            default:
                tabNameEn = 'personHome';
        }
        return tabNameEn;
    }

    $scope.SkipSY = function (index) {
        switch (index) {
            case 0:
                window.location.href = $scope.baseurl;
                break;
            case 1:
                window.location.href = $scope.baseurl+ "/#/campus";
                break;
            case 2:
                window.location.href = $scope.baseurl+ "/#/teacher";
                break;
            case 3:
                window.location.href = $scope.baseurl+ "/#/application";
                break;
            case 4:
                window.location.href = $scope.baseurl+ "/#/normalQuestion";
                break;
            case 5:
                window.location.href = $scope.baseurl+ "/#/aboutUs";
                break;
        }
    }



    // $(".ps-m-left div").each(function (index, value) {
    //     $(this).click(function () {
    //         $(this)[0].className = 'Selected'
    //         storage.setItem("Selected", $(this)[0].attributes[1].nodeValue);
    //         $(this).parent().siblings().children().each(function (index, value) {
    //             value.className = 'unSelected';
    //         });
    //     })
    //
    //
    //     // $scope.schoolId = storage.getItem("schoolId");
    //     // storage.removeItem("schoolId");
    //     // storage.setItem("schoolId", schoolId);
    //     //设置默认
    //     if (storage.getItem("Selected") == null) {//第一次进来  personHome
    //         if (index == 0) {
    //             value.className = "Selected";
    //             //var tab = storage.getItem("Selected");
    //             window.location.href = $scope.baseurl + "/user/home#/personHome";
    //         }
    //     } else if (storage.getItem("Selected") == $scope.ChangeTab(value.innerHTML)) {//当前选中
    //         value.className = "Selected";
    //         $(this).parent().siblings().children().each(function (index, value) {
    //             value.className = 'unSelected';
    //         });
    //         var tab = storage.getItem("Selected");
    //         window.location.href = $scope.baseurl + "/user/home#/" + tab;
    //     } else {
    //         //跳转到具体的页面
    //         if (index == 0) {
    //             window.location.href = $scope.baseurl + "/user/home#/" + value.baseURI.substr(value.baseURI.indexOf('#') + 2);
    //             storage.setItem("Selected", value.baseURI.substr(value.baseURI.indexOf('#') + 2));
    //         }
    //
    //     }
    //
    //
    // });

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

    $(".tabList li").each(function (index, value) {
        if (storage.getItem("persionnavigationId") != null) {
            if (storage.getItem("persionnavigationId") == index && index < 4) {
                $(this)[0].className = "rel cur";
                // "m" + (index + 1) + "-borderBottom" + (index + 1);
            } else {
                $(this)[0].className = "rel";
            }
        }
        $(this).click(function () {
            storage.setItem("persionnavigationId", index);
            $(".tabList li").each(function (indexTemp, value) {
                if (storage.getItem("persionnavigationId") == indexTemp && indexTemp < 4) {
                    $(this)[0].className = "rel cur";
                } else {
                    $(this)[0].className = "rel";
                }
            });

            //底部导航栏
            $("#footH li").each(function (index, value) {
                if (storage.getItem("navigationId") != null) {
                    if (storage.getItem("navigationId") == index && index < 6) {
                        $(this)[0].className = "fl rel cur";
                    } else {
                        $(this)[0].className = "fl rel";
                    }
                }
            });
        });
    });

});