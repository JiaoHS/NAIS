myApp.controller('protocolController', function ($scope, $http) {
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
    $scope.Init();
});