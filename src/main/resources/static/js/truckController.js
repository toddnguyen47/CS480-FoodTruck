angular.module('truckApp', []).controller('truckCtrl', function($scope, $http, $log) {
    $http.get("output.json")
    .then(function (response) {
        $scope.trucks = response.data;
        $log.info(response)
    });
});
