package com.example.spring_boot.services;

import com.example.spring_boot.exception.ResourceNotFoundException;
import com.example.spring_boot.model.Course;
import com.example.spring_boot.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Long id, Course newCourse) {
        Course course = getCourse(id);
        course.setTitle(newCourse.getTitle());
        course.setDescription(newCourse.getDescription());
        return courseRepository.save(course);
    }


    @Override
    public void delete(Long id) {
        Course course = getCourse(id);
        courseRepository.delete(course);
    }

    private Course getCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("COURSE NOT FOUND WITH THIS ID: " + id));
    }
}
