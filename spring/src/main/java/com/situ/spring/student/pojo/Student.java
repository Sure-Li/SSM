package com.situ.spring.student.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long rowId;
	private String stuName;
	private Integer stuAge;
	private Integer stuSex;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")//将表单中得到的字符串格式的数据转换为date数据
	private Date stuBirthday;
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public String getstuName() {
		return stuName;
	}
	public void setstuName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getStuAge() {
		return stuAge;
	}
	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}
	public Integer getStuSex() {
		return stuSex;
	}
	public void setStuSex(Integer stuSex) {
		this.stuSex = stuSex;
	}
	public Date getStuBirthday() {
		return stuBirthday;
	}
	public void setStuBirthday(Date stuBirthday) {
		this.stuBirthday = stuBirthday;
	}
	@Override
	public String toString() {
		return "Student [rowId=" + rowId + ", stuName=" + stuName + ", stuAge=" + stuAge + ", stuSex=" + stuSex
				+ ", stuBirthday=" + stuBirthday + "]";
	}
	
}
