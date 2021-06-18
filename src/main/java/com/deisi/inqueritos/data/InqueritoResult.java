package com.deisi.inqueritos.data;

import java.util.List;

public class InqueritoResult {

    private String courseId;
    private List<AggregatedResponse> responses;

    public InqueritoResult(String courseId, List<AggregatedResponse> responses) {
        this.courseId = courseId;
        this.responses = responses;
    }

    public String getCourseId() {
        return courseId;
    }

    public List<AggregatedResponse> getResponses() {
        return responses;
    }
}
