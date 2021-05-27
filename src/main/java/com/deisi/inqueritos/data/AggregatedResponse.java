package com.deisi.inqueritos.data;


import java.util.Date;

public class AggregatedResponse {
    private String sessionId;
    private Date start;
    private Date end;
    private String programme;
    private int mood;
    private String likedMost;
    private String couldBeBetter;
    private int sync;
    private TeacherEvaluation theoreticalTeacher;
    private TeacherEvaluation practicalTeacher;

    public AggregatedResponse(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getProgramme() {
        return programme;
    }

    public int getMood() {
        return mood;
    }

    public String getLikedMost() {
        return likedMost;
    }

    public String getCouldBeBetter() {
        return couldBeBetter;
    }

    public int getSync() {
        return sync;
    }

    public TeacherEvaluation getTheoreticalTeacher() {
        return theoreticalTeacher;
    }

    public TeacherEvaluation getPracticalTeacher() {
        return practicalTeacher;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public void setLikedMost(String likedMost) {
        this.likedMost = likedMost;
    }

    public void setCouldBeBetter(String couldBeBetter) {
        this.couldBeBetter = couldBeBetter;
    }

    public void setSync(int sync) {
        this.sync = sync;
    }

    public void setTheoreticalTeacher(TeacherEvaluation theoreticalTeacher) {
        this.theoreticalTeacher = theoreticalTeacher;
    }

    public void setPracticalTeacher(TeacherEvaluation practicalTeacher) {
        this.practicalTeacher = practicalTeacher;
    }
}
