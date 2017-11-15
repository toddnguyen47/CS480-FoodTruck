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

	$scope.locationArr = [
		{locationType: "Zip code"},
		{locationType: "Address"},
        {locationType: "City"},
		{locationType: "Current Location"}
	];


	$scope.postSearch = function() {
		//var concatString = "cs480/foodtrucks/yelp/" + $scope.form.location1 + "?opt=" + $scope.form.selectedMode.locationType;
		var concatString = "cs480/foodtrucks/search2";
		$http.post(
			url = concatString,
			data = $scope.searchConcat()
		).success(function(dataResponse) {
			$scope.trucks = dataResponse;
			console.log($scope.trucks);
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

	// Concat user searches
	$scope.searchConcat = function searchConcat() {
		inputTemp = {};
		inputTemp["locationType"] = $scope.form.selectedMode.locationType;
		inputTemp["locationValue"] = $scope.form.location1;
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
