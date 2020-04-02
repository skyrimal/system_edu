package com.education.system_edu.service.impl;

import java.util.List;

import com.education.system_edu.mapper.*;
import com.education.system_edu.pojo.*;
import com.education.system_edu.pojo.insert.*;
import com.education.system_edu.pojo.output.*;
import com.education.system_edu.pojo.pojo.Major;
import com.education.system_edu.service.MajorService;
import com.education.system_edu.utils.*;
import com.education.system_edu.utils.value.ClassValue;
import com.education.system_edu.utils.value.Entry;
import com.education.system_edu.utils.value.UserValue;
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
    SysModelClassMapper sysModelClassMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    ConnectUserStudentAndClassMapper connectUserStudentAndClassMapper;
    @Resource
    SysModelCourseMapper sysModelCourseMapper;

    /**
     * 添加专业
     *
     * @param major
     * @param loginCode
     * @return
     */
    @Override
    public Integer addMajor(Major major, String loginCode) {
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

    /**
     * 查找部门下专业
     *
     * @param departmentCode
     * @return
     */
    @Override
    public List<OutputMajor> findMajorByDepartmentCode(String departmentCode) {
        SysDataTreeExample sysDataTreeExample = new SysDataTreeExample();
        sysDataTreeExample.createCriteria().andParentNodeEqualTo(departmentCode);
        List<OutputMajor> outputMajors = new ArrayList<>();
        for (SysDataTree sysDataTree : sysDataTreeMapper.selectByExample(sysDataTreeExample)) {
            OutputMajor outputMajor = new OutputMajor();
            outputMajor.setMajorCode(sysDataTree.getCode());
            outputMajor.setMajorName(sysDataTree.getName());
            outputMajors.add(outputMajor);
        }
        return outputMajors;
    }

    /**
     * 查找某年级下某专业的班级
     *
     * @param major
     * @param grade
     * @return
     */
    @Override
    public List<OutputClass> findClassByMajorCodeAndGrade(String major, String grade) {
        SysModelClassExample sysModelClassExample = new SysModelClassExample();
        sysModelClassExample.createCriteria().andTypeEqualTo((short) 2).andSysCollegeNodeCodeEqualTo(major).andGradeEqualTo(UserValue.PREFIX_CLASS_NO + grade);
        List<SysModelClass> sysModelClasses = sysModelClassMapper.selectByExample(sysModelClassExample);
        return OutPutEntryUtils.sysModelClassesToOutputClasses(sysModelClasses);
    }

    /**
     * 添加专业
     *
     * @param classInsert
     * @param loginCode
     * @return
     */
    @Override
    public List<ClassSearchOutput> addClass(ClassInsert classInsert, String loginCode) {
        ClassUtils<SysModelClass> classUtils = new ClassUtils<>();

        SysModelClass sysModelClass = new SysModelClass();
        sysModelClass.setCode(UU3D.uu3d());
        sysModelClass.setClassCode(classInsert.getClassClassCode());
        sysModelClass.setType(ClassValue.ADMINISTRATIVE_CLASS);
        sysModelClass.setTeacherType((short) 1);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginCodeEqualTo(classInsert.getTeacherName());
        User user = userMapper.selectByExample(userExample).get(0);
        sysModelClass.setTeacherCode(user.getCode());
        sysModelClass.setTeacherLoginCode(user.getLoginCode());
        sysModelClass.setGrade(UserValue.PREFIX_CLASS_NO + classInsert.getGrade());
        sysModelClass.setSysCollegeNodeCode(classInsert.getMajor());
        sysModelClass.setSysCollegeNodeType(Entry.MAJOR);
        sysModelClass = classUtils.addUserCreateUseInfo(sysModelClass, loginCode);
        sysModelClassMapper.insert(sysModelClass);
        return null;
    }

    /**
     * 通过输入信息查找班级
     * 结合了分页
     *
     * @param classSearchInsert
     * @return
     */
    @Override
    public List<ClassSearchOutput> searchClassByClassInsert(ClassSearchInsert classSearchInsert) {
        List<ClassSearchOutput> classSearchOutputs = sysModelClassMapper.selectByClassSearchInsert(classSearchInsert);

        ConnectUserStudentAndClassExample connectUserStudentAndClassExample;
        List<ClassSearchOutput> _ClassSearchOutputList = new ArrayList<>();
        for (ClassSearchOutput classSearchOutputToAddNumOfClassStudentAndTeacher :
                classSearchOutputs) {
            connectUserStudentAndClassExample = new ConnectUserStudentAndClassExample();
            connectUserStudentAndClassExample.createCriteria().andClassCodeEqualTo(classSearchOutputToAddNumOfClassStudentAndTeacher.getCode());
            classSearchOutputToAddNumOfClassStudentAndTeacher.setNumberOfClass((int) connectUserStudentAndClassMapper.countByExample(connectUserStudentAndClassExample));
            _ClassSearchOutputList.add(classSearchOutputToAddNumOfClassStudentAndTeacher);
        }
        return _ClassSearchOutputList;
    }

    /**
     * 通过输入信息获取查询数据集分页后页数
     *
     * @param classSearchInsert
     * @param pageSize
     * @return
     */
    @Override
    public Integer countPageByPageSizeAndClassSearchInsert(ClassSearchInsert classSearchInsert, Integer pageSize) {
        int i = sysModelClassMapper.countByClassSearchInsert(classSearchInsert);
        boolean flag = IntegerUtils.isExactlyDivisible(i, pageSize);
        if (flag) {
            return i / pageSize;
        } else {
            return i / pageSize + 1;
        }
    }

    /**
     * 添加课程
     *
     * @param courseAddInsert
     * @param loginCode
     * @return
     */
    @Override
    public Integer addCourse(CourseAddInsert courseAddInsert, String loginCode) {
        ClassUtils<SysModelCourse> sysModelCourseClassUtils = new ClassUtils<>();
        SysModelCourse sysModelCourse = new SysModelCourse();
        sysModelCourse = sysModelCourseClassUtils.addUserCreateUseInfo(sysModelCourse, loginCode);
        sysModelCourse.setCode(UU3D.uu3d());
        sysModelCourse.setCourseCode(courseAddInsert.getCourseCode());
        sysModelCourse.setName(courseAddInsert.getCourseName());
        sysModelCourse.setGrade("00");
        sysModelCourse.setHuors(courseAddInsert.getHours());
        sysModelCourse.setCredit(courseAddInsert.getCredit());
        sysModelCourse.setSysNodeType((short) (int) courseAddInsert.getCourseType());
        switch ((int) courseAddInsert.getCourseType()) {
            case 3:
                sysModelCourse.setSysNodeCode(courseAddInsert.getFaculty());
                return sysModelCourseMapper.insert(sysModelCourse);
            case 6:
                sysModelCourse.setSysNodeCode(courseAddInsert.getDepartment());
                return sysModelCourseMapper.insert(sysModelCourse);
            case 7:
                sysModelCourse.setSysNodeCode(courseAddInsert.getMajor());
                return sysModelCourseMapper.insert(sysModelCourse);
            default:
                return -1;
        }

    }

    /**
     * 结合分页查询课程
     *
     * @param courseSearchInsert
     * @return
     */
    @Override
    public List<CourseSearchOutput> searchCourseByCourseSearchInsert(CourseSearchInsert courseSearchInsert) {
        List<CourseSearchOutput> courseSearchOutputs = sysModelCourseMapper.selectCourseSearchOutputBycourseSearchInsert(courseSearchInsert);
        List<CourseSearchOutput> _courseSearchOutputs = new ArrayList<>();
        String str = "";
        for (CourseSearchOutput courseSearchOutput : courseSearchOutputs) {
            if (courseSearchOutput.getFacultyName() == null
                    && courseSearchOutput.getDepartmentName() != null) {
                courseSearchOutput.setFacultyName(courseSearchOutput.getDepartmentName());
                courseSearchOutput.setDepartmentName(courseSearchOutput.getMajorName());
                courseSearchOutput.setMajorName("--");
            }
            if (courseSearchOutput.getFacultyName() == null
                    && courseSearchOutput.getDepartmentName() == null) {
                courseSearchOutput.setFacultyName(courseSearchOutput.getMajorName());
                courseSearchOutput.setDepartmentName("--");
                courseSearchOutput.setMajorName("--");
            }
            _courseSearchOutputs.add(courseSearchOutput);
        }
        return _courseSearchOutputs;
    }

    @Override
    public List<CourseOutput> getAllCourse() {
        List<CourseOutput> courseSearchOutputs = new ArrayList<>();
        for (SysModelCourse course : sysModelCourseMapper.selectByExample(new SysModelCourseExample())) {
            if (!course.getCode().equals("001")) {
                CourseOutput courseSearchOutput = new CourseOutput();
                courseSearchOutput.setCode(course.getCode());
                courseSearchOutput.setName(course.getName());
                courseSearchOutput.setType(course.getSysNodeType() + "");
                courseSearchOutput.setParentCode(course.getSysNodeCode());
                courseSearchOutputs.add(courseSearchOutput);
            }
        }
        return courseSearchOutputs;
    }

    @Override
    public List<CourseOutput> chooseAllCourse(String faculty, String department, String major) {
        List<CourseOutput> courseOutputs = new ArrayList<>();
        if (!faculty.trim().equals("*")) {
            //获取学院、部门、专业下的课程
            if (department.trim().equals("*")) {
                //获取学院课程,当部门、专业为空时
                SysModelCourseExample sysModelCourseExample = new SysModelCourseExample();
                sysModelCourseExample.createCriteria()
                        .andSysNodeCodeEqualTo(faculty.replaceAll("\\*", ""))
                        .andSysNodeTypeEqualTo((short) 3);
                SysDataTreeExample sysDataTreeExample = new SysDataTreeExample();
                sysDataTreeExample.createCriteria().andParentNodeEqualTo(faculty.replaceAll("\\*", ""));

                for (SysDataTree dep : sysDataTreeMapper.selectByExample(sysDataTreeExample)) {
                    //获取学院下所有部门课程
                    SysModelCourseExample sysModelCourseExample1 = new SysModelCourseExample();
                    sysModelCourseExample1.createCriteria()
                            .andSysNodeCodeEqualTo(dep.getCode())
                            .andSysNodeTypeEqualTo((short) 6);

                    SysDataTreeExample sysDataTreeExample1 = new SysDataTreeExample();
                    sysDataTreeExample1.createCriteria().andParentNodeEqualTo(dep.getCode());


                    courseOutputs.addAll(outCourseOutput(sysModelCourseExample1));
                }
                courseOutputs.addAll(outCourseOutput(sysModelCourseExample));

            } else {
                //当部门不为空，获取部门、专业课程
                //获取部门课程
                SysModelCourseExample sysModelCourseExample = new SysModelCourseExample();
                sysModelCourseExample.createCriteria()
                        .andSysNodeCodeEqualTo(department.replaceAll("\\*", ""))
                        .andSysNodeTypeEqualTo((short) 6);
                SysDataTreeExample sysDataTreeExample = new SysDataTreeExample();
                sysDataTreeExample.createCriteria().andParentNodeEqualTo(department.replaceAll("\\*", ""));
                if (major.equals("*")) {
                } else {
                    //当专业不为空时
                    SysModelCourseExample sysModelCourseExample1 = new SysModelCourseExample();
                    sysModelCourseExample1.createCriteria()
                            .andSysNodeCodeEqualTo(major.replaceAll("\\*", ""))
                            .andSysNodeTypeEqualTo((short) 7);
                    courseOutputs.addAll(outCourseOutput(sysModelCourseExample1));
                }
                courseOutputs.addAll(outCourseOutput(sysModelCourseExample));

            }
        }
        return courseOutputs;
    }

    @Override
    public int addCourseClass(AddCourseClassInsert courseAddInsert, String loginUser_loginCode) {
        int flag = 0;
        String departmentCode = courseAddInsert.getDepartmentCode();
        String faculty = courseAddInsert.getFaculty();
        String major = courseAddInsert.getMajor();
        String grade = courseAddInsert.getGrade();
        String teacherCode = courseAddInsert.getTeacherCode();
        List<String> publicCourse = courseAddInsert.getPublicCourse();
        List<String> majorCourse = courseAddInsert.getMajorCourse();
        List<SysModelClass> courseClasses = new ArrayList<>();
        List<User> users = new ArrayList<>();
        //获取课程信息
        List<SysModelCourse> courses = new ArrayList<>();
        if (publicCourse != null) {
            for (int i = 0; i < publicCourse.size(); i++) {
                courses.add(sysModelCourseMapper.selectByCourseCode(publicCourse.get(i)));
            }
        }

        if (majorCourse != null) {
            for (int i = 0; i < majorCourse.size(); i++) {
                courses.add(sysModelCourseMapper.selectByCourseCode(majorCourse.get(i)));
            }
        }


        //获取要排课的学生
        //根据课程获取老师
        //生成课程班级
        //联系学生和班级
        //保存班级
        //保存学生与班级的联系


        //当学院为空时，不添加课程
        if (StringUtils.isEmpty(faculty)) {
            return 0;
        }

        //当部门为空时,给学院下所有学生添加课程班级
        if (StringUtils.isEmpty(departmentCode)) {

            //获取所有学院学生
            users = userMapper.selectStudentByFactoryCode(faculty);

            return insertCourseClasses(0, courses, grade, loginUser_loginCode, users);
        }

        //当专业为空时，给部门下学生添加所有课程
        if (StringUtils.isEmpty(major)) {
            users = userMapper.selectStudentByDepartmentCode(departmentCode);

            return insertCourseClasses(0, courses, grade, loginUser_loginCode, users);
        }
        //当都不为空时，给专业下学生添加课程
        users = userMapper.selectStudentByMajorCode(major);
        return insertCourseClasses(0, courses, grade, loginUser_loginCode, users);
    }

    @Override
    public List<TeacherCourseClassLineInfoOutput> getTeacherCourse(String loginCode) {
        List<TeacherCourseClassLineInfoOutput> courseOutputlist = sysModelCourseMapper.getTeacherCourse(loginCode);
        courseOutputlist.remove(0);
        return courseOutputlist;

    }


    /**
     * 通过输入信息获取查询课程分页后页数
     *
     * @param courseSearchInsert
     * @param pageSize
     * @return
     */
    @Override
    public Integer countCourseByCourseSearchInsert(CourseSearchInsert courseSearchInsert, Integer pageSize) {
        int i = sysModelCourseMapper.countCourseSearchOutputBycourseSearchInsert(courseSearchInsert);
        return PageUtils.coutPageSize(i, pageSize);
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

    private List<CourseOutput> outCourseOutput(SysModelCourseExample sysModelCourseExample) {
        List<CourseOutput> courseOutputs = new ArrayList<>();
        for (SysModelCourse course : sysModelCourseMapper.selectByExample(sysModelCourseExample)) {
            if (!course.getCode().equals("001")) {
                CourseOutput courseSearchOutput = new CourseOutput();
                courseSearchOutput.setCode(course.getCode());
                courseSearchOutput.setName(course.getName());
                courseSearchOutput.setType(course.getSysNodeType() + "");
                courseSearchOutput.setParentCode(course.getSysNodeCode());
                courseOutputs.add(courseSearchOutput);
            }
        }
        return courseOutputs;
    }


    //排课
    private int insertCourseClasses(int flag,
                                    List<SysModelCourse> courses,
                                    String grade,
                                    String loginUser_loginCode,
                                    List<User> users) {

        List<SysModelClass> newCourseClasses = new ArrayList<>();
        //老师与班级创建合并
        //获取所有授课老师
        List<User> teachers = new ArrayList<User>();
        int i = 0;
        for (SysModelCourse str : courses) {
            List<User> teacheres = userMapper.selectTeacherByCoueseCode(str.getCode());
            SysModelClass newCourseClass = null;
            for (User user : teacheres) {
                newCourseClass = ClassesUtils.madeCourseClass(grade, loginUser_loginCode, str, i++, user);
                newCourseClasses.add(newCourseClass);
            }
            teachers.addAll(teacheres);
        }

        //联系学生和班级
        List<ConnectUserStudentAndClass> connectUserStudentAndClassesList = new ArrayList<>();
        int stuNumber = 0;
        if (users.size() % newCourseClasses.size() > 0) {
            stuNumber = (users.size() / newCourseClasses.size()) + 1;
        } else {
            stuNumber = users.size() / newCourseClasses.size();
        }

        //x*stuNumber-(x+1)*stuNumber
        for (int x = 0; x < newCourseClasses.size(); x++) {
            int _stuNum = 0;
            for (int y = x * (stuNumber); y < (x + 1) * stuNumber; y++) {
                if (y < users.size()) {
                    ConnectUserStudentAndClass cUAC = new ConnectUserStudentAndClass();
                    cUAC.setCode(UU3D.uu3d());
                    cUAC.setClassCode(newCourseClasses.get(x).getCode());
                    cUAC.setStudentCode(users.get(y).getCode());
                    cUAC.setStudentNo(users.get(y).getLoginCode());
                    connectUserStudentAndClassesList.add(cUAC);
                    _stuNum++;
                }
            }
            newCourseClasses.get(x).setStudentNum(_stuNum);
        }
        for (SysModelClass sysModelClass :
                newCourseClasses) {
            sysModelClassMapper.insert(sysModelClass);
            flag++;
        }
        for (ConnectUserStudentAndClass cUAC :
                connectUserStudentAndClassesList) {
            connectUserStudentAndClassMapper.insert(cUAC);
            flag++;
        }
        return flag;
    }
}
