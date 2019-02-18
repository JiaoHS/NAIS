myApp.controller('applicationGuideController', function ($scope, $http) {
    var storage;
    $scope.Init = function () {
        $scope.baseurl = getApiUrl();
        $scope.pager = {};
        $scope.visible = true;
        $scope.visiblePerson = false;
        $scope.visibleregister = true;
        $scope.FilterPanel = [];
        if (!window.localStorage) {
            alert("浏览器支持localstorage");
        } else {
            storage = window.localStorage;
            //storage.clear();
        }

        //检测是否登录
        $scope.useracount = storage.getItem("useracount");
        if ($scope.useracount) {
            $scope.visible = false;
            $scope.visiblePerson = true;
            $scope.visibleregister = false;
        }

    }
    $scope.Init();
    $scope.zuocenavigationId = 0;
    $scope.DaoHangXinxi=function (strTemp) {
        switch (strTemp) {
            case 0:
                strTemp = "<span>报名指南</span><br/><span style=\"font-size: 48px\">Registration guide</span>";
                break;
            case 1:
                strTemp = "<span>转学分指南</span><br/><span style=\"font-size: 48px\">Guide to credit</span>";
                break;
            case 2:
                strTemp = "<span>学术准则</span><br/><span style=\"font-size: 48px\">Academic standards</span>";
                break;
            case 3:
                strTemp = "<span>评分标准</span><br/><span style=\"font-size: 48px\">Grading</span>";
                break;
            case 4:
                strTemp = "<span>教学质量评估</span><br/><span style=\"font-size: 48px\">Teaching quality evaluation</span>";
                break;
            case 5:
                strTemp = "<span>成绩单认证</span><br/><span style=\"font-size: 48px\">Transcript certification</span>";
                break;
            case 6:
                strTemp = "<span>学费信息</span><br/><span style=\"font-size: 48px\">Tuition information</span>";
                break;
            case 7:
                strTemp = "<span>支付信息</span><br/><span style=\"font-size: 48px\">Payment information</span>";
                break;
            case 8:
                strTemp = "<span>退款政策</span><br/><span style=\"font-size: 48px\">Refundable policy</span>";
                break;
        }
        $("#daohangtuwenzi").html(strTemp);

        // if ($scope.zuocenavigationId == 0) {
        //     strTemp = "<span>报名指南</span><br/><span style=\"font-size: 48px\">Registration guide</span>";
        // }
        // if ($scope.zuocenavigationId == 1) {
        //     strTemp = "<span>转学分指南</span><br/><span style=\"font-size: 48px\">Guide to credit</span>";
        // }
        // if ($scope.zuocenavigationId == 2) {
        //     strTemp = "<span>学术准则</span><br/><span style=\"font-size: 48px\">Academic standards</span>";
        // }
        // if ($scope.zuocenavigationId == 0) {
        //     strTemp = "<span>学费信息</span><br/><span style=\"font-size: 48px\">Tuition information</span>";
        // }
        // if ($scope.zuocenavigationId == 0) {
        //     strTemp = "<span>学费信息</span><br/><span style=\"font-size: 48px\">Tuition information</span>";
        // }
        // if ($scope.zuocenavigationId == 0) {
        //     strTemp = "<span>学费信息</span><br/><span style=\"font-size: 48px\">Tuition information</span>";
        // }
        // if ($scope.zuocenavigationId == 0) {
        //     strTemp = "<span>学费信息</span><br/><span style=\"font-size: 48px\">Tuition information</span>";
        // }
        // if ($scope.zuocenavigationId == 0) {
        //     strTemp = "<span>学费信息</span><br/><span style=\"font-size: 48px\">Tuition information</span>";
        // }
        // if ($scope.zuocenavigationId == 0) {
        //     strTemp = "<span>学费信息</span><br/><span style=\"font-size: 48px\">Tuition information</span>";
        // }
        // if ($scope.zuocenavigationId == 0) {
        //     strTemp = "<span>学费信息</span><br/><span style=\"font-size: 48px\">Tuition information</span>";
        // }
    }
    $scope.DaoHangXinxi($scope.zuocenavigationId);
    $scope.ApplicationCenter = function () {
        window.location.href = $scope.baseurl + "/user/application#/applicationGuide";
    }
    $scope.PersonalCenter = function () {
        //判断当前登录 用户类型
        var personType = storage.getItem("personType");
        if (personType == 1) {
            //教授
            window.location.href = $scope.baseurl + "/user/home#/teacherHome";
        } else if (personType == 2) {
            //学生
            window.location.href = $scope.baseurl + "/user/home#/personHome";
        }
    }


    $scope.DownDoc = function (url) {
        if (url == null || url == "") {
            return false;
        } else {
            downloadFile($scope.baseurl + url);
        }

    }


    $scope.indexhomeCenter = function () {
        window.location.href = $scope.baseurl + "/#/indexhome";
    }
    $scope.campusCenter = function () {
        window.location.href = $scope.baseurl + "/#/campus";
    }
    $scope.teacherCenter = function () {
        window.location.href = $scope.baseurl + "/#/teacher";
    }
    $scope.aboutUsCenter = function () {
        window.location.href = $scope.baseurl + "/#/aboutUs";
    }
    $scope.ActivityCenter = function () {
        window.location.href = $scope.baseurl + "/#/activity";
    }
    $(".h-modelB0x a").each(function (index, value) {
        if (storage.getItem("navigationId") != null) {
            $(".h-modelBorder div").each(function (indexTemp, value) {
                if (storage.getItem("navigationId") == indexTemp && indexTemp < 6) {
                    $(this)[0].className = "m" + (indexTemp + 1) + "-borderBottom" + (indexTemp + 1);
                } else {
                    $(this)[0].className = "m" + (indexTemp + 1) + "-borderBottom";
                }
            });
        }

        $(this).click(function () {
            storage.setItem("navigationId", index);
            $(".h-modelBorder div").each(function (indexTemp, value) {
                if (storage.getItem("navigationId") == indexTemp && indexTemp < 6) {
                    $(this)[0].className = "m" + (indexTemp + 1) + "-borderBottom" + (indexTemp + 1);
                } else {
                    $(this)[0].className = "m" + (indexTemp + 1) + "-borderBottom";
                }
            });

            //底部导航栏
            $(".f-model a").each(function (index, value) {
                if (storage.getItem("navigationId") != null) {
                    // if (storage.getItem("navigationId") == index && index < 6) {
                    //     $(this).children("div")[0].className = "f-modelFoot1";
                    // } else if (index < 6) {
                    //     $(this).children("div")[0].className = "f-modelFoot2";
                    // }

                    if (storage.getItem("navigationId") == index && index < 6) {
                        if (index == 0) {
                            //f-modelFoot0
                            $(this).children("div")[0].className = "f-modelFoot0";
                        } else {
                            $(this).children("div")[0].className = "f-modelFoot1";
                        }
                    } else if (index < 6) {
                        if (index == 0) {
                            //f-modelFoot0
                            $(this).children("div")[0].className = "f-modelFoot3";
                        } else {
                            $(this).children("div")[0].className = "f-modelFoot2";
                        }
                    }
                }
            });
        });
    });
    //底部导航栏
    $(".f-model a").each(function (index, value) {
        $(this).click(function () {
            storage.setItem("navigationId", index);
            $(".h-modelBorder div").each(function (indexTemp, value) {
                if (storage.getItem("navigationId") == indexTemp && indexTemp < 6) {
                    $(this)[0].className = "m" + (indexTemp + 1) + "-borderBottom" + (indexTemp + 1);
                } else {
                    $(this)[0].className = "m" + (indexTemp + 1) + "-borderBottom";
                }
            });
        });
        if (storage.getItem("navigationId") != null) {
            if (storage.getItem("navigationId") == index && index < 6) {
                if (index == 0) {
                    //f-modelFoot0
                    $(this).children("div")[0].className = "f-modelFoot0";
                } else {
                    $(this).children("div")[0].className = "f-modelFoot1";
                }
            } else if (index < 6) {
                if (index == 0) {
                    //f-modelFoot0
                    $(this).children("div")[0].className = "f-modelFoot3";
                } else {
                    $(this).children("div")[0].className = "f-modelFoot2";
                }
            }
        }
    });
    $scope.ChangeNameToId = function (name) {
        switch (name) {
            case "首页":
                return 0
                break;
            case "校区介绍":
                return 1
                break;
            case "师资团队":
                return 2
                break;
            case "申请信息":
                return 3
                break;
            case "校园生活":
                return 4
                break;
            case "关于我们":
                return 5
                break;
        }
    }

    //左侧导航栏
    $(".ai-left a").each(function (index, value) {
        $(this).click(function () {
            $scope.DaoHangXinxi(index);
            $(this).children("div")[0].className = "ai-l-1Sel";
            $(this).siblings().children("div").each(function (index, value) {
                value.className = 'ai-l-1UnSel';
            });
        });
        // $(this).click(function () {
        //     storage.setItem("zuocenavigationId", index);
        //     $(this).parent().siblings().children().each(function (index, value) {
        //         value.className = 'unSelected';
        //     });
        // })
        // if (storage.getItem("zuocenavigationId") != null) {
        //     if (storage.getItem("navigationId") == index && index < 6) {
        //         if (index == 0) {
        //             //f-modelFoot0
        //             $(this).children("div")[0].className = "f-modelFoot0";
        //         } else {
        //             $(this).children("div")[0].className = "f-modelFoot1";
        //         }
        //     } else if (index < 6) {
        //         if (index == 0) {
        //             //f-modelFoot0
        //             $(this).children("div")[0].className = "f-modelFoot3";
        //         } else {
        //             $(this).children("div")[0].className = "f-modelFoot2";
        //         }
        //     }
        // }
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
