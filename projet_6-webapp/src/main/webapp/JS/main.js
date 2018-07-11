function getListSite() {
    // URL de l'action AJAX
    var url = "listSiteAjax";
    // Action AJAX en POST
    jQuery.post(
        url,
        function (data) {
            var $selectSite = jQuery("#selectSite");
            $selectSite.empty();
            console.log(data);
            jQuery.each(data, function (key, val) {
                $selectSite.append(
                    jQuery("<option>")
                        .text(val.nomSite)
                        .val(val.idSite)
                );
            }); $("#selectSite").trigger("change");
        })
        .fail(function (data) {
            if (typeof data.responseJSON === 'object') {
                console.log(data.responseJSON);
            } else {
                console.log(data);
            }
            alert("Une erreur s'est produite.");
        });
}

function getListSecteur() {
    // URL de l'action AJAX
    var url = "listSecteurAjax";
    // Paramètres de la requête AJAX
    var params = {
        site: $("#selectSite").val() + '#' + $("#spanIdTopo").text()
    };
    // Action AJAX en POST
    jQuery.post(
        url,
        params,
        function (data) {
            var $selectSecteur = jQuery("#selectSecteur");
            $selectSecteur.empty();
            jQuery.each(data, function (key, val) {
                $selectSecteur.append(
                    jQuery("<option>")
                        .text(val.nomSecteur)
                        .val(val.idSecteur)
                );
            }); $("#selectSecteur").trigger("change");
        })
        .fail(function (data) {
            if (typeof data.responseJSON === 'object') {
                console.log(data.responseJSON);
            } else {
                console.log(data);
            }
            alert("Une erreur s'est produite.");
        });
}


// Récuperer liste de voie en ajax

function getListVoie(){
    var url = "listVoieAjax";
    var params = {
        secteur: $("#selectSecteur").val() + '#' + $("#selectSite").val()
    };
    jQuery.post(
        url,
        params,
        function (data) {
            var $selectVoie = jQuery("#selectVoie");
            $selectVoie.empty();
            jQuery.each(data, function (key, val) {
                $selectVoie.append(
                    jQuery("<option>")
                        .text(val.nomVoie)
                        .val(val.idVoie)
                );
            }); $("#selectVoie").trigger("change");
        })
        .fail(function (data) {
            if(typeof data.responseJSON === 'object') {
                console.log(data.responseJSON);
            } else {
                console.log(data);
            }
            alert("Une erreur s'est produite.")
        });
}

function getSiteDetail() {
    //URL de l'action AJAX
    var url = "detailSiteAjax";
    //Paramètres de la requête AJAX
    var params = {
        site: $("#selectSite").val() + '#' + $("#spanIdTopo").text()
    };
    jQuery.post(
        url,
        params,
        function (data) {
            var $infoSite = jQuery("#infoSite");
            $infoSite.empty();
            $infoSite.append(
                jQuery("<li>")
                    .append("<li> nom du site </li>")
                    .append(data.nomSite)
                    .append("<br />")
                    .append("<li> altitude ( en pied ) </li>")
                    .append(data.altitudePiedVoie)
                    .append("<br />")
                    .append("<li> description du site </li>")
                    .append(data.description)
            );
        }).fail(function (data) {
        if (typeof data.responseJSON === 'object'){
            console.log(data.responseJSON);
        } else {
            console.log(data);
        }
        alert("Une erreur s'est produite.")
    });
}

function getSecteurDetail() {
    // URL de l'action AJAX
    var url = "detailSecteurAjax";
    // Paramètres de la requête AJAX
    var params = {
        secteur: $("#selectSecteur").val() + '#' + $("#selectSite").val()
    };
    jQuery.post(
        url,
        params,
        function (data) {
            var $infoSecteur = jQuery("#infoSecteur");
            $infoSecteur.empty();
            $infoSecteur.append(
                jQuery("<li>")
                    .append("<li> nom du secteur </li>")
                    .append(data.nomSecteur)
                    .append("<br />")
                    .append("<li> orientation </li>")
                    .append(data.orientation)
                    .append("<br />")
                    .append("<li> difficulté </li>")
                    .append(data.difficulte)
                    .append("<br />")
                    .append("<li> description du secteur </li>")
                    .append(data.description)
            );
        }).fail(function (data) {
        if (typeof data.responseJSON === 'object'){
            console.log(data.responseJSON);
        } else {
            console.log(data);
        }
        alert("Une erreur s'est produite.")
    });
}

function getVoieDetail() {
    var url = "detailVoieAjax";
    var params = {
        voie: $("#selectVoie").val() + '#' + $("#selectSecteur").val()
    };
    jQuery.post(
        url,
        params,
        function (data) {
            console.log(data);
            var $infoVoie = jQuery("#infoVoie");
            $infoVoie.empty();
            $infoVoie.append(
                jQuery("<li>")
                    .append("<li> nom de la voie  </li>")
                    .append(data.nomVoie)
                    .append("<br />")
                    .append("<li> hauteur de la voie  </li>")
                    .append(data.hauteur)
                    .append("<br />")
                    .append("<li> cotation  </li>")
                    .append(data.cotation)
                    .append("<br />")
                    .append("<li> description de la voie </li>")
                    .append(data.description)
            );
        }).fail(function (data) {
        if (typeof data.responseJSON === 'object'){
            console.log(data.responseJSON);
        } else {
            console.log(data);
        }
        alert("Une erreur s'est produite.")
    });
}

// Récupérer liste de commentaire en ajax

function getListComAjax() {
    // URL de l'action AJAX
    var url = "listComAjax";
    // Action AJAX en POST
    jQuery.post(
        url,
        function (data) {
            var $listCom = jQuery("#listCom");
            $listCom.empty();
            jQuery.each(data, function (key, val) {
                $listCom.append(
                    jQuery("<li>")
                        .append(val.text)
                );
            });
        })
        .fail(function () {
            alert("Une erreur s'est produite.");
        });
}

