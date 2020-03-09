package com.education.system_edu.mapper;

import com.education.system_edu.pojo.ConnectUserAndMajor;
import com.education.system_edu.pojo.ConnectUserAndMajorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConnectUserAndMajorMapper {
    long countByExample(ConnectUserAndMajorExample example);

    int deleteByExample(ConnectUserAndMajorExample example);

    int deleteByPrimaryKey(String code);

    int insert(ConnectUserAndMajor record);

    int insertSelective(ConnectUserAndMajor record);

    List<ConnectUserAndMajor> selectByExample(ConnectUserAndMajorExample example);

    ConnectUserAndMajor selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") ConnectUserAndMajor record, @Param("example") ConnectUserAndMajorExample example);

    int updateByExample(@Param("record") ConnectUserAndMajor record, @Param("example") ConnectUserAndMajorExample example);

    int updateByPrimaryKeySelective(ConnectUserAndMajor record);

    int updateByPrimaryKey(ConnectUserAndMajor record);
}