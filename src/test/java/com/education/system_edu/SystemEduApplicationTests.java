package com.education.system_edu;

import com.education.system_edu.mapper.SysModelClassMapper;
import com.education.system_edu.mapper.UserMapper;
import com.education.system_edu.pojo.SysModelClass;
import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.insert.ClassSearchInsert;
import com.education.system_edu.pojo.insert.UserInModel;
import com.education.system_edu.pojo.output.ClassSearchOutput;
import com.education.system_edu.pojo.pojo_child.parameter.PageUser;
import com.education.system_edu.pojo.pojo_child.result.PageUserOutput;
import com.education.system_edu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class SystemEduApplicationTests {

    @Resource
    UserMapper userMapper;
    @Resource
    SysModelClassMapper sysModelClassMapper;

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    void contextLoads() {
        PageUser pageUser = new PageUser();
        pageUser.setPageNum(1);
        pageUser.setPageSize(10);
        pageUser.setFaculty("2");
        List<PageUserOutput> users = userMapper.selectSelectedByUser(pageUser);
        System.out.println("users的大小" + users.size());
        for (PageUserOutput user : users) {
            System.out.println(user.getUser().getLoginCode());
            System.out.println(user.getUser().getUserName());
            System.out.println(user.getClassCode());
            System.out.println(user.getMajor());
        }
    }
    @Test
    void userPage() {
        System.out.println(UUID.randomUUID().toString());
    }

    @Test
    void testAddOneUser(){
        UserInModel userInModel = new UserInModel();
        userInModel.setUserName("又是比");
        userInModel.setUserType("1");
        userInModel.setGrade(20+"");
        userInModel.setClassNo("2");
        userInModel.setMajor("20841d007c844ed0840f2bdcb07a6d8c");
        userService.addUser(userInModel,"2000000");
    }
    @Test
    void searchClass(){
        ClassSearchInsert classSearchInsert = new ClassSearchInsert();
        classSearchInsert.setFacultyName("智能科技学院");
        List<ClassSearchOutput> classSearchOutputs =  sysModelClassMapper.selectByClassSearchInsert(classSearchInsert);
        for (ClassSearchOutput classSearchOutput:classSearchOutputs ) {
            System.out.println(classSearchOutput.getDepartmentName());
        }
    }
}
