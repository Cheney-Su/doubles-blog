/**
 * Created by Administrator on 2016/10/16 0016.
 */
var loginManager = angular.module('loginManager', []);
var indexManager = angular.module("indexManager", ['ngSanitize', 'ngRoute']);

indexManager.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'blogList.html',
        controller: 'blogController'
    }).when('/blogInfo', {
        templateUrl: 'blogInfo.html',
        controller: 'blogController'
    }).when('/blog/list/:blogId', {
        templateUrl: 'blogInfo.html',
        controller: 'blogController'
    })
}])

indexManager.filter('trustHtml', ['$sce', function ($sce) {
    return function (text) {
        return $sce.trustAsHtml(text);
    };
}]);

indexManager.directive('ueditor', function () {
    return {
        restrict: 'AE',
        transclude: true,
        replace: true,
        template: '<script name="content" type="text/plain" ng-transclude>GGG</script>',
        require: '?ngModel',
        scope: {
            config: '='
        },
        link: function (scope, element, attrs, ngModel) {
            var editor = new UE.ui.Editor(scope.config || {});
            editor.render(element[0]);

            if (ngModel) {
                //Model数据更新时，更新百度UEditor
                ngModel.$render = function () {
                    try {
                        editor.setContent(ngModel.$viewValue);
                    } catch (e) {

                    }
                };

                //百度UEditor数据更新时，更新Model
                editor.addListener('contentChange', function () {
                    setTimeout(function () {
                        scope.$apply(function () {
                            ngModel.$setViewValue(editor.getContent());
                        })
                    }, 0);
                })
            }
        }
    }
});
