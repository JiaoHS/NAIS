myApp.controller('chooseCoursesController', function ($scope, $http) {
    var storage;
    $scope.courseId = [];
    $scope.baseurl = getApiUrl();
    $scope.FilterPanel = [];

    if (!window.localStorage) {
        alert("浏览器支持localstorage");
    } else {
        storage = window.localStorage;
        // return false;
    }
    //将tab加入缓存
    storage.setItem("Selected", 'chooseCourses');
    //定义一个 字典嵌套数组 tab对应选课
    storage.removeItem("courseDic")
    var dict = {
        "course1": [],
        "course2": [],
        "course3": [],
        "course4": []
    };
    storage.setItem("tabId", "course1");//默认课程一
    if (storage.getItem("courseDic") == null) {
        storage.setItem("courseDic", JSON.stringify(dict));
    }


    $scope.schoolId = storage.getItem("schoolId");
    //$scope.courseId = storage.getItem("courseId");
    // if ($scope.schoolId == null || $scope.courseId == null) {
    //     window.location.href = $scope.baseurl + "/user/home#/protocol";
    // }
    $scope.GetCourseList = function (schoolId) {
        $http({
            method: "post",
            url: $scope.baseurl + "/campusCourse/show?campusId=" + schoolId,
            dataType: "json",
            data: JSON.stringify($scope.FilterPanel),
            headers: {"Content-Type": "application/json;charset=utf-8"}
        }).then(function (data) {
            var resdata = angular.fromJson(data);
            if (resdata.data.code == 0) {//成功
                $scope.CourseList = new Array();
                $scope.CourseList = resdata.data.data;
                var html = "<tr><th>时间安排</th><th>课程名称</th><th>课号</th><th>授课教师</th><th>操作</th></tr>";
                var count = 0;
                if ($scope.CourseList.length > 0 && $scope.CourseList != null && $scope.CourseList[0].list.length > 0) {
                    angular.forEach($scope.CourseList, function (value, key) {
                        count = value.list.length;
                        html += '<tr><td rowspan="' + count + '">' + value.timeSpan + '</td>';
                        angular.forEach(value.list, function (va, key) {
                            $scope.SchoolName = va.schoolNameCn;
                            if (key == 0) {

                                html += '<td>' + va.courseName + '</td><td>' + va.courseCode + '</td><td>' + va.professorNameCn + '<br/>' + va.schoolNameCn + '</td><td><input type="checkbox" id="' + va.id + '" class="ck"/></td></tr>';
                            }
                            if (key > 0) {
                                html += '<tr><td>' + va.courseName + '</td><td>' + va.courseCode + '</td><td>' + va.professorNameCn + '<br/>' + va.schoolNameCn + '</td><td><input type="checkbox" id="' + va.id + '" class="ck"/></td></tr>';
                            }
                        });
                        html += '</tr>';
                    });
                }
                $("#courselist2").html(html);//加载所有的校区信息


                $("#courselist2").find('input:checkbox').each(function () { //遍历所有复选框并附加事件
                    $(this).click(function () {
                        var flag = true;
                        var tabId = storage.getItem("tabId");
                        if ($(this).prop('checked') == true) {//当前被选中
                            flag = true;//其他的disabled=true
                            dict = JSON.parse(storage.getItem("courseDic"));
                            dict[tabId].push($(this)[0].id);
                            storage.setItem("courseDic", JSON.stringify(dict));
                            $scope.courseId.splice(0, $scope.courseId.length);
                            //dict = JSON.parse(storage.getItem("courseDic"));
                            for (var course in dict) {
                                if (dict[course].length > 0) {
                                    for (c = 0; c < dict[course].length; c++) {
                                        $scope.courseId.push(dict[course][c]);
                                    }
                                }
                            }
                            if ($scope.courseId.length >= 4) { //达到四门课 待定就置灰
                                $("#ckBtn").attr("disabled", true);//待定置灰
                                //所有课程复选框 置灰  除了已选课程
                                $("#courselist2").find('input:checkbox').each(function (index, value) {
                                    var flag = $scope.courseId.indexOf(value.id);
                                    if (flag >= 0) {
                                        $(this).attr("checked", "checked");
                                    } else {
                                        $(this).attr("disabled", "disabled");
                                    }
                                    // for (j = 0; j < $scope.courseId.length; j++) {
                                    //     if ($scope.courseId[j] == value.id) {
                                    //         //当前被选中  其他的置灰
                                    //         flag = true;
                                    //         $(this).attr("checked", "checked");
                                    //         // var timespan = $(this).parent().siblings().eq(0)[0].innerHTML.substr(0, 2);
                                    //         // if (timespan < 25) {//当前是组内时间戳，也就是组内第一个
                                    //         //     $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                    //         //         var tempTime = value.children[0].innerHTML.substr(0, 2);
                                    //         //         value.children[3].children[0].disabled = flag;
                                    //         //         if (tempTime < 25) {
                                    //         //             //下一组第一个
                                    //         //             return false;
                                    //         //         }
                                    //         //     })
                                    //         // } else {
                                    //         //     //不是时间戳,往前往后each
                                    //         //     $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                    //         //         var tempTime = value.children[0].innerHTML.substr(0, 2);
                                    //         //         if (tempTime < 25) {
                                    //         //             //下一组第一个
                                    //         //             return false;
                                    //         //         } else {
                                    //         //             value.children[3].children[0].disabled = flag;
                                    //         //         }
                                    //         //     })
                                    //         //     $(this).parent().parent().prevAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                    //         //         var tempTime = value.children[0].innerHTML.substr(0, 2);
                                    //         //         if (tempTime < 25) {
                                    //         //             //下一组第一个 往前的时候包括第一个 有5个元素
                                    //         //             value.children[4].children[0].disabled = flag;
                                    //         //             return false;
                                    //         //         } else {
                                    //         //             value.children[3].children[0].disabled = flag;
                                    //         //         }
                                    //         //     })
                                    //         // }
                                    //     }
                                    //     else {
                                    //         //不是选过的  全置灰
                                    //         $(this).attr("disabled", "disabled");
                                    //     }
                                    // }
                                });
                            } else {
                                var timespan = $(this).parent().siblings().eq(0)[0].innerHTML.substr(0, 2);
                                if (timespan < 25) {//当前是组内时间戳，也就是组内第一个
                                    $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                        var tempTime = value.children[0].innerHTML.substr(0, 2);
                                        value.children[3].children[0].disabled = flag;
                                        if (tempTime < 25) {
                                            //下一组第一个
                                            return false;
                                        }

                                    })
                                } else {
                                    //不是时间戳,往前往后each
                                    $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                        var tempTime = value.children[0].innerHTML.substr(0, 2);
                                        if (tempTime < 25) {
                                            //下一组第一个
                                            return false;
                                        } else {
                                            value.children[3].children[0].disabled = flag;
                                        }
                                    })
                                    $(this).parent().parent().prevAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                        var tempTime = value.children[0].innerHTML.substr(0, 2);
                                        if (tempTime < 25) {
                                            //下一组第一个 往前的时候包括第一个 有5个元素
                                            value.children[4].children[0].disabled = flag;
                                            return false;
                                        } else {
                                            value.children[3].children[0].disabled = flag;
                                        }
                                    })
                                }
                            }
                        } else {
                            flag = false;//当前没被选中 其他的disabled=false
                            //$scope.courseId.pop($(this)[0].id);
                            $scope.courseId.splice(0, $scope.courseId.length);
                            dict = JSON.parse(storage.getItem("courseDic"));
                            for (var course in dict) {
                                var index = dict[course].indexOf($(this)[0].id)
                                if (index >= 0) {
                                    dict[course].remove($(this)[0].id);//移除已存在的courseId
                                    // dict[course].remove(-1);
                                }
                                for (c = 0; c < dict[course].length; c++) {
                                    $scope.courseId.push(dict[course][c]);
                                }
                            }
                            if ($scope.courseId.length < 4) { //达到四门课 待定就置灰
                                $("#ckBtn").attr("disabled", false);
                                //少于四门其他的可选
                                //循环所有 跟选中相等的时候置灰  不等的时候 可选
                                storage.setItem("courseDic", JSON.stringify(dict));
                                var tempListEd = [];
                                if ($scope.courseId.length > 0) {
                                    for (m = 0; m < $scope.courseId.length; m++) {//循环所有已选课程
                                        $("#courselist2").find('input:checkbox').each(function (index, value) {
                                            if ($scope.courseId[m] == value.id) {
                                                flag = true;
                                                $(this).attr("checked", true);
                                                var timespan = $(this).parent().siblings().eq(0)[0].innerHTML.substr(0, 2);
                                                if (timespan < 25) {//当前是组内时间戳，也就是组内第一个
                                                    $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                                        var tempTime = value.children[0].innerHTML.substr(0, 2);
                                                        value.children[3].children[0].disabled = flag;
                                                        tempListEd.push(value.children[3].children[0].id);
                                                        if (tempTime < 25) {
                                                            //下一组第一个
                                                            return false;
                                                        }
                                                    })
                                                } else {
                                                    //不是时间戳,往前往后each
                                                    $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                                        var tempTime = value.children[0].innerHTML.substr(0, 2);
                                                        if (tempTime < 25) {
                                                            //下一组第一个
                                                            return false;
                                                        } else {
                                                            value.children[3].children[0].disabled = flag;
                                                            tempListEd.push(value.children[3].children[0].id);
                                                        }
                                                    })
                                                    $(this).parent().parent().prevAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                                        var tempTime = value.children[0].innerHTML.substr(0, 2);
                                                        if (tempTime < 25) {
                                                            //下一组第一个 往前的时候包括第一个 有5个元素
                                                            value.children[4].children[0].disabled = flag;
                                                            tempListEd.push(value.children[4].children[0].id);
                                                            return false;
                                                        } else {
                                                            value.children[3].children[0].disabled = flag;
                                                            tempListEd.push(value.children[3].children[0].id);
                                                        }
                                                    })
                                                }
                                            } else {
                                                var v = tempListEd.indexOf(value.id);
                                                if (v < 0) {//包含在已处理的数组里
                                                    $(this).attr("disabled", false);
                                                }
                                            }
                                            // var flag = $scope.courseId.indexOf(value.id);
                                            // if (flag >= 0) { //跟选中相等的时候置灰
                                            //     flag = true;
                                            //
                                            //     var timespan = $(this).parent().siblings().eq(0)[0].innerHTML.substr(0, 2);
                                            //     if (timespan < 25) {//当前是组内时间戳，也就是组内第一个
                                            //         $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            //             var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            //             value.children[3].children[0].disabled = flag;
                                            //             if (tempTime < 25) {
                                            //                 //下一组第一个
                                            //                 return false;
                                            //             }
                                            //         })
                                            //     } else {
                                            //         //不是时间戳,往前往后each
                                            //         $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            //             var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            //             if (tempTime < 25) {
                                            //                 //下一组第一个
                                            //                 return false;
                                            //             } else {
                                            //                 value.children[3].children[0].disabled = flag;
                                            //             }
                                            //         })
                                            //         $(this).parent().parent().prevAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            //             var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            //             if (tempTime < 25) {
                                            //                 //下一组第一个 往前的时候包括第一个 有5个元素
                                            //                 value.children[4].children[0].disabled = flag;
                                            //                 return false;
                                            //             } else {
                                            //                 value.children[3].children[0].disabled = flag;
                                            //             }
                                            //         })
                                            //     }
                                            // } else {
                                            //     flag = false;
                                            //     //storage.setItem("courseDic", JSON.stringify(dict));
                                            //     var timespan = $(this).parent().siblings().eq(0)[0].innerHTML.substr(0, 2);
                                            //     if (timespan < 25) {//当前是组内时间戳，也就是组内第一个
                                            //         $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            //             var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            //             value.children[3].children[0].disabled = flag;
                                            //             if (tempTime < 25) {
                                            //                 //下一组第一个
                                            //                 return false;
                                            //             }
                                            //
                                            //         })
                                            //     } else {
                                            //         //不是时间戳,往前往后each
                                            //         $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            //             var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            //             if (tempTime < 25) {
                                            //                 //下一组第一个
                                            //                 return false;
                                            //             } else {
                                            //                 value.children[3].children[0].disabled = flag;
                                            //             }
                                            //         })
                                            //         $(this).parent().parent().prevAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            //             var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            //             if (tempTime < 25) {
                                            //                 //下一组第一个 往前的时候包括第一个 有5个元素
                                            //                 value.children[4].children[0].disabled = flag;
                                            //                 return false;
                                            //             } else {
                                            //                 value.children[3].children[0].disabled = flag;
                                            //             }
                                            //         })
                                            //     }
                                            // }
                                            // for (j = 0; j < $scope.courseId.length; j++) {
                                            //     if ($scope.courseId[j] == value.id) {
                                            //         //当前被选中  其他的置灰
                                            //         flag = true;
                                            //         $(this).attr("checked", "checked");
                                            //         // var timespan = $(this).parent().siblings().eq(0)[0].innerHTML.substr(0, 2);
                                            //         // if (timespan < 25) {//当前是组内时间戳，也就是组内第一个
                                            //         //     $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            //         //         var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            //         //         value.children[3].children[0].disabled = flag;
                                            //         //         if (tempTime < 25) {
                                            //         //             //下一组第一个
                                            //         //             return false;
                                            //         //         }
                                            //         //     })
                                            //         // } else {
                                            //         //     //不是时间戳,往前往后each
                                            //         //     $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            //         //         var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            //         //         if (tempTime < 25) {
                                            //         //             //下一组第一个
                                            //         //             return false;
                                            //         //         } else {
                                            //         //             value.children[3].children[0].disabled = flag;
                                            //         //         }
                                            //         //     })
                                            //         //     $(this).parent().parent().prevAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            //         //         var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            //         //         if (tempTime < 25) {
                                            //         //             //下一组第一个 往前的时候包括第一个 有5个元素
                                            //         //             value.children[4].children[0].disabled = flag;
                                            //         //             return false;
                                            //         //         } else {
                                            //         //             value.children[3].children[0].disabled = flag;
                                            //         //         }
                                            //         //     })
                                            //         // }
                                            //     }
                                            //     else {
                                            //         //不是选过的  全置灰
                                            //         $(this).attr("disabled", "disabled");
                                            //     }
                                            // }
                                        });
                                    }
                                }
                                else {
                                    $("#courselist2").find('input:checkbox').each(function (index, value) {
                                        $(this).attr("disabled", false);
                                    });
                                }


                            }

                            // $scope.courseId.remove($(this)[0].id);
                            // dict[tabId] = $scope.courseId;

                        }

                    })
                });


                // if (storage.getItem("courseDic") != null) {//返回的时候 自动加载
                //     var CourseList = [];
                //     //获取dict tab
                //     dict = JSON.parse(storage.getItem("courseDic"));
                //     var tab = storage.getItem("tabId");
                //     for (var course in dict) {
                //         if (dict[course].length > 0) {
                //             for (c = 0; c < dict[course].length; c++) {
                //                 CourseList.push(dict[course][c]);
                //             }
                //         }
                //     }
                //     if (CourseList.indexOf("-1") >= 0 && dict[tab].indexOf("-1") >= 0) {
                //         $("#ckBtn").attr("checked", true);
                //         $("#ckBtn").attr("disabled", false);
                //     } else {
                //         if (CourseList.length >= 4) {
                //             $("#ckBtn").attr("checked", false);
                //             $("#ckBtn").attr("disabled", true);
                //         } else {
                //             if (dict[tab].length > 0) {//有东西
                //                 $("#ckBtn").attr("disabled", true);
                //                 $("#ckBtn").attr("checked", false);
                //             } else {
                //                 $("#ckBtn").attr("disabled", false);
                //                 $("#ckBtn").attr("checked", false);
                //             }
                //
                //         }
                //     }
                //
                //     if (CourseList.length >= 4) {
                //         var indexNum = CourseList.indexOf("-1");
                //         if (indexNum >= 0) {
                //             $("#ckBtn").attr("checked", true);//选中
                //         } else {
                //             $("#ckBtn").attr("disabled", true);//待定置灰
                //         }
                //
                //         $("#courselist2").find('input:checkbox').each(function (index, value) { //遍历所有复选框
                //             //循环 $scope.courseId
                //             if (CourseList.length < 0) {
                //                 return false;
                //             } else {
                //                 //循环 $scope.courseId
                //                 var flag = CourseList.indexOf(value.id);
                //                 if (flag >= 0) {
                //                     $(this).attr("checked", "checked");
                //                 } else {
                //                     $(this).attr("disabled", "disabled");
                //                 }
                //             }
                //         });
                //     } else {
                //         $("#courselist2").find('input:checkbox').each(function (index, value) { //遍历所有复选框
                //             //循环 $scope.courseId
                //             if (CourseList.length < 0) {
                //                 return false;
                //             } else {
                //                 //循环 $scope.courseId
                //                 var flag = true;
                //                 for (j = 0; j < CourseList.length; j++) {
                //                     if (CourseList[j] == value.id) {
                //                         //当前被选中  其他的置灰
                //                         flag = true;
                //                         $(this).attr("checked", "checked");
                //                         var timespan = $(this).parent().siblings().eq(0)[0].innerHTML.substr(0, 2);
                //                         if (timespan < 25) {//当前是组内时间戳，也就是组内第一个
                //                             $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                //                                 var tempTime = value.children[0].innerHTML.substr(0, 2);
                //                                 value.children[3].children[0].disabled = flag;
                //                                 if (tempTime < 25) {
                //                                     //下一组第一个
                //                                     return false;
                //                                 }
                //                             })
                //                         } else {
                //                             //不是时间戳,往前往后each
                //                             $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                //                                 var tempTime = value.children[0].innerHTML.substr(0, 2);
                //                                 if (tempTime < 25) {
                //                                     //下一组第一个
                //                                     return false;
                //                                 } else {
                //                                     value.children[3].children[0].disabled = flag;
                //                                 }
                //                             })
                //                             $(this).parent().parent().prevAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                //                                 var tempTime = value.children[0].innerHTML.substr(0, 2);
                //                                 if (tempTime < 25) {
                //                                     //下一组第一个 往前的时候包括第一个 有5个元素
                //                                     value.children[4].children[0].disabled = flag;
                //                                     return false;
                //                                 } else {
                //                                     value.children[3].children[0].disabled = flag;
                //                                 }
                //                             })
                //                         }
                //                     }
                //                 }
                //             }
                //         });
                //     }
                // }
            } else {
                alert(resdata.data.info);
            }
        });
    }
    Array.prototype.indexOf = function (val) {
        for (var i = 0; i < this.length; i++) {
            if (this[i] == val) return i;
        }
        return -1;
    };
    Array.prototype.remove = function (val) {
        var index = this.indexOf(val);
        if (index > -1) {
            this.splice(index, 1);
        }
    };

    $scope.SkipIndex = function () {
        window.location.href = $scope.baseurl;
    }
    if ($scope.schoolId == -1) {
        //隐藏其他复选框 disabled按钮 跳过  待定
        $scope.SchoolName = "未选择";
        $("#ckBtn").attr("checked", true);
        //隐藏
        $scope.mriCourseShow = false;
        $scope.courseId.push(-1);
        storage.setItem("courseId", $scope.courseId);
    } else {
        //显示
        $scope.mriCourseShow = true;
        //调后台接口
        $scope.GetCourseList($scope.schoolId);
    }


    // $scope.SubCourse = function () {
    //     //加入缓存
    //     if (storage.getItem("courseId")) {
    //         storage.removeItem("courseId")
    //     }
    //     storage.setItem("courseId", $scope.courseId);
    //     //跳转
    //     window.location.href = $scope.baseurl + "coursesOrderPreview";
    // }
    $scope.SkipCheckBox = function (MyCourseList) {
        var CourseList = new Array();
        CourseList = MyCourseList;
        //获取dict tab
        dict = JSON.parse(storage.getItem("courseDic"));
        var tab = storage.getItem("tabId");
        if (CourseList.indexOf("-1") >= 0 && dict[tab].indexOf("-1") >= 0) {
            $("#ckBtn").prop("checked", true);
            $("#ckBtn").attr("disabled", false);
        } else {
            if (CourseList.length >= 4) {
                $("#ckBtn").prop("checked", false);
                $("#ckBtn").attr("disabled", true);
            } else {
                if (dict[tab].length > 0) {//有东西
                    //$("#ckBtn").attr("disabled", true);
                    $("#ckBtn").prop("checked", false);
                    $("#ckBtn").prop("disabled", false);
                } else {
                    $("#ckBtn").prop("checked", false);
                    $("#ckBtn").prop("disabled", false);
                    //更新其他复选框
                    if (CourseList.length < 4) { //达到四门课 待定就置灰
                        //少于四门其他的可选
                        //循环所有 跟选中相等的时候置灰  不等的时候 可选
                        var tempListEd = [];
                        for (m = 0; m < CourseList.length; m++) {//循环所有已选课程
                            $("#courselist2").find('input:checkbox').each(function (index, value) {
                                if (CourseList[m] == value.id) {
                                    flag = true;
                                    $(this).attr("checked", true);
                                    var timespan = $(this).parent().siblings().eq(0)[0].innerHTML.substr(0, 2);
                                    if (timespan < 25) {//当前是组内时间戳，也就是组内第一个
                                        $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            value.children[3].children[0].disabled = flag;
                                            tempListEd.push(value.children[3].children[0].id);
                                            if (tempTime < 25) {
                                                //下一组第一个
                                                return false;
                                            }
                                        })
                                    } else {
                                        //不是时间戳,往前往后each
                                        $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            if (tempTime < 25) {
                                                //下一组第一个
                                                return false;
                                            } else {
                                                value.children[3].children[0].disabled = flag;
                                                tempListEd.push(value.children[3].children[0].id);
                                            }
                                        })
                                        $(this).parent().parent().prevAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            if (tempTime < 25) {
                                                //下一组第一个 往前的时候包括第一个 有5个元素
                                                value.children[4].children[0].disabled = flag;
                                                tempListEd.push(value.children[4].children[0].id);
                                                return false;
                                            } else {
                                                value.children[3].children[0].disabled = flag;
                                                tempListEd.push(value.children[3].children[0].id);
                                            }
                                        })
                                    }
                                } else {
                                    var v = tempListEd.indexOf(value.id);
                                    if (v < 0) {//包含在已处理的数组里
                                        $(this).prop("disabled", false);
                                    }
                                }
                            });
                        }
                    }


                }

            }
        }
        //遍历所有复选框
        $("#courselist2").find('input:checkbox').each(function (index, value) {
            //循环 $scope.courseId
            if (CourseList.length <= 0) {
                return false;//返回所有
            } else {
                //循环 返回已选中的课
                var flag = true;
                for (j = 0; j < CourseList.length; j++) {
                    if (CourseList[j] == "-1") {
                        continue;
                    }
                    if (CourseList[j] == value.id) {
                        //当前被选中  其他的置灰
                        flag = true;
                        var timespan = $(this).parent().siblings().eq(0)[0].innerHTML.substr(0, 2);
                        if (timespan < 25) {//当前是组内时间戳，也就是组内第一个
                            $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                var tempTime = value.children[0].innerHTML.substr(0, 2);
                                value.children[3].children[0].disabled = flag;
                                if (tempTime < 25) {
                                    //下一组第一个
                                    return false;
                                }
                            })
                        } else {
                            //不是时间戳,往前往后each
                            $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                var tempTime = value.children[0].innerHTML.substr(0, 2);
                                if (tempTime < 25) {
                                    //下一组第一个
                                    return false;
                                } else {
                                    value.children[3].children[0].disabled = flag;
                                }
                            })
                            $(this).parent().parent().prevAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                var tempTime = value.children[0].innerHTML.substr(0, 2);
                                if (tempTime < 25) {
                                    //下一组第一个 往前的时候包括第一个 有5个元素
                                    value.children[4].children[0].disabled = flag;
                                    return false;
                                } else {
                                    value.children[3].children[0].disabled = flag;
                                }
                            })
                        }
                    }
                }

            }
        });
    }
    $(".mri-course div").each(function (index, value) {
        if (value.id == storage.getItem("tabId")) {
            $(this).prop('class', 'SelectedDiv').siblings().prop('class', 'unSelectedDiv');
        }
        $(this).click(function () {
            //当前tab加入缓存
            storage.setItem("tabId", $(this)[0].id);
            $scope.courseId.splice(0, $scope.courseId.length);//清空$scope.courseId
            $(this).prop('class', 'SelectedDiv').siblings().prop('class', 'unSelectedDiv');
            //请求刷新一次  复选框的状态
            //循环所有的复选框

            //取dict是否有缓存
            dict = JSON.parse(storage.getItem("courseDic"));
            //取出数据循环
            $scope.courseId.splice(0, $scope.courseId.length);
            for (var course in dict) {
                for (c = 0; c < dict[course].length; c++) {
                    $scope.courseId.push(dict[course][c]);
                }
            }
            $scope.SkipCheckBox($scope.courseId);
        })
    });

    $scope.DaiDing = function () {
        //查缓存
        var tabId = storage.getItem("tabId")
        dict = JSON.parse(storage.getItem("courseDic"));
        $scope.courseId.splice(0, $scope.courseId.length);
        for (var course in dict) {
            for (c = 0; c < dict[course].length; c++) {
                $scope.courseId.push(dict[course][c]);//当前已选课程集合
            }
        }
        //todo  做判断 复选  是否选中
        if ($("#ckBtn")[0].checked) {//当前是选中 -1待定
            if (dict[tabId].length > 0) { //如果已选 不能待定
                if (dict[tabId][0] == "-1") {//如果已选为-1  取消选定
                    $("#ckBtn").attr("checked", false);
                    $scope.courseId.remove(dict[tabId][0]);
                    //更新其他复选框
                    if ($scope.courseId.length < 4) { //达到四门课 待定就置灰
                        //少于四门其他的可选
                        //循环所有 跟选中相等的时候置灰  不等的时候 可选
                        var tempListEd = [];
                        for (m = 0; m < $scope.courseId.length; m++) {//循环所有已选课程
                            $("#courselist2").find('input:checkbox').each(function (index, value) {
                                if ($scope.courseId[m] == value.id) {//等于当前已选的  处于选中状态
                                    flag = true;
                                    $(this).attr("checked", true);
                                    var timespan = $(this).parent().siblings().eq(0)[0].innerHTML.substr(0, 2);
                                    if (timespan < 25) {//当前是组内时间戳，也就是组内第一个
                                        $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            value.children[3].children[0].disabled = flag;
                                            tempListEd.push(value.children[3].children[0].id);
                                            if (tempTime < 25) {
                                                //下一组第一个
                                                return false;
                                            }
                                        })
                                    } else {
                                        //不是时间戳,往前往后each
                                        $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            if (tempTime < 25) {
                                                //下一组第一个
                                                return false;
                                            } else {
                                                value.children[3].children[0].disabled = flag;
                                                tempListEd.push(value.children[3].children[0].id);
                                            }
                                        })
                                        $(this).parent().parent().prevAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                            var tempTime = value.children[0].innerHTML.substr(0, 2);
                                            if (tempTime < 25) {
                                                //下一组第一个 往前的时候包括第一个 有5个元素
                                                value.children[4].children[0].disabled = flag;
                                                tempListEd.push(value.children[4].children[0].id);
                                                return false;
                                            } else {
                                                value.children[3].children[0].disabled = flag;
                                                tempListEd.push(value.children[3].children[0].id);
                                            }
                                        })
                                    }
                                } else {
                                    var v = tempListEd.indexOf(value.id);
                                    if (v < 0) {//不包含在已处理的数组里
                                        $(this).attr("disabled", false);
                                    }
                                }
                            });
                        }
                    }
                    dict[tabId] = [];
                    storage.setItem("courseDic", JSON.stringify(dict));//更新缓存
                } else {
                    $("#ckBtn").attr("checked", false)
                    alert("当前课程已选,不能待定,请选择其他课程");
                }
                return false;
            } else {//当前tab未选择
                if ($scope.courseId.length < 4) {
                    dict[tabId].push("-1");
                    storage.setItem("courseDic", JSON.stringify(dict));//当前存入缓存
                    $scope.courseId.push("-1");
                    $("#ckBtn").attr("checked", true);//当前选中
                    //$("#ckBtn").attr("disabled", "disabled");//待定置灰
                    $("#courselist2").find('input:checkbox').each(function (index, value) { //遍历所有复选框
                        //循环 $scope.courseId
                        if ($scope.courseId.length < 0) {
                            return false;
                        } else {
                            //循环 $scope.courseId
                            var flag = $scope.courseId.indexOf(value.id);
                            if (flag >= 0) {
                                $(this).attr("checked", "checked");
                            } else {
                                $(this).attr("disabled", "disabled");
                            }
                        }
                    });
                } else {
                    //当前tab未选择但是选课 已超过四门
                    alert("当前选择已超过四门");
                    return false;
                }
            }
        } else {//点击的时候没被选中  取消选中
            $scope.courseId.remove("-1");
            //缓存减去-1
            for (var course in dict) {
                for (c = 0; c < dict[course].length; c++) {
                    if (dict[course][c].indexOf("-1") >= 0) {
                        dict[course] = [];
                        //return false;
                    }
                }
            }
            //dict[tabId] = [];
            storage.setItem("courseDic", JSON.stringify(dict));//更新缓存
            //更新其他复选框
            if ($scope.courseId.length < 4) { //达到四门课 待定就置灰
                //少于四门其他的可选
                //循环所有 跟选中相等的时候置灰  不等的时候 可选
                var tempListEd = [];
                for (m = 0; m < $scope.courseId.length; m++) {//循环所有已选课程
                    $("#courselist2").find('input:checkbox').each(function (index, value) {
                        if ($scope.courseId[m] == value.id) {
                            flag = true;
                            $(this).attr("checked", true);
                            var timespan = $(this).parent().siblings().eq(0)[0].innerHTML.substr(0, 2);
                            if (timespan < 25) {//当前是组内时间戳，也就是组内第一个
                                $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                    var tempTime = value.children[0].innerHTML.substr(0, 2);
                                    value.children[3].children[0].disabled = flag;
                                    tempListEd.push(value.children[3].children[0].id);
                                    if (tempTime < 25) {
                                        //下一组第一个
                                        return false;
                                    }
                                })
                            } else {
                                //不是时间戳,往前往后each
                                $(this).parent().parent().nextAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                    var tempTime = value.children[0].innerHTML.substr(0, 2);
                                    if (tempTime < 25) {
                                        //下一组第一个
                                        return false;
                                    } else {
                                        value.children[3].children[0].disabled = flag;
                                        tempListEd.push(value.children[3].children[0].id);
                                    }
                                })
                                $(this).parent().parent().prevAll().each(function (index, value) {//当前的父节点的父节点tr下的第一个td
                                    var tempTime = value.children[0].innerHTML.substr(0, 2);
                                    if (tempTime < 25) {
                                        //下一组第一个 往前的时候包括第一个 有5个元素
                                        value.children[4].children[0].disabled = flag;
                                        tempListEd.push(value.children[4].children[0].id);
                                        return false;
                                    } else {
                                        value.children[3].children[0].disabled = flag;
                                        tempListEd.push(value.children[3].children[0].id);
                                    }
                                })
                            }
                        } else {
                            var v = tempListEd.indexOf(value.id);
                            if (v < 0) {//包含在已处理的数组里
                                $(this).attr("disabled", false);
                            }
                        }
                    });
                }
            }
        }
    }

});