package com.education.system_edu.mapper;

import com.education.system_edu.pojo.CorrectAssignmenrtAction;
import com.education.system_edu.pojo.CorrectAssignmenrtActionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CorrectAssignmenrtActionMapper {
    long countByExample(CorrectAssignmenrtActionExample example);

    int deleteByExample(CorrectAssignmenrtActionExample example);

    int deleteByPrimaryKey(String code);

    int insert(CorrectAssignmenrtAction record);

    int insertSelective(CorrectAssignmenrtAction record);

    List<CorrectAssignmenrtAction> selectByExample(CorrectAssignmenrtActionExample example);

    CorrectAssignmenrtAction selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") CorrectAssignmenrtAction record, @Param("example") CorrectAssignmenrtActionExample example);

    int updateByExample(@Param("record") CorrectAssignmenrtAction record, @Param("example") CorrectAssignmenrtActionExample example);

    int updateByPrimaryKeySelective(CorrectAssignmenrtAction record);

    int updateByPrimaryKey(CorrectAssignmenrtAction record);
}