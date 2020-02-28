package com.education.system_edu.mapper;

import com.education.system_edu.pojo.StudentSignAction;
import com.education.system_edu.pojo.StudentSignActionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentSignActionMapper {
    long countByExample(StudentSignActionExample example);

    int deleteByExample(StudentSignActionExample example);

    int deleteByPrimaryKey(String code);

    int insert(StudentSignAction record);

    int insertSelective(StudentSignAction record);

    List<StudentSignAction> selectByExample(StudentSignActionExample example);

    StudentSignAction selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") StudentSignAction record, @Param("example") StudentSignActionExample example);

    int updateByExample(@Param("record") StudentSignAction record, @Param("example") StudentSignActionExample example);

    int updateByPrimaryKeySelective(StudentSignAction record);

    int updateByPrimaryKey(StudentSignAction record);
}