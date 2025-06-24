package com.example.spring_boot.services;

import com.example.spring_boot.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student create(Student student);
    Student update(Long id, Student student);
    void delete(Long id);
}
