package com.deisi.inqueritos.data;


public class TeacherEvaluation {
    private String teacherId;
    private int explanations;
    private int wellPrepared;
    private int availability;
    private int material;
    private int assessment;
    private int again;

    public TeacherEvaluation(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public int getExplanations() {
        return explanations;
    }

    public void setExplanations(int explanations) {
        this.explanations = explanations;
    }

    public int getWellPrepared() {
        return wellPrepared;
    }

    public void setWellPrepared(int wellPrepared) {
        this.wellPrepared = wellPrepared;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    public int getAgain() {
        return again;
    }

    public void setAgain(int again) {
        this.again = again;
    }
}
