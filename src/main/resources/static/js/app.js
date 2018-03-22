angular.module('hello', [])
    .controller('home', function($scope, $http) {
        $http.get('/client-api/greeting/').success(function(data) {
            $scope.greeting = data;
        })
    });