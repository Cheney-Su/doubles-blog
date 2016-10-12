/**
 * Created by Administrator on 2016/10/10 0010.
 */
blog.controller("blogController", function ($scope, $http, $routeParams) {
    // $http.get('web/mock/blogList.json').success(function (data) {
    //     $scope.blogs = data;
    // })
    $http.get('blog/list/').success(function (data) {
        $scope.blogs = data.data;
//        console.info($scope.blogs)
    })

    if ($routeParams.id != undefined) {
        $http.get('blog/list/' + $routeParams.id).success(function (data) {
            console.info(data)
            $scope.blog = data.data;
        });

        $http.get('reply/' + $routeParams.id).success(function (data) {
            console.info(data)
            $scope.replys = data.data;
        })
    }

    $scope.blogReply = function($scope){
        var data = {};
        data['blogId'] = $("#reply-from [name='blogId']").val();
        data['content'] = $("#reply-from [name='content']").val();
        console.info(data)
    }
})
