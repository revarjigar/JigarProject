/**
 * Created by WWE on 10/16/15.
 */
(function() {
    'use strict';

    angular
        .module('settings', ['ngRoute'])
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider'];

    function moduleConfig ($routeProvider) {

        $routeProvider
            //jigar
            .when('/booking', {
                templateUrl: 'owner/booking.tmpl.html',
                controller: 'ReservationsController',
                controllerAs: 'rsvVm'
            })
            .when('/seating', {
                templateUrl: 'owner/seating.tmpl.html',
            })
            .when('/contact', {
                templateUrl: 'owner/contact.tmpl.html',
                controller: 'ReservationsController',
                controllerAs: 'rsvVm'
            })
            .when('/settings', {
                templateUrl: 'owner/settings.tmpl.html',
                controller: "MainController",
                controllerAs: "mainVm"
            })
            //jigar
            .otherwise({
                redirectTo: '/booking'
            });
    }
})();
