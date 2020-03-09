package com.education.system_edu.service;

import com.education.system_edu.pojo.insert.UserInModel;
import com.education.system_edu.pojo.pojo_child.result.PageUserOutput;
import com.education.system_edu.pojo.pojo_getData.SearchUserByFaculty;

import java.util.List;

public interface UserService {
    boolean updatePassword(String loginCode, String oldPassword, String newPassword);
    List<PageUserOutput> selectUsersByUser(SearchUserByFaculty searchUserByFaculty, Integer pageSize, Integer pageNum);
    Long getUserPageCount( SearchUserByFaculty searchUserByFaculty,Integer pageSize);

    Integer addUser(UserInModel userInModel, String userLoginCode);
}
