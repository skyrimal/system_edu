function pageHelperInit(pageNum, pageMaxNum) {//页脚页码加工功能
    console.log("进入生成")
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
    console.info(start+",,,.,"+end)
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
    console.info(pageNum);
    if (pageNum >= 8 && pageNum < pageMaxNum - 8) {
        appendAFootNum(1, 5, pageNum);

        appendAFootPoint(1, 3);

        if(Number(pageNum) + 3>pageMaxNum-13){

            appendAFootNum(Number(pageNum) - 3, pageMaxNum, Number(pageNum));

        }else{
            appendAFootNum(Number(pageNum) - 3, Number(pageNum) + 3, Number(pageNum));
            appendAFootPoint(1, 3);

            appendAFootNum(Number(pageNum) - 3, pageMaxNum, Number(pageNum));
        }



    }
}

//条件2-3，当pageNum>=pageMaxNum-8时
function action3(pageNum, pageMaxNum) {
    if (pageNum >= pageMaxNum - 8) {
        action1(1, pageMaxNum, pageNum)
    }

}

function clickA(pageNum, pageMaxNum, data, pageSize, url) {
    console.info("跳转 的接口"+url);
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
        console.info(page_num+"获取到"+url);
        $.ajax({
            type: "POST",
            url: url + page_num + "/" + pageSize,
            data: data,
            success(d) {
                console.info(d);
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
