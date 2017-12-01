var optPrimeApp = angular.module('optPrimeApp', []);

optPrimeApp.controller('inputForm', ['$scope', '$http', function($scope, $http) {
	var x = document.getElementById("geoloc");
	var curLocation = 'Current Location'.toLowerCase();
	var prevUserSelection = [];
	$scope.inputForm = {};
	$scope.checkboxCheck = [];
	$scope.isSurpriseMe = [];
	$scope.emptyList = {};

	// Make sure "Random" is the LAST entry
	$scope.typesOfFood = [
        {name: "Argentine",      selected: false},
        {name: "American",		 selected: false},
        {name: "British",        selected: false},
        {name: "Chinese",        selected: false},
        {name: "Dessert",        selected: false},
        {name: "Filipino",       selected: false},
        {name: "Halal",          selected: false},
        {name: "Hawaiian",       selected: false},
        {name: "Indian",         selected: false},
		{name: "Italian",		 selected: false},
		{name: "Japanese",		 selected: false},
		{name: "Korean",	 	 selected: false},
        {name: "Latin American", selected: false},
        {name: "Lebanese",       selected: false},
        {name: "Mediterranean",  selected: false},
		{name: "Mexican",		 selected: false},
        {name: "Middle Eastern", selected: false},
        {name: "Thai",           selected: false},
        {name: "Vietnamese",     selected: false},
		{name: "Surprise Me!",   selected: false}
	];

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
				for (let index = 0; index < $scope.trucks.length; index++) {
					var tempString = $scope.trucks[index]["phoneNumber"];

					if (tempString !== null) {
						$scope.trucks[index]["phoneNumber"] = tempString.substring(0,3);
						$scope.trucks[index]["phoneNumber2"] = tempString.substring(3);
					}
				}
			});
		}
		else {
			$scope.formLocation.submitError = true;
			window.alert("Some required fields are empty.");
		}
	}

	// Selected food
	$scope.foodSelection = [];

	// Watch fruits for change
	$scope.$watch('typesOfFood | filter:{selected:true}', function(input) {
		// Return all food elements that are selected
		$scope.foodSelection = input.map(function (food) {
			return food.name;
		});
	}, true);

	// Concat user searches
	$scope.searchConcat = function searchConcat() {
		var inputTemp = {};
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

	$scope.hideTextInput = function hideTextInput() {
		return ($scope.formLocation !== undefined && $scope.isCurrentLocation());
	}

	$scope.isCurrentLocation = function isCurrentLocation() {
		if ($scope.formLocation.selectedMode !== undefined) {
			var locationType = $scope.formLocation.selectedMode.locationType.toLowerCase();
			return (locationType === curLocation);
		}
	}

	$scope.updateCheckbox = function updateCheckbox(food, indexFood, foodTypes) {
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

		if (food.name.toLowerCase() === 'Surprise Me!'.toLowerCase()) {
			uncheckOtherBoxes(indexFood, foodTypes);
		}
	}

	function onlyUnique(value, index, self) {
		return self.indexOf(value) === index;
	}

	function uncheckOtherBoxes(indexFood, foodTypes) {
		prevUserSelection = JSON.parse(localStorage.getItem('prevUserSelection')) || [];

		angular.forEach(foodTypes, function(otherFoods, curIndex) {
			// Only store previous user input if Surprise Me! is selected
			if (foodTypes[indexFood].selected)
				prevUserSelection[curIndex] = otherFoods.selected;

			if (indexFood !== curIndex) {
				otherFoods.selected = false;
			}
		});

		// Disable other boxes
		if (foodTypes[indexFood].selected) {
			for (let i = 0; i < foodTypes.length;i++) {
				// Disable all other checkboxes but surprise me
				if (i !== indexFood) {
					$scope.isSurpriseMe[i] = true;
				}
				else {
					$scope.isSurpriseMe[i] = false;
				}
			}
		}

		// Enable all boxes
		else {
			angular.forEach(foodTypes, function(foodType, key) {
				$scope.isSurpriseMe[key] = false;
				foodType.selected = prevUserSelection[key];
			});
			// Make sure Surprise Me! is unchecked
			foodTypes[indexFood].selected = false;
		}

		localStorage.setItem('prevUserSelection', JSON.stringify(prevUserSelection));
	}

	$scope.reset = function reset(foodTypes) {
		$scope.checkboxCheck = [];
		angular.forEach(foodTypes, function(foodType, key) {
			foodType.selected = false;
			$scope.isSurpriseMe[key] = false;
		});
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

	// Get selected food
	/*$scope.selectedFood = function selectedFood() {
		return filterFilter($scope.typesOfFood, {selected: true})
	};*/

	/*
	// Get latitude/longitude from current location
	$scope.getLatLon = function getLatLon(address) {
		var temp = {};
		geocoder.geocode({'address':address}, function(results, status){
			if (status == google.maps.GeocoderStatus.OK) {
				var latitude = results[0].geometry.location.lat();
				var longitude = results[0].geometry.location.lng();

				temp["latitude"] = latitude;
				temp["longitude"] = longitude;
			}
		});

		return temp;
	}*/
}]);
