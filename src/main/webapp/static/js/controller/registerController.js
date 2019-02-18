myApp.controller('registerController', function ($scope, $http) {
    var storage;
    if (!window.localStorage) {
        alert("浏览器支持localstorage");
    } else {
        storage = window.localStorage;
    }
    $scope.Init = function () {
        $scope.baseurl = getApiUrl();
        $scope.FilterPanel = [];
        $.idcode.setCode();
        $scope.checkandrend = true;
    }
    $scope.Init();
    $scope.Skip = function () {
        window.location.href = $scope.baseurl + "/user/login";
    }
    $scope.RegisterSubmit = function () {
        $scope.check2();
        $scope.check1();
        $scope.check3();
        $scope.check4();
        $scope.check5();
        if ($(".reg-promopt1").css("display") == "block" || $(".reg-promopt2").css("display") == "block" || $(".reg-promopt3").css("display") == "block" || $(".reg-promopt4").css("display") == "block" || $(".reg-promopt5").css("display") == "block") {
            return;
        }
        //var postData={email:$scope.useracount,password:$scope.userpwd,repwd:$scope.userrepwd,school:"",role:""};
        //http://localhost:8022/register?email=jiaohs%40163.com&password=jiao123&repwd=jiao123
        var email = $scope.useracount;
        var password = $scope.userpwd;
        var repwd = $scope.userrepwd;
        $http({
            method: "post",
            url: $scope.baseurl + "/user/registerSave?email=" + email + "&password=" + password + "&repwd=" + repwd + "&role=" + "",
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
                window.location.href = $scope.baseurl + "/#/login";
            } else {
                alert(resdata.data.info);
            }
        })
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
    $scope.check3 = function () {
        var IsBy = true;
        if ($scope.userTxtidcode == "" || $scope.userTxtidcode == undefined) {
            IsBy = false;
        } else {
            if ($scope.userTxtidcode.length >= 5) {
                IsBy = $.idcode.validateCode();
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
    $scope.check5 = function () {
        if ($scope.checkandrend) {
            $(".reg-promopt5").css("display", "none")
        } else {
            $(".reg-promopt5").css("display", "block")
        }
    }

    $scope.Login = function () {
        window.location.href = $scope.baseurl + "/#/login";
    }
    $scope.Register = function () {
        window.location.href = $scope.baseurl + "/#/register";
    }
});