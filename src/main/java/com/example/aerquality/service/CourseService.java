package com.example.aerquality.service;

import com.example.aerquality.model.entity.CourseEntity;

import java.util.List;

public interface CourseService {

    List<CourseEntity> getAllCourses();

    CourseEntity getById(long id);

    void addCourse(String course);

    void initCourses();
}
