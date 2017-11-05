var optPrimeApp = angular.module('optPrimeApp', []);

optPrimeApp.controller('inputForm', function($scope, $http){
	$scope.myFunction = function() {
		var tempDict = {};
		tempDict["location"] = $scope.location;
		
		console.log("Button clicked!");
		console.log(tempDict);
	}
});