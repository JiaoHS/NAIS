myApp.controller('infoListController', function ($scope, $http) {
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
    //通过校区名称查询
    $scope.GetInfoList = function () {
        $http({
            method: "post",
            url: $scope.baseurl + "/info/show/list",
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.infoList = resdata.data.data;
            } else {
            }
        });
    }
    $scope.Init();
    $scope.GetInfoList();
    $scope.GetDetail=function (infoId) {
        storage.setItem("infoId", infoId);
        window.location.href = $scope.baseurl + "/#/infoDetail";
    }
});
