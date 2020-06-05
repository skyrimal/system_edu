package com.education.system_edu.mapper;

import com.education.system_edu.pojo.charts.Chart;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChartsMapper {

    @Select("SELECT\n" +
            "charts.`no`,\n" +
            "charts.x,\n" +
            "charts.`key`\n" +
            "FROM\n" +
            "charts\n" +
            "WHERE\n" +
            "charts.`key` = 'pie'")
    List<Chart> selectPieData();

    @Select("SELECT\n" +
            "charts.`no`,\n" +
            "charts.x,\n" +
            "charts.`key`,\n" +
            "charts.y\n" +
            "FROM\n" +
            "charts\n" +
            "WHERE\n" +
            "charts.`key` = 'line'\n")
    List<Chart> selectLineData();

    @Select("SELECT\n" +
            "charts.`no`,\n" +
            "charts.x,\n" +
            "charts.`key`,\n" +
            "charts.y\n" +
            "FROM\n" +
            "charts\n" +
            "WHERE\n" +
            "charts.`key` = 'line2'\n")
    List<Chart> selectLine2Data();
}
