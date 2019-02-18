var myApp = angular.module("myApp", ['ui.router', 'ui.bootstrap', 'ngAnimate'])
myApp.config(function ($stateProvider, $httpProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/index');
    $stateProvider.state("index", {
        url: "",
        controller: 'indexhomeController',
        templateUrl: "/indexhome"
    }).state("indexhome", {
        url: "/indexhome",
        controller: 'indexhomeController',
        templateUrl: "/indexhome"
    }).state("home", {
        url: "/home",
        controller: 'personHomeController',
        templateUrl: "home"
    }).state("personHome", {//页面 ui-self
        url: "/personHome", //页面url显示
        controller: 'personalInfoShowController',//jscontroller
        templateUrl: "info"//后台方法
    }).state("apply", {
        url: "/apply",
        controller: 'personalInfoSetController',
        templateUrl: "update"
    }).state("protocol", {
        url: "/protocol",
        controller: 'protocolController',
        templateUrl: "protocol"
    }).state("courseHome", {
        url: "/courseHome",
        controller: 'courseHomeController',
        templateUrl: "course"
    }).state("chooseCourses", {
        url: "/chooseCourses",
        controller: 'chooseCoursesController',
        templateUrl: "chooseCourses"
    }).state("changeLesson", {//更改课程
        url: "/changeLesson",
        controller: 'coursesOrderPreviewController',
        templateUrl: "coursesOrderPreview"
    }).state("payment", {
        url: "/payment",
        controller: 'coursesOrderReviewController',
        templateUrl: "coursesOrderReview"
    }).state("couponHome", {
        url: "/couponHome",
        controller: 'couponHomeController',
        templateUrl: "coupon"
    }).state("payWay", {
        url: "/payWay",
        controller: 'payWayController',
        templateUrl: "payWay"
    }).state("paySuccess", {
        url: "/paySuccess",
        controller: 'paySuccessController',
        templateUrl: "paySuccess"
    }).state("payFail", {
        url: "/payFail",
        controller: 'payFailController',
        templateUrl: "payFail"
    }).state("hotelHome", {
        url: "/hotelHome",
        controller: 'hotelHomeController',
        templateUrl: "hotel"
    }).state("orderCenter", {
        url: "/orderCenter",
        controller: 'orderCenterController',
        templateUrl: "orderCenter"
    }).state("hotelPay", {
        url: "/hotelPay",
        controller: 'hotelPayController',
        templateUrl: "hotelPay"
    }).state("campus", {
        url: "/campus",
        controller: 'campusController',
        templateUrl: "campus/campushome"
    }).state("teacher", {
        url: "/teacher",
        controller: 'teacherController',
        templateUrl: "professorList/professorhome"
    }).state("login", {
        url: "/login",
        controller: 'loginController',
        templateUrl: "user/login"
    }).state("register", {
        url: "/register",
        controller: 'registerController',
        templateUrl: "user/register"
    }).state("passwordReset", {
        url: "/passwordReset",
        controller: 'passwordResetController',
        templateUrl: "user/passwordReset"
    }).state("infoList", {
        url: "/infoList",
        controller: 'infoListController',
        templateUrl: "info/infoList"
    }).state("infoDetail", {
        url: "/infoDetail",
        controller: 'infoDetailController',
        templateUrl: "info/infoDetail"
    }).state("aboutUs", {
        url: "/aboutUs",
        controller: 'aboutUsController',
        templateUrl: "aboutUs"
    }).state("teacherHome", {
        url: "/teacherHome",
        controller: 'teacherHomeController',
        templateUrl: "teacherHome"
    }).state("teacherIndex", {
        url: "/teacherIndex",
        controller: 'teacherIndexController',
        templateUrl: "teacherIndex"
    }).state("application", {
        url: "/application",
        controller: 'applicationController',
        templateUrl: "application"
    }).state("normalQuestion", {
        url: "/normalQuestion",
        controller: 'normalQuestionController',
        templateUrl: "normalQuestion"
    }).state("applicationGuide", {
        url: "/applicationGuide",
        controller: 'applicationGuideController',
        templateUrl: "applicationGuide"
    }).state("translateGradeGuide", {
        url: "/translateGradeGuide",
        controller: 'translateGradeGuideController',
        templateUrl: "translateGradeGuide"
    }).state("academicStandards", {
        url: "/academicStandards",
        controller: 'academicStandardsController',
        templateUrl: "academicStandards"
    }).state("gradeStandards", {
        url: "/gradeStandards",
        controller: 'gradeStandardsController',
        templateUrl: "gradeStandards"
    }).state("teachingQualityEvaluation", {
        url: "/teachingQualityEvaluation",
        controller: 'teachingQualityEvaluationController',
        templateUrl: "teachingQualityEvaluation"
    }).state("transcriptCertification", {
        url: "/transcriptCertification",
        controller: 'transcriptCertificationController',
        templateUrl: "transcriptCertification"
    }).state("tuitionInformation", {
        url: "/tuitionInformation",
        controller: 'tuitionInformationController',
        templateUrl: "tuitionInformation"
    }).state("paymentInformation", {
        url: "/paymentInformation",
        controller: 'paymentInformationController',
        templateUrl: "paymentInformation"
    }).state("refundPolicy", {
        url: "/refundPolicy",
        controller: 'refundPolicyController',
        templateUrl: "refundPolicy"
    }).state("activity", {
        url: "/activity",
        controller: 'activityController',
        templateUrl: "info/activity"
    }).state("studentSystem", {
        url: "/studentSystem",
        controller: 'studentSystemController',
        templateUrl: "studentSystem"
    }).state("SelectCampus", {
        url: "/SelectCampus",
        controller: 'SelectCampusController',
        templateUrl: "SelectCampus"
    });

    $httpProvider.interceptors.push('myInterceptor');
});
myApp.config(['$compileProvider', function ($compileProvider) {
    $compileProvider.debugInfoEnabled(false);
}]);
//loading
myApp.factory('myInterceptor', ["$rootScope", function ($rootScope) {
    var timestampMarker = {
        request: function (config) {
            $rootScope.loading = true;
            return config;
        },
        requestError: function (response) {
            $rootScope.loading = false;
            return response;
        },
        response: function (response) {
            $rootScope.loading = false;
            return response;
        },
        responseError: function (response) {
            $rootScope.loading = false;
            return response;
        }

    };
    return timestampMarker;
}]);
// myApp.filter('trust2Html', ['$sce', function ($sce) {
//     return function (val) {
//         return $sce.trustAsHtml(val);
//     };
// }])

