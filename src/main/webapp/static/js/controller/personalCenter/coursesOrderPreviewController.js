myApp.controller('coursesOrderPreviewController', function ($scope, $http,$compile) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];
    $scope.courseId = [];
    if (!window.localStorage) {
        alert("浏览器支持localstorage");
    } else {
        storage = window.localStorage;
    }

});