/**
 * Created by Administrator on 2016/10/16 0016.
 */
loginManager.controller('loginManagerController', function ($scope, $http) {
    $scope.login = function ($scope) {
        var data = {}
        data['userName'] = $(".form-group [name='userName']").val()
        data['password'] = $(".form-group [name='password']").val()
        $http.post('../../manager/user', data).success(function (data) {
            if (data.status == 0) {
                window.location.href = 'index.html'
            } else {
                alert(data.msg)
                return
            }
        })
    }
})