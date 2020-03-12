package com.education.system_edu.service.impl;

import com.education.system_edu.mapper.*;
import com.education.system_edu.pojo.*;
import com.education.system_edu.pojo.insert.UserInModel;
import com.education.system_edu.pojo.output.OutputUserForEditUserAction;
import com.education.system_edu.pojo.pojo_child.parameter.PageUser;
import com.education.system_edu.pojo.pojo_child.result.PageUserOutput;
import com.education.system_edu.pojo.pojo_getData.SearchUserByFaculty;
import com.education.system_edu.service.UserService;
import com.education.system_edu.utils.ClassUtils;
import com.education.system_edu.utils.EmptyUtil;
import com.education.system_edu.utils.EncryptionUtils;
import com.education.system_edu.utils.UserUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Resource
    SysDataTreeMapper sysDataTreeMapper;
    @Resource
    SysNodeMapper sysNodeMapper;
    @Resource
    ConnectUserAndMajorMapper connectUserAndMajorMapper;
    @Resource
    ConnectUserAndRoleMapper connectUserAndRoleMapper;
    @Resource
    ConnectUserStudentAndClassMapper connectUserStudentAndClassMapper;


    /**
     * 用户修改密码
     *
     * @param loginCode
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    public boolean updatePassword(String loginCode, String oldPassword, String newPassword) {
        //判断新密码是否为空
        ClassUtils<User> classUtils = new ClassUtils<>();
        boolean flag = EmptyUtil.stringIsEmpty(newPassword);
        UserExample userForSearch = new UserExample();
        userForSearch.createCriteria().andLoginCodeEqualTo(loginCode);
        User user = userMapper.selectByExample(userForSearch).get(0);
        if (null != user && flag &&
                user.getPassword()
                        .equals(EncryptionUtils
                                        .encryption("MD5", oldPassword, user.getCode()).toString())) {
            User _user = new User();
            _user.setCode(user.getCode());
            _user.setPassword(EncryptionUtils.encryption("MD5", newPassword, user.getCode()).toString());
            _user = classUtils.addUserUpdateUseInfo(_user, loginCode);
            int count = userMapper.updateByPrimaryKeySelective(_user);
            return count != 0;
        } else {
            return false;
        }
    }

    /**
     * 通过页面传入的信息搜索user
     *
     * @param searchUserByFaculty
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public List<PageUserOutput> selectUsersByUser(SearchUserByFaculty searchUserByFaculty, Integer pageSize, Integer pageNum) {
        PageUser pageUser = new PageUser();
        if (searchUserByFaculty != null) {
            if (!searchUserByFaculty.getKeyword().equals("") && searchUserByFaculty.getKeyword() != null) {
            }
            if (!searchUserByFaculty.getFacultyId().equals("")
                    && searchUserByFaculty.getFacultyId() != null) {
                pageUser.setFaculty(searchUserByFaculty.getFacultyId());
            }
            if (!searchUserByFaculty.getDepartmentCode().equals("")
                    && searchUserByFaculty.getDepartmentCode() != null) {
                pageUser.setDepartment(searchUserByFaculty.getDepartmentCode());
            }
        }
        pageUser.setPageNum(pageNum);
        pageUser.setPageSize(pageSize);
        return userMapper.selectSelectedByUser(pageUser);
    }

    /**
     * 获取user分页总页数
     * 按情况，如果没有进行过搜索则是总数，如果进行过搜索则先获得搜索后的数量
     *
     * @param searchUserByFaculty
     * @param pageSize
     * @return
     */
    @Override
    public Long getUserPageCount(SearchUserByFaculty searchUserByFaculty, Integer pageSize) {
        PageUser pageUser = new PageUser();
        long pageCount = 0L;
        if (searchUserByFaculty != null) {
            pageUser.setFaculty(searchUserByFaculty.getFacultyId());
            pageUser.setDepartment(searchUserByFaculty.getDepartmentCode());
            if (searchUserByFaculty.getDepartmentCode().equals("") && searchUserByFaculty.getFacultyId().equals("") && searchUserByFaculty.getKeyword().equals("")) {
                pageCount = userMapper.countByExample(new UserExample());
            } else {
                pageCount = userMapper.countByPageUser(pageUser);
            }
        } else {
            pageCount = userMapper.countByExample(new UserExample());
        }

        if (pageCount % pageSize == 0) {
            return pageCount / pageSize;
        } else {
            return pageCount / pageSize + 1;
        }
    }

    /**
     * 添加一个用户以及其关联类
     *
     * @param userInModel
     * @param userLoginCode
     * @return
     */
    @Override
    public Integer addUser(UserInModel userInModel, String userLoginCode) {
        //判断数据库是否修改
        int flag = 0;
        //创建mapper用的Example
        ConnectUserStudentAndClassExample connectUserStudentAndClassExample = new ConnectUserStudentAndClassExample();
        //创建要添加到数据库的实体类
        //1.创建user
        //1.1获取班级大小，添加用户为最后一个
        connectUserStudentAndClassExample.createCriteria().andClassCodeEqualTo(userInModel.getClassNo());
        long studentNo = connectUserStudentAndClassMapper.countByExample(connectUserStudentAndClassExample);
        User user = UserUtils.madeUser(userInModel, studentNo + 1, userMapper, userLoginCode);
        flag += userMapper.insert(user);

        //2.创建role-user联系
        List<ConnectUserAndRole> connectUserAndRoles = UserUtils.connectUserAndRole(sysNodeMapper, userInModel.getUserType(), user.getCode(), userLoginCode);
        for (ConnectUserAndRole connectUserAndRole : connectUserAndRoles) {
            flag += connectUserAndRoleMapper.insert(connectUserAndRole);
        }

        //3.创建user-department联系--不需要，直接通过class -- department获取
        //改为major与user联系
        //ConnectUserAndDepartment connectUserAndDepartment = UserUtils.connectUserAndDePartment();
        ConnectUserAndMajor connectUserAndMajor = UserUtils.connectUserAndMajor(user.getCode(), userInModel.getMajor(), userLoginCode);
        flag += connectUserAndMajorMapper.insert(connectUserAndMajor);
        if (user.getUserType().equals("2")) {
            //4.创建学生-班级user-class联系
            ConnectUserStudentAndClass connectUserStudentAndClass = UserUtils.connectUserStudentAndClass(user, userInModel.getClassNo(), userLoginCode);
            flag += connectUserStudentAndClassMapper.insert(connectUserStudentAndClass);
        }
        return flag;
    }

    @Override
    public OutputUserForEditUserAction getOutputUserForEditUserActionBy(String loginCode) {
        return userMapper.selectOutputUserForEditUserActionByLoginCode(loginCode);
    }

    /**
     * 修改部分添加用户方法实现修改用户功能
     *
     * @param userInModel
     * @param userLoginCode
     * @return
     */
    @Override
    public Integer editUser(UserInModel userInModel, String userLoginCode) {
        //判断数据库是否修改
        int flag = 0;
        //修改user
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginCodeEqualTo(userInModel.getUserId());
        User user = userMapper.selectByExample(userExample).get(0);
        user.setUserName(userInModel.getUserName());
        user = (User) updateObject(user, userLoginCode);

        userMapper.updateByPrimaryKey(user);
        //修改user—class连接
        ConnectUserStudentAndClassExample connectUserStudentAndClassExample = new ConnectUserStudentAndClassExample();
        connectUserStudentAndClassExample.createCriteria().andStudentCodeEqualTo(user.getCode());
        connectUserStudentAndClassMapper.deleteByExample(connectUserStudentAndClassExample);
        if (user.getUserType().equals("2")) {
            //4.创建学生-班级user-class联系
            ConnectUserStudentAndClass connectUserStudentAndClass = UserUtils.connectUserStudentAndClass(user, userInModel.getClassNo(), userLoginCode);
            flag += connectUserStudentAndClassMapper.insert(connectUserStudentAndClass);
        }
        //修改user-major连接
        ConnectUserAndMajorExample connectUserAndMajorExample = new ConnectUserAndMajorExample();
        connectUserAndMajorExample.createCriteria().andUseCodeEqualTo(user.getCode());
        connectUserAndMajorMapper.deleteByExample(connectUserAndMajorExample);
        ConnectUserAndMajor connectUserAndMajor = UserUtils.connectUserAndMajor(user.getCode(), userInModel.getMajor(), userLoginCode);
        flag += connectUserAndMajorMapper.insert(connectUserAndMajor);
        //修改user-role连接
        ConnectUserAndRoleExample connectUserAndRoleExample = new ConnectUserAndRoleExample();
        connectUserAndRoleExample.createCriteria().andUseCodeEqualTo(user.getCode());
        connectUserAndRoleMapper.deleteByExample(connectUserAndRoleExample);
        List<ConnectUserAndRole> connectUserAndRoles = UserUtils.connectUserAndRole(sysNodeMapper, userInModel.getUserType(), user.getCode(), userLoginCode);
        for (ConnectUserAndRole connectUserAndRole : connectUserAndRoles) {
            flag += connectUserAndRoleMapper.insert(connectUserAndRole);
        }
        return flag;
    }

    @Override
    public Integer initPassword(String loginCode) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginCodeEqualTo(loginCode);
        User user = userMapper.selectByExample(userExample).get(0);
        user.setPassword(EncryptionUtils.encryption("MD5", "123456", user.getCode()).toString());
        userMapper.updateByPrimaryKey(user);
        return null;
    }


    public static Object updateObject(Object o, String userLoginCode) {
        ClassUtils<Object> classUtils = new ClassUtils<>();
        return classUtils.addUserUpdateUseInfo(o, userLoginCode);
    }


}
