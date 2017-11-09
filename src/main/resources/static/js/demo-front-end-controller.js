var cs480AppDemo = angular.module('cs480AppDemo', []);

cs480AppDemo.controller('DemoCtrl', function ($scope, $http) {
	$scope.myForm = {};
	$scope.searchOpt = [
		{ optName :"zip code"},
		{ optName : "address"},
		{ optName : "current location"}
	];
	$scope.typesOfFood = [
		{name: "American",		selected: false},
		{name: "Italian",		selected: false},
		{name: "Japanese",		selected: false}, 
		{name: "Korean",		selected: false},
		{name: "Mexican",		selected: false},
		{name: "Surprise Me!",  selected: false}
	];
    $scope.postSearch = function() {
    	//remove the if statement based on the user is always using the browser so geo-location can always pass it to next round for validation of usage
    	//if($scope.myForm.selectedRole.optName == "current location"){
    		 
    	//}
    	var p = [];
  		console.log("debugging...");
  		for (var i = 0; i < $scope.typesOfFood.length; i++) {
  			var item = $scope.typesOfFood[i];
  	       if ( item.checked) {
  	    	 console.log("selected: " + item);
  	        p.push(item )  
  	       }
  		}
  		var parameter = JSON.stringify({type:"selection", search_input:$scope.myForm.search_input, opt:$scope.myForm.selectedRole.optName, lat: $scope.position.coords.latitude, lon:$scope.position.coords.longitude, tyepOfFood:p});
  		
	  //$http.post("cs480/foodtrucks/yelp/" + $scope.myForm.search_input + "?opt=" + $scope.myForm.selectedRole.optName + "&opt2="  + $scope.position.coords.latitude + "," + $scope.position.coords.longitude, parameter)
  	  $http.post("cs480/foodtrucks/yelp", parameter)
	  .success(function(data){
	  		
	  		$scope.selectedItems = p;
	  		$scope.trucks = data;
	  	});
   }
   $scope.init = function(){
		if (navigator.geolocation) {
   			    navigator.geolocation.getCurrentPosition(function(position){
   			      $scope.$apply(function(){
   			        $scope.position = position;
   			      });
   			    });
   			  }
   }
});