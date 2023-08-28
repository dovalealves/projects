define(function() {
    var internals = {
        handlers: {},
        elements: {}
    };

    var externals = {};

    internals.createButton = function() {
        return '<button class="random-film">Random Digimon Generator</button>';
    };

    internals.createDigimonCard = function(digimon) {
        return (
            '<div>' +
            '<p><strong>Name </strong>' +
            digimon.name +
            '</p>' +
            '<p><strong>Level: </strong>' +
            digimon.level +
            '</p>' +
            '<img src="' +
            digimon.img +
            '"></img></div>'
        );
    };

    internals.renderDigimon = function(digimon) {
        if (internals.elements.digimonCard) {
            internals.elements.digimonCard.empty();
        }

        internals.elements.digimonCard = $(internals.createDigimonCard(digimon));
        internals.elements.app.append(internals.elements.digimonCard);
    };

    internals.renderButton = function() {
        if (internals.elements.button) {
            return;
        }

        internals.elements.button = $(internals.createButton());
        internals.elements.button.click(internals.handlers['button']);
        internals.elements.app.append(internals.elements.button);
    };

    externals.bind = function(event, handler) {
        internals.handlers[event] = handler;
    };

    externals.render = function(digimon) {
        internals.elements.app = $('#app');
        internals.renderButton();

        //console.log(digimon);
        if (digimon) {
            internals.renderDigimon(digimon);
        }
    };

    return externals;
});
