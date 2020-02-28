package com.education.system_edu.utils;


import com.education.system_edu.pojo.SysDataTree;
import com.education.system_edu.pojo.SysDataTreeExample;
import com.education.system_edu.pojo.SysNodeExample;

import java.util.Date;
import java.util.Map;

public class SysTreeAndNodeUtils {
    private String loginCode;
    private Map<String, Object> createMap;
    private Map<String, Object> updateMap;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;

    private ClassUtils<Object> classUtils = new ClassUtils<>();

    public void initSysTreeAndNodeUtils(String loginCode) {
        this.loginCode = loginCode;
        createMap = UserUtils.create(loginCode);
        updateMap = UserUtils.update(loginCode);
        createBy = createMap.get(Entry.CREATE_BY).toString();
        createTime = (Date) createMap.get(Entry.CREATE_TIME);
        updateBy = updateMap.get(Entry.UPDATE_BY).toString();
        updateTime = (Date) updateMap.get(Entry.UPDATE_TIME);
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
