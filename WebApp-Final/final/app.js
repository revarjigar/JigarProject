(function() {
  'use strict';
    angular.module('Authentication', []);
    angular.module('Home', []);

  angular
    .module('plunker', ['ngRoute',
          'Authentication',
          'Home',
          'ngRoute',
          'ngCookies','ngMessages'
      ])
    .config(moduleConfig);
    
    moduleConfig.$inject = ['$routeProvider'];
    
    function moduleConfig ($routeProvider) {
      
       $routeProvider
        .when('/reservation', {
          templateUrl: 'reservation.tmpl.html',
          controller: 'NewController',
          controllerAs: 'newVm'
        })
           .when('/editreservation', {
               templateUrl: 'editreservation.tmpl.html',
               controller: 'NewController',
               controllerAs: 'newVm'
           })
        .when('/login', {
          templateUrl: 'login.tmpl.html',
               controller: 'LoginController',
               controllerAs: 'loginVm'
        })
        .otherwise({
          redirectTo: '/reservation'
        });
    }

})();
