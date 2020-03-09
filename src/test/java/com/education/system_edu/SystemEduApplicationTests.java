package com.education.system_edu;

import com.education.system_edu.mapper.UserMapper;
import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.pojo_child.parameter.PageUser;
import com.education.system_edu.pojo.pojo_child.result.PageUserOutput;
import com.education.system_edu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SystemEduApplicationTests {

    @Resource
    UserMapper userMapper;

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
    }

}
