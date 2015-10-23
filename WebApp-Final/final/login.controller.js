
(function() {
    'use strict';

    angular
        .module('plunker')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['loginService', '$routeParams'];

    function LoginController(loginService, routeParams) {
        var loginVm = this;

        loginVm.log= {};

        loginVm.ownerLogin  = function()  {
            var originalName = loginVm.log.username;
            var originalPasswd = loginVm.log.password;

            loginService
                .ownerLogin()
                .then(function(response) {
                    loginVm.log = response[0];

                    if ( originalName ==  loginVm.log.username  &&
                        originalPasswd ==  loginVm.log.password) {
                        window.location.href = 'http://localhost:8080/RESTDB/api/index1.html';
                    }
                    else {
                        alert ('Invalid Username or password');
                        loginVm.log=null;
                    }

                }, function(error) {
                    console.log(error);
                });
        }

    }


})();
