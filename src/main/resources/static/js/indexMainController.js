var optPrimeApp = angular.module('optPrimeApp', []);

optPrimeApp.controller('inputForm', ['$scope', '$http', function($scope, $http){
	var x = document.getElementById("geoloc");
	var curLocation = 'Current Location'.toLowerCase();
	$scope.inputForm = {};
	$scope.checkboxCheck = [];

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

	$scope.locationArr = [
		{locationType: "Zip code"},
		{locationType: "Address"},
		{locationType: "City"},
		{locationType: "Current Location"}
	];


	$scope.postSearch = function postSearch() {		
		if ($scope.formLocation.$valid) {
			var postUrl = "cs480/foodtrucks/search2";
			$http.post(
				url = postUrl,
				data = $scope.searchConcat()
			).success(function(dataResponse) {
				$scope.trucks = dataResponse;
				console.log($scope.trucks);
				for (let index = 0; index < $scope.trucks.length; index++) {
					var tempString = $scope.trucks[index]["phoneNumber"];
					$scope.trucks[index]["phoneNumber"] = tempString.substring(0,3);
					$scope.trucks[index]["phoneNumber2"] = tempString.substring(3);
				}
			});
		}
		else {
			$scope.formLocation.submitError = true;
			window.alert("Some required fields are empty.");
		}
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

	// Concat user searches
	$scope.searchConcat = function searchConcat() {
		inputTemp = {};
		inputTemp["locationType"] = $scope.formLocation.selectedMode.locationType;
		inputTemp["locationValue"] = $scope.formLocation.location1;
		inputTemp["foodTypes"] = $scope.foodSelection;
		
		// TODO: Consider changing this to prevent needing secure server
		if ($scope.position !== undefined) {
			inputTemp["lat"] = $scope.position.coords.latitude;
			inputTemp["lon"] = $scope.position.coords.longitude;
		}

		return inputTemp;
	}

	// Get latitude/longitude from current location
	$scope.getLatLon = function getLatLon(address) {
		temp = {};
		geocoder.geocode({'address':address}, function(results, status){
			if (status == google.maps.GeocoderStatus.OK) {
				var latitude = results[0].geometry.location.lat();
				var longitude = results[0].geometry.location.lng();

				console("latitude: " + latitude + ", longitude: " + longitude);

				temp["latitude"] = latitude;
				temp["longitude"] = longitude;
			}
		});

		return temp;
	}

	$scope.hideTextInput = function hideTextInput() {
		return ($scope.formLocation !== undefined && $scope.isCurrentLocation());
	}

	$scope.isCurrentLocation = function isCurrentLocation() {
		if ($scope.formLocation.selectedMode !== undefined) {
			var locationType = $scope.formLocation.selectedMode.locationType.toLowerCase();
			return (locationType === curLocation);
		}
	}

	$scope.updateCheckbox = function updateCheckbox(food) {
		$scope.checkboxCheck = $scope.checkboxCheck || [];
		if (food.selected) {
			$scope.checkboxCheck.push (food.name);
			// Removes all duplicates
			$scope.checkboxCheck = $scope.checkboxCheck.filter(onlyUnique);
		}
		else {
			// Without returns the array with the element removed
			//$scope.checkboxCheck = _.without($scope.checkboxCheck, food.name);
			$scope.checkboxCheck = $scope.checkboxCheck.filter(function(otherFoodName) {
				return otherFoodName !== food.name;
			});
		}
	}

	function onlyUnique(value, index, self) {
		return self.indexOf(value) === index;
	}

	/*******************************************/
	/* Geolocation code
	/*******************************************/

	// TODO: Remove if we get a non-HTML5 geolocation to work
	$scope.init = function() {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				$scope.$apply(function() {
					$scope.position = position;
				});
			});
		}
	}

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

	// Extra code
	/* $scope.deleteMe = {
		"locationType":"zip code",
		"typesOfFood":[
			"korean",
			"american"
		]
	}  */

	// Get latitude/longitude from address
	//var geocoder = new google.maps.Geocoder();
}]);
