package com.education.system_edu.mapper;

import com.education.system_edu.pojo.StudentLSubmitTaskAction;
import com.education.system_edu.pojo.StudentLSubmitTaskActionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentLSubmitTaskActionMapper {
    long countByExample(StudentLSubmitTaskActionExample example);

    int deleteByExample(StudentLSubmitTaskActionExample example);

    int deleteByPrimaryKey(String code);

    int insert(StudentLSubmitTaskAction record);

    int insertSelective(StudentLSubmitTaskAction record);

    List<StudentLSubmitTaskAction> selectByExample(StudentLSubmitTaskActionExample example);

    StudentLSubmitTaskAction selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") StudentLSubmitTaskAction record, @Param("example") StudentLSubmitTaskActionExample example);

    int updateByExample(@Param("record") StudentLSubmitTaskAction record, @Param("example") StudentLSubmitTaskActionExample example);

    int updateByPrimaryKeySelective(StudentLSubmitTaskAction record);

    int updateByPrimaryKey(StudentLSubmitTaskAction record);
}