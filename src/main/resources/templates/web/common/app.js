/**
 * Created by Administrator on 2016/10/10 0010.
 */
var blog = angular.module("blog", ['ngSanitize', 'ngRoute']);

blog.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '/web/common/blogList.html',
        controller: 'blogController'
    }).when('/blog/list/:id', {
        templateUrl: '/web/blogInfo.html',
        controller: 'blogController'
    }).otherwise({
        redirectTo: '/'
    });
}])

blog.filter('trustHtml', ['$sce', function ($sce) {
    return function (text) {
//        console.info($sce.getTrustedHtml(text))
        return $sce.trustAsHtml(text);
    };
}]);
