myApp.controller('payWayController', function ($scope, $http, $interval, fileReader, $location) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];

    if (!window.localStorage) {
        alert("浏览器支持localstorage");
    } else {
        storage = window.localStorage;
    }
    // if (storage.getItem("totalMoney") != null) {
    //     $scope.totalMoney = storage.getItem("totalMoney");
    // }
    // $scope.orderListPay = [];
    // $scope.orderListPay = JSON.parse(storage.getItem('orderList'));
    $scope.OrderList = [];
    $scope.OrderId = storage.getItem("orderId");
    if (storage.getItem("TotalMoney") != null) {
        $scope.TotalMoney = storage.getItem("TotalMoney") <= 0 ? 100 : storage.getItem("TotalMoney");
    } else {
        $scope.TotalMoney = 100;
    }
    if (storage.getItem("paymentSeq") != null) {
        $scope.paymentSeq = storage.getItem("paymentSeq");
    } else {
        $scope.paymentSeq = 0;
    }
    $scope.CouponId = "";

    $scope.SubmitOrder = function (OrderId, CouponId) {
        var url = "/couponOrder/submit?orderId=" + OrderId + "&stockId=" + CouponId;
        if (CouponId == null || CouponId == "") {
            url = "/couponOrder/submit?orderId=" + OrderId + "&stockId=";
        }
        $.ajax(
            {
                url: $scope.baseurl + url,
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功

                    }
                }
            });
    }
    $scope.UseConpon = function () {
        //根据CouponId查优惠金额
        if ($scope.CouponId == "" || $scope.CouponId == null) {
            alert("请输入优惠券！")
            return false;
        } else {
            //查优惠券是否存在
            //领取成功
            var GetCoupon = $.ajax(
                {
                    url: $scope.baseurl + "/coupon/pullSpreadCouponCode?couponCode=" + $scope.CouponId,
                    dataType: "json",
                    type: "post",
                    async: false,
                    success: function (data) {
                        var resdata = angular.fromJson(data);
                        if (resdata.code == 0) {//成功
                            alert("优惠券使用成功！")

                        } else {
                            return false;
                        }
                    }
                });
            //查我的优惠券
            var flag = false;
            var GetMyCoupon = $.ajax(
                {
                    url: $scope.baseurl + "/coupon/show/myCouponList?page=1&rows=8",
                    dataType: "json",
                    type: "post",
                    async: false,
                    success: function (data) {
                        var resdata = angular.fromJson(data);
                        $scope.MyCouponList = resdata.rows;
                        if ($scope.MyCouponList == null || $scope.MyCouponList.length <= 0) {
                            alert("暂无优惠券")
                            return false;
                        } else {
                            //循环取出couponid
                            for (var key in $scope.MyCouponList) {//key是订单
                                if ($scope.MyCouponList[key].couponCode == $scope.CouponId) {
                                    flag = true;
                                    $scope.stockId = $scope.MyCouponList[key].stockId;
                                    $scope.DisCountMount = $scope.MyCouponList[key].discountAmount;
                                    var mon = $scope.TotalMoney - $scope.DisCountMount;
                                    $scope.TotalMoney = mon <= 0 ? 100 : mon;

                                    storage.setItem("TotalMoney", $scope.TotalMoney);
                                }
                            }
                            if (!flag) {
                                alert("优惠券已使用！")
                                return false;
                            }
                        }
                    }
                });
            if ($scope.stockId != null && $scope.OrderId != null) {
                $scope.SubmitOrder($scope.OrderId, $scope.stockId);
            }
        }
    }

    if (storage.getItem("reloadd") != null) {
        if ($location.absUrl().indexOf("personHome") > -1) {
            $scope.isShow = true;
            $scope.TitleName1 = "首页";
            $scope.TitleName2 = "学生中心";
            storage.removeItem("reloadd");
            storage.setItem("persionnavigationId", "0");
            window.location.href = $scope.baseurl + "/user/home#/personHome";
            window.location.reload();
        }
        if ($location.absUrl().indexOf("payWay") > -1) {
            $scope.isShow = false;
            $scope.TitleName1 = "学生中心";
            $scope.TitleName2 = "学生缴费";
            storage.removeItem("reloadd");
            storage.setItem("persionnavigationId", "3");
            window.location.href = $scope.baseurl + "/user/home#/payWay";
            window.location.reload();
        }
    }

    function timeFn(d1) {
        //di作为一个变量传进来
        //如果时间格式是正确的，那下面这一步转化时间格式就可以不用了
        var dateBegin = new Date(d1);//将-转化为/，使用new Date
        var dateEnd = new Date();//获取当前时间
        var dateDiff = dateEnd.getTime() - dateBegin.getTime();//时间差的毫秒数
        var dayDiff = Math.floor(dateDiff / (24 * 3600 * 1000));//计算出相差天数
        var leave1 = dateDiff % (24 * 3600 * 1000)    //计算天数后剩余的毫秒数
        $scope.hours = Math.floor(leave1 / (3600 * 1000))//计算出小时数
        //计算相差分钟数
        var leave2 = leave1 % (3600 * 1000)    //计算小时数后剩余的毫秒数
        $scope.minutes = Math.floor(leave2 / (60 * 1000))//计算相差分钟数
        //计算相差秒数
        var leave3 = leave2 % (60 * 1000)      //计算分钟数后剩余的毫秒数
        $scope.seconds = Math.round(leave3 / 1000)
    }

    $scope.TimeDiff = function (createTime) {
        //已s为单位

        createTime = new Date(createTime.replace(/-/g, "/"));//replace方法将-转为/
        var time = $interval(function () {
            timeFn(createTime);
            $scope.textPayWay = (23 - $scope.hours) + ":" + (59 - $scope.minutes) + ":" + (60 - $scope.seconds);
            // if ($scope.n == 0) {
            //     $interval.cancel(time);
            // }
        }, 1000);
    }


    $scope.Pay = function (index) {
        if ($scope.paymentSeq == "" || $scope.paymentSeq == undefined || $scope.paymentSeq == null) {
            alert("出现错误！")
            return;
        }
        if (index == 2) {//支付宝
            window.location.href = $scope.baseurl + "/pay/aliPay/doPay?paymentSeq=" + $scope.paymentSeq;
        } else if (index == 3) {
            var w = document.documentElement.clientWidth || document.body.clientWidth;
            var h = document.documentElement.clientHeight || document.body.clientHeight;
            $(".courseShade").css({"width": w, "height": h, "display": "block"});

        }
    }
    $(".csb-close").click(function () {
        $(".courseShade").css("display", "none");
    })
    $scope.Cancel = function () {
        $(".courseShade").css("display", "none");
    }
    $scope.UpImg = function () {
        //var btnUpload = document.getElementById("btnUpload");
        // var uploader = new ss.SimpleUpload({
        //     button: btnUpload,
        //     url: $scope.baseurl + "/pay/bankPay/receipt/upload",
        //     name: "file",
        //     multiple: true,
        //     allowedExtensions: ['jpg', 'jpeg', 'png', 'gif'],
        //     responseType: 'json',
        //     onSubmit: function () {
        //
        //     },
        //     onComplete: function (filename, response) {
        //         console.log(filename);
        //         console.log(response);
        //     },
        //     onError: function (error) {
        //         console.log(error);
        //     }
        // });

        var formData = new FormData($("#upfile")[0]);
        formData.append("file", convertBase64UrlToBlob($scope.imageSrc));
        formData.append("orderId", $scope.OrderId);

        //var files = $('input[name="fileField"]').prop('files');//获取到文件列表
        // var postData = {
        //     vacationType: $scope.leave.type,
        //     reason: $scope.leave.reason,
        //     familyRelation: +$scope.leave.type == 7 ? $scope.leave.relation : "",
        //     startTime: startTime,
        //     endTime: endTime,
        //     fileName: $scope.myFile,
        //     workDelivers: workDelivers,
        //     ccmailNickNames: sendPersons,
        //     realDays: +$scope.leave.type == 8 ? $scope.leave.timeLong : ""
        // };
        // var fd = new FormData();
        // angular.forEach(postData, function(val, key) {
        //     fd.append(key, val);
        // });
        // $http({
        //     type: "post",
        //     url: $scope.baseurl + "/pay/bankPay/receipt/upload",
        //     dataType: "text",
        //     data: formData,
        //     processData: false,         // 告诉jQuery不要去处理发送的数据
        //     contentType: false,        // 告诉jQuery不要去设置Content-Type请求头
        // }).then(function (data) {
        //     var resdata = angular.fromJson(data);
        //     if (resdata.data.code == 0) {
        //         //提交订单成功
        //         //关闭图片上传
        //
        //     } else {
        //         alert(resdata.data.info);
        //     }
        // });
        $.ajax({
            url: $scope.baseurl + "/pay/bankPay/receipt/upload",
            type: "POST",
            data: formData,
            dataType: "text",
            processData: false,         // 告诉jQuery不要去处理发送的数据
            contentType: false,        // 告诉jQuery不要去设置Content-Type请求头

            success: function (data) {
                $(".courseShade").css("display", "none");
                $("#bankLink").html("已上传");
                document.getElementById("bankLink").style.color = 'red';
                //window.location.href="${ctx}"+data;
            },
            // xhr: function () {            //在jquery函数中直接使用ajax的XMLHttpRequest对象
            //     var xhr = new XMLHttpRequest();
            //
            //     xhr.upload.addEventListener("progress", function (evt) {
            //         if (evt.lengthComputable) {
            //             var percentComplete = Math.round(evt.loaded * 100 / evt.total);
            //             // console.log();        //在控制台打印上传进度
            //             $scope.logContent = "正在提交." + percentComplete.toString() + '%';
            //         }
            //     }, false);
            //
            //     return xhr;
            // }

        });


        // if (files.length == 0) {
        //     alert('请选择文件');
        //     return;
        // } else {
        //     var reader = new FileReader();//新建一个FileReader
        //     reader.readAsText(files[0], "UTF-8");//读取文件
        //     reader.onload = function (evt) { //读取完文件之后会回来这里
        //         var fileString = evt.target.result;
        //         //post方式上传图片到控制器
        //         //var date = {"file": fileString};
        //         $http({
        //             method: "get",
        //             url: $scope.baseurl + "/pay/bankPay/receipt/upload?orderId=" + $scope.OrderId + "&file=" + fileString,
        //             dataType: "json",
        //             data: JSON.stringify($scope.FilterPanel),
        //             headers: {"Content-Type": "application/json;charset=utf-8"}
        //         }).then(function (data) {
        //             var resdata = angular.fromJson(data);
        //             if (resdata.data.code == 0) {
        //                 //提交订单成功
        //                 //关闭图片上传
        //
        //             } else {
        //                 alert(resdata.data.info);
        //             }
        //         });
        //         // $.post("editProfile", date).success(function (result) {
        //         //     alert("ok");
        //         // });
        //     }
        // }
        // var file = $scope.myFile;

    }
    $scope.getFile = function () {
        fileReader.readAsDataUrl($scope.file, $scope)
            .then(function (result) {
                $scope.imageSrc = result;
                //$('#temp').html('<label ng-hide="{{LabelHide}}" class="model4">删除文件</label>');
            });
    };
    $scope.SubmitRemark = function () {
        //提交其他的付款信息  姓名 电话 银行
        if ($scope.RemittanceName == "" || $scope.RemittancePhohe == "" || $scope.StudentName == "" || $scope.RemittanceBank == "") {
            alert("请填写完整的信息！")
            return;
        }
        if ($scope.RemittanceName == undefined || $scope.RemittancePhohe == undefined || $scope.StudentName == undefined || $scope.RemittanceBank == undefined) {
            alert("请填写完整的信息！")
            return;
        }
        $scope.agree = $("#agree").prop("checked");
        if (!$scope.agree) {
            alert("请选择同意！");
            return false;
        }
        //拼接到一个字段 更新到paymentremark
        var remark = $scope.RemittanceName + "," + $scope.RemittancePhohe + "," + $scope.StudentName + "," + $scope.RemittanceBank;
        $.ajax(
            {
                url: $scope.baseurl + "/chooseCourse/ChangeOrderRemark?orderId=" + $scope.OrderId + "&remark=" + remark,
                dataType: "json",
                type: "post",
                async: false,
                success: function (data) {
                    var resdata = angular.fromJson(data);
                    if (resdata.code == 0) {//成功
                        //跳转到订单预览页面
                        storage.setItem("reloadd", $scope.OrderId);
                        window.location.href = $scope.baseurl + "/user/home#/payment";
                    }
                }
            });
    }
    $(".methodTitle li").each(function (index, value) {
        if (storage.getItem("payTabId") != null) {
            if (storage.getItem("payTabId") == index && index < 4) {
                if (index == 2) {
                    //fl rel tc c
                    $(this)[0].className = "fl rel tc c cur";
                } else if (index == 3) {
                    $(this)[0].className = "fl rel tc d cur";
                } else {
                    $(this)[0].className = "fl rel tc cur";
                }
                //$(this)[0].className = "rel cur";
                // "m" + (index + 1) + "-borderBottom" + (index + 1);
            }
            else {
                if (index == 2) {
                    //fl rel tc c
                    $(this)[0].className = "fl rel tc c";
                } else if (index == 3) {
                    $(this)[0].className = "fl rel tc d";
                } else {
                    $(this)[0].className = "fl rel tc";
                }
                //$(this)[0].className = "rel";
            }
            switch (storage.getItem("payTabId")) {
                case "0":
                    $("#pay0").removeClass("hide");
                    $("#pay1").addClass("hide");
                    $("#pay2").addClass("hide");
                    $("#pay3").addClass("hide");
                    $("#pay4").removeClass("hide");
                    break;
                case "1":
                    $("#pay1").removeClass("hide");
                    $("#pay0").addClass("hide");
                    $("#pay2").addClass("hide");
                    $("#pay3").addClass("hide");
                    $("#pay4").removeClass("hide");
                    break;
                case "2":
                    $("#pay2").removeClass("hide");
                    $("#pay1").addClass("hide");
                    $("#pay0").addClass("hide");
                    $("#pay3").addClass("hide");
                    $("#pay4").addClass("hide");
                    break;
                case "3":
                    $("#pay3").removeClass("hide");
                    $("#pay1").addClass("hide");
                    $("#pay2").addClass("hide");
                    $("#pay0").addClass("hide");
                    $("#pay4").addClass("hide");
                    break;
            }
        }

        $(this).click(function () {
            if(index==2){
                alert("暂时不支持，请选择其他支付方式！");
                return false;
            }
            storage.setItem("payTabId", index);
            switch (index) {
                case 0:
                    $("#pay0").removeClass("hide");
                    $("#pay1").addClass("hide");
                    $("#pay2").addClass("hide");
                    $("#pay3").addClass("hide");
                    $("#pay4").removeClass("hide");
                    break;
                case 1:
                    $("#pay1").removeClass("hide");
                    $("#pay0").addClass("hide");
                    $("#pay2").addClass("hide");
                    $("#pay3").addClass("hide");
                    $("#pay4").removeClass("hide");
                    break;
                case 2:
                    $("#pay2").removeClass("hide");
                    $("#pay1").addClass("hide");
                    $("#pay0").addClass("hide");
                    $("#pay3").addClass("hide");
                    $("#pay4").addClass("hide");
                    break;
                case 3:
                    $("#pay3").removeClass("hide");
                    $("#pay1").addClass("hide");
                    $("#pay2").addClass("hide");
                    $("#pay0").addClass("hide");
                    $("#pay4").addClass("hide");
                    break;
            }
            $(".methodTitle li").each(function (indexTemp, value) {
                if (storage.getItem("payTabId") == indexTemp && indexTemp < 4) {
                    if (indexTemp == 2) {
                        //fl rel tc c
                        $(this)[0].className = "fl rel tc c cur";
                    } else if (indexTemp == 3) {
                        $(this)[0].className = "fl rel tc d cur";
                    } else {
                        $(this)[0].className = "fl rel tc cur";
                    }
                } else {
                    if (indexTemp == 2) {
                        //fl rel tc c
                        $(this)[0].className = "fl rel tc c";
                    } else if (indexTemp == 3) {
                        $(this)[0].className = "fl rel tc d";
                    } else {
                        $(this)[0].className = "fl rel tc";
                    }
                }
            });
        });
    });


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
});