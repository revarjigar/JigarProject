
(function() {
    'use strict';

    angular
        .module('settings',[])
        .controller('ReservationsController', ReservationsController);

    ReservationsController.$inject = ['reservationService'];

    function ReservationsController (reservationService) {
        var rsvVm = this;
        console.log('ReservationsController');

        init();

        function init() {
            reservationService
                .getReservations()
                .then(function (reservations) {
                    rsvVm.reservations = reservations;
                }, function (error) {
                    console.log(error);
                });
        }
    }

    angular
        .module('plunker')
        .filter('phone', phoneFilter);

    function phoneFilter(){
      return function(phoneStr){
        var rez='';

        if(phoneStr && phoneStr.length==10){
          rez='('+ phoneStr.substring(0,3) +') '+phoneStr.substring(3,6)+'-'+phoneStr.substring(6);
        }
        return rez;
      };
    }

})();

