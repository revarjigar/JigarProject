
(function() {
    'use strict';

    angular
        .module('plunker')
        .service('loginService', loginService);

    loginService.$inject = ['$q', '$http'];

    function loginService($q, $http) {
        var self = this;
        self.ownerLogin = ownerLogin;

        //private members
        function ownerLogin() {
            var defer = $q.defer();

            $http
                .post('http://localhost:8080/RESTDB/api/login')
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
