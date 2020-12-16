package com.situ.spring.student.dao;

import java.util.List;

import com.situ.spring.student.pojo.Student;

public interface StudentDao {
	Integer save(Student student);
	List<Student> findAll();
	Integer updateStudent(Student student);
	Integer delectStudent(String rowId);
	Integer checkCode();
}
