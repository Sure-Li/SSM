package com.situ.spring.student.service;

import java.util.List;

import com.situ.spring.student.pojo.Student;

public interface StudentService {
	Integer saveStudent(Student Student);
	Integer updateStudent(Student Student);
	List<Student> findAllStudent();
	Integer delectStudent(String rowId);
}
