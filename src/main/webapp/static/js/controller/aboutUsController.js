myApp.controller('aboutUsController', function ($scope, $http) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];
    $scope.visible = false;
    if (!window.localStorage) {
        alert("浏览器不支持localstorage");
    } else {
        storage = window.localStorage;
    }
    storage.setItem("navigationId", "5");
    //导航栏样式
    $("#nav li").each(function (index, value) {
        if (storage.getItem("navigationId") != null) {
            if (storage.getItem("navigationId") == index && index < 6) {
                $(this)[0].className = "fl rel cur";
                // "m" + (index + 1) + "-borderBottom" + (index + 1);
            } else {
                $(this)[0].className = "fl rel";
            }
        }
        $(this).click(function () {
            storage.setItem("navigationId", index);
            $("#nav li").each(function (indexTemp, value) {
                if (storage.getItem("navigationId") == indexTemp && indexTemp < 6) {
                    $(this)[0].className = "fl rel cur";
                } else {
                    $(this)[0].className = "fl rel";
                }
            });

            //底部导航栏
            $("#footH li").each(function (index, value) {
                if (storage.getItem("navigationId") != null) {
                    if (storage.getItem("navigationId") == index && index < 6) {
                        $(this)[0].className = "fl rel cur";
                    } else {
                        $(this)[0].className = "fl rel";
                    }
                }
            });
        });
    });
    //底部导航栏
    $("#footH li").each(function (index, value) {
        $(this).click(function () {
            storage.setItem("navigationId", index);
            $("#footH li").each(function (index, value) {
                if (storage.getItem("navigationId") != null) {
                    if (storage.getItem("navigationId") == index && index < 6) {
                        $(this)[0].className = "fl rel cur";
                    } else {
                        $(this)[0].className = "fl rel";
                    }
                }
            });
            //头部导航
            $("#nav li").each(function (indexTemp, value) {
                if (storage.getItem("navigationId") == indexTemp && indexTemp < 6) {
                    $(this)[0].className = "fl rel cur";
                } else {
                    $(this)[0].className = "fl rel";
                }
            });
        });
        //首次加载
        if (storage.getItem("navigationId") != null) {
            if (storage.getItem("navigationId") == index && index < 6) {
                $("#footH li").each(function (index, value) {
                    if (storage.getItem("navigationId") != null) {
                        if (storage.getItem("navigationId") == index && index < 6) {
                            $(this)[0].className = "fl rel cur";
                        } else {
                            $(this)[0].className = "fl rel";
                        }
                    }
                });
            }
        }
    });
});
