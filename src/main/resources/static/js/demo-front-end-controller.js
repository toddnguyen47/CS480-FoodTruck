var cs480AppDemo = angular.module('cs480AppDemo', []);

cs480AppDemo.controller('DemoCtrl', function ($scope, $http) {
	$scope.myForm = {};
	$scope.searchOpt = [{ optName :"zip code"},{ optName : "address"},{ optName : "current location"}];
    $scope.postSearch = function() {
	  $http.post("cs480/foodtrucks/yelp/" + $scope.myForm.search_input + "?opt=" + $scope.myForm.selectedRole.optName)
	  	.success(function(data){
	  		$scope.trucks = data;
	  	});
   }
 
});