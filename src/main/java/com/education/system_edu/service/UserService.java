package com.education.system_edu.service;

import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.insert.TeacherSearchStudentInsert;
import com.education.system_edu.pojo.insert.UserInModel;
import com.education.system_edu.pojo.output.CourseClassUserStudentOutPut;
import com.education.system_edu.pojo.output.OutputUserForEditUserAction;
import com.education.system_edu.pojo.pojo_child.result.PageUserOutput;
import com.education.system_edu.pojo.pojo_getData.SearchUserByFaculty;

import java.util.List;

public interface UserService {
    boolean updatePassword(String loginCode, String oldPassword, String newPassword);
    List<PageUserOutput> selectUsersByUser(SearchUserByFaculty searchUserByFaculty, Integer pageSize, Integer pageNum);
    Long getUserPageCount( SearchUserByFaculty searchUserByFaculty,Integer pageSize);

    Integer addUser(UserInModel userInModel, String userLoginCode);

    OutputUserForEditUserAction getOutputUserForEditUserActionBy(String loginCode);

    Integer editUser(UserInModel userInModel, String userLoginCode);

    Integer initPassword(String loginCode);

    List<CourseClassUserStudentOutPut> getUserByCourseCode(String courseClassCode);

    Integer countCourseByCourseSearchInsert(TeacherSearchStudentInsert teacherSearchStudentInsert, Integer pageSize, String courseClassCode);

    List<CourseClassUserStudentOutPut> getUserByTeacherSearchStudentInsert(TeacherSearchStudentInsert teacherSearchStudentInsert,String courseClassCode);
}
