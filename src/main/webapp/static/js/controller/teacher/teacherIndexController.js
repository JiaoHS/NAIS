myApp.controller('teacherIndexController', function ($scope, $http, $compile) {
    var storage;
    $scope.StuWorkListIsShow = true;
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];
    $scope.visible = false;
    $scope.LoginIsShow = true;
    if (!window.localStorage) {
        alert("浏览器不支持localstorage");
    } else {
        storage = window.localStorage;
    }

    //根据schoolId查找校区信息
    $scope.schoolId = storage.getItem("schoolId");
    $scope.professorId = storage.getItem("professorId");

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
            $scope.doneDetail(storage.getItem("studentId"));//更新主轴时间
        }
    }
    $scope.GetCourseByIds = function (courseArrangeId, courseId, courseCode) {
        for (var i = 0; i < $scope.CourseList.length; i++) {
            if (courseArrangeId == $scope.CourseList[i].id) {
                $('#abc' + $scope.CourseList[i].id + '')[0].className = 'tsh-courseSel';
            } else {
                $('#abc' + $scope.CourseList[i].id + '')[0].className = 'tsh-courseUnSel';
            }
        }
        $scope.GetCourseById(courseArrangeId, courseId, courseCode);
    }
    //获取对应课程的学生列表
    $scope.GetCourseById = function (courseArrangeId, courseId, courseCode) {

        //courseArrangeId存入缓存
        storage.setItem("courseArrangeId", courseArrangeId);
        storage.setItem("courseId", courseId);
        storage.setItem("courseCode", courseCode);
        $scope.nameList = new Array();
        $http({
            method: "post",
            url: $scope.baseurl + "/homework/professor/studentList?campusId=" + $scope.schoolId + "&courseArrangeId=" + courseArrangeId,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.StudentList = resdata.data.data;

                //如果学生列表不为空$scope.StudentList 加载第一个学生的详细完成情况
                if ($scope.StudentList != null && $scope.StudentList.length > 0) {
                    var studengListHtml = '';
                    angular.forEach($scope.StudentList, function (value, key) {
                        //student.id,student.nameCn
                        var name = value.nameEn == "" ? value.nameCn : value.nameEn;
                        $scope.nameList[value.id] = value.nameCn;
                        studengListHtml += '<div class="cl-courseNumUnSel" id="abc' + value.id + '" ng-click="doneDetail(' + value.id + ')">' + name + '</div>';
                    })
                    var temp = $compile(studengListHtml)($scope);
                    $("#studengListHtml").html(temp);
                    var name2 = $scope.StudentList[0].nameEn == "" ? $scope.StudentList[0].nameCn : $scope.StudentList[0].nameEn;
                    storage.setItem("studentIdName", name2);
                    $scope.doneDetail($scope.StudentList[0].id);//加载第一个
                    storage.setItem("studentId", $scope.StudentList[0].id);
                    $scope.StuWorkListIsShow = true;

                    $scope.GetTimeList("now");//默认当期时间
                } else {
                    //隐藏详细完成情况 列表
                    $scope.StuWorkListIsShow = false;
                }
            } else {
                alert(resdata.data.info);
            }
        });
    }

    //根据professorId schoolId 查询 获取与教授对应的课程安排
    $scope.GetCourseListById = function (professorId, schoolId) {
        $http({
            method: "post",
            url: $scope.baseurl + "/homework/professor/arrangeList?professorId=" + professorId + "&campusId=" + schoolId,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.CourseList = resdata.data.data;

                //课程安排不为空  获取第一个课程的学生列表
                if ($scope.CourseList != null && $scope.CourseList.length > 0) {
                    $scope.GetCourseById($scope.CourseList[0].id, $scope.CourseList[0].courseId, $scope.CourseList[0].courseCode);//加载默认第一个

                }
            } else {
                alert(resdata.data.info);
            }
        });
    }

    //学生详细完成情况
    $scope.doneDetail = function (studentId) {
        for (var key in $scope.nameList) {
            if (key == studentId) {
                $('#abc' + key + '')[0].className = 'cl-courseNumSel';
            } else {
                $('#abc' + key + '')[0].className = 'cl-courseNumUnSel';
            }
        }

        // if (studentId == -1) {
        //     studentId = storage.getItem("studentId");
        // }
        storage.setItem("studentId", studentId);//更新缓存
        storage.setItem("nameCn", $scope.nameList[studentId]);//更新缓存
        var courseArrangeId = storage.getItem("courseArrangeId");
        var Date = storage.getItem("baseDate");
        $scope.studentName = storage.getItem("nameCn");
        $.post($scope.baseurl + "/homework/professor/doneDetail", {
            courseArrangeId: courseArrangeId,
            studentId: studentId,
            baseDate: Date
        }, function (data, status, xhr) {
            if (status == "success" && data != 0) {
                $scope.DocList = new Array();
                var resdata = angular.fromJson(data);
                $scope.HomeWorkList = resdata.data[1];
                var htmlrow1 = '<div class="cmh-word">Homework</div>';
                var htmlrow2 = '  <div class="cmh-word">Score</div>';
                angular.forEach($scope.HomeWorkList, function (value, key) {
                    if (value.homeWorkTask == null || value.homeWorkTask == "") {
                        //无作业
                        htmlrow1 += '<div class="cmh-homework4">No homework</div>';
                        htmlrow2 += '<div class="cmh-grade3"></div>';
                    } else if (value.status == 0) {
                        //未提交
                        htmlrow1 += '<div class="cmh-homework1" style="color: red">Unsubmitted</div>';
                        htmlrow2 += '<div class="cmh-grade3">0</div>';
                    } else if (value.status == 1) {
                        //已提交未打分，且没有上传，显示为submitted
                        htmlrow1 += ' <div class="cmf-mt1" style="color: #00aeef">Submitted</div>';
                        htmlrow2 += '<div class="cmh-grade1">0</div>';
                    } else if (value.status == 2) {
                        //已提交未打分，显示为download
                        $scope.DocList[value.userHomeWork.id] = value.userHomeWork.taskSubmitUrl;
                        htmlrow1 += '<div class="cmh-homework2"><div class="cmh-do"><div class="cmh-download"><a href="" ng-click="DownFileDoc(' + value.userHomeWork.id + ')" id="homeworkDownload" type="pdf">download</a><div class="cmh-dot"></div></div></div></div>';
                        htmlrow2 += '<div class="cmh-grade2"><input ng-model="Score' + key + '" type="text" class="cmh-inputScore"><div ng-click="uploadFile2(' + key + ',' + value.userHomeWork.id + ')" class="cmh-scoreUpload">upload</div></div>';
                    } else if (value.status == 3) {
                        //已打分，显示分数
                        htmlrow1 += ' <div class="cmf-mt1" style="color: #00aeef">Submitted</div>';
                        htmlrow2 += '<div class="cmh-grade1">' + value.userHomeWork.taskScore + '/' + value.userHomeWork.taskTotalScore + '</div>'
                    }
                })
                //$compile编译
                var tmp = $compile(htmlrow1)($scope);
                $('#homeworkRow1').html(tmp);
                var tmp2 = $compile(htmlrow2)($scope);
                $('#homeworkRow2').html(tmp2);
                //演讲
                $scope.SpeechList = resdata.data[2];
                var speechRow = '<div class="cms-word1">Speech Score</div>';
                angular.forEach($scope.SpeechList, function (value, key) {
                    if (value.homeWorkTask == null || value.homeWorkTask == "") {
                        //无作业
                        speechRow += '<div class="cmh-grade2">No Speech</div>';
                        //'<div class="cmh-grade2"><input ng-model="Score' + key + '" type="text" class="cmh-inputScore"><div ng-click="uploadFile2(' + key + ',' + value.id + ')" class="cmh-scoreUpload">upload</div></div>';
                    } else if (value.status == 0) {
                        //未提交
                        speechRow += '<div class="cmh-grade2">No Speech</div>';
                        //speechRow += '<div class="cmh-grade2"><input ng-model="Score' + key + '" type="text" class="cmh-inputScore"><div ng-click="uploadFile2(' + key + ',' + value.userHomeWork.id + ')" class="cmh-scoreUpload">upload</div></div>';
                    } else if (value.status == 1) {
                        //已提交未打分，且没有上传，显示为submitted
                        if (value.userHomeWork != null) {
                            speechRow += '<div class="cmh-grade2"><input ng-model="Score' + key + '" type="text" class="cmh-inputScore"><div ng-click="uploadFile2(' + key + ',' + value.userHomeWork.id + ')" class="cmh-scoreUpload">upload</div></div>';
                        } else {
                            speechRow += '<div class="cmh-grade2">No Speech</div>';
                        }
                    } else if (value.status == 2) {
                        speechRow += '<div class="cmh-grade2">No Speech</div>';
                        speechRow += '<div class="cmh-grade2"><input ng-model="Score' + key + '" type="text" class="cmh-inputScore"><div ng-click="uploadFile2(' + key + ',' + value.userHomeWork.id + ')" class="cmh-scoreUpload">upload</div></div>';
                    } else if (value.status == 3) {
                        speechRow += '<div class="cms-speaking5">' + value.userHomeWork.taskScore + '/' + value.userHomeWork.taskTotalScore + '</div>'
                    }
                })
                var tmp = $compile(speechRow)($scope);
                $("#speachList").html(tmp);

                //The midterm exam
                $scope.ThemidtermexamList = resdata.data[3];
                var htmlrow3 = '<div class="cmm-word2">The midterm exam</div>';
                var htmlrow4 = '<div class="cmm-word">Score</div>';
                angular.forEach($scope.ThemidtermexamList, function (value, key) {
                    if (value.homeWorkTask == null || value.homeWorkTask == "") {
                        //无作业
                        htmlrow3 += '<div class="cmm-mt2">No homework</div>';
                        htmlrow4 += '<div class="cmm-grade1"></div>';
                    } else if (value.status == 0) {
                        //未提交
                        htmlrow3 += '<div class="cmm-mt2" style="color: red">Unsubmitted</div>';
                        htmlrow4 += '<div class="cmm-grade1">0</div>';
                    } else if (value.status == 1) {
                        //已提交未打分，且没有上传，显示为submitted
                        htmlrow3 += ' <div class="cmm-mt2" style="color: #00aeef">Submitted</div>';
                        htmlrow4 += '<div class="cmm-grade1">0</div>';
                    } else if (value.status == 2) {
                        //已提交未打分，显示为download
                        $scope.DocList[value.userHomeWork.id] = value.userHomeWork.taskSubmitUrl;
                        htmlrow3 += '<div class="cmm-mt2"><div class="cmh-do"><div class="cmh-download"><a href="" ng-click="DownFileDoc(' + value.userHomeWork.id + ')" id="homeworkDownload" type="pdf">download</a><div class="cmh-dot"></div></div></div></div>';
                        htmlrow4 += '<div class="cmm-grade1"><input ng-model="Score' + key + '" type="text" class="cmh-inputScore"><div ng-click="uploadFile2(' + key + ',' + value.userHomeWork.id + ')" class="cmh-scoreUpload">upload</div></div>';
                    } else if (value.status == 3) {
                        //已打分，显示分数
                        htmlrow3 += ' <div class="cmm-mt2" style="color: #00aeef">Submitted</div>';
                        htmlrow4 += '<div class="cmm-grade1">' + value.userHomeWork.taskScore + '/' + value.userHomeWork.taskTotalScore + '</div>'
                    }
                })
                //$compile编译
                var tmp3 = $compile(htmlrow3)($scope);
                $('#homeworkRow3').html(tmp3);
                var tmp4 = $compile(htmlrow4)($scope);
                $('#homeworkRow4').html(tmp4);
                //期末考试
                $scope.FinalexamList = resdata.data[4];
                var htmlrow5 = '<div class="cmh-word">Final exam</div>';
                var htmlrow6 = '<div class="cmh-word">Score</div>';
                angular.forEach($scope.FinalexamList, function (value, key) {
                    if (value.homeWorkTask == null || value.homeWorkTask == "") {
                        //无作业
                        htmlrow5 += '<div class="cmh-homework4">No homework</div>';
                        htmlrow6 += '<div class="cmh-grade3"></div>';
                    } else if (value.status == 0) {
                        //未提交
                        htmlrow5 += '<div class="cmh-homework1" style="color: red">Unsubmitted</div>';
                        htmlrow6 += '<div class="cmh-grade3">0</div>';
                    } else if (value.status == 1) {
                        //已提交未打分，且没有上传，显示为submitted
                        htmlrow5 += ' <div class="cmf-mt1" style="color: #00aeef">Submitted</div>';
                        htmlrow6 += '<div class="cmh-grade1">0</div>';
                    } else if (value.status == 2) {
                        //已提交未打分，显示为download
                        $scope.DocList[value.userHomeWork.id] = value.userHomeWork.taskSubmitUrl;
                        htmlrow5 += '<div class="cmh-homework2"><div class="cmh-do"><div class="cmh-download"><a ng-click="DownFileDoc(' + value.userHomeWork.id + ')" href="" id="homeworkDownload" type="pdf">download</a><div class="cmh-dot"></div></div></div></div>';
                        htmlrow6 += '<div class="cmh-grade2"><input ng-model="Score' + key + '" type="text" class="cmh-inputScore"><div ng-click="uploadFile2(' + key + ',' + value.userHomeWork.id + ')" class="cmh-scoreUpload">upload</div></div>';
                    } else if (value.status == 3) {
                        //已打分，显示分数
                        htmlrow5 += ' <div class="cmf-mt1" style="color: #00aeef">Submitted</div>';
                        htmlrow6 += '<div class="cmh-grade1">' + value.userHomeWork.taskScore + '/' + value.userHomeWork.taskTotalScore + '</div>'
                    }
                })
                //$compile编译
                var tmp5 = $compile(htmlrow5)($scope);
                $('#homeworkRow5').html(tmp5);
                var tmp6 = $compile(htmlrow6)($scope);
                $('#homeworkRow6').html(tmp6);

            }
        }, "text");

    }


    $scope.GetCourseListById($scope.professorId, $scope.schoolId);


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
    $scope.ymd = new Date().Format("yyyy/MM/dd");
    $scope.hms = new Date().Format("hh:mm:ss").substr(0, 5);
    $scope.dateMonth1 = $scope.ymd.split('/')[1];
    $scope.dateDay1 = $scope.ymd.split('/')[2];
    $scope.dateYear1 = $scope.ymd.split('/')[0];

    function GetWeek() {
        var weekIndex = new Date().getDay();
        switch (weekIndex) {
            case 0:
                b = "Sunday";
                break;
            case 1:
                b = "Monday";
                break;
            case 2:
                b = "Tuesday";
                break;
            case 3:
                b = "Wednesday";
                break;
            case 4:
                b = "Thursday";
                break;
            case 5:
                b = "Friday";
                break;
            case 6:
                b = "Saturday";
                break;
        }
        $scope.week = b;
    }

    GetWeek();//获取星期

    //Inform
    $scope.Inform = function (professorId) {
        $http({
            method: "post",
            url: $scope.baseurl + "/homework/professor/news?professorId=" + professorId,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.InformList = resdata.data.data;

                var html = '';
                angular.forEach($scope.InformList, function (value, index) {
                    html += '<div class="crc-conBox"><div class="crc-time">' + value.createTime.substr(0, 10) + '</div><paragraph>' + value.taskDesc + '</paragraph></div>';
                })
                html += '<div class="crc-conBox"><div class="crc-time">2018-05-28</div><paragraph>开学报名时间是2018年05月27日，请同学们带好身份证或者护照，前往指定地点报到</paragraph></div>';
                $("#informList").html(html);
            } else {
            }
        });
    }
    $scope.Inform($scope.professorId);

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

    //var time2 = new Date().Format("yyyy-MM-dd");
    //新增作业
    $scope.UpLoadWork = function () {
        if (storage.getItem("taskType") == 1 && $("#fileUrl").val() == "") {
            alert("Homework必须上传作业附件");
            return false;
        }
        var formData = new FormData();
        var startTime = $scope.dateYear1.toString() + "-" + $scope.dateMonth1.toString() + "-" + $scope.dateDay1.toString();
        var endTime = $scope.dateYear2.toString() + "-" + $scope.dateMonth2.toString() + "-" + $scope.dateDay2.toString();
        $http({
            method: "post",
            url: $scope.baseurl + "/homework/professor/add?courseArrangeId=" + storage.getItem("courseArrangeId") + "&courseId=" + storage.getItem("courseId") + "&courseCode=" + storage.getItem("courseCode") + "&taskType=" + storage.getItem("taskType") + "&startTime=" + startTime + "&endTime=" + endTime + "&attachUrl=" + encodeURIComponent($("#fileUrl").val()) + "&desc=" + $scope.description + "&totalScore=" + $scope.fullMark + "&professorId=" + $scope.professorId,
            dataType: "text",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                //关窗
                $(".teacherSystemShade1").css("display", "none");

                if (resdata.data.data.id > 0) {
                    //演讲插入数据
                    // //演讲
                    if (resdata.data.data.taskType == 2) {
                        $http({
                            method: "post",
                            url: $scope.baseurl + "/homeWork/student/add?courseId=" + resdata.data.data.taskCourseId + "&courseCode=" + resdata.data.data.taskCourseCode + "&taskId=" + resdata.data.data.id + "&taskType=2&attachUrl=&desc=&userId=" + storage.getItem("studentId"),
                            dataType: "text",
                            data: JSON.stringify($scope.FilterPanel),
                            headers: {"Content-Type": "application/json;charset=utf-8"}
                        }).then(function (data) {
                            var resdata = angular.fromJson(data);
                            if (resdata.data.code == 0) {//成功
                            } else {
                            }
                        });
                    }
                }

                //去缓存
                //刷新
                location.reload();
            } else {
                alert(resdata.data.info);
            }
        });

    }
    //作业类型
    $scope.GetAssignment = function (type) {
        storage.setItem("taskType", type);
    }

    $scope.uploadFile2 = function (index, userHomeWorkId) {
        $scope.userHomeWorkId = userHomeWorkId;
        $scope.studentName = storage.getItem("nameCn");
        var score;
        switch (index) {
            case 0:
                score = $scope.Score0
                break;
            case 1:
                score = $scope.Score1
                break;
            case 2:
                score = $scope.Score2
                break;
            case 3:
                score = $scope.Score3
                break;
            case 4:
                score = $scope.Score4
                break;
        }
        $scope.ScoreNew = (score == undefined ? 0 : score);
        var w = document.documentElement.clientWidth || document.body.clientWidth;
        var h = document.documentElement.clientHeight || document.body.clientHeight;
        $(".teacherSystemShade2").css({"width": w, "height": h, "display": "block"});
    }
    //提交分数
    $scope.SubScore = function (Score) {
        var userHomeWorkId = $scope.userHomeWorkId;
        $http({
            method: "post",
            url: $scope.baseurl + "/homework/professor/giveScore?userHomeWorkId=" + userHomeWorkId + "&score=" + Score,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                //打分成功 关闭 并修改
                $(".teacherSystemShade2").css("display", "none");

                location.reload();
            } else {
            }
        });

    }

    $scope.DownFileDoc = function (id) {
        var url = $scope.DocList[id];
        if ((url == null || url == NaN || url == "")) {
            return false;
        } else {
            downloadFile($scope.baseurl + url);
        }
    }

    $(".cl-courseNumUnSel").each(function (index, value) {
        alert(3)
        $(this).click(function () {
            alert(4)
            $(this)[0].className = 'cl-courseNumSel';
            $(this).siblings('span').each(function (index, value) {
                value.className = 'cl-courseNumUnSel';
            });
        })
    });
    $("#studengListHtml div").each(function (index, value) {
        $(this).click(function () {
            alert(4)
            $(this)[0].className = 'cl-courseNumSel';
            $(this).siblings('span').each(function (index, value) {
                value.className = 'cl-courseNumUnSel';
            });
        })
    });
});

//上传文件
function change() {
    document.getElementById("upload_file_tmp").value = document.getElementById("upload_file").value;
    var formData = new FormData();
    formData.append("file", $("#upload_file")[0].files[0]);
    $.ajax({
        url: getApiUrl() + "/homework/professor/attach/upload",
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

