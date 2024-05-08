package com.deisi.inqueritos.apiclient;


import java.util.List;

public class TeacherCourses {
    private String teacherId;
    private List<InnerTeacherCourse> courses;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public List<InnerTeacherCourse> getCourses() {
        return courses;
    }

    public void setCourses(List<InnerTeacherCourse> courses) {
        this.courses = courses;
    }
}
