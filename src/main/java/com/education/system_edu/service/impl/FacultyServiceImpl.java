package com.education.system_edu.service.impl;


import com.education.system_edu.mapper.ConnectUserAndDepartmentMapper;
import com.education.system_edu.mapper.SysDataTreeMapper;
import com.education.system_edu.mapper.SysNodeMapper;
import com.education.system_edu.pojo.*;
import com.education.system_edu.pojo.pojo.Department;
import com.education.system_edu.pojo.pojo.Faculty;
import com.education.system_edu.service.FacultyService;
import com.education.system_edu.utils.*;
import com.education.system_edu.utils.value.Entry;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Resource
    SysDataTreeMapper sysDataTreeMapper;
    @Resource
    SysNodeMapper sysNodeMapper;
    @Resource
    ConnectUserAndDepartmentMapper connectUserAndDepartmentMapper;

    /**
     * 查找学院
     *
     * @param treeLevel
     * @return
     */
    @Override
    public List<Faculty> findFaculty(Integer treeLevel) {
        return facultiesAdd(treeLevel);
    }

    /**
     * 查找部门
     *
     * @param code
     * @param treeLevel
     * @return
     */
    @Override
    public List<Department> findDepartment(String code, Integer treeLevel) {
        return departmentsAdd(code, treeLevel);
    }

    /**
     * 添加部门
     *
     * @param parentCode
     * @param department
     * @param loginCode
     * @return
     */
    @Override
    public int addDepartment(String parentCode, Department department, String loginCode) {
        SysTreeAndNodeUtils sysTreeAndNodeUtils = new SysTreeAndNodeUtils();
        sysTreeAndNodeUtils.initSysTreeAndNodeUtils(loginCode);

        SysDataTree sysDataTree = new SysDataTree();
        sysDataTree.setCode(UU3D.uu3d());
        sysDataTree.setName(department.getDepartmentName());
        sysDataTree.setParentNode(parentCode);
        sysDataTree.setType(Entry.FACULTY);
        sysDataTree.setIsShow("1");
        sysDataTree.setIsLeaf("0");
        sysDataTree.setParentNodes(parentCode);
        sysDataTree.setTreeLevel(2);
        sysDataTree.setRemarks(department.getRemarks());
        sysDataTree = (SysDataTree) sysTreeAndNodeUtils.createAndUpdateMessage(sysDataTree);


        SysNode sysNodeCode = new SysNode();
        sysNodeCode.setCode(UU3D.uu3d());
        sysNodeCode.setName("manage_login_code");
        sysNodeCode.setType(Entry.FACULTY);
        sysNodeCode.setRoleTreeNodeCode(sysDataTree.getCode());
        sysNodeCode.setRemarks(department.getManagerCode());
        sysNodeCode = (SysNode) sysTreeAndNodeUtils.createAndUpdateMessage(sysNodeCode);


        SysNode sysNodeName = new SysNode();
        sysNodeName.setCode(UU3D.uu3d());
        sysNodeName.setName("manage_name");
        sysNodeName.setType(Entry.FACULTY);
        sysNodeName.setRoleTreeNodeCode(sysDataTree.getCode());
        sysNodeName.setRemarks(department.getManagerName());
        sysNodeName = (SysNode) sysTreeAndNodeUtils.createAndUpdateMessage(sysNodeName);


        return sysDataTreeMapper.insert(sysDataTree)
                + sysNodeMapper.insert(sysNodeCode)
                + sysNodeMapper.insert(sysNodeName);
    }


    /**
     * 删除部门
     *
     * @param departmentCode
     * @return
     */
    @Override
    public int deleteDepartment(String departmentCode) {
        SysNodeExample sysForSearch = SysTreeAndNodeUtils.madeSysNodeExample(departmentCode);

        SysDataTreeExample sysDataTreeExample = SysTreeAndNodeUtils.madeSysDataTreeExample(departmentCode);

        ConnectUserAndDepartmentExample connectUserAndDepartmentExample = new ConnectUserAndDepartmentExample();
        connectUserAndDepartmentExample.createCriteria().andSysNodeCodeEqualTo(departmentCode);

        return sysNodeMapper.deleteByExample(sysForSearch) + sysDataTreeMapper.deleteByExample(sysDataTreeExample) + connectUserAndDepartmentMapper.deleteByExample(connectUserAndDepartmentExample);

    }

    /**
     * 通过id查看部门
     *
     * @param departmentCode
     * @return
     */
    @Override
    public Department findDepartmentByDepartmentId(String departmentCode) {
        SysDataTree sysDataTree = sysDataTreeMapper.selectByExample(SysTreeAndNodeUtils.madeSysDataTreeExample(departmentCode)).get(0);
        List<SysNode> sysNodes = sysNodeMapper.selectByExample(SysTreeAndNodeUtils.madeSysNodeExample(departmentCode));
        return FacultyFactory.builderDepartment(sysDataTree, sysNodes);
    }

    /**
     * 修改部门信息
     *
     * @param department
     * @return
     */

    @Override
    public int updateDepartment(Department department, String userCode) {
        SysTreeAndNodeUtils sysTreeAndNodeUtils = new SysTreeAndNodeUtils();
        sysTreeAndNodeUtils.initSysTreeAndNodeUtils(userCode);
        //修改部门信息
        int flag = 0;
        SysDataTreeExample sysDataTreeExample = SysTreeAndNodeUtils.madeSysDataTreeExample(department.getCode());
        SysDataTree sysDataTree = sysDataTreeMapper.selectByExample(sysDataTreeExample).get(0);
        sysDataTree.setName(department.getDepartmentName());
        sysDataTree.setRemarks(department.getRemarks());
        sysDataTree = (SysDataTree) sysTreeAndNodeUtils.updateMessage(sysDataTree);
        flag += sysDataTreeMapper.updateByPrimaryKeySelective(sysDataTree);
        //修改部门关联信息
        SysNodeExample sysNodeExample = SysTreeAndNodeUtils.madeSysNodeExample(department.getCode());
        List<SysNode> sysNodes = sysNodeMapper.selectByExample(sysNodeExample);
        for (SysNode sysNode : sysNodes) {
            if (sysNode.getName().equals(Entry.MANAGER_NAME)) {
                sysNode.setRemarks(department.getManagerName());

            }
            if (sysNode.getName().equals(Entry.MANAGER_LOGIN_CODE)) {
                sysNode.setRemarks(department.getManagerCode());
            }
            sysNode = (SysNode) sysTreeAndNodeUtils.updateMessage(sysNode);
            flag += sysNodeMapper.updateByPrimaryKeySelective(sysNode);
        }
        return flag;
    }





    /****************************************************获取系下部门*********************************************/
    /**
     * 通过父节点id和树的深度获取数据树节点
     *
     * @param code
     * @param treeLevel
     * @return
     */
    private List<SysDataTree> getSysDataTreesWithParentCode(String code, Integer treeLevel) {
        SysDataTreeExample sysDataTreeForSearch = new SysDataTreeExample();
        sysDataTreeForSearch.createCriteria().andTypeEqualTo((short) 3).andTreeLevelEqualTo(treeLevel).andParentNodeEqualTo(code);
        return sysDataTreeMapper.selectByExample(sysDataTreeForSearch);
    }

    /**
     * 通过数据数节点id和树的深度获取部门
     *
     * @param code
     * @param treeLevel
     * @return
     */
    private List<Department> departmentsAdd(String code, Integer treeLevel) {
        List<Department> departments = new ArrayList<>();
        for (SysDataTree sysDataTree : getSysDataTreesWithParentCode(code, treeLevel)) {
            SysNodeExample sysNodeForSearch = new SysNodeExample();
            sysNodeForSearch.createCriteria().andRoleTreeNodeCodeEqualTo(sysDataTree.getCode());
            List<SysNode> sysNodes = sysNodeMapper.selectByExample(sysNodeForSearch);
            departments.add(FacultyFactory.builderDepartment(sysDataTree, sysNodes));
        }
        return departments;
    }
    /****************************************************获取所有院系*********************************************/
    /**
     * 通过深度获取所有院系部门节点
     *
     * @param treeLevel
     * @return
     */
    private List<SysDataTree> getSysDataTrees(Integer treeLevel) {
        SysDataTreeExample sysDataTreeForSearch = new SysDataTreeExample();
        sysDataTreeForSearch.createCriteria().andTypeEqualTo((short) 3).andTreeLevelEqualTo(treeLevel);
        return sysDataTreeMapper.selectByExample(sysDataTreeForSearch);
    }

    /**
     * 通过深度获取学院信息
     *
     * @param treeLevel
     * @return
     */
    private List<Faculty> facultiesAdd(Integer treeLevel) {
        List<Faculty> faculties = new ArrayList<>();
        for (SysDataTree sysDataTree :
                getSysDataTrees(treeLevel)) {
            SysNodeExample sysNodeForSearch = new SysNodeExample();
            sysNodeForSearch.createCriteria().andRoleTreeNodeCodeEqualTo(sysDataTree.getCode());
            List<SysNode> sysNodes = sysNodeMapper.selectByExample(sysNodeForSearch);
            faculties.add(FacultyFactory.builderFactory(sysDataTree, sysNodes));
        }
        return faculties;
    }



}
