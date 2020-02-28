package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysMessage;
import com.education.system_edu.pojo.SysMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMessageMapper {
    long countByExample(SysMessageExample example);

    int deleteByExample(SysMessageExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysMessage record);

    int insertSelective(SysMessage record);

    List<SysMessage> selectByExample(SysMessageExample example);

    SysMessage selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysMessage record, @Param("example") SysMessageExample example);

    int updateByExample(@Param("record") SysMessage record, @Param("example") SysMessageExample example);

    int updateByPrimaryKeySelective(SysMessage record);

    int updateByPrimaryKey(SysMessage record);
}