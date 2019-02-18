myApp.controller('applicationController', function ($scope, $http) {
    var storage;
    $scope.baseurl = getApiUrl();
    // $scope.pager = {};
    // $scope.visible = true;
    // $scope.visiblePerson = false;
    // $scope.visibleregister = true;
    //$scope.FilterPanel = [];
    if (!window.localStorage) {
        alert("浏览器支持localstorage");
    } else {
        storage = window.localStorage;
        //storage.clear();
    }
    storage.setItem("navigationId", "3");
    var i = 0;

    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var url = this.location.href;
        if (url.indexOf("?") != -1) {
            strs = url.split("?");
            r = '?' + strs[1];
            r = r.substr(1);
            r = r.match(reg);
            if (r != null) return unescape(r[2]);
            return null;
        } else {
            return null;
        }
    }

    $scope.tabId = getQueryString("id");
    storage.setItem("appTabId", $scope.tabId);
    if (storage.getItem('appTabId') != null && storage.getItem('appTabId') != "" && storage.getItem('appTabId') != "null") {
        if ($scope.tabId == 7) {
            i = 0;
            $("#app1").addClass('select').siblings().removeClass('select');
        } else if ($scope.tabId == 8) {
            i = 1;
            $("#app2").addClass('select').siblings().removeClass('select');
        } else if ($scope.tabId == 9) {
            i = 2;
            $("#app3").addClass('select').siblings().removeClass('select');
        } else {
            i = 0;
            $("#app1").addClass('select').siblings().removeClass('select');
        }
        $(".topBanner li").eq(i).show().siblings().hide();
        //.eq(i).addClass('show').siblings().removeClass('show');
        $(".infoItem").eq(i).show().siblings().hide();
        //.eq(i).addClass('cur').siblings().removeClass('cur');
        //$(".detailCon .detailItem").eq(i).addClass('cur').siblings().removeClass('cur');
    } else {
        i = 0;
        $("#app1").addClass('select').siblings().removeClass('select');
        $(".topBanner li").eq(i).show().siblings().hide();
        $(".infoItem").eq(i).show().siblings().hide();
    }

    $(".tab").on("click", "li", function () {
        var i = $(this).index();
        $(this).addClass('select').siblings().removeClass('select');
        $(".topBanner li").eq(i).show().siblings().hide();
        $(".infoItem").eq(i).show().siblings().hide();
    })
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
