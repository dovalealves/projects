//Project completed during week 12 of my Intensive 14 Week Bootcamp at Academia de Codigo during 2023

define(['views/digimon-view', 'services/digimon-service'], function (
    digimonView,
    digimonService,
) {
    var externals = {};
    var internals = {};

    externals.start = function () {
        internals.bindEventHandlers();
        digimonView.render();
    };

    internals.bindEventHandlers = function () {
        // Update the button click handler to fetch and display Digimon
        digimonView.bind('button', internals.fetchAndDisplayDigimon);
    };

    // Function to fetch and display Digimon using the Digimon API
    internals.fetchAndDisplayDigimon = function () {
        digimonService.fetchDigimon(function (digimon) {
           // console.log(digimon);
            if (digimon) {   //logic to fetch 1 digimon only, randomly
                var randomDigimon = Math.floor(Math.random() * 208);

                digimonView.render(digimon[randomDigimon]);
            } else {
            // Handle the error
            console.log('Error fetching Digimon data');
        }
        });
    }; 
    
    

return externals;
});

