package com.education.system_edu.service;

import com.education.system_edu.pojo.pojo.Department;
import com.education.system_edu.pojo.pojo.Faculty;
import com.education.system_edu.pojo.pojo.Major;

import java.util.List;

public interface FacultyService {
    List<Faculty> findFaculty(Integer treeLevel);

    List<Department> findDepartment(String code, Integer treeLevel);

    int addDepartment(String parentCode, Department department, String loginCode);

    int deleteDepartment(String departmentCode);

    Department findDepartmentByDepartmentId(String departmentCode);

    int updateDepartment(Department department, String UserCode);

}
