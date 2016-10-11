/**
 * Created by Administrator on 2016/10/10 0010.
 */
var blog = angular.module("blog", ['ngSanitize', 'ngRoute']);

blog.config(function ($routeProvider, $locationProvider) {
    $routeProvider.when('/blog/list/', {
        templateUrl: '/blogInfo.html',
        controller: 'blogController''
    });
})

blog.filter('trustHtml', ['$sce', function ($sce) {
    return function (text) {
//        console.info($sce.getTrustedHtml(text))
        return $sce.trustAsHtml(text);
    };
}]);
