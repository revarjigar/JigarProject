//(function() {
//
//  angular
//    .module('settings')
//    .service('contactService', contactServiceFn);
//
//  contactServiceFn.$inject = ['$http', '$q'];
//
//  function contactServiceFn($http, $q) {
//    var self = this;
//
//    self.getList = function() {
//      var newPromise = $q.defer();
//
//      $http({
//        method: 'GET',
//        url: 'http://localhost:8080/RESTDB/api/rsv',
//        cache: false
//      }).success(function(data) {
//        console.log(data);
//        newPromise.resolve(data);
//      }).error(function(err) {
//        newPromise.reject(err);
//      });
//
//      return newPromise.promise;
//    };
//  }
//
//})();


(function() {
  'use strict';

  angular
      .module('settings')
      .service('reservationService', reservationService);

  reservationService.$inject = ['$q', '$http'];

  function reservationService($q, $http) {
    var self = this;

    self.getReservations = getReservations;
    self.getReservationById = getReservationById;

    //private members
    function getReservations() {

      var defer = $q.defer();

      $http
          .get('http://localhost:8080/RESTDB/api/rsv')
          .then(successFn, errorFn);

      function successFn(response) {
        defer.resolve(response.data);
      }

      function errorFn(error) {
        defer.reject(error.statusText);
      }

      return defer.promise;
    }

    function getReservationById(id) {
      var defer = $q.defer();

      $http
          .get('http://localhost:8080/RESTDB/api/rsv/' + id)
          .then(successFn, errorFn);

      function successFn(response) {
        defer.resolve(response.data);
      }

      function errorFn(error) {
        defer.reject(error.statusText);
      }

      return defer.promise;
    }
  }

  //angular
  //    .module('plunker')
  //    .filter('phone', phoneFilter);
  //
  //function phoneFilter(){
  //  return function(phoneStr){
  //    var rez='';
  //
  //    if(phoneStr && phoneStr.length==10){
  //      rez='('+ phoneStr.substring(0,3) +') '+phoneStr.substring(3,6)+'-'+phoneStr.substring(6);
  //    }
  //    return rez;
  //  };
  //}

})();