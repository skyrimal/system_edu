package com.education.system_edu.service.impl;


import com.education.system_edu.mapper.GroupMapper;
import com.education.system_edu.mapper.UserMapper;
import com.education.system_edu.pojo.Group;
import com.education.system_edu.pojo.User;
import com.education.system_edu.pojo.output.CourseClassTeamOutput;
import com.education.system_edu.service.CourseClassService;
import com.education.system_edu.utils.ClassUtils;
import com.education.system_edu.utils.UU3D;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月03日 12:24
 */
@Service
public class CourseClassServiceImpl implements CourseClassService {

    @Resource
    UserMapper userMapper;

    @Resource
    GroupMapper groupMapper;

    @Override
    public Integer madeTeam(String courseClassCode, Integer memberNum, String loginCode) {
        List<User> student = userMapper.selectAllByCourseClassCode(courseClassCode);
        Integer stuNum = stuNum(student.size(), memberNum);
        ClassUtils<Group> classUtils = new ClassUtils<>();
        int flag = 0;
        for (int i = 0; i < memberNum; i++) {
            for (int j = i * stuNum; j < (i + 1) * stuNum && j < student.size(); j++) {
                Group group = new Group();
                group.setCode(UU3D.uu3d());
                group.setStudentCode(student.get(j).getCode());
                group.setClassCode(courseClassCode);
                group.setType((short) 1);
                group.setRemarks(i+"");
                group = classUtils.addUserCreateUseInfo(group, loginCode);
                flag+=groupMapper.insert(group);
            }
        }
        return flag;
    }

    @Override
    public List<CourseClassTeamOutput> getCourseClassTeamByCourseClassCode(String courseClassCode) {
        return groupMapper.selectAllCourseClassGroupByCourseClassCode(courseClassCode);
    }

    private Integer stuNum(int x, int y) {
        if (x % y == 0) {
            return x / y;
        }
        return x / y + 1;
    }
}