//过滤字段长度然后截取
myApp.filter('textLengthSet', function () {
    // cut:true:20:' ...'
    return function (value, wordwise, max, tail) {
        if (!value) return '';

        max = parseInt(max, 10);
        if (!max) return value;
        if (value.length <= max) return value;

        value = value.substr(0, max);
        if (wordwise) {
            var lastspace = value.lastIndexOf(' ');
            if (lastspace != -1) {
                value = value.substr(0, lastspace);
            }
        }

        return value + (tail || ' …');//'...'可以换成其它文字
    };
});
myApp.filter("parseHTML", function ($sce) {
    return function (text) {
        return $sce.trustAsHtml(text);
    }
})

//上传图片
myApp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs, ngModel) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            element.bind('change', function (event) {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
                //附件预览
                scope.file = (event.srcElement || event.target).files[0];
                //判断 类型
                if (scope.file.type.indexOf('/') >= 0) {
                    var type = scope.file.type.split('/')[1];
                    if (type != "jpg" && type != "png" && type != "jpeg") {
                        alert("图片仅支持png、jpg类型的文件");
                        scope.file = null;
                        return false;
                    }
                } else {
                    alert("图片仅支持png、jpg类型的文件");
                    scope.file = null;
                    return false;
                }

                scope.getFile();
            });
        }
    };
}]);
myApp.factory('fileReader', ["$q", "$log", function ($q, $log) {
    var onLoad = function (reader, deferred, scope) {
        return function () {
            scope.$apply(function () {
                deferred.resolve(reader.result);
            });
        };
    };

    var onError = function (reader, deferred, scope) {
        return function () {
            scope.$apply(function () {
                deferred.reject(reader.result);
            });
        };
    };

    var getReader = function (deferred, scope) {
        var reader = new FileReader();
        reader.onload = onLoad(reader, deferred, scope);
        reader.onerror = onError(reader, deferred, scope);
        return reader;
    };

    var readAsDataURL = function (file, scope) {
        var deferred = $q.defer();
        var reader = getReader(deferred, scope);
        reader.readAsDataURL(file);
        return deferred.promise;
    };

    return {
        readAsDataUrl: readAsDataURL
    };
}])
myApp.service('AuthenticationService', ['$http', '$q', function ($http,$q) {
    var storage;
    if (!window.localStorage) {
        alert("浏览器支持localstorage");
    } else {
        storage = window.localStorage;
    }
    this.GetCurrentUser = function () {
        var defer = $q.defer();
        //var url = getResourceUrl() + "/_api/Web/CurrentUser";
        //$http({
        //    method: "GET",
        //    url: url,
        //    headers: { "Content-Type": "application/json;charset=utf-8" }
        //}).success(function (data) {
        //    defer.resolve(data);
        //}).error(function (data, status, headers, config) {
        //    defer.reject("Error");
        //});
        defer.resolve({ "Id": storage.getItem("useracount"),"type": storage.getItem("personType")});
        return defer.promise;
    }


}]);