package com.education.system_edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.education.system_edu.mapper.*;
import com.education.system_edu.pojo.*;
import com.education.system_edu.pojo.insert.TeacherSearchStudentInsert;
import com.education.system_edu.pojo.insert.UserInModel;
import com.education.system_edu.pojo.output.CourseClassUserStudentOutPut;
import com.education.system_edu.pojo.output.OutputUserForEditUserAction;
import com.education.system_edu.pojo.pojo_child.parameter.PageUser;
import com.education.system_edu.pojo.pojo_child.result.PageUserOutput;
import com.education.system_edu.pojo.pojo_getData.SearchUserByFaculty;
import com.education.system_edu.service.UserService;
import com.education.system_edu.utils.*;
import com.education.system_edu.utils.value.PageValue;
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
        if (null != user && !flag &&
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
        List<PageUserOutput> pageUserOutputs = userMapper.selectSelectedByUser(pageUser);
        List<PageUserOutput> _pageUserOutputs = new ArrayList<>();
        for(PageUserOutput pageUserOutput:pageUserOutputs){
            if(!StringUtils.isEmpty(pageUserOutput.getFaculty())){
                if(!StringUtils.isEmpty(pageUserOutput.getDepartment())){
                    _pageUserOutputs.add(pageUserOutput);
                }
            }
        }
        return _pageUserOutputs;
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
        pageSize = PageValue.PAGE_SIZE;
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
        pageUser.setPageSize(pageSize);
        List<PageUserOutput> pageUserOutputs = userMapper.countttt(pageUser);
        List<PageUserOutput> _pageUserOutputs = new ArrayList<>();
        for(PageUserOutput pageUserOutput:pageUserOutputs){
            if(!StringUtils.isEmpty(pageUserOutput.getFaculty())){
                if(!StringUtils.isEmpty(pageUserOutput.getDepartment())){
                    _pageUserOutputs.add(pageUserOutput);
                }
            }
        }

        if (_pageUserOutputs.size() % pageSize == 0) {
            return ((long)_pageUserOutputs.size() / pageSize)/2;
        } else {
            return ((long)_pageUserOutputs.size() / (pageSize + 1))/2;
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
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public List<CourseClassUserStudentOutPut> getUserByCourseCode(String courseClassCode) {
        List<CourseClassUserStudentOutPut> courseClassUserStudentOutPutlist = userMapper.getUserMsgForCourseClassOutput(courseClassCode);
        return courseClassUserStudentOutPutlist;
    }

    @Override
    public Integer countCourseByCourseSearchInsert(TeacherSearchStudentInsert teacherSearchStudentInsert, Integer pageSize, String courseClassCode) {
        if (teacherSearchStudentInsert == null
                || (StringUtils.isEmpty(teacherSearchStudentInsert.getStudentLoginCode())
                && StringUtils.isEmpty(teacherSearchStudentInsert.getStudentName()))) {
            return userMapper.countSelectByCourseClassCode(courseClassCode);
        }
        UserExample userExample = new UserExample();
        if (!StringUtils.isEmpty(teacherSearchStudentInsert.getStudentLoginCode())) {
            userExample.createCriteria().andLoginCodeEqualTo(teacherSearchStudentInsert.getStudentLoginCode());
            return userMapper.countSelectByCourseClassCodeAndName(courseClassCode
                    , teacherSearchStudentInsert.getStudentName());
        } else if (!StringUtils.isEmpty(teacherSearchStudentInsert.getStudentName())) {
            return 0;   }
        return null;
    }

    @Override
    public List<CourseClassUserStudentOutPut> getUserByTeacherSearchStudentInsert(TeacherSearchStudentInsert teacherSearchStudentInsert, String courseClassCode) {
        if (teacherSearchStudentInsert == null
                || (StringUtils.isEmpty(teacherSearchStudentInsert.getStudentLoginCode())
                && StringUtils.isEmpty(teacherSearchStudentInsert.getStudentName()))) {
            return usersToCourseClassUserStudentOutPuts(userMapper.selectByCourseClassCode(courseClassCode
                    , (teacherSearchStudentInsert.getPageNum()-1) * teacherSearchStudentInsert.getPageSize()
                    ,  teacherSearchStudentInsert.getPageSize()), courseClassCode);
        }
        UserExample userExample = new UserExample();
        if (!StringUtils.isEmpty(teacherSearchStudentInsert.getStudentLoginCode())) {
            userExample.createCriteria().andLoginCodeEqualTo(teacherSearchStudentInsert.getStudentLoginCode());
            return usersToCourseClassUserStudentOutPuts(userMapper.selectByExample(userExample), courseClassCode);
        } else if (!StringUtils.isEmpty(teacherSearchStudentInsert.getStudentName())) {
            return usersToCourseClassUserStudentOutPuts(userMapper.selectByCourseClassCodeAndName(courseClassCode
                    , teacherSearchStudentInsert.getStudentName()
                    , (teacherSearchStudentInsert.getPageNum()-1) * teacherSearchStudentInsert.getPageSize()
                    ,  teacherSearchStudentInsert.getPageSize()), courseClassCode);
        }
        return null;
    }


    private List<CourseClassUserStudentOutPut> usersToCourseClassUserStudentOutPuts(List<User> students, String courseClassCode) {
        List<CourseClassUserStudentOutPut> result = new ArrayList<>();
        for (User user : students) {
            result.add(userToCourseClassUserStudentOutPut(user, courseClassCode));
        }
        return result;
    }

    private CourseClassUserStudentOutPut userToCourseClassUserStudentOutPut(User user, String courseClassCode) {
        CourseClassUserStudentOutPut userStudentOutPut = new CourseClassUserStudentOutPut();
        userStudentOutPut.setCode(user.getCode());
        userStudentOutPut.setLoginCode(user.getLoginCode());
        userStudentOutPut.setUserName(user.getUserName());

        ConnectUserAndMajorExample connectUserAndMajorExample = new ConnectUserAndMajorExample();
        connectUserAndMajorExample.createCriteria()
                .andUseCodeEqualTo(user.getCode());
        SysDataTree major = sysDataTreeMapper.selectByPrimaryKey(
                connectUserAndMajorMapper
                        .selectByExample(connectUserAndMajorExample)
                        .get(0).getSysNodeCode());
        SysDataTree department = sysDataTreeMapper.selectByPrimaryKey(major.getParentNode());
        SysDataTree factory = sysDataTreeMapper.selectByPrimaryKey(department.getParentNode());
        userStudentOutPut.setMajor(major.getName());
        userStudentOutPut.setDepartment(department.getName());
        userStudentOutPut.setFactory(factory.getName());
        userStudentOutPut.setClassCode(courseClassCode);
        return userStudentOutPut;
    }
}
