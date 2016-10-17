/**
 * Created by Administrator on 2016/10/10 0010.
 */
blog.controller("blogController", function ($scope, $http, $routeParams) {
    // $http.get('web/mock/blogList.json').success(function (data) {
    //     $scope.blogs = data;
    // })
    if ($routeParams.blogClassId != undefined) {
        $http.get('blogClass/list/' + $routeParams.blogClassId).success(function (data) {
            if (data.status == 0) {
                $scope.blogs = data.data;
                $scope.blogClass = {
                    name: data.data[0].blogClassName,
                }
            } else if (data.status == -1) {
                $scope.message = data.msg;
            }
        });
    } else {
        $http.get('blog/list/').success(function (data) {
            if (data.status == 0) {
                $scope.blogs = data.data;
            } else if (data.status == -1) {
                $scope.message = data.msg;
            }
        })
    }

    if ($routeParams.blogId != undefined) {

        $http.get('blog/list/' + $routeParams.blogId).success(function (data) {
            $scope.blog = data.data;
        });

        $http.get('reply/' + $routeParams.blogId).success(function (data) {
            $scope.replys = data.data;
        })

        // $http.get('reply/' + $routeParams.id).success(function (data) {
        //     $scope.replys = data.data;
        // })
    }

    $http.get('blogClass/list/').success(function (data) {
        $scope.blogClasses = data.data;
//        console.info($scope.blogs)
    })

    $scope.blogReply = function () {
        var me = this;
        var reply = {};
        reply['blogId'] = $("#reply-from [name='blogId']").val();
        // reply['rootId'] = 0;
        reply['content'] = $("#reply-from [name='content']").val();
        // reply['createTime'] = formatDate(new Date())
        reply['ownerId'] = 1;
        reply['toUserId'] = $("#reply-from [name='toUserId']").val();
        // console.info($scope.replys)
        $http.post('reply/add', reply, me).success(function (data) {
            if (data.status == 0) {
                $http.get('reply/' + $routeParams.blogId).success(function (data) {
                    me.replys = data.data;
                })
                me.content = ''
            } else {
                alert(data.msg)
                return
            }
        })
    }

    // function formatDate(now) {
    //     var year = now.getFullYear();
    //     var month = now.getMonth() + 1;
    //     var date = now.getDate();
    //     var hour = now.getHours();
    //     var minute = now.getMinutes();
    //     var second = now.getSeconds();
    //     return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
    // }
})
