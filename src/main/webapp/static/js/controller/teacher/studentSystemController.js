myApp.controller('studentSystemController', function ($scope, $http, $compile) {
    var storage;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];
    $scope.StuWorkListIsShow = true;
    if (!window.localStorage) {
        alert("浏览器不支持localstorage");
    } else {
        storage = window.localStorage;
    }
    storage.setItem("middleIsShowStorage", true);
    storage.setItem("LoginIsShow", true);
    //时间轴
    //获取时间 today yesterday tomorrow 默认是today
    //传入一个时间获取最近五天
    var curIndex = 0;
    $scope.yearBase = new Date().getFullYear();
    $scope.GetTimeList = function (temp) {
        $scope.TimeList = [];
        if (temp == "now") {
            //当前
            for (i = 2; i >= -2; i--) {//去5天的时间
                $scope.TimeList.push(getBeforeDate(i).substr(5, 5));
            }
        }
        if (temp == "pre") {
            //前一天
            curIndex--;//0
            for (i = (2 - curIndex); i >= (-2 - curIndex); i--) {//去5天的时间
                $scope.TimeList.push(getBeforeDate(i).substr(5, 5));
            }
        }
        if (temp == "next") {
            //后一天
            curIndex++;
            for (i = (2 - curIndex); i >= (-2 - curIndex); i--) {//去5天的时间
                $scope.TimeList.push(getBeforeDate(i).substr(5, 5));
            }
        }
        var tempList = $scope.TimeList[2].split('.');
        storage.setItem("baseDate", $scope.yearBase + "-" + tempList[0] + "-" + tempList[1]);
        //左右 时间更新 更新学生作业完成情况 假如StuWorkListIsShow==false则 不显示学生作业完成情况
        if ($scope.StuWorkListIsShow == false) {
            return false;
        } else {
            if (temp != "now") {
                $scope.doneDetail();//更新主轴时间
            }
        }
    }

    function getBeforeDate(n) {
        var date = new Date();
        var year, month, day;
        date.setDate(date.getDate() - n);
        year = date.getFullYear();
        month = date.getMonth() + 1;
        day = date.getDate();
        s = year + '.' + (month < 10 ? ('0' + month) : month) + '.' + (day < 10 ? ('0' + day) : day);
        return s;
    }

    //学生详细完成情况
    $scope.doneDetail = function () {
        var courseArrangeId = storage.getItem("courseArrangeId");
        var courseId = storage.getItem("courseId");
        var Date = storage.getItem("baseDate");
        $.post($scope.baseurl + "/homeWork/student/doneDetail", {
            campusId: $scope.schoolId,
            courseArrangeId: courseArrangeId,
            studentId: $scope.userId,
            baseDate: Date
        }, function (data, status, xhr) {
            if (status == "success" && data != 0) {
                var resdata = angular.fromJson(data);
                $scope.courseDocList = new Array();


                $scope.HomeWorkList = resdata.data[1];
                var htmlrow1 = '<div class="cmh-word">课后作业</div>';
                var htmlrow2 = '<div class="cmh-word">成绩</div>';
                var htmlrow3 = '<div class="cmh-word1">提交时间</div>';
                angular.forEach($scope.HomeWorkList, function (value, key) {
                    if (value.homeWorkTask == null || value.homeWorkTask == "" || value.status == -1) {
                        //未发布
                        htmlrow1 += '<div class="cmh-homework3">未发布</div>';
                        htmlrow2 += '<div class="cmh-grade2"></div>';
                        htmlrow3 += '<div class="cmh-time3"></div>';
                    } else if (value.status == 0) {
                        //未提交，显示上传下载按钮
                        $scope.courseDocList[value.homeWorkTask.id] = value.homeWorkTask.taskAttachUrl;
                        htmlrow1 += '<div class="cmh-homework2"><div class="cmh-do"><div ng-click="DownFileDoc(' + value.homeWorkTask.id + ')" class="cmh-download">下载</div><div class="cmhd-line"></div><div ng-click="UploadFileDoc(' + value.homeWorkTask.taskType + ',' + value.homeWorkTask.id + ')" class="cmh-upload">上传</div></div></div>';
                        htmlrow2 += '<div class="cmh-grade2"></div>';
                        htmlrow3 += '<div class="cmh-time3"></div>';
                    } else if (value.status == 1) {
                        //未提交，但是当前时间已经超过作业提交最晚时间，显示  未提交
                        //<div class="cmh-homework1" style="color: red">submitted</div>
                        htmlrow1 += '<div class="cmh-homework1" style="color: red">未提交</div>';
                        htmlrow2 += '<div class="cmh-grade1">0</div>';
                        htmlrow3 += '<div class="cmh-time3"></div>';
                    } else if (value.status == 2) {
                        //已提交 未打分 1类作业
                        htmlrow1 += '<div class="cmh-homework1" style="color: #00aeef">已提交</div>';
                        htmlrow2 += '<div class="cmh-grade1"></div>';
                        htmlrow3 += '<div class="cmh-time3">' + value.userHomeWork.submitTime.substr(5, 5) + '</div>';
                    } else if (value.status == 3) {
                        //已提交 未打分 1类作业
                        htmlrow1 += '<div class="cmh-homework1" style="color: #00aeef">已提交</div>';
                        htmlrow2 += '<div class="cmh-grade1"></div>';
                        htmlrow3 += '<div class="cmh-time3">' + value.userHomeWork.submitTime.substr(5, 5) + '</div>';
                    } else if (value.status == 4) {
                        //已打分，显示分数
                        htmlrow1 += '<div class="cmh-homework1" style="color: #00aeef">已提交</div>';
                        htmlrow2 += '<div class="cmh-grade1">' + value.userHomeWork.taskScore + '/' + value.userHomeWork.taskTotalScore + '</div>'
                        htmlrow3 += '<div class="cmh-time3">' + value.userHomeWork.submitTime.substr(5, 5) + '</div>';
                    }
                })
                //$compile编译
                var tmp = $compile(htmlrow1)($scope);
                $('#homeworkRow1').html(tmp);
                var tmp2 = $compile(htmlrow2)($scope);
                $('#homeworkRow2').html(tmp2);
                var tmp3 = $compile(htmlrow3)($scope);
                $('#homeworkRow3').html(tmp3);
                //演讲
                $scope.SpeechList = resdata.data[2];
                var speechRow = '<div class="cms-word1">演讲成绩</div>';
                angular.forEach($scope.SpeechList, function (value, key) {
                    if (value.homeWorkTask == null || value.homeWorkTask == "" || value.status == -1) {
                        //无作业
                        speechRow += '<div class="cms-speaking3"></div>';
                    } else if (value.status == 0) {
                        //未提交
                        speechRow += '<div class="cms-speaking3"></div>';
                    } else if (value.status == 1) {
                        //已提交未打分，且没有上传，显示为submitted
                        speechRow += '<div class="cms-speaking3"></div>';
                    } else if (value.status == 2) {
                        speechRow += '<div class="cms-speaking3"></div>';
                    } else if (value.status == 4) {
                        speechRow += '<div class="cms-speaking3">' + value.userHomeWork.taskScore + '/' + value.userHomeWork.taskTotalScore + '</div>'
                    }
                })
                var tmp = $compile(speechRow)($scope);
                $("#speachList").html(tmp);

                //期中考试
                $scope.ThemidtermexamList = resdata.data[3];
                var htmlrow4 = '<div class="cmh-word">期中考试</div>';
                var htmlrow5 = '<div class="cmh-word">成绩</div>';
                var htmlrow6 = '<div class="cmh-word1">提交时间</div>';
                angular.forEach($scope.ThemidtermexamList, function (value, key) {
                    if (value.homeWorkTask == null || value.homeWorkTask == "" || value.status == -1) {
                        //未发布  ' + value.taskType + ',' + value.id + '
                        htmlrow4 += '<div class="cmh-homework3">未发布</div>';
                        htmlrow5 += '<div class="cmh-grade2"></div>';
                        htmlrow6 += '<div class="cmh-time3"></div>';
                    } else if (value.status == 0) {
                        //未提交，显示上传下载按钮
                        $scope.courseDocList[value.homeWorkTask.id] = value.homeWorkTask.taskAttachUrl;
                        htmlrow4 += '<div class="cmh-homework2"><div class="cmh-do"><div ng-click="DownFileDoc(' + value.homeWorkTask.id + ')" class="cmh-download">下载</div><div class="cmhd-line"></div><div ng-click="UploadFileDoc(' + value.homeWorkTask.taskType + ',' + value.homeWorkTask.id + ')" class="cmh-upload">上传</div></div></div>';
                        htmlrow5 += '<div class="cmh-grade2"></div>';
                        htmlrow6 += '<div class="cmh-time3"></div>';
                    } else if (value.status == 1) {
                        //未提交，但是当前时间已经超过作业提交最晚时间，显示  未提交
                        //<div class="cmh-homework1" style="color: red">submitted</div>
                        htmlrow4 += '<div class="cmh-homework1" style="color: red">未提交</div>';
                        htmlrow5 += '<div class="cmh-grade1">0</div>';
                        htmlrow6 += '<div class="cmh-time3"></div>';
                    } else if (value.status == 2) {
                        //已提交 未打分 1类作业
                        htmlrow4 += '<div class="cmh-homework1" style="color: #00aeef">已提交</div>';
                        htmlrow5 += '<div class="cmh-grade1"></div>';
                        htmlrow6 += '<div class="cmh-time3">' + value.userHomeWork.submitTime.substr(5, 5) + '</div>';
                    } else if (value.status == 3) {
                        //已提交 未打分 1类作业
                        htmlrow4 += '<div class="cmh-homework1" style="color: #00aeef">已提交</div>';
                        htmlrow5 += '<div class="cmh-grade1"></div>';
                        htmlrow6 += '<div class="cmh-time3">' + value.userHomeWork.submitTime.substr(5, 5) + '</div>';
                    } else if (value.status == 4) {
                        //已打分，显示分数
                        htmlrow4 += '<div class="cmh-homework1" style="color: #00aeef">已提交</div>';
                        htmlrow5 += '<div class="cmh-grade1">' + value.userHomeWork.taskScore + '/' + value.userHomeWork.taskTotalScore + '</div>'
                        htmlrow6 += '<div class="cmh-time3">' + value.userHomeWork.submitTime.substr(5, 5) + '</div>';
                    }
                })
                //$compile编译
                var tmp4 = $compile(htmlrow4)($scope);
                $('#homeworkRow4').html(tmp4);
                var tmp5 = $compile(htmlrow5)($scope);
                $('#homeworkRow5').html(tmp5);
                var tmp6 = $compile(htmlrow6)($scope);
                $('#homeworkRow6').html(tmp6);


                // var htmlrow4 = '<div class="cmh-word">期中考试</div>';
                // var htmlrow5 = '<div class="cmh-word">成绩</div>';
                // var htmlrow6 = '<div class="cmh-word1">提交时间</div>';
                // // angular.forEach($scope.ThemidtermexamList, function (value, key) {
                // //     if (value.homeWorkTask == null || value.homeWorkTask == "" || value.status == -1) {
                // //         //未发布
                // //         htmlrow1 += '<div class="cmh-homework3">未发布</div>';
                // //         htmlrow2 += '<div class="cmh-grade2"></div>';
                // //         htmlrow3 += '<div class="cmh-time3"></div>';
                // //     } else if (value.status == 0) {
                // //         //未提交，显示上传下载按钮
                // //         htmlrow1 += '<div class="cmh-homework2"><div class="cmh-do"><div class="cmh-download">下载</div><div class="cmhd-line"></div><div class="cmh-upload">上传</div></div></div>';
                // //         htmlrow2 += '<div class="cmh-grade2"></div>';
                // //         htmlrow3 += '<div class="cmh-time3"></div>';
                // //     } else if (value.status == 1) {
                // //         //未提交，但是当前时间已经超过作业提交最晚时间，显示  未提交
                // //         //<div class="cmh-homework1" style="color: red">submitted</div>
                // //         htmlrow1 += '<div class="cmh-homework1" style="color: red">未提交</div>';
                // //         htmlrow2 += '<div class="cmh-grade1">0</div>';
                // //         htmlrow3 += '<div class="cmh-time3"></div>';
                // //     } else if (value.status == 3) {
                // //         //已提交 未打分 1类作业
                // //         htmlrow1 += '<div class="cmh-homework1" style="color: #00aeef">已提交</div>';
                // //         htmlrow2 += '<div class="cmh-grade1"></div>';
                // //         htmlrow3 += '<div class="cmh-time3">' + value.userHomeWork.submit_time + '</div>';
                // //     } else if (value.status == 4) {
                // //         //已打分，显示分数
                // //         htmlrow1 += '<div class="cmh-homework1" style="color: #00aeef">已提交</div>';
                // //         htmlrow2 += '<div class="cmh-grade1">' + value.userHomeWork.taskscore + '</div>'
                // //         htmlrow3 += '<div class="cmh-time3">' + value.userHomeWork.submit_time + '</div>';
                // //     }
                // // })
                // angular.forEach($scope.ThemidtermexamList, function (value, key) {
                //     if (value.homeWorkTask == null || value.homeWorkTask == "" || value.status == -1) {
                //         //未发布
                //         htmlrow7 += '<div class="cmh-homework3">未发布</div>';
                //         htmlrow8 += '<div class="cmh-grade2"></div>';
                //         htmlrow9 += '<div class="cmh-time3"></div>';
                //     } else if (value.status == 0) {
                //         //未提交，显示上传下载按钮
                //         htmlrow7 += '<div class="cmh-homework2"><div class="cmh-do"><div class="cmh-download">下载</div><div class="cmhd-line"></div><div class="cmh-upload">上传</div></div></div>';
                //         htmlrow8 += '<div class="cmh-grade2"></div>';
                //         htmlrow9 += '<div class="cmh-time3"></div>';
                //     } else if (value.status == 1) {
                //         //未提交，但是当前时间已经超过作业提交最晚时间，显示  未提交
                //         //<div class="cmh-homework1" style="color: red">submitted</div>
                //         htmlrow7 += '<div class="cmh-homework1" style="color: red">未提交</div>';
                //         htmlrow8 += '<div class="cmh-grade1">0</div>';
                //         htmlrow9 += '<div class="cmh-time3"></div>';
                //     } else if (value.status == 3) {
                //         //已提交 未打分 1类作业
                //         htmlrow7 += '<div class="cmh-homework1" style="color: #00aeef">已提交</div>';
                //         htmlrow8 += '<div class="cmh-grade1"></div>';
                //         htmlrow9 += '<div class="cmh-time3">' + value.userHomeWork.submit_time + '</div>';
                //     } else if (value.status == 4) {
                //         //已打分，显示分数
                //         htmlrow7 += '<div class="cmh-homework1" style="color: #00aeef">已提交</div>';
                //         htmlrow8 += '<div class="cmh-grade1">' + value.userHomeWork.taskscore + '</div>'
                //         htmlrow9 += '<div class="cmh-time3">' + value.userHomeWork.submit_time + '</div>';
                //     }
                // })
                // //$compile编译
                // var tmp4 = $compile(htmlrow4)($scope);
                // $('#homeworkRow4').html(tmp4);
                // var tmp5 = $compile(htmlrow5)($scope);
                // $('#homeworkRow5').html(tmp5);
                // var tmp6 = $compile(htmlrow6)($scope);
                // $('#homeworkRow6').html(tmp6);
                //期末考试
                $scope.FinalexamList = resdata.data[4];
                var htmlrow7 = '<div class="cmh-word">期末考试</div>';
                var htmlrow8 = '<div class="cmh-word">成绩</div>';
                var htmlrow9 = '<div class="cmh-word1">提交时间</div>';
                angular.forEach($scope.FinalexamList, function (value, key) {
                    if (value.homeWorkTask == null || value.homeWorkTask == "" || value.status == -1) {
                        //未发布
                        htmlrow7 += '<div class="cmh-homework3">未发布</div>';
                        htmlrow8 += '<div class="cmh-grade2"></div>';
                        htmlrow9 += '<div class="cmh-time3"></div>';
                    } else if (value.status == 0) {
                        //未提交，显示上传下载按钮
                        $scope.courseDocList[value.homeWorkTask.id] = value.homeWorkTask.taskAttachUrl;
                        htmlrow7 += '<div class="cmh-homework2"><div class="cmh-do"><div ng-click="DownFileDoc(' + value.homeWorkTask.id + ')" class="cmh-download">下载</div><div class="cmhd-line"></div><div ng-click="UploadFileDoc(' + value.homeWorkTask.taskType + ',' + value.homeWorkTask.id + ')" class="cmh-upload">上传</div></div></div>';
                        htmlrow8 += '<div class="cmh-grade2"></div>';
                        htmlrow9 += '<div class="cmh-time3"></div>';
                    } else if (value.status == 1) {
                        //未提交，但是当前时间已经超过作业提交最晚时间，显示  未提交
                        //<div class="cmh-homework1" style="color: red">submitted</div>
                        htmlrow7 += '<div class="cmh-homework1" style="color: red">未提交</div>';
                        htmlrow8 += '<div class="cmh-grade1">0</div>';
                        htmlrow9 += '<div class="cmh-time3"></div>';
                    } else if (value.status == 2) {
                        //已提交 未打分 1类作业
                        htmlrow7 += '<div class="cmh-homework1" style="color: #00aeef">已提交</div>';
                        htmlrow8 += '<div class="cmh-grade1"></div>';
                        htmlrow9 += '<div class="cmh-time3">' + value.userHomeWork.submitTime.substr(5, 5) + '</div>';
                    } else if (value.status == 3) {
                        //已提交 未打分 1类作业
                        htmlrow7 += '<div class="cmh-homework1" style="color: #00aeef">已提交</div>';
                        htmlrow8 += '<div class="cmh-grade1"></div>';
                        htmlrow9 += '<div class="cmh-time3">' + value.userHomeWork.submitTime.substr(5, 5) + '</div>';
                    } else if (value.status == 4) {
                        //已打分，显示分数
                        htmlrow7 += '<div class="cmh-homework1" style="color: #00aeef">已提交</div>';
                        htmlrow8 += '<div class="cmh-grade1">' + value.userHomeWork.taskScore + '/' + value.userHomeWork.taskTotalScore + '</div>'
                        htmlrow9 += '<div class="cmh-time3">' + value.userHomeWork.submitTime.substr(5, 5) + '</div>';
                    }
                })
                //$compile编译
                var tmp7 = $compile(htmlrow7)($scope);
                $('#homeworkRow7').html(tmp7);
                var tmp8 = $compile(htmlrow8)($scope);
                $('#homeworkRow8').html(tmp8);
                var tmp9 = $compile(htmlrow9)($scope);
                $('#homeworkRow9').html(tmp9);

            }
        }, "text");

    }


    var courseArrangeId = getQueryString('courseArrangeId');
    var studentId = getQueryString('studentId');
    var campusId = getQueryString('campusId');
    if (courseArrangeId != null && studentId != null && campusId != null) {
        //storage.clear();
        storage.setItem("middleIsShowStorage", false);
        storage.setItem("LoginIsShow", false);
        //后台调链接
        storage.setItem("courseArrangeId", courseArrangeId);
        storage.setItem("userId", studentId);
        $scope.userId = studentId;
        storage.setItem("schoolId", campusId);
        $scope.schoolId = campusId;
        // $scope.GetTimeList('now');
        // $scope.doneDetail();
        $scope.GetCourseListByUserId = function (campusId) {
            //已选课则  $scope.StuWorkListIsShow = true;
            $http({
                method: "post",
                url: $scope.baseurl + "/homeWork/student/myCourse?page=1&rows=50&campusId=" + campusId + "&studentId=" + studentId,
                dataType: "json",
                data: JSON.stringify($scope.FilterPanel),
                headers: {"Content-Type": "application/json;charset=utf-8"}
            }).then(function (data) {
                var resdata = angular.fromJson(data);
                if (resdata.data.rows != null) {//成功
                    $scope.CourseList = new Array();
                    $scope.CourseList = resdata.data.rows;

                    if ($scope.CourseList != null && $scope.CourseList.length > 0) {
                        storage.setItem("courseArrangeId", $scope.CourseList[0].id);
                        storage.setItem("courseId", $scope.CourseList[0].courseId);
                        storage.setItem("courseCode", $scope.CourseList[0].courseCode);
                        $scope.GetTimeList("now");//默认当期时间
                        $scope.doneDetail($scope.CourseList[0].id, $scope.CourseList[0].courseId);//加载默认第一个
                        $scope.StuWorkListIsShow = true;
                    } else {
                        //隐藏详细完成情况 列表
                        $scope.StuWorkListIsShow = false;
                    }
                } else {
                }
            });
        }
        $scope.GetCourseListByUserId(campusId);//左侧的学生课程显示
    } else if (storage.getItem("userId") != null || storage.getItem("schoolId") != null) {
        storage.setItem("middleIsShowStorage", true);
        storage.setItem("LoginIsShow", true);
        $scope.GetCourseListByUserId = function (campusId) {
            //已选课则  $scope.StuWorkListIsShow = true;
            $http({
                method: "post",
                url: $scope.baseurl + "/homeWork/student/myCourse?page=1&rows=50&campusId=" + campusId + "&studentId=" + storage.getItem("userId"),
                dataType: "json",
                data: JSON.stringify($scope.FilterPanel),
                headers: {"Content-Type": "application/json;charset=utf-8"}
            }).then(function (data) {
                var resdata = angular.fromJson(data);
                if (resdata.data.rows != null) {//成功
                    $scope.CourseList = new Array();
                    $scope.CourseList = resdata.data.rows;

                    if ($scope.CourseList != null && $scope.CourseList.length > 0) {
                        storage.setItem("courseArrangeId", $scope.CourseList[0].id);
                        storage.setItem("courseId", $scope.CourseList[0].courseId);
                        storage.setItem("courseCode", $scope.CourseList[0].courseCode);
                        $scope.GetTimeList("now");//默认当期时间
                        $scope.doneDetail($scope.CourseList[0].id, $scope.CourseList[0].courseId);//加载默认第一个
                        $scope.StuWorkListIsShow = true;
                    } else {
                        //隐藏详细完成情况 列表
                        $scope.StuWorkListIsShow = false;
                    }
                } else {
                }
            });
        }
        $scope.GetCourseListByUserId(storage.getItem("schoolId"));//左侧的学生课程显示
    } else {
        return false;
    }
    Date.prototype.Format = function (fmt) { // author: meizz
        var o = {
            "M+": this.getMonth() + 1, // 月份
            "d+": this.getDate(), // 日
            "h+": this.getHours(), // 小时
            "m+": this.getMinutes(), // 分
            "s+": this.getSeconds(), // 秒
            "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
            "S": this.getMilliseconds() // 毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
    storage.setItem("Selected", "SelectCampus");
    $scope.userId = storage.getItem("userId");
    $scope.schoolId = storage.getItem("schoolId");
    $scope.GetName = function (studentId, campusId) {
        $http({
            method: "post",
            url: $scope.baseurl + "/homeWork/student/stuInfo?studentId=" + studentId + "&campusId=" + campusId,
            dataType: "JSON",
            data: "",
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (response) {
            // {"code":0,"data":"/personalInfoSet.html","info":"操作成功"}
            var resdata = angular.fromJson(response)
            if (resdata.data.code == 0) {//成功
                storage.setItem("userName", resdata.data.data[0].userName);
                $scope.userName = resdata.data.data[0].userName;
            } else {

            }
        })
    }
    $scope.GetName($scope.userId, $scope.schoolId);
    $scope.userName = storage.getItem("userName");

    $scope.GetSchoolById = function (schoolId) {
        $http({
            method: "post",
            url: $scope.baseurl + "/campus/show/list/select?id=" + schoolId,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.campusInfoList = resdata.data.data[0];
            } else {
                alert(resdata.data.info);
            }
        });
    }
    $scope.GetSchoolById($scope.schoolId);//根据学校id查找学校的名字

    $scope.GetdoneDet=function (courseArrangeId, courseId, courseCode) {
        for (var i = 0; i < $scope.CourseList.length; i++) {
            if (courseArrangeId == $scope.CourseList[i].id) {
                $('#abc' + $scope.CourseList[i].id + '')[0].className = 'cl-courseNumSel';
            } else {
                $('#abc' + $scope.CourseList[i].id + '')[0].className = 'cl-courseNumUnSel';
            }
        }
        $scope.GetdoneDetail(courseArrangeId, courseId, courseCode);
    }

    $scope.GetdoneDetail = function (courseArrangeId, courseId, courseCode) {
        storage.setItem("courseArrangeId", courseArrangeId);
        storage.setItem("courseId", courseId);
        storage.setItem("courseCode", courseCode);
        $scope.doneDetail();
    }


    $scope.GetNoticeList = function (campusId) {
        $http({
            method: "post",
            url: $scope.baseurl + "/homeWork/student/notices?campusId=" + campusId + "&studentId=" + $scope.userId,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.noticeList = resdata.data.data;

                var html = '';
                angular.forEach($scope.noticeList, function (value, index) {
                    html += '<div class="crc-conBox"><div class="crc-time">' + value.createTime.substr(0, 10) + '</div><paragraph>' + value.taskDesc + '</paragraph></div>';
                })
                html += '<div class="crc-conBox"><div class="crc-time">2018-05-28</div><paragraph>开学报名时间是2018年05月27日，请同学们带好身份证或者护照，前往指定地点报到</paragraph></div>';
                $("#informList").html(html);
            } else {
            }
        });
    }
    $scope.GetNoticeList($scope.schoolId);//通知中心

    $scope.DownFileDoc = function (courseId) {
        var url = $scope.courseDocList[courseId];
        if ((url == null || url == NaN || url == "")) {
            return false;
        } else {
            downloadFile($scope.baseurl + url);
        }
    }

    $scope.UploadFileDoc = function (taskType, taskId) {
        var w = document.documentElement.clientWidth || document.body.clientWidth;
        var h = document.documentElement.clientHeight || document.body.clientHeight;
        $(".teacherSystemShade1").css({"width": w, "height": h, "display": "block"});
        $scope.taskType = taskType;
        $scope.taskId = taskId;
    }

    $scope.UpLoadWork = function () {
        var formData = new FormData();
        // var startTime = $scope.dateYear1.toString() + "-" + $scope.dateMonth1.toString() + "-" + $scope.dateDay1.toString();
        // var endTime = $scope.dateYear2.toString() + "-" + $scope.dateMonth2.toString() + "-" + $scope.dateDay2.toString();
        $http({
            method: "post",
            url: $scope.baseurl + "/homeWork/student/add?courseId=" + storage.getItem("courseId") + "&courseCode=" + storage.getItem("courseCode") + "&taskId=" + $scope.taskId + "&taskType=" + $scope.taskType + "&attachUrl=" + encodeURIComponent($("#fileUrl").val()) + "&desc=&studentId=" + storage.getItem("userId"),
            dataType: "text",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                //关窗
                $(".teacherSystemShade1").css("display", "none");
                //去缓存
                //刷新
                location.reload();
            } else {
                alert(resdata.data.info);
            }
        });

    }


});

//上传文件
function change() {
    document.getElementById("upload_file_tmp").value = document.getElementById("upload_file").value;
    var formData = new FormData();
    formData.append("file", $("#upload_file")[0].files[0]);
    $.ajax({
        url: getApiUrl() + "/homeWork/student/attach/upload",
        type: "POST",
        data: formData,
        dataType: "text",
        processData: false,         // 告诉jQuery不要去处理发送的数据
        contentType: false,        // 告诉jQuery不要去设置Content-Type请求头

        success: function (data) {
            //赋值 URL
            var resdata = angular.fromJson(data);
            if (resdata.code == 0) {//成功
                $("#fileUrl").val(resdata.data);
                //$scope.fileUrl = resdata.data.data;
            } else {
                alert(resdata.info);
            }

        },
    });
}

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