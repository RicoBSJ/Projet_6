$(document).ready(function() {
    $('#listTopo').DataTable();
});

$('#listCom').addEventListener("load", getListComAjax);

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
        }).done(function(data) {
        // Ajout d'un second appel pour afficher toute les informations d'un secteur - ne fonctionne pas -
        var $infoSecteur = jQuery("#infoSecteur");
        $infoSecteur.empty();
        jQuery.each(data, function (key, val) {
            if ($("#selectSecteur").val() === $("#infoSecteur").val()){
                $infoSecteur.append(
                    jQuery("<li>")
                        .text(val.nomSecteur)
                        .val(val.nomSecteur)
                        .val(val.idSecteur)
                        .append(val.description)
                )
            }
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

