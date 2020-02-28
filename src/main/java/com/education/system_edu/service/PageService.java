package com.education.system_edu.service;

import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.UserExample;

public interface PageService {
    User findUser(UserExample userExample);
}
