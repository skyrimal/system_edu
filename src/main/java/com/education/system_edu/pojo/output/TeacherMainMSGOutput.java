package com.education.system_edu.pojo.output;

import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月16日 9:50
 */
public class TeacherMainMSGOutput{
    private List<String> courseClassNames;
    private MainMSGOutput mainMSGOutput;

    public MainMSGOutput getMainMSGOutput() {
        return mainMSGOutput;
    }

    public void setMainMSGOutput(MainMSGOutput mainMSGOutput) {
        this.mainMSGOutput = mainMSGOutput;
    }

    public List<String> getCourseClassNames() {
        return courseClassNames;
    }

    public void setCourseClassNames(List<String> courseClassNames) {
        this.courseClassNames = courseClassNames;
    }
}
