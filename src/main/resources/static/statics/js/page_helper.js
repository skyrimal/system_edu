function pageHelperInit(pageNum, pageMaxNum) {//页脚页码加工功能
//1.生成页面超链接
//1.1 生成上一页下一页首页尾页四个超链接
    $("#pageFoot").append("<a class=\" text-black-50\" href=\"#\"><< \t&ensp; </a>");
    $("#pageFoot").append("<a class=\" text-black-50\" href=\"#\"><  \t&ensp; </a>");
//1.2 按最大页码生成页脚
//条件1，当pageMaxNum小于10时
    if (pageMaxNum < 20) {
        appendAFootNum(1, pageMaxNum);
    }
//条件2，当pageMaxNum大于20时
    else {
        //条件2-1，当pageNum<8时
        action1(pageNum, pageMaxNum);
        //条件2-2，当pageNum>=8 pageNum<pageMaxNum-8时
        action2(pageNum, pageMaxNum);
        //条件2-3，当pageNum>=pageMaxNum-8时
        action3(pageNum, pageMaxNum)
    }
    $("#pageFoot").append("<a class=\" text-black-50\" href=\"#\">>  \t&ensp; </a>");
    $("#pageFoot").append("<a class=\" text-black-50\" href=\"#\">>> \t&ensp; </a>");

}

function appendAFootNum(start, end, pageNum) {
    for (var i = start; i <= end; i++) {
        $("#pageFoot").append("<a class=\" text-black-50\" href=\"#\">" + i + " \t&ensp; </a>");
    }
}

function appendAFootPoint(start, end) {
    for (var i = start; i <= end; i++) {
        $("#pageFoot").append("." + "\t&ensp;");
    }
}

//条件2-1，当pageNum<8时
function action1(pageNum, pageMaxNum) {
    if (pageNum < 8) {
        appendAFootNum(1, 10, pageNum);

        appendAFootPoint(1, 10);

        appendAFootNum(pageMaxNum - 7, pageMaxNum, pageNum);
    }
}

//条件2-2，当pageNum>=8 pageNum<pageMaxNum-8时
function action2(pageNum, pageMaxNum) {
    if (pageNum >= 8 && pageNum < pageMaxNum - 8) {
        appendAFootNum(1, 5, pageNum);

        appendAFootPoint(1, 3);

        appendAFootNum(pageNum - 3, pageNum + 3, pageNum);

        appendAFootPoint(1, 3);

        appendAFootNum(pageMaxNum - 3, pageMaxNum, pageNum);
    }
}

//条件2-3，当pageNum>=pageMaxNum-8时
function action3(pageNum, pageMaxNum) {
    if (pageNum >= pageMaxNum - 8) {
        action1(1, pageMaxNum, pageNum)
    }

}

function clickA(pageNum, pageMaxNum, data, pageSize) {
    $("#pageFoot a").click(function () {
        var page_num = $(this).text();
        switch (page_num.trim(' ')) {
            case '>':
                if (pageNum<pageMaxNum){
                    page_num =  parseInt(pageNum) + 1;
                }else {
                    page_num =  parseInt(pageNum);
                }
                break;
            case '<':
                if (pageNum>1){
                    page_num =  parseInt(pageNum)- 1;
                }else {
                    page_num =  parseInt(pageNum);
                }
                break;
            case '>>':
                page_num =  parseInt(pageMaxNum);
                break;
            case '<<':
                page_num =  1;
                break;
            default:
                break;
        }
        console.info(page_num+"获取到");
        $.ajax({
            type: "POST",
            url: "/manage/faculty/searchClass/" + page_num + "/" + pageSize,
            data: data,
            success(d) {
                $(" body").html(d);
            }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                // 状态码
                console.log(XMLHttpRequest.status);
                // 状态
                console.log(XMLHttpRequest.readyState);
                // 错误信息
                console.log(textStatus);
            }
        });
    });
}
