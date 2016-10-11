/**
 * Created by Administrator on 2016/10/10 0010.
 */
blog.controller("rightNavController", function ($scope, $http) {
    // $http.get('web/mock/blogList.json').success(function (data) {
    //     $scope.blogs = data;
    // })
    $http.get('blogClass/list/').success(function (data) {
        $scope.blogClasses = data.data;
//        console.info($scope.blogs)
    })
})
