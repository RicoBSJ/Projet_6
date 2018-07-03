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
            });
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
            });
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
                        .val(val.nomVoie)
                );
            });
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
                    .append(data.nomSite)
                    .append(data.altitudePiedVoie)
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
            $infoSecteur.append(data.nomSecteur);
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
    //URL de l'action AJAX
    var url = "detailVoieAjax";
    //Paramètres de la requête AJAX
    var params = {
        voie: $("#selectVoie").val() + '#' + $("#selectSecteur").val()
    };
    jQuery.post(
        url,
        params,
        function (data) {
            var $infoVoie = jQuery("#infoVoie");
            $infoVoie.empty();
            $infoVoie.append(data.nomVoie);
            $infoVoie.append(data.hauteur);
            $infoVoie.append(data.description)
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

