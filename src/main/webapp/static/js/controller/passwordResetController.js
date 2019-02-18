myApp.controller('passwordResetController', function ($scope, $http) {
    var storage;
    $scope.Init = function () {
        $scope.baseurl = getApiUrl();
        $scope.FilterPanel = [];
        $scope.visible = false;
        if (!window.localStorage) {
            alert("浏览器不支持localstorage");
        } else {
            storage = window.localStorage;
        }
    }
    $scope.update = function () {
        $scope.check2();
        $scope.check1();
        $scope.check4();
        if ($(".reg-promopt1").css("display") == "block" || $(".reg-promopt2").css("display") == "block" || $(".reg-promopt4").css("display") == "block") {
            return;
        }
        $scope.visible = true;
        var code = storage.getItem("code");
        if (code == "" || code == undefined || code == null) {
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
            $scope.check3(code);
            if ($(".reg-promopt3").css("display") == "block") {
                return;
            }
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
                    storage.clear();
                    var url = resdata.data.data;
                    window.location.href = $scope.baseurl + "/user/home#/personHome";//暂时跳转个人中心
                } else {
                    alert(resdata.data.info);
                }
            })
        }
    }

    //一系列校验方法
    //对电子邮件的验证
    $scope.check1 = function () {
        var temp = $scope.useracount;
        var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/
        if (!myreg.test(temp)) {
            $(".reg-promopt1").css("display", "block")
        } else {
            $(".reg-promopt1").css("display", "none")
        }
    }

    //两次密码是否一致校验
    $scope.check2 = function () {
        if ($scope.userpwd == $scope.userrepwd) {
            $(".reg-promopt2").css("display", "none")
        } else {
            $(".reg-promopt2").css("display", "block")
        }
    }
    //验证密码是否字母数字组成
    $scope.check4 = function () {
        var temp = $scope.userpwd;
        var myreg = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,10}$/
        if (!myreg.test(temp)) {
            $(".reg-promopt4").css("display", "block")
        } else {
            $(".reg-promopt4").css("display", "none")
        }
    }

    //验证码校验
    $scope.check3 = function (str) {
        str = storage.getItem("code");
        var IsBy = true;
        if ($scope.userTxtidcode == "" || $scope.userTxtidcode == undefined) {
            IsBy = false;
        } else {
            if ($scope.userTxtidcode == str) {
                IsBy = true;
            } else {
                IsBy = false;
            }
        }

        if (IsBy) {
            $(".reg-promopt3").css("display", "none")
        } else {
            $(".reg-promopt3").css("display", "block")
            return
        }
    }

    $scope.Init();
});