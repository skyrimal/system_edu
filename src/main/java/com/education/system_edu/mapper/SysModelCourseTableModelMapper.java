package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysModelCourseTableModel;
import com.education.system_edu.pojo.SysModelCourseTableModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysModelCourseTableModelMapper {
    long countByExample(SysModelCourseTableModelExample example);

    int deleteByExample(SysModelCourseTableModelExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysModelCourseTableModel record);

    int insertSelective(SysModelCourseTableModel record);

    List<SysModelCourseTableModel> selectByExample(SysModelCourseTableModelExample example);

    SysModelCourseTableModel selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysModelCourseTableModel record, @Param("example") SysModelCourseTableModelExample example);

    int updateByExample(@Param("record") SysModelCourseTableModel record, @Param("example") SysModelCourseTableModelExample example);

    int updateByPrimaryKeySelective(SysModelCourseTableModel record);

    int updateByPrimaryKey(SysModelCourseTableModel record);
}