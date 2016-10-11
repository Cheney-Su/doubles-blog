/**
 * Created by Administrator on 2016/10/10 0010.
 */
blog.controller("blogController", function ($scope, $http) {
    // $http.get('web/mock/blogList.json').success(function (data) {
    //     $scope.blogs = data;
    // })
    $http.get('blog/list/').success(function (data) {
        // console.info(data)
        $scope.blogs = data.data;
    })
})
