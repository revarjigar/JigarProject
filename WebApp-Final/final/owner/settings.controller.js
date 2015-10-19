(function() {
  'use strict';

  angular
      .module('settings')
      .controller('MainController', MainController);

  MainController.$inject = ['employeeService'];

  function MainController(employeeService) {
    var mainVm = this;
    mainVm.title = 'AngularJS';

    mainVm.sort = {
      by: 'id',
      reverse: false
    };

    mainVm.employees = [];
    mainVm.newEmp = null;

    init();

    function init () {
      employeeService
          .createEmployee()
          .then(function (employees){
            mainVm.employees = employees;
          }, function (errorMsg){
            console.log(errorMsg);
          });

    }


  }

})();