package com.education.system_edu.service.impl;

import com.education.system_edu.mapper.UserMapper;
import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.UserExample;
import com.education.system_edu.service.UserService;
import com.education.system_edu.utils.EmptyUtil;
import com.education.system_edu.utils.EncryptionUtils;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    /**
     * 用户修改密码
     * @param loginCode
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    public boolean updatePassword(String loginCode, String oldPassword, String newPassword) {
        //判断新密码是否为空
        boolean flag = EmptyUtil.stringIsEmpty(newPassword);
        UserExample userForSearch = new UserExample();
        userForSearch.createCriteria().andLoginCodeEqualTo(loginCode);
        User user = userMapper.selectByExample(userForSearch).get(0);
        System.out.println("旧密码" + oldPassword);
        System.out.println("新密码" + newPassword);
        if (null != user && flag &&
                user.getPassword()
                        .equals(EncryptionUtils
                                        .encryption("MD5", oldPassword, user.getCode()).toString())) {
            User _user = new User();
            _user.setCode(user.getCode());
            _user.setPassword(EncryptionUtils.encryption("MD5", newPassword, user.getCode()).toString());
            System.out.println("加密后的密码" + _user.getPassword());
            int count = userMapper.updateByPrimaryKeySelective(_user);
            return count != 0;
        } else {
            return false;
        }
    }
}
