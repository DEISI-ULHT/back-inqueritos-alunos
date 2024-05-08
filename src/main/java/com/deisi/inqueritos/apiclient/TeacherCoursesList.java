package com.deisi.inqueritos.apiclient;


import java.util.List;

public class TeacherCoursesList {
    private String year;
    private String semester;
    private List<TeacherCourses> data;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public List<TeacherCourses> getData() {
        return data;
    }

    public void setData(List<TeacherCourses> data) {
        this.data = data;
    }
}
