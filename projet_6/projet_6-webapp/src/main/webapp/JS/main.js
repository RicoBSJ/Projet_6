$(document).ready(function() {

    $(".title").hide();
        $(".title").fadeIn(3000,function(){
        });
})

function getListSiteAjax() {
    // URL de l'action AJAX
    var url = "listSiteAjax";
    // Action AJAX en POST
    jQuery.post(
        url,
        function (data) {
            var $listSite = jQuery("#listSite");
            var newButton = $('<button>Afficher plus d\'information</button>');
            var $strbutton = "<button> class='btn btn-primary btn-sm' type='submit' onclick='getListSecteurAjax(val.idSite)'> Voir les secteur</button>"
            $listSite.empty();
            jQuery.each(data, function (key, val) {
                $listSite.append(
                    jQuery("<li>")
                        .append(" - Nom du site : ")
                        .append(val.nomSite)
                        .append(val.id)
                );
                /*newButton.button().click(function () {
                    $listSite.append(
                        jQuery("<li>")
                            .append(site.description)
                    )
                })*/
            });
        })
        .fail(function () {
            alert("Une erreur s'est produite.");
        });
}


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
                console.log(val)
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

function getListSecteur() {
    // URL de l'action AJAX
    var url = "getListSecteur()";
    // Paramètres de la requête AJAX
    var params = {
        site: jQuery("#listSite").val()
    };
    // Action AJAX en POST
    jQuery.post(
        url,
        params,
        function (data) {
            var $listSecteur = jQuery("#listSecteur");
            $listSecteur.empty();
            jQuery.each(data, function (key, val) {
                console.log($listSecteur);
                $listSecteur.append(
                    jQuery("<li>")
                        .append(val.nomSecteur)
                        .append(val.difficulte)
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
