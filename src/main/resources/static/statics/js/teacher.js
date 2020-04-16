$(function () {
    $.ajax({
        type: "get",
        url: "/teacher/course",
        success: function (date) {
            console.log(date);
            $("#_course_manage").attr("aria-expanded","false");
            $("#course_manage").children().remove();
            $.each(date, function (index, value) {
                $("#course_manage").append("<li>\n" +
                    "                    <a href=\"/teacher/course/" + value.classCode + "\">"+value.name+"</a>\n" +
                    "                </li>");
            });

            $("#course_manage").removeClass("show");
        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            // 状态码
            console.log(XMLHttpRequest.status);
            // 状态
            console.log(XMLHttpRequest.readyState);
            // 错误信息
            console.log(textStatus);
        }
    })
});