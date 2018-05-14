angular.module('holdinarmApp',
                [ 'ngRoute', 'holdinarmApp.controllers', 'holdinarmApp.services' ]).

// This configures the routes and associates each route with a view and a
// controller
config([ '$routeProvider', function($routeProvider) {
        $routeProvider.when('/brand', {
                controller : 'brandViewController',
                templateUrl : 'assets/view/brand.html'
        })

       

        .otherwise({
                redirectTo : '/'
        });
        //TODO nincs next!!
} ]);