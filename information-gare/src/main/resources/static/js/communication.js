$(document).ready(function () {

    function getNbRetards() {
        return $('#container').find('span.retard').filter(function () {
            return $(this).html().toString().search('Retard') !== -1;
        }).length;
    }

    function getNbAnnule() {
        return $('#container').find('span.retard').filter(function () {
            return $(this).html().toString().search('Annulé') !== -1;
        }).length;
    }

    function getNbRows() {
        return $('#container').find('tr').length;
    }

    function resetScroll() {
        clearInterval(scrollThread);
        var delayScroll = 10000 + 2 * 400 * nbRows;
        // console.log(nbRows);
        // console.log(delayScroll);
        scrollThread = setInterval(scrollDownAndUp, delayScroll);

    }

    function scrollDownAndUp() {
        if ($('#container').height() > $(window).height() - 70) {
            var nbRows = getNbRows();
            var time = 400 * nbRows;
            // console.log(nbRows);
            var bodyHtml = $('body,html');
            bodyHtml.animate({scrollTop: $(document).height() - $(window).height()}, time).delay(3000);
            bodyHtml.animate({scrollTop: 0}, time).delay(10000);
        }
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

    function findModifiedRow(beforeTr,nowTr){
        for (var i = 0; i < beforeTr.length; i++) {
            if(beforeTr[i].innerText !== nowTr[i].innerText){
                console.log("INDEX LIGNE RETARD = " + i);
                return i;
            }
        }
        return -1;
    }

    var currentLocation = window.location.pathname;
    var currentLocationSplit = currentLocation.split('/');
    var type = currentLocationSplit[1];
    var gare = currentLocationSplit[2];
    var nbRows = getNbRows();
    var nbRetards = getNbRetards();
    var nbAnnule = getNbAnnule();

    var audio = new Audio('../audio/jingleSNCF.wav');

    var msg = new SpeechSynthesisUtterance();
    msg.lang = 'fr-FR';

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

    $("#annuler").click(function (e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: "/testCancel"
        });
    });
    
    var scrollThread = null;
    resetScroll();

    checkAndToggleVisibility();

    var beforeTr = $('#container').find('tr');

    setInterval(function () {
        $('#container').load('/update', {type: type, gare: gare, style: 'new'},
            function (responseText, textStatus, XMLHttpRequest) {
                if (textStatus === "success") {

                    checkAndToggleVisibility();

                    if (nbRetards < getNbRetards() || nbAnnule < getNbAnnule()) {
                        if(nbRetards < getNbRetards()){
                            nbRetards = getNbRetards();
                        }
                        if(nbAnnule < getNbAnnule()){
                            nbAnnule = getNbAnnule();
                        }

                        var el = $('<div></div>');
                        el.html(responseText);
                        var nowTr = el.find('tr');

                        var indexDifference = findModifiedRow(beforeTr,nowTr);

                        beforeTr = nowTr;

                        if (indexDifference !== -1) {
                            var numTrain = nowTr[indexDifference].children[0].innerText;
                            var temps = nowTr[indexDifference].children[1].innerText;
                            var heures = temps.split('h')[0];
                            var minutes = temps.split('h')[1];
                            var gare = nowTr[indexDifference].children[2].innerText;

                            var retardTxt = nowTr[indexDifference].children[3].innerText;
                            var retard = retardTxt.substring(retardTxt.lastIndexOf(": ") + 1, retardTxt.lastIndexOf(" min"));
                            //console.log(retard);

                            console.log(retardTxt);
                            var truc = "";
                            if (retardTxt.trim() !== 'Annulé') {
                                truc = 'a un retard de ' + retard + ' minutes.';
                            } else {
                                truc = 'a été annulé.';
                            }

                            if (type === 'departs') {
                                msg.text = 'Le départ du train numero ' + numTrain + ' prévu à ' + heures + ' heures ' + minutes + ' à destination de ' + gare + ' '
                                    + truc + ' Veuillez nous excuser pour la gêne occasionnée';
                            } else {
                                msg.text = 'Le train numero ' + numTrain + ' venant de ' + gare + 'prévu à ' + heures + ' heures ' + minutes + ' '
                                    + truc + ' Veuillez nous excuser pour la gêne occasionnée';
                            }

                            audio.play();
                            audio.addEventListener("ended", speak);
                        }
                    }

                    if (nbRows < getNbRows()) {
                        nbRows = getNbRows();
                        var container = $('#container');
                        beforeTr = container.find('tr');

                        resetScroll();
                        audio.play();
                        //container.find('tr:last').hide().insertAfter('#container tr:last').fadeIn('slow');

                        $('tr:last')
                            .find('td')
                            .wrapInner('<div style="display: none;" />')
                            .parent()
                            .find('td > div')
                            .slideDown(500, function () {

                                var $set = $(this);
                                $set.replaceWith($set.contents());

                            });
                    }
                }
            });
    }, 1000);

});
