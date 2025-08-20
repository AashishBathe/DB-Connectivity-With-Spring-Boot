package com.aashish.redis.service;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.logging.structured.CommonStructuredLogFormat;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.aashish.redis.model.Student;

@Service
public class StudentService {
	
	private final RedisTemplate<String, Object> redisTemplate;
	public StudentService(RedisTemplate<String, Object> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
	}
	
	private static final String PREFIX = "student:";
	
	public void save(Student student) {
		redisTemplate.opsForValue().set(PREFIX + student.getId(), student, 1, TimeUnit.HOURS);
	}
	
	public Student findById(String id) {
        return (Student) redisTemplate.opsForValue().get(PREFIX + id);
    }
	
	public Student delete(String id) {
		Student exist = (Student) redisTemplate.opsForValue().get(PREFIX + id);
		redisTemplate.delete(PREFIX + id);
		return exist;
	}
	
	public Student updateById(String id, Student student) {
		Student exist = (Student) redisTemplate.opsForValue().get(PREFIX + id);
		if (exist == null) return null;
		if (student.getName() != null) exist.setName(student.getName());
		if (student.getEmail() != null) exist.setEmail(student.getEmail());
		redisTemplate.opsForValue().set(PREFIX + id, exist, 1, TimeUnit.HOURS);
		return exist;
	}

}
