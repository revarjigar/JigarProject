
(function() {
    'use strict';

    angular
        .module('settings')
        .service('employeeService', employeeService);

    employeeService.$inject = ['$q', '$http'];

    function employeeService($q, $http) {
        var self = this;

        self.createEmployee = createEmployee;



            function createEmployee() {
                var defer = $q.defer();

                $http
                    .put('http://localhost:8080/RESTDB/api/settings/1')
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
})();