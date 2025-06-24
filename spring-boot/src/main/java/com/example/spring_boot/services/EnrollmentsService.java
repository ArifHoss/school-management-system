package com.example.spring_boot.services;

import com.example.spring_boot.model.Course;
import com.example.spring_boot.model.Enrollment;

import java.util.List;

public interface EnrollmentsService {
    List<Enrollment> getAll();
    Enrollment create(Enrollment enrollment);
    Enrollment update(Long id, Enrollment enrollment);
    void delete(Long id);
}
