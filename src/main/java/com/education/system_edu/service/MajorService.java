package com.education.system_edu.service;

import com.education.system_edu.pojo.insert.ClassAddInsert;
import com.education.system_edu.pojo.insert.ClassInsert;
import com.education.system_edu.pojo.insert.ClassSearchInsert;
import com.education.system_edu.pojo.output.ClassSearchOutput;
import com.education.system_edu.pojo.output.OutputClass;
import com.education.system_edu.pojo.output.OutputMajor;
import com.education.system_edu.pojo.pojo.Major;

import java.util.List;

public interface MajorService {
    int addMajor(Major major, String loginCode);
    List<Major> findMajorByMajor(Major major, String keyword, String faculty);

    Major findMajorByMajorByMajorCode(String majorCode);

    Integer updateMajor(Major major,String userCode);

    List<OutputMajor> findMajorByDepartmentCode(String departmentCode);

    List<OutputClass> findClassByMajorCodeAndGrade(String major, String grade);

    List<ClassSearchOutput> addClass(ClassInsert classInsert, String loginCode);

    List<ClassSearchOutput> searchClassByClassInsert(ClassSearchInsert classSearchInsert);

    Integer countPageByPageSizeAndClassSearchInsert(ClassSearchInsert classSearchInsert,Integer pageSize);
}
