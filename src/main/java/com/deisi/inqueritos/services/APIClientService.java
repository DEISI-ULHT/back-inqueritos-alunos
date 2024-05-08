package com.deisi.inqueritos.services;

import com.deisi.inqueritos.apiclient.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class APIClientService {

    public List<Course> fetchCourses(String year) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer your_token_here");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Courses> response = restTemplate.exchange(
                "https://dsdeisi.pythonanywhere.com/inqueritos-courses/" + year,
                HttpMethod.GET,
                entity,
                Courses.class
        );

        Courses courses = response.getBody();
        return courses.getCourses();
    }

    public List<Teacher> fetchTeachers(String year) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer your_token_here");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Teachers> response = restTemplate.exchange(
                "https://dsdeisi.pythonanywhere.com/inqueritos-teachers/" + year,
                HttpMethod.GET,
                entity,
                Teachers.class
        );

        Teachers teachers = response.getBody();
        return teachers.getTeachers();
    }

    public List<TeacherCourses> fetchTeachersCourse(String year, String semester) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer your_token_here");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<TeacherCoursesList> response = restTemplate.exchange(
                "https://dsdeisi.pythonanywhere.com/inqueritos-teacher-courses/" + year + "/" + semester,
                HttpMethod.GET,
                entity,
                TeacherCoursesList.class
        );

        TeacherCoursesList teachers = response.getBody();
        return teachers.getData();
    }
}
