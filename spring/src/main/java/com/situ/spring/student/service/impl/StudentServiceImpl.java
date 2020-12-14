package com.situ.spring.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.spring.student.dao.StudentDao;
import com.situ.spring.student.pojo.Student;
import com.situ.spring.student.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	private static Long rowId = 0L;
	@Autowired
	private StudentDao studentDao;

	@Override
	public Integer saveStudent(Student Student) {
		Student.setRowId(rowId);
		studentDao.save(Student);
		rowId++;
		return null;
	}

	@Override
	public List<Student> findAllStudent() {
		return studentDao.findAll();
	}

	@Override
	public Integer updateStudent(Student Student) {
		return studentDao.updateStudent(Student);
	}

	@Override
	public Integer delectStudent(String rowId) {
		return studentDao.delectStudent(rowId);
	}

}
