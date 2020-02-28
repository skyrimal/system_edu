package com.education.system_edu.service.impl;

import com.education.system_edu.mapper.UserMapper;
import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.UserExample;
import com.education.system_edu.service.PageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PageServiceImpl implements PageService {

    @Resource
    UserMapper userMapper;

    @Override
    public User findUser(UserExample userExample) {
        return userMapper.selectByExample(userExample).get(0);
    }
}
