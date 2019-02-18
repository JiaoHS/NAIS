myApp.controller('hotelPayController', function ($scope, $http) {
    var storage;
    $scope.Init = function () {
        $scope.baseurl = getApiUrl();
        $scope.FilterPanel = [];

        if (!window.localStorage) {
            alert("浏览器支持localstorage");
        } else {
            storage = window.localStorage;
            //storage.clear();
            return false;
        }

    }
    $scope.SkipIndex = function () {
        window.location.href = $scope.baseurl;
    }
    $scope.Init();
});