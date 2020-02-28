package com.education.system_edu.mapper;

import com.education.system_edu.pojo.ConnectUserStudentAndClass;
import com.education.system_edu.pojo.ConnectUserStudentAndClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConnectUserStudentAndClassMapper {
    long countByExample(ConnectUserStudentAndClassExample example);

    int deleteByExample(ConnectUserStudentAndClassExample example);

    int deleteByPrimaryKey(String code);

    int insert(ConnectUserStudentAndClass record);

    int insertSelective(ConnectUserStudentAndClass record);

    List<ConnectUserStudentAndClass> selectByExample(ConnectUserStudentAndClassExample example);

    ConnectUserStudentAndClass selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") ConnectUserStudentAndClass record, @Param("example") ConnectUserStudentAndClassExample example);

    int updateByExample(@Param("record") ConnectUserStudentAndClass record, @Param("example") ConnectUserStudentAndClassExample example);

    int updateByPrimaryKeySelective(ConnectUserStudentAndClass record);

    int updateByPrimaryKey(ConnectUserStudentAndClass record);
}