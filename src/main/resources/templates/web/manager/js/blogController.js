/**
 * Created by Administrator on 2016/10/17 0017.
 */
indexManager.controller('blogController', function ($scope, $http) {
    $http.get('/blog/list/').success(function (data) {
        if (data.status == 0) {
            $scope.blogs = data.data
        } else {
            alert(222)
        }
    })
})