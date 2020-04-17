package com.education.system_edu;

import java.util.*;

import com.education.system_edu.mapper.*;
import com.education.system_edu.pojo.*;
import com.education.system_edu.pojo.insert.*;
import com.education.system_edu.pojo.output.ClassSearchOutput;
import com.education.system_edu.pojo.output.CourseSearchOutput;
import com.education.system_edu.pojo.pojo_child.parameter.PageUser;
import com.education.system_edu.pojo.pojo_child.result.PageUserOutput;
import com.education.system_edu.service.UserService;
import com.education.system_edu.utils.*;
import com.education.system_edu.utils.value.UserValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SystemEduApplicationTests {

    @Resource
    SysDataTreeMapper sysDataTreeMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    SysModelClassMapper sysModelClassMapper;

    @Resource
    SysModelCourseMapper sysModelCourseMapper;

    @Resource
    ConnectUserAndRoleMapper connectUserAndRoleMapper;
    @Resource
    ConnectUserAndMajorMapper connectUserAndMajorMapper;
    @Resource
    ConnectUserStudentAndClassMapper connectUserStudentAndClassMapper;
    @Resource
    ConnectTeacherCourseMapper connectTeacherCourseMapper;


    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    void contextLoads() {
        PageUser pageUser = new PageUser();
        pageUser.setPageNum(1);
        pageUser.setPageSize(10);
        pageUser.setFaculty("2");
        List<PageUserOutput> users = userMapper.selectSelectedByUser(pageUser);
        System.out.println("users的大小" + users.size());
        for (PageUserOutput user : users) {
            System.out.println(user.getUser().getLoginCode());
            System.out.println(user.getUser().getUserName());
            System.out.println(user.getClassCode());
            System.out.println(user.getMajor());
        }
    }

    @Test
    void userPage() {
        System.out.println(UUID.randomUUID().toString());
    }

    @Test
    void testAddOneUser() {
        UserInModel userInModel = new UserInModel();
        userInModel.setUserName("又是比");
        userInModel.setUserType("1");
        userInModel.setGrade(20 + "");
        userInModel.setClassNo("2");
        userInModel.setMajor("20841d007c844ed0840f2bdcb07a6d8c");
        userService.addUser(userInModel, "2000000");
    }

    @Test
    void searchClass() {
        ClassSearchInsert classSearchInsert = new ClassSearchInsert();
        classSearchInsert.setFacultyName("智能科技学院");
        List<ClassSearchOutput> classSearchOutputs = sysModelClassMapper.selectByClassSearchInsert(classSearchInsert);
        for (ClassSearchOutput classSearchOutput : classSearchOutputs) {
            System.out.println(classSearchOutput.getDepartmentName());
        }
    }

    @Test
    void searchCourseSearchOutput() {
        CourseSearchInsert courseSearchInsert = new CourseSearchInsert();
        courseSearchInsert.init();
        List<CourseSearchOutput> courseSearchOutputs = sysModelCourseMapper.selectCourseSearchOutputBycourseSearchInsert(courseSearchInsert);
        for (CourseSearchOutput courseSearchOutput : courseSearchOutputs) {
            System.out.println(courseSearchOutput.getName());
        }
    }


    @Test
    void insertTestData() {
        //1.创建老师
        List<User> teachers = new ArrayList<>();
        List<String> teachersLoginCodes = new ArrayList<>();
        List<String> teachersCodes = new ArrayList<>();
        ClassInsert classMsg = new ClassInsert();
        classMsg.setGrade("X41");
        classMsg.setClassClassCode("");
        User teacher;
        //创建老师和老师带的班级
        for (int i = 0; i < 100; i++) {
            //创建老师
            teacher = madeUser(classMsg,
                               i,
                               1 + "",
                               0 + "");
            teachers.add(teacher);
            teachersLoginCodes.add(teacher.getLoginCode());
            teachersCodes.add(teacher.getCode());
        }

        //2.给每个老师创建一个行政班级
        List<SysModelClass> classes = new ArrayList<>();
        List<String> classesNo = new ArrayList<>();
        List<String> classesCodes = new ArrayList<>();
        SysModelClass modelClass;
        List<SysDataTree> sysModelClas = addSm();
        for (int i = 0; i < 100; i++) {
            int randomNumber2 = RandomUtils.randomNumber(0, sysModelClas.size() - 1);
            //创建班级
            modelClass = modelClass(20 + "",
                                    (short) 2,
                                    teachersCodes.get(i),
                                    teachersLoginCodes.get(i),
                                    "001",
                                    "001",
                                    sysModelClas.get(randomNumber2).getCode(),
                                    sysModelClas.get(randomNumber2).getType(),
                                    "",
                                    1,
                                    1);
            classesNo.add(modelClass.getClassCode());
            classesCodes.add(modelClass.getCode());
            classes.add(modelClass);
        }


        //3.给每个老师创建3-10个课程班级
        List<SysModelClass> coursesClasses = new ArrayList<>();
        List<String> courseClassNo = new ArrayList<>();
        List<String> courseClassCodes = new ArrayList<>();
        SysModelClass modelCourseClass;
        for (int i = 0; i < 100; i++) {
            int randomNumber = RandomUtils.randomNumber(3, 10);
            for (int j = 0; j < randomNumber; j++) {
                //获取课程
                List<SysModelCourse> allCourses = madeCourse();
                int randomNumber2 = RandomUtils.randomNumber(0, allCourses.size() - 1);
                // 创建班级
                modelCourseClass = modelClass(20 + "",
                                              (short) 1,
                                              teachersCodes.get(i),
                                              teachersLoginCodes.get(i),
                                              allCourses.get(randomNumber2).getCourseCode(),
                                              allCourses.get(randomNumber2).getCode(),
                                              allCourses.get(randomNumber2).getSysNodeCode(),
                                              allCourses.get(randomNumber2).getSysNodeType(),
                                              "",
                                              1,
                                              1);
                courseClassNo.add(modelCourseClass.getClassCode());
                courseClassCodes.add(modelCourseClass.getCode());
                coursesClasses.add(modelCourseClass);

            }
        }

        //给行政班级添加学生
        List<User> student = new ArrayList<>();
        List<ConnectUserAndMajor> connectUserAndMajors = new ArrayList<>();
        List<ConnectUserStudentAndClass> connectUserStudentAndClasses = new ArrayList<>();
        int f = 0;
        for (SysModelClass aClass : classes) {
            ClassInsert aClassInfo = new ClassInsert();
            aClassInfo.setClassClassCode(aClass.getClassCode());
            aClassInfo.setGrade(aClass.getGrade());

            for (int i = 0; i < 50; i++) {
                User user = madeUser(aClassInfo, i, "2", "0");
                user.setLoginCode(StringUtils.addZeroForNum((f++) + "", 3) + user.getLoginCode());
                ConnectUserAndMajor connect2 = new ConnectUserAndMajor();
                connect2.setCode(UU3D.uu3d() + i);
                connect2.setUseCode(user.getCode());
                connect2.setSysNodeCode(aClass.getSysCollegeNodeCode());
                connect2.setSysNodeType(aClass.getSysCollegeNodeType());
                student.add(user);
                ConnectUserStudentAndClass connectUserStudentAndClass = new ConnectUserStudentAndClass();
                connectUserStudentAndClass.setCode(UU3D.uu3d());
                connectUserStudentAndClass.setClassCode(aClass.getCode());
                connectUserStudentAndClass.setStudentNo(user.getLoginCode());
                connectUserStudentAndClass.setStudentCode(user.getCode());
                connectUserStudentAndClasses.add(connectUserStudentAndClass);
                connectUserAndMajors.add(connect2);
            }
        }


        //
        //插入数据库
        //1.老师
        for (User user : teachers) {
            userMapper.insert(user);
            ConnectUserAndRole connect = new ConnectUserAndRole();
            connect.setCode(UU3D.uu3d());
            connect.setUseCode(user.getCode());
            connect.setSysRoleNodeCode("3");
            connect.setSysRoleNodeType((short) 1);
            connectUserAndRoleMapper.insert(connect);
        }
        //2.行政班级
        for (SysModelClass aClass : classes) {
            sysModelClassMapper.insert(aClass);
        }
        //3.课程班级
        for (SysModelClass courseClass : coursesClasses) {
            sysModelClassMapper.insert(courseClass);
        }
        //4.插入学生
        for (User user : student) {
            userMapper.insert(user);

            ConnectUserAndRole connect = new ConnectUserAndRole();
            connect.setCode(UU3D.uu3d());
            connect.setUseCode(user.getCode());
            connect.setSysRoleNodeCode("2");
            connect.setSysRoleNodeType((short) 1);
            connectUserAndRoleMapper.insert(connect);
        }
        //5.插入学生专业关联
        for (ConnectUserAndMajor connect2 : connectUserAndMajors) {
            connectUserAndMajorMapper.insert(connect2);
        }
        for (ConnectUserStudentAndClass con : connectUserStudentAndClasses) {
            connectUserStudentAndClassMapper.insert(con);

        }
    }


    //给学生添加院系
    private List<SysDataTree> addSm() {
        List<SysDataTree> sysDataTreelist = new ArrayList();
        SysDataTreeExample sysDataTreeExample = new SysDataTreeExample();
        sysDataTreeExample.createCriteria().andTypeEqualTo((short) 7);
        sysDataTreelist = sysDataTreeMapper.selectByExample(sysDataTreeExample);
        return sysDataTreelist;
    }

    //获取所有课程
    private List<SysModelCourse> madeCourse() {
        return sysModelCourseMapper.selectByExample(new SysModelCourseExample());
    }


    private SysModelClass modelClass(String grade, Short type,
                                     String teacherCode,
                                     String teacherLoginCode,
                                     String courseCodeNo,
                                     String courseCode,
                                     String parentCode,
                                     short parentType,
                                     String assistantCode,
                                     Integer studentNum, int i) {
        ClassUtils<SysModelClass> classUtils = new ClassUtils<>();
        SysModelClass sysModelClass = new SysModelClass();
        sysModelClass.setCode(UU3D.uu3d());
        sysModelClass.setClassCode(grade + RandomUtils.getRandomClassNo() + StringUtils.lengthControl(i + "", 3));
        sysModelClass.setType(type);
        sysModelClass.setTeacherType(type);
        sysModelClass.setTeacherCode(teacherCode);
        sysModelClass.setTeacherLoginCode(teacherLoginCode);
        sysModelClass.setCourseCodeNo(courseCodeNo);
        sysModelClass.setCourseCode(courseCode);
        sysModelClass.setGrade(grade);
        sysModelClass.setSysCollegeNodeCode(parentCode);
        sysModelClass.setSysCollegeNodeType(parentType);
        sysModelClass.setAssistant(assistantCode);
        sysModelClass.setStudentNo("");
        sysModelClass.setStudentNum(studentNum);
        sysModelClass = classUtils.addUserCreateUseInfo(sysModelClass, "");
        return sysModelClass;
    }


    private User madeUser(ClassInsert classMsg,
                          int studentNo,
                          String type,
                          String mgrType) {
        ClassUtils<User> classUtils = new ClassUtils<>();

        User user = new User();
        user.setCode(UU3D.uu3d());

        //用户登录账号为前驱+年级+班级+（总人数+1）
        //有bug，loginCode中classNo，studentNo位数可能错乱
        //添加长度控制方法
        //user.setLoginCode();
        user.setLoginCode(UserValue.PREFIX_CLASS_NO + classMsg.getGrade()
                                  + StringUtils.lengthControl(classMsg.getClassClassCode(), 4)
                                  + StringUtils.lengthControl(studentNo + "", 3));
        user.setUserName(RandomUtils.getRandomChineseName());
        user.setPassword(EncryptionUtils.encryption("MD5", "123456", user.getCode()).toString());
        user.setUserType(type);
        user.setMgrType(mgrType);
        user.setStatus("0");
        user = classUtils.addUserCreateUseInfo(user, "");
        return user;
    }

    @Test
    void addTeacherCouseClass() {
        List<SysModelCourse> courses = sysModelCourseMapper.selectByExample(new SysModelCourseExample());
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserTypeEqualTo("1");
        List<User> users = userMapper.selectByExample(userExample);
        for (User user : users) {
            int i = RandomUtils.randomNumber(0, courses.size() - 1);

        }
    }

    @Test
    void connectTeacherCourse() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserTypeEqualTo("1");
        List<User> users = userMapper.selectByExample(userExample);

        List<SysModelCourse> courses = sysModelCourseMapper.selectByExample(new SysModelCourseExample());
        List<SysModelCourse> _courses = new ArrayList<>();
        for (SysModelCourse course : courses) {
            if (!course.getCode().equals("001")) {
                System.out.println(course.getName());
                _courses.add(course);
            }
        }
        courses = _courses;
        List<User> teachers = new ArrayList<User>();
        int flag = 0;
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 1; j <= 10; j++) {
                teachers.add(users.get(flag));
                flag++;
            }
        }

        for (User user :
                teachers) {

            System.out.println(user.getLoginCode());
        }

        List<ConnectTeacherCourse> connectTeacherCourseList = new ArrayList<>();
        ClassUtils<ConnectTeacherCourse> con = new ClassUtils<>();
        for (int j = 0; j < teachers.size(); j++) {

            ConnectTeacherCourse teacherCourse = new ConnectTeacherCourse();
            teacherCourse.setCode(UU3D.uu3d());
            teacherCourse.setCourseCode(courses.get(RandomUtils.randomNumber(0, courses.size() - 1))
                                                .getCode());
            teacherCourse.setTeacherCode(teachers.get(j).getCode());
            teacherCourse = con.addUserCreateUseInfo(teacherCourse, "20000000");
            connectTeacherCourseList.add(teacherCourse);
            connectTeacherCourseMapper.insert(teacherCourse);
        }
        System.out.println("结束");
    }
}
