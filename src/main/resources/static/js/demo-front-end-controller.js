var cs480AppDemo = angular.module('cs480AppDemo', []);

cs480AppDemo.controller('DemoCtrl', function ($scope, $http) {
	$scope.myForm = {};
	$scope.searchOpt = [{ optName :"zip code"},{ optName : "address"},{ optName : "current location"}];
    $scope.postSearch = function() {
    	//remove the if statement based on the user is always using the browser so geo-location can always pass it to next round for validation of usage
    	//if($scope.myForm.selectedRole.optName == "current location"){
    		 if (navigator.geolocation) {
    			    navigator.geolocation.getCurrentPosition(function(position){
    			      $scope.$apply(function(){
    			        $scope.position = position;
    			      });
    			    });
    			  }
    	//}
	  $http.post("cs480/foodtrucks/yelp/" + $scope.myForm.search_input + "?opt=" + $scope.myForm.selectedRole.optName + "&opt2="  + $scope.position.coords.latitude + "," + $scope.position.coords.longitude)
	  	.success(function(data){
	  		
	  		$scope.trucks = data;
	  	});
   }
 
});