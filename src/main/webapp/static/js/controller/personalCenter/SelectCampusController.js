myApp.controller('SelectCampusController', function ($scope, $http) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];
    if (!window.localStorage) {
        alert("浏览器不支持localstorage");
    } else {
        storage = window.localStorage;
    }
    //校区选择
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
            } else {
                alert(resdata.data.info);
            }
        });
    }
    $scope.schoolBox();

    $scope.SchoolDetail = function (schoolId) {
        //加入缓存
        storage.setItem("schoolId", schoolId);
        //跳转
        window.location.href = $scope.baseurl + "/user/home#/studentSystem";
    }
});
