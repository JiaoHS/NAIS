myApp.controller('infoDetailController', function ($scope, $http) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];
    $scope.visible = false;
    storage = window.localStorage;
    //通过校区名称查询
    $scope.GetInfoDetail = function (infoId) {
        $http({
            method: "post",
            url: $scope.baseurl + "/info/show/single?id=" + infoId,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.infoDetail = resdata.data.data;
            } else {
            }
        });
    }
    var infoId = storage.getItem("infoId");
    $scope.GetInfoDetail(infoId);
});
