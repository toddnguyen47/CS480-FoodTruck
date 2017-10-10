// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs480App = angular.module('cs480App', []);

cs480App.controller('UserCtrl', function ($scope, $http) {

  $scope.loadUsers = function() {
	  $http.get("cs480/users/list")
	  	.success(function(data){
	  		$scope.users = data;
	  	});
  }

  $scope.getUser = function() {
	  $http.get("cs480/user/" + $scope.userIdToSearch)
	  	.success(function(data){
	  		$scope.founduser = data;
	  	});
  }

  $scope.addUser = function() {
	  $http.post("cs480/user/" + $scope.new_id + "?name=" + $scope.new_name + "&major=" + $scope.new_major)
	  	.success(function(data){
	  		$scope.loadUsers();
	  	});
  }

  $scope.deleteUser = function(userId) {
	  $http.delete("cs480/user/" + userId)
	  	.success(function(data){
	  		$scope.loadUsers();
	  	});
  }

  $scope.loadUsers();
  
});
cs480App.controller('FoodtruckCtrl', function ($scope, $http) {

	  $scope.loadTrucks = function() {
		  $http.get("cs480/foodtruck/list")
		  	.success(function(data){
		  		$scope.trucks = data;
		  	});
	  }

	  $scope.getTruck = function() {
		  $http.get("cs480/foodtruck/" + $scope.truckIdToSearch)
		  	.success(function(data){
		  		$scope.foundtruck = data;
		  	});
	  }

	  $scope.addTruck = function() {
		  $http.post("cs480/foodtruck/" + $scope.new_id + "?name=" + $scope.new_name + "&type=" + $scope.new_type)
		  	.success(function(data){
		  		$scope.loadTrucks();
		  	});
	  }

	  $scope.deleteTruck = function(truckId) {
		  $http.delete("cs480/foodtruck/" + truckId)
		  	.success(function(data){
		  		$scope.loadTrucks();
		  	});
	  }

	  $scope.loadTrucks();
	  
	});