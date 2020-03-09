package com.education.system_edu.service.impl;

import com.education.system_edu.mapper.UserMapper;
import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.UserExample;
import com.education.system_edu.pojo.pojo_child.parameter.PageUser;
import com.education.system_edu.pojo.pojo_child.result.PageUserOutput;
import com.education.system_edu.pojo.pojo_getData.SearchUserByFaculty;
import com.education.system_edu.service.UserService;
import com.education.system_edu.utils.EmptyUtil;
import com.education.system_edu.utils.EncryptionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

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

    @Override
    public List<PageUserOutput> selectUsersByUser(SearchUserByFaculty searchUserByFaculty, Integer pageSize, Integer pageNum) {
        PageUser pageUser = new PageUser();
        if (searchUserByFaculty != null) {
            pageUser.setFaculty(searchUserByFaculty.getFacultyId());
            pageUser.setDepartment(searchUserByFaculty.getDepartmentCode());
        }
        pageUser.setPageNum(pageNum);
        pageUser.setPageSize(pageSize);
        List<PageUserOutput> pageUserOutputs = userMapper.selectSelectedByUser(pageUser);
        return pageUserOutputs;
    }

    @Override
    public Long getUserPageCount(SearchUserByFaculty searchUserByFaculty, Integer pageSize) {
        PageUser pageUser = new PageUser();
        long pageCount = 0L;
        if (searchUserByFaculty != null) {
            pageUser.setFaculty(searchUserByFaculty.getFacultyId());
            pageUser.setDepartment(searchUserByFaculty.getDepartmentCode());
            if (searchUserByFaculty.getDepartmentCode().equals("") && searchUserByFaculty.getFacultyId().equals("") && searchUserByFaculty.getKeyword().equals("")) {
                pageCount = userMapper.countByExample(new UserExample());
            }else{
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


}
