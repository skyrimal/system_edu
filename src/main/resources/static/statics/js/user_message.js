$(function () {

    $.ajax({
        type: "GET",
        url: "/user/user_message",
        dataType: "json",
        success: function (data) {
            console.info(data);
            $("#user_name").text(data.user_name);
            $("#user_type").text(data.user_type);
        }
    });
});