/*$( document ).ready(function() {
    $('.co').hide();

    $('.login-button').on('click', function() {
            $('.co').show();
        }
    )
}); */

$('.co').hide();

$('.login-button').click(function(){
    $('.co').show();
});



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
