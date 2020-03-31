$(function () {
    $.ajax({
        type: "get",
        url: "teacher/course",
        success : function(date){
            $("#course_manage").children().remove();
            $.each(date,function (index,value) {
                $("#course_manage").append("<li>\n" +
                    "                    <a href=\"/teacher/course/"+value.courseCode+"\">Page</a>\n" +
                    "                </li>");
            })
        }
    })
});