$(function () {
    $("#stu_main").addClass("active");
    $.ajax({
        url: "/student/course/courseClass",
        typ: "get",
        success(date) {
            $("#coursedropdownDropdown").children().remove();
            $.each(date,function (index,value) {
                $("#coursedropdownDropdown").append("" +
                    "                <li>\n" +
                    "                    <a href=\"/student/course/into/"+value.code+"\">"+value.name+"</a>\n" +
                    "                </li>");
            })
        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            // 状态码
            console.log(XMLHttpRequest.status);
            // 状态
            console.log(XMLHttpRequest.readyState);
            // 错误信息
            console.log(textStatus);
        }
    })
})