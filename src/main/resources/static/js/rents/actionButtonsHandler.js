// TODO functions which activates Bootstrap accordion on forms

var activateSetRentIdToForm = function(buttonClass, fillingInputId, collapseFormId){
    $.each($("." + buttonClass), function(){
        let rentId = $(this).attr("rentid");
        $(this).click(function(e){
            e.preventDefault(); // prevent Links redirection
            $("#" + fillingInputId).val(rentId);
            $("#" + collapseFormId).collapse('show');
            window.scrollTo(0, 0);
        });
    });
}

$(document).ready(function(){
    activateSetRentIdToForm("ext_link", "extRentId", "collapseTwo");
    activateSetRentIdToForm("close_link", "closeRentId", "collapseThree");
});