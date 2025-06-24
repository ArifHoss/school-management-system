package com.example.spring_boot.controller;

import com.example.spring_boot.model.Enrollment;
import com.example.spring_boot.services.EnrollmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentsService enrollmentsService;

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAll(){
        List<Enrollment> enrollments = enrollmentsService.getAll();
        return ResponseEntity.ok(enrollments);
    }

    @PostMapping
    public ResponseEntity<Enrollment> create(@RequestBody Enrollment enrollment){
        Enrollment created = enrollmentsService.create(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> update(@PathVariable Long id, @RequestBody Enrollment enrollment){
        Enrollment updated = enrollmentsService.update(id, enrollment);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        enrollmentsService.delete(id);
        return ResponseEntity.ok("ENROLLMENT REMOVED");
    }
}
