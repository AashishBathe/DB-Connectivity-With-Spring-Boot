package com.aashish.redis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aashish.redis.model.Student;
import com.aashish.redis.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Student student) {
        service.save(student);
        return ResponseEntity.ok("Student saved in Redis");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable String id) {
        Student student = service.findById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateById(@PathVariable String id, @RequestBody Student student) {
        Student newStudent = service.updateById(id, student);
        if (newStudent == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        Student student = service.delete(id);
        if (student == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Deleted from Redis!");
    }
}

