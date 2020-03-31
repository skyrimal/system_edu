package com.education.system_edu.service;

import com.education.system_edu.pojo.insert.*;
import com.education.system_edu.pojo.output.*;
import com.education.system_edu.pojo.pojo.Major;

import java.util.List;

public interface MajorService {
    Integer addMajor(Major major, String loginCode);

    List<Major> findMajorByMajor(Major major, String keyword, String faculty);

    Major findMajorByMajorByMajorCode(String majorCode);

    Integer updateMajor(Major major, String userCode);

    List<OutputMajor> findMajorByDepartmentCode(String departmentCode);

    List<OutputClass> findClassByMajorCodeAndGrade(String major, String grade);

    List<ClassSearchOutput> addClass(ClassInsert classInsert, String loginCode);

    List<ClassSearchOutput> searchClassByClassInsert(ClassSearchInsert classSearchInsert);

    Integer countPageByPageSizeAndClassSearchInsert(ClassSearchInsert classSearchInsert, Integer pageSize);

    Integer countCourseByCourseSearchInsert(CourseSearchInsert courseSearchInsert, Integer pageSize);

    Integer addCourse(CourseAddInsert courseAddInsert, String loginCode);

    List<CourseSearchOutput> searchCourseByCourseSearchInsert(CourseSearchInsert courseSearchInsert);

    List<CourseOutput> getAllCourse();

    List<CourseOutput> chooseAllCourse(String faculty, String department, String major);

    int addCourseClass(AddCourseClassInsert courseAddInsert);
}
