var getObjects = function(path, fillFunction){
    $.ajax({
        method: "GET",
        url: 'http://localhost:8082/' + path,
        success: function (data) {
            console.log('Items from "' + path + '" have been received.');
            fillFunction(data);
        },
        error: function (data) {console.log('Items from "' + path + '" have NOT been received.'); }
    });
}

var fillRenteres = function(itemsJson){
    $.each(itemsJson, function(){
        $("#renterId").append($("<option />").val(this.renterId).text(this.renterName));
    })
}

var fillItems = function(itemsJson){
    $.each(itemsJson, function(){
        if(!this.isRented)
            $("#rentedItemId").append($("<option />").val(this.rentedItemId).text(this.rentedItemName));
    })
}

var fillOffice = function(itemsJson, officeSelectId){
    $.each(itemsJson, function(){
        $('#' + officeSelectId).append($("<option />").val(this.rentalOfficeId).text(this.rentalOfficeName));
    })
}

var fillOffices = function(itemsJson){
    fillOffice(itemsJson, 'getRentalOfficeId');
    fillOffice(itemsJson, 'returnRentalOfficeId');
}


$(document).ready(function(){
    getObjects("renters", fillRenteres);
    getObjects("items", fillItems);
    getObjects("offices", fillOffices);
});