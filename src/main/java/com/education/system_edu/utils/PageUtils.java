package com.education.system_edu.utils;

import com.education.system_edu.pojo.model.PageMsg;
import com.education.system_edu.utils.value.PageValue;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.TimeZone;

public class PageUtils {
    public static String TEACHER = "teacher/t_";
    public static String STUDENT = "stu_";
    public static String MANAGER = "m_";

    public static String findPageByUserType(String userType, String lastUrlName) {
        switch (userType) {
            case "1":
                return TEACHER + lastUrlName;
            case "2":
                return STUDENT + lastUrlName;
            case "3":
                return MANAGER + lastUrlName;
            default:
                return "error";
        }
    }

    public static PageMsg madePageMsg(Integer pageNum, Integer pageSize, Integer maxPage) {
        PageMsg page = new PageMsg();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setMaxPage(maxPage);
        return page;
    }

    public static boolean sendPageMsgToModel(Model model, PageMsg pageMsg) {
        model.addAttribute(PageValue.PAGE_MODEL_KEY, pageMsg);
        return model.getAttribute(PageValue.PAGE_MODEL_KEY) != null;
    }

    public static Integer coutPageSize(Integer i, Integer pageSize){
        boolean flag = IntegerUtils.isExactlyDivisible(i, pageSize);
        if (flag) {
            return i / pageSize;
        } else {
            return i / pageSize + 1;
        }
    }


}
