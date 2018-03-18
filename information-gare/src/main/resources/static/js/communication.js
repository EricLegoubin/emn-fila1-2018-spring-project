$(document).ready(function () {

    function getNbRetards() {
        return $('#container').find('span.retard').filter(function () {
            return $(this).html().toString().search('Retard') !== -1;
        }).length;
    }

    function getNbRows() {
        return $('#container').find('tr').length;
    }

    var currentLocation = window.location.pathname;
    var currentLocationSplit = currentLocation.split('/');
    var type = currentLocationSplit[1];
    var gare = currentLocationSplit[2];
    var nbRows = getNbRows();
    var nbRetards = getNbRetards();

    var audio = new Audio('../audio/jingleSNCF.mp3');

    var msg = new SpeechSynthesisUtterance();
    msg.lang = 'fr-FR';

    $("#ajout").click(function (e) {
        console.log("BOUTON CLIQUE");
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: "/testAdd"
        });
    });

    $("#retard").click(function (e) {
        console.log("BOUTON RETARD CLIQUE");
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: "/testAddRetard"
        });
    });

    function resetScroll() {
        clearInterval(scrollThread);
        var delayScroll = 10000 + 2 * 200 * nbRows;
        console.log(nbRows);
        console.log(delayScroll);
        scrollThread = setInterval(scrollDownAndUp, delayScroll);

    }

    function scrollDownAndUp() {
        if ($('#container').height() > $(window).height() - 70) {
            var nbRows = getNbRows();
            var time = 200 * nbRows;
            console.log(nbRows);
            $('body,html').animate({scrollTop: $(document).height() - $(window).height()}, time).delay(2000);
            $('body,html').animate({scrollTop: 0}, time).delay(10000);
        }
    }

    function speak() {
        window.speechSynthesis.speak(msg);
        audio.removeEventListener("ended", speak);
    }

    var scrollThread = null;
    resetScroll();

    setInterval(function () {
        $('#container').load('/update', {type: type, gare: gare},
            function (responseText, textStatus, XMLHttpRequest) {
                if (textStatus === "success") {

                    if(getNbRows() == 0){
                        $("#noRace").css("display", "flex");
                    } else {
                        $('#noRace').hide();
                    }

                    if (nbRows < getNbRows()) {
                        nbRows = getNbRows();
                        resetScroll();
                        audio.play();
                    }
                    // console.log('nbRetards avant = ' + nbRetards);
                    // console.log('nbRetards maintenant = ' + getNbRetards());
                    if (nbRetards < getNbRetards()) {
                        nbRetards = getNbRetards();
                        var beforeTr = $('#container').find('tr');
                        var el = $('<div></div>');
                        el.html(responseText);
                        var nowTr = el.find('tr');
                        var diff = $(nowTr).not(beforeTr).get();
                        //console.table(diff);

                        if(diff.length > 0) {
                            var numTrain = diff[0].children[0].innerText;
                            var temps = diff[0].children[1].innerText;
                            var heures = temps.split('h')[0];
                            var minutes = temps.split('h')[1];
                            var gare = diff[0].children[2].innerText;

                            var retardTxt = diff[0].children[3].innerText;
                            var retard = retardTxt.substring(retardTxt.lastIndexOf(": ") + 1, retardTxt.lastIndexOf(" min"));
                            //console.log(retard);
                            if (type === 'departs') {
                                msg.text = 'Le départ du train numero ' + numTrain + ' prévu à ' + heures + ' heures ' + minutes + ' à destination de ' + gare + ' ' +
                                    'a un retard de ' + retard + ' minutes. Veuillez nous excuser pour la gêne occasionnée';
                            } else {
                                msg.text = 'Le train numero ' + numTrain + ' venant de ' + gare + 'prévu à ' + heures + ' heures ' + minutes +
                                    'a un retard de ' + retard + ' minutes. Veuillez nous excuser pour la gêne occasionnée';
                            }
                            audio.play();
                            audio.addEventListener("ended", speak);
                        }
                    }
                }
            });

    }, 1000);

});
