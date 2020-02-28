package com.education.system_edu.service.impl;

import com.education.system_edu.mapper.ConnectUserAndDepartmentMapper;
import com.education.system_edu.mapper.SysDataTreeMapper;
import com.education.system_edu.mapper.SysNodeMapper;
import com.education.system_edu.mapper.UserMapper;
import com.education.system_edu.pojo.*;
import com.education.system_edu.pojo.pojo.Major;
import com.education.system_edu.service.MajorService;
import com.education.system_edu.utils.*;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MajorServiceImpl implements MajorService {
    @Resource
    SysDataTreeMapper sysDataTreeMapper;
    @Resource
    SysNodeMapper sysNodeMapper;
    @Resource
    ConnectUserAndDepartmentMapper connectUserAndDepartmentMapper;

    @Resource
    UserMapper userMapper;

    /**
     * 添加专业
     *
     * @param major
     * @param loginCode
     * @return
     */
    @Override
    public int addMajor(Major major, String loginCode) {
        SysTreeAndNodeUtils sysTreeAndNodeUtils = new SysTreeAndNodeUtils();
        sysTreeAndNodeUtils.initSysTreeAndNodeUtils(loginCode);

        SysDataTree sysDataTree = new SysDataTree();
        sysDataTree.setCode(UU3D.uu3d());
        sysDataTree.setName(major.getMajorName());
        sysDataTree.setType(Entry.MAJOR);
        sysDataTree.setIsShow("1");
        sysDataTree.setIsLeaf("0");
        sysDataTree.setParentNode(major.getDepartmentCode());
        sysDataTree.setParentNodes(major.getDepartmentCode());
        sysDataTree.setTreeLevel(3);

        sysDataTree = (SysDataTree) sysTreeAndNodeUtils.createAndUpdateMessage(sysDataTree);

        SysNode manageCode = new SysNode();
        manageCode.setCode(UU3D.uu3d());
        manageCode.setName("manage_login_code");
        manageCode.setType(Entry.MAJOR);
        manageCode.setRoleTreeNodeCode(sysDataTree.getCode());
        manageCode.setRemarks(major.getTeacherCode());
        manageCode = (SysNode) sysTreeAndNodeUtils.createAndUpdateMessage(manageCode);


        SysNode manageName = new SysNode();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginCodeEqualTo(loginCode);

        manageName.setCode(UU3D.uu3d());
        manageName.setName("manage_name");
        manageName.setType(Entry.MAJOR);
        manageName.setRoleTreeNodeCode(sysDataTree.getCode());
        manageName.setRemarks(userMapper.selectByExample(userExample).get(0).getUserName());
        manageName = (SysNode) sysTreeAndNodeUtils.createAndUpdateMessage(manageName);

        return sysDataTreeMapper.insert(sysDataTree)
                + sysNodeMapper.insert(manageCode)
                + sysNodeMapper.insert(manageName);
    }


    /**
     * 查找专业
     *
     * @param major
     * @param keyword
     * @param faculty
     * @return
     */
    @Override
    public List<Major> findMajorByMajor(Major major, String keyword, String faculty) {
        ListUtils listUtils = new ListUtils();
        List<Major> majors = new ArrayList<>();

        SysDataTreeExample sysDataTreeExample = new SysDataTreeExample();

        List<SysDataTree> sysDataTrees = new ArrayList<>();
        //由keyword转换
        String majorName = "";
        String facultyName = "";
        String departmentName = "";

        if (!StringUtil.isEmpty(keyword)) {
            if (!StringUtils.isInteger(keyword)) {
                majorName = keyword;
                facultyName = keyword;
                departmentName = keyword;

                SysDataTreeExample majorNameExample = new SysDataTreeExample();
                majorNameExample.createCriteria().andNameLike(majorName).andTreeLevelEqualTo(3);
                SysDataTreeExample facultyNameExample = new SysDataTreeExample();
                facultyNameExample.createCriteria().andNameLike(facultyName).andTreeLevelEqualTo(1);
                SysDataTreeExample departmentNameExample = new SysDataTreeExample();
                departmentNameExample.createCriteria().andNameLike(departmentName).andTreeLevelEqualTo(2);
                sysDataTrees.addAll(sysDataTreeMapper.selectByExample(majorNameExample));
                sysDataTrees.addAll(sysDataTreeMapper.selectByExample(facultyNameExample));
                sysDataTrees.addAll(sysDataTreeMapper.selectByExample(departmentNameExample));
            }
        }
        if (!StringUtil.isEmpty(faculty)) {
            SysDataTreeExample sysDataTreeFacultyExample = new SysDataTreeExample();
            sysDataTreeFacultyExample.createCriteria().andCodeEqualTo(faculty);
            List<SysDataTree> facultySysDataTrees = sysDataTreeMapper.selectByExample(sysDataTreeFacultyExample);

            List<SysDataTree> departmentSysDataTrees = getListDateTrees(facultySysDataTrees);
            List<SysDataTree> majorTrees = getListDateTrees(departmentSysDataTrees);
            sysDataTrees.addAll(majorTrees);
        }

        if (major != null) {
            if (!StringUtil.isEmpty(major.getDepartmentCode())) {
                SysDataTreeExample sysDataTreeFacultyExample = new SysDataTreeExample();
                sysDataTreeFacultyExample.createCriteria().andCodeEqualTo(major.getDepartmentCode());
                List<SysDataTree> departmentSysDataTrees = sysDataTreeMapper.selectByExample(sysDataTreeFacultyExample);

                List<SysDataTree> majorTrees = getListDateTrees(departmentSysDataTrees);
                sysDataTrees.addAll(majorTrees);
            }
        }


        List<SysDataTree> newList;

        Map<String, SysDataTree> sysDataTreeMap = new HashMap<>();
        for (SysDataTree sysDataTree : sysDataTrees) {
            sysDataTreeMap.put(sysDataTree.getCode(), sysDataTree);
        }

        newList = listUtils.mapToList(sysDataTreeMap);

        if (newList.size() == 0) {
            SysDataTreeExample example = new SysDataTreeExample();
            example.createCriteria().andTreeLevelEqualTo(3);
            newList = sysDataTreeMapper.selectByExample(example);
        }
        for (SysDataTree sysDataTree : newList) {
            SysNodeExample sysNodeExample = new SysNodeExample();
            sysDataTreeExample.createCriteria().andParentNodeEqualTo(sysDataTree.getCode());
            majors.add(FacultyFactory.sysDateTreeToMajor(sysDataTree, sysNodeMapper.selectByExample(sysNodeExample)));
        }

        return majors;
    }

    /**
     * 查找一个专业
     *
     * @param majorCode
     * @return
     */
    @Override
    public Major findMajorByMajorByMajorCode(String majorCode) {
        SysDataTree sysDataTree = sysDataTreeMapper.selectByPrimaryKey(majorCode);
        SysNodeExample sysNodeExample = new SysNodeExample();
        sysNodeExample.createCriteria().andRoleTreeNodeCodeEqualTo(sysDataTree.getCode());
        List<SysNode> sysNodes = sysNodeMapper.selectByExample(sysNodeExample);
        return FacultyFactory.sysDateTreeToMajor(sysDataTree, sysNodes);
    }

    /**
     * 修改专业
     *
     * @param major
     * @return
     */
    @Override
    public Integer updateMajor(Major major, String userCode) {
        SysTreeAndNodeUtils sysTreeAndNodeUtils = new SysTreeAndNodeUtils();
        sysTreeAndNodeUtils.initSysTreeAndNodeUtils(userCode);
        //修改部门信息
        int flag = 0;
        SysDataTreeExample sysDataTreeExample = new SysDataTreeExample();
        sysDataTreeExample.createCriteria().andTreeLevelEqualTo(3).andParentNodeEqualTo(major.getDepartmentCode());
        SysDataTree sysDataTree = sysDataTreeMapper.selectByExample(sysDataTreeExample).get(0);
        sysDataTree.setName(major.getMajorName());
        sysDataTree.setCode(major.getCode());
        sysDataTree = (SysDataTree) sysTreeAndNodeUtils.updateMessage(sysDataTree);
        flag += sysDataTreeMapper.updateByPrimaryKeySelective(sysDataTree);

        //修改部门关联信息
        SysNodeExample sysNodeExample = SysTreeAndNodeUtils.madeSysNodeExample(major.getCode());
        List<SysNode> sysNodes = sysNodeMapper.selectByExample(sysNodeExample);
        for (SysNode sysNode : sysNodes) {
            if (sysNode.getName().equals(Entry.MANAGER_NAME)) {
                sysNode.setRemarks(major.getTeacherName());

            }
            if (sysNode.getName().equals(Entry.MANAGER_LOGIN_CODE)) {
                sysNode.setRemarks(major.getTeacherCode());
            }
            sysNode = (SysNode) sysTreeAndNodeUtils.updateMessage(sysNode);
            flag += sysNodeMapper.updateByPrimaryKeySelective(sysNode);
        }
        return flag;
    }


    private List<SysDataTree> getListDateTrees(List<SysDataTree> sysDataTrees) {
        SysDataTreeExample sysDataTreeDepartmentExample = new SysDataTreeExample();
        SysDataTreeExample.Criteria criteria = sysDataTreeDepartmentExample.createCriteria();
        criteria.andParentNodeEqualTo(sysDataTrees.get(0).getCode());
        if (sysDataTrees.size() != 1) {
            for (int i = 1; i < sysDataTrees.size(); i++) {
                SysDataTreeExample.Criteria criteria_ = sysDataTreeDepartmentExample.createCriteria();
                criteria.andParentNodeEqualTo(sysDataTrees.get(i).getCode());
                sysDataTreeDepartmentExample.or(criteria_);
            }
        }
        return sysDataTreeMapper.selectByExample(sysDataTreeDepartmentExample);
    }
}