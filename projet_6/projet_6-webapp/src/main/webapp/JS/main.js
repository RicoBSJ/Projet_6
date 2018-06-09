
// Faire apparaitre le titre en 3s

$(document).ready(function() {
    $(".title").hide();
        $(".title").fadeIn(3000,function(){
        });
})

// Récuperer liste de secteur en ajax

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
                        .val(val.nomSecteur)
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
                        .text(val.nom)
                        .val(val.nom)
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


// Pagination topo

var show_per_page = 3;
var current_page = 0;

function set_display(first, last) {
    $('#content').children().css('display', 'none');
    $('#content').children().slice(first, last).css('display', 'block');
}

function previous(){
    if($('.active').prev('.page_link').length) go_to_page(current_page - 1);
}

function next(){
    if($('.active').next('.page_link').length) go_to_page(current_page + 1);
}

function go_to_page(page_num){
    current_page = page_num;
    start_from = current_page * show_per_page;
    end_on = start_from + show_per_page;
    set_display(start_from, end_on);
    $('.active').removeClass('active');
    $('#id' + page_num).addClass('active');
}

$(document).ready(function() {

    var number_of_pages = Math.ceil($('#content').children().length / show_per_page);

    var nav = '<ul class="pagination"><li><a href="javascript:previous();">&laquo;</a>';

    var i = -1;
    while(number_of_pages > ++i){
        nav += '<li class="page_link'
        if(!i) nav += ' active';
        nav += '" id="id' + i +'">';
        nav += '<a href="javascript:go_to_page(' + i +')">'+ (i + 1) +'</a>';
    }
    nav += '<li><a href="javascript:next();">&raquo;</a></ul>';

    $('#page_navigation').html(nav);
    set_display(0, show_per_page);

});

