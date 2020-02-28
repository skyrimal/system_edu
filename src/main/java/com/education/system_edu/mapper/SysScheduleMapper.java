package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysSchedule;
import com.education.system_edu.pojo.SysScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysScheduleMapper {
    long countByExample(SysScheduleExample example);

    int deleteByExample(SysScheduleExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysSchedule record);

    int insertSelective(SysSchedule record);

    List<SysSchedule> selectByExample(SysScheduleExample example);

    SysSchedule selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysSchedule record, @Param("example") SysScheduleExample example);

    int updateByExample(@Param("record") SysSchedule record, @Param("example") SysScheduleExample example);

    int updateByPrimaryKeySelective(SysSchedule record);

    int updateByPrimaryKey(SysSchedule record);
}