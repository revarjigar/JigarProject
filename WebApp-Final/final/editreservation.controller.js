
(function(){
    angular
        .module('plunker')
        .controller('NewController', NewController);

    NewController.$inject = ['mainService'];
    function NewController(mainService){

        var newVm = this;
        newVm.reservationID = null;
        newVm.showSuccess = false;
        newVm.showError = false;

        newVm.addEdited = function(flag){

            if(flag){
                console.log(newVm.newReservation);
                mainService.addEdited(newVm.newReservation).then(function(data){
                    newVm.reservationID = data;
                    newVm.showSuccess = true;
                    newVm.newReservation = null;

                }, function(err){
                    console.log(err);
                    newVm.newReservation = null;
                });
            }
        }
    }
})();