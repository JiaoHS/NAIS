myApp.controller('campusController', function ($scope, $http, $q, $compile) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];
    $scope.visible = false;
    $scope.imageUrl = "";
    if (!window.localStorage) {
        alert("浏览器不支持localstorage");
    } else {
        storage = window.localStorage;
    }
    storage.setItem("navigationId", "1");
    $scope.schoolId = storage.getItem('schoolId')
    $scope.schoolName = storage.getItem('schoolName');
    $scope.beijingId = (storage.getItem('beijing'));
    $scope.shanghaiId = (storage.getItem('shanghai'));

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
    storage.setItem("schoolId", schoolId);
    storage.setItem("schoolName", schoolName);
    $scope.schoolBox = function () {
        $http({
            method: "post",
            url: $scope.baseurl + "/campus/show/list",
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.schoolBoxList = new Array();
                $scope.schoolBoxList = resdata.data.data;
                var i = 0;
                angular.forEach($scope.schoolBoxList, function (value, key) {

                    // if ($scope.schoolId != null && $scope.schoolId != "") {
                    //
                    //     if ($scope.schoolId == value.id) {
                    //         i = 1;
                    //         $("#sh").addClass('select').siblings().removeClass('select');
                    //         $(".infoItem").eq(i).show().siblings().hide();
                    //     } else {
                    //         i = 0;
                    //         $("#bj").addClass('select').siblings().removeClass('select');
                    //         $(".infoItem").eq(i).show().siblings().hide();
                    //     }
                    //     i = 0;
                    //     $(".detailCon .detailItem").eq(i).addClass('cur').siblings().removeClass('cur');
                    // } else {
                    //     //默认北京
                    //     i = 0;
                    //     $("#bj").addClass('select').siblings().removeClass('select');
                    //     $(".infoItem").eq(i).show().siblings().hide();
                    //     $(".detailCon .detailItem").eq(i).addClass('cur').siblings().removeClass('cur');
                    // }

                });

            } else {
            }
        });
    }
    $scope.schoolBox();
    $scope.uploadFile2 = function (courseId) {
        var url = $scope.courseDocList[courseId];
        if ((url == null || url == NaN || url == "")) {
            return false;
        } else {
            downloadFile($scope.baseurl + "/" + url);
        }
    }
    //通过校区名称查询
    $scope.SelectCampus = function (campusid) {
        $scope.campusid = campusid;
        //x校区信息
        $.ajax(
            {
                url: $scope.baseurl + "/campus/show/list/select?id=" + $scope.campusid,
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        $scope.campusInfoList = resdata.data[0];
                        $scope.imageUrl = $scope.campusInfoList.campusBannerPhoto;
                    }
                }
            });
        $.ajax(
            {
                url: $scope.baseurl + "/professorList/all?schoolId=" + $scope.campusid + "&page=" + 1 + "&rows=" + 8,
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        $scope.teacherList = resdata.data.list;
                    }
                }
            });
        $.ajax(
            {
                url: $scope.baseurl + "/campusCourse/show?campusId=" + $scope.campusid,
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        $scope.CourseList = angular.fromJson(resdata.data);
                        var html = "";
                        var count = 0;
                        $scope.courseDocList = new Array();
                        angular.forEach($scope.CourseList, function (value, key) {
                            count = value.list.length;

                            html += '<div class="list time fl abs"><div class="timeCon abs">' + (value.timeSpan == null ? "" : value.timeSpan) + '</div></div><div class="list name fl f24">';
                            angular.forEach(value.list, function (va, key) {
                                $scope.courseDocList[va.id] = va.courseAttach;
                            });
                            html += '</div>';
                        });
                    }
                }
            });
    }
    $scope.FormatDateTime = function (time) {
        if (time == undefined || time == "undefined") {
            return false;
        }
        var temp = time.substr(0, 10);
        return temp.split('-')[0] + '.' + temp.split('-')[1] + '.' + temp.split('-')[2];
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
    if (storage.getItem('schoolId') != null && storage.getItem('schoolId') != "" && storage.getItem('schoolId') != "null") {
        $scope.SelectCampus(storage.getItem('schoolId'));
    } else {
        $scope.SelectCampus($scope.beijingInfo.id);
    }
    //默认tab的样式
    if (storage.getItem('schoolId') != null && storage.getItem('schoolId') != "" && storage.getItem('schoolId') != "null") {
        var i = 0;
        if ($scope.schoolName == "nanjing") {
            i = 1;
            $("#sh").addClass('select').siblings().removeClass('select');
            $(".infoItem").eq(i).show().siblings().hide();
            $scope.SelectCampus($scope.shanghaiInfo.id);
        } else if ($scope.schoolName == "beijing") {
            i = 0;
            $("#bj").addClass('select').siblings().removeClass('select');
            $(".infoItem").eq(i).show().siblings().hide();
            $scope.SelectCampus($scope.beijingInfo.id);
        }
        i = 0;
        $(".detailCon .detailItem").eq(i).addClass('cur').siblings().removeClass('cur');

    } else {
        //默认北京
        var i = 0;
        $("#bj").addClass('select').siblings().removeClass('select');
        $(".infoItem").eq(i).show().siblings().hide();
        $(".detailCon .detailItem").eq(i).addClass('cur').siblings().removeClass('cur');
        //$scope.SelectCampus(storage.getItem('schoolId'));
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
window.downloadFile = function (sUrl) {

    //iOS devices do not support downloading. We have to inform user about this.
    if (/(iP)/g.test(navigator.userAgent)) {
        alert('Your device does not support files downloading. Please try again in desktop browser.');
        return false;
    }

    //If in Chrome or Safari - download via virtual link click
    if (window.downloadFile.isChrome || window.downloadFile.isSafari) {
        //Creating new link node.
        var link = document.createElement('a');
        link.href = sUrl;

        if (link.download !== undefined) {
            //Set HTML5 download attribute. This will prevent file from opening if supported.
            var fileName = sUrl.substring(sUrl.lastIndexOf('/') + 1, sUrl.length);
            link.download = fileName;
        }

        //Dispatching click event.
        if (document.createEvent) {
            var e = document.createEvent('MouseEvents');
            e.initEvent('click', true, true);
            link.dispatchEvent(e);
            return true;
        }
    }

    // Force file download (whether supported by server).
    if (sUrl.indexOf('?') === -1) {
        sUrl += '?download';
    }

    window.open(sUrl, '_self');
    return true;
}

window.downloadFile.isChrome = navigator.userAgent.toLowerCase().indexOf('chrome') > -1;
window.downloadFile.isSafari = navigator.userAgent.toLowerCase().indexOf('safari') > -1;

