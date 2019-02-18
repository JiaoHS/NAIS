myApp.controller('loginController', function ($scope, $http) {
    var storage;
    alert(233)
    $scope.Init = function () {
        $scope.baseurl = getApiUrl();
        $scope.FilterPanel = [];
        $.idcode.setCode();

        if (!window.localStorage) {
            alert("浏览器支持localstorage");
        } else {
            storage = window.localStorage;
        }
    }
    $scope.Init();
    $scope.loginSubmit = function (index) {
        storage.clear();
        //remember pwd
        //var storage=window.localStorage;
        if ($scope.userremember) {
            //勾选了记住密码，现在开始写入

            storage.setItem("chk", true);
            //设置过期时间
            if (index == 1) {
                var curTime = new Date().getTime();
                storage.setItem("time", curTime);
                storage.setItem("userpwd", ($scope.userpwd));
            }
        } else {
            //没有勾选记住密码，现在开始删除账号cookie
            storage.removeItem("useracount");
            storage.removeItem("userpwd");
            storage.removeItem("chk");
            storage.removeItem("time");
        }
        // 若为本地环境 则手写cookie
        // if (window.location.href.indexOf('localhost') != -1){
        //     storage.setItem("useracount", $scope.useracount);
        //     storage.setItem("userpwd", $scope.userpwd);
        // }
        if (index == 1) {
            $scope.check2();
            $scope.check1();
            // if ($(".log-promopt1").css("display") == "block" || $(".log-promopt2").css("display") == "block") {
            //     return;
            // }
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
                storage.setItem("email", $scope.useracount);
                if (resdata.data.data.roleId == 1) {
                    //教授
                    storage.clear();
                    storage.setItem("useracount", $scope.useracount);
                    storage.setItem("Selected", "teacherHome");
                    storage.setItem("professorId", resdata.data.data.professorId);
                    storage.setItem("personType", 1);
                    storage.setItem("LoginIsShow", true);
                    window.location.href = $scope.baseurl + "/user/home#/teacherHome";
                } else if (resdata.data.data.roleId == 2) {
                    storage.setItem("Selected", "personHome");
                    storage.setItem("personType", 2);
                    storage.setItem("userId", resdata.data.data.id);
                    storage.setItem("userName", resdata.data.data.nameCn);
                    storage.setItem("LoginIsShow", true);
                    storage.setItem("middleIsShowStorage", true);
                    storage.setItem("useracount", $scope.useracount);
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
                $scope.visibleregister = false;
                alert(resdata.data.info);
            }
        });
    }
    //验证验证码
    $scope.check2 = function () {
        var IsBy = true;
        if ($scope.Txtidcode == "" || $scope.Txtidcode == undefined) {
            IsBy = false;
        } else {
            if ($scope.Txtidcode.length >= 5) {
                IsBy = $.idcode.validateCode();
            }
        }

        if (IsBy) {
            $(".log-promopt2").css("display", "none")
        } else {
            $(".log-promopt2").css("display", "block")
            return
        }
    }
    //验证邮箱
    $scope.check1 = function () {
        var temp = $scope.useracount;
        var mylog = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/
        if (!mylog.test(temp)) {
            $(".log-promopt1").css("display", "block")
        } else {
            $(".log-promopt1").css("display", "none")
        }
    }
});