/**
 * Created by Administrator on 2016/10/17 0017.
 */
indexManager.controller('blogController', function ($scope, $http, $routeParams) {
    $http.get('/blog/list/').success(function (data) {
        if (data.status == 0) {
            $scope.blogs = data.data
        } else {
            alert(222)
        }
    })
    $http.get('/blogClass/list/').success(function (data) {
        if (data.status == 0) {
            $scope.blogClasses = data.data
        } else {
            alert(222)
        }
    })

    $scope.saveBlog = function () {
        var data = {};
        data['userId'] = 2
        data['author'] = 'tnmao';
        data['createTime'] = '';
        data['readCount'] = 1;
        data['title'] = $("#title").val();
        data['blogType'] = $("#blogType").val();
        data['content'] = $("#content").val();
        data['abstracts'] = $("#abstracts").val();
        data['blogClassName'] = $("#blogClassId").find("option:selected").text();
        data['blogClassId'] = $("#blogClassId").val();
        data['keyWords'] = $("#keyWords").val();
        $http.post("/blog/save", data).success(function (data) {
            if (data.status == 0) {
                window.location.href = '#/'
            }
        })
    }

    if ($routeParams.blogId != undefined) {
        $http.get('/blog/list/' + +$routeParams.blogId).success(function (data) {
            console.info(data)
            $scope.blog = data.data;
        });
    }

    $scope.deleteBlog = function () {
        alert(this.blog.id)
        $http.delete("/blog/delete/" + this.blog.id).success(function (data) {
            if (data.status == 0) {
                $http.get('/blog/list/').success(function (data) {
                    if (data.status == 0) {
                        $scope.blogs = data.data
                    } else {
                        alert(222)
                    }
                })
            }
        })
    }
})