package com.education.system_edu.utils;


import com.education.system_edu.pojo.SysDataTreeExample;
import com.education.system_edu.pojo.SysNodeExample;
import com.education.system_edu.utils.value.Entry;

import java.util.Date;
import java.util.Map;

public class SysTreeAndNodeUtils {
    private String loginCode;

    private ClassUtils<Object> classUtils = new ClassUtils<>();

    public void initSysTreeAndNodeUtils(String loginCode) {
        this.loginCode = loginCode;
    }

    public Object createAndUpdateMessage(Object object) {

        return classUtils.addUserCreateUseInfo(object, loginCode);
    }


    public Object updateMessage(Object object) {
        return classUtils.addUserUpdateUseInfo(object, loginCode);
    }

    /****************************************************共用方法*********************************************/

    public static SysDataTreeExample madeSysDataTreeExample(String departmentCode) {

        SysDataTreeExample sysDataTreeExample = new SysDataTreeExample();
        sysDataTreeExample.createCriteria().andCodeEqualTo(departmentCode).andTypeEqualTo((short) 3);
        return sysDataTreeExample;
    }
    public static SysDataTreeExample madeSysDataTreeExample(String departmentCode,Short type) {

        SysDataTreeExample sysDataTreeExample = new SysDataTreeExample();
        sysDataTreeExample.createCriteria().andCodeEqualTo(departmentCode).andTypeEqualTo(type);
        return sysDataTreeExample;
    }
    public static SysNodeExample madeSysNodeExample(String departmentCode) {

        SysNodeExample sysForSearch = new SysNodeExample();
        sysForSearch.createCriteria().andRoleTreeNodeCodeEqualTo(departmentCode).andTypeEqualTo((short) 3);
        return sysForSearch;
    }
}
