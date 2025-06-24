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
    public Student update(Long id, Student newStudent) {
        Student student = getStudentById(id);

        if (newStudent.getName() != null) {
            student.setName(newStudent.getName());
        }

        if (newStudent.getEmail() != null) {
            student.setEmail(newStudent.getEmail());
        }
        return studentRepository.save(student);
    }

    private Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("STUDENT NOT FOUND"));
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
