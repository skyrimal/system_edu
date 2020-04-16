package com.education.system_edu.pojo.output;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月12日 11:00
 */
public class SignHistory {
    private String time;
    private String status;
    private String courseName;
    private String courseClassCode;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseClassCode() {
        return courseClassCode;
    }

    public void setCourseClassCode(String courseClassCode) {
        this.courseClassCode = courseClassCode;
    }
}
