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
    })
}])

indexManager.filter('trustHtml', ['$sce', function ($sce) {
    return function (text) {
        return $sce.trustAsHtml(text);
    };
}]);
