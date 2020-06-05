package com.education.system_edu.mapper;

import com.education.system_edu.pojo.SysDataTree;
import com.education.system_edu.pojo.SysDataTreeExample;

import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysDataTreeMapper {
    long countByExample(SysDataTreeExample example);

    int deleteByExample(SysDataTreeExample example);

    int deleteByPrimaryKey(String code);

    int insert(SysDataTree record);

    int insertSelective(SysDataTree record);

    List<SysDataTree> selectByExample(SysDataTreeExample example);

    SysDataTree selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") SysDataTree record, @Param("example") SysDataTreeExample example);

    int updateByExample(@Param("record") SysDataTree record, @Param("example") SysDataTreeExample example);

    int updateByPrimaryKeySelective(SysDataTree record);

    int updateByPrimaryKey(SysDataTree record);

    @Select("SELECT\n" +
            "sys_data_tree.`code`,\n" +
            "sys_data_tree.ref_code,\n" +
            "sys_data_tree.`name`,\n" +
            "sys_data_tree.type,\n" +
            "sys_data_tree.permission,\n" +
            "sys_data_tree.is_show,\n" +
            "sys_data_tree.parent_node,\n" +
            "sys_data_tree.parent_nodes,\n" +
            "sys_data_tree.tree_level,\n" +
            "sys_data_tree.is_leaf,\n" +
            "sys_data_tree.ui,\n" +
            "sys_data_tree.color,\n" +
            "sys_data_tree.icon,\n" +
            "sys_data_tree.remarks,\n" +
            "sys_data_tree.create_by,\n" +
            "sys_data_tree.create_date,\n" +
            "sys_data_tree.update_by,\n" +
            "sys_data_tree.update_date\n" +
            "FROM\n" +
            "sys_data_tree\n" +
            "WHERE\n" +
            "sys_data_tree.`name` LIKE '%${keyword}%'\n")
    List<SysDataTree> selectByKey(String keyword);

@Select("SELECT\n" +
        "sys_data_tree.`code`,\n" +
        "sys_data_tree.ref_code,\n" +
        "sys_data_tree.`name`,\n" +
        "sys_data_tree.type,\n" +
        "sys_data_tree.permission,\n" +
        "sys_data_tree.is_show,\n" +
        "sys_data_tree.parent_node,\n" +
        "sys_data_tree.parent_nodes,\n" +
        "sys_data_tree.tree_level,\n" +
        "sys_data_tree.is_leaf,\n" +
        "sys_data_tree.ui,\n" +
        "sys_data_tree.color,\n" +
        "sys_data_tree.icon,\n" +
        "sys_data_tree.remarks,\n" +
        "sys_data_tree.create_by,\n" +
        "sys_data_tree.create_date,\n" +
        "sys_data_tree.update_by,\n" +
        "sys_data_tree.update_date\n" +
        "FROM\n" +
        "sys_data_tree\n" +
        "WHERE\n" +
        "sys_data_tree.parent_node = '${code}'\n")
    List<SysDataTree> selectByParentCode(String code);
}