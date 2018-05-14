angular.module('holdinarmApp.services', []).factory('Service', function($http) {
	var factory = {};
	
	/** ********************BRAND******************** */
	
	factory.getBrands = function($scope) {

		$http({
			url : "/brand",
			method : "GET",
			headers : [ {
				'Accept' : 'application/json'
			} ]
		}).success(function(data, status, headers, config) {
			console.log("Success");

			$scope.brands = data;
		}).error(function(data, status, headers, config) {
			console.log("Error");
		});
	};

	factory.setBrand = function($scope) {

		$http({
			url : "/brand",
			method : "POST",
			data : {
				name : $scope.brandInName,
			},
			headers : [ {
				'Accept' : 'application/json'
			} ]
		}).success(function(data, status, headers, config) {
			console.log("Success");
			factory.getBrands($scope);
		}).error(function(data, status, headers, config) {
			console.log("Error");
		});
	};

	factory.updateBrand = function($scope,brandId ,brandName) {

		$http({
			url : "/brand/" + brandId,
			method : "PUT",
			data : {
				name : brandName,
			},
			headers : [ {
				'Accept' : 'application/json'
			} ]
		}).success(function(data, status, headers, config) {
			console.log("Success");
			factory.getBrands($scope);
		}).error(function(data, status, headers, config) {
			console.log("Error");
		});
	};

	factory.deleteBrand = function($scope, brandID) {

		$http({
			url : "/brand/" +brandID,
			method : "delete",
			headers : [ {
				'Accept' : 'application/json'
			} ]
		}).success(function(data, status, headers, config) {
			console.log("Success");
			factory.getBrands($scope);
		}).error(function(data, status, headers, config) {
			console.log("Error");
		});
	};
	return factory;
});
