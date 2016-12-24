$(document).ready(function () {

    var submitting = false;

    $("#submit").click(function (event) {
        if (!submitting) {
            if (!validate()) {
                clearState();
                return;
            }
            $("#msg").html("");
            submitting = true;
            $("#submit").value = "Working...";
            $("#submit").prop('disabled', true);
            $.ajax({
                type: 'POST',
                url: 'calculate',
                data: {
                    'landscape': $("#landscape").val().trim().replace(/ /g, '')
                },
                error: function (request, error) {
                    clearState();
                    $("#msg").html(error);
                },
                success: function (msg) {
                    clearState();
                    if (msg.indexOf("ERROR") !== -1) {
                       $("#msg").html(msg);
                    } else {
                       $("#result").html("Water volume: " + msg + " units.");
                    }
                }
            });
        }
    });

    function validate() {
        var landscape = $("#landscape").val();
        if (landscape.trim().length == 0) {
            $("#msg").html("Please, provide landscape array.");
            return false;
        }
        if (landscape.trim().length > 10000) {
            $("#msg").html("Too long hill!");
            return false;
        }
        landscape = landscape.replace(/ /g, '');
        var onlyDigitsAndComma = /^[0-9.,]+$/
        if (!onlyDigitsAndComma.test(landscape)) {
            $("#msg").html("Please, use only digits separated by commas.");
            return false;
        }
        return true;
    }

    function clearState() {
        $("#result").html("");
        $("#submit").prop('disabled', false);
        submitting = false;
        $("#submit").value = "Calculate water volume";
    }
});