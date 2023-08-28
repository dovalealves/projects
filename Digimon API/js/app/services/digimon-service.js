define(function() {
    var externals = {}; // external api, object to hold external API stuff

const url = "https://digimon-api.vercel.app/api/digimon"; // digimon sucks

// function to fetch Digimon data from API
externals.fetchDigimon = function(cb) {

    //fetch to make request to the API
    fetch(url)
    .then(response => response.json())  //convert response to JSON
            .then(data => {
                //if data is parsed, pass it to the cb function
                cb(data); 
            })
            .catch(error => {
                console.error('Error fetching digimon data:', error);
                cb(null); // Pass null to the callback in case of an error
            });
    };
    return externals;  // returns the object from the 'fetchDigimon' function
});


