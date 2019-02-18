myApp.controller('indexhomeController', function ($scope, $http, $location, $compile) {
    var storage;
    storage = window.localStorage;
    $scope.baseurl = getApiUrl();
    $scope.nameList = new Array();
    $scope.loading = true;
    storage.setItem("navigationId", "0");
    $scope.Init = function () {
        //alert(3)
        $scope.baseurl = getApiUrl();
        $scope.pager = {};
        $scope.visible = true;
        $scope.visiblePerson = false;
        $scope.FilterPanel = [];
        if (!window.localStorage) {
            alert("浏览器支持localstorage");
        } else {
            storage = window.localStorage;
            //查看过期时间
            var timenow = new Date().getTime();
            //1000 * 60 * 60 * 24 * 7
            if (timenow - storage.getItem("time") > 1000 * 60 * 60 * 24 * 7) {//过期时间为1周  7天
                storage.clear();
                // alert(3)
                //window.location.href = $scope.baseurl;
                return false;
            } else {
                //勾选了记住密码，读取
                $scope.useracount = storage.getItem("useracount");
                $scope.userpwd = (storage.getItem("userpwd"));
                // $scope.loginSubmit(2);
            }
        }

        //检测是否登录
        $scope.useracount = storage.getItem("useracount");
        if ($scope.useracount) {
            $scope.visible = false;
            $scope.visiblePerson = true;
            $scope.photo = ((storage.getItem("photo") == undefined || storage.getItem("photo") == "") ? $scope.baseurl + '/static/images/userCenter/默认头像.png' : $scope.baseurl + storage.getItem("photo"));
        } else {
            $scope.visible = true;
            $scope.visiblePerson = false;
        }
    }
    $scope.Init();
    $scope.PersonalCenter = function () {
        //判断当前登录 用户类型
        var personType = storage.getItem("personType");
        if (personType == 1) {
            //教授
            window.location.href = $scope.baseurl + "/user/home#/teacherHome";
        } else if (personType == 2) {
            //学生
            window.location.href = $scope.baseurl + "/user/home#/personHome";
        }

        //http://localhost:8080/user/home#/teacherHome
    }
    $scope.ApplicationCenter = function () {
        window.location.href = $scope.baseurl + "/user/application#/applicationGuide";
    }
    $scope.SkipToIndex = function () {
        storage.setItem("navigationId", "0");
        window.location.href = $scope.baseurl + "/#/indexhome";
    }
    //暂时测试
    $scope.SkipLogin = function () {
        //弹窗
        $(".maskBg").css("display", "block");
        //$(".topBanner li").eq(i).show().siblings().hide();
        $('#registerBox').hide();
        $('#loginBox').show();

    }
    $scope.CloseForm = function () {
        $('#registerBox').hide();
        $('#loginBox').hide();
        $('#RetrievePwd').hide();
        $(".maskBg").css("display", "none");
    }
    $scope.RegisterForm = function () {
        $('#loginBox').hide();
        $('#registerBox').show();
    }
    $scope.RetrievePwd = function () {
        $('#loginBox').hide();
        $('#registerBox').hide();
        $('#RetrievePwd').show();
        $scope.userpwd = "";
        $scope.userpwd2 = "";
    }
    $scope.schoolBox = function () {
        $http({
            method: "post",
            url: $scope.baseurl + "/campus/show/list",
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.schoolBoxList = new Array();
                $scope.schoolBoxList = resdata.data.data;
                var html = "";

                angular.forEach($scope.schoolBoxList, function (value, key) {
                    //html = '<p class="name">' + value.campusName + '</p><p class="date">' + $scope.FormatDateTime(value.seasonStart) + '-' + $scope.FormatDateTime(value.seasonEnd) + '</p>';
                    if (value.campusNameEn.toLowerCase().indexOf("beijing") > -1) {
                        $scope.nameList[value.id] = value.campusNameEn.toLowerCase();
                        storage.setItem("beijing", value.id);
                        html += ' <div style="cursor:pointer" class="infoItem bj fl" ng-click="CumpusSkip(' + value.id + ')"><img src="' + getApiUrl() + value.campusPhoto + '" alt=""><div class="infoMsg"><div class="fl tl" id="bj"><p class="name">' + value.campusName + '</p><p class="date">' + $scope.FormatDateTime(value.seasonStart) + '-' + $scope.FormatDateTime(value.seasonEnd) + '</p></div><div class="fr tr addr"><div class="hzgb">北京</div><i class="line"></i></div></div></div>';
                    }
                    if (value.campusNameEn.toLowerCase().indexOf("nanjing") > -1) {
                        $scope.nameList[value.id] = value.campusNameEn.toLowerCase();
                        storage.setItem("shanghai", value.id);
                        html += ' <div style="cursor:pointer" class="infoItem sh fr" ng-click="CumpusSkip(' + value.id + ')"><img src="' + getApiUrl() + value.campusPhoto + '" alt=""><div class="infoMsg"><div class="fr tr" id="sh"><p class="name">' + value.campusName + '</p><p class="date">' + $scope.FormatDateTime(value.seasonStart) + '-' + $scope.FormatDateTime(value.seasonEnd) + '</p></div><div class="fl tl addr"><div class="hzgb">南京</div><i class="line"></i></div></div></div>';
                    }
                    var tmp = $compile(html)($scope);
                    $("#campusInfo").html(tmp);

                });

            } else {
                //alert(resdata.data.info);
            }
        });
    }
    $scope.CumpusSkip = function (schoolId) {
        var campusName;
        for (var key in $scope.nameList) {
            if (key == schoolId) {
                campusName = $scope.nameList[key];
            }
        }
        storage.setItem("navigationId", "1");
        //,' + value.campusName + '
        storage.setItem("schoolId", schoolId);
        storage.setItem("schoolName", campusName);
        $scope.SelectCampus(storage.getItem('schoolId'));
        window.location.href = $scope.baseurl + "/#/campus?schoolId=" + schoolId + "&schoolName=" + campusName;
    }
    $scope.TabSkip = function (schoolId, type) {
        //alert(schoolId);
        var campusName;
        for (var key in $scope.nameList) {
            if (key == schoolId) {
                campusName = $scope.nameList[key];
            }
        }
        if (type == 1 || type == 2) {
            storage.setItem("schoolName", campusName);
            storage.setItem("schoolId", schoolId);
        }

        switch (type) {
            case 1:
                if ($location.absUrl().indexOf("campus") < 1) {
                    //$scope.SelectCampus(schoolId);
                    window.location.href = $scope.baseurl + "/#/campus?schoolId=" + schoolId + "&schoolName=" + campusName;
                } else if ($location.absUrl().indexOf("campus") >= 1) {
                    //同一个页面
                    //$scope.SelectCampus(schoolId);
                    window.location.href = $scope.baseurl + "/#/campus?schoolId=" + schoolId + "&schoolName=" + campusName;
                    window.location.reload();
                    //$scope.SelectCampus(schoolId);
                }
                break;
            case 2:
                var url = '';
                if (schoolId == 0) {
                    url = $scope.baseurl + "/#/teacher?schoolId=" + schoolId;
                } else {
                    url = $scope.baseurl + "/#/teacher?schoolId=" + schoolId + "&schoolName=" + campusName;
                }
                if ($location.absUrl().indexOf("teacher") < 1) {
                    //$scope.SelectTeacher(schoolId);
                    window.location.href = url;
                } else if ($location.absUrl().indexOf("teacher") >= 1) {
                    //同一个页面
                    //$scope.SelectTeacher(schoolId);
                    window.location.href = url;
                    window.location.reload();
                }
                break;
            case 3:
                //storage.setItem("appTabId", schoolId);
                if ($location.absUrl().indexOf("application") < 1) {
                    window.location.href = $scope.baseurl + "/#/application?id=" + schoolId;
                } else if ($location.absUrl().indexOf("application") >= 1) {
                    //同一个页面
                    window.location.href = $scope.baseurl + "/#/application?id=" + schoolId;
                    window.location.reload();
                }
                break;
            case 4:
                //storage.setItem("questionTabId", schoolId);
                if ($location.absUrl().indexOf("normalQuestion") < 1) {
                    window.location.href = $scope.baseurl + "/#/normalQuestion?id=" + schoolId;
                } else if ($location.absUrl().indexOf("normalQuestion") >= 1) {
                    //同一个页面
                    window.location.href = $scope.baseurl + "/#/normalQuestion?id=" + schoolId;
                    window.location.reload();
                }
                break;
        }
    }
    //teacherBox
    $scope.teacherBox = function () {
        $http({
            method: "get",
            url: $scope.baseurl + "/professor/show/list",
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.professorBoxList = resdata.data.data;

                // var html = "";
                // angular.forEach($scope.professorBoxList, function (value, key) {
                //     html += '<div class="teacher-con"><div style="width: 208px;height: 259px;float: left;background: url(' + $scope.baseurl + value.photo + ');background-size:100% 100%"></div><div class="t-fromBox"><div class="t-fromEng">' + value.professorName + '</div><div class="t-line"></div><div class="t-fromChi">' + value.fromSchool + '</div></div><span class="t-intro">' + value.description + '</span></div>';
                // });
                // $(".teacher-box").html(html);

            } else {
                alert(resdata.data.info);
            }
        });
    }
    //advantageBox
    $scope.advantageBox = function () {
        $http({
            method: "post",
            url: $scope.baseurl + "/personalInfo/student/show",
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.advantageBoxList = resdata.data.data;
            } else {
                alert(resdata.data.info);
            }
        });
    }
    //newsBox
    $scope.newsBox = function () {
        $http({
            method: "post",
            url: $scope.baseurl + "/info/show/list/limit?limit=3",
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.newsBoxList = resdata.data.data;
                var html = "";
                angular.forEach($scope.newsBoxList, function (value, key) {
                    html += '<a href="javascript:void(0)" ng-repeat="item in newsBoxList"><div style="background: url(' + $scope.baseurl + value.titleImg + ') no-repeat;background-position: center;background-size: cover" class="banner1"></div></a>';
                });
                $(".lunbo1").html(html);
            } else {
                alert(resdata.data.info);
            }
        });
    }

    $scope.schoolBox();//校区
    $scope.teacherBox();//教师
    // $scope.advantageBox();//优势
    //$scope.newsBox();//资讯
    $scope.FormatDateTime = function (time) {
        var temp = time.substr(0, 10);
        return temp.split('-')[0] + '.' + temp.split('-')[1] + '.' + temp.split('-')[2];
    }
    Date.prototype.Format = function (fmt) { // author: meizz
        var o = {
            "M+": this.getMonth() + 1, // 月份
            "d+": this.getDate(), // 日
            "h+": this.getHours(), // 小时
            "m+": this.getMinutes(), // 分
            "s+": this.getSeconds(), // 秒
            "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
            "S": this.getMilliseconds() // 毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
    $scope.GetDetail = function (infoId) {
        storage.setItem("infoId", infoId);
        window.location.href = $scope.baseurl + "/#/infoDetail";
    }
    //导航栏样式
    $("#nav li").each(function (index, value) {
        if (storage.getItem("navigationId") != null) {
            if (storage.getItem("navigationId") == index && index < 6) {
                $(this)[0].className = "fl rel cur";
                // "m" + (index + 1) + "-borderBottom" + (index + 1);
            } else {
                $(this)[0].className = "fl rel";
            }
        }
        $(this).click(function () {
            storage.setItem("navigationId", index);
            $("#nav li").each(function (indexTemp, value) {
                if (storage.getItem("navigationId") == indexTemp && indexTemp < 6) {
                    $(this)[0].className = "fl rel cur";
                } else {
                    $(this)[0].className = "fl rel";
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
    //底部导航栏
    $("#footH li").each(function (index, value) {
        $(this).click(function () {
            storage.setItem("navigationId", index);
            $("#footH li").each(function (index, value) {
                if (storage.getItem("navigationId") != null) {
                    if (storage.getItem("navigationId") == index && index < 6) {
                        $(this)[0].className = "fl rel cur";
                    } else {
                        $(this)[0].className = "fl rel";
                    }
                }
            });
            //头部导航
            $("#nav li").each(function (indexTemp, value) {
                if (storage.getItem("navigationId") == indexTemp && indexTemp < 6) {
                    $(this)[0].className = "fl rel cur";
                } else {
                    $(this)[0].className = "fl rel";
                }
            });
        });
        //首次加载
        if (storage.getItem("navigationId") != null) {
            if (storage.getItem("navigationId") == index && index < 6) {
                $("#footH li").each(function (index, value) {
                    if (storage.getItem("navigationId") != null) {
                        if (storage.getItem("navigationId") == index && index < 6) {
                            $(this)[0].className = "fl rel cur";
                        } else {
                            $(this)[0].className = "fl rel";
                        }
                    }
                });
            }
        }
    });
    $scope.ChangeNameToId = function (name) {
        switch (name) {
            case "首页":
                return 0
                break;
            case "校区介绍":
                return 1
                break;
            case "师资团队":
                return 2
                break;
            case "申请信息":
                return 3
                break;
            case "校园生活":
                return 4
                break;
            case "关于我们":
                return 5
                break;
        }
    }

    $scope.SelectCampusList = function () {
        $http({
            method: "post",
            url: $scope.baseurl + "/campus/show/list",
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.campusList = resdata.data.data;
                angular.forEach($scope.campusList, function (value, key) {
                    if (value.campusNameEn.toLowerCase() == "beijing") {
                        $scope.beijingInfo = value;
                    }
                    if (value.campusNameEn.toLowerCase() == "nanjing") {
                        $scope.shanghaiInfo = value;
                    }
                });
            } else {
                alert(resdata.data.info);
            }
        });

    }
    $scope.SelectCampusList();
    //默认tab的样式
    if ($scope.schoolId != null && $scope.schoolId) {
        if ($scope.schoolName == "nanjing") {
            var i = 2;
            $("#sh").addClass('select').siblings().removeClass('select');
            $(".infoItem").eq(i).show().siblings().hide();
            $scope.SelectCampus($scope.shanghaiInfo.id);
        } else if ($scope.schoolName == "beijing") {
            var i = 1;
            $("#bj").addClass('select').siblings().removeClass('select');
            $(".infoItem").eq(i).show().siblings().hide();
            $scope.SelectCampus($scope.beijingInfo.id);
        }

    } else {
        //默认北京
        var i = 1;
        $("#bj").addClass('select').siblings().removeClass('select');
        $(".infoItem").eq(i).show().siblings().hide();
    }


    $scope.SelectCampus = function (campusid) {
        $scope.campusid = campusid;
        //x校区信息
        $.ajax(
            {
                url: $scope.baseurl + "/campus/show/list/select?id=" + $scope.campusid,
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        $scope.campusInfoList = resdata.data[0];
                        $scope.imageUrl = $scope.campusInfoList.campusBannerPhoto;
                    }
                }
            });
        $.ajax(
            {
                url: $scope.baseurl + "/professorList/all?schoolId=" + $scope.campusid + "&page=" + 1 + "&rows=" + 8,
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        $scope.teacherList = resdata.data.list;
                    }
                }
            });
        $.ajax(
            {
                url: $scope.baseurl + "/campusCourse/show?campusId=" + $scope.campusid,
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        $scope.CourseList = angular.fromJson(resdata.data);
                        var html = "";
                        var count = 0;
                        $scope.courseDocList = new Array();
                        angular.forEach($scope.CourseList, function (value, key) {
                            count = value.list.length;

                            html += '<div class="list time fl abs"><div class="timeCon abs">' + (value.timeSpan == null ? "" : value.timeSpan) + '</div></div><div class="list name fl f24">';
                            angular.forEach(value.list, function (va, key) {
                                $scope.courseDocList[va.id] = va.courseAttach;
                            });
                            html += '</div>';
                        });
                    }
                }
            });
    }
    $scope.SelectTeacher = function (campusid) {
        if (campusid == 0) {//所有
            $http({
                method: "post",
                url: $scope.baseurl + "/professorList/all?page=" + 1 + "&rows=" + 8,
                dataType: "json",
                data: JSON.stringify($scope.FilterPanel),
                headers: {"Content-Type": "application/json;charset=utf-8"}
            }).then(function (data) {
                var resdata = angular.fromJson(data);
                if (resdata.data.code == 0) {//成功
                    $scope.teacherList = resdata.data.data.list;
                } else {
                    //alert(resdata.data.info);
                }
            });
        } else {
            $http({
                method: "post",
                url: $scope.baseurl + "/professorList/all?schoolId=" + campusid + "&page=" + 1 + "&rows=" + 8,
                dataType: "json",
                data: JSON.stringify($scope.FilterPanel),
                headers: {"Content-Type": "application/json;charset=utf-8"}
            }).then(function (data) {
                var resdata = angular.fromJson(data);
                if (resdata.data.code == 0) {//成功
                    $scope.teacherList = resdata.data.data.list;
                } else if (resdata.data.code == -1) {
                    $scope.teacherList = "";
                }
            });
        }
    }

    $scope.loginSubmit = function (index) {
        storage.clear();
        $scope.isEmail = false;
        $scope.isPwd = false;
        //remember pwd

        //设置过期时间
        // if (index == 1) {
        //     var curTime = new Date().getTime();
        //     storage.setItem("time", curTime);
        //     storage.setItem("userpwd", ($scope.userpwd));
        // }

        //var storage=window.localStorage;
        // if ($scope.userremember) {
        //     //勾选了记住密码，现在开始写入
        //
        //     storage.setItem("chk", true);
        //     //设置过期时间
        //     if (index == 1) {
        //         var curTime = new Date().getTime();
        //         storage.setItem("time", curTime);
        //         storage.setItem("userpwd", ($scope.userpwd));
        //     }
        // } else {
        //     //没有勾选记住密码，现在开始删除账号cookie
        //     storage.removeItem("useracount");
        //     storage.removeItem("userpwd");
        //     storage.removeItem("chk");
        //     storage.removeItem("time");
        // }
        // 若为本地环境 则手写cookie
        // if (window.location.href.indexOf('localhost') != -1){
        //     storage.setItem("useracount", $scope.useracount);
        //     storage.setItem("userpwd", $scope.userpwd);
        // }
        if (index == 1) {
            $scope.check1();
            $scope.check4();
            if ($scope.isEmail == false || $scope.isPwd == false) {
                return;
            }
        }
        var email = $scope.useracount;
        var pwd = $scope.userpwd;
        $http({
            method: "post",
            url: $scope.baseurl + "/user/loginSubmit?" + "email=" + email + "&password=" + pwd,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                var url = resdata.data.data;
                //假如未勾选自动登录
                //storage.setItem("email", $scope.useracount);
                if (resdata.data.data.roleId == 1) {
                    //教授
                    storage.clear();
                    storage.setItem("useracount", $scope.useracount);
                    storage.setItem("professorId", resdata.data.data.professorId);
                    storage.setItem("personType", 1);
                    storage.setItem("LoginIsShow", true);
                    window.location.href = $scope.baseurl + "/user/home#/teacherHome";
                } else if (resdata.data.data.roleId == 2) {
                    var curTime = new Date().getTime();
                    storage.setItem("time", curTime);
                    storage.setItem("userpwd", ($scope.userpwd));


                    storage.setItem("personType", 2);
                    storage.setItem("userId", resdata.data.data.id);
                    storage.setItem("userName", resdata.data.data.nameCn);
                    storage.setItem("LoginIsShow", true);
                    storage.setItem("middleIsShowStorage", true);
                    storage.setItem("useracount", $scope.useracount);
                    storage.setItem("photo", resdata.data.data.photo);
                    window.location.href = $scope.baseurl + "/user/home#/personHome";
                } else if (resdata.data.data.roleId == 0) {
                    storage.clear();
                    storage.setItem("useracount", $scope.useracount);
                    storage.setItem("personType", 0);
                    window.location.href = $scope.baseurl + "/admin/index.html";
                }

            } else {
                storage.clear();
                $scope.visible = false;
                $scope.visiblePerson = true;
                alert(resdata.data.info);
            }
        });
    }
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

        if ($scope.userpwd == $scope.userpwdReg2) {
            $("#password2Retrieve").removeClass('errorTip');
            $("#emailMsg2PwdRetrieve").hide();
            $scope.isPwd2 = true;
        } else {
            $("#password2Retrieve").addClass('fr errorTip');
            $("#emailMsg2PwdRetrieve").show();
            $scope.isPwd2 = false;
        }
    }
    //重置
    $scope.ReSetInput = function () {
        $scope.useracount = "";
        $scope.userphone = "";
        $scope.username = "";
        $scope.userCard = "";
        $scope.userpwdReg = "";
        $scope.userpwdReg2 = "";
        $scope.userpwd = "";
    }
    //获取用户的性别

    $scope.ss1 = function (index) {
        var sex = document.getElementsByName("sex");
        var sexValue;
        if (index == "q") {
            for (var i = sex.length; i--;) {
                var el = sex[i];
                if (el.checked) {
                    sexValue = el.getAttribute("value");
                    $scope.sexValue = sexValue;
                    break;
                }
            }
        } else {
            for (var i = sex.length; i--;) {
                var el = sex[i];
                if (el.getAttribute("value") == index) {
                    el.checked = true;
                    break;
                }
            }
        }
    }
    //获取证件类型
    $scope.ss2 = function (index) {
        var cardType = document.getElementsByName("cardType");
        var paperType;
        if (index == "q") {
            for (var i = cardType.length; i--;) {
                var el = cardType[i];
                if (el.checked) {
                    paperType = el.getAttribute("value");
                    $scope.paperType = paperType;
                    break;
                }
            }
        } else {
            for (var i = cardType.length; i--;) {
                var el = cardType[i];
                if (el.getAttribute("value") == index) {
                    el.checked = true;
                    break;
                }
            }
        }
    }
    //获取用户的性别
    $scope.ss3 = function () {
        var ecSex = document.getElementsByName("ecSex");
        var ecSexValue;
        for (var i = ecSex.length; i--;) {
            var el = ecSex[i];
            if (el.checked) {
                ecSexValue = el.getAttribute("value");
                $scope.ecSexValue = ecSexValue;
                alert(ecSexValue)
                break;
            }
        }
    }
    //获取第一联系人用户的性别
    $scope.ss4 = function (index) {
        var ecSex = document.getElementsByName("ecSexH");
        var emcSexValue;
        if (index == "q") {
            for (var i = ecSex.length; i--;) {
                var el = ecSex[i];
                if (el.checked) {
                    emcSexValue = el.getAttribute("value");
                    $scope.emcSexValue = emcSexValue;
                    break;
                }
            }
        } else {
            for (var i = ecSex.length; i--;) {
                var el = ecSex[i];
                if (el.getAttribute("value") == index) {
                    el.checked = true;
                    break;
                }
            }
        }


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
    $scope.SkipIndex = function () {
        window.location.href = $scope.baseurl;
    }
    //检测
    $scope.checkEmail = function (email) {
        var mylog = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/
        if (!mylog.test(email)) {
            alert("邮箱不合法！")
            return false;
        } else {
            return true;
        }
    }
    //检测
    $scope.checkPhone = function () {
        var phonenum = $scope.userphone;
        // if (phonenum == "" || phonenum == undefined) {
        //     //未填写
        //     return true;
        // }
        var mylog = /^[1][3,4,5,7,8][0-9]{9}$/

        if (!mylog.test(phonenum)) {
            $("#phoneRegster").addClass('fr errorTip');
            $("#phoneMsgRegster").show();
            $scope.isPhone = false;
        } else {
            $("#phoneRegster").removeClass('errorTip');
            $("#phoneMsgRegster").hide();
            $scope.isPhone = true;
        }
    }
    $scope.checkName = function () {
        var username = $scope.username;
        if (username == "" || username == undefined) {
            //未填写
            $("#nameRegster").addClass('fr errorTip');
            $("#nameMsgRegster").show();
            $scope.isName = false;
        } else {
            $("#nameRegster").removeClass('errorTip');
            $("#nameMsgRegster").hide();
            $scope.isName = true;
        }
    }
    $scope.checkIdcode = function () {
        var code = $scope.userCard;
        var mylog = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/

        if (!mylog.test(code)) {
            $("#CardRegster").addClass('fr errorTip');
            $("#ncardMsgRegster").show();
            $scope.isCard = false;
        } else {
            $("#CardRegster").removeClass('errorTip');
            $("#ncardMsgRegster").hide();
            $scope.isCard = true;
        }
        // if (index == 0) {
        //     var mylog = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/
        //
        //     if (!mylog.test(code)) {
        //         alert("身份证不合法！")
        //         return false;
        //     } else {
        //         return true;
        //     }
        // }
        // if (index == 1) {
        //     var mylog = /^1[45][0-9]{7}$|G[0-9]{8}$|P\.[0-9]{7}$|S[0-9]{7,8}$|D[0-9]{7,8}$/
        //     if (!mylog.test(code)) {
        //         alert("护照不合法！")
        //         return false;
        //     } else {
        //         return true;
        //     }
        // }
        // if (index == 2) {
        //     //港澳通行证
        // }
    }
    //注册
    $scope.RegisterSubmit = function () {
        if ($scope.isName == false || $scope.isPhone == false || $scope.isPwd2 == false || $scope.isPwd == false || $scope.isEmail == false) {
            return;
        }
        $scope.sexMale = $("#sexMale").prop("checked");
        $scope.sexFamale = $("#sexFamale").prop("checked");
        if ($scope.sexMale == 1) {
            $scope.sex = 1;
        } else {
            $scope.sex = 0;
        }
        //var postData={email:$scope.useracount,password:$scope.userpwd,repwd:$scope.userrepwd,school:"",role:""};
        //http://localhost:8022/register?email=jiaohs%40163.com&password=jiao123&repwd=jiao123
        var email = $scope.useracount;
        var password = $scope.userpwd;
        $http({
            method: "post",
            url: $scope.baseurl + "/user/registerSave?email=" + $scope.useracount + "&password=" + $scope.userpwd + "&repwd=" + $scope.userpwdReg2 + "&role=" + "" + "&telCn=" + $scope.userphone + "&userName=" + $scope.username + "&idCard=" + $scope.userCard + "&sex=" + $scope.sex,
            dataType: "JSON",
            data: "",
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (response) {
            // {"code":0,"data":"/personalInfoSet.html","info":"操作成功"}
            var resdata = angular.fromJson(response)
            if (resdata.data.code == 0) {//成功
                storage.clear();
                //var url = resdata.data.data;
                //注册成功去登录
                $('#registerBox').hide();
                $('#loginBox').show();
                $scope.useracount = email;
                $scope.userpwd = password;
            } else {
                alert(resdata.data.info);
            }
        })
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
                // var url = resdata.data.data;
                window.location.href = $scope.baseurl + "/user/home#/personHome";//暂时跳转个人中心
            } else {
                alert(resdata.data.info);
            }
        })
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


});
