/*$( document ).ready(function() {
    $('.co').hide();

    $('.login-button').on('click', function() {
            $('.co').show();
        }
    )
}); */

$(document).ready(function() {

    $(".title").hide();
        $(".title").fadeIn(5000,function(){
        });
})

/*

$('#listSite').click(function() {
    $.ajax({
        url: "ListSite", // Nom de l'action
        type: "POST",
        data: {listSite: $('topoId').val()}, // Nom de la variable puis paramètre
        dataType: "json",
        error: function(XMLHttpRequest, textStatus, errorThrown){
            alert('Error ' + textStatus);
            alert(errorThrown);
            alert(XMLHttpRequest.responseText);
        },
        success: function(data){
            alert('SUCCESS');

        }
    });
})

*/


function getSite() {
    $.ajax({
        type : "POST",
        url : "ListSite",
        data: {listSite: $('topoId').val()},
        success : function(itr) {
            var x = "<ol>";
            $.each(itr.listSite, function() {
                x += "<li>" + this + "</li>";
            });
            x += "</ol>";
            $("#listSite").html(x);
        },
        error : function(itr) {
            alert("No values found..!!");
        }
    });
}
