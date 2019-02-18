myApp.controller('teacherController', function ($scope, $http) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];
    $scope.visible = false;
    if (!window.localStorage) {
        alert("浏览器不支持localstorage");
    } else {
        storage = window.localStorage;
    }
    storage.setItem("navigationId", "2");
    $scope.beijingId = parseInt(storage.getItem('beijing'));
    $scope.shanghaiId = parseInt(storage.getItem('shanghai'));
    $scope.schoolName = storage.getItem('schoolName');

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

    var schoolId = getQueryString("schoolId");
    var schoolName = getQueryString("schoolName");
    $scope.schoolId = schoolId;
    $scope.schoolName = schoolName;
    if (schoolId != 0) {
        storage.setItem("schoolId", schoolId);
        storage.setItem("schoolName", schoolName);
    }


    $scope.SelectCampusList = function () {
        $.ajax(
            {
                url: $scope.baseurl + "/campus/show/list",
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        $scope.campusList = resdata.data;
                        angular.forEach($scope.campusList, function (value, key) {
                            if (value.campusName.toLowerCase().indexOf("北京") > -1) {
                                $scope.beijingInfo = value;
                            }
                            if (value.campusName.toLowerCase().indexOf("南京") > -1) {
                                $scope.shanghaiInfo = value;
                            }
                        });
                    }
                }
            });
    }
    $scope.SelectCampusList();


    //tab样式
    if (storage.getItem('schoolId') != null && storage.getItem('schoolId') != "" && storage.getItem('schoolId') != "null") {
        if ($scope.schoolName == "nanjing") {
            $("#sh").addClass('select').siblings().removeClass('select');
            $scope.SelectTeacher($scope.shanghaiInfo.id);
        } else if ($scope.schoolName == "beijing") {
            $("#bj").addClass('select').siblings().removeClass('select');
            $scope.SelectTeacher($scope.beijingInfo.id);
        } else {
            //默认全部
            $("#qb").addClass('select').siblings().removeClass('select');
            $scope.SelectTeacher("0");
        }
    } else {
        //默认全部
        $("#qb").addClass('select').siblings().removeClass('select');
        $scope.SelectTeacher("0");
    }

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
