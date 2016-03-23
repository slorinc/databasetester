$("#errorButton").on("click", function (event) {
    event.preventDefault();
    $("#errorList").slideToggle("fast");
})

setInterval(function () {
    jQuery.ajax({
        url: "/databasetester/internal/testing/ajax",
        success: function (result) {
            if (result > 0) {
                $("#counter").html('Counter: ' + result).css("display", "inline")
            } else {
                $("#counter").css("display", "none")

            }
        }
    })
}, 100);
