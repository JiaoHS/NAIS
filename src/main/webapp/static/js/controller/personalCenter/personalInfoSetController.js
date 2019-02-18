myApp.controller('personalInfoSetController', function ($scope, $http, fileReader, $compile) {
    var storage;
    var CourseListTotal = new Array();

    $scope.Init = function () {
        $scope.selectValue = 1;
        $scope.baseurl = getApiUrl();
        $scope.FilterPanel = [];

        $(document).attr("title", "申请表单");
        if (!window.localStorage) {
            alert("浏览器支持localstorage");
        } else {
            storage = window.localStorage;
            storage.setItem("persionnavigationId", "1");
            storage.setItem("personTab", "1");
            $("#basicMsg").removeClass("hide");

            $(".tabList li").each(function (index, value) {
                if (storage.getItem("persionnavigationId") != null) {
                    if (storage.getItem("persionnavigationId") == index && index < 4) {
                        $(this)[0].className = "rel cur";
                    } else {
                        $(this)[0].className = "rel";
                    }
                }
            });
        }
        var personTab = storage.getItem("personTab");
        switch (personTab) {
            case "1":
                $("#schoolMsg").addClass("hide");
                $("#phoneMsg").addClass("hide");
                $("#CourseMsg").addClass("hide");
                break;
            case "2":
                $("#basicMsg").addClass("hide");
                $("#schoolMsg").removeClass("hide");
                $("#phoneMsg").addClass("hide");
                $("#CourseMsg").addClass("hide");
                $("#schoolTab").addClass("done");
                // $("#phoneTab").addClass("done");
                // $("#courseTab").addClass("done");
                break;
            case "3":
                $("#basicMsg").addClass("hide");
                $("#schoolMsg").addClass("hide");
                $("#phoneMsg").removeClass("hide");
                $("#CourseMsg").addClass("hide");
                $("#schoolTab").addClass("done");
                $("#phoneTab").addClass("done");
                // $("#courseTab").addClass("done");
                break;
            case "4":
                $("#basicMsg").addClass("hide");
                $("#schoolMsg").addClass("hide");
                $("#phoneMsg").addClass("hide");
                $("#CourseMsg").removeClass("hide");
                $("#schoolTab").addClass("done");
                $("#phoneTab").addClass("done");
                $("#courseTab").addClass("done");
                break;
            default:
                $("#basicMsg").removeClass("hide");
                $("#schoolMsg").addClass("hide");
                $("#phoneMsg").addClass("hide");
                $("#CourseMsg").addClass("hide");
                break;
        }
        $scope.sexValue = "";
        $scope.paperType = "";
        $scope.emcSexValue = "";
        $scope.email = storage.getItem("email");
        // $scope.currentTimestart = $scope.getNowFormatDate();
        // $('#datetimepickerstart').datetimepicker({
        //     // format: 'yyyy-mm-dd', /*此属性是显示顺序，还有显示顺序是mm-dd-yyyy*/
        //     autoclose: true,//自动关闭
        //     minView: 0,//最精准的时间选择为日期0-分 1-时 2-日 3-月
        //     // weekStart: 0
        // });

        //先赋值
        $http({
            method: "post",
            url: $scope.baseurl + "/user/show?id=" + parseInt(storage.getItem("userId")),
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                var url = resdata.data.data;
                $scope.ChName = url.nameCn;
                var names = url.nameEn.split(' ');
                if (names.length > 1) {
                    $scope.EnName1 = names[0];
                    $scope.ChName2 = names[1];
                } else {
                    $scope.EnName1 = url.nameEn;
                    $scope.ChName2 = url.nameEn;
                }
                if (url.gender == 1) {
                    $("#sexMale").prop("checked", "checked");
                } else {
                    $("#sexFamale").prop("checked", "checked");
                }
                //$scope.sexValue = url.gender;
                $scope.ss1(url.gender);
                $scope.birthday = url.birthDate.substr(0, 10);
                $scope.selectValue = url.cardtype;
                $scope.cardId = url.idCard;
                $scope.nowSchool = url.fromSchoolCn;
                $scope.StartYear = url.major;

                if (url.emcgender == 1) {
                    $("#spring").prop("checked", "checked");
                } else {
                    $("#autumn").prop("checked", "checked");
                }

                var address = url.homeaddress.split(',');
                if (address.length > 1) {
                    $scope.country = address[0];
                    $scope.province = address[1];
                    $scope.city = address[2];
                } else {
                    $scope.country = "";
                    $scope.province = "";
                    $scope.city = "";
                }
                var phones = url.telCn.split(',');
                if (phones.length > 1) {
                    $scope.phone1 = phones[0];
                    $scope.phone2 = phones[1];
                } else {
                    $scope.phone1 = "";
                    $scope.phone2 = "";
                }

                $scope.email = url.email;
                $scope.emeName = url.emcUser;
                $scope.emePhone = url.emcTel;
                $scope.emeChengwei = url.emcrole;
                $scope.weixin = url.wechat;
                $scope.imageSrc = url.photo == "" ? "/static/images/userCenter/默认2.png" : url.photo;
                //storage.setItem("photo", $scope.imageSrc);
            } else {
            }
        });
    }
    $scope.SaveData = function () {
        //检测字段 手机号   邮箱  证件号 出生日期
        var chkemail = $scope.checkEmail($scope.email);
        var chkephoneNum = $scope.checkPhone($scope.phoneNum);
        var chkecPhoneNum = $scope.checkPhone($scope.ecPhoneNum);
        var chkshenfen = $scope.checkIdcode($scope.paperType, $scope.idNum);
        var chkbirthdate = $scope.checkBirthdate($scope.currentTimestart);
        if (!chkemail || !chkephoneNum || !chkecPhoneNum || !chkshenfen || !chkbirthdate) {
            return;
        }
        $scope.firstName = $scope.firstName == undefined ? "" : $scope.firstName;
        $scope.lastName = $scope.lastName == undefined ? "" : $scope.lastName;
        $http({
            method: "post",
            url: $scope.baseurl + "/user/updateSave?nameCn=" + $scope.cName + "&nameEn=" + $scope.firstName + " " + $scope.lastName + "&gender=" + $scope.sexValue + "&birthDate=" + $scope.currentTimestart.substr(0, 10) + "&cardType=" + $scope.paperType + "&idCard=" + $scope.idNum + "&telCn=" + $scope.phoneNum + "&email=" + $scope.email + "&fromSchoolCn=" + $scope.schoolName + "&major=" + $scope.majorName + "&schoolAddress=" + $scope.mailingAddress + "&emcUser=" + $scope.ecName + "&emcTel=" + $scope.ecPhoneNum + "&emcRole=" + $scope.ecRelationshape + "&emcGender=" + $scope.emcSexValue + "&weChat=" + $scope.wechat + "&homeAddress=" + $scope.homeLocal,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                var url = resdata.data.data;
                storage.removeItem("email");
                window.location.href = $scope.baseurl + "/user/home#/personHome";
            } else {
                alert(resdata.data.info);
            }
        });
    }
    $scope.skipTab = function (personTab) {
        switch (personTab) {
            case "1":
                $("#schoolMsg").addClass("hide");
                $("#phoneMsg").addClass("hide");
                $("#CourseMsg").addClass("hide");
                $("#basicMsg").removeClass("hide");
                $("#schoolTab").removeClass("done");
                $("#phoneTab").removeClass("done");
                $("#courseTab").removeClass("done");
                break;
            case "2":
                $("#basicMsg").addClass("hide");
                $("#schoolMsg").removeClass("hide");
                $("#phoneMsg").addClass("hide");
                $("#CourseMsg").addClass("hide");
                $("#schoolTab").addClass("done");
                $("#phoneTab").removeClass("done");
                $("#courseTab").removeClass("done");
                // $("#phoneTab").addClass("done");
                // $("#courseTab").addClass("done");
                break;
            case "3":
                $("#basicMsg").addClass("hide");
                $("#schoolMsg").addClass("hide");
                $("#phoneMsg").removeClass("hide");
                $("#CourseMsg").addClass("hide");
                $("#schoolTab").addClass("done");
                $("#phoneTab").addClass("done");
                $("#courseTab").removeClass("done");
                // $("#courseTab").addClass("done");
                break;
            case "4":
                $("#basicMsg").addClass("hide");
                $("#schoolMsg").addClass("hide");
                $("#phoneMsg").addClass("hide");
                $("#CourseMsg").removeClass("hide");
                $("#schoolTab").addClass("done");
                $("#phoneTab").addClass("done");
                $("#courseTab").addClass("done");
                break;
            default:
                $("#basicMsg").removeClass("hide");
                $("#schoolMsg").addClass("hide");
                $("#phoneMsg").addClass("hide");
                $("#CourseMsg").addClass("hide");
                break;
        }
    }
    $scope.Quit = function () {
        storage.clear();
        window.location.href = $scope.baseurl + "/user/login";
    }

    //获取用户的性别

    $scope.ss1 = function (index) {
        var sex = document.getElementsByName("sex");
        var sexValue;
        if (index == "q") {
            for (var i = sex.length; i--;) {
                var el = sex[i];
                if (el.checked) {
                    sexValue = el.getAttribute("value");
                    $scope.sexValue = sexValue;
                    break;
                }
            }
        } else {
            for (var i = sex.length; i--;) {
                var el = sex[i];
                if (el.getAttribute("value") == index) {
                    el.checked = true;
                    break;
                }
            }
        }
    }
    //获取证件类型
    $scope.ss2 = function (index) {
        var cardType = document.getElementsByName("cardType");
        var paperType;
        if (index == "q") {
            for (var i = cardType.length; i--;) {
                var el = cardType[i];
                if (el.checked) {
                    paperType = el.getAttribute("value");
                    $scope.paperType = paperType;
                    break;
                }
            }
        } else {
            for (var i = cardType.length; i--;) {
                var el = cardType[i];
                if (el.getAttribute("value") == index) {
                    el.checked = true;
                    break;
                }
            }
        }
    }
    $scope.selectedChange = function (v) {
        $scope.selectValue = v;
    }
    //获取用户的性别
    $scope.ss3 = function () {
        var ecSex = document.getElementsByName("ecSex");
        var ecSexValue;
        for (var i = ecSex.length; i--;) {
            var el = ecSex[i];
            if (el.checked) {
                ecSexValue = el.getAttribute("value");
                $scope.ecSexValue = ecSexValue;
                alert(ecSexValue)
                break;
            }
        }
    }
    //获取第一联系人用户的性别
    $scope.ss4 = function (index) {
        var ecSex = document.getElementsByName("ecSexH");
        var emcSexValue;
        if (index == "q") {
            for (var i = ecSex.length; i--;) {
                var el = ecSex[i];
                if (el.checked) {
                    emcSexValue = el.getAttribute("value");
                    $scope.emcSexValue = emcSexValue;
                    break;
                }
            }
        } else {
            for (var i = ecSex.length; i--;) {
                var el = ecSex[i];
                if (el.getAttribute("value") == index) {
                    el.checked = true;
                    break;
                }
            }
        }


    }

    $scope.getNowFormatDate = function () {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var hour = date.getHours();
        var minu = date.getMinutes();
        var sec = date.getSeconds();
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (hour >= 1 && hour <= 9) {
            hour = "0" + hour;
        }
        if (minu >= 1 && minu <= 9) {
            minu = "0" + minu;
        }
        if (sec >= 1 && sec <= 9) {
            sec = "0" + sec;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + hour + seperator2 + minu
            + seperator2 + sec;
        return currentdate;
    }
    $scope.SkipIndex = function () {
        window.location.href = $scope.baseurl;
    }
    //检测
    $scope.checkEmail = function (email) {
        var mylog = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/
        if (!mylog.test(email)) {
            return false;
        } else {
            return true;
        }
    }
    $scope.CheckDate = function (value) {
        //日期的正则表达式
        var reg = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
        var regExp = new RegExp(reg);
        if (!regExp.test(value)) {
            return false;
        } else {
            return true;
        }
    }
    $scope.checkPhone = function (phonenum) {
        if (phonenum == "" || phonenum == undefined) {
            //未填写
            return false;
        }
        var mylog = /^[1][3,4,5,7,8][0-9]{9}$/

        if (!mylog.test(phonenum)) {
            return false;
        } else {
            return true;
        }
    }
    $scope.checkIdcode = function (index, code) {
        if (code == "" || code == undefined) {
            //未填写
            $scope.isCard = false;
            return true;
        }
        if (index == 0) {
            var mylog = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/

            if (!mylog.test(code)) {
                $scope.isCard = false;
                return false;
            } else {
                $scope.isCard = true;
            }
        }
        if (index == 1) {
            var mylog = /^1[45][0-9]{7}$|G[0-9]{8}$|P\.[0-9]{7}$|S[0-9]{7,8}$|D[0-9]{7,8}$/
            if (!mylog.test(code)) {
                $scope.isCard = false;
                return false;
            } else {
                $scope.isCard = true;
            }
        }
        if (index == 2) {
            //港澳通行证
        }
    }
    $scope.checkBirthdate = function (time) {
        if ($scope.getNowFormatDate().substr(0, 10) < time.substr(0, 10)) {
            alert("出生日期不合法！")
            return false;
        } else {
            return true;
        }
    }
    $scope.Init();
    $scope.PersonMagSave = function () {
        $scope.loading = true;
        $scope.sexMale = $("#sexMale").prop("checked");
        $scope.sexFamale = $("#sexFamale").prop("checked");
        if ($scope.sexMale == 1) {
            $scope.sex = 1;
        } else {
            $scope.sex = 0;
        }
        if ($scope.ChName == "" || $scope.ChName == undefined) {
            $("#ChName").removeClass("hide");
            return false;
        } else {
            $("#ChName").addClass("hide");
        }
        if ($scope.EnName1 == "" || $scope.EnName1 == undefined) {
            $("#EnName1").removeClass("hide");
            return false;
        } else {
            $("#EnName1").addClass("hide");
        }
        if ($scope.ChName2 == "" || $scope.ChName2 == undefined) {
            $("#ChName2").removeClass("hide");
            return false;
        } else {
            $("#ChName2").addClass("hide");
        }
        if ($scope.birthday == "" || $scope.birthday == undefined) {
            $("#birthday").removeClass("hide");
            return false;
        } else {
            if ($scope.CheckDate($scope.birthday)) {
                $("#birthday").addClass("hide");
            } else {
                $("#birthday").removeClass("hide");
                return false;
            }
        }
        if ($scope.cardId == "" || $scope.cardId == undefined) {
            $("#cardId").removeClass("hide");
            return false;
        } else {
            $("#cardId").addClass("hide");
        }
        $scope.checkIdcode($scope.selectValue, $scope.cardId);
        if ($scope.isCard) {
            $("#cardId").addClass("hide");
        } else {
            $("#cardId").removeClass("hide");
            return;
        }

        var formData = new FormData($("#upfile")[0]);
        if ($scope.imageSrc.indexOf("/static") == -1) {
            formData.append("file", convertBase64UrlToBlob($scope.imageSrc));
        }
        formData.append("nameCn", $scope.ChName);
        formData.append("nameEn", $scope.EnName1 + " " + $scope.ChName2);
        formData.append("gender", $scope.sex);
        formData.append("birthDate", $scope.birthday.substr(0, 10));
        formData.append("cardType", $scope.selectValue);
        formData.append("idCard", $scope.cardId);
        $.ajax({
            url: $scope.baseurl + "/user/updateSave",
            type: "POST",
            data: formData,
            dataType: "text",
            processData: false,         // 告诉jQuery不要去处理发送的数据
            contentType: false,        // 告诉jQuery不要去设置Content-Type请求头

            success: function (data) {
                var resdata = angular.fromJson(data);
                if (resdata.code == 0) {//成功
                    //更换下一步
                    storage.setItem("personTab", 2);
                    $("#basicMsg").addClass("hide");
                    $("#schoolMsg").removeClass("hide");
                    $("#schoolTab").addClass("done");
                    $scope.imageSrc = resdata.data.photo;
                    storage.setItem("photo", $scope.imageSrc);
                    $scope.loading = false;
                } else {
                    alert(resdata.data.info);
                }
            },
        });
    }
    $scope.getFile = function () {
        fileReader.readAsDataUrl($scope.file, $scope)
            .then(function (result) {
                $scope.imageSrc = result;
                //$('#temp').html('<label ng-hide="{{LabelHide}}" class="model4">删除文件</label>');
            });
    };

    /**
     * 将以base64的图片url数据转换为Blob
     * @param urlData
     *            用url方式表示的base64图片数据
     */
    function convertBase64UrlToBlob(urlData) {

        var bytes = window.atob(urlData.split(',')[1]);        //去掉url的头，并转换为byte

        //处理异常,将ascii码小于0的转换为大于0
        var ab = new ArrayBuffer(bytes.length);
        var ia = new Uint8Array(ab);
        for (var i = 0; i < bytes.length; i++) {
            ia[i] = bytes.charCodeAt(i);
        }

        return new Blob([ab], {type: 'image/png'});
    }

    //保存学校信息
    $scope.SaveSchoolMsg = function () {
        $scope.spring = $("#spring").prop("checked");
        $scope.autumn = $("#autumn").prop("checked");
        if ($scope.spring == 1) {
            $scope.season = 1;
        } else {
            $scope.season = 0;
        }
        if ($scope.nowSchool == "" || $scope.nowSchool == undefined) {
            $("#nowSchool").removeClass("hide");
            return false;
        } else {
            $("#nowSchool").addClass("hide");
        }
        if ($scope.StartYear == "" || $scope.StartYear == undefined) {
            $("#StartYear").removeClass("hide");
            return false;
        } else {
            if ($scope.CheckDate($scope.StartYear)) {
                $("#StartYear").addClass("hide");
            } else {
                $("#StartYear").removeClass("hide");
                return false;
            }
        }

        var formData = new FormData($("#upfile")[0]);
        //formData.append("file", convertBase64UrlToBlob($scope.imageSrc));
        formData.append("fromSchoolCn", $scope.nowSchool);
        formData.append("major", $scope.StartYear);
        formData.append("emcGender", $scope.season);
        $.ajax({
            url: $scope.baseurl + "/user/updateSave",
            type: "POST",
            data: formData,
            dataType: "text",
            processData: false,         // 告诉jQuery不要去处理发送的数据
            contentType: false,        // 告诉jQuery不要去设置Content-Type请求头

            success: function (data) {
                var resdata = angular.fromJson(data);
                if (resdata.code == 0) {//成功
                    //更换下一步
                    storage.setItem("personTab", 3);
                    $("#schoolMsg").addClass("hide");
                    $("#phoneMsg").removeClass("hide");
                    $("#phoneTab").addClass("done");
                } else {
                    alert(resdata.data.info);
                }
            },
        });
    }
    //保存tab3信息
    $scope.PersonMsgSave2 = function () {
        if ($scope.country == "" || $scope.country == undefined || $scope.province == "" || $scope.province == undefined || $scope.city == "" || $scope.city == undefined) {
            $("#address").removeClass("hide");
            return false;
        } else {
            $("#address").addClass("hide");
        }
        if ($scope.phone1 == "" || $scope.phone1 == undefined) {
            $("#phone1").removeClass("hide");
            return false;
        } else {
            if ($scope.checkPhone($scope.phone1)) {
                $("#phone1").addClass("hide");
            } else {
                $("#phone1").removeClass("hide");
                return false;
            }
        }
        if ($scope.phone2 == "" || $scope.phone2 == undefined) {
            $("#phone2").removeClass("hide");
            return false;
        } else {
            $("#phone2").addClass("hide");
        }
        if ($scope.weixin == "" || $scope.weixin == undefined) {
            $("#weixin").removeClass("hide");
            return false;
        } else {
            $("#weixin").addClass("hide");
        }
        if ($scope.emeName == "" || $scope.emeName == undefined) {
            $("#emeName").removeClass("hide");
            return false;
        } else {
            $("#emeName").addClass("hide");
        }
        if ($scope.emeChengwei == "" || $scope.emeChengwei == undefined) {
            $("#emeChengwei").removeClass("hide");
            return false;
        } else {
            $("#emeChengwei").addClass("hide");
        }
        if ($scope.emePhone == "" || $scope.emePhone == undefined) {
            $("#emePhone").removeClass("hide");
            return false;
        } else {
            if ($scope.checkPhone($scope.emePhone)) {
                $("#emePhone").addClass("hide");
            } else {
                $("#emePhone").removeClass("hide");
                return false;
            }
        }
        if ($scope.email == "" || $scope.email == undefined) {
            $("#email").removeClass("hide");
            return false;
        } else {
            if ($scope.checkEmail($scope.email)) {
                $("#email").addClass("hide");
            } else {
                $("#email").removeClass("hide");
                return false;
            }
        }

        var formData = new FormData($("#upfile")[0]);
        //formData.append("file", convertBase64UrlToBlob($scope.imageSrc));
        formData.append("homeAddress", $scope.country + "," + $scope.province + "," + $scope.city);
        formData.append("telCn", $scope.phone1 + "," + $scope.phone2);
        formData.append("weChat", $scope.weixin);
        formData.append("emcUser", $scope.emeName);
        formData.append("emcTel", $scope.emePhone);
        formData.append("emcRole", $scope.emeChengwei);
        formData.append("email", $scope.email);
        $.ajax({
            url: $scope.baseurl + "/user/updateSave",
            type: "POST",
            data: formData,
            dataType: "text",
            processData: false,         // 告诉jQuery不要去处理发送的数据
            contentType: false,        // 告诉jQuery不要去设置Content-Type请求头

            success: function (data) {
                var resdata = angular.fromJson(data);
                if (resdata.code == 0) {//成功
                    //更换下一步
                    storage.setItem("personTab", 4);
                    $("#phoneMsg").addClass("hide");
                    $("#CourseMsg").removeClass("hide");
                    $("#courseTab").addClass("done");
                } else {
                    alert(resdata.data.info);
                }
            },
        });
    }
    //提交申请表
    $scope.submitApply = function () {
        $scope.loading = true;
        storage.removeItem("personTab");//清理tab缓存

        $scope.bjAddr = $("#bjAddr").prop("checked");
        $scope.shAddr = $("#shAddr").prop("checked");
        $scope.agree = $("#agree").prop("checked");
        if (!$scope.agree) {
            $("#agreeMsg").removeClass("hide")
            alert("请选择同意！");
            return false;
        } else {
            $("#agreeMsg").addClass("hide")
        }
        if ($scope.bjAddr == 1) {
            //北京校区
            $scope.schoolId = $scope.beijingInfo.id;
        } else {
            //上海校区
            $scope.schoolId = $scope.shanghaiInfo.id;
        }
        var idList = [];
        //已选择的课程
        $("#lessonList li input").each(function (index, value) {
            if ($(this)[0].checked) {
                //$scope.idList.push($(this)[0]["id"]);
                idList[$(this)[0].attributes["timespan"].value] = $(this)[0]["id"];
            }
        });
        var schoolSelectId = storage.getItem("schoolSelectedId");
        if (schoolSelectId != null && schoolSelectId != "") {
            if ($scope.schoolId != schoolSelectId) {
                alert("请选择同一个学校的课程！")
                return;
            }
        }

        //在已有的订单里 先过滤已经付款的课程
        var idList2 = [];
        var idListTemp = [];
        if (CourseListTotal != null && CourseListTotal.length > 0) {
            for (var key2 in idList) {//新的订单课程id集合

                for (var key in CourseListTotal) {//key是订单
                    if (key2 == CourseListTotal[key].startTime.substr(11, 2)) {//同一个时间段比较
                        if (CourseListTotal[key].status == 3 || CourseListTotal[key].status == 4) {//状态=3表示已付款
                            idListTemp.push(key2);
                            continue;
                        } else {
                            idList2[idList[key2]] = key;
                        }
                        idListTemp.push(key2);
                    }
                }
            }
            for (var key3 in idList) {
                if (idListTemp.indexOf(key3) > -1) {
                    continue;
                } else {
                    idList2[idList[key3]] = 0;
                }
            }
        } else {
            if (idList != null) {
                for (var key in idList) {
                    idList2[idList[key]] = 0;
                }
            } else {
                idList2 = [];
            }
        }

        if (idList2 != null && idList2.length > 0) {
            angular.forEach(idList2, function (value, index) {
                $.ajax(
                    {
                        url: $scope.baseurl + "/chooseCourse/submit?orderIds=&id=" + index + "&campusId=" + $scope.schoolId + "&orderId=" + value,
                        dataType: "json",
                        type: "post",
                        async: false,
                        success: function (data) {
                            var resdata = angular.fromJson(data);
                            if (resdata.code == 0) {//成功
                                $scope.CourseList = resdata.data;
                                //跳转到支付页面
                                $scope.loading = false;
                                window.location.href = $scope.baseurl + "/user/home#/payment";
                                //+ "/#/pay";
                            }
                        }
                    });
            })
        } else {
            //没有新增订单跳转到支付页面
            window.location.href = $scope.baseurl + "/user/home#/payment";
        }

        //
    }

    $scope.MergeList = function () {
        var html = '';
        var html1 = '';
        var indexTime = 0;
        if (CourseListTotal != null && CourseListTotal.length > 0) {

            angular.forEach($scope.CourseListAll, function (CourseInfo, key3) {
                var flag3 = false;
                var flag = false;  //select
                var flag2 = "";  //checked
                var flag3 = false;  //是否付款
                var html2 = '';
                var html3 = '';
                html2 += ' <i class="arr abs"></i><ul class="baseInfo f22 clearfix"><li class="fl a">时间段</li><li class="fl b">' + CourseInfo.timeSpan + '</li><li class="fl c">&nbsp;</li><li id="courseNameId" class="fl d"></li></ul><ol class="typeInfo f22 clearfix hide"><li class="fl a">Time</li><li class="fl b">Course Name</li><li class="fl c">Instructor</li><li class="fl d">Operating</li></ol>';
                html2 += '<div class="lessonListInfo f16 c65">';
                indexTime++;
                angular.forEach(CourseInfo.list, function (info, key5) {
                    for (var key in CourseListTotal) {
                        //循环
                        if (info.id == CourseListTotal[key].id) {
                            //选中
                            flag = true;
                            flag2 = info.id;
                            if (CourseListTotal[key].status == 3 || CourseListTotal[key].status == 4) {
                                flag3 = true;
                            }
                            break;
                        }
                    }
                });
                angular.forEach(CourseInfo.list, function (info, key5) {
                    var name = 'time' + indexTime;
                    html2 += '<ul class="perList clearfix"><li class="fl a">' + CourseInfo.timeSpan + '</li><li class="fl b"><p>' + (info.courseCode == '' ? '&nbsp;' : info.courseCode) + '</p><p>' + (info.courseName == '' ? '&nbsp;' : info.courseName) + '</p></li><li class="fl c">' + (info.professorNameCn == '' ? '&nbsp;' : info.professorNameCn) + '</li><li class="fl d"><a href="">课程详情</a></li>';
                    if (flag) {//有选中的
                        if (flag2 == info.id) {//已选中的课程
                            html3 = '<li class="fl e"><input coursecouch="' + (info.courseAttach == "" ? "null" : info.courseAttach) + '" coursenamea="' + info.courseName + '" school="' + info.campusId + '" timespan="' + info.startTime.substr(11, 2) + '" id="' + info.id + '"  name=' + name + ' type="radio" checked></li></ul>';
                        } else {
                            if (flag3) {
                                html3 = '<li class="fl e"><input coursecouch="' + (info.courseAttach == "" ? "null" : info.courseAttach) + '" coursenamea="' + info.courseName + '" school="' + info.campusId + '" timespan="' + info.startTime.substr(11, 2) + '" id="' + info.id + '" name=' + name + ' type="radio" disabled></li></ul>';
                            } else {
                                html3 = '<li class="fl e"><input coursecouch="' + (info.courseAttach == "" ? "null" : info.courseAttach) + '" coursenamea="' + info.courseName + '" school="' + info.campusId + '" timespan="' + info.startTime.substr(11, 2) + '" id="' + info.id + '" name=' + name + ' type="radio"></li></ul>';
                            }
                        }
                    } else {
                        html3 = '<li class="fl e"><input coursecouch="' + (info.courseAttach == "" ? "null" : info.courseAttach) + '" coursenamea="' + info.courseName + '" school="' + info.campusId + '" timespan="' + info.startTime.substr(11, 2) + '" id="' + info.id + '" name=' + name + ' type="radio"></li></ul>';
                    }
                    html2 += html3;
                });


                html2 += '</div>';
                if (flag) {
                    html1 = '<div class="lessonDetail rel select">';
                    flag = false;
                } else {
                    html1 = '<div class="lessonDetail rel">';
                }
                html += html1 + html2 + '</div>';
            });

        } else {
            angular.forEach($scope.CourseListAll, function (CourseInfo, key3) {
                var flag3 = false;
                var flag = false;  //select
                var flag2 = "";  //checked
                var flag3 = false;  //是否付款
                var html2 = '';
                var html3 = '';
                html2 += ' <i class="arr abs"></i><ul class="baseInfo f22 clearfix"><li class="fl a">时间段</li><li class="fl b">' + CourseInfo.timeSpan + '</li><li class="fl c">&nbsp;</li><li id="courseNameId" class="fl d"></li></ul><ol class="typeInfo f22 clearfix hide"><li class="fl a">Time</li><li class="fl b">Course Name</li><li class="fl c">Instructor</li><li class="fl d">Operating</li></ol>';
                html2 += '<div class="lessonListInfo f16 c65">';
                indexTime++;
                angular.forEach(CourseInfo.list, function (info, key5) {
                    var name = 'time' + indexTime;
                    html2 += '<ul class="perList clearfix"><li class="fl a">' + CourseInfo.timeSpan + '</li><li class="fl b"><p>' + (info.courseCode == '' ? '&nbsp;' : info.courseCode) + '</p><p>' + (info.courseName == '' ? '&nbsp;' : info.courseName) + '</p></li><li class="fl c">' + (info.professorNameCn == '' ? '&nbsp;' : info.professorNameCn) + '</li><li class="fl d"><a href="">课程详情</a></li>';
                    html3 = '<li class="fl e"><input coursecouch="' + (info.courseAttach == "" ? "null" : info.courseAttach) + '"  coursenamea="' + info.courseName + '" school="' + info.campusId + '" timespan="' + info.startTime.substr(11, 2) + '" id="' + info.id + '" name=' + name + ' type="radio"></li></ul>';
                    html2 += html3;
                });


                html2 += '</div>';
                if (flag) {
                    html1 = '<div class="lessonDetail rel select">';
                } else {
                    html1 = '<div class="lessonDetail rel">';
                }
                html += html1 + html2 + '</div>';
            });
        }
        //html += html1 + html2;
        var tmp = $compile(html)($scope);
        $("#lessonList").html(tmp);
    }

    $scope.CommonFun = function (cumpusId) {
        var CourseListAll = $.ajax(
            {
                url: $scope.baseurl + "/campusCourse/show?campusId=" + cumpusId,
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        $scope.CourseListAll = angular.fromJson(resdata.data);
                    }
                }
            });
        var MyCourseList = $.ajax(
            {
                url: $scope.baseurl + "/order/list/my",
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        $scope.MyOrderList = resdata.data;

                        if ($scope.MyOrderList != null) {
                            var orderId = "";
                            //循环我的课程列表
                            var orderIdList = [];
                            var ids = [];
                            angular.forEach($scope.MyOrderList, function (value, key) {
                                //循环订单列表  取出订单id
                                if (value.orderStatus != -1 && value.orderSource == 100) {
                                    orderId = value.id;
                                    if (value.remark == null || value.remark == "") {
                                        orderIdList.push(value);
                                    }
                                }
                            });

                            if (orderIdList != null && orderIdList.length > 0) {
                                angular.forEach(orderIdList, function (valueOrder, key3) {
                                    $.ajax(
                                        {
                                            url: $scope.baseurl + "/order/courseList?orderId=" + valueOrder.id,
                                            dataType: "json",
                                            type: "post",
                                            async: false,
                                            success: function (data) {
                                                var resdata = angular.fromJson(data);
                                                if (resdata.code == 0) {//成功
                                                    $scope.CourseList = resdata.data;
                                                    var indexTemp = 0;

                                                    angular.forEach($scope.CourseList, function (value1, key1) {
                                                        if (value1 != null) {
                                                            value1.professorId = valueOrder.id;
                                                            value1.status = valueOrder.orderStatus;
                                                            valueOrder.paymentSeq = valueOrder.courseName;
                                                            if (valueOrder.remark == null || valueOrder.remark == "") {
                                                                CourseListTotal[valueOrder.id] = value1;
                                                                storage.setItem("schoolSelectedId", value1.campusId);
                                                            }
                                                        }
                                                    });
                                                } else {
                                                }
                                            }
                                        });
                                });
                            } else {
                                storage.removeItem("schoolSelectedId");
                            }
                        }
                    } else {
                        storage.removeItem("schoolSelectedId");
                    }
                }
            });
        $.when(CourseListAll, MyCourseList).done(function () {
            //所做操作
            $scope.MergeList();
        });

        if (storage.getItem("schoolSelectedId") == null || storage.getItem("schoolSelectedId") == "") {
            if ($("#shAddr").prop("checked") == true) {
                $("#shAddr").prop("checked", "checked");
            } else if ($("#bjAddr").prop("checked") == true) {
                $("#bjAddr").prop("checked", "checked");
            }
        } else {
            if (storage.getItem("schoolSelectedId") == $scope.beijingInfo.id) {
                $("#shAddr").prop("disabled", "disabled");
                $("#bjAddr").prop("checked", "checked");
                //$scope.CommonFun($scope.beijingInfo.id);
            } else if (storage.getItem("schoolSelectedId") == $scope.shanghaiInfo.id) {
                $("#bjAddr").prop("disabled", "disabled");
                $("#shAddr").prop("checked", "checked");
                //$scope.CommonFun($scope.shanghaiInfo.id);
            }
        }

        //给每一个按钮一个点击事件

        $(":radio").on("click", function () {
            if ($(this)[0].attributes["name"].value == "choiceAddr") {
                if ($("#shAddr").prop("checked") == true) {
                    $("#shAddr").prop("checked", "checked");
                } else if ($("#bjAddr").prop("checked") == true) {
                    $("#bjAddr").prop("checked", "checked");
                }
            } else {
                var courseName = $(this)[0].attributes["coursenamea"].value;
                //$('#courseNameId').html(courseName);
                // $(this).parent().parent().parent().parent().children("#courseNameId").html(courseName);
                $(this).parent().parent().parent().parent().children('ul').children('#courseNameId').html(courseName);
                $(this).parent().parent().parent().parent().addClass('select');
            }
        })
    }

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
                } else {
                    alert(resdata.data.info);
                }
                //默认北京
                // if (storage.getItem('schoolId') == null || storage.getItem('schoolId') == "") {
                //     $scope.GetCourseListById($scope.beijingInfo.id);
                // }
            }
        });
    if (storage.getItem('schoolSelectedId') == null || storage.getItem('schoolSelectedId') == "") {
        $scope.cumpusId = $scope.beijingInfo.id;
        storage.setItem("schoolSelectedId", $scope.cumpusId);
        $scope.CommonFun($scope.cumpusId);
    } else {
        $scope.CommonFun(storage.getItem('schoolSelectedId'));
    }

    //给每一个按钮一个点击事件

    $(":radio").on("click", function () {
        if ($(this)[0].attributes["name"].value == "choiceAddr") {
            if ($("#shAddr").prop("checked") == true) {
                $("#shAddr").prop("checked", "checked");
            } else if ($("#bjAddr").prop("checked") == true) {
                $("#bjAddr").prop("checked", "checked");
            }
        } else {
            var courseName = $(this)[0].attributes["coursenamea"].value;
            //$('#courseNameId').html(courseName);
            // $(this).parent().parent().parent().parent().children("#courseNameId").html(courseName);
            $(this).parent().parent().parent().parent().children('ul').children('#courseNameId').html(courseName);
            $(this).parent().parent().parent().parent().addClass('select');
        }
    })
    $("#lessonList li input").each(function (index, value) {
        if ($(this)[0].checked) {
            var courseName = $(this)[0].attributes["coursenamea"].value;
            $(this).parent().parent().parent().parent().children('ul').children('#courseNameId').html(courseName);
        }
    });
    $scope.DownLoadSy = function () {
        //未选择任何课程，请选择后下载
        var idList = [];
        //已选择的课程
        $("#lessonList li input").each(function (index, value) {
            if ($(this)[0].checked) {
                //$scope.idList.push($(this)[0]["id"]);
                var courseAttach = $(this)[0].attributes["coursecouch"].value;
                idList.push(courseAttach)
                //idList[$(this)[0].attributes["courseAttach"].value] = $(this)[0]["id"];
            }
        });
        if (idList != null && idList.length > 0) {
            for (var i = 0; i < idList.length; i++) {
                var url = idList[i];
                if ((url == null || url == NaN || url == "" || url == "null")) {
                    continue;
                } else {
                    downloadFile($scope.baseurl + "/" + url);
                }
            }
        } else {
            alert('未选择任何课程，请选择后下载')
            return false;
        }
    }
})
window.downloadFile = function (sUrl) {
    alert(navigator.userAgent.toLowerCase().indexOf('ie'));
    //iOS devices do not support downloading. We have to inform user about this.
    if (/(iP)/g.test(navigator.userAgent)) {
        alert('Your device does not support files downloading. Please try again in desktop browser.');
        return false;
    }

    //If in Chrome or Safari - download via virtual link click
    if (window.downloadFile.isChrome || window.downloadFile.isSafari || window.downloadFile.isIE) {
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
