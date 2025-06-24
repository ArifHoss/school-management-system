package com.example.spring_boot.services;

import com.example.spring_boot.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    Course create(Course course);
    Course update(Long id, Course course);
    void delete(Long id);
}
