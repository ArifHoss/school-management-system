package com.example.spring_boot.services;

import com.example.spring_boot.exception.ResourceNotFoundException;
import com.example.spring_boot.model.Student;
import com.example.spring_boot.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        Student foundStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("STUDENT NOT FOUND"));
        foundStudent.setName(student.getName());
        foundStudent.setEmail(student.getEmail());
        return studentRepository.save(foundStudent);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
