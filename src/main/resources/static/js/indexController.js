var optPrimeApp = angular.module('optPrimeApp', []);

optPrimeApp.controller('inputForm', ['$scope', '$http', function($scope, $http){
	$scope.inputForm = {};
	// Do I need to fix locationArr?
	$scope.locationArr = [{locationType: "Zip code"}, {locationType:"Address"}, {locationType: "Current Location"}];

	$scope.postSearch = function() {
		//var tempLocation = angular.lowercase($scope.form.location1.toString());
		//var tempSelectedMode = angular.lowercase($scope.form.selectedMode.locationType.toString());
		//var concatString = "cs480/foodtrucks/yelp/" + tempLocation + "?opt=" + tempSelectedMode;
		var concatString = "cs480/foodtrucks/yelp/" + $scope.form.location1 + "?opt=" + $scope.form.selectedMode.locationType;
		$http.post(concatString).success(function(dataResponse) {
			$scope.trucks = dataResponse;
		});
	}

	$scope.checkboxModel = {
		American: false,
		Italian: false,
		Japanese: false,
		Korean: false,
		Mexican: false,
		Random: false
	};
}]);