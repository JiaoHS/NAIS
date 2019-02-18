myApp.controller('payFailController', function ($scope, $http) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];

    if (!window.localStorage) {
        alert("浏览器支持localstorage");
    } else {
        storage = window.localStorage;
    }
    storage.setItem("Selected", "payFail");
    //清除 storage
    storage.removeItem("ShouldMoney");
    storage.removeItem("couponId");
    storage.removeItem("ShouldMoney");
    storage.removeItem("paymentSeq");
    storage.removeItem("tabId");
    storage.removeItem("chk");
    storage.removeItem("CouponCreateTime");

    $scope.OrderId = storage.getItem("orderId");
    //根据orderId查询成功后的信息
    $http({
        method: "post",
        url: $scope.baseurl + "/order/single?id=" + $scope.OrderId,
        dataType: "json",
        data: JSON.stringify($scope.FilterPanel),
        headers: {"Content-Type": "application/json;charset=utf-8"}
    }).then(function (data) {
        var resdata = angular.fromJson(data);
        if (resdata.data.code == 0) {//成功
            $scope.OrderInfo = resdata.data.data;
            storage.removeItem("orderId");
        } else {
            alert(resdata.data.info);
        }
        storage.removeItem("Selected");
    });
});