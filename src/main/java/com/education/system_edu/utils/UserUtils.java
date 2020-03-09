package com.education.system_edu.utils;


import com.education.system_edu.mapper.ConnectUserAndMajorMapper;
import com.education.system_edu.mapper.SysDataTreeMapper;
import com.education.system_edu.mapper.SysNodeMapper;
import com.education.system_edu.mapper.UserMapper;
import com.education.system_edu.pojo.*;
import com.education.system_edu.pojo.insert.UserInModel;
import com.education.system_edu.utils.value.Entry;
import com.education.system_edu.utils.value.UserValue;

import java.util.*;

public class UserUtils {
    public static String TEACHER = "老师";
    public static String STUDENT = "学生";
    public static String MANAGER = "管理员";

    public static String getUserType(String userType) {
        switch (userType) {
            case "1":
                return TEACHER;
            case "2":
                return STUDENT;
            case "3":
                return MANAGER;
            default:
                return "error";
        }
    }

    public static String getUserTypeToName(String userType) {
        switch (userType) {
            case "1":
                return "teacher";
            case "2":
                return "student";
            case "3":
                return "manage";
            default:
                return "error";
        }
    }

    /**
     * 给页面 -- 显示用户基础信息 -- 用户名和用户类型
     * @param user
     * @return
     */
    public static Map<String, String> userForLeftBar(User user) {
        Map<String, String> _user = new HashMap<>();
        _user.put("user_type", getUserType(user.getUserType()));
        _user.put("user_name", user.getUserName());
        return _user;
    }

    /**
     * 给用户添加创建时间和创建者
     * 弃置 改为反射工具进行
     * @return
     */
//    public static Map<String, Object> create(String loginCode) {
//        Map<String, Object> map = new HashMap<>();
//
//        map.put(Entry.CREATE_BY, loginCode);
//        map.put(Entry.CREATE_TIME, new Date());
//        return map;
//    }

    /**
     * 用户添加修改者信息和修改时间
     * 弃置 改为反射工具进行
     * @return
     */
//    public static Map<String, Object> update(String loginCode) {
//        Map<String, Object> map = new HashMap<>();
//
//        map.put(Entry.UPDATE_BY, loginCode);
//        map.put(Entry.UPDATE_TIME, new Date());
//        return map;
//    }


    public static User madeUser(UserInModel userInModel, Long studentNo, UserMapper userMapper, String userLoginCode) {
        UserExample userExample = new UserExample();

        ClassUtils<User> classUtils = new ClassUtils<>();

        User user = new User();
        user.setCode(UU3D.uu3d());
        user.setLoginCode(UserValue.PREFIX_CLASS_NO + userInModel.getGrade() + userInModel.getClassNo() + studentNo);
        user.setUserName(userInModel.getUserName());
        user.setPassword(EncryptionUtils.encryption("MD5", "123456", user.getCode()).toString());
        user.setUserType(userInModel.getUserType());
        user.setMgrType(0 + "");
        user.setStatus("0");
        user = classUtils.addUserCreateUseInfo(user, userLoginCode);

        userExample.createCriteria().andLoginCodeEqualTo(user.getLoginCode());
        System.out.println("studentNo++>"+studentNo);
        if (userMapper.selectByExample(userExample).size() != 0) {
            return useMadeUser(userInModel, studentNo+1, userMapper, userLoginCode);
        } else {
            return user;
        }
    }


    public static ConnectUserStudentAndClass connectUserStudentAndClass(User user, String classNo, String userLoginCode) {
        ClassUtils<ConnectUserStudentAndClass> classUtils = new ClassUtils<>();

        ConnectUserStudentAndClass connectUserStudentAndClass = new ConnectUserStudentAndClass();
        connectUserStudentAndClass.setCode(UU3D.uu3d());
        connectUserStudentAndClass.setClassCode(classNo);
        connectUserStudentAndClass.setStudentCode(user.getCode());
        connectUserStudentAndClass.setStudentNo(user.getLoginCode());
        connectUserStudentAndClass = classUtils.addUserCreateUseInfo(connectUserStudentAndClass, userLoginCode);

        return connectUserStudentAndClass;
    }

    private static User useMadeUser(UserInModel userInModel, Long studentNo, UserMapper userMapper, String userLoginCode) {
        return madeUser(userInModel, studentNo, userMapper, userLoginCode);
    }

    public static List<ConnectUserAndRole> connectUserAndRole(SysNodeMapper sysNodeMapper, String type, String code, String userLoginCode) {
        List<ConnectUserAndRole> connectUserAndRoles = new ArrayList<>();

        connectUserAndRoles.add(madeConnectUserAndRole(sysNodeMapper, getUserTypeToName(type), code, userLoginCode));
        connectUserAndRoles.add(madeConnectUserAndRole(sysNodeMapper, "user", code, userLoginCode));
        return connectUserAndRoles;
    }

    private static ConnectUserAndRole madeConnectUserAndRole(SysNodeMapper sysNodeMapper, String roleName, String code, String userLoginCode) {
        ClassUtils<ConnectUserAndRole> classUtils = new ClassUtils<>();

        SysNodeExample sysNodeExample = new SysNodeExample();
        sysNodeExample.createCriteria().andTypeEqualTo((short) 1).andNameEqualTo(roleName);

        ConnectUserAndRole connectUserAndRole = new ConnectUserAndRole();
        connectUserAndRole.setCode(UU3D.uu3d());
        connectUserAndRole.setUseCode(code);
        connectUserAndRole.setSysRoleNodeCode(sysNodeMapper.selectByExample(sysNodeExample).get(0).getCode());
        connectUserAndRole.setSysRoleNodeType((short) 1);

        return classUtils.addUserCreateUseInfo(connectUserAndRole, userLoginCode);
    }

    public static ConnectUserAndMajor connectUserAndMajor(String code, String majorCode, String userLoginCode) {
        ClassUtils<ConnectUserAndMajor> classUtils = new ClassUtils<>();

        ConnectUserAndMajor connectUserAndMajor = new ConnectUserAndMajor();
        connectUserAndMajor.setCode(UU3D.uu3d());
        connectUserAndMajor.setUseCode(code);
        connectUserAndMajor.setSysNodeType((short)7);
        connectUserAndMajor.setSysNodeCode(majorCode);
        return classUtils.addUserCreateUseInfo(connectUserAndMajor,userLoginCode);
    }
}
