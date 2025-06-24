package com.example.spring_boot.services;

import com.example.spring_boot.exception.ConflictException;
import com.example.spring_boot.exception.ResourceNotFoundException;
import com.example.spring_boot.model.Course;
import com.example.spring_boot.model.Enrollment;
import com.example.spring_boot.model.Student;
import com.example.spring_boot.repository.CourseRepository;
import com.example.spring_boot.repository.EnrollmentRepository;
import com.example.spring_boot.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentsService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<Enrollment> getAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment create(Enrollment enrollment) {
        long studentId = enrollment.getStudent().getId();
        long courseId = enrollment.getCourse().getId();
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("STUDENT NOT FOUND" + studentId));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("COURSE NOT FOUND WITH THIS ID: " + courseId));
        Optional<Enrollment> existing = enrollmentRepository.findByStudentIdAndCourseId(studentId, courseId);

        if (existing.isPresent()) {
            throw new ConflictException("EITHER STUDENT OR COURSE ENROLLED ALREADY!");
        }

        Enrollment newEnrollMent = new Enrollment();
        newEnrollMent.setStudent(student);
        newEnrollMent.setCourse(course);
        newEnrollMent.setEnrollmentDate(LocalDate.now());
        return enrollmentRepository.save(newEnrollMent);
    }

    @Override
    public Enrollment update(Long id, Enrollment newEnrollment) {
        Enrollment updated = getEnrollment(id);
        updated.setCourse(newEnrollment.getCourse());
        updated.setStudent(newEnrollment.getStudent());
        return enrollmentRepository.save(updated);
    }

    @Override
    public void delete(Long id) {
        Enrollment enrollment = getEnrollment(id);
        enrollmentRepository.delete(enrollment);
    }

    private Enrollment getEnrollment(Long id) {
        return enrollmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ENROLLMENT NOT FOUND"));
    }
}
