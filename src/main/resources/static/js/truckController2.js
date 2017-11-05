var cs480AppDemo = angular.module('truckTest2', []);

cs480AppDemo.controller('DemoCtrl', function ($scope, $http) {
	$scope.myForm = {};
	$scope.locOpt = [{ locOptName : "zip code"},{ locOptName : "address"},{ locOptName : "current location"}];
    $scope.foodTypes = ['Mexican', 'Korean', 'Mediterranean'];
    $scope.typeSelection = [];
    $scope.toggleSelection = function(typeName) {
        var idx = $scope.typeSelection.indexOf(typeName);
        if (idx > -1) {
            $scope.typeSelection.splice(idx, 1);
        }
        else {
            $scope.typeSelection.push(typeName);
        }
        console.log($scope.typeSelection);
    };
    $scope.postSearch = function() {
	  $http.post("cs480/foodtrucks/yelp/test/" + $scope.myForm.search_input
      + "?loc_opt=" + $scope.myForm.selectedRole.locOptName
      + "?food_type=" + $scope.typeSelection)
	  	.success(function(data) {
	  		$scope.trucks = data;
	  	});
   }

});
