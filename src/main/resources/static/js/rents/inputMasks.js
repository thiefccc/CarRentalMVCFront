$(function() {
    $('.dateTimePicker').inputmask("datetime", {
        mask: "1-2-y h:s",
        placeholder: "dd-mm-yyyy hh:mm",
        leapday: "-02-29",
        separator: "-",
        alias: "dd-mm-yyyy"
    });

    $('.datePicker').inputmask("datetime", {
        mask: "1-2-y",
        placeholder: "dd-mm-yyyy",
        leapday: "-02-29",
        separator: "-",
        alias: "dd-mm-yyyy"
    });
});