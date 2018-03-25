$(document).ready(function () {

    function getNbRows() {
        return $('#container').find('div.oui').length;
    }

    function getNbRetards() {
        return $('#container').find('span.retard').filter(function () {
            return $(this).html().toString().search('Retard') !== -1;
        }).length;
    }

    function speak() {
        window.speechSynthesis.speak(msg);
        audio.removeEventListener("ended", speak);
    }

    function checkAndToggleVisibility() {
        if (getNbRows() === 0) {
            $("#noRace").css("display", "flex");
        } else {
            $('#noRace').hide();
        }
    }

    function findModifiedRow(beforeTr, nowTr) {
        for (var i = 0; i < beforeTr.length; i++) {
            if (beforeTr[i].innerText !== nowTr[i].innerText) {
                console.log("INDEX LIGNE RETARD = " + i);
                return i;
            }
        }
        return -1;
    }

    function pad(pad, str, padLeft) {
        if (typeof str === 'undefined')
            return pad;
        if (padLeft) {
            return (pad + str).slice(-pad.length);
        } else {
            return (str + pad).substring(0, pad.length);
        }
    }

    var currentLocation = window.location.pathname;
    var currentLocationSplit = currentLocation.split(/[/?]/);
    var type = currentLocationSplit[1];
    var gare = currentLocationSplit[2];
    var nbRows = 0;
    var nbRetards = getNbRetards();

    var beforeTr = $('#container').find('div.oui');
    console.log(beforeTr);

    var audio = new Audio('../audio/jingleSNCF.wav');

    var msg = new SpeechSynthesisUtterance();
    msg.lang = 'fr-FR';

    // var heightRow = $('div.row').height();
    // console.log(heightRow);
    // var rowCount = Math.round(window.height / heightRow);
    // console.log(rowCount);
    var board = new DepartureBoard(document.getElementById('test'), {rowCount: 15, letterCount: 50});

    $("#ajout").click(function (e) {
        // console.log("BOUTON CLIQUE");
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
            url: "/testAddRetard",
            data: {type: type}
        });
    });

    var indexDifference = -1;

    setInterval(function () {

        $('#container').load('/update', {type: type, gare: gare, style: 'old'},
            function (responseText, textStatus, XMLHttpRequest) {
                if (textStatus === "success") {

                    if (nbRetards < getNbRetards()) {
                        nbRetards = getNbRetards();

                        var el = $('<div></div>');
                        el.html(responseText);
                        var nowTr = el.find('div.oui');
                        console.log("beforeTr");
                        console.log(beforeTr);
                        console.log("nowTr");
                        console.log(nowTr);
                        indexDifference = findModifiedRow(beforeTr,nowTr);
                        console.log(indexDifference);

                        beforeTr = nowTr;

                        if (indexDifference !== -1) {
                            var numTrain = nowTr[indexDifference].children[0].children[0].innerText;
                            var temps = nowTr[indexDifference].children[0].children[1].innerText;
                            var heures = temps.split('h')[0];
                            var minutes = temps.split('h')[1];
                            var gare = nowTr[indexDifference].children[0].children[2].innerText;

                            var retardTxt = nowTr[indexDifference].children[0].children[3].innerText;
                            var retard = retardTxt.substring(retardTxt.lastIndexOf(": ") + 1, retardTxt.lastIndexOf(" min"));
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

                    if(nbRows < getNbRows() || indexDifference !== -1){
                        if(nbRows === getNbRows() - 1){
                            audio.play();
                        }
                        nbRows = getNbRows();
                        beforeTr = $('#container').find('div.oui');
                        var el = $('<div></div>');
                        el.html(responseText);
                        var nowTr = el.find('.row');

                        var array = [];
                        for (var i = 0; i < nowTr.length; i++) {
                            var numTrain = pad(Array(5).join(' '),nowTr[i].children[0].innerHTML,false);
                            var heure = nowTr[i].children[1].innerHTML;
                            var ville = pad(Array(24).join(' '),nowTr[i].children[2].innerHTML,false);
                            var retard = nowTr[i].children[3].innerHTML;
                            array.push(numTrain + " " + heure + " " + ville + " " + retard);
                        }
                        if(indexDifference !== -1){
                            board.setValue(array,0);
                        } else {
                            board.setValue(array,200);
                        }
                        indexDifference = -1;
                    }
                }
            });
    }, 2000);

});
