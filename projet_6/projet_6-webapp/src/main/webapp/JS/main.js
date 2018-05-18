$(document).ready(function() {

    $(".title").hide();
        $(".title").fadeIn(5000,function(){
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
            $listSite.empty();
            jQuery.each(data, function (key, val) {
                $listSite.append(
                    jQuery("<li>")
                        .append(" - Nom du site : ")
                        .append(val.nomSite)
                );
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

