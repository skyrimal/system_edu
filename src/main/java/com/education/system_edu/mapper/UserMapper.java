package com.education.system_edu.mapper;

import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.UserExample;
import java.util.List;

import com.education.system_edu.pojo.output.OutputUserForEditUserAction;
import com.education.system_edu.pojo.pojo_child.parameter.PageUser;
import com.education.system_edu.pojo.pojo_child.result.PageUserOutput;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    long countByPageUser(PageUser pageUser);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String code);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    /**
     * 按条件查找用户信息
     * @param user
     * @return
     */
    List<PageUserOutput> selectSelectedByUser(PageUser user);

    User selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    OutputUserForEditUserAction selectOutputUserForEditUserActionByLoginCode(@Param("loginCode") String loginCode);
}