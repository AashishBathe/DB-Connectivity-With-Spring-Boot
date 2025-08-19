package com.aashish.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aashish.mongo.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>{
}
