package com.situ.spring.student.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.spring.student.dao.StudentDao;
import com.situ.spring.student.pojo.Student;
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
private static List<Student> studentList = new ArrayList<Student>();
	@Override
	public Integer save(Student student) {
		studentList.add(student);
		return null;
	}

	@Override
	public List<Student> findAll() {
		return studentList;
	}

	@Override
	public Integer updateStudent(Student student) 
	{
//		System.out.println(student.getRowId());
		studentList.set(Integer.parseInt(student.getRowId().toString()), student);
		return null;
	}

	@Override
	public Integer delectStudent(String rowId) {
		studentList.set(Integer.parseInt(rowId), new Student());
		return null ;
	}

}
