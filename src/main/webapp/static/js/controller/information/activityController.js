myApp.controller('activityController', function ($scope, $http) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];
    if (!window.localStorage) {
        alert("浏览器不支持localstorage");
    } else {
        storage = window.localStorage;
    }
});
