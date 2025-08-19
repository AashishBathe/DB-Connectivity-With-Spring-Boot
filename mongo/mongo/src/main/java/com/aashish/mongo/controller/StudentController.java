package com.aashish.mongo.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aashish.mongo.model.Student;
import com.aashish.mongo.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentRepository studentRepository;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@GetMapping
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable String id) {
		Student exist = studentRepository.findById(id).orElse(null);
		if (exist == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(exist);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable String id, @RequestBody Student student) {
		Student exist = studentRepository.findById(id).orElse(null);
		if (exist == null) return ResponseEntity.notFound().build();
		if (student.getEmail() != null) exist.setEmail(student.getEmail());
		if (student.getName() != null) exist.setName(student.getName());
		studentRepository.save(exist);
		return ResponseEntity.ok(exist);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable String id) {
		Student exist = studentRepository.findById(id).orElse(null);
		if (exist == null) return ResponseEntity.notFound().build();
		studentRepository.deleteById(id);
		return ResponseEntity.ok(exist);
	}
}
