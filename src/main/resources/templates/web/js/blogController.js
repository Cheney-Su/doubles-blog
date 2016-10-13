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
            $scope.blog = data.data;
        });

        $http.get('reply/' + $routeParams.id).success(function (data) {
            $scope.replys = data.data;
        })
    }

    $scope.blogReply = function () {
        var data = {};
        data['blogId'] = $("#reply-from [name='blogId']").val();
        data['content'] = $("#reply-from [name='content']").val();
        data['ownerId'] = 1;
        data['toUserId'] = $("#reply-from [name='toUserId']").val();
        $http.post('reply/add', data).success(function (data) {
            if (data.status == 0) {
                console.info($scope)
                window.location.reload()
            } else {
                alert(data.msg)
                return
            }
        })
    }
})
