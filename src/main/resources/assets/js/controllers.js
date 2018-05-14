/* Controllers */
angular.module('holdinarmApp.controllers', []).
controller('brandViewController', function($scope, Service) {
	Service.getBrands($scope);
	$scope.setBrand = function() {
		Service.setBrand($scope);
		$scope.brandInName = "";
	};

	$scope.updateBrand = function(brandId, brandName) {
		Service.updateBrand($scope, brandId, brandName);
	};

	$scope.deleteBrand = function(brandID) {
		Service.deleteBrand($scope, brandID);
	};
}).



controller('menuController', function($scope) {
	$scope.$on("$routeChangeSuccess", function(angularEvent, current, previous) {
		// calls set setClasses method, and converts originalPath to
		// /originalPath to originalPathClass
		setClasses($scope, current.originalPath.split("/")[1] += "Class");
	});
});

var setClasses = function($scope, next) {
	$scope.brandClass = "default";
	$scope.campaignClass = "default";
	$scope.keywordClass = "default";
	$scope.competitorClass = "default";

	if (next == "brandClass")
		$scope.brandClass = "success";
	
}
