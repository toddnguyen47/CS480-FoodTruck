var optPrimeApp = angular.module('optPrimeApp', []);

optPrimeApp.controller('inputForm', ['$scope', '$http', function($scope, $http){
	var x = document.getElementById("geoloc");
	$scope.inputForm = {};
	
	// Make sure "Random" is the LAST entry
	$scope.typesOfFood = [
		{name: "American",		selected: false},
		{name: "Italian",		selected: false},
		{name: "Japanese",		selected: false}, 
		{name: "Korean",		selected: false},
		{name: "Mexican",		selected: false},
		{name: "Surprise Me!",  selected: false}
	];

	// Selected food
	$scope.foodSelection = [];
	
	// Do I need to fix locationArr?
	$scope.locationArr = [
		{locationType: "Zip code"},
		{locationType: "Address"},
		{locationType: "Current Location"}
	];

	$scope.postSearch = function() {
		//var tempLocation = angular.lowercase($scope.form.location1.toString());
		//var tempSelectedMode = angular.lowercase($scope.form.selectedMode.locationType.toString());
		//var concatString = "cs480/foodtrucks/yelp/" + tempLocation + "?opt=" + tempSelectedMode;
		var concatString = "cs480/foodtrucks/yelp/" + $scope.form.location1 + "?opt=" + $scope.form.selectedMode.locationType;
		$http.post(concatString).success(function(dataResponse) {
			$scope.trucks = dataResponse;
		});
	}

	// Get selected food
	$scope.selectedFood = function selectedFood() {
		return filterFilter($scope.typesOfFood, {selected: true})
	};

	// Watch fruits for change
	$scope.$watch('typesOfFood | filter:{selected:true}', function(input) {
		$scope.foodSelection = input.map(function (food){
			return food.name;
		});
	}, true);

	/*******************************************/
	/* Geolocation code
	/*******************************************/

	$scope.getLocation = function() {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(showPosition, showError);
		} else {
			x.innerHTML = "Geolocation is not supported by this browser.";
		}
	}
	
	$scope.showPosition = function (position) {
		x.innerHTML = position.coords.latitude + "," + position.coords.longitude;
	}
	
	$scope.showError = function(error) {
		switch(error.code) {
			case error.PERMISSION_DENIED:
				x.innerHTML = "User denied the request for Geolocation."
				break;
			case error.POSITION_UNAVAILABLE:
				x.innerHTML = "Location information is unavailable."
				break;
			case error.TIMEOUT:
				x.innerHTML = "The request to get user location timed out."
				break;
			case error.UNKNOWN_ERROR:
				x.innerHTML = "An unknown error occurred."
				break;
		}
	}
}]);