package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysReaderMessage;
import com.education.system_edu.pojo.SysReaderMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysReaderMessageMapper {
    long countByExample(SysReaderMessageExample example);

    int deleteByExample(SysReaderMessageExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysReaderMessage record);

    int insertSelective(SysReaderMessage record);

    List<SysReaderMessage> selectByExample(SysReaderMessageExample example);

    SysReaderMessage selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysReaderMessage record, @Param("example") SysReaderMessageExample example);

    int updateByExample(@Param("record") SysReaderMessage record, @Param("example") SysReaderMessageExample example);

    int updateByPrimaryKeySelective(SysReaderMessage record);

    int updateByPrimaryKey(SysReaderMessage record);
}